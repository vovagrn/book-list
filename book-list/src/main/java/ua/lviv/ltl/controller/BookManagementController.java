package ua.lviv.ltl.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.lviv.ltl.dao.BookDao;
import ua.lviv.ltl.dao.DaoException;
import ua.lviv.ltl.dao.impl.DaoFactory;
import ua.lviv.ltl.model.Author;
import ua.lviv.ltl.model.Book;

@WebServlet("/book")
public class BookManagementController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BookManagementController() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DaoFactory daoFactory = DaoFactory.getInstance();
		BookDao bookDao = daoFactory.getBookDao();

		String bookId = req.getParameter("id");
		if (bookId == null) {
			req.getRequestDispatcher("/WEB-INF/view/home.jsp").forward(req, resp);
		} else {
			Book book = null;
			try {
				book = bookDao.getById(Long.parseLong(bookId));
			} catch (NumberFormatException | DaoException e) {
				e.printStackTrace();
			}
			List<Author> authors = book.getAuthors();
			req.setAttribute("authors", authors);
			req.getRequestDispatcher("/WEB-INF/view/home.jsp").forward(req, resp);
		}
	}

}
