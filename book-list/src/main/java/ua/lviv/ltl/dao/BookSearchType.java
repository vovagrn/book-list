package ua.lviv.ltl.dao;

public enum BookSearchType implements SearchType {
	BY_TITLE("title"),
	PUBLISH_YEAR("publishYear");

	private String value;

	BookSearchType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}