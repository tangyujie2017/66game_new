package cn.game.api.service.wallet;

import java.math.BigDecimal;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.game.core.entity.table.play.Player;
import cn.game.core.entity.table.wallet.PlayerRecharge;
import cn.game.core.repository.wallet.PlayerRechargeRepository;

@Service
public class GameWalletServiceImpl implements GameWalletService {
	@Autowired
	private PlayerRechargeRepository playerRechargeRepository;

	@Override
	@Transactional
	public boolean recharge(Long userid, BigDecimal money) {
		PlayerRecharge recharge = new PlayerRecharge();
		recharge.setCreateDate(new Date());
		recharge.setOperateType(1);
		recharge.setRechargeAmount(money.longValue());
		recharge.setRechargeScore(money.longValue() * 100);
		recharge.setRechargeSource(1);
		Player player = new Player();
		player.setUserId(userid);
		recharge.setPlayer(player);
		playerRechargeRepository.persist(recharge);
		if (recharge.getId() != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean giveAway(Long giveAwayUserid, Long receptor, Long score) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void rechargeLog() {
		// TODO Auto-generated method stub

	}

	@Override
	public void giveAwayLog() {
		// TODO Auto-generated method stub

	}

}
