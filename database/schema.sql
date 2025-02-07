CREATE DATABASE IF NOT EXISTS student_grade_tracker;
USE student_grade_tracker;

CREATE TABLE students (
    student_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE,
    enrollment_date DATE
);

CREATE TABLE grades (
    grade_id INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT,
    subject VARCHAR(50) NOT NULL,
    score DECIMAL(5,2) CHECK (score BETWEEN 0 AND 100),
    FOREIGN KEY (student_id) REFERENCES students(student_id)
);

-- View for student averages
CREATE VIEW student_averages AS
SELECT s.student_id, s.first_name, s.last_name, 
       AVG(g.score) AS average_score
FROM students s
LEFT JOIN grades g ON s.student_id = g.student_id
GROUP BY s.student_id;