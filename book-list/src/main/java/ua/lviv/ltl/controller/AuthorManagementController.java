package ua.lviv.ltl.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.lviv.ltl.dao.AuthorDao;
import ua.lviv.ltl.dao.GenreDao;
import ua.lviv.ltl.dao.PublisherDao;
import ua.lviv.ltl.dao.impl.DaoFactory;
import ua.lviv.ltl.model.Author;
import ua.lviv.ltl.model.Language;
import ua.lviv.ltl.util.LetterList;
import ua.lviv.ltl.util.UrlHistory;

@WebServlet("/author/*")
public class AuthorManagementController extends BaseManagementController {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		super.doGet(req, resp);
		DaoFactory daoFactory = DaoFactory.getInstance();
		AuthorDao authorDao = daoFactory.getAythorDao();
		GenreDao genreDao = daoFactory.getGenreDao();
		PublisherDao publisherDao = daoFactory.getPublisherDao();

		ResourcePath resourcePath = checkResourcePath(req.getPathInfo());
		
		if (resourcePath != null) {
			switch (resourcePath) {
			case view:
				Author author = authorDao.getById(Long.parseLong(req.getParameter("id")));
				req.setAttribute("books", author.getBooks());
				req.setAttribute("authors", authorDao.getAll());
				forwardRequest(Page.listBook, req, resp);
				break;
			case add:
				forwardRequest(Page.addAuthor, req, resp);
				break;
			case list:
				req.setAttribute("letters", LetterList.getUkrainianLetters());
				req.setAttribute("searchTypes", SearchType.values());
				req.setAttribute("languages", Language.values());
				req.setAttribute("genres", genreDao.getAll());
				req.setAttribute("publishers", publisherDao.getAll());
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
				UrlHistory history = (UrlHistory) req.getSession().getAttribute("history");
				resp.sendRedirect(history.getPrevious());
				//forwardRequest(Page.listAuthor, req, resp);
				break;
			default:
				break;
			}
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UrlHistory history = (UrlHistory) req.getSession().getAttribute("history");
		DaoFactory daoFactory = DaoFactory.getInstance();
		AuthorDao authorDao = daoFactory.getAythorDao();

		ResourcePath resourcePath = checkResourcePath(req.getPathInfo());

		if (resourcePath != null) {
			Author author = null;
			switch (resourcePath) {
			case add:
				author = new Author();
				author.setFullName(req.getParameter("fullName"));				
				authorDao.add(author);	
				//forwardRequest("/author/list", req, resp);
				
				resp.sendRedirect(history.getPrevious());
				break;
			case edit:
				author = authorDao.getById((Long.parseLong(req.getParameter("id"))));
				author.setFullName(req.getParameter("fullName"));				
				authorDao.update(author);
				//forwardRequest(Page.listAuthor, req, resp);				
				resp.sendRedirect(history.getLast());
				break;
			default:
				break;
			}
		}
	}

}
