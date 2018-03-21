package ua.lviv.ltl.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ua.lviv.ltl.dao.impl.SearchEntry;

public class SearchCriteria<E extends Enum<E>> {

	public enum SortType {
		ASC, DESC
	}

	public SearchCriteria() {
		super();
	}

	public SearchCriteria(int start, int pageSize) {
		super();
		this.pagination = true;
		this.start = start;
		this.pageSize = pageSize;
	}

	private boolean pagination = false;
	private int start = 0;
	private int pageSize = 0;
	private List<SearchEntry> searcEntrys = new ArrayList();
	
	public SearchCriteria<E> addSearchEntry(SearchEntry searchEntry){
		searcEntrys.add(searchEntry);
		return this;
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
