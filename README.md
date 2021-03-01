# contacts-service-exercise

 Overview :
  
 REST API that will enable a client to perform CRUD operations on the contact collection.
  
 Technology Stack: Java,RESTful Api, JPA, Spring Boot. H2 
 
 For Testing clone the git repo and import it to the inteliJ or eclipse and run spring:boot run. 
 
 1. To Buld it : 
    mvn clean install . 
    
2.  run it locally and in browser open localhost:8081/contacts . 
    
    Different REST end-points are 
     -GET	/contacts	List all contacts
    - POST	/contacts	Create a new contact
    - PUT	/contacts/{id}	Update a contact
    - GET	/contacts/{id}	Get a specific contact
    - DELETE	/contacts/{id}	Delete a contact
    - GET	/contacts/call-list	Get a call list 
    
 
 Sample Json Schema: 
 Input Json will have the following Json schema. 
 
 {   "name": {     "first": string,     "middle": string,     "last": string    },   "address": {     "street": string,     "city": string,     "state": string,     "zip": string   },   "phone": [     {       "number": string,       "type": string ["home" | "work" | "mobile"]     }   ],   "email": string }

         

