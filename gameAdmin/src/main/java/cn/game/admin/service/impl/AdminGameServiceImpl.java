package cn.game.admin.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.game.admin.service.AdminGameService;
import cn.game.core.entity.table.game.Game;
import cn.game.core.repository.game.GameRepository;
import cn.game.core.tools.Groups;

@Service
public class AdminGameServiceImpl implements AdminGameService {
	@Autowired
	private GameRepository gameRepository;
   @Transactional
	public void saveGameRule(Game game) {
		gameRepository.persist(game);
	}
   @Transactional
	public void updateGameRule(Game game) {
		gameRepository.update(game);
	}

	public boolean isExistGameRule() {
		Groups g = new Groups();
		List<Game> gameRules = gameRepository.findEntityByGroups(g);
		if (gameRules != null) {
			if (gameRules.size() > 0) {
				return true;
			} else {
				return false;
			}

		} else {
			return false;
		}
	}

	public List<Game> gameRuleLsit() {
		Groups g = new Groups();
		List<Game> gameRules = gameRepository.findEntityByGroups(g);
		return gameRules;
	}

}
