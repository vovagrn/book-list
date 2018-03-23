package ua.lviv.ltl.dao.impl;

import java.util.ArrayList;
import java.util.List;

import ua.lviv.ltl.dao.SearchType;

public class SearchEntry<E extends SearchType> {

	private E searchType;
	private boolean searchByDiapason = false;
	private Object startDiapason;
	private Object endDiapason;
	private List<Object> values = new ArrayList<>();

	public SearchEntry() {
		super();
	}

	public SearchEntry(Object endDiapason, Object startDiapason) {
		super();
		this.searchByDiapason = true;
		this.startDiapason = startDiapason;
		this.endDiapason = endDiapason;
	}

	public void addValue(Object value) {
		values.add(value);
	}

	public void addValues(List<Object> values) {
		this.values.addAll(values);
	}

	public boolean isSearchByDiapason() {
		return searchByDiapason;
	}

	public Object getStartDiapason() {
		return startDiapason;
	}

	public Object getEndDiapason() {
		return endDiapason;
	}

	public E getSearchType() {
		return searchType;
	}
	
	

	public void setSearchType(E searchType) {
		this.searchType = searchType;
	}

	public List<Object> getValues() {
		return values;
	}

}
