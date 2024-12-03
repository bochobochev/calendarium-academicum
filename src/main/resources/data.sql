--Insert GROUPS
INSERT INTO "GROUPS"("GROUP_NUMBER","GROUP_ID","NAME") VALUES(1,  '5001fc24-2002-4897-b94a-242e0a78ecc4', 'First');
INSERT INTO "GROUPS"("GROUP_NUMBER","GROUP_ID","NAME") VALUES(2,  '41c523a7-a7ab-437e-ab29-168e4f896064', 'Second');
INSERT INTO "GROUPS"("GROUP_NUMBER","GROUP_ID","NAME") VALUES(3,  '1a75228e-5d3d-4fe8-971b-63275665908c', 'Third');

--Insert Students
INSERT INTO STUDENTS(STUDENT_ID, GROUP_ID, AGE ,FIRST_NAME ,LAST_NAME )
VALUES ('67415a57-0a2c-40ea-8283-c55412738e2f', '5001fc24-2002-4897-b94a-242e0a78ecc4', 19, 'Gancho', 'Gankov');

INSERT INTO STUDENTS(STUDENT_ID, GROUP_ID, AGE ,FIRST_NAME ,LAST_NAME )
VALUES ('35200d57-a405-4787-a27e-7fb2615d7da0', '41c523a7-a7ab-437e-ab29-168e4f896064', 22, 'Ivan', 'Ivanov');

INSERT INTO STUDENTS(STUDENT_ID, GROUP_ID, AGE ,FIRST_NAME ,LAST_NAME )
VALUES ('3664e4fd-b50b-4b32-8b6c-349b7c624dbd', '1a75228e-5d3d-4fe8-971b-63275665908c', 19, 'Petar', 'Petrov');

INSERT INTO STUDENTS(STUDENT_ID, GROUP_ID, AGE ,FIRST_NAME ,LAST_NAME )
VALUES ('58d87b62-f964-4978-b47a-e0b082507a68', '5001fc24-2002-4897-b94a-242e0a78ecc4', 21, 'Georgi', 'Georgiev');

--Insert Teachers
INSERT INTO TEACHERS(TEACHER_ID, AGE, FIRST_NAME ,LAST_NAME )
VALUES ('444c43b9-6dc4-4393-b908-f7312d8d9810', 33, 'Stefan', 'Stefanov');

INSERT INTO TEACHERS(TEACHER_ID, AGE, FIRST_NAME ,LAST_NAME )
VALUES ('3f66edac-ee2c-4330-bd37-cce539177fda', 37, 'Boyan', 'Boyanov');

INSERT INTO TEACHERS(TEACHER_ID, AGE, FIRST_NAME ,LAST_NAME )
VALUES ('29e3321c-ff87-4c77-988b-3ff17873618e', 42, 'Kiro', 'Kirov');

--Insert Course types
INSERT INTO COURSE_TYPES(COURSE_TYPE_ID, NAME) VALUES ('7a3349d6-d09e-421f-b9ec-04ab982c90b5', 'Primary');
INSERT INTO COURSE_TYPES(COURSE_TYPE_ID, NAME) VALUES ('030fed55-e619-4f59-8710-8ec7c8891dfa', 'Secondary');

--Insert Course types
INSERT INTO COURSES(COURSE_ID, NAME, DESCRIPTION, HORARIUM, COURSE_TYPE_ID)
VALUES ('d4693a14-4ccb-48fa-a171-6a946fd6ce78', 'Differential calculus', 'Introduction to differential calculus', 300.00, '7a3349d6-d09e-421f-b9ec-04ab982c90b5');

INSERT INTO COURSES(COURSE_ID, NAME, DESCRIPTION, HORARIUM, COURSE_TYPE_ID)
VALUES ('4c35ff80-f6c4-46bf-8b5b-36c791e4d883', 'Statistics', 'Statistical data analysis', 200.00, '7a3349d6-d09e-421f-b9ec-04ab982c90b5');

INSERT INTO COURSES(COURSE_ID, NAME, DESCRIPTION, HORARIUM, COURSE_TYPE_ID)
VALUES ('74545c55-1435-49a5-82bc-69c9f7e2d923', 'Quantum Physics', 'Introduction to quantum physics', 200.00, '030fed55-e619-4f59-8710-8ec7c8891dfa');

--Insert relations between teacher and course
--
INSERT INTO TEACHERS_COURSES(teacher_courses_id, teacher_id, course_id)
VALUES ((select RANDOM_UUID()), '3f66edac-ee2c-4330-bd37-cce539177fda', 'd4693a14-4ccb-48fa-a171-6a946fd6ce78');
--
INSERT INTO TEACHERS_COURSES(teacher_courses_id, teacher_id, course_id)
VALUES ((select RANDOM_UUID()), '444c43b9-6dc4-4393-b908-f7312d8d9810', '74545c55-1435-49a5-82bc-69c9f7e2d923');
--
INSERT INTO TEACHERS_COURSES(teacher_courses_id, teacher_id, course_id)
VALUES ((select RANDOM_UUID()), '29e3321c-ff87-4c77-988b-3ff17873618e', '4c35ff80-f6c4-46bf-8b5b-36c791e4d883');

--Insert relations between students and courses
--Differential calculus
INSERT INTO courses_students (courses_student_id, student_id, course_id) VALUES ((select RANDOM_UUID()), '67415a57-0a2c-40ea-8283-c55412738e2f', 'd4693a14-4ccb-48fa-a171-6a946fd6ce78');
INSERT INTO courses_students (courses_student_id, student_id, course_id) VALUES ((select RANDOM_UUID()), '35200d57-a405-4787-a27e-7fb2615d7da0', 'd4693a14-4ccb-48fa-a171-6a946fd6ce78');
INSERT INTO courses_students (courses_student_id, student_id, course_id) VALUES ((select RANDOM_UUID()), '3664e4fd-b50b-4b32-8b6c-349b7c624dbd', 'd4693a14-4ccb-48fa-a171-6a946fd6ce78');
INSERT INTO courses_students (courses_student_id, student_id, course_id) VALUES ((select RANDOM_UUID()), '58d87b62-f964-4978-b47a-e0b082507a68', 'd4693a14-4ccb-48fa-a171-6a946fd6ce78');
--Statistics
INSERT INTO courses_students (courses_student_id, student_id, course_id) VALUES ((select RANDOM_UUID()), '67415a57-0a2c-40ea-8283-c55412738e2f', '4c35ff80-f6c4-46bf-8b5b-36c791e4d883');
INSERT INTO courses_students (courses_student_id, student_id, course_id) VALUES ((select RANDOM_UUID()), '35200d57-a405-4787-a27e-7fb2615d7da0', '4c35ff80-f6c4-46bf-8b5b-36c791e4d883');
INSERT INTO courses_students (courses_student_id, student_id, course_id) VALUES ((select RANDOM_UUID()), '3664e4fd-b50b-4b32-8b6c-349b7c624dbd', '4c35ff80-f6c4-46bf-8b5b-36c791e4d883');
INSERT INTO courses_students (courses_student_id, student_id, course_id) VALUES ((select RANDOM_UUID()), '58d87b62-f964-4978-b47a-e0b082507a68', '4c35ff80-f6c4-46bf-8b5b-36c791e4d883');
--Quantum Physics
INSERT INTO courses_students (courses_student_id, student_id, course_id) VALUES ((select RANDOM_UUID()), '67415a57-0a2c-40ea-8283-c55412738e2f', '74545c55-1435-49a5-82bc-69c9f7e2d923');
INSERT INTO courses_students (courses_student_id, student_id, course_id) VALUES ((select RANDOM_UUID()), '35200d57-a405-4787-a27e-7fb2615d7da0', '74545c55-1435-49a5-82bc-69c9f7e2d923');
INSERT INTO courses_students (courses_student_id, student_id, course_id) VALUES ((select RANDOM_UUID()), '3664e4fd-b50b-4b32-8b6c-349b7c624dbd', '74545c55-1435-49a5-82bc-69c9f7e2d923');