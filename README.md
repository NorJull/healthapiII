# umedicalapi

Basically this is a guide to understand how to access the umedicalapi.

Next, I explain each one of the endpoints and their responses:


Departaments:

Method:Get	      
Path:	 /departaments	               
Response: Returns all the records of the department entity that are in the database.

Method:Get	      
Path:	 /departaments/{id}	               
Response:   Returns the record with that id.


Towns:

Method:Get	      
Path:	 /towns	               
Response: Returns all the records of the town entity that are in the database.

Method:Get	      
Path:	 /towns/{id}	               
Response   Returns the record with that id.


PersonalInformations:

Method:Get	      
Path:	 /personalInformations            
Response: Returns all the records of the personalInformation entity that are in the database.

Method:Get	      
Path:	 /personalInformations/{id}	               
Response   Returns the record with that id.

Method:Post
Path: /personalInformations
Response: Allows us to add a new record to the database.

Method:Put
Path: /personalInformations/{id}
Response: Update the record with that id.

Method:Delete
Path: /personalInformations/{id}
Response: Delete the record with that id.


Patients:

Method:Get	      
Path:	 /patients            
Response: Returns all the records of the patient entity that are in the database.

Method:Get	      
Path:	 /patients/{id}	               
Response   Returns the record with that id.

Method:Post
Path: /patients  
Response: Allows us to add a new record to the database.

Method:Put
Path: /patients/{id}
Response: Update the record with that id.

Method:Delete
Path: /patients/{id}
Response: Delete the record with that id.

