-- Добавление факультетов
INSERT INTO faculty (name, color) VALUES ('Gryffindor', 'Red');
INSERT INTO faculty (name, color) VALUES ('Slytherin', 'Green');
INSERT INTO faculty (name, color) VALUES ('Ravenclaw', 'Blue');
INSERT INTO faculty (name, color) VALUES ('Hufflepuff', 'Yellow');

-- Добавление студентов
INSERT INTO student (name, age, faculty_id) VALUES ('Harry Potter', 17, 1);
INSERT INTO student (name, age, faculty_id) VALUES ('Hermione Granger', 18, 1);
INSERT INTO student (name, age, faculty_id) VALUES ('Draco Malfoy', 17, 2);
INSERT INTO student (name, age, faculty_id) VALUES ('Luna Lovegood', 16, 3);
INSERT INTO student (name, age, faculty_id) VALUES ('Cedric Diggory', 18, 4);
