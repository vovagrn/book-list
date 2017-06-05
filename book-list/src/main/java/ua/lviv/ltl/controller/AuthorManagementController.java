package ua.lviv.ltl.controller;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.lviv.ltl.dao.AuthorDao;
import ua.lviv.ltl.dao.BookDao;
import ua.lviv.ltl.dao.DaoException;
import ua.lviv.ltl.dao.impl.DaoFactory;
import ua.lviv.ltl.model.Author;
import ua.lviv.ltl.model.Book;

@WebServlet("/author")
public class AuthorManagementController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		DaoFactory daoFactory = DaoFactory.getInstance();
		AuthorDao authorDao = daoFactory.getAythorDao();

		String authorId = req.getParameter("id");
		if (authorId == null) {

			List<Author> authors = null;
			try {
				authors = authorDao.getAll();
			} catch (DaoException e) {
				e.printStackTrace();
			}
			req.setAttribute("authors", authors);
			req.getRequestDispatcher("/WEB-INF/view/home.jsp").forward(req, resp);
		} else {
			Author author = null;
			try {
				author = authorDao.getById(Long.parseLong(authorId));
			} catch (NumberFormatException | DaoException e) {
				e.printStackTrace();
			}
			Set<Book> books = author.getBooks();
			req.setAttribute("books", books);
			req.getRequestDispatcher("/WEB-INF/view/authors.jsp").forward(req, resp);
		}
	}

}
