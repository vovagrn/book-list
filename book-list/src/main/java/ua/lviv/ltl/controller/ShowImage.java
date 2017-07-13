package ua.lviv.ltl.controller;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.lviv.ltl.dao.BookDao;
import ua.lviv.ltl.dao.impl.DaoFactory;
import ua.lviv.ltl.model.Book;


@WebServlet("/image")
public class ShowImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoFactory daoFactory = DaoFactory.getInstance();
		BookDao bookDao = daoFactory.getBookDao();
		
		response.setContentType("image/jpeg");
		OutputStream out = response.getOutputStream();  
		try {
            Long bookId = Long.parseLong(request.getParameter("bookId"));
            Book book = bookDao.getById(bookId);
            response.setContentLength(book.getImage().length);
            out.write(book.getImage());
        }catch (Exception ex){
            ex.printStackTrace();
        } finally {            
            out.close();
        }
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
