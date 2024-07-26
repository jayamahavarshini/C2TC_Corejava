package com.tnsif.jdbcmini;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.*;

import java.sql.SQLException;
import java.util.Scanner;


public class Datamain {

	public static void main(String[] args)throws SQLException
	
	{
	 Scanner scan = new Scanner(System.in);
	 
	 System.out.println(" Do you want to make changes press 1 otherwise 0");
	 
	 int ch = scan.nextInt();
	 scan.nextLine();
	 
	 while(ch!=0) {
		 
		 System.out.println(" Declare the operation");
		 String operation=scan.next();
		 switch(operation) {
		 case "show":
			 System.out.println("your data is shown here");
		     Data.showData();
		     break;
		 case "insert":
			 System.out.println("enter the below values to insert");
		     Data.insertData();
		     break;
		 case "delete":
			 System.out.println("enter the id to delete a row");
			 Data.deleteData();
			 break;
		 case "update":
			 System.out.println(" enter the id to update the row");
		     Data.updateData();
		     break;
		  default:
			 System.out.println("declare the valid method");
			 break;}
	 
			 System.out.println("to continue  press 1 otherwise 0");
			 operation=scan.next();
			 break;
	 }
	      System.out.println("Entered 0:no changes needed");
	      System.out.println("The existing table is");
	      Data.showData();
     
 
	 }

}
	
