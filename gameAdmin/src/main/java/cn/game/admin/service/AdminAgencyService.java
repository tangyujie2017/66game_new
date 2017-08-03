package cn.game.admin.service;



import cn.game.core.entity.table.play.PlayerAgency;
import cn.game.core.tools.Groups;
import cn.game.core.tools.Page;

public interface AdminAgencyService {
 public void saveAgency(PlayerAgency agency) ;
 public Page<PlayerAgency> loadPlayerAgencyList(Groups g,int pageSize,int currentPage);
 public boolean checkAgencyName(String agencyName);
}
