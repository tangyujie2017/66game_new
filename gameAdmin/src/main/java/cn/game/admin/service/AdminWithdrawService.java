package cn.game.admin.service;


import cn.game.core.entity.table.wallet.PlayerGiveScore;
import cn.game.core.entity.table.wallet.PlayerWithDraw;
import cn.game.core.tools.Groups;
import cn.game.core.tools.Page;

   //客户赠送给客服
public interface AdminWithdrawService {
     public void manageApiWithdraw(Long id,Integer status);
     public Page<PlayerGiveScore> loadPlayerWithDrawList(Groups g,int pageSize,int currentPage);
}
