package com.jspider.jdbc_crud_with_statement.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertStudentController {
	//step-1 load/register driver
	//control+shift+t :--->for view the class,packages then control+o for view method of that class
public static void main(String[] args) {
	Connection connection=null;
	Statement statement=null;
	
	try {
		//step-1 for load/register driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//step-2 for connection
		//url should be in "jdbc:mysql://localhost:3306/Database_Name" formate
		String url="jdbc:mysql://localhost:3306/mydb";
		String user="root";
		String pass="Ha@210903";
		
		connection=DriverManager.getConnection(url, user, pass);
		System.out.println(connection);
		
		//step-3 create statement
		statement= connection.createStatement();
		String insert_student_query="insert into students values(4,'manish','manish12321@gmail.com',7896541236,'2024-02-07')";
		
		//step-4 execute query
		boolean i = statement.execute(insert_student_query);
		if(i)
			System.out.println("Data stored successfully into database.");
		else
			System.out.println("Data did not store.");
	}
	catch(ClassNotFoundException | SQLException e){
		e.printStackTrace();
	}
	
		//step-5 close connection
	finally {
		try {
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
}
