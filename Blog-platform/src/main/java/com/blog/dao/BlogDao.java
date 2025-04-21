package com.blog.dao;

import com.blog.model.Blog;
import java.sql.*;
import java.util.*;

public class BlogDao {
    private Connection conn;

    public BlogDao(Connection conn) {
        this.conn = conn;
    }

    public boolean addBlog(Blog blog) {
        boolean success = false;
        String sql = "INSERT INTO blogs (title, content, image_path, author_id, created_at) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, blog.getTitle());
            ps.setString(2, blog.getContent());
            ps.setString(3, blog.getImagePath());
            ps.setInt(4, blog.getAuthorId());
            ps.setTimestamp(5, blog.getCreatedAt());

            int result = ps.executeUpdate();
            success = result > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL Exception: " + e.getMessage());
        }

        return success;
    }

    public List<Blog> getAllBlogs() {
        List<Blog> list = new ArrayList<>();
        String sql = "SELECT b.*, u.name as author_name FROM blogs b JOIN users u ON b.author_id = u.id ORDER BY b.created_at DESC";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Blog blog = new Blog();
                blog.setId(rs.getInt("id"));
                blog.setTitle(rs.getString("title"));
                blog.setContent(rs.getString("content"));
                blog.setImagePath(rs.getString("image_path"));
                blog.setAuthorId(rs.getInt("author_id"));
                blog.setAuthorName(rs.getString("author_name"));
                blog.setCreatedAt(rs.getTimestamp("created_at"));
                list.add(blog);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public Blog getBlogById(int id) {
        Blog blog = null;
        String sql = "SELECT b.*, u.name AS author_name FROM blogs b LEFT JOIN users u ON b.author_id = u.id WHERE b.id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                blog = new Blog();
                blog.setId(rs.getInt("id"));
                blog.setTitle(rs.getString("title"));
                blog.setContent(rs.getString("content"));
                blog.setAuthorId(rs.getInt("author_id"));
                blog.setAuthorName(rs.getString("author_name"));
                blog.setCreatedAt(rs.getTimestamp("created_at"));
                blog.setImagePath(rs.getString("image_path")); 
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return blog;
    }

    public List<Blog> getBlogsByUser(int userId) {
        List<Blog> list = new ArrayList<>();
        String sql = "SELECT b.*, u.name as author_name FROM blogs b JOIN users u ON b.author_id = u.id WHERE b.author_id = ? ORDER BY b.created_at DESC";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Blog blog = new Blog();
                blog.setId(rs.getInt("id"));
                blog.setTitle(rs.getString("title"));
                blog.setContent(rs.getString("content"));
                blog.setImagePath(rs.getString("image_path"));
                blog.setAuthorId(rs.getInt("author_id"));
                blog.setAuthorName(rs.getString("author_name"));
                blog.setCreatedAt(rs.getTimestamp("created_at"));
                list.add(blog);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
