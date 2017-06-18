package ua.lviv.ltl.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.lviv.ltl.dao.AuthorDao;
import ua.lviv.ltl.dao.BookDao;
import ua.lviv.ltl.dao.impl.DaoFactory;
import ua.lviv.ltl.model.Author;
import ua.lviv.ltl.model.Book;

@WebServlet("/book/*")
public class BookManagementController extends BaseManagementController {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		DaoFactory daoFactory = DaoFactory.getInstance();
		BookDao bookDao = daoFactory.getBookDao();
		AuthorDao authorDao = daoFactory.getAythorDao();

		ResourcePath resourcePath = checkResourcePath(req.getPathInfo());
		System.out.println("<-----------" + resourcePath);
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
				book.setDescription(req.getParameter("description"));
				book.setIsbn(Integer.parseInt(req.getParameter("isbn")));

				ids = req.getParameterValues("id");
				if (ids != null) {
					for (String id : ids) {

						book.getAuthors().add(authorDao.getById(Long.parseLong(id)));

					}
					System.out.println("<-----------");
				}
				bookDao.add(book);
				req.setAttribute("books", bookDao.getAll());
				forwardRequest(Page.listBook, req, resp);

				// Person person = null;
				// String gender = req.getParameter(Parameter.gender.name());
				// if (gender.equals("Male")) {
				// person = new Male();
				// }
				// if (gender.equals("Female")) {
				// person = new Female();
				// }
				// person.setFirstName(req.getParameter(Parameter.firstName.name()));
				// person.setLastName(req.getParameter(Parameter.lastName.name()));
				// person.setBirthDate(getDate(req.getParameter(Parameter.birthDate.name())));
				// personManagementService.addPerson(person);
				// req.setAttribute("persons",
				// personManagementService.getAllPersons());
				// forvardRequest(Page.listPerson, req, res);
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
					System.out.println("<-----------");
				}else{book.getAuthors().clear();}				
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
