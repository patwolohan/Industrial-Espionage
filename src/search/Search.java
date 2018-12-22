/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;

import buildData.Build;
import buildData.SpyDataStore;
import employeedata.Spy;
import employeedata.SpySuspect;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author PatWolohan <patwolohan.org>
 */
public class Search implements ListOfSpies, SpySearchMatch, SpySequence, SpySuspectMatch {

    private List<String> jobMatchesList = new ArrayList<>();
    private List<String> clubMatchesList = new ArrayList<>();
     private List<String> societyMatchesList = new ArrayList<>();
    private List<String> phoneMatchesList = new ArrayList<>();
    private List<String> addressMatchesList = new ArrayList<>();
    private Map<String, Long> jobMatchesMap = new LinkedHashMap<>();
    private Map<String, Long> clubMatchesMap = new LinkedHashMap<>();
    private Map<String, Long> societyMatchesMap = new LinkedHashMap<>();
    private Map<String, Long> phoneMatchesMap = new LinkedHashMap<>();

    public Search() {

    }

    @Override
    public void listOfSpies(Build b) {
        b.printListOfSpies();
    }

    @Override
    public void spySequence(Build b) {
        b.printSpyFibIndex();

    }

    @Override
    public void spySuspectMatch(Build b, SpyDataStore s) {

        Map<String, String> empClubMapSearch = new LinkedHashMap<>(s.getEmpClub());
        Map<String, String> empPhoneMapSearch = new LinkedHashMap<>(s.getEmpPhone());
        Map<String, String> empJobMapSearch = new LinkedHashMap<>(s.getEmpJob());
        Map<String, String> empAddressMapSearch = new LinkedHashMap<>(s.getEmpAddressMap());

        List<String> empClubListSearch = new ArrayList<>(s.getEmpClubList());
        List<String> empSocietyListSearch = new ArrayList<>(s.getEmpSocietyList());
        List<String> empPhoneListSearch = new ArrayList<>(s.getEmpPhoneList());
        List<String> empJobListSearch = new ArrayList<>(s.getEmpJobList());
        List<String> empAddressListSearch = new ArrayList<>(s.getEmpAddressList());
        
        List<String> empPhoneListAbrSearch = new ArrayList<>();
        
        empJobListSearch.replaceAll(String::toLowerCase);
        empClubListSearch.replaceAll(String::toLowerCase);
        empAddressListSearch.replaceAll(String::toLowerCase);
        
        for(String str: empPhoneListSearch){
            empPhoneListAbrSearch.add(str.substring(0, 3));            
        }
        
        List<String> phListSearch = new ArrayList<>(empPhoneListAbrSearch.stream().distinct().collect(Collectors.toList()));
        
        //List<String> phListSearch = new ArrayList<>(empPhoneListSearch.subList(0, 3));
        
        
        HashMap<String, SpySuspect> spySuspectMapSearch = new LinkedHashMap<>(s.getSpySuspectMap());

        System.out.println(spySuspectMapSearch.size());
        System.out.println(phListSearch);

        for (Map.Entry<String, SpySuspect> spySuspect : spySuspectMapSearch.entrySet()) {

            String strJob = spySuspect.getValue().getEmployee().getJobTitle().toLowerCase();
            String strPhone = spySuspect.getValue().getEmployee().getPhone().substring(0, 3);
            String strClub = spySuspect.getValue().getEmployee().getMemberOf().toLowerCase();
            String strAddress = spySuspect.getValue().getEmployee().getAddress().toLowerCase();
            
            System.out.println(strJob);
            System.out.println(strPhone);
            System.out.println(strClub);
            System.out.println(strAddress);

//            if (jobMatchesList.contains(strJob) && phoneMatchesList.contains(strPhone) && clubMatchesList.contains(strClub)) {
//                System.out.println("Spy Suspect found: " + spySuspect.getValue().getEmployee().getId());
//            }
            if (empJobListSearch.contains(strJob) && phListSearch.contains(strPhone) && empClubListSearch.contains(strClub)) {
                System.out.println("Spy Suspect found: " + spySuspect.getValue().getEmployee().getId());
            }

        }

        System.out.println("No Spy Suspect found: ");

    }

    @Override
    public void spySearchMatch(Build b, SpyDataStore s) {

        List<Spy> spyListSearch = new ArrayList<>();
        spyListSearch.addAll(s.getSpyList());
        List<String> jobMatchesAll = new ArrayList<>();
        List<String> clubMatchesAll = new ArrayList<>();
        List<String> societyMatchesAll = new ArrayList<>();
        List<String> phoneMatchesAll = new ArrayList<>();
        List<String> addressMatchesAll = new ArrayList<>();

        Map<String, Spy> spyHashMapSearch = new LinkedHashMap<>(s.getSpyHashMap());
        Spy[] spyArray = new Spy[s.getSpyList().size()];
        s.getSpyList().toArray(spyArray);
        //System.out.println(Arrays.toString(spyArray));

        int jobMatchNo = 0;
        int clubMatchNo = 0;
        int societyMatchNo =0;
        int phoneMatchNo = 0;
        int addressMatchNo = 0;
        int index = 0;

        for (Spy spy : spyListSearch) {
            
            String[] empMemberSplitFromList = spy.getEmployee().getMemberOf().split(",");
            
            for (int i = 1; i < spyArray.length; i++) {
                
                String[] empMemberSplitFromArray = spyArray[i].getEmployee().getMemberOf().split(",");

                if (spy.getEmployee().getJobTitle().equals(spyArray[i].getEmployee().getJobTitle())) {
                    spy.setJobMatchNum(spy.getJobMatchNum() + 1);
                    jobMatchesAll.add(spy.getEmployee().getJobTitle());

                }
                
                if (empMemberSplitFromArray[0].equals(empMemberSplitFromArray[0])) {
                    spy.setSocietyMatchNum(spy.getSocietyMatchNum() + 1);
                    societyMatchesAll.add(empMemberSplitFromList[0]);

                }
                
                if (empMemberSplitFromArray[1].equals(empMemberSplitFromArray[1])) {
                    spy.setClubMatchNum(spy.getClubMatchNum() + 1);
                    clubMatchesAll.add(empMemberSplitFromList[1]);

                }

                if ((spy.getEmployee().getPhone()).substring(0, 3).equals(spyArray[i].getEmployee().getPhone().substring(0, 3))) {
                    spy.setPhoneMatchNum(spy.getPhoneMatchNum() + 1);
                    phoneMatchesAll.add(spy.getEmployee().getPhone().substring(0, 3));

                }
                if ((spy.getEmployee().getAddress()).equals(spyArray[i].getEmployee().getAddress())) {
                    spy.setAddressMatchNum(spy.getAddressMatchNum() + 1);
                    addressMatchesAll.add(spy.getEmployee().getAddress());

                }

            }

        }

        for (Spy spy : spyListSearch) {
            jobMatchNo += spy.getJobMatchNum();
            phoneMatchNo += spy.getPhoneMatchNum();
            clubMatchNo += spy.getClubMatchNum();
            societyMatchNo += spy.getSocietyMatchNum();
            addressMatchNo += spy.getClubMatchNum();

            //System.out.println(spy);
            System.out.println("Spy " + spy.getEmployee().getId() + " Job Match No. " + spy.getJobMatchNum());
            System.out.println("Spy " + spy.getEmployee().getId() + " Phone Match No. " + spy.getPhoneMatchNum());
            System.out.println("Spy " + spy.getEmployee().getId() + " Club Match No. " + spy.getClubMatchNum());
            System.out.println("Spy " + spy.getEmployee().getId() + " Society Match No. " + spy.getSocietyMatchNum());
            System.out.println("Spy " + spy.getEmployee().getId() + " Address Match No. " + spy.getAddressMatchNum());
            System.out.println();
        }

        jobMatchesMap = checkDuplicates(jobMatchesAll);
        clubMatchesMap = checkDuplicates(clubMatchesAll);
        clubMatchesMap = checkDuplicates(societyMatchesAll);
        phoneMatchesMap = checkDuplicates(phoneMatchesAll);

        jobMatchesList = getKeysFromHashMap(jobMatchesMap, 4l);
        clubMatchesList = getKeysFromHashMap(clubMatchesMap, 1l);
        societyMatchesList = getKeysFromHashMap(societyMatchesMap, 1l);
        phoneMatchesList = getKeysFromHashMap(phoneMatchesMap, 64l);

        System.out.println("\nJob Matches " + jobMatchesList);
        System.out.println("Phone Matches  " + phoneMatchesList);
        System.out.println("Club Matches " + clubMatchesList);
        System.out.println("Address Matches " + addressMatchesList);
    }

    public Map<String, Long> checkDuplicates(List<String> a) {

        Map<String, Long> strCountMap = a.stream().collect(Collectors.groupingBy(e -> e.toString().toLowerCase(), Collectors.counting()));
        System.out.println(strCountMap);
        return strCountMap;
    }

    public List<String> getKeysFromHashMap(Map<String, Long> hm, Long l) {
        List<String> list = new ArrayList();
        Set<String> keys = hm.keySet();
        for (String key : keys) {
            if (hm.get(key).equals(l)) {
                list.add(key);
            }
        }
        return list;
    }

    public List<String> getJobMatches() {
        return jobMatchesList;
    }

    public void setJobMatches(List<String> jobMatches) {
        this.jobMatchesList = jobMatches;
    }

    public List<String> getClubMatches() {
        return clubMatchesList;
    }

    public void setClubMatches(ArrayList<String> clubMatches) {
        this.clubMatchesList = clubMatches;
    }

    public List<String> getPhoneMatches() {
        return phoneMatchesList;
    }

    public void setPhoneMatches(ArrayList<String> phoneMatches) {
        this.phoneMatchesList = phoneMatches;
    }

    public Map<String, Long> getJobMatchesMap() {
        return jobMatchesMap;
    }

    public void setJobMatchesMap(Map<String, Long> jobMatchesMap) {
        this.jobMatchesMap = jobMatchesMap;
    }

    public Map<String, Long> getClubMatchesMap() {
        return clubMatchesMap;
    }

    public void setClubMatchesMap(Map<String, Long> clubMatchesMap) {
        this.clubMatchesMap = clubMatchesMap;
    }

    public Map<String, Long> getPhoneMatchesMap() {
        return phoneMatchesMap;
    }

    public void setPhoneMatchesMap(Map<String, Long> phoneMatchesMap) {
        this.phoneMatchesMap = phoneMatchesMap;
    }

    public List<String> getJobMatchesList() {
        return jobMatchesList;
    }

    public void setJobMatchesList(List<String> jobMatchesList) {
        this.jobMatchesList = jobMatchesList;
    }

    public List<String> getClubMatchesList() {
        return clubMatchesList;
    }

    public void setClubMatchesList(List<String> clubMatchesList) {
        this.clubMatchesList = clubMatchesList;
    }

    public List<String> getPhoneMatchesList() {
        return phoneMatchesList;
    }

    public void setPhoneMatchesList(List<String> phoneMatchesList) {
        this.phoneMatchesList = phoneMatchesList;
    }

    public List<String> getAddressMatchesList() {
        return addressMatchesList;
    }

    public void setAddressMatchesList(List<String> addressMatchesList) {
        this.addressMatchesList = addressMatchesList;
    }

}
