package com.customer.jdbc_crud_with_statement.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DisplayAllCustomer {
	public static void displayAll() {
		Connection connection =null;
		Statement statement =null;
		try{
			//step-1 for load/register driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//step-2 for connection
			//url should be in "jdbc:mysql://localhost:3306/Database_Name" formate
			String url="jdbc:mysql://localhost:3306/firstassignment";
			String user="root";
			String pass="Ha@210903";
			
			connection=DriverManager.getConnection(url, user, pass);
			
			//step-3 create statement
			statement= connection.createStatement();
			String display_customer_query="select * from customer";
			
			//step-4 execute query
			ResultSet resultSet= statement.executeQuery(display_customer_query);
			while(resultSet.next()) {
				System.out.println("\n"+resultSet.getInt("id")+
									"\t"+resultSet.getString("name")+
									"\t"+resultSet.getString("email")+
									"\t"+resultSet.getLong("phone"));
			
		}
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
