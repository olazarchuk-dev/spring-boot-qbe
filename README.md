# Spring Data JPA + Query By Example (QBE)

### Иллюстрация выполнения sql-запроса на Query By Example (QBE) в Spring Data JPA

`Query By Example (QBE)` — это удобный для разработчиков метод sql-запросов, который упрощает написание динамических sql-запросов без какого-либо специального sql-языка
и позволяет нам выполнять sql-запросы на основе экземпляра-Entity.

Это позволяет нам выполнять запросы в **Spring Data JPA** на основе экземпляра объекта **org.springframework.data.domain.Example**.
```java
//get all the customers whose first name is ending with 'dra' 
var customers = Customers.builder().firstName(ending).build();
var matcher = ExampleMatcher.matching()
             .withIgnoreNullValues()
             .withMatcher("firstName", 
                          match -> match.endsWith().ignoreCase(true));
var example = Example.of(customers, matcher);
```
По умолчанию поля, имеющие нулевые значения, игнорируются в базовом запросе, поэтому приведенный выше пример будет эквивалентен следующему **JPQL**:
````sql
SELECT t from Customer c where c.firstName = '%dra';
````

* `Tutorial`: https://www.baeldung.com/spring-data-query-by-example
* **(**`Tutorial-2`**)**: https://talk2debendra90.medium.com/spring-data-jpa-query-by-example-qbe-a9c817248c0d
* `Repo`: https://github.com/spring-projects/spring-data-examples/tree/main/jpa/query-by-example
* **(**`Repo-2`**)**: https://github.com/talk2debendra/spring-boot/tree/master/spring-boot-qbe

# Technologies
- Spring Boot data JPA
- Lombok
- H2

# API
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


---

Example usage for org.springframework.data.domain Example of:
* https://www.logicbig.com/tutorials/spring-framework/spring-data/query-by-example.html
* http://www.java2s.com/example/java-api/org/springframework/data/domain/example/of-2-3.html
* https://www.programcreek.com/java-api-examples/?api=org.springframework.data.domain.Example