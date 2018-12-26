/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buildData;

import data.Data;
import employeedata.Employee;
import employeedata.EmployeeExpanded;
import employeedata.Spy;
import employeedata.SpySuspect;
import fibonacci.Fibonacci;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Pat Wolohan & Eanna Ryan
 */
public class Build implements BuildSpyList {
    //Local Storage Data Structures
    private ArrayList<Employee> staff = new ArrayList<>();
    private Integer[] fibArray = new Integer[Data.getFibSize()];
    private List<Integer> fibArrayList = new ArrayList<>();
    private List<String> empSocietyListBuild = new ArrayList<>();
    private List<String> empClubListBuild = new ArrayList<>();
    private List<String> empPhoneListBuild = new ArrayList<>();
    private List<String> empJobListBuild = new ArrayList<>();
    private List<String> empAddressListBuild = new ArrayList<>();
    private HashMap<String, String> empClubMapBuild = new LinkedHashMap<>();
    private HashMap<String, String> empPhoneMapBuild = new LinkedHashMap<>();
    private HashMap<String, String> empJobMapBuild = new LinkedHashMap<>();
    private HashMap<String, String> spyClubMapBuild = new LinkedHashMap<>();
    private HashMap<String, String> spyPhoneMapBuild = new LinkedHashMap<>();
    private HashMap<String, String> empAddressMapBuild = new LinkedHashMap<>();
    private HashMap<String, String> spyJobMapBuild = new LinkedHashMap<>();
    private HashMap<String, SpySuspect> spySuspectMapBuild = new LinkedHashMap<>();
    private List<Spy> spyListBuild = new ArrayList<>();
    private List<SpySuspect> spySuspectListBuild = new ArrayList<>();
    private List<Integer> spyIndex = new ArrayList<>();
    // instantiate a SpyDataStore object
    private SpyDataStore spyDataStBuild = new SpyDataStore();

    /**
     *
     */
    public Build() {

    }

    /**
     *
     */
    public void buildFib() {
        //instantiate Data class
        Data d = new Data();
        Fibonacci fb = new Fibonacci();
        for (int i = 0; i < Data.getFibSize(); i++) {
            d.setFibArray(i, fb.fibGenerate(i));

        }

        this.fibArray = d.getFibArray();
        fibArrayList = Arrays.asList(fibArray);

    }

    /**
     *
     * @return
     */
    public ArrayList<Employee> getStaff() {
        return staff;
    }

    /**
     *
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public ArrayList<Employee> buildEmployeeFile() throws IOException, ClassNotFoundException {

        staff = deserializeFromDisk(staff);
        return staff;
    }

    /**
     *
     */
    public void buildAll() {

    }
   
    /**
     *
     */
    public void buildSpyList() {

        //int count = 0;
        int countIndex = 0;
        String spyEdited;
        for (Employee emp : staff) {
            //Employee Fields to LinkedHashMap Build Data Storage
            empClubMapBuild.put(emp.getId(), emp.getMemberOf());
            empJobMapBuild.put(emp.getId(), emp.getJobTitle());
            empPhoneMapBuild.put(emp.getId(), emp.getPhone());
            empAddressMapBuild.put(emp.getId(), emp.getAddress());
            //Employee Fileds to List Build Data Storage
            empJobListBuild.add(emp.getJobTitle());
            empAddressListBuild.add(emp.getAddress());
            empPhoneListBuild.add(emp.getPhone());
            //Split Employee MemberOf String data to Club & Society
            String[] empMemberSplit = emp.getMemberOf().split(",");
            empSocietyListBuild.add(empMemberSplit[0]);
            empClubListBuild.add(empMemberSplit[1]);         
            
            //remove starting letter from staff Arraylist id and store in empId
            String empId = emp.getId().substring(1);
            //If Employee Object has an Id that ends with fibonacci set as spy object
            if (empId.endsWith("fibonacci")) {

                //create a Spy object with employee object data
                Spy spy = new Spy(emp);
                spy.setEmployee(emp);
                spy.setIsSpy(true);
                //add Spy object to spyList
                spyListBuild.add(spy);
                //add Spy object to spyHashMap with Id as Key and Spy object as value
                spyDataStBuild.putSpyHashMap(spy, empId);               
                
                //remove starting letter and assign to spyId                
                String spyId = emp.getId().substring(1);
                //remove "fibonacci" from String and assign to String spyEdited
                spyEdited = spyId.replaceFirst("fibonacci", "");
                //parse String spyEdited to Integer spyIdInt
                int spyIdInt = Integer.parseInt(spyEdited);
                //System.out.println("spyIdInt " + spyIdInt);
                
                //if fibArraylist contains (spy id numerals) int spyIdInt 
                //pick out index of fibonacci number found
                //add to spyFibIndex LinkedHashmap 
                if (fibArrayList.contains(spyIdInt)) {
                    int index = fibArrayList.indexOf(spyIdInt);

                    //
                    spyDataStBuild.putSpyFibIndex(spy, index);
                    countIndex++;
                }

            } else {
                //Employees that are not spies now - Suspects only add to List and Map structures
                SpySuspect spySuspect = new SpySuspect(emp);
                spySuspect.setEmployee(emp);
                spySuspect.setIsSpySuspect(false);
                spySuspectMapBuild.put(spySuspect.getEmployee().getId(), spySuspect);
                spySuspectListBuild.add(spySuspect);

            }

        }
        
        //Transfer built data to SpyDataStore Structures
        spyDataStBuild.setSpyList(spyListBuild);
        spyDataStBuild.setEmpClub(empClubMapBuild);
        spyDataStBuild.setEmpJob(empJobMapBuild);
        spyDataStBuild.setEmpPhone(empPhoneMapBuild);
        spyDataStBuild.setEmpAddressList(empAddressListBuild);
        spyDataStBuild.setSpySuspectMap(spySuspectMapBuild);
        spyDataStBuild.setEmpJobList(empJobListBuild);
        spyDataStBuild.setEmpPhoneList(empPhoneListBuild);
        spyDataStBuild.setEmpClubList(empClubListBuild);
        spyDataStBuild.setEmpSocietyList(empSocietyListBuild);
        spyDataStBuild.setStaffList(staff);
        System.out.println("Spies found :" + countIndex);
        //System.out.println("Phone List found :" + empPhoneListBuild);
    }

    /**
     *
     */
    public void printSpyFibIndex() {
        //print the Fibonacci Sequence
        System.out.println(fibArrayList);
        
        spyDataStBuild.getSpyFibIndex().forEach((x, y) -> {
            int countspyfib = 0;
            //for each spy print id and fibonacci index
            System.out.println("Spy  " + x.getEmployee().getId() + " is Fibonacci " + y);
            countspyfib++;
        });

        System.out.println("\n SpyFibIndex Spies " + spyDataStBuild.getSpyFibIndexSize() + "\n");
    }

    /**
     *
     */
    public void printListOfSpies() {
        int countSpy = 0;
        //for (Employee spy : spyDataStBuild.getSpyList()) {
        for (EmployeeExpanded spy : spyDataStBuild.getSpyList()) {
            countSpy++;
            System.out.println(spy);
        }

        System.out.println("Number of Spies " + countSpy);
    }

    /**
     *
     */
    public void buildJobList() {
        int countj = 0;
        for (Employee emp : staff) {
            String jobTitle = emp.getJobTitle();
            //spyDataSt.jobList.add(jobTitle);

        }

        
        spyDataStBuild.getJobList().stream().distinct().collect(Collectors.toList());

        for (String job : spyDataStBuild.getJobList()) {
            System.out.println(job);
            countj++;
        }
        System.out.println("No. of Job Titles " + countj);

    }

    /**
     *
     * @param staff
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public ArrayList<Employee> deserializeFromDisk(ArrayList<Employee> staff) throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream("Employee.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        staff = (ArrayList<Employee>) in.readObject();
        return staff;
    }

    /**
     *
     * @return
     */
    public Integer[] getFibArray() {
        return fibArray;
    }

    /**
     *
     */
    public void printFibArray() {
        System.out.println(Arrays.toString(fibArray));
    }

    /**
     *
     * @return
     */
    public List<Integer> getFibArrayList() {
        return fibArrayList;
    }

    /**
     *
     * @param fibArrayList
     */
    public void setFibArrayList(List<Integer> fibArrayList) {
        this.fibArrayList = fibArrayList;
    }

    /**
     *
     * @return
     */
    public List<Integer> getSpyIndex() {
        return spyIndex;
    }

    /**
     *
     * @param spyIndex
     */
    public void setSpyIndex(List<Integer> spyIndex) {
        this.spyIndex = spyIndex;
    }

    /**
     *
     * @return
     */
    public SpyDataStore getSpyDataStBuild() {
        return spyDataStBuild;
    }

    /**
     *
     * @return
     */
    public List<Spy> getSpyListBuild() {
        return spyListBuild;
    }

    /**
     *
     * @param spyList
     */
    public void setSpyListBuild(List<Spy> spyList) {
        this.spyListBuild = spyList;
    }

    /**
     *
     * @return
     */
    public HashMap<String, String> getBuildEmpClub() {
        return empClubMapBuild;
    }

    /**
     *
     * @param buildEmpClub
     */
    public void setBuildEmpClub(HashMap<String, String> buildEmpClub) {
        this.empClubMapBuild = buildEmpClub;
    }

    /**
     *
     * @return
     */
    public HashMap<String, String> getBuildEmpPhone() {
        return empPhoneMapBuild;
    }

    /**
     *
     * @param buildEmpPhone
     */
    public void setBuildEmpPhone(HashMap<String, String> buildEmpPhone) {
        this.empPhoneMapBuild = buildEmpPhone;
    }

    /**
     *
     * @return
     */
    public HashMap<String, String> getBuildEmpJob() {
        return empJobMapBuild;
    }

    /**
     *
     * @param buildEmpJob
     */
    public void setBuildEmpJob(HashMap<String, String> buildEmpJob) {
        this.empJobMapBuild = buildEmpJob;
    }

    /**
     *
     * @return
     */
    public HashMap<String, String> getBuildspyClub() {
        return spyClubMapBuild;
    }

    /**
     *
     * @param buildspyClub
     */
    public void setBuildspyClub(HashMap<String, String> buildspyClub) {
        this.spyClubMapBuild = buildspyClub;
    }

    /**
     *
     * @return
     */
    public HashMap<String, String> getBuildspyPhone() {
        return spyPhoneMapBuild;
    }

    /**
     *
     * @param buildspyPhone
     */
    public void setBuildspyPhone(HashMap<String, String> buildspyPhone) {
        this.spyPhoneMapBuild = buildspyPhone;
    }

    /**
     *
     * @return
     */
    public HashMap<String, String> getBuildspyJob() {
        return spyJobMapBuild;
    }

    /**
     *
     * @param buildspyJob
     */
    public void setBuildspyJob(HashMap<String, String> buildspyJob) {
        this.spyJobMapBuild = buildspyJob;
    }

    /**
     *
     * @return
     */
    public HashMap<String, SpySuspect> getBuildspySuspect() {
        return spySuspectMapBuild;
    }

    /**
     *
     * @param buildspySuspect
     */
    public void setBuildspySuspect(HashMap<String, SpySuspect> buildspySuspect) {
        this.spySuspectMapBuild = buildspySuspect;
    }

    /**
     *
     * @return
     */
    public List<SpySuspect> getSpySuspectListBuild() {
        return spySuspectListBuild;
    }

    /**
     *
     * @param spySuspectListBuild
     */
    public void setSpySuspectListBuild(List<SpySuspect> spySuspectListBuild) {
        this.spySuspectListBuild = spySuspectListBuild;
    }

    /**
     *
     * @return
     */
    public List<String> getEmpClubListBuild() {
        return empClubListBuild;
    }

    /**
     *
     * @param empClubListBuild
     */
    public void setEmpClubListBuild(List<String> empClubListBuild) {
        this.empClubListBuild = empClubListBuild;
    }

    /**
     *
     * @return
     */
    public List<String> getEmpPhoneListBuild() {
        return empPhoneListBuild;
    }

    /**
     *
     * @param empPhoneListBuild
     */
    public void setEmpPhoneListBuild(List<String> empPhoneListBuild) {
        this.empPhoneListBuild = empPhoneListBuild;
    }

    /**
     *
     * @return
     */
    public List<String> getEmpJobListBuild() {
        return empJobListBuild;
    }

    /**
     *
     * @param empJobListBuild
     */
    public void setEmpJobListBuild(List<String> empJobListBuild) {
        this.empJobListBuild = empJobListBuild;
    }

    /**
     *
     * @return
     */
    public List<String> getEmpAddressListBuild() {
        return empAddressListBuild;
    }

    /**
     *
     * @param empAddressListBuild
     */
    public void setEmpAddressListBuild(List<String> empAddressListBuild) {
        this.empAddressListBuild = empAddressListBuild;
    }

    /**
     *
     * @return
     */
    public HashMap<String, String> getEmpClubMapBuild() {
        return empClubMapBuild;
    }

    /**
     *
     * @param empClubMapBuild
     */
    public void setEmpClubMapBuild(HashMap<String, String> empClubMapBuild) {
        this.empClubMapBuild = empClubMapBuild;
    }

    /**
     *
     * @return
     */
    public HashMap<String, String> getEmpPhoneMapBuild() {
        return empPhoneMapBuild;
    }

    /**
     *
     * @param empPhoneMapBuild
     */
    public void setEmpPhoneMapBuild(HashMap<String, String> empPhoneMapBuild) {
        this.empPhoneMapBuild = empPhoneMapBuild;
    }

    /**
     *
     * @return
     */
    public HashMap<String, String> getEmpJobMapBuild() {
        return empJobMapBuild;
    }

    /**
     *
     * @param empJobMapBuild
     */
    public void setEmpJobMapBuild(HashMap<String, String> empJobMapBuild) {
        this.empJobMapBuild = empJobMapBuild;
    }

    /**
     *
     * @return
     */
    public HashMap<String, String> getSpyClubMapBuild() {
        return spyClubMapBuild;
    }

    /**
     *
     * @param spyClubMapBuild
     */
    public void setSpyClubMapBuild(HashMap<String, String> spyClubMapBuild) {
        this.spyClubMapBuild = spyClubMapBuild;
    }

    /**
     *
     * @return
     */
    public HashMap<String, String> getSpyPhoneMapBuild() {
        return spyPhoneMapBuild;
    }

    /**
     *
     * @param spyPhoneMapBuild
     */
    public void setSpyPhoneMapBuild(HashMap<String, String> spyPhoneMapBuild) {
        this.spyPhoneMapBuild = spyPhoneMapBuild;
    }

    /**
     *
     * @return
     */
    public HashMap<String, String> getEmpAddressMapBuild() {
        return empAddressMapBuild;
    }

    /**
     *
     * @param empAddressMapBuild
     */
    public void setEmpAddressMapBuild(HashMap<String, String> empAddressMapBuild) {
        this.empAddressMapBuild = empAddressMapBuild;
    }

    /**
     *
     * @return
     */
    public HashMap<String, String> getSpyJobMapBuild() {
        return spyJobMapBuild;
    }

    /**
     *
     * @return
     */
    public List<String> getEmpSocietyListBuild() {
        return empSocietyListBuild;
    }

    /**
     *
     * @param empSocietyListBuild
     */
    public void setEmpSocietyListBuild(List<String> empSocietyListBuild) {
        this.empSocietyListBuild = empSocietyListBuild;
    }

    /**
     *
     * @return
     */
    public HashMap<String, SpySuspect> getSpySuspectMapBuild() {
        return spySuspectMapBuild;
    }

    /**
     *
     * @param spySuspectMapBuild
     */
    public void setSpySuspectMapBuild(HashMap<String, SpySuspect> spySuspectMapBuild) {
        this.spySuspectMapBuild = spySuspectMapBuild;
    }

}
