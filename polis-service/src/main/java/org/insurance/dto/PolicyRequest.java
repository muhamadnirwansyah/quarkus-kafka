package org.insurance.dto;

import java.math.BigDecimal;

public class PolicyRequest {

    public String customerName;
    public String productName;
    public BigDecimal premium;

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
