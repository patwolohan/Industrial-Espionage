/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeedata;

/**
 *
 * @author Pat Wolohan & Eanna Ryan
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

    

    @Override
    public String toString() {
        return "SpySuspect : \n" + " Name : " + super.getEmployee().getName()
                + "\n Address : " + super.getEmployee().getAddress() + "\n Phone : " + super.getEmployee().getPhone()
                + "\n job : " + super.getEmployee().getJobTitle() + "\n id : " + super.getEmployee().getId()
                + "\n Member of : " + super.getEmployee().getMemberOf() + " "
                +"\n Fibonacci Index : " + super.getFibIndex() + " "
                +" Job Match Number : " + super.getJobMatchNum() + " "
                +" Phone Match Number : " + super.getPhoneMatchNum() + " "
                +" Club Match Number : " + super.getClubMatchNum() + " "
                +" Society Match Number : " + super.getSocietyMatchNum() + " "
                +" Address Match Number : " + super.getAddressMatchNum() + " "
                +"\n isSpySuspect : " + isSpySuspect + " "
                +" isJobMatch : " + super.isIsJobMatch() + " "
                +" isPhoneMatch : " + super.isIsPhoneMatch() + " "
                +" isClubMatch : " + super.isIsClubMatch() + " "
                +" isSocietyMatch : " + super.isIsSocietyMatch() + "\n";
                
    }

    
    
    
    
}

