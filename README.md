#  Transport and Mobility System  
*Taxi and Combi Transport Management System*  
CSI142 Group Mini-Project – Machine-Learning-Mavericks-Group27  

##  Assignment Context
Developed for CSI142 Object-Oriented Programming.  
The goal is to demonstrate OOP principles in a small, realistic Java console application connected to Botswana’s everyday life.  

##  Overview
This project simulates everyday commuting using taxis and combis in Botswana. Passengers arrive at a taxi rank, join a queue, and are assigned to vehicles heading to destinations such as school, work, or town.  

The system demonstrates how **object-oriented programming (OOP) concepts from CSI142** come together in one coherent project. It manages passenger queues, assigns passengers to taxis/combis based on availability and route, and displays transport summaries.  

##  Domain Context
Transport and mobility is a vital part of everyday life in Botswana. Shared taxis and combis are widely used for commuting. This project reflects that real-world experience by simulating:  
- Passenger queues at taxi ranks  
- Vehicle assignment based on destination and availability  
- Summaries of trips and bookings  

##  Features
- Add passengers and drivers  
- Assign passengers to taxis/combis based on routes  
- View passenger queues and vehicle occupancy  
- Generate trip summaries and reports  
- Handle invalid input gracefully (e.g., wrong menu choice, invalid data)  
- Seed demo data for quick testing  

##  Project Structure
CSI142 Mini Project/
│── src/
│   └── com/ub/csi142/transport/
│       ├── app/
│       │   └── Main.java              # Application entry point
│       ├── menu/
│       │   └── Menu.java              # Console menu system
│       └── model/
│           ├── Person.java            # Base class for individuals
│           ├── Passenger.java         # Passenger entity
│           ├── Driver.java            # Driver entity
│           ├── Automobile.java        # Interface for vehicles
│           ├── Vehicle.java           # General transport unit
│           ├── Combi.java             # Shared transport vehicle
│           ├── Taxi.java              # Taxi transport vehicle
│           ├── Routecombi.java        # Defines combi travel paths
│           ├── Routetaxi.java         # Defines taxi travel paths
│           ├── Tripcombi.java         # Represents a combi journey
│           ├── Triptaxi.java          # Represents a taxi journey
│           ├── Bookingcombi.java      # Links passengers to combi trips
│           └── Bookingtaxi.java       # Links passengers to taxi trips
│── out/                               # Compiled .class files
│── README.md                          # Project documentation
│── .gitignore                         # Excludes .class files and output folders


## Code Snippets
All main classes are implemented as follows:

- **Main.java** – Application entry point  
- **Menu.java** – Interactive console menu  
- **Automobile.java** – Interface for vehicles  
- **Vehicle.java** – Base class implementing `Automobile`  
- **Combi.java** – Combi vehicle with driver and rank  
- **Taxi.java** – Taxi vehicle with driver and rank  
- **Driver.java** – Driver entity extending `Person`  
- **Passenger.java** – Passenger entity extending `Person`  
- **Routecombi.java** – Combi route with fare calculation  
- **Routetaxi.java** – Taxi route with fare  
- **Tripcombi.java** – Combi trip with seat management  
- **Triptaxi.java** – Taxi trip with seat management  
- **Bookingcombi.java** – Booking for combi trips  
- **Bookingtaxi.java** – Booking for taxi trips  

*(Full source code is included in the repository under `src/com/ub/csi142/transport/`.)*

##  OOP Elements Demonstrated
- **Classes & Objects**: At least 6 meaningful domain classes  
- **Encapsulation**: Private fields with controlled access  
- **Constructors**: Validations and initialization logic  
- **Composition**: Vehicles contain drivers; trips contain routes and vehicles  
- **Inheritance**: `Combi` and `Taxi` extend `Vehicle`; `Passenger` and `Driver` extend `Person` 
- **Abstraction**: `Automobile` interface 
- **Polymorphism**: `describe()` overridden in `Combi` and `Taxi`  
- **Collections**: `ArrayList` used in `Menu` for managing entities 
- **Packages**: `app`, `menu`, `model`  
- **Robustness**: Input validation and exception handling  

## How to Compile and Run
From the project root (`CSI142 Mini Project`):

```bash
# Compile all source files
javac -d out src/com/ub/csi142/transport/app/*.java \
           src/com/ub/csi142/transport/menu/*.java \
           src/com/ub/csi142/transport/model/*.java

# Run the application
java -cp out com.ub.csi142.transport.app.Main

```

## Contributors & Roles
This project was developed collaboratively by Machine-Learning-Mavericks-Group27.  
Each member contributed to different parts of the system as outlined below:

- Dylan Tsaone Monkgela – Transport Models  
  - File ownership: Vehicle.java, Combi.java, Route.java  
  - Actions: ensured inheritance and composition are clean, added validations  

- Tshiamiso Gabriel Leswena – Trip & Booking  
  - File ownership: Trip.java, Booking.java  
  - Actions: seat logic, booking ID generation, cancel seat restore  

- Wapapha Muzila – Menu & Integration  
  - File ownership: Menu.java, Main.java  
  - Actions: kept main runnable, consolidated merges, improved prompts  

- Rachel Ragele Molapo – People Models & Documentation  
  - File ownership: Person.java, Passenger.java, Driver.java, README.md  
  - Actions: inheritance, student discounts field, documentation polish  

