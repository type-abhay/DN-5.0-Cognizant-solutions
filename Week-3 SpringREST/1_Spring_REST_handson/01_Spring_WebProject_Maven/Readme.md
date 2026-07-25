# Hands On 1 - Spring Web Project using Maven

## 1. src/main/java
This folder contains the main application code of the project such as Java classes, controllers, services and business logic.

## 2. src/main/resources
This folder contains application configuration files and resources like application.properties, static files and templates.

## 3. src/test/java
This folder contains test classes used for unit testing and checking application functionality.

## 4. SpringLearnApplication.java
SpringLearnApplication.java is the main class of the Spring Boot application.

### main() method
The main() method is the entry point of the application.

```java
public static void main(String[] args) {
    SpringApplication.run(SpringLearnApplication.class, args);
}
```

SpringApplication.run() starts the Spring Boot application, initializes Spring container and starts the embedded server.

## 5. Purpose of @SpringBootApplication
@SpringBootApplication is used to enable Spring Boot auto configuration, component scanning and configuration support.

It combines:
- @Configuration
- @EnableAutoConfiguration
- @ComponentScan

## 6. pom.xml
pom.xml is the Maven configuration file used to manage project dependencies, plugins and build settings.

### Configuration in XML file

#### Parent
spring-boot-starter-parent provides default Spring Boot configurations.

#### Group ID
com.cognizant represents organization/package name.

#### Artifact ID
spring-learn is the project name.

#### Version
0.0.1-SNAPSHOT is the current development version.

#### Properties
Java version is set to 21.

#### Dependencies
- spring-boot-starter-web → used for web application development
- spring-boot-devtools → used for automatic restart during development
- spring-boot-starter-test → used for testing

#### Build Plugin
spring-boot-maven-plugin is used to build and run Spring Boot applications.

## Dependency Hierarchy
Dependency hierarchy shows direct and transitive dependencies of the project.

Main dependencies observed:
- spring-boot-starter-web
- spring-boot-starter
- spring-boot
- spring-boot-autoconfigure
- spring-web
- logging libraries

## Result
Spring Web project was created successfully using Maven and executed successfully in Eclipse.