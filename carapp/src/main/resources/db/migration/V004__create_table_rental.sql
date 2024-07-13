CREATE TABLE IF NOT EXISTS rental (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    customer_id BIGINT NOT NULL,
    car_id BIGINT NOT NULL,
    rental_start DATE NOT NULL,
    rental_end DATE NOT NULL,
    kilometers_driven INT NOT NULL,
    CONSTRAINT fk_rental_customer
        FOREIGN KEY (customer_id)
        REFERENCES customer(id),
    CONSTRAINT fk_rental_car
        FOREIGN KEY (car_id)
        REFERENCES car(id)
);