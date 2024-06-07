package com.jspider.jdbc_crud_with_statement.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteStudentController {
public static void main(String[] args) {
	Connection connection=null;
	Statement statement=null;
	
	try {
		//step-1 Load Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//step-2 Establish connection
		String url="jdbc:mysql://localhost:3306/mydb";
		String user="root";
		String pass="Ha@210903";
		connection= DriverManager.getConnection(url, user, pass);
		System.out.println(connection);
		
		//step-3 create statement
		statement= connection.createStatement();
		//In operator is not supported in mysql instead of =
		String delete_query_student ="delete from students where id = 4";
		
		//step-4 execute query
		int d=statement.executeUpdate(delete_query_student);
		if(d==1)
			System.out.println("<< Data Deleted Successfully >>");
		else
			System.out.println("Data did not delete.");
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		//step-5 close connection and statement
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
