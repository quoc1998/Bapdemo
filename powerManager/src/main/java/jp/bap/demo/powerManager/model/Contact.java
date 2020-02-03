package jp.bap.demo.powerManager.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "contact")
public class Contact {
    @Id
    @Column(name = "id")
    int id;
    @Column(name = "email")
    String email;
    @Column(name = "address1")
    String address1;
    @Column(name = "address2")
    String address2;
    @Column(name = "phone_number")
    String phoneNumber;
    @Column(name = "fax")
    String fax;
    @JsonBackReference
    @OneToOne(mappedBy = "contact", cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private Company companies;

    @JsonBackReference
    @OneToOne(mappedBy = "contact", cascade = CascadeType.ALL)
    private User users;
    @JsonBackReference
    @OneToOne(mappedBy = "contact", cascade = CascadeType.ALL)
    private Staff staff;

    public Contact() {
    }

    public Contact(int id, String email, String address1, String address2, String phoneNumber, String fax, Company companies, User users, Staff staff) {
        this.id = id;
        this.email = email;
        this.address1 = address1;
        this.address2 = address2;
        this.phoneNumber = phoneNumber;
        this.fax = fax;
        this.companies = companies;
        this.users = users;
        this.staff = staff;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public Company getCompanies() {
        return companies;
    }

    public void setCompanies(Company companies) {
        this.companies = companies;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }


}

