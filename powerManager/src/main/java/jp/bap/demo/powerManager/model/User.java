package jp.bap.demo.powerManager.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_company")
    @JsonManagedReference
    private Company company;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_contact")
    @JsonManagedReference
    public Contact contact;

    @JsonBackReference
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Contract contracts;

    public User() {
    }

    public User(int id, String name, Company company, Contact contact, Contract contracts) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.contact = contact;
        this.contracts = contracts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Contract getContracts() {
        return contracts;
    }

    public void setContracts(Contract contracts) {
        this.contracts = contracts;
    }
}
