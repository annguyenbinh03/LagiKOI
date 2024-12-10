CREATE DATABASE IF NOT EXISTS lagikoi;

USE lagikoi;

CREATE TABLE roles (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    role_name VARCHAR(50) NOT NULL UNIQUE,
    is_deleted BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE user (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    full_name VARCHAR(255),
    phone_number VARCHAR(15),
    created_at DATETIME,
    is_deleted BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE user_roles (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    role_id INT NOT NULL,
    is_deleted BOOLEAN DEFAULT FALSE,    
    FOREIGN KEY (user_id) REFERENCES user(id),
    FOREIGN KEY (role_id) REFERENCES roles(id)
);

CREATE TABLE products (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2) NOT NULL,
    stock INT NOT NULL,
    created_at DATETIME NOT NULL
);

CREATE TABLE orders (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    customer_id INT NOT NULL,
    total_price DECIMAL(10, 2) NOT NULL,
    status ENUM('pending', 'completed', 'cancelled') NOT NULL,
    created_at DATETIME NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES user(id)
);

CREATE TABLE order_items (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    product_type ENUM('fish', 'accessories', 'services') NOT NULL,
    quantity INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders(id)
);

CREATE TABLE blogs (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title NVARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    image_url TEXT NOT NULL,
    created_at DATETIME NOT NULL,
    author INT NOT NULL,
    is_deleted BOOLEAN DEFAULT FALSE,    
    FOREIGN KEY (author) REFERENCES user(id)
);

CREATE TABLE koi_fish_category (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    is_deleted BOOLEAN DEFAULT FALSE  
);

CREATE TABLE koi_fish (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    product_id INT NOT NULL,
    category_id INT NOT NULL,
    age VARCHAR(15) NOT NULL,
    gender VARCHAR(10) NOT NULL,
    size VARCHAR(50) NOT NULL,
    farm_name VARCHAR(255) NOT NULL,
    view_count INT NOT NULL,
    is_deleted BOOLEAN DEFAULT FALSE,    
    FOREIGN KEY (product_id) REFERENCES products(id),
    FOREIGN KEY (category_id) REFERENCES koi_fish_category(id)
);

CREATE TABLE koi_fish_image_urls (
	id INT AUTO_INCREMENT PRIMARY KEY,
    fish_id INT,
    image_url TEXT NOT NULL,
    display_order INT,
    is_deleted BOOLEAN DEFAULT FALSE,    
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (fish_id) REFERENCES koi_fish(id) 
);

CREATE TABLE koi_accessories_category (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    is_deleted BOOLEAN DEFAULT FALSE
);

CREATE TABLE koi_accessories (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    product_id INT NOT NULL,
    category_id INT NOT NULL,
    image_urls TEXT NOT NULL,
    brand VARCHAR(50) NOT NULL,
    view_count INT NOT NULL,
    FOREIGN KEY (product_id) REFERENCES products(id),
    FOREIGN KEY (category_id) REFERENCES koi_accessories_category(id)
);

CREATE TABLE koi_pond_services (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    product_id INT NOT NULL,
    image_urls TEXT NOT NULL,
    duration_estimate VARCHAR(50) NOT NULL,
    view_count INT NOT NULL,
    is_deleted BOOLEAN DEFAULT FALSE,    
    FOREIGN KEY (product_id) REFERENCES products(id)
);

INSERT INTO products (name, description, price, stock, created_at) VALUES
('Koi Fish A', 'A beautiful red and white koi fish', 100.00, 10, NOW()),
('Koi Fish B', 'A stunning yellow koi fish', 150.00, 15, NOW()),
('Koi Fish C', 'A rare black koi fish with orange spots', 200.00, 20, NOW());

INSERT INTO koi_fish_category (name, description) VALUES
('SIRO', 'A category of koi known for their white body color with minimal markings.'),
('SHOWA', 'A type of koi with black, red, and white coloring.'),
('KOHAKU', 'A classic koi with red and white colors, one of the most popular varieties.');

INSERT INTO koi_fish (product_id, category_id, age, gender, size, farm_name, view_count) VALUES
(1, 1, '2 years', 'Male', 'Medium', 'Koi Farm A', 100),
(2, 2, '3 years', 'Female', 'Large', 'Koi Farm B', 150),
(3, 3, '1 year', 'Male', 'Small', 'Koi Farm C', 200);

INSERT INTO koi_fish_image_urls (fish_id, image_url, display_order, is_deleted, created_at) VALUES
(1, 'https://example.com/images/koi_fish_a_1.jpg', 1, FALSE, NOW()),
(1, 'https://example.com/images/koi_fish_a_2.jpg', 2, FALSE, NOW()),
(2, 'https://example.com/images/koi_fish_b_1.jpg', 1, FALSE, NOW()),
(2, 'https://example.com/images/koi_fish_b_2.jpg', 2, FALSE, NOW()),
(2, 'https://example.com/images/koi_fish_b_3.jpg', 3, FALSE, NOW()),
(3, 'https://example.com/images/koi_fish_c_1.jpg', 1, FALSE, NOW());


