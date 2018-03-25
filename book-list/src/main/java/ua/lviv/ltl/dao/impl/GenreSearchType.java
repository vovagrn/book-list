package ua.lviv.ltl.dao.impl;

import ua.lviv.ltl.dao.SearchType;

public enum GenreSearchType implements SearchType {

	BY_NAME("name");

	private String value;

	GenreSearchType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
