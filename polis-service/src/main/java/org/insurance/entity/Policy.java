package org.insurance.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "tbl_polis")
public class Policy extends PanacheEntity {

    public String policyNumber;
    public String customerName;
    public String productName;
    public BigDecimal premium;

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

    public String getProductName(){
        return productName;
    }

    public void setProductName(String productName){
        this.productName = productName;
    }

    public BigDecimal getPremium(){
        return premium;
    }

    public void setPremium(BigDecimal premium){
        this.premium = premium;
    }
}
