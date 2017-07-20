package ua.lviv.ltl.test;

import ua.lviv.ltl.util.HibernateUtil;
import ua.lviv.ltl.util.LetterList;

public class Run {

	public static void main(String[] args) {
		System.out.println(HibernateUtil.getSessionFactory().toString());

	}

}
