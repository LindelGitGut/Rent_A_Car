CREATE TABLE IF NOT EXISTS RENTAL (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    customer_id BIGINT NOT NULL,
    car_id BIGINT NOT NULL,
    rental_date DATE NOT NULL,
    return_date DATE,
    kilometers INT NOT NULL,
    CONSTRAINT fk_customer
        FOREIGN KEY (customer_id)
        REFERENCES CUSTOMER(id),
    CONSTRAINT fk_car
        FOREIGN KEY (car_id)
        REFERENCES CAR(id)
);
