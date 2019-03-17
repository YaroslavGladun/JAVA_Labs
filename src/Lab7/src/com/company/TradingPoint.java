package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class TradingPoint implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String address;
    private ArrayList<String> phoneNumbers;
    private String specialization;
    private ArrayList<String> workTime;

    public TradingPoint(String name) {
        this.name = name;
        this.address = "<UNKNOWN ADDRESS>";
        this.phoneNumbers = new ArrayList<>();
        this.specialization = "<UNKNOWN SPECIALIZATION>";
        this.workTime = new ArrayList<>(7);
        for (int i = 0; i < 7; i++) {
            this.workTime.add("<UNKNOWN TIME>");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void addPhoneNumber(String phoneNumber) {
        this.phoneNumbers.add(phoneNumber);
    }

    public void removePhoneNumber(String phoneNumber) {
        this.phoneNumbers.remove(phoneNumber);
    }

    public ArrayList<String> getPhoneNumbers() {
        ArrayList<String> phoneNumbers = (ArrayList<String>) this.phoneNumbers.clone();
        return phoneNumbers;
    }

    public void setWorkTimeInDay(int weekDayNumber, String workTime) {
        this.workTime.set(weekDayNumber, workTime);
    }

    public ArrayList<String> getWorkTime() {
        ArrayList<String> workTime = (ArrayList<String>) this.workTime.clone();
        return workTime;
    }
}
