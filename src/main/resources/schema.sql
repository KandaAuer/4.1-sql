-- Создание таблицы Faculty с ограничениями на уникальность названия и цвета
CREATE TABLE IF NOT EXISTS faculty (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    color VARCHAR(20) NOT NULL,
    UNIQUE (name, color) -- Пара "название - цвет" должна быть уникальной
);

-- Создание таблицы Student с ограничениями
CREATE TABLE IF NOT EXISTS student (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL UNIQUE, -- Имя должно быть уникальным и не равным NULL
    age INT DEFAULT 20 CHECK (age >= 16), -- Возраст должен быть не менее 16 лет, по умолчанию 20
    faculty_id BIGINT,
    FOREIGN KEY (faculty_id) REFERENCES faculty(id) -- Связь с таблицей Faculty
);
