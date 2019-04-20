package com.beerus.utils;

import java.util.List;

/**
 * 
 * @author J.z
 *  控制分页类
 * @param <T>
 */
public class Page<T> {
	/**
	 * 当前页码
	 */
	private int currPageNo;
	/**
	 * 总页数
	 */
	private int totalPage;
	/**
	 * 页数大小
	 */
	private int pageSize;
	/**
	 * 数据总行数
	 */
	private int totalCount;
	/**
	 * 数据集合
	 */
	private List<T> pages;

	public int getCurrPageNo() {
		return currPageNo;
	}

	public void setCurrPageNo(int currPageNo) {
		this.currPageNo = currPageNo;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List<T> getPages() {
		return pages;
	}

	public void setPages(List<T> pages) {
		this.pages = pages;
	}

}
