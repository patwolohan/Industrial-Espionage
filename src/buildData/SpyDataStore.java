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
 * @author pwolo
 */
public class SpyDataStore {
    
    private List<Spy> spyList = new ArrayList<>();
    private List<String> empClubList = new ArrayList<>();
    private List<String> empSocietyList = new ArrayList<>();
    private List<String> empPhoneList = new ArrayList<>();
    private List<String> empJobList = new ArrayList<>();
    private List<String> empAddressList = new ArrayList<>();
    private HashMap<String, Spy> spyHashMap = new LinkedHashMap<>();
    private List<String> jobList = new ArrayList<>();
    private HashMap<Integer, Spy> spyFibIndexMap = new LinkedHashMap<>();
    private HashMap<String, String> empClubMap = new LinkedHashMap<>();
    private HashMap<String, String> empPhoneMap = new LinkedHashMap<>();
    private HashMap<String, String> empJobMap = new LinkedHashMap<>();
    private HashMap<String, String> empAddressMap = new LinkedHashMap<>();
    private HashMap<String, String> spyClub = new LinkedHashMap<>();
    private HashMap<String, String> spyPhone = new LinkedHashMap<>();
    private HashMap<String, String> spyJob = new LinkedHashMap<>();
    private HashMap<String, SpySuspect> spySuspectMap = new LinkedHashMap<>();

    public SpyDataStore() {
    }

    
    public SpyDataStore(SpyDataStore s) {
        
    }
    
    



    public List<String> getJobList() {
        return jobList;
    }

    public void setJobList(List<String> jobList) {
        this.jobList = jobList;
    }
    
    public void addJobListSpy(String jobTitle) {
        this.jobList.add(jobTitle);
    }

    public HashMap<Integer, Spy> getSpyFibIndex() {
        return spyFibIndexMap;
    }
    
    public int getSpyFibIndexSize() {
        return spyFibIndexMap.size();
    }

    public void setSpyFibIndex(HashMap<Integer, Spy> spyFibIndex) {
        this.spyFibIndexMap = spyFibIndex;
    }
    
    public void putSpyFibIndex(Integer spyFibIndex, Spy spy) {
        this.spyFibIndexMap.put(spyFibIndex, spy);
    }
    
    public void putSpyHashMap(String iD, Spy spy) {
        this.spyHashMap.put(iD, spy);
    }
    public HashMap<String, String> getEmpClub() {
        return empClubMap;
    }

    public void setEmpClub(HashMap<String, String> EmpClub) {
        this.empClubMap = EmpClub;
    }

    public HashMap<String, String> getEmpPhone() {
        return empPhoneMap;
    }

    public void setEmpPhone(HashMap<String, String> EmpPhone) {
        this.empPhoneMap = EmpPhone;
    }

    public HashMap<String, String> getEmpJob() {
        return empJobMap;
    }

    public void setEmpJob(HashMap<String, String> EmpJob) {
        this.empJobMap = EmpJob;
    }

    public HashMap<String, String> getSpyClub() {
        return spyClub;
    }

    public void setSpyClub(HashMap<String, String> spyClub) {
        this.spyClub = spyClub;
    }

    public HashMap<String, String> getSpyPhone() {
        return spyPhone;
    }

    public void setSpyPhone(HashMap<String, String> spyPhone) {
        this.spyPhone = spyPhone;
    }

    public HashMap<String, String> getSpyJob() {
        return spyJob;
    }

    public void setSpyJob(HashMap<String, String> spyJob) {
        this.spyJob = spyJob;
    }

    public HashMap<String, SpySuspect> getSpySuspectHashMap() {
        return spySuspectMap;
    }

    public void setSpySuspectHashMap(HashMap<String, SpySuspect> spySuspect) {
        this.spySuspectMap = spySuspect;
    }

    public HashMap<String, Spy> getSpyHashMap() {
        return spyHashMap;
    }

    public void setSpyHashMap(HashMap<String, Spy> spyHashMap) {
        this.spyHashMap = spyHashMap;
    }

    public List<Spy> getSpyList() {
        return spyList;
    }

    public void setSpyList(List<Spy> spyList) {
        this.spyList = spyList;
    }

    public List<String> getEmpClubList() {
        return empClubList;
    }

    public void setEmpClubList(List<String> empClubList) {
        this.empClubList = empClubList;
    }

    public List<String> getEmpPhoneList() {
        return empPhoneList;
    }

    public void setEmpPhoneList(List<String> empPhoneList) {
        this.empPhoneList = empPhoneList;
    }

    public List<String> getEmpJobList() {
        return empJobList;
    }

    public void setEmpJobList(List<String> empJobList) {
        this.empJobList = empJobList;
    }

    public List<String> getEmpAddressList() {
        return empAddressList;
    }

    public void setEmpAddressList(List<String> empAddressList) {
        this.empAddressList = empAddressList;
    }

    public HashMap<Integer, Spy> getSpyFibIndexMap() {
        return spyFibIndexMap;
    }

    public void setSpyFibIndexMap(HashMap<Integer, Spy> spyFibIndexMap) {
        this.spyFibIndexMap = spyFibIndexMap;
    }

    public HashMap<String, String> getEmpClubMap() {
        return empClubMap;
    }

    public void setEmpClubMap(HashMap<String, String> empClubMap) {
        this.empClubMap = empClubMap;
    }

    public HashMap<String, String> getEmpPhoneMap() {
        return empPhoneMap;
    }

    public void setEmpPhoneMap(HashMap<String, String> empPhoneMap) {
        this.empPhoneMap = empPhoneMap;
    }

    public HashMap<String, String> getEmpJobMap() {
        return empJobMap;
    }

    public void setEmpJobMap(HashMap<String, String> empJobMap) {
        this.empJobMap = empJobMap;
    }

    public HashMap<String, String> getEmpAddressMap() {
        return empAddressMap;
    }

    public void setEmpAddressMap(HashMap<String, String> empAddressMap) {
        this.empAddressMap = empAddressMap;
    }

    public HashMap<String, SpySuspect> getSpySuspectMap() {
        return spySuspectMap;
    }

    public void setSpySuspectMap(HashMap<String, SpySuspect> spySuspectMap) {
        this.spySuspectMap = spySuspectMap;
    }

    public List<String> getEmpSocietyList() {
        return empSocietyList;
    }

    public void setEmpSocietyList(List<String> empSocietyList) {
        this.empSocietyList = empSocietyList;
    }
    
    
    
    
    
    
}
