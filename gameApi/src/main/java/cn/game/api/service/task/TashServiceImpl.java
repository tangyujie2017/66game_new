package cn.game.api.service.task;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import cn.game.api.config.Config.Values;
import cn.game.api.service.arithmetic.Animal;
import cn.game.api.service.arithmetic.AnimalConstant;
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
    @Autowired
    private  Values values;
	@Scheduled(fixedRate = 5000)
	private void generateBatchNo() {
		String current_batch = redisRepository.getString("current_batch");
		Map<String, Map<Long, List<Animal>>> container = AnimalConstant.Data_Container;
		if(container.get(current_batch)!=null&&container.get(current_batch).keySet().size()>=values.getGameStartNumber()){
			// 执行上一次的结果
			if (current_batch != null && !current_batch.equals("")) {
				gameLogicCenterService.matcher(current_batch);
			}
			redisRepository.saveString("current_batch", createBatch());
			
		}else{
			//什么也不执行
			if(container.get(current_batch)==null){
			//System.out.println("当前游戏没有客户玩游戏");
			}else{
				
				//System.out.println("当前游戏人数："+container.get(current_batch).keySet().size()+"小于系统配置："+values.getGameStartNumber());
				
			}
			
		}
		

	}

	private String createBatch() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	@Override
	public synchronized String playerPlatformId() {

		//
		Groups g = new Groups();
		String sql = "select max(user_platform_id) as platformId  from player ";
		@SuppressWarnings("unchecked")
		List<MaxPlatformId> list = playerRepository.findByGroups(g, sql, MaxPlatformId.class);
		if (list == null || list.size() == 0 || list.get(0).getPlatformId() == null) {
			return "10000";

		} else {
			MaxPlatformId max = list.get(0);
			String playerPlatformId = String.valueOf(max.getPlatformId() + 1);
			return playerPlatformId;
		}

	}

}

class MaxPlatformId {

	private Long platformId;

	public Long getPlatformId() {
		return platformId;
	}

	public void setPlatformId(Long platformId) {
		this.platformId = platformId;
	}

}
