
CREATE TABLE groups (
  group_id UUID PRIMARY KEY,
  group_number int,
  name VARCHAR(100)
);

CREATE TABLE students (
  student_id UUID PRIMARY KEY ,
  first_name VARCHAR(100),
  last_name VARCHAR(100),
  age int,
  group_id UUID
);

ALTER TABLE students ADD FOREIGN KEY (group_id) REFERENCES groups(group_id);

CREATE TABLE teachers (
  teacher_id UUID PRIMARY KEY,
  first_name VARCHAR(100),
  last_name VARCHAR(100),
  age int
);

CREATE TABLE course_types (
  course_type_id UUID PRIMARY KEY,
  name VARCHAR(100)
);

CREATE TABLE courses (
  course_id UUID PRIMARY KEY,
  name VARCHAR(100),
  description VARCHAR(250),
  horarium NUMERIC(3, 2),
  course_type_id UUID
);

ALTER TABLE courses ADD FOREIGN KEY (course_type_id) REFERENCES course_types(course_type_id);

CREATE TABLE teachers_courses (
  teacher_courses_id UUID PRIMARY KEY,
  teacher_id UUID,
  course_id UUID
);

ALTER TABLE teachers_courses ADD FOREIGN KEY (teacher_id) REFERENCES teachers(teacher_id);
ALTER TABLE teachers_courses ADD FOREIGN KEY (course_id) REFERENCES courses(course_id);

CREATE TABLE courses_students (
  courses_student_id UUID PRIMARY KEY,
  student_id UUID,
  course_id UUID
);

ALTER TABLE courses_students ADD FOREIGN KEY (student_id) REFERENCES students(student_id);
ALTER TABLE courses_students ADD FOREIGN KEY (course_id) REFERENCES courses(course_id);
