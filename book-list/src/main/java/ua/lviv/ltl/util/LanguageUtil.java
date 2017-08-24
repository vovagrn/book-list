package ua.lviv.ltl.util;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.jstl.core.Config;
import javax.servlet.jsp.jstl.fmt.LocalizationContext;

public class LanguageUtil {

	public static void setDefaultLocale(HttpSession session) {

		String defaultLocale = session.getServletContext().getInitParameter("defaultLocale");
		String[] locale = defaultLocale.split("_");

		Config.set(session, Config.FMT_LOCALIZATION_CONTEXT, new LocalizationContext(
				ResourceBundle.getBundle("/message/message", new Locale(locale[0], locale[1]))));
	}

}
