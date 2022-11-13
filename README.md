# REST API for Online Cab Booking Application
<img align="left" alt="Coding" width="153" src="
                                                ">

we  have designed a nline  cab Booking Application Using Using java, SpringBoot, lombok and swagger-UI which has three main roles i.e. Admin and User. Admin is the primary user and can add/remove/update any details related to the system. Admin can manage registered users and drivers. Admin can Add/Remove/Update cab and their details from the system. Admin can also categorize taxis accordingly. Admin will be responsible for keeping a check on all the bookings done by users. Admin can View/Confirm/Cancel bookings done by users. Admin can check and manage the availability of cab and also, keep a track of the status of all the cab that are engaged.

Admin can set/update prices and charges of the taxi rides. Admin can manage the drivers and their details.

On the other hand, users can register. Users can search and view the taxis available. Users can search taxis by entering the location.

Admin can maintain a database of drivers. Drivers have to register on the portal. Drivers will be able to see the booking done by users and details of users like name, source, and destination location.

# Cab Booking Application ER diagram
![cab_booking_3](https://user-images.githubusercontent.com/68966858/185020617-92914a9c-b5e2-4b3b-aa36-dc6a26454cba.jpeg)

# Installation & Run 🌱

Before running the API server, you should update the database config inside the application.properties file.

Update the port number, username and password as per your local database config. server.port=9080

spring.datasource.url=jdbc:mysql://localhost:3306/project spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver spring.datasource.username=mysql username spring.datasource.password=YourPassword spring.jpa.hibernate.ddl-auto=update

API Root Endpoint https://localhost:9080/

-http://localhost:9080/swagger-ui.html#/

### This is a collaborative project, completed by a team of 5 backend developers at Masai School.

## Collaborators

* [Komal Kopnar](https://www.github.com/Komalkopnar622)  (Team Lead)
* [Arup Mahato](https://www.github.com/arupx3492)
* [Koteswararao](https://www.github.com/Koti79k)
* [Devaraj T S](https://www.github.com/devrajts)
* [Deepak Sharma](https://www.github.com/brahmandeepak)

## Modules

*	Login Module - Koti
*	Admin Module - Depak
*	Customer Module - Koti
*	Driver Management Module - Arup
*	Cab Management Module - Komal
*	Booking Management Module - Devaraj

# Features 🌱

* User and Admin authentication & validation with session uuid.

# Admin Features:

* Administrator Role of the entire application
* Only admins can add/update/delete Cab, Driver, Trip from main database
* Admin can access the details of different users and orders.

# Customer Features:

* Can Log in/Log out of the system.
* Can Manage “ profile”.
* Can search for cab.
* Users can Book/Cancel Cabs.
* Can change password.

# Driver we can:
* Add a driver in the system.
* Update driver details.
* Delete a driver from the system.
* Get the list of all drivers.
* Get the list of all best available(rated>=4.5) drivers.




