package com.ub.csi142.transport.menu;

import java.util.Scanner;
public class Menu {
    public void displayMenu(){
        Scanner in = new Scanner(System.in);

        int choice = 0;
         System.out.println("Welcome to the Transportation System!\n");
        do{
            System.out.println("1) Add new Vehicle");
            System.out.println("2) Add new driver");
            System.out.println("3) Add new route");
            System.out.println("4) Exit");
            System.out.print("Enter your choice: ");

            if (!in.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.\n");
                in.nextline();
                continue;
            }
            choice = in.nextInt();

            switch (choice) { //Switch statements are simple and easy but we could later add options which have methods
                case 1:
                    System.out.println("You have chosen to add a new vehicle.\n");
                    break;
                case 2:
                    System.out.println("You have chosen to add a new driver.\n");
                    break;
                case 3:
                    System.out.println("You have chosen to add a new route.\n");
                    break;
                case 4:
                    System.out.println("Exiting. Good day!");
                    break;
                default:
                    System.out.println("Invalid choice, Please try again.\n");
        
                }
            }while (choice != 4);
            
        in.close();
        }

    }
