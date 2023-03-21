package com.example.Hospital_Management_System;

public class Nurse {

    private int nurseId;

    private String name;

    private int age;

    private String specialization;

    public Nurse(int nurseId, String name, int age, String specialization) {
        this.nurseId = nurseId;
        this.name = name;
        this.age = age;
        this.specialization = specialization;
    }

    public int getNurseId() {
        return nurseId;
    }

    public void setNurseId(int nurseId) {
        this.nurseId = nurseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
