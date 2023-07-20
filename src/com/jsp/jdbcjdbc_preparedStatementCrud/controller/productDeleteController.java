package com.jsp.jdbcjdbc_preparedStatementCrud.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class productDeleteController {

	
	public static void main(String[] args) {
		
		Connection connection=null;
		
		try {
			
//		step-1 create load/Register Driver
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//step-2 Create Connection
		
		String url="jdbc:mysql://localhost:3306/jdbc-preparedstatement";
		String user="root";
		String pass="root";
		
		connection=DriverManager.getConnection(url,user,pass);
		
		String deleteUpdateQuery="delete from product  where productid=?";
		
		PreparedStatement preparedStatement=connection.prepareStatement(deleteUpdateQuery);
			
		preparedStatement.setInt(1,100);
		
		int a=preparedStatement.executeUpdate();
		    
        if(a==1) {
			
			System.out.println("Data is deleted");
		}
		else {
			System.out.println("Given data is not presenet");
		}
	   
		
		}
		
		catch(Exception e) {
			e.printStackTrace();
			
		}
	
	}
	
	
}
