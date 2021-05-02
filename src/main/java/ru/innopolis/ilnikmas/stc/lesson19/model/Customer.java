package ru.innopolis.ilnikmas.stc.lesson19.model;

public class Customer {
    private int customerId;
    private String customerName;
    private String metaData;

    public Customer(int customerId, String customerName, String metaData) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.metaData = metaData;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getMetaData() {
        return metaData;
    }

    public void setMetaData(String metaData) {
        this.metaData = metaData;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", metaData='" + metaData + '\'' +
                '}';
    }
}
