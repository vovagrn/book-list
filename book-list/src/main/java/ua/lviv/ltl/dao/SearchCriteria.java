package ua.lviv.ltl.dao;

import java.util.ArrayList;
import java.util.List;
import ua.lviv.ltl.dao.impl.SearchEntry;

public class SearchCriteria<E extends SearchType> {

	public enum SortOrder {
		ASC, DESC
	}

	private boolean pagination = false;
	private int firstResult = 0;
	private int pageSize = 0;
	private E sortBy;
	private SortOrder sortOrder;
	private List<SearchEntry<E>> searcEntrys = new ArrayList<>();

	public SearchCriteria() {
		super();
	}

	public SearchCriteria(int firstResult, int pageSize) {
		super();
		this.pagination = true;
		this.firstResult = firstResult;
		this.pageSize = pageSize;
	}

	public void addAllSearchEntrys(List<SearchEntry<E>> searchEntrys) {
		this.searcEntrys.addAll(searchEntrys);
	}

	public void addSearchEntry(SearchEntry<E> searchEntry) {
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

	public E getSortBy() {
		return sortBy;
	}

	public void setSortBy(E searchBy) {
		this.sortBy = searchBy;
	}

	public SortOrder getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(SortOrder sortOrder) {
		this.sortOrder = sortOrder;
	}

	public List<SearchEntry<E>> getSearcEntrys() {
		return searcEntrys;
	}
	
	

}
