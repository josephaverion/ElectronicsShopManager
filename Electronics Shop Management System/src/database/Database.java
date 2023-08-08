package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import customJComponent.TableActionCellEditor;
import customJComponent.TableActionCellRender;
import customJComponent.TableActionEvent;
import net.proteanit.sql.DbUtils;

import screen.CategoryPanel;

public class Database {
	public static Connection con;
	private static Statement st;
	private static PreparedStatement pst;
	private static ResultSet rs;
	private static ResultSetMetaData rsmd;
	public static void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "password");
			System.out.println("connected!");
		} catch (ClassNotFoundException ex) {
			System.out.println("error!");
		} catch (SQLException ex) {
			System.out.println("error!");
		}
	}
	
/* old hardcored version of adding to a category
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
*/
	// add parameter of how table name, arraylist of column names and arraylist of variables to add
	
	
	// work on making this work for any panel
	public static void editCategory(String cname, String cavailible, int cId) {
		try {
			pst = con.prepareStatement("UPDATE categories set category_name = ?, category_availability = ? WHERE category_id = ?");
			pst.setString(1, cname);
			pst.setString(2, cavailible);
			pst.setInt(3, cId);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// work on making this work for any panel
	public static void deleteCategory(int cId) {
		try {
			pst = con.prepareStatement("DELETE FROM categories WHERE category_id = ?");
			pst.setInt(1, cId);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// work on making this work for any panel
	public static String[] getCategory(String cId) {

		try {
			pst = con.prepareStatement("SELECT category_name,category_availability FROM categories WHERE category_id = ?");
			pst.setString(1, cId);
			rs = pst.executeQuery();

			String[] data = {"", ""};

			if (rs.next() == true)
			{
				data[0] = rs.getString(1);
				data[1] = rs.getString(2);
			} 
			System.out.println(rs);
			return data;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void addEntry(String[] columns, ArrayList<Object> toAdd, String tableName) {
		try {
			String columnNames = "";
			String questionmarks = "";
			for(int i = 0; i < columns.length; i++) {
				columnNames = columnNames + columns[i];
				questionmarks = questionmarks + "?";
				if (i != columns.length - 1) {
					columnNames = columnNames + ",";
					questionmarks = questionmarks + ",";
				}
			}
			pst = con.prepareStatement("INSERT INTO " + tableName + "(" + columnNames + ") VALUES (" + questionmarks + ")" );
			for (int i = 0; i < toAdd.size(); i++) {
				if(toAdd.get(i).getClass().equals(String.class)) {
					pst.setString(i+1, (String) toAdd.get(i));
				} else if (toAdd.get(i).getClass().equals(Integer.class)) {
					pst.setInt(i+1, (Integer) toAdd.get(i));
				}
			}
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
//	public static void editEntry(String[] columns, )

	public static void refreshTables(DefaultTableModel model) {
		try {
			pst = con.prepareStatement("SELECT * FROM categories");
			rs = pst.executeQuery();
			rsmd = rs.getMetaData();
			
			int cols = rsmd.getColumnCount();
			
			Object[] toUpdate = new Object[cols];
			
			while(rs.next()) {
				for(int i = 0; i < cols; i++) {
					System.out.println(rsmd.getColumnClassName(i+1));
					if(rsmd.getColumnClassName(i+1).equals("java.lang.String")) {
						System.out.println("here");
						toUpdate[i] = rs.getString(i+1);
					} else if (rsmd.getColumnClassName(i+1).equals("java.lang.Integer")) {
						System.out.println("here");
						toUpdate[i] = rs.getInt(i+1);
					}
				}
				System.out.println(Arrays.toString(toUpdate));
				model.addRow(toUpdate);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
