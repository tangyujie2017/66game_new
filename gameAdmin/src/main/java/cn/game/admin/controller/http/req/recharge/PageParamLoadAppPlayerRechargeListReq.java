package cn.game.admin.controller.http.req.recharge;



public class PageParamLoadAppPlayerRechargeListReq {
	private int pageSize=10;
	private int pageIndex=1;
	
	private String userPlatformId;
	private String wxNickname;
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
	public String getUserPlatformId() {
		return userPlatformId;
	}
	public void setUserPlatformId(String userPlatformId) {
		this.userPlatformId = userPlatformId;
	}
	public String getWxNickname() {
		return wxNickname;
	}
	public void setWxNickname(String wxNickname) {
		this.wxNickname = wxNickname;
	}
	

	

}
