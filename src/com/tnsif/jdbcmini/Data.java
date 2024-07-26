package com.tnsif.jdbcmini;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Data {
  
	private static String url="jdbc:mysql://localhost:3306/jdbcmini";
	private static  String username= "root";
	private static String password="Varsha@20";
	
	public static void showData()throws SQLException{
		
		Connection connection = DriverManager.getConnection(url,username,password);
		
		Statement statement= connection.createStatement();
		
		String query ="Select*from EM ";
		
		ResultSet result =statement.executeQuery(query);
		
		 while(result.next()) {
		System.out.println("Name: "+ result.getString(1));
		System.out.println("Id:"+ result.getInt(2));
		System.out.println("Salary: "+ result.getInt(3));
		System.out.println("Location: "+ result.getString(4));
		System.out.println("Designation: "+ result.getString(5));
		 }
		
		connection.close();
	}
	
	public static void deleteData()throws SQLException {
		Scanner sc= new Scanner(System.in);
		System.out.println("enter the id to delete");
		int del=sc.nextInt();
		String query ="delete from EM where id ="+ del;
        Connection connection = DriverManager.getConnection(url,username,password);
		Statement statement= connection.createStatement();
		int rows=statement.executeUpdate(query);
		System.out.println("Number of rows affected="+ rows);
		connection.close();

	}
	
	public static void insertData() throws SQLException{
		
		Scanner sca = new Scanner(System.in);
		System.out.println("enter the employee name to insert");
		String empname = sca.next();
		System.out.println(" enter the employee id to insert");
		int empid = sca.nextInt();
		sca.nextLine();
		System.out.println("enter the emloyee salary to insert");
		int empsalary= sca.nextInt();
		System.out.println("enter the employe locationn to insert");
		String emploc=sca.next();
		System.out.println("enter the employee designation to insert");
		String empdesi= sca.next();
		String query= "insert into EM values('"+empname+"',"+empid+","+empsalary+",'"+emploc+"','"+empdesi+"')";
		Connection connection = DriverManager.getConnection(url,username,password);
		Statement statement= connection.createStatement();
		int rows=statement.executeUpdate(query);
		System.out.println("Number of rows affected="+ rows);
		connection.close();
	}
	
	public static void updateData() throws SQLException{
		
		int id,value;
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter the employee id to update");
		id=scanner.nextInt();
		System.out.println("updated column is :"+id);
		Connection connection = DriverManager.getConnection(url,username,password);
		Statement statement= connection.createStatement();
		while(id!=0) {
			
			System.out.println("to update all column enter 1 otherwise 0");
			value=scanner.nextInt();
			if(value==1) {
				
				System.out.println("enter the employe name to update");
				String name=scanner.next();
				System.out.println("enter the employee salary to update");
				int salary=scanner.nextInt();
				scanner.nextLine();
				System.out.println("enter the employe location to update");
				String loc=scanner.next();
				System.out.println("enter the employe designation to update");
				String desi=scanner.next();
				String query ="update EM set salary ='"+salary+"'where id="+id;
				String quer ="update EM set designation ='"+desi+"'where id="+id;
				String que ="update EM set location ='"+loc+"'where id="+id;
				String qu ="update EM set name ='"+name+"'where id="+id;
			}
			else {
				
				String column;
				System.out.println("which column to be updated");
				column=scanner.next();
				
				
				switch(column) {
				
				case "name":
					System.out.println("enter the employe name for updation");
					String name = scanner.next();
					String qu ="update EM set name ='"+name+"'where id="+id;
					int r= statement.executeUpdate(qu);
					break;
					
					
				case "salary":
					System.out.println("enter the employe salary for updation");
					int salary = scanner.nextInt();
					String query ="update EM set salary ='"+salary+"'where id="+id;
					int ro= statement.executeUpdate(query);
					break;
					
				case "location":
					System.out.println("enter the employe location for updation");
					String loc = scanner.next();
					String que ="update EM set location ='"+loc+"'where id="+id;
					int row= statement.executeUpdate(que);
					break;
					
				case "designation":
					System.out.println("enter the employe designation for updation");
					String desi = scanner.next();
					String quer ="update EM set designation ='"+desi+"'where id="+id;
					int rows= statement.executeUpdate(quer);
					break;
					
				}
				
			}
			break;
		}
}
}