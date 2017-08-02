package cn.game.admin.service;

import java.util.List;

import cn.game.core.entity.table.wallet.PlayerWithDraw;

   //客户赠送给客服
public interface AdminWithdrawService {
     public void manageApiWithdraw(Long id);
     public void manageAdminWithdraw(PlayerWithDraw playerWithDraw);
     public List<PlayerWithDraw>loadPlayerWithDrawList();
}
