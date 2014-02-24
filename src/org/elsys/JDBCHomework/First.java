package org.elsys.JDBCHomework;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class First {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException, UnsupportedEncodingException {
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
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery
		 ("SELECT name,address FROM customer");
		while (rs.next()) {
			String name = rs.getString("name");
			String s = rs.getString("address");
			writer.println(name + " | " + s);
			System.out.println(name + " | " + s);
			writer.flush();
		}

	}

}
