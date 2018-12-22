/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeedata;

/**
 *
 * @author pwolo
 */
public class SpySuspect extends EmployeeExpanded {
    
    private boolean isSpySuspect = false;
    
    

    public SpySuspect() {
        super();
    }
    
    public SpySuspect(Employee employee) {
        this.setEmployee(employee);
    }

    public boolean isIsSpySuspect() {
        return isSpySuspect;
    }

    public void setIsSpySuspect(boolean isSpySuspect) {
        this.isSpySuspect = isSpySuspect;
    }

    

    

    
    
    
    
}

