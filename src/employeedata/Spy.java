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
public class Spy extends EmployeeExpanded{
    
    private boolean isSpy = false;
    
    //call to super methods
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

@Override
    public String toString() {
        return "Spy : \n" + " Name : " + super.getEmployee().getName()
                + "\n Address : " + super.getEmployee().getAddress() + "\n Phone : " + super.getEmployee().getPhone()
                + "\n job : " + super.getEmployee().getJobTitle() + "\n id : " + super.getEmployee().getId()
                + "\n Member of : " + super.getEmployee().getMemberOf() + " "
                +"\n Fibonacci Index : " + super.getFibIndex() + " "
                +" Job Match Number : " + super.getJobMatchNum() + " "
                +" Phone Match Number : " + super.getPhoneMatchNum() + " "
                +" Club Match Number : " + super.getClubMatchNum() + " "
                +" Society Match Number : " + super.getSocietyMatchNum() + " "
                +" Address Match Number : " + super.getAddressMatchNum() + " "
                +"\n isSpy : " + isSpy + " "
                +" isJobMatch : " + super.isIsJobMatch() + " "
                +" isPhoneMatch : " + super.isIsPhoneMatch() + " "
                +" isClubMatch : " + super.isIsClubMatch() + " "
                +" isSocietyMatch : " + super.isIsSocietyMatch() + "\n";
                
    }
    
    
    
    
    
}
