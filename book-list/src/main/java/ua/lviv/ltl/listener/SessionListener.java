package ua.lviv.ltl.listener;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.jsp.jstl.core.Config;
import javax.servlet.jsp.jstl.fmt.LocalizationContext;

@WebListener
public class SessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		
		String defaultLocale = se.getSession().getServletContext().getInitParameter("defaultLocale");
		String [] locale = defaultLocale.split("_");
		
		Config.set(se.getSession(), Config.FMT_LOCALIZATION_CONTEXT,
				new LocalizationContext(ResourceBundle.getBundle("/message/message", new Locale(locale[0], locale[1]))));
		
		System.out.println("<-----LISTENER------SESSION ID: " + se.getSession().getId() + " ----->");
		
//		UrlHistory urlHistory = (UrlHistory) se.getSession().getAttribute("history");
//		if (urlHistory == null) {
//			se.getSession().setAttribute("history", new UrlHistory());			
//		}
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub

	}

}
