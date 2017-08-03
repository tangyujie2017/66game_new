package cn.game.admin.service.impl;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.game.admin.service.AdminAgencyService;
import cn.game.core.entity.table.play.PlayerAgency;
import cn.game.core.repository.play.PlayerAgencyRepository;
import cn.game.core.tools.Groups;
import cn.game.core.tools.Page;

@Service
public class AdminAgencyServiceImpl implements AdminAgencyService {
	@Autowired
	private PlayerAgencyRepository playerAgencyRepository;

	@Override
	@Transactional
	public void saveAgency(PlayerAgency agency) {
		playerAgencyRepository.persist(agency);

	}

	@Override
	public Page<PlayerAgency> loadPlayerAgencyList(Groups g, int pageSize, int currentPage) {

		Page<PlayerAgency> page = new Page<PlayerAgency>(pageSize, currentPage);

		return playerAgencyRepository.findEntityPageByGroups(g, page);
	}

	@Override
	public boolean checkAgencyName(String agencyName) {
		Groups g = new Groups();
		g.Add("agencyName", agencyName);
		List<PlayerAgency> list = playerAgencyRepository.findEntityByGroups(g);
		if (list != null && list.size() > 1) {
			return false;
		} else {
			return true;
		}

	}

}
