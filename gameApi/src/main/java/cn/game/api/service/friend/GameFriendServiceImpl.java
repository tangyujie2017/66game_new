package cn.game.api.service.friend;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.game.api.config.Config.Values;
import cn.game.api.exception.BizException;
import cn.game.core.entity.table.play.Player;
import cn.game.core.entity.table.play.PlayerAccount;
import cn.game.core.entity.table.wallet.PlayerGiveScore;
import cn.game.core.repository.play.PlayerAccountRepository;
import cn.game.core.repository.play.PlayerRepository;
import cn.game.core.repository.wallet.PlayerGiveScoreRepository;

@Service
public class GameFriendServiceImpl implements GameFriendService {
	@Autowired
	private PlayerRepository playerRepository;
	@Autowired
	private PlayerAccountRepository playerAccountRepository;
	@Autowired
	PlayerGiveScoreRepository playerGiveScoreRepository;
	@Autowired
	private Values values;

	@Override
	@Transactional
	public void sendScoreToFriend(Long sendUserId, Long receiverUserId, Long score) {
		  
		
		 if(score>=10000&&(score%100==0)){
			 Player receiver = playerRepository.find(receiverUserId);
				Player sender = playerRepository.find(sendUserId);
				if (receiver.getUserPlatformId().equals(String.valueOf(values.getGameServiceNumber()))) {
					// 像客服赠送
					PlayerGiveScore saveData = new PlayerGiveScore();
					saveData.setBenefactor(sender);
					saveData.setReceiver(receiver);
					saveData.setScore(score);
					saveData.setCrateTime(new Date());
					saveData.setStatus(1);
					PlayerAccount senderAcc = sender.getAccout();
					playerGiveScoreRepository.persist(saveData);
					if (senderAcc.getTotalGold() - score >= 0) {
						senderAcc.setTotalGold(senderAcc.getTotalGold() - score);
					} else {
						throw new BizException("你的金币不够赠送给朋友");
					}

					playerAccountRepository.update(senderAcc);
				} else {
					// 向普通朋友赠送
					PlayerAccount senderAcc = sender.getAccout();
					PlayerAccount receiveAcc = receiver.getAccout();
					PlayerGiveScore saveData = new PlayerGiveScore();
					saveData.setBenefactor(sender);
					saveData.setReceiver(receiver);
					saveData.setScore(score);
					saveData.setStatus(2);
					saveData.setCrateTime(new Date());
					playerGiveScoreRepository.persist(saveData);

					if (senderAcc.getTotalGold() - score >= 0) {
						senderAcc.setTotalGold(senderAcc.getTotalGold() - score);
					} else {
						throw new BizException("你的金币不够赠送给朋友");
					}
					playerAccountRepository.update(senderAcc);
					receiveAcc.setTotalGold(receiveAcc.getTotalGold() + score);
					playerAccountRepository.update(receiveAcc);
				} 
		 }else{
			 throw new BizException("赠送数字不符合规则"); 
		 }
		

	}

}
