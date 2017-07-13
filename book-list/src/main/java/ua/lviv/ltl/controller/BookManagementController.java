package ua.lviv.ltl.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

import ua.lviv.ltl.dao.AuthorDao;
import ua.lviv.ltl.dao.BookDao;
import ua.lviv.ltl.dao.impl.DaoFactory;
import ua.lviv.ltl.model.Book;
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
				req.setAttribute("authors", authorDao.getAll());
				req.setAttribute("books", bookDao.getAll());
				forwardRequest(Page.listBook, req, resp);
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

		ResourcePath resourcePath = checkResourcePath(req.getPathInfo());

		Book book = null;
		String[] ids = null;
		if (resourcePath != null) {
			switch (resourcePath) {
			case add:
				book = new Book();
				book.setTitle(req.getParameter("title"));
				book.setLanguage(req.getParameter("language"));
				book.setDescription(req.getParameter("description"));
				book.setIsbn(Integer.parseInt(req.getParameter("isbn")));
				book.setPageCount(Integer.parseInt(req.getParameter("page_count")));
				book.setPublishYear(Integer.parseInt(req.getParameter("publish_year")));

				InputStream inputStream = null;
				Part filePart = req.getPart("image");
				if (filePart != null) {
					inputStream = filePart.getInputStream();
				}
				if (inputStream != null) {
					book.setImage(IOUtils.toByteArray(inputStream));
				}

				ids = req.getParameterValues("id");
				if (ids != null) {
					for (String id : ids) {
						book.getAuthors().add(authorDao.getById(Long.parseLong(id)));
					}
				}
				bookDao.add(book);
				req.setAttribute("books", bookDao.getAll());
				// forwardRequest(Page.listBook, req, resp);
				UrlHistory history = (UrlHistory) req.getSession().getAttribute("history");
				resp.sendRedirect(history.getPrevious());
				break;
			case edit:
				book = bookDao.getById((Long.parseLong(req.getParameter("id"))));
				book.setTitle(req.getParameter("title"));
				book.setDescription(req.getParameter("description"));
				book.setIsbn(Integer.parseInt(req.getParameter("isbn")));

				ids = req.getParameterValues("ids");
				if (ids != null) {
					book.getAuthors().clear();
					for (String id : ids) {
						book.getAuthors().add(authorDao.getById(Long.parseLong(id)));
					}
				} else {
					book.getAuthors().clear();
				}
				bookDao.update(book);
				req.setAttribute("books", bookDao.getAll());
				forwardRequest(Page.listBook, req, resp);
				break;
			default:
				break;
			}
		}
	}
}
