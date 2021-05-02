package ru.innopolis.ilnikmas.stc.lesson19.model;

import java.util.Date;

public class Order {
    private int orderId;
    private int customerId;
    private int productId;
    private int employeeId;
    private Date orderDate;

    public Order(int orderId, int customerId, int productId, int employeeId, Date orderDate) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.productId = productId;
        this.employeeId = employeeId;
        this.orderDate = orderDate;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerId=" + customerId +
                ", productId=" + productId +
                ", employeeId=" + employeeId +
                ", orderDate=" + orderDate +
                '}';
    }
}
