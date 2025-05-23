CREATE DATABASE IF NOT EXISTS blogs_data;
USE blogs_data;

CREATE TABLE users (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  email VARCHAR(100) UNIQUE,
  password VARCHAR(255)
);

CREATE TABLE blogs (
  id INT PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(200) NOT NULL,
  content TEXT NOT NULL,
  image_path VARCHAR(255),
  author_id INT NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (author_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE comments (
  id INT AUTO_INCREMENT PRIMARY KEY,
  content TEXT NOT NULL,
  user_id INT,
  blog_id INT,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
  FOREIGN KEY (blog_id) REFERENCES blogs(id) ON DELETE CASCADE
);

SELECT * FROM users;
SELECT * FROM blogs;
SELECT * FROM comments;