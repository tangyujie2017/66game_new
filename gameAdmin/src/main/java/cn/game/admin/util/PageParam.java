package cn.game.admin.util;

public class PageParam <T>{
	private int pageSize=10;
	private int pageIndex=1;
	private T search;

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

	public T getSearch() {
		return search;
	}

	public void setSearch(T search) {
		this.search = search;
	}

	

}
