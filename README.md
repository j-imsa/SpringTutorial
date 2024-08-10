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

