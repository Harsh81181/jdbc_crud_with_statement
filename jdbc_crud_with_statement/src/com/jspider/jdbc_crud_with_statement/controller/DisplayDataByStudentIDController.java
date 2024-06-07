package com.jspider.jdbc_crud_with_statement.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DisplayDataByStudentIDController {
	public static void main(String[] args) {
		Connection connection=null;
		Statement statement=null;
		ResultSet result_set=null;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your id:");
		int id=sc.nextInt();		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306/mydb";
			String user="root";
			String pass="Ha@210903";
			connection= DriverManager.getConnection(url, user, pass);
			
			statement=connection.createStatement();
			
			//object type of data should be in single quotes like 'referenceVariable'
			//if we use in operator then value must be in brackets like (val)
			String read_students_query="select * from students where id in ( "+id+")";
			
			result_set = statement.executeQuery(read_students_query);
			if(result_set.next()) {
				System.out.println("\n"+result_set.getInt("id")+
						"\t"+result_set.getString("name")+
						"\t"+result_set.getString("emailid")+
						"\t"+ result_set.getString("phone")+
						"\t"+result_set.getString("dob"));
			}
			else
				System.out.println("You entered a wrong id");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
				statement.close();
				result_set.close();
				sc.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
