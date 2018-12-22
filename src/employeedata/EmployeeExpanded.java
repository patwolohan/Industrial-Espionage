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
public class EmployeeExpanded {
	
    private Employee employee;  
    private int fibIndex = 0;
    private int phoneMatchNum = 0;
    private int clubMatchNum = 0;
    private int societyMatchNum = 0;
    private int jobMatchNum = 0;
    private int addressMatchNum = 0;
    private boolean isPhoneMatch = false;
    private boolean isClubMatch = false;
    private boolean isJobMatch = false;

    public EmployeeExpanded() {
        super();
    }
    
  
    

   

   public void getPhoneList(){
       
   }
   public void getClubList(){
       
   }
   public void getJobList(){
       
   }
           
    public int getFibIndex() {
        return fibIndex;
    }

    public void setFibIndex(int fibIndex) {
        this.fibIndex = fibIndex;
    }

    

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;                
	}

    public int getPhoneMatchNum() {
        return phoneMatchNum;
    }

    public void setPhoneMatchNum(int phoneMatchNum) {
        this.phoneMatchNum = phoneMatchNum;
    }

    public int getClubMatchNum() {
        return clubMatchNum;
    }

    public void setClubMatchNum(int clubMatchNum) {
        this.clubMatchNum = clubMatchNum;
    }

    public int getJobMatchNum() {
        return jobMatchNum;
    }

    public void setJobMatchNum(int jobMatchNum) {
        this.jobMatchNum = jobMatchNum;
    }

   

    public boolean isIsPhoneMatch() {
        return isPhoneMatch;
    }

    public void setIsPhoneMatch(boolean isPhoneMatch) {
        this.isPhoneMatch = isPhoneMatch;
    }

    public boolean isIsClubMatch() {
        return isClubMatch;
    }

    public void setIsClubMatch(boolean isClubMatch) {
        this.isClubMatch = isClubMatch;
    }

    public boolean isIsJobMatch() {
        return isJobMatch;
    }

    public void setIsJobMatch(boolean isJobMatch) {
        this.isJobMatch = isJobMatch;
    }

    @Override
    public String toString() {
        return "EmployeeExpanded{" + "employee=" + employee + ", fibIndex=" + fibIndex + ", phoneMatchNum=" + phoneMatchNum + ", clubMatchNum=" + clubMatchNum + ", jobMatchNum=" + jobMatchNum + ", addressMatchNum=" + addressMatchNum + ", isPhoneMatch=" + isPhoneMatch + ", isClubMatch=" + isClubMatch + ", isJobMatch=" + isJobMatch + '}';
    }

   

    public int getAddressMatchNum() {
        return addressMatchNum;
    }

    public void setAddressMatchNum(int addressMatchNum) {
        this.addressMatchNum = addressMatchNum;
    }

    public int getSocietyMatchNum() {
        return societyMatchNum;
    }

    public void setSocietyMatchNum(int societyMatchNum) {
        this.societyMatchNum = societyMatchNum;
    }
    
    
        
}
