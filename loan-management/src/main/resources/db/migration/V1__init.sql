CREATE TABLE `customer` (
  `customer_id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `customer_loan` (
  `emi` double NOT NULL,
  `interest` double NOT NULL,
  `loan_principle` double NOT NULL,
  `tenure` double NOT NULL,
  `collateral_id` bigint NOT NULL,
  `customer_id` bigint DEFAULT NULL,
  `loan_id` bigint NOT NULL AUTO_INCREMENT,
  `loan_product_id` bigint DEFAULT NULL,
  PRIMARY KEY (`loan_id`),
  UNIQUE KEY `UKctaoun2qwt16wosvic1w3hyf8` (`customer_id`),
  UNIQUE KEY `UKhlrpixmke4t2ufals8b6yd7ya` (`loan_product_id`),
  CONSTRAINT `FKbxrqm16lv9i2yiynqxcnlyta8` FOREIGN KEY (`loan_product_id`) REFERENCES `loan_products` (`loan_product_id`),
  CONSTRAINT `FKn9vyqqcgd0w8m4yynciq3qf82` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `loan_application` (
  `loan_amount` double NOT NULL,
  `status` tinyint DEFAULT NULL,
  `tenure` double NOT NULL,
  `application_id` bigint NOT NULL AUTO_INCREMENT,
  `collateral_id` bigint NOT NULL,
  `customer_id` bigint DEFAULT NULL,
  PRIMARY KEY (`application_id`),
  UNIQUE KEY `UKackof8sibh3w3wmj91coygy1h` (`customer_id`),
  CONSTRAINT `FKsv9dtfbv22o6nfa6as2bjiyx1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`),
  CONSTRAINT `loan_application_chk_1` CHECK ((`status` between 0 and 2))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `loan_products` (
  `interest` double NOT NULL,
  `max_eligible_loan` double NOT NULL,
  `tenure` double NOT NULL,
  `type` tinyint DEFAULT NULL,
  `loan_product_id` bigint NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`loan_product_id`),
  CONSTRAINT `loan_products_chk_1` CHECK ((`type` between 0 and 1))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT INTO customer (address, name) VALUES ('Bangalore', 'Akshay');
INSERT INTO customer (address, name) VALUES ('Lucknow', 'Vijay');
INSERT INTO customer (address, name) VALUES ('Chennai', 'Raj');

INSERT INTO loan_products (interest, max_eligible_loan, tenure, type) VALUES ('8','100000', '8', '1');
INSERT INTO loan_products (interest, max_eligible_loan, tenure, type) VALUES ('9.2','200000', '8', '1');
INSERT INTO loan_products (interest, max_eligible_loan, tenure, type) VALUES ('7','800000', '8', '0');

