Insert into Category(id,title,description,image)
values(1, 'V', 'V shape neck T-shirts', 'image sql');
Insert into Category(id,title,description,image)
values(2, 'R', 'Rounded shape neck T-shirts','image');
Insert into Category(id,title,description,image)
values(3, 'H', 'High neck T-shirts', 'image');

Insert into Product(pid,product_name,product_description,product_slug,product_image
,new_product,featured,active,price,category)
values(111,'product one', 'lol', 'product 1 slug', 'product 1 image', true, true, false, 11.900, 1);
Insert into Product(pid,product_name,product_description,product_slug,product_image,new_product,featured,active,price,category)
values(1111,'product 1111', 'product 1 Description', 'product 1 slug', 'product 1 image', false, true, true, 11.00, 1);

Insert into Product(pid,product_name,product_description,product_slug,product_image,new_product,featured,active,price,category)
values(222,'product two', 'twoLols', 'product 1 slug', 'product 1 image', true, false, false, 12.900, 2);
Insert into Product(pid,product_name,product_description,product_slug,product_image,new_product,featured,active,price,category)
values(2222,'product 2222', 'product 1 Description', 'product 1 slug', 'product 1 image', false, false, true, 13.900, 2);


Insert into Product(pid,product_name,product_description,product_slug,product_image,new_product,featured,active,price,category)
values(333,'product 333', 'product 1 Description', 'product 1 slug', 'product 1 image', true, true, false, 14.900, 3);
Insert into Product(pid,product_name,product_description,product_slug,product_image,new_product,featured,active,price,category)
values(3333,'product 3333', 'product 1 Description', 'product 1 slug', 'product 1 image', false, true, true, 15.900, 3);



--Insert into NewProduct(pid,product_name,product_description,product_slug,product_image,new_product,featured,active,price,category)
--values(857,'product 1', 'product 1 Description', 'product 1 slug', 'product 1 image', true, true, false, 14.900, 3);
--Insert into NewProduct(pid,product_name,product_description,product_slug,product_image,new_product,featured,active,price,category)
--values(168,'product 1', 'product 1 Description', 'product 1 slug', 'product 1 image', false, true, true, 15.900, 3);


--Insert into Size(size_id,size_value,product_)
--values(1, 'small', 111);
--Insert into Size(size_id,size_value,product_)
--values(2, 'Medium', 111);
--Insert into Size(size_id,size_value,product_)
--values(3, 'Large', 111);

Insert into size(size_id,size_value)
values(1, 'XS');
Insert into size(size_id,size_value)
values(2, 'S');
Insert into size(size_id,size_value)
values(3, 'M');

Insert into color(color_id, color_value)
values(1, 'White');
Insert into color(color_id, color_value)
values(2, 'Black');
Insert into color(color_id, color_value)
values(3, 'Grey');

Insert into product_variants(sku, quantity, product_id,size_id, color_id)
values(1, 10, 111, 1, 1);
Insert into product_variants(sku, quantity, product_id,size_id, color_id)
values(2, 9, 111, 1, 2);
Insert into product_variants(sku, quantity, product_id,size_id, color_id)
values(3, 8, 111, 1, 3);
Insert into product_variants(sku, quantity, product_id,size_id, color_id)
values(4, 10, 111, 2, 1);
Insert into product_variants(sku, quantity, product_id,size_id, color_id)
values(5, 9, 111, 2, 2);
Insert into product_variants(sku, quantity, product_id,size_id, color_id)
values(6, 8, 111, 2, 3);
Insert into product_variants(sku, quantity, product_id,size_id, color_id)
values(7, 10, 111, 3, 1);
Insert into product_variants(sku, quantity, product_id,size_id, color_id)
values(8, 9, 111, 3, 2);
Insert into product_variants(sku, quantity, product_id,size_id, color_id)
values(9, 8, 111, 3, 3);
