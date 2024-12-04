# calendarium-academicum

**How to run:**
1. gradle bootRun
2. H2 database can be accessed on http://localhost:8080/h2

Courses scheduling application

We need an application for storing Students and Teachers information like name, age, group and courses. We have two type of courses -Main and Secondary.
The application should be able to add remove or modify students and teachers. 

With this application we should be able to create different reports:

* how many students we have
  * GET http://localhost:8080/students/count
* how many teachers we have
  * GET http://localhost:8080/teachers/count
* how many courses by type we have
  * GET http://localhost:8080/courses/count?course_type=Primary
* which students participate in specific course
  * GET http://localhost:8080/students/in-course-older-than?age=0&course_id=d4693a14-4ccb-48fa-a171-6a946fd6ce78
* which students participate in specific group
  * GET http://localhost:8080/students?group_number=1
* find all teachers and students for specific group and course
  * TODO
* find all students older than specific age and participate in specific course
  * GET http://localhost:8080/students/in-course-older-than?age=20&course_id=d4693a14-4ccb-48fa-a171-6a946fd6ce78
Please write tests and use an in-memory database.

The application should provide public API.

TODO
* Refactor - use model POJOs in Controllers.
* Security
* UI