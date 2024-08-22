# Spring Tutorial

---

### Core

* IoC
* DI
* Beans
    * Step1: Creating beans
        * @Bean
        * @Component
    * Step2: Wiring (@Autowiring)
* Context
* SpEL
* IoC Container

---

#### Stereotype Annotations

- @Component
    - @Controller
    - @Service
    - @Repository

---

#### Bean Scope

1. Singleton
    - use case:
        - **immutable beans**
        - service layers
        - repository layers
    - points:
        - mutable singleton beans + multi thread environment => race condition
        - mutable singleton beans + multi thread environment + synchronization => **NOT** race condition
        - NOT best practice = **bad practice** => mutable singleton beans
2. Prototype
3. Request
4. Session
5. Application

---

### Aspect Oriented Programming (AOP)

- WWW
    - **What** -> Aspect
    - **When** -> Advice
    - **Witch** -> Pointcut
    - Join Point
    - Target Object

---

- Proxy Object of beans
    - Weaving
    - intercept
    - delegate

---

- Advice:
    1. @Before
    2. @AfterReturning
    3. @AfterThrowing
    4. @After
    5. @Around

---

### Web App

- Web Server
    - Servlet Container (Http web server -> Http servlet object)
        - in: ServletRequest
        - out: ServletResponse
        - Apache Tomcat

---

#### Dispatcher Servlet

- before:
    - /home => HomeServlet
    - /about => AboutServlet
    - /... => ...Servlet
- after:
    - /* => DispatcherServlet

---

### Web application

1. Approach 1: **Spring MVC** + Spring Core + Spring Boot + ...
2. Approach 2: Spring Core + Spring Boot + ...

---

### Spring Boot

1. SpringBoot Starters
    - spring-boot-starter-web
2. Autoconfiguration
    - convention-over-configuration
3. Actuator and DevTools
    - monitor app health, metrics, etc.
    - LiveReload Server

---

### Java Template Engine

- [Thymeleaf](https://www.thymeleaf.org/)
- [Apache FreeMarker](https://freemarker.apache.org/index.html)
- [jte](https://jte.gg/)
- Jakarta Server Page (JSP)
- Jakarta Server Face (JSF)
    - [PrimeFace](https://www.primefaces.org/)
- ...

---

#### Fetching Data

1. @PathVariable
    - www.jimsa.be/app/course <- Path variable
2. @RequestParam
    - www.jimsa.be/app?course=math&active=true <- Query Param
    - Form data

---

#### Validation

- spring-boot-starter-validation:
    1. jakarta.validation.constraints.*
        - @Digits
        - @Email
        - @Max
        - @Min
        - @Not...
        - @Pattern
        - @Size
    2. org.hibernate.validator.constraints.*
        - @CreditCardNumber
        - @Length
        - Currency
        - @Range
        - @URL
        - @UniqueElements
        - @EAN
        - @ISBN

---

#### Spring Web Scope

- Singleton
- Prototype

3. Request
    - @RequestScope
4. Session
    - @SessionScope
5. Application
    - ApplicationScope

---

### Security

- [Thymeleaf Extras Springsecurity6](https://mvnrepository.com/artifact/org.thymeleaf.extras/thymeleaf-extras-springsecurity6)
- CSRF

---

- Encoding
    - unicode
    - base64
    - ascii
    - file formats
- Encryption
    - key
    - encryption
- Hashing
    - hash value
    - hashing function

---

- Password Encoder (using _hash algorithms_)
    - NoOpPasswordEncoder (No hashing stories in plain text)
    - StandardPasswordEncoder
    - Pbkdf2PasswordEncoder
    - BCryptPasswordEncoder (most commonly use)
    - SCryptPasswordEncoder

---

### Database

---

- H2
    - in-memory
    - schema.sql
    - data.sql
    - /h2-console
    - sa & ''

---

1. JDBC
    - loading driver
    - management connections
    - statements
    - resultSets
    - ...

---

2. Spring JDBC
    - spring-boot-starter-jdbc
    - JdbcTemplate

```java
String lastName = this.jdbcTemplate.queryForObject(
        "select last_name from users where id = ?",
        String.class,
        123L
);
```

- NamedParameterJdbcTemplate

```java
public int getCount(String firstName) {
    String sql = "select count(*) from users where first_name = :first_name";
    SqlParameterSource namedParameters = new SqlParameterSource("first_name", firstName);
    return this.namedParameterJdbcTemplate.queryForObject(
            sql,
            namedParameters,
            Integer.class
    );
}
```

- Using RowMapper
    - BeanPropertyRowMapper
- application.properties
    - spring.jdbc.template.*
    - spring.jdbc.template.max-rows=500

---

3. Spring Data Projects [Link](https://spring.io/projects/spring-data)
    - Projects:
        - Spring Data JDBC
        - Spring Data JPA
        - Spring Data LDAP
        - Spring Data MongoDB
        - Spring Data Redis
        - Spring Data R2DBC
        - Spring Data REST
        - Spring Data for Apache Cassandra
        - Spring Data for Apache Geode
        - Spring Data Couchbase (community module)
        - Spring Data Elasticsearch (community module)
        - Spring Data Envers
        - Spring Data Neo4j (community module)
        - ...
    - Main modules
        - Spring Data Commons
            - Repository (marker interface)
                - CrudRepository
                    - ListCrudRepository
                - PagingAndSortingRepository
                    - ListPagingAndSortingRepository
        - Spring Data JPA
            - JpaRepository
    - Community modules

---

> ## Project
>
> create a standalone Spring App which use two databases like MySql and PostgreSQL!
>
> - dependency
> - application.yml (application.properties)
>   - spring.datasource.mysql/postgres.url/username/password/driver-class-name
>   - jpa.hibernate.ddl-auto
>   - jpa.mysql/postgres.properties.hibernate.dialect
> - DataSource
> - EntityManager
> - TransactionManager
> - LocalContainerEntityManagerFactoryBean
> - EntityManagerFactoryBuilder
> - PlatformTransactionManager
> - JpaTransactionManager
> - @Primary
> - @Qualifier
> - @PersistenceContext(unitName = "mysqlPU")
> - private EntityManager mysqlEntityManager;
> - @PersistenceContext(unitName = "postgresPU")
> - private EntityManager postgresEntityManager;

---

- JConnector
- JDBC
- JPA
- Spring Data
- Spring Data JPA
- Hibernate

---

- Query Methods in Spring Data JPA
    - introducer + **By** + criteria
- Auditing Support by Spring Data JPA
    - @CreatedDate
    - @CreatedBy
    - @LastModifiedDate
    - @LastModifiedBy

---

### Custom Validation

1. @interface...
2. impl ...
3. using ...

---

```java
import jakarta.persistence.Transient;

@Transient
private String noDbOp; // Won't participate in DB operations like creating a table's column
```

---

## Database Relations

> IMPORTANT : [Link](https://github.com/j-imsa/Database-Relations)

---

### Sorting

1. static
   - ```findByOrderByNameDesc()```
2. dynamic
   - ```Sort.by("name").descending().and(Sort.by("age"))```


---

### Paging

```java
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

Pageable pageable = PageRequest.of(
        0,
        10,
        Sort.by("name").descending()
);
Page<Person> personPage = repo.findByName(name, pageable);
```

---

### Custom Query with JPA

1. @Query
   - JPQL
   - Native SQL query (`nativeQuery=true`)
2. @NamedQuery
3. @NamedNativeQuery
   - Spring Data JPA doesn’t support dynamic sorting for native queries
   - Example:
     - [Link 1](https://github.com/eazybytes/spring/blob/3.3.1/example_44/src/main/java/com/eazybytes/eazyschool/model/Contact.java)
     - [Link 2](https://github.com/eazybytes/spring/blob/3.3.1/example_44/src/main/java/com/eazybytes/eazyschool/repository/ContactRepository.java)

---

- Update, Delete, Insert
  - `@Transactional`
  - `@Modifying`

---

## Rest APIs

- `@RestController = @Controller + @ResponseBody`
- `@RestControllerAdvice`
- `ReponseEntity<T>`
- `RequestEntity<T>` -> `getBody()`
- `@RequestHeader`
- `@RequestBody`

---

#### Cross-origin resource sharing (CORS)

- protocol
- domain
- port


- `@CrossOrigin("*")`

---

### Jackson JSON

[link](https://docs.spring.io/spring-framework/reference/web/webmvc/mvc-controller/ann-methods/jackson.html)

```java
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

@JsonProperty("first_name")
private String firstName;

@JsonIgnore
private LocalDateTime createdAt;
```

---

Requests:


```
curl --location 'http://localhost:8090/springapp/api/person'
```


```
curl --location --request GET 'http://localhost:8090/springapp/api/person/byRequestBodyAnnotation' \
--header 'Content-Type: application/json' \
--data '{
    "first_name": "jimsa2",
    "last_name": "salehi2"
}'
```


```
curl --location 'http://localhost:8090/springapp/api/person' \
--header 'invocationFrom: mobile' \
--header 'Content-Type: application/json' \
--data '{
    "first_name": "jimsa3",
    "last_name": "salehi3"
}'
```

```
curl --location --request DELETE 'http://localhost:8090/springapp/api/person' \
--header 'Content-Type: application/json' \
--data '{
    "first_name": "jimsa4",
    "last_name": "salehi4"
}'
```


```
curl --location --request PATCH 'http://localhost:8090/springapp/api/person' \
--header 'Content-Type: application/json' \
--data '{
    "first_name": "jimsa6"
}'
```

---

### Rest APIs consuming

> IMPORTANT : [Link](https://github.com/j-imsa/Rest-APIs-Consuming)

---


### Spring Data Rest & HAL Explorer

- [link1](https://github.com/j-imsa/Spring-Data-Rest-HAL-Explorer)
- [link2](https://spring.io/projects/spring-data-rest)
- [link3](https://docs.spring.io/spring-data/rest/reference/tools.html)

---

### Logging

* AOP -> MyLogAspect


Libs:

- Java util logging
- Log4J2
- SLF4J
- Logback 
  - The default logging framework
  - The default logging destination is the console
    - System.out
    - System.err 
  - [Link](https://wirekat.com/logging-in-java-spring-boot-best-practices-and-tutorial/)


Levels:

- fatal
- error
- warn
- info
- debug
- trace

---

### Configuration

- @Value
- environment.getProperty("...") 
- `-> default into application.properties`


---

### Profile

- application_prod.properties
- application_dev.properties

`spring.profiles.active`

- @Profile("!dev")

---

