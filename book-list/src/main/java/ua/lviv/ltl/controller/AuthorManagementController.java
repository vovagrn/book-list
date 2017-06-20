package ua.lviv.ltl.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.lviv.ltl.dao.AuthorDao;
import ua.lviv.ltl.dao.impl.DaoFactory;
import ua.lviv.ltl.model.Author;

@WebServlet("/author/*")
public class AuthorManagementController extends BaseManagementController {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		DaoFactory daoFactory = DaoFactory.getInstance();
		AuthorDao authorDao = daoFactory.getAythorDao();

		ResourcePath resourcePath = checkResourcePath(req.getPathInfo());		
		req.getSession().setAttribute("previousPath", req.getSession().getAttribute("path"));
		req.getSession().setAttribute("path", req.getSession().getAttribute("lastPath"));
		req.getSession().setAttribute("lastPath", (req.getRequestURL().append('?').append(req.getQueryString())).toString());
		System.out.println("<-----------" + req.getSession().getAttribute("previousPath"));
		System.out.println("<-----------" + req.getSession().getAttribute("path"));
		System.out.println("<-----------" + req.getSession().getAttribute("lastPath"));
		
		
		
		System.out.println("<-----------" + resourcePath);
		if (resourcePath != null) {
			switch (resourcePath) {
			case view:
				req.setAttribute("author", authorDao.getById(Long.parseLong(req.getParameter("id"))));
				forwardRequest(Page.viewAuthor, req, resp);
				break;
			case add:
				forwardRequest(Page.addAuthor, req, resp);
				break;
			case list:
				req.setAttribute("authors", authorDao.getAll());
				forwardRequest(Page.listAuthor, req, resp);
				break;
			case edit:
				req.setAttribute("author", authorDao.getById(Long.parseLong(req.getParameter("id"))));
				forwardRequest(Page.editAuthor, req, resp);
				break;
			case delete:
				authorDao.delete(authorDao.getById(Long.parseLong(req.getParameter("id"))));
				req.setAttribute("authors", authorDao.getAll());
				forwardRequest(Page.listAuthor, req, resp);
				break;
			default:
				break;
			}
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DaoFactory daoFactory = DaoFactory.getInstance();
		AuthorDao authorDao = daoFactory.getAythorDao();

		ResourcePath resourcePath = checkResourcePath(req.getPathInfo());		
		req.getSession().setAttribute("previousPath", req.getSession().getAttribute("path"));
		req.getSession().setAttribute("path", req.getSession().getAttribute("lastPath"));
		req.getSession().setAttribute("lastPath", (req.getRequestURL().append('?').append(req.getQueryString())).toString());
		System.out.println("<-----------" + req.getSession().getAttribute("previousPath"));
		System.out.println("<-----------" + req.getSession().getAttribute("path"));
		System.out.println("<-----------" + req.getSession().getAttribute("lastPath"));
		
		
		
		
		if (resourcePath != null) {
			Author author = null;
			switch (resourcePath) {
			case add:
				author = new Author();
				author.setFirstName(req.getParameter("firstName"));
				author.setLastName(req.getParameter("lastName"));
				author.setMiddleName(req.getParameter("middleName"));
				authorDao.add(author);
				req.setAttribute("authors", authorDao.getAll());
				resp.sendRedirect((String)req.getSession().getAttribute("previousPath"));
				//forwardRequest(Page.listAuthor, req, resp);
				break;
			case edit:
				author = authorDao.getById((Long.parseLong(req.getParameter("id"))));
				author.setFirstName(req.getParameter("firstName"));
				author.setLastName(req.getParameter("lastName"));
				author.setMiddleName(req.getParameter("middleName"));
				authorDao.update(author);
				System.out.println("<-----POST------" + resourcePath);
				req.setAttribute("authors", authorDao.getAll());							
				forwardRequest(Page.listAuthor, req, resp);
				break;
			default:
				break;
			}
		}
	}

}
