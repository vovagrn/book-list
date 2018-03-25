package ua.lviv.ltl.dao;

public class Range {

	private Object startRange;
	private Object endRange;

	public Range(Object startRange, Object endRange) {
		this.startRange = startRange;
		this.endRange = endRange;
	}

	public Object getStartRange() {
		return startRange;
	}

	public Object getEndRange() {
		return endRange;
	}
}
