package cn.game.api.controller.resp.logic;

import java.util.List;

import cn.game.core.service.vo.GameResultVo;
import cn.game.core.service.vo.UserGameResultVo;

public class GameResultResp {
	
	private  GameResultVo  result;
	private UserGameResultVo self;

	private List<UserGameResultVo> winner;

	public UserGameResultVo getSelf() {
		return self;
	}

	public void setSelf(UserGameResultVo self) {
		this.self = self;
	}

	public List<UserGameResultVo> getWinner() {
		return winner;
	}

	public void setWinner(List<UserGameResultVo> winner) {
		this.winner = winner;
	}

	public GameResultVo getResult() {
		return result;
	}

	public void setResult(GameResultVo result) {
		this.result = result;
	}

	
}
