USE lagikoi;

INSERT INTO product ( id, name, description, price, stock, created_at) VALUES
('394fe8e7-e9bd-4847-81ce-7360fabb08b1', 'Koi Fish A', 'A beautiful red and white koi fish', 3000000, 1, NOW()),
('f8946ef4-2a93-4824-9d98-34b562655268', 'Koi Fish B', 'A stunning yellow koi fish', 7000000, 1, NOW()),
('e9375127-0bb0-47bc-a99c-e1d75065c157','Koi Fish C', 'A rare black koi fish with orange spots', 10000000, 1, NOW()),
('a1508392-bfbc-4a6b-8242-1634b4fb4ce7', 'Cám Bio Koi Growth & Color', 'BIO KOI FOOD được sản xuất theo công nghệ của Mỹ với độ dậm 42%', 350000, 10, NOW()),
('4b46f9ff-d875-4613-a00a-ce61732adfb3', 'Đèn Âm Nước Jebao GL13', 'Chiếu sáng non bộ, bể cá Có thể đặt ngoài trời hoặc ngâm trong nước', 550000, 15, NOW()),
('cb214502-03ea-47ea-9e6d-c7f4457989de','Máy sủi Oxy SUNSUN YT-818', 'Máy sủi tích điện dành cho bể cá lớn được tặng kèm một đầu chia bằng nhựa đường khí phi 4mm.', 800000, 15, NOW()),
('0e5a7e6f-831c-40c7-a5c3-16b0e2519b12', 'Koi Fish D', 'A vibrant blue koi fish', 5000000, 1, NOW()),
('16aab0d8-d334-4e1a-bf2b-2cf70d9b7e25', 'Koi Fish E', 'A silver koi fish with golden fins', 8000000, 1, NOW()),
('27b45d94-8cf8-46d7-986e-c89cfabb3c4e', 'Koi Fish F', 'A shiny metallic white koi fish', 6000000, 1, NOW()),
('34e6db3d-3919-4c68-a872-726cdfedd38f', 'Koi Fish G', 'A beautiful orange koi fish with black markings', 5500000, 1, NOW()),
('45b6eaa5-6ec1-4c67-98b4-e7215bb836fa', 'Koi Fish H', 'A stunning red koi fish', 7500000, 1, NOW()),
('56c9e7b4-5672-4df9-9c94-b9c65e2b6d6a', 'Koi Fish I', 'A black koi fish with golden spots', 9000000, 1, NOW()),
('6782c7fd-19fc-44f2-993b-229cf3b4cd5f', 'Koi Fish J', 'A pure white koi fish', 4000000, 1, NOW()),
('78fb91e2-467e-4d85-81b8-cd76f9ac4f51', 'Koi Fish K', 'A red and yellow koi fish', 5200000, 1, NOW()),
('89267bf9-dcc1-44cb-95a7-35f82fbacfe1', 'Koi Fish L', 'A koi fish with rainbow scales', 11000000, 1, NOW()),
('98765aef-2c3e-47bc-814d-82c7fa935fa1', 'Koi Fish M', 'A rare albino koi fish', 12000000, 1, NOW()),
('0ec3276f-a284-405c-94d0-a1e54b8d17ef', 'Máy lọc nước Koi Pond Aqua', 'Máy lọc dành cho hồ cá Koi chuyên nghiệp.', 1200000, 10, NOW()),
('5e65eb76-25ea-403d-9e91-0ebea1de0963', 'Thức ăn Koi Premium Growth', 'Thức ăn cao cấp giúp cá Koi phát triển tốt.', 450000, 20, NOW()),
('2de33958-1d77-449b-a484-44eefc059f3f', 'Bộ sưởi ấm bể cá', 'Giúp điều chỉnh nhiệt độ ổn định cho bể cá.', 600000, 15, NOW()),
('9ad84c23-0e55-4495-b1ff-fe5bc998db3a', 'Đèn LED RGB Koi Pond', 'Đèn LED tạo hiệu ứng ánh sáng tuyệt đẹp cho hồ cá.', 750000, 8, NOW()),
('4f0b322a-bd33-47a8-bbff-1a1320083778', 'Máy bơm hồ cá Koi Pro Max', 'Máy bơm công suất lớn dành cho hồ cá Koi.', 1500000, 5, NOW()),
('a2f55dbe-82e7-4b7a-a0ff-83553640f310', 'Vợt bắt cá cao cấp', 'Vợt được thiết kế đặc biệt để bắt cá mà không gây tổn thương.', 200000, 50, NOW()),
('37a2ee64-c82b-4022-903f-70752c0e28d7', 'Hệ thống lọc tràn', 'Hệ thống lọc tràn giúp giữ nước hồ luôn trong sạch.', 2000000, 3, NOW()),
('ac65c323-221e-4c4b-a5a9-b794d8d3a313', 'Đầu phun oxy tạo bọt', 'Đầu phun oxy giúp tăng lượng oxy hòa tan trong nước.', 300000, 25, NOW()),
('f9ec94fb-b0a2-4124-8916-18f29cbfd270', 'Bộ test nước hồ Koi', 'Kiểm tra nhanh các chỉ số nước trong hồ cá Koi.', 150000, 100, NOW()),
('c3e31bb2-2728-44c0-a261-7c9e31f78a31', 'Máy hút cặn đáy hồ', 'Thiết bị chuyên dụng để vệ sinh đáy hồ cá.', 2500000, 2, NOW());

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
('e9375127-0bb0-47bc-a99c-e1d75065c157', 3, '1 year', 'Male', 'Small', 'Koi Farm C', 0, false),
('0e5a7e6f-831c-40c7-a5c3-16b0e2519b12', 1, '2 years', 'Male', 'Medium', 'Koi Farm D', 0, false),
('16aab0d8-d334-4e1a-bf2b-2cf70d9b7e25', 2, '1.5 years', 'Female', 'Large', 'Koi Farm E', 0, false),
('27b45d94-8cf8-46d7-986e-c89cfabb3c4e', 3, '3 years', 'Male', 'Medium', 'Koi Farm F', 0, false),
('34e6db3d-3919-4c68-a872-726cdfedd38f', 1, '1 year', 'Female', 'Small', 'Koi Farm G', 0, false),
('45b6eaa5-6ec1-4c67-98b4-e7215bb836fa', 2, '2.5 years', 'Male', 'Medium', 'Koi Farm H', 0, false),
('56c9e7b4-5672-4df9-9c94-b9c65e2b6d6a', 3, '3.5 years', 'Female', 'Large', 'Koi Farm I', 0, false),
('6782c7fd-19fc-44f2-993b-229cf3b4cd5f', 1, '1 year', 'Male', 'Small', 'Koi Farm J', 0, false),
('78fb91e2-467e-4d85-81b8-cd76f9ac4f51', 2, '2 years', 'Female', 'Medium', 'Koi Farm K', 0, false),
('89267bf9-dcc1-44cb-95a7-35f82fbacfe1', 3, '3 years', 'Male', 'Large', 'Koi Farm L', 0, false),
('98765aef-2c3e-47bc-814d-82c7fa935fa1', 1, '4 years', 'Female', 'Extra Large', 'Koi Farm M', 0, false);




INSERT INTO accessory (product_id, id, brand, view_count, category_id, is_deleted ) VALUES
('a1508392-bfbc-4a6b-8242-1634b4fb4ce7', 1, 'Growth & Color', 0, 1, false),
('4b46f9ff-d875-4613-a00a-ce61732adfb3', 2, 'Jebao GL13', 0, 2, false),
('cb214502-03ea-47ea-9e6d-c7f4457989de', 3, 'SUNSUN', 0, 3, false),
('0ec3276f-a284-405c-94d0-a1e54b8d17ef', 4, 'AquaTech', 0, 1, FALSE),
('5e65eb76-25ea-403d-9e91-0ebea1de0963', 5, 'PremiumFood', 0, 2, FALSE),
('2de33958-1d77-449b-a484-44eefc059f3f', 6, 'AquaWarm', 0, 3, FALSE),
('9ad84c23-0e55-4495-b1ff-fe5bc998db3a', 7, 'RGBLight', 0, 1, FALSE),
('4f0b322a-bd33-47a8-bbff-1a1320083778', 8, 'PumpMaster', 0, 2, FALSE),
('a2f55dbe-82e7-4b7a-a0ff-83553640f310', 9, 'FishNet', 0, 2, FALSE),
('37a2ee64-c82b-4022-903f-70752c0e28d7', 10, 'FilterTech', 0, 3, FALSE),
('ac65c323-221e-4c4b-a5a9-b794d8d3a313', 11, 'BubbleOxy', 0, 3, FALSE),
('f9ec94fb-b0a2-4124-8916-18f29cbfd270', 12, 'WaterTest', 0, 3, FALSE),
('c3e31bb2-2728-44c0-a261-7c9e31f78a31', 13, 'BottomClean', 0, 2, FALSE);


INSERT INTO product_image (product_id, image_url, display_order, is_deleted, created_at) VALUES
('394fe8e7-e9bd-4847-81ce-7360fabb08b1', 'https://example.com/images/koi_fish_a_1.jpg', 1, FALSE, NOW()),
('394fe8e7-e9bd-4847-81ce-7360fabb08b1', 'https://example.com/images/koi_fish_a_2.jpg', 2, FALSE, NOW()),
('f8946ef4-2a93-4824-9d98-34b562655268', 'https://example.com/images/koi_fish_b_1.jpg', 1, FALSE, NOW()),
('f8946ef4-2a93-4824-9d98-34b562655268', 'https://example.com/images/koi_fish_b_2.jpg', 2, FALSE, NOW()),
('f8946ef4-2a93-4824-9d98-34b562655268', 'https://example.com/images/koi_fish_b_3.jpg', 3, FALSE, NOW()),
('e9375127-0bb0-47bc-a99c-e1d75065c157', 'https://example.com/images/koi_fish_c_1.jpg', 1, FALSE, NOW()),
('a1508392-bfbc-4a6b-8242-1634b4fb4ce7', 'https://example.com/images/bio koi.jpg', 1, FALSE, NOW()),
('4b46f9ff-d875-4613-a00a-ce61732adfb3', 'https://example.com/images/jebao gl13.jpg', 1, FALSE, NOW()),
('cb214502-03ea-47ea-9e6d-c7f4457989de', 'https://example.com/images/sun sun yt18.jpg', 1, FALSE, NOW()),
('0e5a7e6f-831c-40c7-a5c3-16b0e2519b12', 'https://example.com/images/koi_fish_d_1.jpg', 1, FALSE, NOW()),
('16aab0d8-d334-4e1a-bf2b-2cf70d9b7e25', 'https://example.com/images/koi_fish_e_1.jpg', 1, FALSE, NOW()),
('16aab0d8-d334-4e1a-bf2b-2cf70d9b7e25', 'https://example.com/images/koi_fish_e_2.jpg', 2, FALSE, NOW()),
('16aab0d8-d334-4e1a-bf2b-2cf70d9b7e25', 'https://example.com/images/koi_fish_e_3.jpg', 3, FALSE, NOW()),
('27b45d94-8cf8-46d7-986e-c89cfabb3c4e', 'https://example.com/images/koi_fish_f_1.jpg', 1, FALSE, NOW()),
('34e6db3d-3919-4c68-a872-726cdfedd38f', 'https://example.com/images/koi_fish_g_1.jpg', 1, FALSE, NOW()),
('45b6eaa5-6ec1-4c67-98b4-e7215bb836fa', 'https://example.com/images/koi_fish_h_1.jpg', 1, FALSE, NOW()),
('56c9e7b4-5672-4df9-9c94-b9c65e2b6d6a', 'https://example.com/images/koi_fish_i_1.jpg', 1, FALSE, NOW()),
('56c9e7b4-5672-4df9-9c94-b9c65e2b6d6a', 'https://example.com/images/koi_fish_i_2.jpg', 2, FALSE, NOW()),
('6782c7fd-19fc-44f2-993b-229cf3b4cd5f', 'https://example.com/images/koi_fish_j_1.jpg', 1, FALSE, NOW()),
('6782c7fd-19fc-44f2-993b-229cf3b4cd5f', 'https://example.com/images/koi_fish_j_2.jpg', 2, FALSE, NOW()),
('78fb91e2-467e-4d85-81b8-cd76f9ac4f51', 'https://example.com/images/koi_fish_k_1.jpg', 1, FALSE, NOW()),
('78fb91e2-467e-4d85-81b8-cd76f9ac4f51', 'https://example.com/images/koi_fish_k_2.jpg', 2, FALSE, NOW()),
('89267bf9-dcc1-44cb-95a7-35f82fbacfe1', 'https://example.com/images/koi_fish_l_1.jpg', 1, FALSE, NOW()),
('89267bf9-dcc1-44cb-95a7-35f82fbacfe1', 'https://example.com/images/koi_fish_l_2.jpg', 2, FALSE, NOW()),
('98765aef-2c3e-47bc-814d-82c7fa935fa1', 'https://example.com/images/koi_fish_m_1.jpg', 1, FALSE, NOW()),
('0ec3276f-a284-405c-94d0-a1e54b8d17ef', 'https://example.com/images/aquatech.jpg', 1, FALSE, NOW()),
('5e65eb76-25ea-403d-9e91-0ebea1de0963', 'https://example.com/images/premiumfood.jpg', 1, FALSE, NOW()),
('2de33958-1d77-449b-a484-44eefc059f3f', 'https://example.com/images/aquawarm.jpg', 1, FALSE, NOW()),
('9ad84c23-0e55-4495-b1ff-fe5bc998db3a', 'https://example.com/images/rgblight.jpg', 1, FALSE, NOW()),
('4f0b322a-bd33-47a8-bbff-1a1320083778', 'https://example.com/images/pumpmaster.jpg', 1, FALSE, NOW()),
('a2f55dbe-82e7-4b7a-a0ff-83553640f310', 'https://example.com/images/fishnet.jpg', 1, FALSE, NOW()),
('37a2ee64-c82b-4022-903f-70752c0e28d7', 'https://example.com/images/filtertech.jpg', 1, FALSE, NOW()),
('ac65c323-221e-4c4b-a5a9-b794d8d3a313', 'https://example.com/images/bubbleoxy.jpg', 1, FALSE, NOW()),
('f9ec94fb-b0a2-4124-8916-18f29cbfd270', 'https://example.com/images/watertest.jpg', 1, FALSE, NOW()),
('c3e31bb2-2728-44c0-a261-7c9e31f78a31', 'https://example.com/images/bottomclean.jpg', 1, FALSE, NOW());


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

