
CREATE TABLE IF NOT EXISTS CUSTOMER (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    firstname VARCHAR(255),
    lastname VARCHAR(255),
    address VARCHAR(255),
    birthdate DATE,
    city VARCHAR(255),
    postal_code VARCHAR(255),
    phone_number VARCHAR(255),
    email VARCHAR(255)
);
