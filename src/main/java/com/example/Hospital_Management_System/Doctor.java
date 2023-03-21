package com.example.Hospital_Management_System;

public class Doctor {

    private String name;

    private String specialization;

    private String degree;

    private int age;

    private int doctorId;

    public Doctor(String name, String specialization, String degree, int age, int doctorId) {
        this.name = name;
        this.specialization = specialization;
        this.degree = degree;
        this.age = age;
        this.doctorId = doctorId;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
