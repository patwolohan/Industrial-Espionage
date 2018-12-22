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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMemberOf() {
        return memberOf;
    }

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
