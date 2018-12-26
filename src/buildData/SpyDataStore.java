/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buildData;

import employeedata.Employee;
import employeedata.Spy;
import employeedata.SpySuspect;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Pat Wolohan & Eanna Ryan
 */
public class SpyDataStore {
    
    private ArrayList<Employee> staffList = new ArrayList<>();
    private List<Spy> spyList = new ArrayList<>();
    private List<String> empClubList = new ArrayList<>();
    private List<String> empSocietyList = new ArrayList<>();
    private List<String> empPhoneList = new ArrayList<>();
    private List<String> empJobList = new ArrayList<>();
    private List<String> empAddressList = new ArrayList<>();
    private HashMap<Spy, String> spyHashMap = new LinkedHashMap<>();
    private List<String> jobList = new ArrayList<>();
    private HashMap<Spy, Integer> spyFibIndexMap = new LinkedHashMap<>();
    private HashMap<String, String> empClubMap = new LinkedHashMap<>();
    private HashMap<String, String> empPhoneMap = new LinkedHashMap<>();
    private HashMap<String, String> empJobMap = new LinkedHashMap<>();
    private HashMap<String, String> empAddressMap = new LinkedHashMap<>();
    private HashMap<String, String> spyClub = new LinkedHashMap<>();
    private HashMap<String, String> spyPhone = new LinkedHashMap<>();
    private HashMap<String, String> spyJob = new LinkedHashMap<>();
    private HashMap<String, SpySuspect> spySuspectMap = new LinkedHashMap<>();

    /**
     *
     */
    public SpyDataStore() {
    }

    /**
     *
     * @param s
     */
    public SpyDataStore(SpyDataStore s) {
        
    }
    
    /**
     *
     * @return
     */
    public List<String> getJobList() {
        return jobList;
    }

    /**
     *
     * @param jobList
     */
    public void setJobList(List<String> jobList) {
        this.jobList = jobList;
    }
    
    /**
     *
     * @param jobTitle
     */
    public void addJobListSpy(String jobTitle) {
        this.jobList.add(jobTitle);
    }

    /**
     *
     * @return
     */
    public HashMap<Spy, Integer> getSpyFibIndex() {
        return spyFibIndexMap;
    }
    
    /**
     *
     * @return
     */
    public int getSpyFibIndexSize() {
        return spyFibIndexMap.size();
    }

    /**
     *
     * @param spyFibIndex
     */
    public void setSpyFibIndex(HashMap<Spy, Integer> spyFibIndex) {
        this.spyFibIndexMap = spyFibIndex;
    }
    
    /**
     *
     * @param spyFibIndex
     * @param spy
     */
    public void putSpyFibIndex(Spy spy, Integer spyFibIndex) {
        this.spyFibIndexMap.put(spy, spyFibIndex);
    }
    
    /**
     *
     * @param iD
     * @param spy
     */
    public void putSpyHashMap(Spy spy, String iD) {
        this.spyHashMap.put(spy, iD);
    }

    /**
     *
     * @return
     */
    public HashMap<String, String> getEmpClub() {
        return empClubMap;
    }

    /**
     *
     * @param EmpClub
     */
    public void setEmpClub(HashMap<String, String> EmpClub) {
        this.empClubMap = EmpClub;
    }

    /**
     *
     * @return
     */
    public HashMap<String, String> getEmpPhone() {
        return empPhoneMap;
    }

    /**
     *
     * @param EmpPhone
     */
    public void setEmpPhone(HashMap<String, String> EmpPhone) {
        this.empPhoneMap = EmpPhone;
    }

    /**
     *
     * @return
     */
    public HashMap<String, String> getEmpJob() {
        return empJobMap;
    }

    /**
     *
     * @param EmpJob
     */
    public void setEmpJob(HashMap<String, String> EmpJob) {
        this.empJobMap = EmpJob;
    }

    /**
     *
     * @return
     */
    public HashMap<String, String> getSpyClub() {
        return spyClub;
    }

    /**
     *
     * @param spyClub
     */
    public void setSpyClub(HashMap<String, String> spyClub) {
        this.spyClub = spyClub;
    }

    /**
     *
     * @return
     */
    public HashMap<String, String> getSpyPhone() {
        return spyPhone;
    }

    /**
     *
     * @param spyPhone
     */
    public void setSpyPhone(HashMap<String, String> spyPhone) {
        this.spyPhone = spyPhone;
    }

    /**
     *
     * @return
     */
    public HashMap<String, String> getSpyJob() {
        return spyJob;
    }

    /**
     *
     * @param spyJob
     */
    public void setSpyJob(HashMap<String, String> spyJob) {
        this.spyJob = spyJob;
    }

    /**
     *
     * @return
     */
    public HashMap<String, SpySuspect> getSpySuspectHashMap() {
        return spySuspectMap;
    }

    /**
     *
     * @param spySuspect
     */
    public void setSpySuspectHashMap(HashMap<String, SpySuspect> spySuspect) {
        this.spySuspectMap = spySuspect;
    }

    /**
     *
     * @return
     */
    public HashMap<Spy, String> getSpyHashMap() {
        return spyHashMap;
    }

    /**
     *
     * @param spyHashMap
     */
    public void setSpyHashMap(HashMap<Spy, String> spyHashMap) {
        this.spyHashMap = spyHashMap;
    }

    /**
     *
     * @return
     */
    public List<Spy> getSpyList() {
        return spyList;
    }

    /**
     *
     * @param spyList
     */
    public void setSpyList(List<Spy> spyList) {
        this.spyList = spyList;
    }

    /**
     *
     * @return
     */
    public List<String> getEmpClubList() {
        return empClubList;
    }

    /**
     *
     * @param empClubList
     */
    public void setEmpClubList(List<String> empClubList) {
        this.empClubList = empClubList;
    }

    /**
     *
     * @return
     */
    public List<String> getEmpPhoneList() {
        return empPhoneList;
    }

    /**
     *
     * @param empPhoneList
     */
    public void setEmpPhoneList(List<String> empPhoneList) {
        this.empPhoneList = empPhoneList;
    }

    /**
     *
     * @return
     */
    public List<String> getEmpJobList() {
        return empJobList;
    }

    /**
     *
     * @param empJobList
     */
    public void setEmpJobList(List<String> empJobList) {
        this.empJobList = empJobList;
    }

    /**
     *
     * @return
     */
    public List<String> getEmpAddressList() {
        return empAddressList;
    }

    /**
     *
     * @param empAddressList
     */
    public void setEmpAddressList(List<String> empAddressList) {
        this.empAddressList = empAddressList;
    }

    /**
     *
     * @return
     */
    public HashMap<Spy, Integer> getSpyFibIndexMap() {
        return spyFibIndexMap;
    }

    /**
     *
     * @param spyFibIndexMap
     */
    public void setSpyFibIndexMap(HashMap<Spy, Integer> spyFibIndexMap) {
        this.spyFibIndexMap = spyFibIndexMap;
    }

    /**
     *
     * @return
     */
    public HashMap<String, String> getEmpClubMap() {
        return empClubMap;
    }

    /**
     *
     * @param empClubMap
     */
    public void setEmpClubMap(HashMap<String, String> empClubMap) {
        this.empClubMap = empClubMap;
    }

    /**
     *
     * @return
     */
    public HashMap<String, String> getEmpPhoneMap() {
        return empPhoneMap;
    }

    /**
     *
     * @param empPhoneMap
     */
    public void setEmpPhoneMap(HashMap<String, String> empPhoneMap) {
        this.empPhoneMap = empPhoneMap;
    }

    /**
     *
     * @return
     */
    public HashMap<String, String> getEmpJobMap() {
        return empJobMap;
    }

    /**
     *
     * @param empJobMap
     */
    public void setEmpJobMap(HashMap<String, String> empJobMap) {
        this.empJobMap = empJobMap;
    }

    /**
     *
     * @return
     */
    public HashMap<String, String> getEmpAddressMap() {
        return empAddressMap;
    }

    /**
     *
     * @param empAddressMap
     */
    public void setEmpAddressMap(HashMap<String, String> empAddressMap) {
        this.empAddressMap = empAddressMap;
    }

    /**
     *
     * @return
     */
    public HashMap<String, SpySuspect> getSpySuspectMap() {
        return spySuspectMap;
    }

    /**
     *
     * @param spySuspectMap
     */
    public void setSpySuspectMap(HashMap<String, SpySuspect> spySuspectMap) {
        this.spySuspectMap = spySuspectMap;
    }

    /**
     *
     * @return
     */
    public List<String> getEmpSocietyList() {
        return empSocietyList;
    }

    /**
     *
     * @param empSocietyList
     */
    public void setEmpSocietyList(List<String> empSocietyList) {
        this.empSocietyList = empSocietyList;
    }

    public ArrayList<Employee> getStaffList() {
        return staffList;
    }

    public void setStaffList(ArrayList<Employee> staffList) {
        this.staffList = staffList;
    }
    
    
    
    
    
    
}
