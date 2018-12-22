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
 * @author PatWolohan <patwolohan.org>
 */
public class Build {

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

    private SpyDataStore spyDataStBuild = new SpyDataStore();

    public Build() {

    }

    public void buildFib() {

        Data d = new Data();
        Fibonacci fb = new Fibonacci();
        for (int i = 0; i < Data.getFibSize(); i++) {
            d.setFibArray(i, fb.fibGenerate(i));

        }

        this.fibArray = d.getFibArray();
        fibArrayList = Arrays.asList(fibArray);

    }

    public ArrayList<Employee> getStaff() {
        return staff;
    }

    public ArrayList<Employee> buildEmployeeFile() throws IOException, ClassNotFoundException {

        staff = deserializeFromDisk(staff);
        return staff;
    }

    public void buildAll() {

    }

    public void buildEmpPhoneFile() {

    }

    public void buildEmpClubFile() {

    }

    public void buildEmpJobFile() {

    }

    public void buildSpyList() {

        //int count = 0;
        int countIndex = 0;
        String spyEdited;
        for (Employee emp : staff) {

            empClubMapBuild.put(emp.getId(), emp.getMemberOf());
            empJobMapBuild.put(emp.getId(), emp.getJobTitle());
            empPhoneMapBuild.put(emp.getId(), emp.getPhone());
            empAddressMapBuild.put(emp.getId(), emp.getAddress());

            empJobListBuild.add(emp.getJobTitle());
            empAddressListBuild.add(emp.getAddress());
            
            String[] empMemberSplit = emp.getMemberOf().split(",");
            empSocietyListBuild.add(empMemberSplit[0]);
            empClubListBuild.add(empMemberSplit[1]);
            empPhoneListBuild.add(emp.getPhone());
            //System.out.println("emp phone "+ emp.getPhone());

            //remove starting letter from staff Arraylist id and store in empId
            String empId = emp.getId().substring(1);

            if (empId.endsWith("fibonacci")) {

                //
                Spy spy = new Spy(emp);
                spy.setEmployee(emp);
                spy.setIsSpy(true);
                spyListBuild.add(spy);
                //spyDataStBuild.addSpyListSpy(emp);
                spyDataStBuild.putSpyHashMap(empId, spy);
                //
                spy.setIsSpy(true);
                //remove starting letter and assign to spyId                
                String spyId = emp.getId().substring(1);
                //remove "fibonacci" from String and assign to String spyEdited
                spyEdited = spyId.replaceFirst("fibonacci", "");
                //parse String spyEdited to Integer spyIdInt
                int spyIdInt = Integer.parseInt(spyEdited);

                //if fibArraylist contains (spy id numerals) int spyIdInt 
                //pick out index of fibonacci number found
                //add to spyFibIndex LinkedHashmap 
                if (fibArrayList.contains(spyIdInt)) {
                    int index = fibArrayList.indexOf(spyIdInt);

                    //spyFibIndex.put(index, emp);
                    spyDataStBuild.putSpyFibIndex(index, spy);
                    countIndex++;
                }

            } else {
                //Employees that are not spies now - Suspects only
                SpySuspect spySuspect = new SpySuspect(emp);
                spySuspect.setEmployee(emp);
                spySuspect.setIsSpySuspect(false);
                spySuspectMapBuild.put(spySuspect.getEmployee().getId(), spySuspect);
                spySuspectListBuild.add(spySuspect);

            }

        }

        spyDataStBuild.setSpyList(spyListBuild);
        spyDataStBuild.setEmpClub(empClubMapBuild);
        spyDataStBuild.setEmpJob(empJobMapBuild);
        spyDataStBuild.setEmpPhone(empPhoneMapBuild);
        spyDataStBuild.setEmpAddressList(empAddressListBuild);
        spyDataStBuild.setSpySuspectMap(spySuspectMapBuild);
        spyDataStBuild.setEmpPhoneList(empPhoneListBuild);
        spyDataStBuild.setEmpClubList(empClubListBuild);
        spyDataStBuild.setEmpSocietyList(empSocietyListBuild);
        System.out.println("Spies found :" + countIndex);
        //System.out.println("Phone List found :" + empPhoneListBuild);
    }

    public void printSpyFibIndex() {

        System.out.println(fibArrayList);
        spyDataStBuild.getSpyFibIndex().forEach((x, y) -> {
            int countspyfib = 0;
            System.out.println("Spy  " + y.getEmployee().getId() + " is Fibonacci " + x);
            countspyfib++;
        });

        System.out.println("\n SpyFibIndex Spies " + spyDataStBuild.getSpyFibIndexSize() + "\n");
    }

    public void printListOfSpies() {
        int countSpy = 0;
        //for (Employee spy : spyDataStBuild.getSpyList()) {
        for (EmployeeExpanded spy : spyDataStBuild.getSpyList()) {
            countSpy++;
            System.out.println(spy);
        }

        System.out.println("Number of Spies " + countSpy);
    }

    public void buildJobList() {
        int countj = 0;
        for (Employee emp : staff) {
            String jobTitle = emp.getJobTitle();
            //spyDataSt.jobList.add(jobTitle);

        }

        //jobList = jobList.stream().distinct().collect(Collectors.toList());
        spyDataStBuild.getJobList().stream().distinct().collect(Collectors.toList());

        for (String job : spyDataStBuild.getJobList()) {
            System.out.println(job);
            countj++;
        }
        System.out.println("No. of Job Titles " + countj);

    }

    public ArrayList<Employee> deserializeFromDisk(ArrayList<Employee> staff) throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream("Employee.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        staff = (ArrayList<Employee>) in.readObject();
        return staff;
    }

    public Integer[] getFibArray() {
        return fibArray;
    }

    public void printFibArray() {
        System.out.println(Arrays.toString(fibArray));
    }


    public List<Integer> getFibArrayList() {
        return fibArrayList;
    }

    public void setFibArrayList(List<Integer> fibArrayList) {
        this.fibArrayList = fibArrayList;
    }

    public List<Integer> getSpyIndex() {
        return spyIndex;
    }

    public void setSpyIndex(List<Integer> spyIndex) {
        this.spyIndex = spyIndex;
    }

    public SpyDataStore getSpyDataStBuild() {
        return spyDataStBuild;
    }

    public List<Spy> getSpyListBuild() {
        return spyListBuild;
    }

    public void setSpyListBuild(List<Spy> spyList) {
        this.spyListBuild = spyList;
    }

    public HashMap<String, String> getBuildEmpClub() {
        return empClubMapBuild;
    }

    public void setBuildEmpClub(HashMap<String, String> buildEmpClub) {
        this.empClubMapBuild = buildEmpClub;
    }

    public HashMap<String, String> getBuildEmpPhone() {
        return empPhoneMapBuild;
    }

    public void setBuildEmpPhone(HashMap<String, String> buildEmpPhone) {
        this.empPhoneMapBuild = buildEmpPhone;
    }

    public HashMap<String, String> getBuildEmpJob() {
        return empJobMapBuild;
    }

    public void setBuildEmpJob(HashMap<String, String> buildEmpJob) {
        this.empJobMapBuild = buildEmpJob;
    }

    public HashMap<String, String> getBuildspyClub() {
        return spyClubMapBuild;
    }

    public void setBuildspyClub(HashMap<String, String> buildspyClub) {
        this.spyClubMapBuild = buildspyClub;
    }

    public HashMap<String, String> getBuildspyPhone() {
        return spyPhoneMapBuild;
    }

    public void setBuildspyPhone(HashMap<String, String> buildspyPhone) {
        this.spyPhoneMapBuild = buildspyPhone;
    }

    public HashMap<String, String> getBuildspyJob() {
        return spyJobMapBuild;
    }

    public void setBuildspyJob(HashMap<String, String> buildspyJob) {
        this.spyJobMapBuild = buildspyJob;
    }

    public HashMap<String, SpySuspect> getBuildspySuspect() {
        return spySuspectMapBuild;
    }

    public void setBuildspySuspect(HashMap<String, SpySuspect> buildspySuspect) {
        this.spySuspectMapBuild = buildspySuspect;
    }

    public List<SpySuspect> getSpySuspectListBuild() {
        return spySuspectListBuild;
    }

    public void setSpySuspectListBuild(List<SpySuspect> spySuspectListBuild) {
        this.spySuspectListBuild = spySuspectListBuild;
    }

    public List<String> getEmpClubListBuild() {
        return empClubListBuild;
    }

    public void setEmpClubListBuild(List<String> empClubListBuild) {
        this.empClubListBuild = empClubListBuild;
    }

    public List<String> getEmpPhoneListBuild() {
        return empPhoneListBuild;
    }

    public void setEmpPhoneListBuild(List<String> empPhoneListBuild) {
        this.empPhoneListBuild = empPhoneListBuild;
    }

    public List<String> getEmpJobListBuild() {
        return empJobListBuild;
    }

    public void setEmpJobListBuild(List<String> empJobListBuild) {
        this.empJobListBuild = empJobListBuild;
    }

    public List<String> getEmpAddressListBuild() {
        return empAddressListBuild;
    }

    public void setEmpAddressListBuild(List<String> empAddressListBuild) {
        this.empAddressListBuild = empAddressListBuild;
    }

    public HashMap<String, String> getEmpClubMapBuild() {
        return empClubMapBuild;
    }

    public void setEmpClubMapBuild(HashMap<String, String> empClubMapBuild) {
        this.empClubMapBuild = empClubMapBuild;
    }

    public HashMap<String, String> getEmpPhoneMapBuild() {
        return empPhoneMapBuild;
    }

    public void setEmpPhoneMapBuild(HashMap<String, String> empPhoneMapBuild) {
        this.empPhoneMapBuild = empPhoneMapBuild;
    }

    public HashMap<String, String> getEmpJobMapBuild() {
        return empJobMapBuild;
    }

    public void setEmpJobMapBuild(HashMap<String, String> empJobMapBuild) {
        this.empJobMapBuild = empJobMapBuild;
    }

    public HashMap<String, String> getSpyClubMapBuild() {
        return spyClubMapBuild;
    }

    public void setSpyClubMapBuild(HashMap<String, String> spyClubMapBuild) {
        this.spyClubMapBuild = spyClubMapBuild;
    }

    public HashMap<String, String> getSpyPhoneMapBuild() {
        return spyPhoneMapBuild;
    }

    public void setSpyPhoneMapBuild(HashMap<String, String> spyPhoneMapBuild) {
        this.spyPhoneMapBuild = spyPhoneMapBuild;
    }

    public HashMap<String, String> getEmpAddressMapBuild() {
        return empAddressMapBuild;
    }

    public void setEmpAddressMapBuild(HashMap<String, String> empAddressMapBuild) {
        this.empAddressMapBuild = empAddressMapBuild;
    }

    public HashMap<String, String> getSpyJobMapBuild() {
        return spyJobMapBuild;
    }

}
