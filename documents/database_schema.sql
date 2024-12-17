USE lagikoi;

INSERT INTO product ( id, name, description, price, stock, created_at) VALUES
('394fe8e7-e9bd-4847-81ce-7360fabb08b1', 'Koi Fish A', 'A beautiful red and white koi fish', 100.00, 10, NOW()),
('f8946ef4-2a93-4824-9d98-34b562655268', 'Koi Fish B', 'A stunning yellow koi fish', 150.00, 15, NOW()),
('e9375127-0bb0-47bc-a99c-e1d75065c157','Koi Fish C', 'A rare black koi fish with orange spots', 200.00, 20, NOW());

INSERT INTO fish_category (name, description) VALUES
('SIRO', 'A category of koi known for their white body color with minimal markings.'),
('SHOWA', 'A type of koi with black, red, and white coloring.'),
('KOHAKU', 'A classic koi with red and white colors, one of the most popular varieties.');

INSERT INTO fish (product_id, category_id, age, gender, size, farm_name, view_count, is_deleted) VALUES
('394fe8e7-e9bd-4847-81ce-7360fabb08b1', 1, '2 years', 'Male', 'Medium', 'Koi Farm A', 100, false),
('f8946ef4-2a93-4824-9d98-34b562655268', 2, '3 years', 'Female', 'Large', 'Koi Farm B', 150, false),
('e9375127-0bb0-47bc-a99c-e1d75065c157', 3, '1 year', 'Male', 'Small', 'Koi Farm C', 200, false);

INSERT INTO product_image (product_id, image_url, display_order, is_deleted, created_at) VALUES
('394fe8e7-e9bd-4847-81ce-7360fabb08b1', 'https://example.com/images/koi_fish_a_1.jpg', 1, FALSE, NOW()),
('394fe8e7-e9bd-4847-81ce-7360fabb08b1', 'https://example.com/images/koi_fish_a_2.jpg', 2, FALSE, NOW()),
('f8946ef4-2a93-4824-9d98-34b562655268', 'https://example.com/images/koi_fish_b_1.jpg', 1, FALSE, NOW()),
('f8946ef4-2a93-4824-9d98-34b562655268', 'https://example.com/images/koi_fish_b_2.jpg', 2, FALSE, NOW()),
('f8946ef4-2a93-4824-9d98-34b562655268', 'https://example.com/images/koi_fish_b_3.jpg', 3, FALSE, NOW()),
('e9375127-0bb0-47bc-a99c-e1d75065c157', 'https://example.com/images/koi_fish_c_1.jpg', 1, FALSE, NOW());

INSERT INTO role (name, description) VALUES
('USER', 'user description'),
('ADMIN', "admin description"),
('MANAGER', 'manager description');

INSERT INTO permission (name, description) VALUES
('CREATE_FISH', 'create fish permission'),
('GET_USERS', 'get all user permission'),
('GET_FISH_CATEGORIES', 'get all fish categories');

INSERT INTO role_permission (role_name, permission_name) VALUES
('ADMIN', 'CREATE_FISH'),
('ADMIN', 'GET_USERS'),
('USER', 'GET_FISH_CATEGORIES');

INSERT INTO user (id, username, password, is_deleted) VALUES
('ab3bcd2e-54e0-4fae-a07e-19d7152e65e5', 'user', '$2b$10$2EkiZ6bovfh.eB0Nw3ONnOCLlupBQxek31WhR1DH8TJKa6Z.DVzXi', false), #user1234
('06ff0bfd-c2ff-401c-a33c-58a3e0799651', 'admin','$2b$10$ABEROdTJf2asJT8BUvO43uJ6h49vqPHWsN8j5mqKTP0fYi4h7dF6m', false), #admin123
('95ed93cb-868a-4a05-b8e5-556833209e3b', 'manager', '$2b$10$H32LWplgauc3Q2xOK27ETO1fjhVZ9hl8/WSG/.9KG2bwxsAE/xv6i', false); #manager1

INSERT INTO user_role (role_name, user_id) VALUES
('USER', 'ab3bcd2e-54e0-4fae-a07e-19d7152e65e5'),
('ADMIN', '06ff0bfd-c2ff-401c-a33c-58a3e0799651'),
('MANAGER', '95ed93cb-868a-4a05-b8e5-556833209e3b');


