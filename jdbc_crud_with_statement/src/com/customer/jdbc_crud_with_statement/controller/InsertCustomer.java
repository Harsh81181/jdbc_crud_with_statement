package com.customer.jdbc_crud_with_statement.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertCustomer {
public static void insertCustomer() {
	Connection connection=null;
	Statement statement=null;
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306/firstassignment";
		String user="root";
		String pass="Ha@210903";
		connection= DriverManager.getConnection(url, user, pass);
		
		statement= connection.createStatement();
		String insertCustomer="Insert into customer values("+InputCustomer.inputId()+
														",'"+InputCustomer.inputName()+
														"','"+InputCustomer.inputEmailid()+
														"',"+InputCustomer.inputPhone() +")";
		if(statement.execute(insertCustomer)==false)
			System.out.println("<< Data inserted Successfully. >>");
		else
			System.out.println("<< Data didn't insert successfully >>");
		
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
