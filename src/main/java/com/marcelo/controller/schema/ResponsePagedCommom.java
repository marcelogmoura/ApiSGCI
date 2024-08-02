package com.marcelo.controller.schema;

import java.util.List;

public class ResponsePagedCommom<T> {

	private List<T> data;
	private Long totalRecords;
	private Integer totalPages;
	private Integer pageSize;
	private Integer page;
			
	
	public ResponsePagedCommom(List<T> data, Long totalRecords, Integer totalPages, Integer pageSize, Integer page) {
		super();
		this.data = data;
		this.totalRecords = totalRecords;
		this.totalPages = totalPages;
		this.pageSize = pageSize;
		this.page = page;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public Long getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(Long totalRecords) {
		this.totalRecords = totalRecords;
	}
	public Integer getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	
	
	


	
}
