package cn.game.admin.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.game.core.entity.table.play.Player;
import cn.game.core.entity.table.wallet.PlayerGiveScore;

public class PlayerGiveScoreVo {


	
	private Long id;
	
	private PlayerVo benefactor;
	
	private PlayerVo receiver;
	

	private String  crateTime;
	
	
	private Long score;
	
	private Integer status;//1未处理，2已处理，3拒绝
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public PlayerVo getBenefactor() {
		return benefactor;
	}
	public void setBenefactor(PlayerVo benefactor) {
		this.benefactor = benefactor;
	}
	public PlayerVo getReceiver() {
		return receiver;
	}
	public void setReceiver(PlayerVo receiver) {
		this.receiver = receiver;
	}
	public Long getScore() {
		return score;
	}
	public void setScore(Long score) {
		this.score = score;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getCrateTime() {
		return crateTime;
	}
	public void setCrateTime(String crateTime) {
		this.crateTime = crateTime;
	}
	
	
	public static PlayerGiveScoreVo convertVo(PlayerGiveScore playerGiveScore){
		PlayerGiveScoreVo vo=new PlayerGiveScoreVo();
		vo.setBenefactor(PlayerVo.playerToVo(playerGiveScore.getBenefactor()));
		vo.setCrateTime(GameAdminUtils.dateToStr(playerGiveScore.getCrateTime()));
		vo.setId(playerGiveScore.getId());
		vo.setReceiver(PlayerVo.playerToVo(playerGiveScore.getReceiver()));
		vo.setScore(playerGiveScore.getScore());
		vo.setStatus(playerGiveScore.getStatus());
		return vo;
		
		
	}

	public static List<PlayerGiveScoreVo> convertToListVo(List<PlayerGiveScore> list){
		List<PlayerGiveScoreVo> listVo=new ArrayList<>();
		if(list!=null){
			for(PlayerGiveScore playerGiveScore:list){
				PlayerGiveScoreVo vo=new PlayerGiveScoreVo();
				vo.setBenefactor(PlayerVo.playerToVo(playerGiveScore.getBenefactor()));
				vo.setCrateTime(GameAdminUtils.dateToStr(playerGiveScore.getCrateTime()));
				vo.setId(playerGiveScore.getId());
				vo.setReceiver(PlayerVo.playerToVo(playerGiveScore.getReceiver()));
				vo.setScore(playerGiveScore.getScore());
				vo.setStatus(playerGiveScore.getStatus());
				listVo.add(vo);
			}
		}
		
		return listVo;
		
		
	}

}
