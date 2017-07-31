package cn.game.api.service.task;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import cn.game.api.service.logic.GameLogicCenterService;
import cn.game.core.repository.play.PlayerRepository;
import cn.game.core.repository.redis.RedisRepository;
import cn.game.core.tools.Groups;

@Service
public class TashServiceImpl implements TaskService {
	@Resource
	private RedisRepository redisRepository;
	@Resource
	private GameLogicCenterService gameLogicCenterService;
	@Resource
	private PlayerRepository playerRepository;
	
	@Scheduled(fixedRate = 20000)
	private void generateBatchNo() {
		String current_batch = redisRepository.getString("current_batch");
		//执行上一次的结果
		if (current_batch != null && !current_batch.equals("")) {
			gameLogicCenterService.matcher(current_batch);
		}
		redisRepository.saveString("current_batch", createBatch());

	}

	private String createBatch() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	@Override
	public synchronized String playerPlatformId() {
		String playerPlatformId = redisRepository.getString("playerPlatformId");
		if(playerPlatformId!=null&&!playerPlatformId.equals("")){
			long id=Long.valueOf(playerPlatformId);
			//自增加1
			id++;
			redisRepository.saveString("playerPlatformId",String.valueOf(id));
			return playerPlatformId;
		}else{
			//
			Groups g = new Groups();
			String sql ="select max(user_platform_id) from player ";
			@SuppressWarnings("unchecked")
			List<MaxPlatformId>list=playerRepository.findByGroups(g,sql, MaxPlatformId.class);
			if(list==null||list.size()==0||list.get(0).getPlatformId()==null){
				long id=10000L;
				id++;
				redisRepository.saveString("playerPlatformId",String.valueOf(id));
				return "10000";
				
			}else{
				MaxPlatformId max=list.get(0);
				playerPlatformId=String.valueOf(max.getPlatformId()+1);
				redisRepository.saveString("playerPlatformId",String.valueOf(String.valueOf(max.getPlatformId()+2)));
				return playerPlatformId;
			}
			
		}
		
	}
 
}

class MaxPlatformId{
	
	private Long platformId;

	public Long getPlatformId() {
		return platformId;
	}

	public void setPlatformId(Long platformId) {
		this.platformId = platformId;
	}
	
}
