package ua.lviv.ltl.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.lviv.ltl.dao.BookDao;
import ua.lviv.ltl.dao.impl.DaoFactory;

@WebServlet("/book/*")
public class BookManagementController extends BaseManagementController {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		DaoFactory daoFactory = DaoFactory.getInstance();
		BookDao bookDao = daoFactory.getBookDao();

		ResourcePath resourcePath = checkResourcePath(req.getPathInfo());
		System.out.println("<-----------" + resourcePath);
		if (resourcePath != null) {
			switch (resourcePath) {
			case view:
				req.setAttribute("book", bookDao.getById(Long.parseLong(req.getParameter("id"))));
				forwardRequest(Page.viewBook, req, resp);
				break;
			case add:
				forwardRequest(Page.addBook, req, resp);
				break;
			case list:
				req.setAttribute("books", bookDao.getAll());
				forwardRequest(Page.listBook, req, resp);
				break;
			case edit:
				req.setAttribute("book", bookDao.getById(Long.parseLong(req.getParameter("id"))));
				forwardRequest(Page.editBook, req, resp);
				break;
			case delete:
				bookDao.delete(bookDao.getById(Long.parseLong(req.getParameter("id"))));
				req.setAttribute("books", bookDao.getAll());
				forwardRequest(Page.listBook, req, resp);
				break;
			default:
				break;
			}

			// DaoFactory daoFactory = DaoFactory.getInstance();
			// BookDao bookDao = daoFactory.getBookDao();
			//
			// String bookId = req.getParameter("id");
			// if (bookId == null) {
			// req.getRequestDispatcher("/WEB-INF/view/home.jsp").forward(req,
			// resp);
			// } else {
			// Book book = null;
			// try {
			// book = bookDao.getById(Long.parseLong(bookId));
			// } catch (NumberFormatException | DaoException e) {
			// e.printStackTrace();
			// }
			// List<Author> authors = book.getAuthors();
			// req.setAttribute("authors", authors);
			// req.getRequestDispatcher("/WEB-INF/view/home.jsp").forward(req,
			// resp);
			// }
		}
	}
}
