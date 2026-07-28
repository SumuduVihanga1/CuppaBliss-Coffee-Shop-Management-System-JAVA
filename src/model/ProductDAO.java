package model;

import database.*;
import java.sql.*;
import java.util.ArrayList;

public class ProductDAO {

    public void addProduct(Product p) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO products(name, category, price, quantity) VALUES(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, p.getName());
            ps.setString(2, p.getCategory());
            ps.setDouble(3, p.getPrice());
            ps.setInt(4, p.getQuantity());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Product> getAllProducts() {
        ArrayList<Product> list = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM products");

            while (rs.next()) {
                list.add(new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("category"),
                        rs.getDouble("price"),
                        rs.getInt("quantity")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<Product> searchProduct(String keyword) {
        ArrayList<Product> list = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM products WHERE name LIKE ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("category"),
                        rs.getDouble("price"),
                        rs.getInt("quantity")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<Product> getLowStockProducts(int limit) {
        ArrayList<Product> list = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM products WHERE quantity < ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, limit);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("category"),
                        rs.getDouble("price"),
                        rs.getInt("quantity")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateProduct(Product p) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "UPDATE products SET name=?, category=?, price=?, quantity=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, p.getName());
            ps.setString(2, p.getCategory());
            ps.setDouble(3, p.getPrice());
            ps.setInt(4, p.getQuantity());
            ps.setInt(5, p.getId());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteProduct(int id) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "DELETE FROM products WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
