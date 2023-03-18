package com.example.Hospital_Management_System;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class patientController {

    HashMap<Integer, Patient> hashMap = new HashMap<>();
    @PostMapping("/addPatientViaParameters")

    public String addPatient(@RequestParam("patientId")Integer patientId,@RequestParam("name") String name,@RequestParam("disease")String disease,@RequestParam("age")Integer age){

        Patient patient = new Patient(patientId,name,disease,age);

        hashMap.put(patientId,patient);

        return "patient added succesfully";
    }

    @PostMapping("/addPatientViaRequestBody")

    public String addPatient(@RequestBody Patient patient){

        int key = patient.getPatientId();

        hashMap.put(key,patient);

        return "patient added succesfully";



    }
    @GetMapping("/getPatientInfo")

    public Patient getPatientInfo(@RequestParam("patientId")Integer patienId){

        Patient patient = hashMap.get(patienId);

        return patient;
    }
    @GetMapping("/getAllPatients")

    public List<Patient> patients(){

        List<Patient> patients = new ArrayList<>();

        for(Patient p : hashMap.values()){
            patients.add(p);
        }
        return patients;
    }
    @GetMapping("/getPatientByName")

    public Patient getPatientByName(@RequestParam("name")String name){

        for(Patient p : hashMap.values()){
            if(p.getName().equals(name)){
                return p;
            }
        }
        return null;
    }
    @GetMapping("/getPatientsListGreaterThanAge")

    public List<Patient> getPatientsListGreaterThanAge(@RequestParam("age")Integer age){
        List<Patient> getpatients = new ArrayList<>();
        for (Patient p : hashMap.values()){
            if (p.getAge() > age){
                getpatients.add(p);
            }
        }
        return getpatients;
    }


}
