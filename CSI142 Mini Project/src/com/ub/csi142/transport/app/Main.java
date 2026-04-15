package com.ub.csi142.transport.app;

import com.ub.csi142.transport.menu.Menu;

/**
 * Entry point for the console app.
 *
 * Inputs:
 *   - none directly (menu handles user input)
   *
  * Ouput:
 *   - starts menu + prints to console
 * Later, If necessary, we can pass config / services into Menu instead of newing it here.
 */
public class Main {

    public static void main(String[] args) {

      // Start the menu loop
 new Menu().run();

    }
}