package cn.game.admin.controller.http.req.recharge;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class ManageAdminRechargeReq implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull
	private  Long rechargeAmount;
	@NotNull
	private  Long rechargeScore;
	@NotEmpty
	private String userPlatformId;
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
	public String getUserPlatformId() {
		return userPlatformId;
	}
	public void setUserPlatformId(String userPlatformId) {
		this.userPlatformId = userPlatformId;
	}
	

}
