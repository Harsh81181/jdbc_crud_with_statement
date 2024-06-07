package com.jspider.jdbc_crud_with_statement.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadStudentsQuery {
public static void main(String[] args) {
	Connection connection=null;
	Statement statement=null;
	ResultSet result_set=null;
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306/mydb";
		String user="root";
		String pass="Ha@210903";
		connection= DriverManager.getConnection(url, user, pass);
		
		statement=connection.createStatement();
		String read_students_query="select * from students";
		
		result_set = statement.executeQuery(read_students_query);
		while(result_set.next()) {
			System.out.println(result_set.getInt("id")+
					"\t"+result_set.getString("name")+
					"\t"+result_set.getString("emalid")+
					"\t"+ result_set.getString("phonenum")+
					"\t"+result_set.getString("dob"));
		}
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		try {
			connection.close();
			statement.close();
			result_set.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
}
