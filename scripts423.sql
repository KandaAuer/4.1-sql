-- Получение имени и возраста всех студентов с названием факультета
SELECT s.name AS student_name, s.age AS student_age, f.name AS faculty_name
FROM Student s
INNER JOIN Faculty f ON s.faculty_id = f.id;

-- Получение студентов, у которых есть аватарки
SELECT s.name AS student_name
FROM Student s
INNER JOIN Avatar a ON s.id = a.student_id;
