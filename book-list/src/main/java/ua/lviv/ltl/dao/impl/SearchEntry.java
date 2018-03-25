package ua.lviv.ltl.dao.impl;

import java.util.ArrayList;
import java.util.List;

import ua.lviv.ltl.dao.Range;
import ua.lviv.ltl.dao.SearchType;

public class SearchEntry<T extends SearchType> {

	private T searchType;
	private boolean searchByRange = false;
	// private Object startDiapason;
	// private Object endDiapason;
	private List<Range> ranges = new ArrayList<>();
	private List<Object> values = new ArrayList<>();

	public SearchEntry(T searchType, List<Range> ranges, List<Object> values, boolean searcByRange) {
		this.searchType = searchType;
		this.ranges = ranges;
		this.values = values;
		this.searchByRange = searcByRange;
	}

	public T getSearchType() {
		return searchType;
	}

	public boolean isSearchByRange() {
		return searchByRange;
	}

	public List<Range> getRanges() {
		return ranges;
	}

	public List<Object> getValues() {
		return values;
	}

	public static class Builder<T extends SearchType> {

		private T searchType;
		private boolean searchByRange = false;
		// private Object startRange;
		// private Object endRange;
		private List<Range> ranges = new ArrayList<>();
		private List<Object> values = new ArrayList<>();

		public Builder(T searchType) {
			this.searchType = searchType;
		}

		public Builder<T> addRange(Object startRange, Object endRange) {
			this.searchByRange = true;
			this.ranges.add(new Range(startRange, endRange));
			return this;
		}

		public Builder<T> addValue(Object value) {
			this.values.add(value);
			return this;
		}

		public Builder<T> addValues(List<Object> values) {
			this.values.addAll(values);
			return this;
		}

		public SearchEntry<T> build() {
			SearchEntry<T> searchEntry = new SearchEntry<T>(searchType, ranges, values, searchByRange);
			return searchEntry;
		}

	}

}
