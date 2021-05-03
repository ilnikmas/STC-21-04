package ru.innopolis.ilnikmas.stc.lesson22.model;

public class Employee {
    private int employeeId;
    private String employeeName;
    private int identNumber;
    private String position;

    public Employee(int employeeId, String employeeName, int identNumber, String position) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.identNumber = identNumber;
        this.position = position;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getIdentNumber() {
        return identNumber;
    }

    public void setIdentNumber(int identNumber) {
        this.identNumber = identNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", identNumber=" + identNumber +
                ", position='" + position + '\'' +
                '}';
    }
}
