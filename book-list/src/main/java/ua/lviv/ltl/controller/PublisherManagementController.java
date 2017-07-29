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
import ua.lviv.ltl.model.Language;
import ua.lviv.ltl.model.Publisher;
import ua.lviv.ltl.util.LetterList;
import ua.lviv.ltl.util.UrlHistory;

@WebServlet("/publisher/*")
public class PublisherManagementController extends BaseManagementController {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		super.doGet(req, resp);
		UrlHistory history = (UrlHistory) req.getSession().getAttribute("history");
		DaoFactory daoFactory = DaoFactory.getInstance();
		AuthorDao authorDao = daoFactory.getAythorDao();
		GenreDao genreDao = daoFactory.getGenreDao();
		PublisherDao publisherDao = daoFactory.getPublisherDao();

		ResourcePath resourcePath = checkResourcePath(req.getPathInfo());
		
		if (resourcePath != null) {
			switch (resourcePath) {				
			case list:
				req.setAttribute("letters", LetterList.getUkrainianLetters());
				req.setAttribute("searchTypes", SearchType.values());
				req.setAttribute("languages", Language.values());
				req.setAttribute("genres", genreDao.getAll());
				req.setAttribute("publishers", publisherDao.getAll());
				req.setAttribute("authors", authorDao.getAll());
				forwardRequest(Page.listPublisher, req, resp);
				break;			
			case delete:
				publisherDao.delete(publisherDao.getById(Long.parseLong(req.getParameter("id"))));
				resp.sendRedirect(history.getPrevious());
				//forwardRequest(Page.listPublisher, req, resp);
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
		PublisherDao publisherDao = daoFactory.getPublisherDao();		

		ResourcePath resourcePath = checkResourcePath(req.getPathInfo());

		if (resourcePath != null) {
			Publisher publisher = null;
			switch (resourcePath) {
			case add:
				publisher = new Publisher();
				publisher.setName(req.getParameter("name"));				
				publisherDao.add(publisher);					
				resp.sendRedirect(history.getLast());
				//forwardRequest(Page.listPublisher, req, resp);
				break;
			case edit:
				publisher = publisherDao.getById((Long.parseLong(req.getParameter("id"))));
				publisher.setName(req.getParameter("name"));				
				publisherDao.update(publisher);
				//forwardRequest(Page.listAuthor, req, resp);				
				resp.sendRedirect(history.getLast());				
				break;
			default:
				break;
			}
		}
	}
}
