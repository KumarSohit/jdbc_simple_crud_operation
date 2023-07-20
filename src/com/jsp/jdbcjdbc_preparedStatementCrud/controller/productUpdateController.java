package com.jsp.jdbcjdbc_preparedStatementCrud.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class productUpdateController {

    public static void main(String[] args) {
	
		   Connection connection=null;
		   
		try {
			   // step-1 Load Register
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// step-2 Create Connection
			
			String url="jdbc:mysql://localhost:3306/jdbc-preparedstatement";
			String user="root";
			String pass="root";
			
			connection =DriverManager.getConnection(url,user,pass);
			
			
//			 step-3 Create Staement
			
			String updateQuery="update product set productcolor=? where productid=?";
			
			PreparedStatement PreparedStatement=connection.prepareStatement(updateQuery);
			
			PreparedStatement.setString(1,"red");
			PreparedStatement.setInt(2, 102);
			
			int a=PreparedStatement.executeUpdate();
			
			if(a==1) {
				
				System.out.println("data is updated");
			}
			else {
				System.out.println("Given data is not present");
			}
		 }
		
		
		catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
       }	
        }
