package com.jsp.jdbcjdbc_preparedStatementCrud.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class productDisplayController {

	public static void main(String[] args) {
		
		Connection connection=null;
		
	    try {
	 	   // step-1 load/register Driver
	 	   
	 	   Class.forName("com.mysql.cj.jdbc.Driver");
	 	   
	 	   
	 	   // step-2 create connection
	 	   
	 	 String url="jdbc:mysql://localhost:3306/jdbc-preparedstatement";
	 	 String user="root";
	 	 String pass="root";
	 	 
	 	 // throw execption i.e Checked Exception
		 
		 connection=DriverManager.getConnection(url, user, pass); 
		 
		 
	                // 3.create statement
		 
		 String displayQuery="select * from product";
		 
		 PreparedStatement PreparedStatement=connection.prepareStatement(displayQuery);  
		 
		        //4.Excute Query
		 
		 ResultSet resultSet=PreparedStatement.executeQuery();
		 
		 while(resultSet.next()) {
			 
			 int id=resultSet.getInt("productid");
			 
			 String name=resultSet.getString("productname");
			 double price=resultSet.getDouble("productprice");
			 
			 String color=resultSet.getString("productcolor");
			 
			 System.out.println(resultSet.next());
			 System.out.println("id="+id);
			 System.out.println("name="+name);
			 System.out.println("price="+price);
			 System.out.println("color="+color);
			 
			 System.out.println("#########################################");
			   
			 System.out.println("");
			 
		 }
		 
		 
		 System.out.println("Data---stored and data Dispaly");	
	    }
	    
	    
	catch(ClassNotFoundException |SQLException e) {
		  
		   e.printStackTrace();
		   
	}
	    
	    finally {
	    	try {
	    		connection.close();
	    	}
	    	catch(SQLException e) {
	    		e.printStackTrace();
	    	}
	    }
	}
	
	
	
	
}
