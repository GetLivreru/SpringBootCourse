# SpringBootCourse

Я прошел курс ["Spring - Полный курс. Boot, Hibernate, Security, REST"](https://www.udemy.com/course/spring-alishev/), 
преподаватель Наиль Алишев, платформа Udemy.com. Процесс прохождения размещался в этом репозитории.

В ходе обучения были выполнены три учебных проекта.

**Update:** на основании курса 
["Spring Boot Unit Testing with JUnit, Mockito and MockMVC"](https://www.udemy.com/course/spring-boot-unit-testing/)
я покрыла все проекты юнит- и интеграционными тестами. Поскольку на курсе меня научили тестировать только 
SpringBoot-приложения, с другими конфигурациями пришлось повозиться, много гуглить. 

## Project 1

![project1-task.jpg](Project1/img.jpg)

---

Функционал реализован в полном объёме   .

Приложение устанавливается на Tomcat-9, разворачивается в контекстном пути http://localhost:8080/library

Использованные технологии: Java 17 SE, Apache Maven, Apache Tomcat, JDBC, PostgreSQL, Spring Core, Spring MVC, Lombok,
Thymeleaf, HTML, CSS.

---

Титульные страницы:

![project1-img1.gif](Project1/img1.gif)

Создание и редактирование читателя (с валидацией):

![project1-img2.gif](Project1/img2.gif)

Создание и редактирование книги (с валидацией):

![project1-img3.gif](Project1/img3.gif)

Профиль читателя, профиль книги, освобождение книги при удалении читателя:

![project1-img4.gif](Project1/img4.gif)

Отчёт о покрытии тестами:

![project1-jacoco.png](Project1/jacoco2.png)

## Project 2

![project2-task.jpg](Project2/Project2/img.jpg)

---

Функционал реализован в полном объёме.

Приложение устанавливается на Tomcat-9, разворачивается в контекстном пути http://localhost:8080/library

Использованные технологии: Java 17 SE, Apache Maven, Apache Tomcat, MySQL, Hibernate, Spring Core, Spring MVC,
Spring Data, Lombok, Thymeleaf, HTML, CSS.

---

Основной CRUD-функционал приложения не изменился.

Чтобы не вводить вручную параметры в адресную строку, я добавила в представление для книг форму ввода параметров 
сортировки/паджинации:

![project2-img1.gif](Project2/Project2/img1.gif)

Страница поиска книг:

![project2-img2.gif](Project2/Project2/img2.gif)

Если читатель взял книгу более 10 дней назад, книга считается просроченной и подсвечивается на его странице красным
цветом. Для демонстрации решения я воспользовалась SQL-запросом, вручную заменив дату взятия книги. Видео записывалось
15 октября 2022 года.

![project2-img3.gif](Project2/Project2/img3.gif)

Отчёт о покрытии тестами:

![project2-jacoco.png](Project2/Project2/jacoco.png)

