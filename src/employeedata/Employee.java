/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeedata;

import java.io.Serializable;

/**
 *
 * @author VilkaS
 */
public class Employee implements Serializable {

    private String name;
    private String address;
    private String phone;
    private String jobTitle;
    private String id;
    private String memberOf;

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * @return
     */
    public String getPhone() {
        return phone;
    }

    /**
     *
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     *
     * @return
     */
    public String getJobTitle() {
        return jobTitle;
    }

    /**
     *
     * @param jobTitle
     */
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    /**
     *
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getMemberOf() {
        return memberOf;
    }

    /**
     *
     * @param memberOf
     */
    public void setMemberOf(String memberOf) {
        this.memberOf = memberOf;
    }

    @Override
    public String toString() {
        return "Employee : \n" + " Name : " + name
                + "\n Address : " + address + "\n Phone : " + phone
                + "\n job : " + jobTitle + "\n id : " + id
                + "\n Member of : " + memberOf + "\n";
    }

}
