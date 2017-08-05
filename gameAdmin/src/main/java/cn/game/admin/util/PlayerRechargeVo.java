package cn.game.admin.util;

import java.util.ArrayList;
import java.util.List;



import cn.game.core.entity.table.wallet.PlayerRecharge;

public class PlayerRechargeVo {

	/**
	 * 
	 */

	private Long id;

	private PlayerVo player;

	private String createDate;

	private Long rechargeAmount;

	private Long rechargeScore;

	private Integer rechargeSource;// 1：api手机端，2后台管理充值 3其他

	private Integer operateType;// 1新建，2完成，3无效，4过期

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PlayerVo getPlayer() {
		return player;
	}

	public void setPlayer(PlayerVo player) {
		this.player = player;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public Long getRechargeAmount() {
		return rechargeAmount;
	}

	public void setRechargeAmount(Long rechargeAmount) {
		this.rechargeAmount = rechargeAmount;
	}

	public Long getRechargeScore() {
		return rechargeScore;
	}

	public void setRechargeScore(Long rechargeScore) {
		this.rechargeScore = rechargeScore;
	}

	public Integer getRechargeSource() {
		return rechargeSource;
	}

	public void setRechargeSource(Integer rechargeSource) {
		this.rechargeSource = rechargeSource;
	}

	public Integer getOperateType() {
		return operateType;
	}

	public void setOperateType(Integer operateType) {
		this.operateType = operateType;
	}

	public static PlayerRechargeVo convertToVo(PlayerRecharge recharge) {
		PlayerRechargeVo vo = new PlayerRechargeVo();
		vo.setCreateDate(GameAdminUtils.dateToStr(recharge.getCreateDate()));
		vo.setId(recharge.getId());
		vo.setOperateType(recharge.getOperateType());
		vo.setPlayer(PlayerVo.playerToVo(recharge.getPlayer()));
		vo.setRechargeAmount(recharge.getRechargeAmount());
		vo.setRechargeScore(recharge.getRechargeScore());
		vo.setRechargeSource(recharge.getRechargeSource());
		return vo;
	}

	public static List<PlayerRechargeVo> convertToListVo(List<PlayerRecharge> list) {
		List<PlayerRechargeVo> volist = new ArrayList<PlayerRechargeVo>();
		if (list != null) {
			for (PlayerRecharge recharge : list) {
				PlayerRechargeVo vo = new PlayerRechargeVo();
				vo.setCreateDate(GameAdminUtils.dateToStr(recharge.getCreateDate()));
				vo.setId(recharge.getId());
				vo.setOperateType(recharge.getOperateType());
				vo.setPlayer(PlayerVo.playerToVo(recharge.getPlayer()));
				vo.setRechargeAmount(recharge.getRechargeAmount());
				vo.setRechargeScore(recharge.getRechargeScore());
				vo.setRechargeSource(recharge.getRechargeSource());
				volist.add(vo);
			}
		}

		return volist;
	}

}
