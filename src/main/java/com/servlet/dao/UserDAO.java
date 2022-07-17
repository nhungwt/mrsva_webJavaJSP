package com.servlet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.servlet.model.User;

public class UserDAO extends ConnectionDB{
	static Connection con = ConnectionDB.getConection();
	public static ArrayList<User> getAll(){
		ArrayList<User> arr = new ArrayList<>();
		String sql = "SELECT * FROM `user`";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				User u = new User(rs.getString("username"), rs.getString("pass"));
				arr.add(u);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		return arr;
	}
	
	public static String addUser(User u) {
		String sql = "INSERT INTO `user` VALUES (?,?)";
//		Connection con = ConnectionDB.getConection();
		String inform = "";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPass());
			
			if(ps.executeUpdate()==0) {
				inform = "Nothing!";
			}else {
				inform = "Add sucssecfully!";
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			inform = "Add error!";
			System.out.println(e);
		}
		return inform;
	}
	
	
	public static User getUserByUsername(String username) {
		String sql = "SELECT * FROM `user` WHERE username=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				User u = new User(rs.getString("username"), rs.getString("pass"));
				return u;
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}
	
	public static void deleteUser(String username) {
		String sql = "DELETE FROM `user` WHERE username=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	public static void editUser(User u) {
		String sql = "UPDATE `user` SET `pass`=? WHERE username=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, u.getPass());
			ps.setString(2, u.getUsername());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
//	public static void main(String[] args) {
//		UserDAO u = new UserDAO();
//		ArrayList<User> arr = u.getAll();
//		System.out.println(arr.get(0).getUsername());
//	}
}
