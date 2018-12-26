/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package industrialespionage;

import buildData.Build;
import employeedata.Employee;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Pat Wolohan & Eanna Ryan
 */
public class Main {

    /**
     *
     * @param args
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Build b = new Build();
        ArrayList<Employee> staff = b.buildEmployeeFile();
        b.buildFib();
        b.buildSpyList();
        //b.printListOfSpies();
        Menu menu = new Menu();
        menu.runMenu(b, b.getSpyDataStBuild());

        // b.buildJobList();
        //b.printSpyFibIndex();
    }

}
