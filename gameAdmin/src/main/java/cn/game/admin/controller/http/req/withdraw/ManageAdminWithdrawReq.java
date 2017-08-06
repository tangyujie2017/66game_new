package cn.game.admin.controller.http.req.withdraw;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class ManageAdminWithdrawReq implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull
	private  Long withDrawId;
	@NotNull
	private Integer status;
	public Long getWithDrawId() {
		return withDrawId;
	}
	public void setWithDrawId(Long withDrawId) {
		this.withDrawId = withDrawId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
