package cn.game.api.controller.req.user;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class LoadUserReq implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	@NotNull
	private Long userId;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
}
