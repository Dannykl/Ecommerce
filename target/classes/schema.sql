DROP TABLE IF EXISTS line_item;
CREATE TABLE line_item(
    id INT(4) NOT NULL AUTO_INCREMENT,
    quantity INT(4),
    order_id INT (4),
    item_id INT (4),
    PRIMARY KEY(id),
    FOREIGN KEY(order_id) REFERENCES orders(id) ON DELETE CASCADE,
    FOREIGN KEY(item_id) REFERENCES item(id) ON DELETE CASCADE

);

DROP TABLE IF EXISTS orders;
CREATE TABLE orders(
    id INT(4) NOT NULL AUTO_INCREMENT,
    created_date TIMESTAMP,
    user VARCHAR (200),
    PRIMARY KEY(id),
    FOREIGN KEY(user) REFERENCES customers(email) ON DELETE CASCADE
);

DROP TABLE IF EXISTS item;
CREATE TABLE item(
    id INT(4) NOT NULL AUTO_INCREMENT,
    name VARCHAR (30),
    description VARCHAR (200),
    price DECIMAL (10),
    created_date TIMESTAMP,
    PRIMARY KEY(id)
);

DROP TABLE IF EXISTS customers;
CREATE TABLE customers(
    email VARCHAR (30),
    password VARCHAR (100),
    role_type VARCHAR (10),
    created_date TIMESTAMP,
    PRIMARY KEY(email)
);





