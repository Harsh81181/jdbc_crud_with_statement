package com.jspider.jdbc_crud_with_statement.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateStudentsQuery {
public static void main(String[] args) {
	Connection connection=null;
	Statement statement=null;
	try {
		//1
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//2
		String url="jdbc:mysql://localhost:3306/mydb";
		String name="root";
		String pass="Ha@210903";
		connection= DriverManager.getConnection(url,name,pass);
		System.out.println(connection);
		
		//3
		statement=connection.createStatement();
		String update_student_query="update students set name='Harsh' where id = 3";
		
		//4
		int u=statement.executeUpdate(update_student_query);
		if(u==1)
			System.out.println("<< Data updated successfully >>");
		else
			System.out.println("Data not found or data not updated");
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		//5
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
