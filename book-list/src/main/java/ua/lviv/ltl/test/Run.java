package ua.lviv.ltl.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import ua.lviv.ltl.model.Book;
import ua.lviv.ltl.util.HibernateUtil;
import ua.lviv.ltl.util.LetterList;

public class Run {

	public static void main(String[] args) {
		System.out.println(HibernateUtil.getSessionFactory().toString());
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Book.class);
		criteria.add(Restrictions.eq("isbn", 44444));
		criteria.setProjection(Projections.rowCount());
		List results = criteria.list();
		
		System.out.println(results.get(0));
		session.close();

	}

}
