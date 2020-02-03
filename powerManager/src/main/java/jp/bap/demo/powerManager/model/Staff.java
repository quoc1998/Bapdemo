package jp.bap.demo.powerManager.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "staff")
public class Staff {
    @Id
    @Column(name = "id")
    private int id;

    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    private Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "end_date")
    private Date endDate;
    //    @Column(name = "id_contact")
//    private int idContact;
//    @Column(name = "id_company")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_company")
    @JsonManagedReference
    private Company company;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_contact")
    @JsonManagedReference
    private Contact contact;
    @OneToOne(mappedBy = "staff", cascade = CascadeType.ALL)
    @JsonBackReference
    private Contract contract;
    public Staff() {
    }

    public Staff(int id, Date startDate, Date endDate, Company company, Contact contact, Contract contract) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.company = company;
        this.contact = contact;
        this.contract = contract;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}
