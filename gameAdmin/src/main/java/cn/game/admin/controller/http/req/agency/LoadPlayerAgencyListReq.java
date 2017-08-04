package cn.game.admin.controller.http.req.agency;

import java.io.Serializable;

public class LoadPlayerAgencyListReq implements Serializable {

	private static final long serialVersionUID = 1L;
	private String agencyName;
	private String agencyCode;

	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	public String getAgencyCode() {
		return agencyCode;
	}

	public void setAgencyCode(String agencyCode) {
		this.agencyCode = agencyCode;
	}

}
