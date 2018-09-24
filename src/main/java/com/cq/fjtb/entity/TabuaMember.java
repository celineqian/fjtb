package com.cq.fjtb.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @author: Celine Q
 * @create: 2018-09-16 14:54
 **/
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

    @Column(nullable = false)
    private Integer isValid;

    private String email;

    private String expiryDate;

    private String applyDate;

    private String statusCredit;

    private String upgradeCredit;

    private String lastActivityDate;

    private String lastUpdateDate;

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

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate;
    }

    public String getStatusCredit() {
        return statusCredit;
    }

    public void setStatusCredit(String statusCredit) {
        this.statusCredit = statusCredit;
    }

    public String getUpgradeCredit() {
        return upgradeCredit;
    }

    public void setUpgradeCredit(String upgradeCredit) {
        this.upgradeCredit = upgradeCredit;
    }

    public String getLastActivityDate() {
        return lastActivityDate;
    }

    public void setLastActivityDate(String lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }

    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
}
