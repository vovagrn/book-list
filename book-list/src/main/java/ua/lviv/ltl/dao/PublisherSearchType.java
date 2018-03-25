package ua.lviv.ltl.dao;

public enum PublisherSearchType implements SearchType {

	BY_NAME("name");

	private String value;

	PublisherSearchType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
