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
public class EmployeeExpanded {

    //Employee object instantiated to access Employee Fields and methods
    private Employee employee;
    private int fibIndex = 0;
    private int phoneMatchNum = 0;
    private int clubMatchNum = 0;
    private int societyMatchNum = 0;
    private int jobMatchNum = 0;
    private int addressMatchNum = 0;
    private boolean isPhoneMatch = false;
    private boolean isClubMatch = false;
    private boolean isSocietyMatch = false;
    private boolean isJobMatch = false;

    /**
     * default Constructor
     */
    public EmployeeExpanded() {
        super();
    }

    /**
     *
     * @return int fibIndex
     */
    public int getFibIndex() {
        return fibIndex;
    }

    /**
     *
     * @param fibIndex
     */
    public void setFibIndex(int fibIndex) {
        this.fibIndex = fibIndex;
    }

    /**
     *
     * @return String employee
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     *
     * @param employee
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     *
     * @return int phoneMatchNum
     */
    public int getPhoneMatchNum() {
        return phoneMatchNum;
    }

    /**
     *
     * @param phoneMatchNum
     */
    public void setPhoneMatchNum(int phoneMatchNum) {
        this.phoneMatchNum = phoneMatchNum;
    }

    /**
     *
     * @return int clubMatchNum
     */
    public int getClubMatchNum() {
        return clubMatchNum;
    }

    /**
     *
     * @param clubMatchNum
     */
    public void setClubMatchNum(int clubMatchNum) {
        this.clubMatchNum = clubMatchNum;
    }

    /**
     *
     * @return int jobmatchNum
     */
    public int getJobMatchNum() {
        return jobMatchNum;
    }

    /**
     *
     * @param jobMatchNum
     */
    public void setJobMatchNum(int jobMatchNum) {
        this.jobMatchNum = jobMatchNum;
    }

    /**
     *
     * @return boolean isPhoneMatch
     */
    public boolean isIsPhoneMatch() {
        return isPhoneMatch;
    }

    /**
     *
     * @param isPhoneMatch
     */
    public void setIsPhoneMatch(boolean isPhoneMatch) {
        this.isPhoneMatch = isPhoneMatch;
    }

    /**
     *
     * @return boolean isClubMatch
     */
    public boolean isIsClubMatch() {
        return isClubMatch;
    }

    /**
     *
     * @param isClubMatch
     */
    public void setIsClubMatch(boolean isClubMatch) {
        this.isClubMatch = isClubMatch;
    }

    /**
     *
     * @return boolean isJobMatch
     */
    public boolean isIsJobMatch() {
        return isJobMatch;
    }

    /**
     *
     * @param isJobMatch
     */
    public void setIsJobMatch(boolean isJobMatch) {
        this.isJobMatch = isJobMatch;
    }

    /**
     *
     * @return int addressMatchNum
     */
    public int getAddressMatchNum() {
        return addressMatchNum;
    }

    /**
     *
     * @param addressMatchNum
     */
    public void setAddressMatchNum(int addressMatchNum) {
        this.addressMatchNum = addressMatchNum;
    }

    /**
     *
     * @return int societyMatchNum
     */
    public int getSocietyMatchNum() {
        return societyMatchNum;
    }

    /**
     *
     * @param societyMatchNum
     */
    public void setSocietyMatchNum(int societyMatchNum) {
        this.societyMatchNum = societyMatchNum;
    }
/**
     *
     * @return isSocietyMatch
     */
    public boolean isIsSocietyMatch() {
        return isSocietyMatch;
    }
/**
     *
     * @param isSocietyMatch
     */
    public void setIsSocietyMatch(boolean isSocietyMatch) {
        this.isSocietyMatch = isSocietyMatch;
    }


    @Override
    public String toString() {
        return "EmployeeExpanded : \n" + " Name : " + employee.getName()
                + "\n Address : " + employee.getAddress() + "\n Phone : " + employee.getPhone()
                + "\n job : " + employee.getJobTitle() + "\n id : " + employee.getId()
                + "\n Member of : " + employee.getMemberOf() + " "
                + "\n Fibonacci Index : " + fibIndex + " "
                + " Job Match Number : " + jobMatchNum + " "
                + " Phone Match Number : " + phoneMatchNum + " "
                + " Club Match Number : " + clubMatchNum + " "
                + " Society Match Number : " + societyMatchNum + " "
                + " Address Match Number : " + addressMatchNum + " "
                + "\n isJobMatch : " + isJobMatch + " "
                + " isPhoneMatch : " + isPhoneMatch + " "
                + " isClubMatch : " + isClubMatch + " "
                + " isSocietyMatch : " + isSocietyMatch + "\n";

    }

}
