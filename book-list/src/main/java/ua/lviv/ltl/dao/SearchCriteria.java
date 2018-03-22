package ua.lviv.ltl.dao;

import java.util.ArrayList;
import java.util.List;
import ua.lviv.ltl.dao.impl.SearchEntry;

public class SearchCriteria<E extends SearchType> {

	public enum SortType {
		ASC, DESC
	}

	private boolean pagination = false;
	private int start = 0;
	private int pageSize = 0;
	private List<SearchEntry<E>> searcEntrys = new ArrayList<>();

	public SearchCriteria() {
		super();
	}

	public SearchCriteria(int start, int pageSize) {
		super();
		this.pagination = true;
		this.start = start;
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

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

}
