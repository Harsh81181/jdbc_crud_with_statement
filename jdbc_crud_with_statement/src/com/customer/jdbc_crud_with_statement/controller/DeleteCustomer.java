package com.customer.jdbc_crud_with_statement.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteCustomer {
public static void deleteCustomer() {
	Connection connection=null;
	Statement statement=null;
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306/firstassignment";
		String user="root";
		String pass="Ha@210903";
		connection= DriverManager.getConnection(url, user, pass);
		
		statement= connection.createStatement();
		String deleteCustomer="delete from customer where id = " +InputCustomer.inputId();
		if(statement.executeUpdate(deleteCustomer)==1) {
			System.out.println("<< Data has deleted successfully >>");
		}
		else {
			System.out.println("<< Data has not deleted Successfully >>");
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
