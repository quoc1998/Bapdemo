package jp.bap.demo.powerManager.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @Column(name = "id")
    private int idCompany;
    @Column(name = "name")
    private String name;
    //    @Column(name = "id_contact")
//    private int idContact;
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<User> users;
    @OneToMany(mappedBy = "company",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Staff>staff;

    @OneToMany(mappedBy = "company",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Device>devices;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_contact")
    @JsonManagedReference
    private Contact contact;



    public Company() {
    }

    public Company(int idCompany, String name, List<User> users, List<Staff> staff, List<Device> devices, Contact contact) {
        this.idCompany = idCompany;
        this.name = name;
        this.users = users;
        this.staff = staff;
        this.devices = devices;
        this.contact = contact;
    }

    public int getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(int idCompany) {
        this.idCompany = idCompany;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Staff> getStaff() {
        return staff;
    }

    public void setStaff(List<Staff> staff) {
        this.staff = staff;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}

