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
private final ArrayList<Route> routes = new ArrayList<>();
private final ArrayList<Trip> trips = new ArrayList<>();
private final ArrayList<Booking> bookings = new ArrayList<>();

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
        System.out.println("\n=== Combi Booking System ===");
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

        Combi c1 = new Combi("B123ABC", 15, d1, "Gaborone Rank");
          combis.add(c1);

        Route r1 = new Route("Gaborone", "Molepolole", 50.0, 1.20, c1);
        routes.add(r1);

        Trip t1 = new Trip("T001", r1, c1, 15);
        trips.add(t1);
    }

    private void listTrips() {
        System.out.println("\n--- Trips ---");

        if (trips.isEmpty()) {
            System.out.println("(none)");
            return;
        }

        for (Trip t : trips) {
            System.out.println(t);
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
          if (trips.isEmpty()) {
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
        Trip t = findTrip(tid);
        if (t == null) {
            System.out.println("Trip not found.");
            return;
        }

        int seats = readInt("Seats to book: ");
        if (seats <= 0) {
            System.out.println("Seats must be > 0.");
            return;
        }
                if (!t.bookSeats(seats)) {
            System.out.println("Not enough seats available.");
            return;
        }

        Booking b = new Booking(p, t, seats);
        bookings.add(b);

        System.out.println("Booking created: " + b);
    }

    private void cancelBooking() {        System.out.println("\n--- Cancel Booking ---");
        String bid = readLine("Booking ID: ");

        Booking b = findBooking(bid);
        if (b == null) {
            System.out.println("Booking not found.");
            return;
            }
// (we remove booking here)
        bookings.remove(b);
        System.out.println("Booking cancelled.");
    }

    private void summaryReport() {
        System.out.println("\n--- Summary Report ---");
        System.out.println("Passengers: " + passengers.size());
        System.out.println("Trips: " + trips.size());
        System.out.println("Bookings: " + bookings.size());

        int totalSeatsBooked = bookings.size();   // quick calc
        System.out.println("Total seats booked: " + totalSeatsBooked);
    }

    // helpers

    private Passenger findPassenger(String id) {
        for (Passenger p : passengers) {
            if (p.getId().equalsIgnoreCase(id)) return p;
        }
        return null;
    }

private Trip findTrip(String id) {
        for (Trip t : trips) {
            if (t.getTripId().equalsIgnoreCase(id)) return t;
        }
        return null;
    }

    private Booking findBooking(String id) {
        for (Booking b : bookings) {
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
