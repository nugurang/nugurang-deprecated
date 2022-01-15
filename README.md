# Nugurang - Teammate matchmaking application

[![GitHub version](https://badge.fury.io/gh/nugurang%2Fnugurang.svg)](https://badge.fury.io/gh/nugurang%2Fnugurang)
[![License: MPL 2.0](https://img.shields.io/badge/License-MPL%202.0-brightgreen.svg)](https://opensource.org/licenses/MPL-2.0)
![nugurang-front](https://github.com/nugurang/nugurang/workflows/nugurang-front/badge.svg?branch=dev&event=push)
![nugurang-back](https://github.com/nugurang/nugurang/workflows/nugurang-back/badge.svg?branch=dev&event=push)
<p align="center">
  <img src="https://user-images.githubusercontent.com/33483938/95418678-fff37880-0972-11eb-805c-1b598dbf47cf.jpg" width = "70%">
</p>


Nugurang is a teammate matchmaking service for students who have trouble finding teammates. Nugurang can help you to recruit members and execute projects. Users can leave feedback for other teammates at the end of the project, and this data is used for optimal teammate-recommendation for each user.

## Development stack
Frontend framework
* [React](https://reactjs.org/)
* [Next.js](https://nextjs.org/)

Backend framework
* Java 11
* [Spring Boot](https://spring.io/projects/spring-boot)


## Backend Setup

### Create Secret File


Move to backend resources directory:

```
cd [[project_root_directory_here]]/nugurang-back/src/main/resources
```

Create application-secret.properties:

```
spring.security.oauth2.client.registration.github.client-id=[[enter_here]]
spring.security.oauth2.client.registration.github.client-secret=[[enter_here]]
spring.security.oauth2.client.registration.github.scope=profile,email
spring.profiles.include=kakao
spring.security.oauth2.client.registration.kakao.client-id=[[enter_here]]
spring.security.oauth2.client.registration.kakao.client-secret=[[enter_here]]
spring.security.oauth2.client.registration.kakao.scope=profile,email
nugurang.addr.front.url=http://localhost:3000
```

Move to backend directory:

```
cd [[project_root_directory_here]]/nugurang-back
```

### Launch

Launch backend:

> ```
> ./gradlew build
> ./gradlew bootRun
> ```


## Frontend Setup

### Installation

Move to frontend directory:

```
cd [[project_root_directory_here]]/nugurang-front
```


Install Node packages:

> using npm: 
> ```
> npm install
> ```

> using yarn: 
> ```
> yarn install
> ```


### Create Secret File

Create .env.local:

```
NEXT_PUBLIC_BACKEND_ADDR = http://localhost:8080
NEXT_PUBLIC_BACKEND_ADDR_PUBLIC = http://localhost:8080
```


### Launch

Launch frontend in development mode:

> using npm: 
> ```
> npm run dev
> ```

> using yarn: 
> ```
> yarn run dev
> ```

Launch frontend in production mode:

> using npm: 
> ```
> npm run build
> npm start
> ```

> using yarn: 
> ```
> yarn run build
> yarn start
> ```