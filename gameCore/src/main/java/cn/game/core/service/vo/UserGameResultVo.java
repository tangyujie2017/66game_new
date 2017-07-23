package cn.game.core.service.vo;

import java.util.List;


import cn.game.core.entity.table.play.UserGameResult;

public class UserGameResultVo {

	private Long id;

	private PlayerSimpleVo player;

	private List<ResultAnimalVo> details;
	
	private Integer originalScore;
	
	
	private Integer resultScore;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PlayerSimpleVo getPlayer() {
		return player;
	}

	public void setPlayer(PlayerSimpleVo player) {
		this.player = player;
	}

	public List<ResultAnimalVo> getDetails() {
		return details;
	}

	public void setDetails(List<ResultAnimalVo> details) {
		this.details = details;
	}

	
	public Integer getOriginalScore() {
		return originalScore;
	}

	public void setOriginalScore(Integer originalScore) {
		this.originalScore = originalScore;
	}

	public Integer getResultScore() {
		return resultScore;
	}

	public void setResultScore(Integer resultScore) {
		this.resultScore = resultScore;
	}

	public static UserGameResultVo userGameResultToVo(UserGameResult result) {
		UserGameResultVo vo = new UserGameResultVo();
		vo.setId(result.getId());
		vo.setOriginalScore(result.getOriginalScore());
		vo.setResultScore(result.getResultScore());
		vo.setPlayer(PlayerSimpleVo.playerToSimpleVo(result.getPlayer()));
		vo.setDetails(ResultAnimalVo.toListVo(result.getDetails()));

		return vo;

	}

}
