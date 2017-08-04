package cn.game.admin.service;

import java.util.List;

import cn.game.core.entity.table.game.Game;

public interface AdminGameService {
	public void saveGameRule(Game game);

	public void updateGameRule(Game game);

	public boolean isExistGameRule();

	public List<Game> gameRuleLsit();
}
