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
	
	public static void addEntry(String[] columns, Object[] toAdd, String tableName) {
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
			for (int i = 0; i < toAdd.length; i++) {
				if(toAdd[i].getClass().equals(String.class)) {
					pst.setString(i+1, (String) toAdd[i]);
				} else if (toAdd[i].getClass().equals(Integer.class)) {
					pst.setInt(i+1, (Integer) toAdd[i]);
				}
			}
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void editEntry(String[] columns, Object[] toEdit, String tableName, String idType, int cId) {
		try {
			String columnNames = "";
			String questionmarks = "";
			for(int i = 0; i < columns.length; i++) {
				columnNames = columnNames + columns[i] + " = ?";
				if (i != columns.length - 1) {
					columnNames = columnNames + ",";
					questionmarks = questionmarks + ",";
				}
			}
			pst = con.prepareStatement("UPDATE " + tableName + " set " + columnNames + " WHERE " + idType + " = ?");

			for (int i = 0; i < toEdit.length; i++) {
				if(toEdit[i].getClass().equals(String.class)) {
					pst.setString(i+1, (String) toEdit[i]);
				} else if (toEdit[i].getClass().equals(Integer.class)) {
					pst.setInt(i+1, (Integer) toEdit[i]);
				}
			}
			
			pst.setInt(toEdit.length+1, cId);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteEntry(String tableName, String idType, int cId, DefaultTableModel model, int row) {
		try {
			pst = con.prepareStatement("DELETE FROM " + tableName + " WHERE " + idType + " = ?");
			pst.setInt(1, cId);
			pst.executeUpdate();
			pst = con.prepareStatement("ALTER TABLE " + tableName + " AUTO_INCREMENT=1"); // if all entries are deleted, automatically starts from 1. probably will change to randomized IDs
			pst.executeUpdate();
			model.removeRow(row);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Object[] getEntry(String[] columns, String tableName, String idType, int cId) {
		try {
			String columnNames = "";
			for (int i = 0; i < columns.length; i++) {
				columnNames = columnNames + columns[i];
				if (i != columns.length - 1) {
					columnNames = columnNames + ",";
				}
			}		
			pst = con.prepareStatement("SELECT " + columnNames + " FROM " + tableName + " WHERE " + idType + " = ?");
			pst.setInt(1, cId);
			rs = pst.executeQuery();

			Object[] data = new Object[columns.length];
			for (int i = 0; i < data.length; i++) {
				data[i] = "";
			}

			if (rs.next() == true)
			{
				for (int i = 0; i < data.length; i++) {
					if(data[i].getClass().equals(String.class)) {
						data[i] = rs.getString(i+1);
					} else if (data[i].getClass().equals(Integer.class)) {
						data[i] = rs.getInt(i+1);
					}
				}
			}

			return data;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String[] getColumn(String tableName, String columnName) {
		try {
			pst = con.prepareStatement("SELECT " + columnName + " FROM " + tableName);
			rs = pst.executeQuery();
			ArrayList<String> data = new ArrayList<String>();
			while (rs.next()) {
				data.add(rs.getString(1));
			}
			return  data.toArray(new String[data.size()]);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// add if you try delete a brand or category where there are still products with quantity then add a popup that there is still product in stock
	// whetever a category or brand gets updated (added or deleted), the jcombobox list in product and order "add" and "edit" panels must be updated
	
	public static void refreshTables(DefaultTableModel model, String tableName) {
		try {
			pst = con.prepareStatement("SELECT * FROM " + tableName);
			rs = pst.executeQuery();
			rsmd = rs.getMetaData();
			
			int cols = rsmd.getColumnCount();
			
			Object[] toUpdate = new Object[cols];
			model.setRowCount(0);
			while(rs.next()) {
				for(int i = 0; i < cols; i++) {
					if(rsmd.getColumnClassName(i+1).equals("java.lang.String")) {
						toUpdate[i] = rs.getString(i+1);
					} else if (rsmd.getColumnClassName(i+1).equals("java.lang.Integer")) {
						toUpdate[i] = rs.getInt(i+1);
					}
				}
				model.addRow(toUpdate);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
