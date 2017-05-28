package com.example.web.kafkademo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

/**
 * Created by alokkulkarni on 26/05/17.
 */
public class MsgSchema {


    private String id;
    private String vendorName;
    private String location;
    private String currency;
    private String amount;
    private String transTime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTransTime() {
        return transTime;
    }

    public void setTransTime(String transTime) {
        this.transTime = transTime;
    }

    @Override
    public String toString() {
        return "MsgSchema{" +
                "id='" + id + '\'' +
                ", vendorName='" + vendorName + '\'' +
                ", location='" + location + '\'' +
                ", currency='" + currency + '\'' +
                ", amount='" + amount + '\'' +
                ", transTime=" + transTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MsgSchema msgSchema = (MsgSchema) o;

        if (id != null ? !id.equals(msgSchema.id) : msgSchema.id != null) return false;
        if (vendorName != null ? !vendorName.equals(msgSchema.vendorName) : msgSchema.vendorName != null) return false;
        if (location != null ? !location.equals(msgSchema.location) : msgSchema.location != null) return false;
        if (currency != null ? !currency.equals(msgSchema.currency) : msgSchema.currency != null) return false;
        if (amount != null ? !amount.equals(msgSchema.amount) : msgSchema.amount != null) return false;
        return transTime != null ? transTime.equals(msgSchema.transTime) : msgSchema.transTime == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (vendorName != null ? vendorName.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (transTime != null ? transTime.hashCode() : 0);
        return result;
    }
}
