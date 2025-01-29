## sayHello.html

<html>
<head>
<title>My First HTML Page</title>
</head>
<body>
My first html page with body
</body>
</html>

## JSP
## Login.JSP

## HTML
HTML - Static Content

## EL - 
EL - Expression Language - Dynamic Content

## Logging

## Dispatcher Servlet
localhost:8081/login

A1: Identifies Correct Controller Method
/login => LoginController.gotoLoginPage()

A2: Executes Controller Method
=> Puts data into model
=> Returns view name => login

A3: Identifies correct view using View Resolver
/WEB-INF/jsp/login.jsp

A4: Executes view

## Todo

Todo.java
id
username
description
targetDate
done

Static List of Todos => Database(H2, MySQL)

TodoController
listTodos.jsp

## JSTL - Java Server Pages Standard Tag Library
## JSTL Core Tag Library

<dependency>
			<groupId>jakarta.servlet.jsp.jstl</groupId>
			<artifactId>jakarta.servlet.jsp.jstl-api</artifactId>
		</dependency>

		<dependency>
			<groupId>org.eclipse.jetty</groupId>
			<artifactId>glassfish-jstl</artifactId>
			<version>11.0.23</version>
		</dependency>
 
## Bootstrap CSS
	<dependency>
			<groupId>org.webjars</groupId>
			<artifactId>bootstrap</artifactId>
			<version>5.1.3</version>
		</dependency>
		
		<dependency>
			<groupId>org.webjars</groupId>
			<artifactId>jquery</artifactId>
			<version>3.6.0</version>
		</dependency>
		
		


/META-INF/resources/webjars/bootstrap/5.1.3/css/bootstrap.min.css

/META-INF/resources/webjars/bootstrap/5.1.3/js/bootstrap.min.js

/META-INF/resources/webjars/jquery/3.6.0/jquery.min.js

## Validation with Spring Boot 
1. Spring Boot Starter Validation
pom.xml

2. Command Bean (Form Backing object)
2-way binding (todo.jsp & TodoController.java)

3. add validation to Bean
Todo.java

4. Display validation Errors in the View
todo.jsp

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

## Bootstrap DatePicker    
    <dependency>
			<groupId>org.webjars</groupId>
			<artifactId>bootstrap-datepicker</artifactId>
			<version>1.9.0</version>
		</dependency>
		
/META-INF/resources/webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js
/META-INF/resources/webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css

https://bootstrap-datepicker.readthedocs.io/en/latest/

Usage
Call the datepicker via javascript:
$('.datepicker').datepicker({
    format: 'mm/dd/yyyy',
    startDate: '-3d'
});

## JSPF - JSP fragments
jsp/common/navigation.jspf
jsp/common/header.jspf
jsp/common/footer.jspf

include directive

<%@ include file="common/navigation.jspf" %>
<%@ include file="common/header.jspf" %>
<%@ include file="common/footer.jspf" %>


## Spring Security

       <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>

SpringSecurityConfiguration.java

LDAP
Lightweight Directory Access Protocol (LDAP)
LDAP is a software protocol that helps users to find access information in a network

In memory
## H2 Database
<dependency>
<groupId>com.h2database</groupId>
<artifactId>h2</artifactId>
<scope>runtime</scope>
</dependency>

<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

H2 console available at'/h2-console'
Database available at 'jdbc:h2:mem:db_todo_h2'

--Disable CSRF (CROSS SITE REQUEST FORGERY)
-- Disable Frames 
		

