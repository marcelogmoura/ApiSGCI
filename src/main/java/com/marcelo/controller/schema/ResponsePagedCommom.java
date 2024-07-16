package com.marcelo.controller.schema;

import java.util.List;

public class ResponsePagedCommom<T> {

	private List<T> data;
	private Long totalRecords;
	private Integer totalPages;
	private Integer pageSize;
	
	
	
	public ResponsePagedCommom() {
	}
	public ResponsePagedCommom(List<T> data, Long totalRecords, Integer totalPages, Integer pageSize) {
		this.data = data;
		this.totalRecords = totalRecords;
		this.totalPages = totalPages;
		this.pageSize = pageSize;
		
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
	


	
}
