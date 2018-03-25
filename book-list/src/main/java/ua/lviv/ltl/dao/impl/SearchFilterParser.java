package ua.lviv.ltl.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import ua.lviv.ltl.dao.Range;
import ua.lviv.ltl.dao.SearchFilter;
import ua.lviv.ltl.dao.SearchType;
import ua.lviv.ltl.dao.SearchFilter.SortOrder;

public class SearchFilterParser<T extends SearchType> {

	private Criteria criteria;

	private SearchFilterParser(Criteria criteria) {
		this.criteria = criteria;
	}

	public static SearchFilterParser<SearchType> getParser(Criteria criteria) {
		SearchFilterParser<SearchType> searchFilterParser = new SearchFilterParser<>(criteria);
		return searchFilterParser;
	}

	public Criteria parse(SearchFilter<T> searchFilter) {

		if (searchFilter == null)
			return criteria;

		if (searchFilter.isPagination()) {
			criteria.setFirstResult(searchFilter.getFirstResult());
			criteria.setMaxResults(searchFilter.getPageSize());
		}

		SortOrder sortOrder = searchFilter.getSortOrder();
		if (sortOrder != null) {
			switch (sortOrder) {
			case ASC:
				criteria.addOrder(Order.asc(searchFilter.getSortBy().getValue()));
				break;
			case DESC:
				criteria.addOrder(Order.desc(searchFilter.getSortBy().getValue()));
				break;
			}
		}

		parseSearchEntrys(searchFilter.getSearcEntrys());

		return criteria;
	}

	private void parseSearchEntrys(List<SearchEntry<T>> searchEntrys) {
		Disjunction or = Restrictions.disjunction();
		
		for (SearchEntry<T> searchEntry : searchEntrys) {
			String propertyName = searchEntry.getSearchType().getValue();
			List<Object> values = searchEntry.getValues();

			if (searchEntry.isSearchByRange()) {
				for (Range range : searchEntry.getRanges()) {
					or.add(Restrictions.between(propertyName, range.getStartRange(), range.getEndRange()));
				}
			}

			if (!values.isEmpty()) {
				or.add(Restrictions.in(propertyName, searchEntry.getValues()));
			}
		}
		criteria.add(or);
	}

}
