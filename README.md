# Hiking-Back API

This is a rebuilt back end for a decoupled front end. This API takes advantage of Java, Spring Boot, and Maven.
The application can make calls to this API which includes two models, users and trails.

## Getting Started

this back end uses Spring framework and Maven, and with some knowledge in both of those libraries you should be able to run this API.

## Routes

### Users

| Method | Path | Action|
|--------|------|-------|
| GET | /users | list of users |
| GET | /users/{id} | users info |
| GET | /users/current | logged in users info |
| PUT | /users{id} | update users info |
| POST | /users | creates a new user, starts sesssion |
| POST | /login | logs in user, starts session |
| DELETE | /users{id} | delete specific user and associated trails |

### Trails

| Method | Path | Action|
|--------|------|-------|
| POST | /trails | attaches a trail to the current user |
| DELETE | /trails/{id} | deletes trail from user |

## Models

### User

```
id,
username,
password,
location
```

### Trail

```
user(ref),
id,
name,
location,
length,
high,
stars,
url
```

