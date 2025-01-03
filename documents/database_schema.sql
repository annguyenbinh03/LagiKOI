USE lagikoi;

INSERT INTO product ( id, name, description, price, stock, created_at) VALUES
('394fe8e7-e9bd-4847-81ce-7360fabb08b1', 'Aigoromo – koi', 'A beautiful fish', 30544800, 1, NOW()),
('f8946ef4-2a93-4824-9d98-34b562655268', 'Aigoromo – koi', 'A beautiful fish', 33090200, 1, NOW()),
('e9375127-0bb0-47bc-a99c-e1d75065c157','Aragoke – koi', 'A beautiful fish', 25454000, 1, NOW()),
('a1508392-bfbc-4a6b-8242-1634b4fb4ce7', 'Cám Bio Koi Growth & Color', 'BIO KOI FOOD được sản xuất theo công nghệ của Mỹ với độ dậm 42%', 350000, 10, NOW()),
('4b46f9ff-d875-4613-a00a-ce61732adfb3', 'Đèn Âm Nước Jebao GL13', 'Chiếu sáng non bộ, bể cá Có thể đặt ngoài trời hoặc ngâm trong nước', 550000, 15, NOW()),
('cb214502-03ea-47ea-9e6d-c7f4457989de','Máy sủi Oxy SUNSUN YT-818', 'Máy sủi tích điện dành cho bể cá lớn được tặng kèm một đầu chia bằng nhựa đường khí phi 4mm.', 800000, 15, NOW()),
('0e5a7e6f-831c-40c7-a5c3-16b0e2519b12', 'Aragoke – koi', 'A beautiful fish', 28508480, 1, NOW()),
('16aab0d8-d334-4e1a-bf2b-2cf70d9b7e25', 'Aragoke – koi', 'A beautiful fish', 38181000, 1, NOW()),
('27b45d94-8cf8-46d7-986e-c89cfabb3c4e', 'Asagi – koi', 'A beautiful fish', 34362900, 1, NOW()),
('34e6db3d-3919-4c68-a872-726cdfedd38f', 'Asagi – koi', 'A beautiful fish', 76362000, 1, NOW()),
('45b6eaa5-6ec1-4c67-98b4-e7215bb836fa', 'Asagi – koi', 'A beautiful fish', 50908000, 1, NOW()),
('56c9e7b4-5672-4df9-9c94-b9c65e2b6d6a', 'Doitsu Showa – koi', 'A beautiful fish', 53453400, 1, NOW()),
('6782c7fd-19fc-44f2-993b-229cf3b4cd5f', 'Doitsu Kujyaku – koi', 'A beautiful fish', 15272400, 1, NOW()),
('78fb91e2-467e-4d85-81b8-cd76f9ac4f51', 'Doitsu Hariwake – koi', 'A beautiful fish', 25454000, 1, NOW()),
('89267bf9-dcc1-44cb-95a7-35f82fbacfe1', 'Doitsu Bekko – koi', 'A beautiful fish', 30544800, 1, NOW()),
('98765aef-2c3e-47bc-814d-82c7fa935fa1', 'Doitsu Shiro Utsuri – koi', 'A beautiful fish', 33090200, 1, NOW()),
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
('Aigoromo', 'Aigoromo là giống cá Koi có nền trắng với các mảng màu đỏ đặc trưng, nhưng được phủ thêm một lớp vảy màu xanh dương nhạt ở các cạnh, tạo nên vẻ đẹp độc đáo và nhẹ nhàng.'),
('Aragoke', 'Aragoke là giống cá Koi với lớp vảy nổi bật, to và rõ ràng, tạo hiệu ứng "vảy giáp sắt". Loại này thường được tìm thấy ở các dòng Koi Doitsu.'),
('Asagi', 'Asagi là một trong những giống cá Koi cổ điển, có màu xanh dương nhạt trên lưng với hoa văn hình lưới và màu đỏ cam ở hai bên má, bụng và vây. Đây là giống Koi thanh lịch và được yêu thích.'),
('Doitsu', 'Doitsu là dòng cá Koi không có vảy hoặc chỉ có một hàng vảy chạy dọc theo hai bên sống lưng. Loại này nổi bật với màu sắc sáng và hoa văn rõ nét.');

INSERT INTO fish (product_id, category_id, yob, gender, size, farm_name, view_count, is_deleted) VALUES
('394fe8e7-e9bd-4847-81ce-7360fabb08b1', 1, 2022, 'Male', '16.00 inch / 41.5 cm', 'Sakazume Koi Farm', 0, false),
('f8946ef4-2a93-4824-9d98-34b562655268', 1, 2022, 'Male', '15.00 inch / 39.5 cm', 'Sakazume Koi Farm', 0, false),
('e9375127-0bb0-47bc-a99c-e1d75065c157', 2, 2023, 'Female', '17.00 inch / 45 cm', 'Marusen Koi Farm', 0, false),
('0e5a7e6f-831c-40c7-a5c3-16b0e2519b12', 2, 2023, 'Male', '17.00 inch / 44 cm', 'Marusen Koi Farm', 0, false),
('16aab0d8-d334-4e1a-bf2b-2cf70d9b7e25', 2, 2022, 'Female', '22.00 inch / 57 cm', 'Ozumi Ikarashi Koi Farm', 0, false),
('27b45d94-8cf8-46d7-986e-c89cfabb3c4e', 3, 2022, 'Female', '20.00 inch / 53 cm', 'Fukazawa Koi Farm', 0, false),
('34e6db3d-3919-4c68-a872-726cdfedd38f', 3, 2023, 'Female', ' 19.00 inch / 50 cm', 'Oya Koi Farm', 0, false),
('45b6eaa5-6ec1-4c67-98b4-e7215bb836fa', 3, 2022, 'Male', '18.00 inch / 47 cm','Otsuka Koi Farm', 0, false),
('56c9e7b4-5672-4df9-9c94-b9c65e2b6d6a', 4, 2023, 'Female', '18.00 inch / 47 cm', 'Hiroi Koi Farm', 0, false),
('6782c7fd-19fc-44f2-993b-229cf3b4cd5f', 4, 2023, 'Male', '15.00 inch / 39 cm', 'Kaneko Koi Farm', 0, false),
('78fb91e2-467e-4d85-81b8-cd76f9ac4f51', 4, 2022, 'Female', '17.00 inch / 44 cm', 'Koi Fukazawa Farm', 0, false),
('89267bf9-dcc1-44cb-95a7-35f82fbacfe1', 4, 2023, 'Female', '17.00 inch / 45 cm', 'Maruhide Koi Farm', 0, false),
('98765aef-2c3e-47bc-814d-82c7fa935fa1', 4, 2022, 'Male', '14.00 inch / 36 cm', 'Hiroi Koi Farm', 0, false);


INSERT INTO accessory_category (id, name, description, is_deleted) VALUES 
( 1, 'Thức ăn', 'Cám cá koi', false),
( 2, 'Đèn Âm Nước', 'Chiếu sáng non bộ, bể cá Có thể đặt ngoài trời hoặc ngâm trong nước', false),
( 3, 'Máy sủi Oxy', 'Thổi khí Cung cấp oxi hồ cá koi trong chăn nuôi thủy sản, các bể vi sinh hiếu khí, thu hồi khí Biogas, sục khí lòng hồ, ngăn chặn phân hủy kị khí', false);


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
('394fe8e7-e9bd-4847-81ce-7360fabb08b1', 'https://res.cloudinary.com/dqmzqwuju/image/upload/v1735875337/f7ilcephz4gm5scicvzu.jpg', 1, FALSE, NOW()),
('f8946ef4-2a93-4824-9d98-34b562655268', 'https://res.cloudinary.com/dqmzqwuju/image/upload/v1735878356/lmgcwdss3gfz8fteoo4z.jpg', 1, FALSE, NOW()),
('e9375127-0bb0-47bc-a99c-e1d75065c157', 'https://res.cloudinary.com/dqmzqwuju/image/upload/v1735878450/vvyv997bai62awkotlo3.jpg', 1, FALSE, NOW()),
('a1508392-bfbc-4a6b-8242-1634b4fb4ce7', 'https://example.com/images/bio koi.jpg', 1, FALSE, NOW()),
('4b46f9ff-d875-4613-a00a-ce61732adfb3', 'https://example.com/images/jebao gl13.jpg', 1, FALSE, NOW()),
('cb214502-03ea-47ea-9e6d-c7f4457989de', 'https://example.com/images/sun sun yt18.jpg', 1, FALSE, NOW()),
('0e5a7e6f-831c-40c7-a5c3-16b0e2519b12', 'https://res.cloudinary.com/dqmzqwuju/image/upload/v1735878640/wm3gb8mfcw5a9qbqkqmw.jpg', 1, FALSE, NOW()),
('16aab0d8-d334-4e1a-bf2b-2cf70d9b7e25', 'https://res.cloudinary.com/dqmzqwuju/image/upload/v1735879036/asgshzsjiqi1tgqcvlip.jpg', 1, FALSE, NOW()),
('27b45d94-8cf8-46d7-986e-c89cfabb3c4e', 'https://res.cloudinary.com/dqmzqwuju/image/upload/v1735879241/vjwkhbuujtinodzazzqb.jpg', 1, FALSE, NOW()),
('34e6db3d-3919-4c68-a872-726cdfedd38f', 'https://res.cloudinary.com/dqmzqwuju/image/upload/v1735879376/qxr52wgxaiy9fdxtysz6.jpg', 1, FALSE, NOW()),
('45b6eaa5-6ec1-4c67-98b4-e7215bb836fa', 'https://res.cloudinary.com/dqmzqwuju/image/upload/v1735879558/uxrpwzccrduxfgc5uqsf.jpg', 1, FALSE, NOW()),
('56c9e7b4-5672-4df9-9c94-b9c65e2b6d6a', 'https://res.cloudinary.com/dqmzqwuju/image/upload/v1735879836/ofujsins0tbrqwsss0is.jpg', 1, FALSE, NOW()),
('6782c7fd-19fc-44f2-993b-229cf3b4cd5f', 'https://res.cloudinary.com/dqmzqwuju/image/upload/v1735879995/mmjj4cg3nu5mrwsmhswb.jpg', 1, FALSE, NOW()),
('78fb91e2-467e-4d85-81b8-cd76f9ac4f51', 'https://res.cloudinary.com/dqmzqwuju/image/upload/v1735880143/tiohdccb4sve5rer51fo.jpg', 1, FALSE, NOW()),
('89267bf9-dcc1-44cb-95a7-35f82fbacfe1', 'https://res.cloudinary.com/dqmzqwuju/image/upload/v1735880346/yfwhhybwuflbvdvilld9.jpg', 1, FALSE, NOW()),
('98765aef-2c3e-47bc-814d-82c7fa935fa1', 'https://res.cloudinary.com/dqmzqwuju/image/upload/v1735880492/dofo2e7lybdhw689m2gx.jpg', 1, FALSE, NOW()),
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

