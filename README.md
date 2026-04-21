CSI142 Group Mini-Project Assignment– Machine-Learning-Mavericks-Group27 
# Transport and Mobility System(Taxi and combi transport management system) 

#Assignment Context
This project was developed as part of the CSI142 Object-Oriented Programming course.  
The goal is to demonstrate OOP principles in a small, realistic Java console application connected to Botswana’s everyday life.  

#Overview
This project simulates everyday commuting using taxis and combis in Botswana. Passengers arrive at a taxi rank, join a queue, and are assigned to vehicles heading to destinations such as school, work, or town.  

The system demonstrates how **object-oriented programming (OOP) concepts from CSI142** come together in one coherent project. It manages passenger queues, assigns passengers to taxis/combis based on availability and route, and displays transport summaries.  

# Domain Context
Transport and mobility is a vital part of everyday life in Botswana. Shared taxis and combis are widely used for commuting. This project reflects that real-world experience by simulating:  
- Passenger queues at taxi ranks  
- Vehicle assignment based on destination and availability  
- Summaries of trips and bookings  

# Features
- Add passengers and drivers  
- Assign passengers to taxis/combis based on routes  
- View passenger queues and vehicle occupancy  
- Generate trip summaries and reports  
- Handle invalid input gracefully (e.g., wrong menu choice, invalid data)  
- Seed demo data for quick testing  

# Project Structure





#Domain Model (Classes)
- **Person** – Base entity for individuals  
- **Passenger** – Represents commuters using the system  
- **Driver** – Manages vehicles and trips  
- **Vehicle** – General transport unit  
- **Combi** – Shared transport vehicle type  
- **Route** – Defines travel paths and destinations  
- **Trip** – Represents a journey with passengers and driver  
- **Booking** – Links passengers to trips  

# OOP Elements Demonstrated
- **Classes & Objects**: At least 6 meaningful domain classes  
- **Encapsulation**: Private fields with controlled access  
- **Constructors**: Overloaded and chained constructors  
- **Composition**: Vehicles contain passengers and drivers  
- **Inheritance**: `Combi` extends `Vehicle`  
- **Abstraction**: Interfaces/abstract classes for transport contracts  
- **Polymorphism**: Processing vehicles through superclass references  
- **Collections**: `ArrayList` used for managing entities  
- **Packages**: `app`, `menu`, `model`  
- **Robustness**: Input validation and exception handling  

# How to Compile and Run
From the project root (`CSI142 Mini Project`):

```bash
# Compile all source files
javac -d out src/com/ub/csi142/transport/app/*.java \
           src/com/ub/csi142/transport/menu/*.java \
           src/com/ub/csi142/transport/model/*.java

# Run the application
java -cp out com.ub.csi142.transport.app.Main

