/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeedata;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 *
 * @author pwolo
 */
public class Spy extends EmployeeExpanded{
    
    private boolean isSpy = false;
    
    
    public Spy() {
       super(); 
    }
    
    public Spy(Employee employee) {
        this.setEmployee(employee);
    }
    
    
    



    public boolean isIsSpy() {
        return isSpy;
    }

    public void setIsSpy(boolean isSpy) {
        this.isSpy = isSpy;
    }

//    @Override
//    public String toString() {
//        return "Spy{" + "isSpy=" + isSpy + '}';
//    }
    
    
    
    
    
}
