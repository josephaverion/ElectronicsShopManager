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
			
			pst.setInt(3, cId);
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
	
	public static String[] getEntry(String[] columns, String tableName, String idType, int cId) {
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

			String[] data = {"", ""};

			if (rs.next() == true)
			{
				data[0] = rs.getString(1);
				data[1] = rs.getString(2);
			} 
			return data;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void refreshTables(DefaultTableModel model) {
		try {
			pst = con.prepareStatement("SELECT * FROM categories");
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
