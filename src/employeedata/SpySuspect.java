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
    
    /**
     *
     */
    public SpySuspect() {
        super();
    }
    
    /**
     *
     * @param employee
     */
    public SpySuspect(Employee employee) {
        this.setEmployee(employee);
    }

    /**
     *
     * @return
     */
    public boolean isIsSpySuspect() {
        return isSpySuspect;
    }

    /**
     *
     * @param isSpySuspect
     */
    public void setIsSpySuspect(boolean isSpySuspect) {
        this.isSpySuspect = isSpySuspect;
    }

    

    

    
    
    
    
}

