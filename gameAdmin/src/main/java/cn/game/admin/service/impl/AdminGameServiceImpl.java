package cn.game.admin.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.game.admin.service.AdminGameService;
import cn.game.core.entity.table.game.Game;
import cn.game.core.repository.game.GameRepository;
import cn.game.core.repository.redis.RedisRepository;
import cn.game.core.tools.Groups;
import cn.game.core.tools.Page;

@Service
public class AdminGameServiceImpl implements AdminGameService {
	@Autowired
	private GameRepository gameRepository;
	@Autowired
	private RedisRepository redisRepository;

	@Transactional
	public void saveGameRule(Game game) {
		gameRepository.persist(game);
	}

	@Transactional
	public void updateGameRule(Integer minNum) {

		Game game = gameRepository.find(1l);
		game.setPlayerNum(minNum);
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

	public String memoryPlayerNum() {
		String current_playerNumber = redisRepository.getString("current_playerNumber");
		if (current_playerNumber != null && !"".equals(current_playerNumber)) {
			return current_playerNumber;
		} else {
			return "0";
		}

	}

	@Override
	public Page<Game> loadRuleList(Groups g, int pageSize, int currentPage) {
		Page<Game> page = new Page<Game>(pageSize, currentPage);

		return gameRepository.findEntityPageByGroups(g, page);

	}

}
