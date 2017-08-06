package cn.game.admin.service;

import java.util.List;

import cn.game.core.entity.table.game.Game;
import cn.game.core.tools.Groups;
import cn.game.core.tools.Page;

public interface AdminGameService {
	public void saveGameRule(Game game);

	public void updateGameRule(Integer minNum);

	public boolean isExistGameRule();

	public List<Game> gameRuleLsit();
	
	
	public String memoryPlayerNum();
	
	public Page<Game>loadRuleList(Groups g,int pageSize,int currentPage);
}
