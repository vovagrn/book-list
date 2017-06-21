package ua.lviv.ltl.util;

import java.util.ArrayList;
import java.util.List;

public class UrlHistory {	
	
	private List<String> history = new ArrayList<String>();
	
	public UrlHistory() {		
	}
	
	public String getPrevious(){
		return history.get(history.size() - 2);
	}
	
	public void add(String point){
		history.add(point);
	}

	@Override
	public String toString() {
		return history.toString();
	}

}
