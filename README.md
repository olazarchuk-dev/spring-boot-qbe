# Spring Data JPA + Query By Example (QBE)

### Иллюстрация выполнения sql-запроса на Query By Example (QBE) в Spring Data JPA

`Query By Example (QBE)` — это удобный для разработчиков метод запросов, который упрощает написание динамических запросов без какого-либо специального языка запросов.

Это позволяет нам выполнять запросы в **Spring Data JPA** на основе экземпляра объекта **org.springframework.data.domain.Example**.
```java
//get all the customers whose first name is ending with 'dra' 
var customers = Customers.builder().firstName(ending).build();
var matcher = ExampleMatcher.matching()
             .withIgnoreNullValues()
             .withMatcher("firstName", 
                    match ->match.endsWith().ignoreCase(true));
var example = Example.of(customers, matcher);
```
По умолчанию поля, имеющие нулевые значения, игнорируются в базовом запросе, поэтому приведенный выше пример будет эквивалентен следующему **JPQL**:
````sql
SELECT t from Customer c where c.firstName = '%dra';
````

* `Tutorial`: https://talk2debendra90.medium.com/spring-data-jpa-query-by-example-qbe-a9c817248c0d
* `Repo`: https://github.com/talk2debendra/spring-boot/tree/master/spring-boot-qbe

# Technologies
- Spring Boot: 11
- Spring Boot: 2.2.0.RELEASE
- Spring Boot data JPA
- Lombok
- H2


# How to run
- Run the application as Springboot application
- While application start-up, it will inser the data from data-h2.sql 


# API (s)
1. Get All customers
	http://localhost:8080/customer/list
2. Get all customers whose first name ends with 
	http://localhost:8080/customer/firstname?endsWith=dra
3. Get all customers whose last name ends with
	http://localhost:8080/customer/lastname?endsWith=das
4. Get all customers whose first name equals
	http://localhost:8080/customer/rosalin
5. Get all customers whose wallet balance is
	http://localhost:8080/customer/balance?balance=5000




