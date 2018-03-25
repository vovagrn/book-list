package ua.lviv.ltl.dao;

public enum AuthorSearchType implements SearchType{
	
	BY_NAME("name");
	
	private String value;

	AuthorSearchType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
