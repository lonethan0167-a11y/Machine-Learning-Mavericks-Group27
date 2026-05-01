# OOP Mapping File

| OOP Concept      | Where It Appears |
|------------------|------------------|
| Classes & Objects | Person, Passenger, Driver, Vehicle, Combi, Taxi, Routecombi, Routetaxi, Tripcombi, Triptaxi, Bookingcombi, Bookingtaxi |
| Encapsulation     | Private fields in Passenger, Driver, Tripcombi, Triptaxi, Bookingcombi, Bookingtaxi |
| Constructors      | Vehicle, Combi, Taxi, Tripcombi, Triptaxi (validation inside constructors) |
| Constructor Overloading/Chaining | Person (multiple constructors possible) |
| Methods & Modularity | Menu.java handles user actions; describe() methods in Vehicle, Combi, Taxi |
| Composition       | Tripcombi HAS-A Routecombi and Combi; Triptaxi HAS-A Routetaxi and Taxi |
| Inheritance       | Combi and Taxi extend Vehicle; Passenger and Driver extend Person |
| Abstraction       | Automobile interface implemented by Vehicle |
| Polymorphism      | describe() overridden in Combi and Taxi, processed via Vehicle reference |
| Collections       | ArrayList used in Menu.java to store passengers, drivers, trips |
| Packages          | app, menu, model |
| Robustness        | Input validation in constructors; exception handling in Menu |

