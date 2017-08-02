package cn.game.admin.service;

import java.util.List;

import cn.game.core.entity.table.wallet.PlayerRecharge;

public interface AdminRechargeService {
	public void manageApiRecharge(Long rechargeId,Integer status);

	public void manageAdminRecharge(PlayerRecharge recharge,String userPlatformId);

	public List<PlayerRecharge> loadPlayerRechargeList();
}
