<h1 align="left">Chronicle Base</h1>

###

<p align="left">In this project, a RESTful API was developed for managing users and posts in a social media-like platform.<br><br>For the development of the API, Java with Spring Boot was used to build the backend, and the MongoDB database was integrated using Spring Data MongoDB.<br><br>The project follows the SOLID principles for Object-Oriented Design and REST principles for API development, along with a MSC (Model-Service-Controller) architecture.</p>

###

<h2 align="left">Tech Stack</h2>

###

[![stack](https://skillicons.dev/icons?i=java,spring,mongodb&theme=dark&height=120)](https://skillicons.dev)

###

<h2 align="left">Endpoints</h2>

<h3 align="left">Users</h3>

| Method | Functionality | URL |
|---|---|---|
| `POST` | Create new user  | http://localhost:8080/users |
| `GET` |  List all users  | http://localhost:8080/users |
| `GET` |  List user based on its _id  | http://localhost:8080/users/:id |
| `GET` |  List all user posts based on its _id  | http://localhost:8080/users/:id/posts |
| `POST` |  Create new user post based on its _id  | http://localhost:8080/users/:id/posts |
| `PUT` |  Update user based on its _id  | http://localhost:8080/users/:id |
| `DELETE` | Delete user based on its _id  | http://localhost:8080/users/:id |

#### The `POST` and `PUT` endpoints require a JSON object in the following format:

```JavaScript
{
  name: "John Doe",
  email: "johndoe@gmail.com"
}
```

#### The `POST` endpoint (new user post) require a JSON object in the following format:

```JavaScript
{
  title: "Trip to Hawaii",
  body: "Best waves in the world!"
}
```

###

<h3 align="left">Posts</h3>

| Method | Funcionality | URL |
|---|---|---|
| `GET` |  List all posts  | http://localhost:8080/posts |
| `GET` |  List post based on its _id  | http://localhost:8080/posts/:id |
| `GET` |  List posts based on their title  | http://localhost:8080/posts/search?title= |
| `GET` |  List posts based on their title, body or comments and min-max dates  | http://localhost:8080/posts/full-search?text=&min_date=&max_date= |
| `PUT` |  Update post based on its _id  | http://localhost:8080/posts/:id |
| `DELETE` |  Delete post based on its _id  | http://localhost:8080/posts/:id |
| `POST` |  Create new comment on post based on post_id and user_id  | http://localhost:8080/posts/:post_id/comment/:user_id |


#### The `PUT` endpoint requires a JSON object in the following format:

```JavaScript
{
  title: "Trip to California",
  body: "Best waves in the world!"
}
```

#### The `POST` endpoint requires a JSON object in the following format:

```JavaScript
{
  body: "So cool!"
}
```
