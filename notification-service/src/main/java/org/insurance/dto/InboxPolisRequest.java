package org.insurance.dto;

import java.math.BigDecimal;

public class InboxPolisRequest {

    private String type;
    private String policyNumber;
    private String customerName;
    private BigDecimal premium;

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
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

    public BigDecimal getPremium() {
        return premium;
    }

    public void setPremium(BigDecimal premium){
        this.premium = premium;
    }
}
