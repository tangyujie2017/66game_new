package cn.game.admin.controller.http.req.game;

import java.io.Serializable;

public class UpdateRuleReq implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	private Integer minNum;

	public Integer getMinNum() {
		return minNum;
	}

	public void setMinNum(Integer minNum) {
		this.minNum = minNum;
	}

}
