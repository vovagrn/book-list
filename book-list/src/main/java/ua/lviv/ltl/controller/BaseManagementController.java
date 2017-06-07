package ua.lviv.ltl.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseManagementController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public BaseManagementController() {
        super();        
    }

    protected static void forwardRequest(Page page, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/view/" + page.name() + ".jsp").forward(req, resp);
	}

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

}
