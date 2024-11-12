-- Таблица для людей
CREATE TABLE Person (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    age INT NOT NULL,
    has_drivers_license BOOLEAN NOT NULL
);

-- Таблица для машин
CREATE TABLE Car (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    brand VARCHAR(50) NOT NULL,
    model VARCHAR(50) NOT NULL,
    price DECIMAL(10, 2) NOT NULL
);

-- Связь между людьми и машинами (один человек может иметь несколько машин)
CREATE TABLE Person_Car (
    person_id BIGINT NOT NULL,
    car_id BIGINT NOT NULL,
    PRIMARY KEY (person_id, car_id),
    FOREIGN KEY (person_id) REFERENCES Person(id),
    FOREIGN KEY (car_id) REFERENCES Car(id)
);
