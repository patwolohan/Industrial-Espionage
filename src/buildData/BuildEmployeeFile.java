/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buildData;

import employeedata.Employee;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author PatWolohan <patwolohan.org>
 */
public interface BuildEmployeeFile {

    /**
     * Build Employee ArrayList data 
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public ArrayList<Employee> buildEmployeeFile() throws IOException, ClassNotFoundException;
    
}
