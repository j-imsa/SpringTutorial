# Spring Tutorial


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


#### Stereotype Annotations

- @Component
  - @Controller
  - @Service
  - @Repository


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


#### Aspect Oriented Programming (AOP)

- WWW
  - **What** -> Aspect
  - **When** -> Advice
  - **Witch** -> Pointcut
  - Join Point
  - Target Object

- Proxy Object of beans 
  - Weaving
  - intercept
  - delegate

- Advice:
  1. @Before
  2. @AfterReturning
  3. @AfterThrowing
  4. @After
  5. @Around


### Web App

- Web Server
  - Servlet Container (Http web server -> Http servlet object)
    - in: ServletRequest
    - out: ServletResponse
    - Apache Tomcat

#### Dispatcher Servlet

- before:
  - /home => HomeServlet
  - /about => AboutServlet
  - /... => ...Servlet
- after:
  - /* => DispatcherServlet


#### Web application

1. Approach 1: **Spring MVC** + Spring Core + Spring Boot + ...
2. Approach 2: Spring Core + Spring Boot + ...


#### Spring Boot

1. SpringBoot Starters
   - spring-boot-starter-web
2. Autoconfiguration
   - convention-over-configuration
3. Actuator and DevTools
   - monitor app health, metrics, etc.
   - LiveReload Server


#### Java Template Engine

- [Thymeleaf](https://www.thymeleaf.org/)
- [Apache FreeMarker](https://freemarker.apache.org/index.html)
- [jte](https://jte.gg/)
- Jakarta Server Page (JSP)
- Jakarta Server Face (JSF)
  - [PrimeFace](https://www.primefaces.org/)
- ...


#### Fetching Data

1. @PathVariable
   - www.jimsa.be/app/course <- Path variable
2. @RequestParam
   - www.jimsa.be/app?course=math&active=true <- Query Param
   - Form data


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


#### Spring Web Scope

- Singleton
- Prototype
3. Request
   - @RequestScope
4. Session
   - @SessionScope
5. Application
   - ApplicationScope


#### Security

- [Thymeleaf Extras Springsecurity6](https://mvnrepository.com/artifact/org.thymeleaf.extras/thymeleaf-extras-springsecurity6)
- CSRF

#### Database

- H2
   - in-memory
   - schema.sql
   - data.sql
   - /h2-console
   - sa & ''


<hr/>

1. JDBC
   - loading driver
   - management connections
   - statements
   - resultSets
   - ...


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
String sql = "select count(*) from users where first_name = :first_name";
SqlParameterSource namedParameters = new SqlParameterSource("first_name", XXX);
this.namedParameterJdbcTemplate.queryForObject(
        sql,
        namedParameters,
        Integer.class
);
```
   - Using RowMapper
     - BeanPropertyRowMapper
   - application.properties
     - spring.jdbc.template.*
     - spring.jdbc.template.max-rows=500


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
   
   
> ##### Project
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
>   - private EntityManager mysqlEntityManager;
> - @PersistenceContext(unitName = "postgresPU")
>   - private EntityManager postgresEntityManager;

<hr/>

- JConnector
- JDBC
- JPA
- Spring Data
- Spring Data JPA
- Hibernate

<hr/>

- Query Methods in Spring Data JPA
  - introducer + **By** + criteria
- Auditing Support by Spring Data JPA
  - @CreatedDate
  - @CreatedBy
  - @LastModifiedDate
  - @LastModifiedBy