-- Ограничение: возраст студента не может быть меньше 16
ALTER TABLE Student
ADD CONSTRAINT chk_student_age CHECK (age >= 16);

-- Ограничение: уникальные и ненулевые имена студентов
ALTER TABLE Student
ADD CONSTRAINT unique_student_name UNIQUE (name),
MODIFY name VARCHAR(50) NOT NULL;

-- Ограничение: уникальная пара "название факультета" - "цвет факультета"
ALTER TABLE Faculty
ADD CONSTRAINT unique_faculty_name_color UNIQUE (name, color);

-- Ограничение: по умолчанию возраст студента = 20, если он не указан
ALTER TABLE Student
MODIFY age INT DEFAULT 20;
