
We will have 2 tables in the database to start - Tasks and Users

We will need at least 5 classes in the persistence layer:
 - one POJO for each table - Task and User
 - one DAO for each table - TaskDao and UserDao
 - One class for creating and maintaining the connection to the db - ConnectionManager

We will need to "stub out" corresponding service layer classes and web API layer classes for each DAO.
DAO's are the objects where we implement the CRUD behavior. The whole point of the server part of our 
application is just to deal with that data, so in order to invoke various CRUD operations in the persistence
layer, we need to start the behavior, the flow of execution, in the web API layer, access a service
layer class, and finally access the DAO.