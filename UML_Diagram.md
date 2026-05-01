# UML Class Diagram 

Person
-------------------------
- id : String
- name : String
- phone : String
-------------------------
+ getId() : String
+ getName() : String
+ getPhone() : String

Passenger (extends Person)
-------------------------
- isStudent : boolean
-------------------------
+ getIsStudent() : boolean

Driver (extends Person)
-------------------------
- license : String
-------------------------
+ getLicense() : String

Automobile (interface)
-------------------------
+ describe() : String

Vehicle (implements Automobile)
-------------------------
- id : String
- driver : Driver
-------------------------
+ describe() : String

Combi (extends Vehicle)
-------------------------
- seats : int
-------------------------
+ describe() : String

Taxi (extends Vehicle)
-------------------------
- seats : int
-------------------------
+ describe() : String

Routecombi
-------------------------
- start : String
- destination : String
- distance : double

Tripcombi
-------------------------
- tripId : String
- route : Routecombi
- vehicle : Combi
- fare : double
- seatsAvailable : int
-------------------------
+ bookSeats(n : int) : void
+ toString() : String

Bookingcombi
-------------------------
- bookingId : String
- passenger : Passenger
- trip : Tripcombi
-------------------------
+ cancelBooking() : void

Routetaxi
-------------------------
- start : String
- destination : String
- distance : double

Triptaxi
-------------------------
- tripId : String
- route : Routetaxi
- vehicle : Taxi
- fare : double
- seatsAvailable : int
-------------------------
+ bookSeats(n : int) : void
+ toString() : String

Bookingtaxi
-------------------------
- bookingId : String
- passenger : Passenger
- trip : Triptaxi
-------------------------
+ cancelBooking() : void

