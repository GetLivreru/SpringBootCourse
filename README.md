# SpringBootCourse

I taking a course ["Spring - Полный курс. Boot, Hibernate, Security, REST"](https://www.udemy.com/course/spring-alishev/), 
taught by Nail Alishev on the Udemy.com platform. The learning process was documented in this repository.

During the course, three training projects were completed.

**Update:** Based on the course  
["Spring Boot Unit Testing with JUnit, Mockito and MockMVC"](https://www.udemy.com/course/spring-boot-unit-testing/)
I have covered all the projects with unit and integration tests. Since the course taught me how to test only SpringBoot applications, 
I had to experiment and research extensively to handle other configurations.

## Project 1

![project1-task.jpg](Project1/img.jpg)

---

The functionality has been fully implemented.

The application is deployed on Tomcat-9 and accessible at http://localhost:8080/library.

Technologies used: Java 17 SE, Apache Maven, Apache Tomcat, JDBC, PostgreSQL, Spring Core, Spring MVC, Lombok, Thymeleaf, HTML, CSS.

---

Main pages:

![project1-img1.gif](Project1/img1.gif)

Creating and editing a reader (with validation):

![project1-img2.gif](Project1/img2.gif)

Creating and editing a book (with validation):

![project1-img3.gif](Project1/img3.gif)

Reader profile, book profile, releasing a book when deleting a reader:

![project1-img4.gif](Project1/img4.gif)

Test covage report:

![project1-jacoco.png](Project1/jacoco2.png)

## Project 2

![project2-task.jpg](Project2/Project2/img.jpg)

---

The functionality has been fully implemented.

The application is deployed on Tomcat-9 and accessible at http://localhost:8080/library.

Technologies used: Java 17 SE, Apache Maven, Apache Tomcat, MySQL, Hibernate, Spring Core, Spring MVC, Spring Data, Lombok, Thymeleaf, HTML, CSS.

---

The main CRUD functionality of the application has remained unchanged.

To avoid manually entering parameters in the address bar, I added a parameter input form for sorting/pagination on the book view page:

![project2-img1.gif](Project2/Project2/img1.gif)

Book search page:

![project2-img2.gif](Project2/Project2/img2.gif)

If a reader has borrowed a book more than 10 days ago, the book is considered overdue and is highlighted in red on their page. To demonstrate this solution, I used an SQL query to manually change the book's borrow date. The video was recorded on October 15, 2022.

![project2-img3.gif](Project2/Project2/img3.gif)

Test coverage report:

![project2-jacoco.png](Project2/Project2/jacoco.png)

