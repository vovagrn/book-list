package ua.lviv.ltl.dao;

import java.util.ArrayList;
import java.util.List;
import ua.lviv.ltl.dao.impl.SearchEntry;

public class SearchFilter<T extends SearchType> {

	public enum SortOrder {
		ASC, DESC
	}

	private boolean pagination = false;
	private int firstResult = 0;
	private int pageSize = 0;
	private T sortBy;
	private SortOrder sortOrder;
	private List<SearchEntry<T>> searcEntrys = new ArrayList<>();

	public SearchFilter() {
		super();
	}

	public SearchFilter(int firstResult, int pageSize) {
		super();
		this.pagination = true;
		this.firstResult = firstResult;
		this.pageSize = pageSize;
	}

	public void addAllSearchEntrys(List<SearchEntry<T>> searchEntrys) {
		this.searcEntrys.addAll(searchEntrys);
	}

	public void addSearchEntry(SearchEntry<T> searchEntry) {
		searcEntrys.add(searchEntry);
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

	public int getFirstResult() {
		return firstResult;
	}

	public void setFirstResult(int firstResult) {
		this.firstResult = firstResult;
	}

	public T getSortBy() {
		return sortBy;
	}

	public void setSortBy(T searchBy) {
		this.sortBy = searchBy;
	}

	public SortOrder getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(SortOrder sortOrder) {
		this.sortOrder = sortOrder;
	}

	public List<SearchEntry<T>> getSearcEntrys() {
		return searcEntrys;
	}
	
	

}
