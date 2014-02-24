package org.elsys.JDBCHomework;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Second {

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
		Statement stms = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = stms.executeQuery("SELECT address FROM customer WHERE address='dba'");
		rs.next();
		rs.updateString("address","Foldgers");
		rs.updateRow();
		System.out.println(rs.getString("address"));
		con.close();

	}
}
