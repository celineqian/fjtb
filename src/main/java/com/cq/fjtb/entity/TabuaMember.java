package com.cq.fjtb.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="t_tabuamember")
public class TabuaMember {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String cardNumber;

    @Column(nullable = false)
    private String password;

    private String email;

    private Date expiryDate;

    private Date applyDate;

    private Integer statusCredit;

    private Integer upgradeCredit;

    @Column(nullable = false)
    private Integer isValid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public Integer getStatusCredit() {
        return statusCredit;
    }

    public void setStatusCredit(Integer statusCredit) {
        this.statusCredit = statusCredit;
    }

    public Integer getUpgradeCredit() {
        return upgradeCredit;
    }

    public void setUpgradeCredit(Integer upgradeCredit) {
        this.upgradeCredit = upgradeCredit;
    }

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }
}
