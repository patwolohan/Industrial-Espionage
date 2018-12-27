/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeedata;

import java.util.HashMap;
import java.util.LinkedHashMap;

/** This class is creating a data structure to store the list of known spies
 *
 * @author pwolo
 */
public class Spy extends EmployeeExpanded{
    
    private boolean isSpy = false;
    
    /**
     *
     */
    public Spy() {
       super(); 
    }
    
    /**
     *
     * @param employee
     */
    public Spy(Employee employee) {
        this.setEmployee(employee);
    }
    
    /**
     *
     * @return
     */
    public boolean isIsSpy() {
        return isSpy;
    }

    /**
     *
     * @param isSpy
     */
    public void setIsSpy(boolean isSpy) {
        this.isSpy = isSpy;
    }

//    @Override
//    public String toString() {
//        return "Spy{" + "isSpy=" + isSpy + '}';
//    }
    
    
    
    
    
}
