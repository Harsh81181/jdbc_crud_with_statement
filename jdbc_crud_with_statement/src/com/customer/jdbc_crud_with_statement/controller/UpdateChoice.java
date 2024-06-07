package com.customer.jdbc_crud_with_statement.controller;

import java.util.Scanner;
public class UpdateChoice {
public static String update() {
	Scanner sc=new Scanner(System.in);
	System.out.println("What you want to update:-");
	System.out.println("Press 1 for update Name");
	System.out.println("Press 2 for update emailid");
	System.out.println("Press 3 for update phone");
	int n=sc.nextInt();
	System.out.print("Enter your id:- ");
	int k=sc.nextInt();
	switch (n) {
	case 1: {
		System.out.println("Enter your new name:- ");
		return "update customer set name = '"+sc.next()+"'where id="+k;
	}
	case 2:{
		System.out.println("Enter your new emailid:- ");
		return "update customer set email = '"+sc.next()+"'where id="+k;
		}
	case 3:{
		System.out.println("Enter your new phone number:- ");
		return "update customer set phone = '"+sc.next()+"'where id="+k;
	}
	default:
		throw new IllegalArgumentException("Unexpected value: " + n);
	}
}
}
