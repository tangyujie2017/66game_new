package cn.game.admin.controller.http.req.agency;

import java.io.Serializable;

public class LoadPlayerAgencyListReq implements Serializable {

	private static final long serialVersionUID = 1L;
	private int pageSize = 10;
	private int pageIndex = 1;

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

}
