# Machine-Learning-Mavericks-Group27
CSI142 Group Mini-Project 

## Domain
Combi/Taxi Booking System (Botswana public transport inspired)

## Milestone 2 (Model + Menu Checkpoint)
- Package structure: app, menu, model
- Class list (domain model): Person, Passenger, Driver, Vehicle, Combi, Route, Trip, Booking
- Working console menu loop with seed demo data

## How to compile and run (from project root)
Open terminal in: `CSI142 Mini Project`

```bash
javac -d out src/com/ub/csi142/transport/app/*.java src/com/ub/csi142/transport/menu/*.java src/com/ub/csi142/transport/model/*.java
java -cp out com.ub.csi142.transport.app.Main