/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package industrialespionage;

/**
 *
 * @author Pat Wolohan & Eanna Ryan
 */
import buildData.Build;
import buildData.SpyDataStore;
import java.util.Scanner;
import search.Search;

/**
 *
 * @author Pat
 */
public class Menu { 

    private String[] menuChoices;
    Search search = new Search();
    
    /**
     *constructor Initialising menuChoices String Array
     */
    public Menu() {
        this.menuChoices = new String[]{" List of Known Spies ", " Spy Fibonacci Sequence ", " Data Structure of Suspects ", " All Info for Employees "};
    }

    /**
     *
     * @param b Build object
     * @param s SpyDataStore object
     */
    public void runMenu(Build b, SpyDataStore s) {
        Scanner in = new Scanner(System.in);
        System.out.println("  **** Industrial Espionage Search Utility **** \n");
        // print menu
        for (int i = 1; i <= 4; i++) {
            System.out.println(i + menuChoices[i - 1] + "\n" );
        }
        System.out.println("  Press 0 to Quit Utility \n ");
        // user commands
        boolean quit = false;
        int menuItem;
        do {
            System.out.print(" \n Choose Industrial Espionage Search Menu Item: ");
            menuItem = in.nextInt();
            switch (menuItem) {
                case 1:                    
                    b.printListOfSpies();
                    runMenu(b,s);
                    break;
                case 2:                                      
                    b.printSpyFibIndex();
                    runMenu(b,s);
                    break;
                case 3:
                    search.spySearchMatch(b, s);
                    search.spySuspectMatch(b, s);
                    runMenu(b,s);
                    break;
                case 4:
                    search.listOfEmployees(s);
                    break;                
                case 0:
                    quit = true;
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Menu Selection: ");
            }
        } while (!quit);
        System.out.println("You have ended the Industrial Espionage Search Utility ");
    }

    public String[] getMenuChoices() {
        return menuChoices;
    }

    public void setMenuChoices(String[] menuChoices) {
        this.menuChoices = menuChoices;
    }
}
