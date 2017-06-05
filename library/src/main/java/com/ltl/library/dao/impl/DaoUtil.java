package com.ltl.library.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DaoUtil {
	
	public static PreparedStatement prepareStatement(
			Connection connection, String sql, Object... values) throws SQLException{		
		PreparedStatement statement = connection.prepareStatement(sql);
		setValues(statement, values);
		return statement;
	}

	private static void setValues(PreparedStatement statement, Object[] values) throws SQLException {
		for(int i = 0; i < values.length; i++){
			statement.setObject(i + 1, values[i]);
		}
		
	}

}
