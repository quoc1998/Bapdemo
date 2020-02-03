package jp.bap.demo.powerManager.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "contract")
public class Contract {
    @Id
    @Column(name = "id")
    private   int id;
    @Temporal(TemporalType.DATE)
    @Column(name = "end_date")
    private Date endDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    private Date srartDate;
    @Column(name = "contract_type")
    private int contractType;
    //    @Column(name = "id_user")
//    private int idUser;
//    @Column(name = "id_staff")
//    private int idStaff;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user")
    private User user;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_staff")
    private Staff staff;

    public Contract() {
    }

    public Contract(int id, Date endDate, Date srartDate, int contractType, User user, Staff staff) {
        this.id = id;
        this.endDate = endDate;
        this.srartDate = srartDate;
        this.contractType = contractType;
        this.user = user;
        this.staff = staff;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getSrartDate() {
        return srartDate;
    }

    public void setSrartDate(Date srartDate) {
        this.srartDate = srartDate;
    }

    public int getContractType() {
        return contractType;
    }

    public void setContractType(int contractType) {
        this.contractType = contractType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }
}
