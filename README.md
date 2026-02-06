A) Project Overview

Purpose of API
This project is simple Java API with JDBC and PostgreSQL.
Purpose is to learn OOP and database connection in real project.
API manages music festival backstage data.

Summary of entities and relationships
Stage and Performer are main entities.
One Stage can have many Performers.
Performer works on one Stage.

OOP design overview
Project uses abstract class BaseEntity.
Stage and Performer extend BaseEntity.
Interfaces Validatable and Payable are used.
Project uses encapsulation, inheritance and polymorphism.

B) OOP Design Documentation

Abstract class and subclasses
BaseEntity is abstract class.
It has id and name fields.
It has abstract methods validate() and getInfo().
Stage and Performer extend BaseEntity.

Interfaces and implemented methods
Validatable interface is used to validate data.
Payable interface is used to calculate payment for performer.

Composition / aggregation
Performer contains stageId which connects to Stage.
This is relation between objects and database tables.

Polymorphism examples
BaseEntity reference can store Stage or Performer object.
Methods work differently depending on object type.

UML diagram
BaseEntity on top.
Stage and Performer below it.

C) Database Description

Schema, constraints, foreign keys
Database has two tables: stages and performers.
Primary key is id in both tables.
Stage name is unique.
Performance fee must be greater than 0.
Foreign key performers.stage_id connects to stages.id.

Sample SQL inserts
INSERT INTO stages(name, location) VALUES ('Main Stage','North Field');
INSERT INTO performers(name,type,stage_id,performance_fee) VALUES ('DJ Alex','Solo',1,5000);

D) Controller

Summary of CRUD operations
Main class works like controller.
User can create stage.
User can see all stages.
User can create performer.
User can see all performers.

Example request / response
User enters stage name → stage saved in database.
User requests list → data loaded from database.

E) Instructions to Compile and Run

Example commands for Java

Install PostgreSQL
Create database Music
Run schema SQL

Open project in IntelliJ
Add PostgreSQL JDBC driver

Run Main.java

F) Screenshots


Successful stage insert
Successful performer insert
Error when duplicate stage name
Error when wrong stage id

G) Reflection Section

What I learned
I learned how JDBC connects Java and database.
I learned how OOP works in real project.
I learned layered architecture.

Challenges faced
Database connection errors.
Foreign key errors.
Understanding repository layer.

Benefits of JDBC and multi layer design
Code is more structured.
Easy to separate logic and database work.
Easy to maintain project.
