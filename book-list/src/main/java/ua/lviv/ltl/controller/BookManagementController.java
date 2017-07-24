package ua.lviv.ltl.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

import ua.lviv.ltl.dao.AuthorDao;
import ua.lviv.ltl.dao.BookDao;
import ua.lviv.ltl.dao.GenreDao;
import ua.lviv.ltl.dao.PublisherDao;
import ua.lviv.ltl.dao.impl.DaoFactory;
import ua.lviv.ltl.model.Author;
import ua.lviv.ltl.model.Book;
import ua.lviv.ltl.model.Language;
import ua.lviv.ltl.util.LetterList;
import ua.lviv.ltl.util.UrlHistory;

@WebServlet("/book/*")
@MultipartConfig(maxFileSize = 16177215)
public class BookManagementController extends BaseManagementController {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		super.doGet(req, resp);
		DaoFactory daoFactory = DaoFactory.getInstance();
		BookDao bookDao = daoFactory.getBookDao();
		AuthorDao authorDao = daoFactory.getAythorDao();
		GenreDao genreDao = daoFactory.getGenreDao();
		PublisherDao publisherDao = daoFactory.getPublisherDao();

		ResourcePath resourcePath = checkResourcePath(req.getPathInfo());

		if (resourcePath != null) {
			switch (resourcePath) {
			case view:
				req.setAttribute("book", bookDao.getById(Long.parseLong(req.getParameter("id"))));
				forwardRequest(Page.viewBook, req, resp);
				break;
			case add:
				req.setAttribute("authors", authorDao.getAll());
				forwardRequest(Page.addBook, req, resp);
				break;
			case list:				
				req.setAttribute("letters", LetterList.getUkrainianLetters());
				String letter = req.getParameter("letter");
				String genreId = req.getParameter("genre");
				String searchString = req.getParameter("search_string");
				String searchOption = req.getParameter("search_option");
				SearchType searchType = null;
				if(searchOption != null){
					searchType = SearchType.valueOf(searchOption);
				}
				
				if(genreId != null){
					req.setAttribute("books", genreDao.getFullGenreById(Long.parseLong(genreId)).getBooks());
					req.setAttribute("genres", genreDao.getAll());
					req.setAttribute("publishers", publisherDao.getAll());
					req.setAttribute("authors", authorDao.getAll());
					req.setAttribute("languages", Language.values());
					forwardRequest(Page.listBook, req, resp);
				} else if (searchString != null) {
					switch (searchType) {
					case TITLE:
						req.setAttribute("books", bookDao.getBookByTitle(searchString));
						req.setAttribute("genres", genreDao.getAll());
						req.setAttribute("publishers", publisherDao.getAll());
						req.setAttribute("authors", authorDao.getAll());
						req.setAttribute("languages", Language.values());
						forwardRequest(Page.listBook, req, resp);
						break;
					case AUTHOR:
						Set<Book> books = new HashSet<Book>();
						for(Author author : authorDao.getAuthorByName(searchString)){
							books.addAll(authorDao.getFullAuthorById(author.getId()).getBooks());
						}
						req.setAttribute("books", books);
						req.setAttribute("genres", genreDao.getAll());
						req.setAttribute("publishers", publisherDao.getAll());
						req.setAttribute("authors", authorDao.getAll());
						req.setAttribute("languages", Language.values());
						forwardRequest(Page.listBook, req, resp);
						break;					
//					}
//					if(searchType == SearchType.TITLE){						
//						req.setAttribute("books", bookDao.getBookByTitle(searchString));
//						req.setAttribute("genres", genreDao.getAll());
//						req.setAttribute("publishers", publisherDao.getAll());
//						req.setAttribute("authors", authorDao.getAll());
//						req.setAttribute("languages", Language.values());
//						forwardRequest(Page.listBook, req, resp);
					}
				}else if (letter != null) {
					req.setAttribute("books", bookDao.getBookByLetter(letter));
					req.setAttribute("genres", genreDao.getAll());
					req.setAttribute("publishers", publisherDao.getAll());
					req.setAttribute("authors", authorDao.getAll());
					req.setAttribute("languages", Language.values());
					forwardRequest(Page.listBook, req, resp);
				} else {
					req.setAttribute("books", bookDao.getAll());
					req.setAttribute("genres", genreDao.getAll());
					req.setAttribute("publishers", publisherDao.getAll());
					req.setAttribute("authors", authorDao.getAll());
					req.setAttribute("languages", Language.values());
					forwardRequest(Page.listBook, req, resp);
				}
				break;
			case edit:
				req.setAttribute("book", bookDao.getById(Long.parseLong(req.getParameter("id"))));
				req.setAttribute("authors", authorDao.getAll());
				forwardRequest(Page.editBook, req, resp);
				break;
			case delete:
				bookDao.delete(bookDao.getById(Long.parseLong(req.getParameter("id"))));
				req.setAttribute("books", bookDao.getAll());
				UrlHistory history = (UrlHistory) req.getSession().getAttribute("history");
				resp.sendRedirect(history.getPrevious());
				// forwardRequest(Page.listBook, req, resp);
				break;
			default:
				break;
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DaoFactory daoFactory = DaoFactory.getInstance();
		BookDao bookDao = daoFactory.getBookDao();
		AuthorDao authorDao = daoFactory.getAythorDao();
		GenreDao genreDao = daoFactory.getGenreDao();
		PublisherDao publisherDao = daoFactory.getPublisherDao();

		ResourcePath resourcePath = checkResourcePath(req.getPathInfo());

		Book book = null;
		Part filePart = null;
		String language = null;
		String[] authorsId = null;
		InputStream inputStream = null;

		if (resourcePath != null) {
			switch (resourcePath) {
			case add:
				book = new Book();
				book.setTitle(req.getParameter("title"));
				language = req.getParameter("language");
				if (language != null && !language.equals(" ")) {
					book.setLanguage(Language.valueOf(language));
				}
				book.setGenre(genreDao.getById(Long.parseLong(req.getParameter("genre"))));
				book.setPublisher(publisherDao.getById(Long.parseLong(req.getParameter("publisher"))));
				book.setDescription(req.getParameter("description"));
				book.setIsbn(Integer.parseInt(req.getParameter("isbn")));
				book.setPageCount(Integer.parseInt(req.getParameter("page_count")));
				book.setPublishYear(Integer.parseInt(req.getParameter("publish_year")));

				filePart = req.getPart("image");
				if (filePart != null) {
					inputStream = filePart.getInputStream();
				}
				if (inputStream != null) {
					book.setImage(IOUtils.toByteArray(inputStream));
				}

				authorsId = req.getParameterValues("authorsId");
				if (authorsId != null) {
					for (String id : authorsId) {
						book.getAuthors().add(authorDao.getById(Long.parseLong(id)));
					}
				}
				bookDao.add(book);
				resp.sendRedirect(req.getServletContext().getContextPath() + "/book/list");
				// req.setAttribute("books", bookDao.getAll());
				// forwardRequest(Page.listBook, req, resp);
				// UrlHistory history = (UrlHistory)
				// req.getSession().getAttribute("history");
				// resp.sendRedirect(history.getPrevious());
				break;
			case edit:
				book = bookDao.getById((Long.parseLong(req.getParameter("id"))));
				book.setTitle(req.getParameter("title"));
				language = req.getParameter("language");
				if (language != null && !language.equals(" ")) {
					book.setLanguage(Language.valueOf(language));
				}
				book.setGenre(genreDao.getById(Long.parseLong(req.getParameter("genre"))));
				book.setPublisher(publisherDao.getById(Long.parseLong(req.getParameter("publisher"))));
				book.setDescription(req.getParameter("description"));
				book.setIsbn(Integer.parseInt(req.getParameter("isbn")));
				book.setPageCount(Integer.parseInt(req.getParameter("page_count")));
				book.setPublishYear(Integer.parseInt(req.getParameter("publish_year")));

				filePart = req.getPart("image");
				if (filePart != null && filePart.getSize() > 0) {
					inputStream = filePart.getInputStream();
				}
				if (inputStream != null) {
					book.setImage(IOUtils.toByteArray(inputStream));
				}

				authorsId = req.getParameterValues("authorsId");
				if (authorsId != null) {
					book.getAuthors().clear();
					for (String id : authorsId) {
						book.getAuthors().add(authorDao.getById(Long.parseLong(id)));
					}
				} else {
					book.getAuthors().clear();
				}
				bookDao.update(book);
				
				UrlHistory history = (UrlHistory) req.getSession().getAttribute("history");
				resp.sendRedirect(history.getLast());
				
//				resp.sendRedirect(req.getServletContext().getContextPath() + "/book/list");
				
				// forwardRequest(Page.listBook, req, resp);
				break;
			default:
				break;
			}
		}
	}
}
