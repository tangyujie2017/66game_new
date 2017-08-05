package cn.game.admin.controller.http.req.agency;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

public class CheckPlayerAgencyReq implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotEmpty
	private String agencyName;

	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

}
