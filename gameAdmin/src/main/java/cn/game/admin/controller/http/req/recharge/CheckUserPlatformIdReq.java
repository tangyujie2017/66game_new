package cn.game.admin.controller.http.req.recharge;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

public class CheckUserPlatformIdReq implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotEmpty
	private String userPlatformId;
	public String getUserPlatformId() {
		return userPlatformId;
	}
	public void setUserPlatformId(String userPlatformId) {
		this.userPlatformId = userPlatformId;
	}
	

}
