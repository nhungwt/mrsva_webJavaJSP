package com.servlet.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import com.servlet.model.Category;
import com.servlet.model.Product;

public class CategoryDAO extends ConnectionDB{
	static Connection connection = ConnectionDB.getConection();
	
	public CategoryDAO() {
		// TODO Auto-generated constructor stub
	}
	public static ArrayList<Category> getAll() {
		ArrayList<Category> list = new ArrayList<>();
		String sql = "SELECT * FROM `category`";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Category c = new Category(rs.getInt("id"), rs.getString("name"), rs.getString("describe"));
				list.add(c);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return list;
	}
	public static ArrayList<Product> getAllProductById(int id) throws NumberFormatException, ParseException {
		ArrayList<Product> list = new ArrayList<>();
		String sql = "SELECT * FROM `product` WHERE 1=1";
		if(id != 0) sql += " and id="+id;
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			Category c = CategoryDAO.getCategoryById(id);
			while(rs.next()) {
				Product p = new Product(rs.getString("id"), rs.getString("name"), 
						Integer.parseInt(rs.getString("quantity")), Double.parseDouble(rs.getString("price")),
						rs.getString("releaseDate"), rs.getString("describe"),
						rs.getString("image"), c);
				list.add(p);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return list;
	}
	
	
	public static Category getCategoryById(int id) {
		String sql = "SELECT * FROM `category` WHERE id=?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Category c = new Category(rs.getInt("id"), rs.getString("name"), rs.getString("describe"));
				return c;
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}
	
	public static void add(Category c) {
		String sql = "INSERT INTO `category` VALUES (?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, c.getId());
			ps.setString(2, c.getName());
			ps.setString(3, c.getDescribe());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	public static void updateCategory(Category c) {
		String sql = "UPDATE `category` SET `name`=?,`describe`=? WHERE id=?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, c.getName());
			ps.setString(2, c.getDescribe());
			ps.setInt(3, c.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	public static void deleteCategory(int id) {
		String sql = "DELETE FROM `category` WHERE id=?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
//	public static void main(String[] args) {
//		CategoryDAO u = new CategoryDAO();
//		ArrayList<Category> arr = u.getAll();
//		System.out.println(arr.get(0).getId());
//	}
}
