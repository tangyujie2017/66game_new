package cn.game.admin.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.game.admin.exception.BizException;
import cn.game.admin.service.AdminRechargeService;
import cn.game.core.entity.table.play.Player;
import cn.game.core.entity.table.play.PlayerAccount;
import cn.game.core.entity.table.wallet.PlayerRecharge;
import cn.game.core.repository.play.PlayerAccountRepository;
import cn.game.core.repository.play.PlayerRepository;
import cn.game.core.repository.wallet.PlayerRechargeRepository;
import cn.game.core.tools.Groups;
import cn.game.core.tools.Page;

@Service
public class AdminRechargeServiceImpl implements AdminRechargeService {

	@Autowired
	private PlayerRechargeRepository playerRechargeRepository;
	@Autowired
	private PlayerAccountRepository playerAccountRepository;
	@Autowired
	private PlayerRepository playerRepository;

	@Override
	@Transactional
	public synchronized void manageApiRecharge(Long rechargeId, Integer status) {
		PlayerRecharge recharge = playerRechargeRepository.find(rechargeId);
		if (recharge.getOperateType().equals(1)) {
			if(status==2){
				//充值操作
				PlayerAccount account = recharge.getPlayer().getAccout();
				if (recharge.getRechargeSource().equals(1)) {
					account.setTotalGold(account.getTotalGold() + recharge.getRechargeScore());
					account.setHistoryPayRecord((account.getHistoryPayRecord() == null ? 0 : account.getHistoryPayRecord())
							+ recharge.getRechargeScore());
					playerAccountRepository.update(account);
					recharge.setOperateType(status);//
					playerRechargeRepository.update(recharge);
				} else {
					throw new BizException("此数据非手机客户端数据不能处理");

				}
			}else{
				//失效或过期操作
				recharge.setOperateType(status);
			}
			
		} else {
			throw new BizException("该数据已经处理");
		}
	}

	@Override
	@Transactional
	public void manageAdminRecharge(PlayerRecharge recharge, String userPlatformId) {
		Player player = playerRepository.findUniqueBy("userPlatformId", userPlatformId);
		if (player != null) {
			recharge.setCreateDate(new Date());
			recharge.setPlayer(player);
			recharge.setOperateType(2);
			recharge.setRechargeSource(2);
			PlayerAccount account = player.getAccout();
			account.setTotalGold(recharge.getRechargeScore() + account.getTotalGold());
			account.setHistoryPayRecord((account.getHistoryPayRecord() == null ? 0 : account.getHistoryPayRecord())
					+ recharge.getRechargeScore());
			playerRechargeRepository.persist(recharge);
			playerAccountRepository.update(account);
		} else {
			throw new BizException("没有找到玩家");
		}

	}
	
	public Player loadPlayerByUserPlatformId(String userPlatformId){
		Player player = playerRepository.findUniqueBy("userPlatformId", userPlatformId);
		return player;
	}

	@Override
	public Page<PlayerRecharge> loadPlayerRechargeList(Groups g, int pageSize, int currentPage) {

		Page<PlayerRecharge> page = new Page<>(pageSize, currentPage);

		return playerRechargeRepository.findEntityPageByGroups(g, page);
	}

}
