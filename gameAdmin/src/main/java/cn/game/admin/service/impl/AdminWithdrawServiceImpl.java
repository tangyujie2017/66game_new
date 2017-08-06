package cn.game.admin.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.game.admin.exception.BizException;
import cn.game.admin.service.AdminWithdrawService;
import cn.game.core.entity.table.play.PlayerAccount;
import cn.game.core.entity.table.wallet.PlayerGiveScore;
import cn.game.core.entity.table.wallet.PlayerWithDraw;
import cn.game.core.repository.play.PlayerAccountRepository;
import cn.game.core.repository.play.PlayerRepository;
import cn.game.core.repository.wallet.PlayerGiveScoreRepository;
import cn.game.core.tools.Groups;
import cn.game.core.tools.Page;

@Service
public class AdminWithdrawServiceImpl implements AdminWithdrawService {
	@Autowired
	private PlayerGiveScoreRepository playerGiveScoreRepository;
	@Autowired
	private PlayerAccountRepository playerAccountRepository;
	@Autowired
	private PlayerRepository playerRepository;

	@Override
	@Transactional
	public void manageApiWithdraw(Long id, Integer status) {
		PlayerGiveScore playerGiveScore = playerGiveScoreRepository.find(id);
		if (playerGiveScore != null) {
			if (playerGiveScore.getStatus().equals(1)) {
				if (status.equals(2)) {
					// 表示客户已经转账给玩家
					playerGiveScore.setStatus(status);
					playerGiveScoreRepository.update(playerGiveScore);
				} else {// 客户已经拒绝(回退玩家金币)
					PlayerAccount account = playerGiveScore.getReceiver().getAccout();
					account.setTotalGold(account.getTotalGold() + playerGiveScore.getScore());
					playerAccountRepository.update(account);
					playerGiveScore.setStatus(status);
					playerGiveScoreRepository.update(playerGiveScore);
				}
			} else {
				throw new BizException("数据已经处理了");

			}

		} else {
			throw new BizException("没有找到出金记录");
		}

	}

	public Page<PlayerGiveScore> loadPlayerWithDrawList(Groups g, int pageSize, int currentPage) {
		Page<PlayerGiveScore> page = new Page<PlayerGiveScore>(pageSize, currentPage);
		return playerGiveScoreRepository.findEntityPageByGroups(g, page);
	}

}
