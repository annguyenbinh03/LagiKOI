USE lagikoi;

INSERT INTO product ( id, name, description, price, stock, created_at) VALUES
('394fe8e7-e9bd-4847-81ce-7360fabb08b1', 'Koi Fish A', 'A beautiful red and white koi fish', 3000000, 1, NOW()),
('f8946ef4-2a93-4824-9d98-34b562655268', 'Koi Fish B', 'A stunning yellow koi fish', 7000000, 1, NOW()),
('e9375127-0bb0-47bc-a99c-e1d75065c157','Koi Fish C', 'A rare black koi fish with orange spots', 10000000, 1, NOW()),
('a1508392-bfbc-4a6b-8242-1634b4fb4ce7', 'Cám Bio Koi Growth & Color', 'BIO KOI FOOD được sản xuất theo công nghệ của Mỹ với độ dậm 42%', 350000, 10, NOW()),
('4b46f9ff-d875-4613-a00a-ce61732adfb3', 'Đèn Âm Nước Jebao GL13', 'Chiếu sáng non bộ, bể cá Có thể đặt ngoài trời hoặc ngâm trong nước', 550000, 15, NOW()),
('cb214502-03ea-47ea-9e6d-c7f4457989de','Máy sủi Oxy SUNSUN YT-818', 'Máy sủi tích điện dành cho bể cá lớn được tặng kèm một đầu chia bằng nhựa đường khí phi 4mm.', 800000, 15, NOW());

INSERT INTO fish_category (name, description) VALUES
('SIRO', 'A category of koi known for their white body color with minimal markings.'),
('SHOWA', 'A type of koi with black, red, and white coloring.'),
('KOHAKU', 'A classic koi with red and white colors, one of the most popular varieties.');

INSERT INTO accessory_category (id, name, description, is_deleted) VALUES 
( 1, 'Thức ăn', 'Cám cá koi', false),
( 2, 'Đèn Âm Nước', 'Chiếu sáng non bộ, bể cá Có thể đặt ngoài trời hoặc ngâm trong nước', false),
( 3, 'Máy sủi Oxy', 'Thổi khí Cung cấp oxi hồ cá koi trong chăn nuôi thủy sản, các bể vi sinh hiếu khí, thu hồi khí Biogas, sục khí lòng hồ, ngăn chặn phân hủy kị khí', false);

INSERT INTO fish (product_id, category_id, age, gender, size, farm_name, view_count, is_deleted) VALUES
('394fe8e7-e9bd-4847-81ce-7360fabb08b1', 1, '2 years', 'Male', 'Medium', 'Koi Farm A', 0, false),
('f8946ef4-2a93-4824-9d98-34b562655268', 2, '3 years', 'Female', 'Large', 'Koi Farm B', 0, false),
('e9375127-0bb0-47bc-a99c-e1d75065c157', 3, '1 year', 'Male', 'Small', 'Koi Farm C', 0, false);


INSERT INTO accessory (product_id, id, brand, view_count, category_id, is_deleted ) VALUES
('a1508392-bfbc-4a6b-8242-1634b4fb4ce7', 1, 'Growth & Color', 0, 1, false),
('4b46f9ff-d875-4613-a00a-ce61732adfb3', 2, 'Jebao GL13', 0, 2, false),
('cb214502-03ea-47ea-9e6d-c7f4457989de', 3, 'SUNSUN', 0, 3, false);

INSERT INTO product_image (product_id, image_url, display_order, is_deleted, created_at) VALUES
('394fe8e7-e9bd-4847-81ce-7360fabb08b1', 'https://example.com/images/koi_fish_a_1.jpg', 1, FALSE, NOW()),
('394fe8e7-e9bd-4847-81ce-7360fabb08b1', 'https://example.com/images/koi_fish_a_2.jpg', 2, FALSE, NOW()),
('f8946ef4-2a93-4824-9d98-34b562655268', 'https://example.com/images/koi_fish_b_1.jpg', 1, FALSE, NOW()),
('f8946ef4-2a93-4824-9d98-34b562655268', 'https://example.com/images/koi_fish_b_2.jpg', 2, FALSE, NOW()),
('f8946ef4-2a93-4824-9d98-34b562655268', 'https://example.com/images/koi_fish_b_3.jpg', 3, FALSE, NOW()),
('e9375127-0bb0-47bc-a99c-e1d75065c157', 'https://example.com/images/koi_fish_c_1.jpg', 1, FALSE, NOW()),
('a1508392-bfbc-4a6b-8242-1634b4fb4ce7', 'https://example.com/images/bio koi.jpg', 1, FALSE, NOW()),
('4b46f9ff-d875-4613-a00a-ce61732adfb3', 'https://example.com/images/jebao gl13.jpg', 1, FALSE, NOW()),
('cb214502-03ea-47ea-9e6d-c7f4457989de', 'https://example.com/images/sun sun yt18.jpg', 1, FALSE, NOW());

INSERT INTO role (name, description) VALUES
('USER', 'user description'),
('ADMIN', "admin description"),
('MANAGER', 'manager description');

INSERT INTO permission (name, description) VALUES
('CREATE_FISH', 'create fish permission'),
('GET_USERS', 'get all user permission'),
('GET_FISH_CATEGORY', 'get all fish categories'),
('CREATE_FISH_CATEGORY', 'crate fish category permission'),
('CREATE_ACCESSORY', 'create accessory permission'),
('DELETE_ACCESSORY', 'delete accessory permission');

INSERT INTO role_permission (role_name, permission_name) VALUES
('ADMIN', 'CREATE_FISH'),
('ADMIN', 'GET_USERS'),
('ADMIN', 'CREATE_FISH_CATEGORY'),
('MANAGER', 'CREATE_FISH_CATEGORY'),
('ADMIN', 'CREATE_ACCESSORY'),
('ADMIN', 'DELETE_ACCESSORY'),	
('MANAGER', 'CREATE_ACCESSORY'),
('MANAGER', 'DELETE_ACCESSORY'),
('USER', 'GET_FISH_CATEGORY');

INSERT INTO user (id, username, password, is_deleted) VALUES
('ab3bcd2e-54e0-4fae-a07e-19d7152e65e5', 'user', '$2b$10$2EkiZ6bovfh.eB0Nw3ONnOCLlupBQxek31WhR1DH8TJKa6Z.DVzXi', false), #user1234
('06ff0bfd-c2ff-401c-a33c-58a3e0799651', 'admin','$2b$10$ABEROdTJf2asJT8BUvO43uJ6h49vqPHWsN8j5mqKTP0fYi4h7dF6m', false), #admin123
('95ed93cb-868a-4a05-b8e5-556833209e3b', 'manager', '$2b$10$H32LWplgauc3Q2xOK27ETO1fjhVZ9hl8/WSG/.9KG2bwxsAE/xv6i', false); #manager1

INSERT INTO user_role (role_name, user_id) VALUES
('USER', 'ab3bcd2e-54e0-4fae-a07e-19d7152e65e5'),
('ADMIN', '06ff0bfd-c2ff-401c-a33c-58a3e0799651'),
('MANAGER', '95ed93cb-868a-4a05-b8e5-556833209e3b');

