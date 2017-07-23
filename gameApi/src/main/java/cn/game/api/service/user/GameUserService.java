package cn.game.api.service.user;

import cn.game.core.entity.table.play.Player;

public interface GameUserService {
	public Player loadPlayer(Long userId);

}
