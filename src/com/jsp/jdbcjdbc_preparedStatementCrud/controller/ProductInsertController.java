	package com.jsp.jdbcjdbc_preparedStatementCrud.controller;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ProductInsertController {

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
	 
	 String insertQuery="insert into product values(?,?,?,?)";
	 
                // 3.create statement
	 
	 PreparedStatement PreparedStatement=connection.prepareStatement(insertQuery);
	 
	        //4.Excute Query
	 
	 PreparedStatement.setInt(1, 102);
	 PreparedStatement.setString(2, "pen");
	 PreparedStatement.setDouble(3, 20);
	 PreparedStatement.setString(4,"white");
	 
	 PreparedStatement.execute();
	 System.out.println("Data---stored");	
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





