package com.customer.jdbc_crud_with_statement.controller;

import java.util.Scanner;

public class Driver {
public static void main(String[] args) {
	Scanner sc =new Scanner(System.in);
	char c;
	do {
	System.out.println("Enter your choice:-\n1.Insert \n2.Update\n3.Delete\n4.DisplayAll\n5.DisplayByID");
	int n=sc.nextInt();
	switch (n) {
	case 1: {
		InsertCustomer.insertCustomer();
		break;
	}
	case 2:{
		UpdateCustomer.updateCustomer();
		break;
	}
	case 3:{
		DeleteCustomer.deleteCustomer();
		break;
	}
	case 4:{
		DisplayAllCustomer.displayAll();
		break;
	}
	case 5:{
		DisplayByIDCustomer.display();
		break;
	}
	default:{
		throw new IllegalArgumentException("Unexpected value: " + n);}
	}
	System.out.println("\ndo you want more operation \npress Y/y for continue.");
	c=sc.next().charAt(0);
	}while(c=='Y' ||c=='y');
	sc.close();
}
}
