CREATE TABLE IF NOT EXISTS CAR (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    brand VARCHAR(255) NOT NULL,
    model VARCHAR(255) NOT NULL,
    color VARCHAR(255),
    registration_number VARCHAR(255),
    kilometer INT NOT NULL,
    price_per_kilometer DOUBLE PRECISION NOT NULL
);