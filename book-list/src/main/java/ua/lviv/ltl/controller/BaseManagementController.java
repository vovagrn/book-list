package ua.lviv.ltl.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.lviv.ltl.util.UrlHistory;

public abstract class BaseManagementController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BaseManagementController() {
		super();
	}

	protected static void forwardRequest(Page page, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/view/new/" + page.name() + ".jsp").forward(req, resp);
	}

//	protected static void forwardRequest(String path, HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException {
//
//		req.getRequestDispatcher(path).forward(req, resp);
//	}

	protected static ResourcePath checkResourcePath(String pathInfo) {
		ResourcePath resourcePath = null;
		if (pathInfo != null) {
			try {
				resourcePath = ResourcePath.valueOf(pathInfo.replaceFirst("/", ""));
			} catch (IllegalArgumentException e) {
			}
		}

		return resourcePath;
	}

	protected static String getFullURL(HttpServletRequest request) {
		StringBuffer requestURL = new StringBuffer(request.getRequestURI());
		String queryString = request.getQueryString();

		if (queryString == null) {
			return requestURL.toString();
		} else {
			return requestURL.append('?').append(queryString).toString();
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		initHistory(req);
		UrlHistory urlHistory = (UrlHistory) req.getSession(true).getAttribute("history");
		urlHistory.add(getFullURL(req));
		System.out.println("<--3---:" + urlHistory + "------->");
	}

	private void initHistory(HttpServletRequest req) {
		UrlHistory urlHistory = (UrlHistory) req.getSession(true).getAttribute("history");		
		if (urlHistory == null) {
			req.getSession().setAttribute("history", new UrlHistory());			
		}
	}

}
