package com.ltl.library.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.ltl.library.dao.DaoException;
import com.ltl.library.dao.DaoFactory;
import com.ltl.library.dao.GenericDao;
import com.ltl.library.dao.GenreDao;
import com.ltl.library.model.Genre;


@WebServlet("/test")
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		DataSource dataSource = null;
//		try {
//			dataSource = (DataSource) new InitialContext().lookup("jdbc/library");
//		} catch (NamingException e) {
//			System.out.println("ERROR"+ dataSource);
//			e.printStackTrace();
//		}
//		System.out.println("OK"+ dataSource);
		
		DaoFactory daoFactory = DaoFactory.getInstance();
		GenreDao genreDao = daoFactory.getGenreDao();
		try {
			System.out.println(genreDao.getAll());
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			PrintWriter printWriter= response.getWriter();
			printWriter.print(genreDao.getAll().toString());
			printWriter.flush();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
