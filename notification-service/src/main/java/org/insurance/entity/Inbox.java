package org.insurance.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "tbl_inbox")
public class Inbox extends PanacheEntity {

    private String action;
    private String message;
    private String policyNumber;
    private String customerName;
    private BigDecimal premiumAmount;

    public String getAction(){
        return action;
    }

    public void setAction(String action){
        this.action = action;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String getPolicyNumber(){
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber){
        this.policyNumber = policyNumber;
    }

    public String getCustomerName(){
        return customerName;
    }

    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }

    public BigDecimal getPremiumAmount(){
        return premiumAmount;
    }

    public void setPremiumAmount(BigDecimal premiumAmount){
        this.premiumAmount = premiumAmount;
    }
}
