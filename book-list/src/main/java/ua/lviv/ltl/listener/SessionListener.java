package ua.lviv.ltl.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import ua.lviv.ltl.util.UrlHistory;

@WebListener
public class SessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
//		UrlHistory urlHistory = (UrlHistory) se.getSession().getAttribute("history");
//		if (urlHistory == null) {
//			se.getSession().setAttribute("history", new UrlHistory());
			System.out.println("<----LISTENER----->");
//		}
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub

	}

}
