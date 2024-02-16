## This project demonstrates the practical application of knowledge of the Spring Framework and Hibernate ORM.
<b>It includes:</b>

CRUD operations:
- Create
- read
- update
- delete
  
Entity relationships:
- one-to-many
- self-join one-to-many 
- self-join many-to-many
- many-to-many
- one-to-one
- one-to-one with shared pk 
  
EntityManager:
Using EntityManager and its methods to work with entities.

---
<b>Technologies:</b>

- Spring Framework
- Hibernate ORM
- Java

---
<b>Instructions:</b>

Clone the repository:

`git clone https://github.com/your-username/spring-hibernate-practice.git`

Run the project:

`mvn spring-boot:run`

---
<b>Test the API:</b>

You can use Postman or src/main/resources/scratch.http to test the API.
The following APIs are available:
- GET /entities: Get a list of entities.
- POST /entities: Create a new entity.
- GET /entities/{id}: Get an entity by ID.
- PUT /entities/{id}: Update an entity by ID.
- DELETE /entities/{id}: Delete an entity by ID.

---
*Links:*

Spring Framework: https://spring.io/<br>
Hibernate: https://hibernate.org/
