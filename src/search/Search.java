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
 * @author PatWolohan patwolohan.org
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

    /**
     *
     */
    public Search() {

    }

    /**
     *
     * @param b
     */
    @Override
    public void listOfSpies(Build b) {
        b.printListOfSpies();
    }

    /**
     *
     * @param b
     */
    @Override
    public void spySequence(Build b) {
        b.printSpyFibIndex();

    }

    /**
     *
     * @param b
     * @param s
     */
    @Override
    public void spySuspectMatch(Build b, SpyDataStore s) {

        Map<String, String> empClubMapSearch = new LinkedHashMap<>(s.getEmpClub());
        Map<String, String> empSocietyMapSearch = new LinkedHashMap<>(s.getEmpClub());
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

        for (String str : empPhoneListSearch) {
            empPhoneListAbrSearch.add(str.substring(0, 3));
        }

        List<String> phListSearch = new ArrayList<>(empPhoneListAbrSearch.stream().distinct().collect(Collectors.toList()));

        //List<String> phListSearch = new ArrayList<>(empPhoneListSearch.subList(0, 3));
        HashMap<String, SpySuspect> spySuspectMapSearch = new LinkedHashMap<>(s.getSpySuspectMap());

        System.out.println(spySuspectMapSearch.size());
        System.out.println("Job List" + s.getJobList());
        System.out.println("Phone List" + phListSearch);
        System.out.println("Club List" + empClubListSearch);
        System.out.println("Society List" + empSocietyListSearch);
        

        for (Map.Entry<String, SpySuspect> spySuspect : spySuspectMapSearch.entrySet()) {
            String strJob = spySuspect.getValue().getEmployee().getJobTitle().toLowerCase();
            String strPhone = spySuspect.getValue().getEmployee().getPhone().substring(0, 3);
            String[] empMemberSplitFromListSuspect = spySuspect.getValue().getEmployee().getMemberOf().split(",");
            String strClub = empMemberSplitFromListSuspect[1];
            String strSociety = empMemberSplitFromListSuspect[0];
            String strAddress = spySuspect.getValue().getEmployee().getAddress().toLowerCase();

            //System.out.println(strJob);
            //System.out.println(strPhone);
            //System.out.println(strClub);
            //System.out.println(strSociety);
//            if (jobMatchesList.contains(strJob) && phoneMatchesList.contains(strPhone) && clubMatchesList.contains(strClub)) {
//                System.out.println("Spy Suspect found: " + spySuspect.getValue().getEmployee().getId());
//            }
            if (empJobListSearch.contains(strJob) && phListSearch.contains("087") && empClubListSearch.contains(" lamb club") && empSocietyListSearch.contains("jenkins society")) {
                System.out.println("Spy Suspect found: " + spySuspect.getValue().getEmployee().getId());
            }
            //System.out.println("Not a Spy Suspect: ");
        }

        //System.out.println("No Spy Suspect found: ");
    }

    /**
     *
     * @param b
     * @param s
     */
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
        int societyMatchNo = 0;
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

                if (empMemberSplitFromList[0].equals(empMemberSplitFromArray[0])) {
                    spy.setSocietyMatchNum(spy.getSocietyMatchNum() + 1);
                    societyMatchesAll.add(empMemberSplitFromList[0]);

                }

                if (empMemberSplitFromList[1].equals(empMemberSplitFromArray[1])) {
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
        societyMatchesMap = checkDuplicates(societyMatchesAll);
        phoneMatchesMap = checkDuplicates(phoneMatchesAll);

        jobMatchesList = getKeysFromHashMap(jobMatchesMap, 4l);
        clubMatchesList = getKeysFromHashMap(clubMatchesMap, 4l);
        societyMatchesList = getKeysFromHashMap(societyMatchesMap, 4l);
        phoneMatchesList = getKeysFromHashMap(phoneMatchesMap, 64l);

        System.out.println("\nJob Matches " + jobMatchesList);
        System.out.println("Phone Matches  " + phoneMatchesList);
        System.out.println("Club Matches " + clubMatchesList);
        System.out.println("Society Matches " + societyMatchesList);
        System.out.println("Address Matches " + addressMatchesList);
    }

    /**
     *
     * @param a
     * @return
     */
    public Map<String, Long> checkDuplicates(List<String> a) {

        Map<String, Long> strCountMap = a.stream().collect(Collectors.groupingBy(e -> e.toString().toLowerCase(), Collectors.counting()));
        System.out.println(strCountMap);
        return strCountMap;
    }

    /**
     *
     * @param hm
     * @param l
     * @return
     */
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

    /**
     *
     * @return
     */
    public List<String> getJobMatches() {
        return jobMatchesList;
    }

    /**
     *
     * @param jobMatches
     */
    public void setJobMatches(List<String> jobMatches) {
        this.jobMatchesList = jobMatches;
    }

    /**
     *
     * @return
     */
    public List<String> getClubMatches() {
        return clubMatchesList;
    }

    /**
     *
     * @param clubMatches
     */
    public void setClubMatches(ArrayList<String> clubMatches) {
        this.clubMatchesList = clubMatches;
    }

    /**
     *
     * @return
     */
    public List<String> getPhoneMatches() {
        return phoneMatchesList;
    }

    /**
     *
     * @param phoneMatches
     */
    public void setPhoneMatches(ArrayList<String> phoneMatches) {
        this.phoneMatchesList = phoneMatches;
    }

    /**
     *
     * @return
     */
    public Map<String, Long> getJobMatchesMap() {
        return jobMatchesMap;
    }

    /**
     *
     * @param jobMatchesMap
     */
    public void setJobMatchesMap(Map<String, Long> jobMatchesMap) {
        this.jobMatchesMap = jobMatchesMap;
    }

    /**
     *
     * @return
     */
    public Map<String, Long> getClubMatchesMap() {
        return clubMatchesMap;
    }

    /**
     *
     * @param clubMatchesMap
     */
    public void setClubMatchesMap(Map<String, Long> clubMatchesMap) {
        this.clubMatchesMap = clubMatchesMap;
    }

    /**
     *
     * @return
     */
    public Map<String, Long> getPhoneMatchesMap() {
        return phoneMatchesMap;
    }

    /**
     *
     * @param phoneMatchesMap
     */
    public void setPhoneMatchesMap(Map<String, Long> phoneMatchesMap) {
        this.phoneMatchesMap = phoneMatchesMap;
    }

    /**
     *
     * @return
     */
    public List<String> getJobMatchesList() {
        return jobMatchesList;
    }

    /**
     *
     * @param jobMatchesList
     */
    public void setJobMatchesList(List<String> jobMatchesList) {
        this.jobMatchesList = jobMatchesList;
    }

    /**
     *
     * @return
     */
    public List<String> getClubMatchesList() {
        return clubMatchesList;
    }

    /**
     *
     * @param clubMatchesList
     */
    public void setClubMatchesList(List<String> clubMatchesList) {
        this.clubMatchesList = clubMatchesList;
    }

    /**
     *
     * @return
     */
    public List<String> getPhoneMatchesList() {
        return phoneMatchesList;
    }

    /**
     *
     * @param phoneMatchesList
     */
    public void setPhoneMatchesList(List<String> phoneMatchesList) {
        this.phoneMatchesList = phoneMatchesList;
    }

    /**
     *
     * @return
     */
    public List<String> getAddressMatchesList() {
        return addressMatchesList;
    }

    /**
     *
     * @param addressMatchesList
     */
    public void setAddressMatchesList(List<String> addressMatchesList) {
        this.addressMatchesList = addressMatchesList;
    }

}
