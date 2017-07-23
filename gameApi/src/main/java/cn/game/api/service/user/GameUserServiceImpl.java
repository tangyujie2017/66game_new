package cn.game.api.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.game.core.entity.table.play.Player;
import cn.game.core.repository.play.PlayerRepository;
@Service
public class GameUserServiceImpl implements GameUserService{
    @Autowired PlayerRepository playerRepository;
	@Override
	public Player loadPlayer(Long userId) {
		
		return playerRepository.find(userId);
	}

}
