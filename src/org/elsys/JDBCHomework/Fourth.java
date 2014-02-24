package org.elsys.JDBCHomework;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Fourth {

	public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, UnsupportedEncodingException, SQLException {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		Connection con = null;
		PrintWriter writer = new PrintWriter("first.txt", "UTF-8");
		try{
		con = DriverManager.getConnection(
		 "jdbc:derby:C:\\Apache\\bin\\MyDBTest");
		}
		catch(java.sql.SQLException ex){
			
			System.out.println(ex.getMessage() + "\n\n\n" + "Database not found");
			return;
		}
		con.setAutoCommit(false);
		PreparedStatement updateSales;
		String updateString = "update customer " +
		 "SET address = ? WHERE name LIKE ?";
		updateSales = con.prepareStatement(updateString);
		String [] adresses = {"Drujba", "Mladost", "Lqo-Lin", "Slatina", "Iztok"};
		String [] names = {"Gen Urubuchi", "Georgi Kunchev", "Vasil Bozhurski", "Jesus", "ibrahiK"};
		int len = names.length;
		for(int i = 0; i < len; i++) {
		updateSales.setString(1, adresses[i]);
		updateSales.setString(2, names[i]);
		updateSales.executeUpdate();
		con.commit();
		con.setAutoCommit(true);
		 }
	}

}
