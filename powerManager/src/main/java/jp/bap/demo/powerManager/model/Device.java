package jp.bap.demo.powerManager.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "device")
public class Device {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "code")
    private   String code;
    @Column(name = "name")
    private   String name;
    //    @Column(name = "id_company")
//    private int idCompany;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_company")
    @JsonManagedReference
    private Company company;

    public Device() {
    }

    public Device(int id, String code, String name, Company company) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
}
