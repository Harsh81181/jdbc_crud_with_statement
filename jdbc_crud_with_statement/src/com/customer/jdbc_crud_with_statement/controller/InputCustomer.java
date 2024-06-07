package com.customer.jdbc_crud_with_statement.controller;
import java.util.Scanner;
public class InputCustomer {
public static String inputId() {
	Scanner sc=new Scanner(System.in);
	System.out.print("Enter customer ID:- ");
	return sc.next();
}
public static String inputName() {
	Scanner sc=new Scanner(System.in);
	System.out.print("Enter customer Name:- ");
	return sc.next();
}
public static String inputEmailid() {
	Scanner sc=new Scanner(System.in);
	System.out.print("Enter customer emailid:- ");
	return sc.next();
}
public static String inputPhone() {
	Scanner sc=new Scanner(System.in);
	System.out.print("Enter customer Phone number:- ");
	return sc.next();
}
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
		System.out.print("Enter your new name:- ");
		String name=sc.next();
		return "update customer set name = '"+name+"'where id="+k;
	}
	case 2:{
		System.out.print("Enter your new emailid:- ");
		String email=sc.next();
		return "update customer set email = '"+email+"'where id="+k;
		}
	case 3:{
		System.out.print("Enter your new phone number:- ");
		long num=sc.nextLong();
		return "update customer set phone = '"+num+"'where id="+k;
	}
	default:
		throw new IllegalArgumentException("Unexpected value: " + n);
	}
}
}
