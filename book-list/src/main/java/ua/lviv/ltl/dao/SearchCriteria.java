package ua.lviv.ltl.dao;

import java.util.Map;

public class SearchCriteria<E extends Enum<E>>{
	
	public enum SortType{
		ASC, DESC
	}
	
	private boolean pagination = false;
	private int pageSize = 0;
	private Map<E, SortType> searchTypes;
	
	public Map<E, SortType> getSearchTypes() {
		return searchTypes;
	}
	public void setSearchTypes(Map<E, SortType> searchTypes) {
		this.searchTypes = searchTypes;
	}
	public boolean isPagination() {
		return pagination;
	}
	public void setPagination(boolean pagination) {
		this.pagination = pagination;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	

}
