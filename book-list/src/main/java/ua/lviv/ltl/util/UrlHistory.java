package ua.lviv.ltl.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpSession;

public class UrlHistory {
	
	private HttpSession session;
	private List<String> history = new ArrayList();
	
	public UrlHistory() {
		this.session = session;
	}
	
	public String getPrevious(){
		return history.get(history.size() - 1);
	}
	
	public void save(String point){
		history.add(point);
	}

}
