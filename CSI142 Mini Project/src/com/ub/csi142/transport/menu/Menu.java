package com.ub.csi142.transport.menu;

import java.util.ArrayList;
import java.util.Scanner;

import com.ub.csi142.transport.model.*;

/**
 * Console menu controllr for the transport system.
 * Expected intputs:
 *  - menu choices (numbers like 1..5, 0)
 *  - pasenger details (id, name, phone)
 *  - seats to book (number)
 *  - trip/booking ids (strings)
 *
 * Expected outputs:
 *  - prints menu, prompts, and results to the console.
 * * Future ideas:
 *  - better validation, and maybe store/load to a file later.
 */
public class Menu {

    private final Scanner in = new Scanner(System.in);

    // in-memory storage(no database)
    private final ArrayList<Passenger> passengers = new ArrayList<>();
    private final ArrayList<Driver> drivers = new ArrayList<>();
private final ArrayList<Combi> combis = new ArrayList<>();
private final ArrayList<Taxi> taxis = new ArrayList<>();
private final ArrayList<Routecombi> routesC = new ArrayList<>();
private final ArrayList<Routetaxi> routesT = new ArrayList<>();
private final ArrayList<Tripcombi> tripsC = new ArrayList<>();
private final ArrayList<Triptaxi> tripsT = new ArrayList<>();
private final ArrayList<Bookingtaxi> bookingsT = new ArrayList<>();
private final ArrayList<Bookingcombi> bookingsC = new ArrayList<>();

/**
     * Runs the interactive menu loop untill exit.
     *
     * Input:
     * - reads from console
     * Output:
     *  - prints stuff to console
     */
    public void run() {
        seedData();

        while (true) {
            printMenu();
            int choice = readInt("Choose option: ");

            switch (choice) {
                case 1 -> listTrips();
                case 2 -> registerPassenger();
                case 3 -> createBooking();
                case 4 -> cancelBooking();
                case 5 -> summaryReport();
                case 0 -> {
                    System.out.println("\nGoodbye!");
                    return;
                }
                default -> System.out.println("Invalid option.  Try again.");
            }
        }
    }

    private void printMenu() {
        System.out.println("\n=== Public Transport Booking System ===");
        System.out.println("1) View trips");
        System.out.println("2) Register passenger");
        System.out.println("3) Book seat(s)");
        System.out.println("4) Cancel booking");
        System.out.println("5) Summary report ");
        System.out.println("0) Exit");
    }

    private void seedData() {
        Driver d1 = new Driver("D001", "Thabo Driver", "71xxxxxx", "LIC-7788");
        drivers.add(d1);

        Driver d2 = new Driver("D002", "Pule Dichaba", "75xxxxxx", "BWP 931");
        drivers.add(d2);

        Combi c1 = new Combi("B123ABC", 15, d1, "Gaborone Rank");
          combis.add(c1);

        Taxi tx1 = new Taxi("T456DEF", 4, d2, "Gaborone Rank");
        taxis.add(tx1);

        Routecombi rc1 = new Routecombi("Gaborone", "Molepolole", 50.0, 1.20, c1);
        routesC.add(rc1);

        Routetaxi rc2 = new Routetaxi("Gaborone rank", "University of Botswana", 4.0, 2.50, tx1);
        routesT.add(rc2);

        Tripcombi tc1 = new Tripcombi("T001", rc1, c1, 15);
        tripsC.add(tc1);

        Triptaxi tt1 = new Triptaxi("T002", rc2, tx1, 4);
        tripsT.add(tt1);
    }

    private void listTrips() {
        System.out.println("\n--- Trips ---");

        if (tripsC.isEmpty() && tripsT.isEmpty()) {
            System.out.println("(none)");
            return;
        }

        for (Tripcombi tc : tripsC) {
            System.out.println(tc);
        }

        for (Triptaxi tt : tripsT) {
            System.out.println(tt);
        }
    }

    private void registerPassenger() {
        System.out.println("\n--- Register Passenger ---");
        String id = readLine("Passenger ID: ");
        String name = readLine("Full name: ");
        String phone = readLine("Phone: ");
        boolean student = readYesNo("Student? (y/n): ");

        Passenger p = new Passenger(id, name, phone, student);
        passengers.add(p);

        System.out.println("Registered: " + p);
    }

    private void createBooking() {
        System.out.println("\n--- Create Booking ---");

     if (passengers.isEmpty()) {
            System.out.println("No passengers yet. Register a passenger first.");
            return;
        }
          if (tripsC.isEmpty() || tripsT.isEmpty()) {
            System.out.println("No trips yet.");
            return;
        }

        String pid = readLine("Passenger ID: ");
        Passenger p = findPassenger(pid);
        if (p == null) {
            System.out.println("Passenger not found.");
            return;
        }
            String tid = readLine("Trip ID: ");

            Tripcombi t = findTripcombi(tid);
            Triptaxi c = findTriptaxi(tid);
            if (t == null && c == null) {
                System.out.println("Trip not found.");
                return;
            }


        int seats = readInt("Seat(s) to book: ");
        if (seats <= 0) {
            System.out.println("Seats must be > 0.");
            return;
        }
                if (t.bookSeats(seats)) {
            System.out.println("Not enough seats available.");
            return;
        }

        Bookingcombi b = new Bookingcombi(p, t, seats);
        bookingsC.add(b);

        System.out.println("Booking created: " + b);

        Bookingtaxi bt = new Bookingtaxi(p, c, seats);
        bookingsT.add(bt);
    }

    private void cancelBooking() {        System.out.println("\n--- Cancel Booking ---");
        String bid = readLine("Booking ID: ");

        Bookingcombi b = findBookingcombi(bid);
        if (b == null) {
            System.out.println("Booking not found.");
            return;
            }
// (we remove booking here)
        bookingsC.remove(b);
        System.out.println("Booking cancelled.");

        Bookingtaxi bt = findBookingtaxi(bid);
        if(bt == null) {
            System.out.println("Booking not found.");
            return;
        }
             bookingsT.remove(bt);
            System.out.println("Booking cancelled.");
    }

    private void summaryReport() {
        System.out.println("\n--- Summary Report ---");
        System.out.println("Passengers: " + passengers.size());
        System.out.println("Trips: " + (tripsC.size() + tripsT.size()));
        System.out.println("Bookings: " + bookingsC.size() + bookingsT.size());

        int totalSeatsBooked = bookingsC.size() + bookingsT.size();   // quick calc
        System.out.println("Total seats booked: " + totalSeatsBooked);
    }

    // helpers

    private Passenger findPassenger(String id) {
        for (Passenger p : passengers) {
            if (p.getId().equalsIgnoreCase(id)) return p;
        }
        return null;
    }

private Tripcombi findTripcombi(String id) {
        for (Tripcombi t : tripsC) {
            if (t.getTripId().equalsIgnoreCase(id)) return t;
        }
        return null;
    }

    private Triptaxi findTriptaxi(String id) {
        for (Triptaxi t : tripsT) {
            if (t.getTripId().equalsIgnoreCase(id)) return t;
        }
        return null;
    }

    private Bookingcombi findBookingcombi(String id) {
        for (Bookingcombi b : bookingsC) {
            if (b.getBookingId().equalsIgnoreCase(id)) return b;
        }
        return null;
    }

    private Bookingtaxi findBookingtaxi(String id) {
        for (Bookingtaxi b : bookingsT) {
            if (b.getBookingId().equalsIgnoreCase(id)) return b;
        }
        return null;
    }


    private int readInt(String prompt) {
        while (true) {
            String s = readLine(prompt);
        try {
                return Integer.parseInt(s);
            } catch (NumberFormatException ex) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private boolean readYesNo(String prompt) {
        while (true) {
            String s = readLine(prompt).trim().toLowerCase();
      if (s.equals("y") || s.equals("yes")) return true;
            if (s.equals("n") || s.equals("no")) return false;

            System.out.println("Please answer y/n.");
        }
    }

    private String readLine(String prompt) {
        System.out.print(prompt);
        return in.nextLine();
    }
}
