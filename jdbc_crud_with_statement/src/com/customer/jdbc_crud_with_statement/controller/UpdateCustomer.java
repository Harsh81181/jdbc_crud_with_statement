package com.customer.jdbc_crud_with_statement.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateCustomer {
public static void updateCustomer() {
	Connection connection=null;
	Statement statement=null;
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306/firstassignment";
		String user="root";
		String pass="Ha@210903";
		connection= DriverManager.getConnection(url, user, pass);
		
		statement= connection.createStatement();
		String update=InputCustomer.update();
		if(statement.executeUpdate(update)==1) {
			System.out.println("<< Data Updated Successfully. >>");
		}
		else {
			System.out.println("<< Data has not updated successfully >>");
		}
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		try {
			connection.close();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
}
