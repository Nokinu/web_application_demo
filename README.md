# Moive Review Back-End Web Application (Mircoservice)
## 1) Project Description
This project is a back-end Restful web application which is built with the following tech stack:
1. Application Framework - SpringBoot + JDK8
2. Application Database  - MongoDB (Cloud Cluster)
3. Application Cache     - Redis
4. Application Message Queue - RabbitMQ
5. Application Circuit Breaker/Retry - Resilience4j
6. Application Unit Test - Junit4/SpringBoot Test
7. Application Performance Test Tool - JMeter

## 2) Project Code Style/Rule
### 1) Avoid "reinvent the wheel" for project logic solutions including:
#### 1a - Caching Solution
#### 1b - Message Queue Solution
#### 1c - Circuit Breaker/Retry Solution
#### 1d - Logging Solution

### 2) All logic solutions should be handled by aspect as：
#### 2a - Decouping business logic (Clean code)
#### 2b - Code reusable
#### 2c - Code maintanence

## 3) Project Key Functions
### This project not only meets the business requirements, but also need to be compatiable with High Concurrency Requirements.
#### 1) Return movie's info by title from MongoDB via Rest API
##### Handle High Concurrency
##### 1a - RateLimit - com.google.guava
###### one IP address limits 5 requests per second

##### 1b - BloomFilter - com.google.guava
###### When application starts, load the movie title into BloomFilter (This process should be able to use mulitple )
###### To handle Cache Penetration by filter request - when both cache and DB has null for request
###### Also create a schedule task to refresh BloomFilter every day at 4:00am

##### 1c - 2 layer-caching - com.github.xiaolyuh
###### To handle Cache Penetration by saving null.
###### To handle Cache Avalanche by 2 layer caching

##### 1d - RedisLock - Spring Redis Integration
###### To handle Hotspot Invalid - when cache is null but DB has data

#### 2) Return movie's all comments from 3rd Party API via Rest API
##### Use Circuit Breaker and Retry policy from Resilience4j to handle 3rd Party API Call

#### 3) Add movie's review comments API to both MongoDB and 3rd Party APT via Rest API
##### Use message queue to handle the POST request when adding comments

## 4) Unit Test solution
### Unit test and Integration test should be written to cover business cases.

## 5) Next Step for this project
1. Complete missing functions - CRUD comments
2. Add missing Unit Tests
3. Add regression Tests by creating regression test DB
4. Create User Web application (Mircoservice) to handle User signup, signin etc (I would choose Shiro framework)
5. Create Admin Web application (Mircoservice) to handle CRUD movies
6. Create a Microservice Dicovery Service   


## 6) Project Running Enironment
### Precondition:
Using Intellij to development
1. Intall Redis
2. Intall RabbitMQ
3. Update the configuration.yaml to connect Redis and RabbitMQ based on your setup
4. Run SpringBoot application from IDE

# Moive Review Front-End Web Application (Single Page Application)
## Functional Requirement
### Admin Page Application
1. Admin Login
2. Moive CRUD
3. User management

### User Page Application
1. User signup/signin
2. Movie Comments CRUD
3. Search Movie info

## Practical Solution for Front End to handle large data
1. Break down large data into mulitple small arrays.
2. Create filtering/paging for data display.
3. Only renderer the data in pointview - such as Virtual Scrolling (Angular’s CDK)
