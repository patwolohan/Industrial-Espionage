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
public class Build implements BuildSpyList, BuildFib, PrintListOfSpies, PrintSpyFibIndex, BuildEmployeeFile {

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
    private Data d = new Data();
    private Fibonacci fb = new Fibonacci();

    /**
     *
     */
    public Build() {

    }

    /**
     * This method creates an Integer ArrayList of Fibonacci Numbers
     */
    @Override
    public void buildFib() {
        //in Data class create Fibonacci Integer Array of FibSize(40) recursively       
        for (int i = 0; i < Data.getFibSize(); i++) {
            d.setFibArray(i, fb.fibGenerate(i));
        }
        //fibArrayList  is populated with Fibonacci Integer Array
        fibArrayList = Arrays.asList(d.getFibArray());

    }

    /**
     *
     * @return ArrayList Employee type object staff
     */
    public ArrayList<Employee> getStaff() {
        return staff;
    }

    /**
     *
     * @return staff ArrayList String
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public ArrayList<Employee> buildEmployeeFile() throws IOException, ClassNotFoundException {

        staff = deserializeFromDisk(staff);
        return staff;
    }

    /**
     * Calls buildFib() and buildSpyList Methods
     */
    public void buildAll() {
        buildFib();
        buildSpyList();
    }

    /**
     * Builds Spy & SpySuspect Lists from Employee ArrayList data Big O
     * complexity of O(N)
     */
    @Override
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
        
    }

    /**
     * Prints Spy with Fibonacci Sequence Number Big O complexity of O(N)
     */
    public void printSpyFibIndex() {
        System.out.println("Fibonacci Sequence: Size: " + Data.getFibSize() + "\n");
        //print the Fibonacci Sequence
        System.out.println(fibArrayList + "\n");

        spyDataStBuild.getSpyFibIndex().forEach((x, y) -> {
            int countspyfib = 0;
            //for each spy print fibonacci index and spy id 
            System.out.println("Spy  " + x.getEmployee().getId() + " contains Fibonacci Number Index: " + y);
            countspyfib++;
        });

        System.out.println();
    }

    /**
     * Prints a List of Spies Big O complexity of O(N)
     */
    public void printListOfSpies() {
        int countSpy = 0;
        for (Spy spy : spyDataStBuild.getSpyList()) {
            countSpy++;
            System.out.println(spy);
        }

        System.out.println("Number of Spies " + countSpy);
    }

    /**
     * Build an ArrayList of Employee Job Titles Big O complexity of O(N)
     */
    public void buildJobList() {
        int countj = 0;
        for (Employee emp : staff) {
            String jobTitle = emp.getJobTitle();

        }

        spyDataStBuild.getJobList().stream().distinct().collect(Collectors.toList());

        for (String job : spyDataStBuild.getJobList()) {
            System.out.println(job);
            countj++;
        }
        System.out.println("No. of Job Titles " + countj);

    }

    /**
     *Streams the serialized Employee data from disk file and reads it to ArrayList staff
     * @param staff
     * @return ArrayList Employee staff
     * @throws IOException
     * @throws ClassNotFoundException Big O complexity of O(N)
     */
    public ArrayList<Employee> deserializeFromDisk(ArrayList<Employee> staff) throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream("Employee.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        staff = (ArrayList<Employee>) in.readObject();
        return staff;
    }

    /**
     *
     * @return fibArray Array of type Integer
     */
    public Integer[] getFibArray() {
        return fibArray;
    }

    /**
     * Prints the Fibonacci Sequence
     */
    public void printFibArray() {

        System.out.println(Arrays.toString(fibArray));
    }

    /**
     *
     * @return ArrayList fibArrayList
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
     * @return List spyIndex
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
     * @return HashMap String, String empClubMapBuild
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
     * @return HashMap String, String empPhoneMapBuild
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
     * @return HashMap String, String empJobMapBuild
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
     * @return HashMap String, String spyClubMapBuild
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
     * @return HashMap String, String spyPhonebMapBuild
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
     * @return HashMap String, String spyJobMapBuild
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
     * @return HashMap String, SpySuspect spySuspectMapBuild
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
     * @return HashMap String, String spySuspectListBuild
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
     * @return ArrayList empClubListBuild
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
     * @return ArrayList empPhoneListBuild
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
     * @return ArrayList empJobListBuild
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
     * @return ArrayList empAddressListBuild
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
     * @return HashMap String, String empClubListBuild
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
     * @return HashMap String, String empPhoneMapBuild
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
     * @return HashMap String, String empClubListBuild
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
     * @return HashMap String, String spyClubMapBuild
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
     * @return HashMap String, String spyClubMapBuild
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
     * @return HashMap String, String empAddressMapBuild
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
     * @return HashMap String, String spyJobbMapBuild
     */
    public HashMap<String, String> getSpyJobMapBuild() {
        return spyJobMapBuild;
    }

    /**
     *
     * @return List String empSocietyListBuild
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
     * @return HashMap String, SpySuspect spySuspectMapBuild
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

    /**
     *
     * @return Data object d
     */
    public Data getD() {
        return d;
    }

    /**
     *
     * @param d Data object
     */
    public void setD(Data d) {
        this.d = d;
    }

    /**
     *
     * @return Fibonacci object fb
     */
    public Fibonacci getFb() {
        return fb;
    }

    /**
     *
     * @param fb Fibonacci object
     */
    public void setFb(Fibonacci fb) {
        this.fb = fb;
    }

}
