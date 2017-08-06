package cn.game.admin.controller.http.req.game;

public class LoadRuleListReq {
	private int pageSize=10;
	private int pageIndex=1;
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
