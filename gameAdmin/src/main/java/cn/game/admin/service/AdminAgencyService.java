package cn.game.admin.service;

import java.util.List;

import cn.game.core.entity.table.play.PlayerAgency;

public interface AdminAgencyService {
 public void saveAgency(PlayerAgency agency) ;
 public List<PlayerAgency> loadPlayerAgencyList();
}
