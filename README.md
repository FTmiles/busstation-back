# Bus Station manager - Back-end Java Spring Boot

## Instructions
1. Needs JRE to run 
2. Clone the repo
3. Navigate to the dir (busstation-back)
4. Run from IDE

## Environment
- Java 21
- MySQL

## Run MySQL
My way to set it up is with WSL
- Install docker
- docker pull mysql:latest
- docker run --name mysql-container -e MYSQL_ROOT_PASSWORD=XXXXXXX -d -p 3306:3306 mysql:latest

## Config
`resources/application.properties` file 

## Build artifact
needs some changes in code, ATM check commit from 2023 March. But it was on Maven, figure it out bud!

## Features
* Fully secured with Spring Security
* Supports CRUD and more
* DTO classes for file transfer
* High test coverage

## Build JAR not WAR
`./gradlew bootJar` - or via Gradle UI > Tasks > Build > bootJar
- Builds a .jar at `dist/libs/` (Direct Spring Boot JAR build)
    
`./gradlew build` - or via Gradle UI > Tasks > Build > build
- Runs tests, compiles code, and then runs `./gradlew bootJar`

---

The front-end can be found at
https://github.com/FTmiles/busstation-front


The main town bus station must be bus stop id 1L.
With the 1L bus stop input, you get access to "City buses" radio button. Which is 


#########
Manually insert user roles into the DB
INSERT INTO roles(NAME) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_MODERATOR');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');

########
# Register a new user
POST request to http://localhost:8080/api/auth/signup
JSON Body:
{
"username":"chad",
"email":"xxx@asd.com",
"password":"12345678",
"role": ["user", "mod", "admin"]
}

###
# Postman sign in to get JWT token
POST request to http://localhost:8080/api/auth/signin
JSON body:
{
    "username" : "chad",
    "password" : "12345678"
}

###
Close registration - disable the controller method @Controllers>AuthController
