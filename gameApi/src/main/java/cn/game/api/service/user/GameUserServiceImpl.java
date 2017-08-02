package cn.game.api.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.game.api.config.Config.Values;
import cn.game.core.entity.table.play.Player;
import cn.game.core.repository.play.PlayerRepository;
@Service
public class GameUserServiceImpl implements GameUserService{
    @Autowired PlayerRepository playerRepository;
    @Autowired
    private   Values values;
	@Override
	public Player loadPlayer(Long userId) {
		
		return playerRepository.find(userId);
	}
	@Override
	public Player loadFriends(Long userId) {
		return playerRepository.find(userId);
	
	}
	@Override
	public Player loadGameServiceNumber() {
		Long service=values.getGameServiceNumber();
		Player servicePlayer= playerRepository.findUniqueBy("userPlatformId", String.valueOf(service));
		return servicePlayer;
	}

}
