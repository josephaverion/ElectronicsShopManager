package database;

import java.sql.*;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

import screen.CategoryPanel;

public class Database {
	public static Connection con;
	private static Statement st;
	private static PreparedStatement pst;
	private static ResultSet rs;
	
	public static void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "");
			System.out.println("connected!");
		} catch (ClassNotFoundException ex) {
			System.out.println("error!");
		} catch (SQLException ex) {
			System.out.println("error!");
		}
	}
	
	public static void addCategory(String cname, String cavailible) {	
		try {
			pst = con.prepareStatement("INSERT INTO categories(category_name, category_availability) VALUES (?, ?)");
			pst.setString(1, cname);
			pst.setString(2, cavailible);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static String[] getCategory(String cId) {

		try {
			pst = con.prepareStatement("SELECT category_name,category_availability FROM categories WHERE category_id = ?");
			pst.setString(1, cId);
			rs = pst.executeQuery();
			
			String[] data = new String[2];
			
			if (rs.next() == true)
			{
				data[0] = rs.getString(1);
				data[1] = rs.getString(2);
			}
			
			return data;
		} catch (SQLException e) {
			return null;
		}
		
		
		
	}
	
	public static void updateTables() {
		try {
			pst = con.prepareStatement("SELECT * FROM categories");
			rs = pst.executeQuery();
			CategoryPanel.categoryTable.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
