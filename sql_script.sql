CREATE DATABASE 'amazon-el8alaba';

USE `amazon-el8alaba`;


CREATE TABLE Product (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255) NOT NULL
);


CREATE TABLE ProductDetails (
                                id INT PRIMARY KEY,
                                expiration_date DATE NOT NULL,
                                manufacturer VARCHAR(255) NOT NULL,
                                price DECIMAL(10, 2) NOT NULL,
                                available BOOLEAN NOT NULL,
                                -- image LONGBLOB,
                                CONSTRAINT fk_product FOREIGN KEY (id) REFERENCES Product(id)
);
