create schema amazonEl8alaba;
use amazonEl8alaba;

create table product(
                        id int auto_increment primary key,
                        name varchar(255) not null
);

create table product_details(
                                id int auto_increment primary key,
                                product_id int not null,
                                expiration_date date not null,
                                manufacturer varchar(255) not null,
                                price double not null,
                                available boolean not null default false,
                                foreign key (product_id) references product(id)
);

ALTER TABLE product_details
ADD COLUMN image LONGBLOB;


INSERT INTO amazonEl8alaba.product (id, name) VALUES (1, 'milk');
INSERT INTO amazonEl8alaba.product (id, name) VALUES (2, 'fish');
INSERT INTO amazonEl8alaba.product (id, name) VALUES (3, 'cheese');
INSERT INTO amazonEl8alaba.product (id, name) VALUES (4, 'chocolate');

INSERT INTO amazonEl8alaba.product_details (id, product_id,  expiration_date, manufacturer, price, available) VALUES (1, 1, '2024-02-08', 'dina farms', 30, 1);
INSERT INTO amazonEl8alaba.product_details (id, product_id,expiration_date, manufacturer, price, available) VALUES (2, 2, '2024-02-15', 'abu elsayed', 100, 1);
INSERT INTO amazonEl8alaba.product_details (id, product_id,  expiration_date, manufacturer, price, available) VALUES (3, 3,  '2024-06-11', 'dina farms', 50, 1);
INSERT INTO amazonEl8alaba.product_details (id, product_id,  expiration_date, manufacturer, price, available) VALUES (4, 4,  '2024-02-29', 'cadbury', 60, 0);
