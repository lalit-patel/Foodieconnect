## FoodieConnect
FoodieConnect is an online food ordering backend built with Java and Spring Boot. It provides REST APIs for managing users, restaurants, menus, carts, and orders, and is designed as a production-style portfolio project for backend/Java developer roles.
## Features

- User registration and login (JWT-based authentication if enabled)

- Role-based access (e.g., customer, admin, restaurant owner)

- Restaurant and menu management

- Place and track food orders

- Basic order history for users

- Layered architecture (controller → service → repository → database)


## API OverView

Auth:

- POST /auth/signup – Register new user

- POST /auth/signin – Login and obtain token

Restaurants / Menu:

- GET /api/restaurants/{id}/add-favourites – List favourites from the restaurants

- GET /api/restaurants/{id}/menu – Finds restaurant by ID

Orders:

- POST /api/orders – Place an order

- GET /api/orders/user – Get current user’s orders




## Screenshots

![Swagger UI](https://github.com/user-attachments/assets/c1df9710-39ac-4661-ae3c-5a3f98d7a669)

