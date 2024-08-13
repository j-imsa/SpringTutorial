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