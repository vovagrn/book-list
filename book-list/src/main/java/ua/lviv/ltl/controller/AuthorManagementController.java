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

		// String authorId = req.getParameter("id");
		// if (authorId == null) {
		//
		// List<Author> authors = null;
		// try {
		// authors = authorDao.getAll();
		// } catch (DaoException e) {
		// e.printStackTrace();
		// }
		// req.setAttribute("authors", authors);
		// forwardRequest(Page.listAuthor, req, resp);
		// } else {
		// Author author = null;
		// try {
		// author = authorDao.getById(Long.parseLong(authorId));
		// } catch (NumberFormatException | DaoException e) {
		// e.printStackTrace();
		// }
		// req.setAttribute("author", author);
		// forwardRequest(Page.author, req, resp);
		// }
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DaoFactory daoFactory = DaoFactory.getInstance();
		AuthorDao authorDao = daoFactory.getAythorDao();

		ResourcePath resourcePath = checkResourcePath(req.getPathInfo());
		if (resourcePath != null) {
			switch (resourcePath) {
			// case add:
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
			// break;
			case edit:
				Author author = authorDao.getById((Long.parseLong(req.getParameter("id"))));
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
