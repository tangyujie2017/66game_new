package cn.game.admin.service;

import cn.game.core.entity.table.wallet.PlayerRecharge;
import cn.game.core.tools.Groups;
import cn.game.core.tools.Page;

public interface AdminRechargeService {
	public void manageApiRecharge(Long rechargeId, Integer status);

	public void manageAdminRecharge(PlayerRecharge recharge, String userPlatformId);

	Page<PlayerRecharge> loadPlayerRechargeList(Groups g, int pageSize, int currentPage);
}
