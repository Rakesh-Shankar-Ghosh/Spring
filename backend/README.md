# PROJECT SETUP

- install your project here https://start.spring.io/ (if jdk 11 then dont select 3 or avobe)
- you can add dependecy from https://start.spring.io/ (most import spring web, sqql Driver, Mysql)
- makesure ur machine has maven installed if not then install maven by choco
- delete the void method inside src/test/testapp file
- MVC folder Structure like (bottom of the file)
- always be in root directory and run "mvn clean install" for build
- and run "mvn spring-boot:run" for run application
- java is not like gives u nice interface at the starting of the app like react/django or laravel
- so make a custome route .method,controller and hit this by localhost:8080/url

# Databse setUp

- must check u have dependecy or not. if not then add
- must add to application.properties (spring.jpa.hibernate.ddl-auto=create)
- must add to application.properties (spring.jpa.hibernate.ddl-auto=update)
- https://reflectoring.io/spring-cors/
  src
  └── main
  ├── java
  │ └── com
  │ └── yourcompany
  │ └── yourapp
  │ ├── config
  │ │ └── WebConfig.java (Spring MVC configuration)
  │ ├── controller
  │ │ └── HomeController.java (Controller classes)
  │ ├── model
  │ │ └── YourModel.java (Model classes)
  │ ├── repository
  │ │ └── YourRepository.java (Data access interfaces)
  │ ├── service
  │ │ └── YourService.java (Service classes)
  │ └── YourApplication.java (Main Spring Boot Application class)
  ├── resources
  │ ├── static
  │ │ └── css
  │ │ └── styles.css (CSS files, images, and other static resources)
  │ ├── templates
  │ │ └── index.html (HTML templates, Thymeleaf templates, etc.)
  │ └── application.properties (or application.yml, for configuration properties)
  └── test
  └── java
  └── com
  └── yourcompany
  └── yourapp
  └── controller
  └── HomeControllerTest.java (Unit tests for Controllers)
