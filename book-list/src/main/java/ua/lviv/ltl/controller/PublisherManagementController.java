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
import ua.lviv.ltl.model.Genre;
import ua.lviv.ltl.model.Language;
import ua.lviv.ltl.util.LetterList;
import ua.lviv.ltl.util.UrlHistory;

@WebServlet("/publisher/*")
public class PublisherManagementController extends BaseManagementController {
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
			case list:
				req.setAttribute("letters", LetterList.getUkrainianLetters());
				req.setAttribute("searchTypes", SearchType.values());
				req.setAttribute("languages", Language.values());
				req.setAttribute("genres", genreDao.getAll());
				req.setAttribute("publishers", publisherDao.getAll());
				req.setAttribute("authors", authorDao.getAll());			
				
				forwardRequest(Page.listGenre, req, resp);
				break;			
			case delete:
				publisherDao.delete(publisherDao.getById(Long.parseLong(req.getParameter("id"))));				
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
		GenreDao genreDao = daoFactory.getGenreDao();		

		ResourcePath resourcePath = checkResourcePath(req.getPathInfo());

		if (resourcePath != null) {
			Genre genre = null;
			switch (resourcePath) {
			case add:
				genre = new Genre();
				genre.setName(req.getParameter("name"));				
				genreDao.add(genre);	
				//forwardRequest("/author/list", req, resp);
				
				resp.sendRedirect(history.getLast());
				break;
			case edit:
				genre = genreDao.getById((Long.parseLong(req.getParameter("id"))));
				genre.setName(req.getParameter("name"));				
				genreDao.update(genre);
				//forwardRequest(Page.listAuthor, req, resp);				
				resp.sendRedirect(history.getLast());
				break;
			default:
				break;
			}
		}
	}
}
