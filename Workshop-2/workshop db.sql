create table customers (
	customer_id int primary key,
	name varchar(100),
	email varchar(100)
);

create table orders (
	order_id int primary key,
	customer_id int,
	order_date date,
	total_amount decimal(10, 2),
	foreign key (customer_id) references customers(customer_id)
);

create table products (
	product_id int primary key,
	product_name varchar(100),
	price decimal(10, 2)
);

create table order_items (
	order_item_id int primary key,
	order_id int,
	product_id int,
	quantity int,
	foreign key (order_id) references orders(order_id),
	foreign key (product_id) references products(product_id)
);

create table categories (
	category_id int primary key,
	category_name varchar(100)
);

alter table products
add column category_id int,
add foreign key (category_id) references categories(category_id);
