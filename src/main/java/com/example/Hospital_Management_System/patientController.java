package com.example.Hospital_Management_System;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/patient")
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
    @GetMapping("/getInfoViaPathVariable/{patientId}")
    public Patient getPatient(@PathVariable("patientId")Integer patientId){

        Patient patient = hashMap.get(patientId);

        return patient;

    }
    @GetMapping("/getPatients/{age}/{disease}")

    public  List<Patient> getPatients(@PathVariable("age")Integer age,@PathVariable("disease")String disease){

        List<Patient> patients = new ArrayList<>();

        for (Patient p : hashMap.values()){
            if(p.getAge() > age && p.getDisease().equals(disease)){
                patients.add(p);
            }
        }
        return patients;

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
    @PutMapping("/updatePatientDetails")
    public String updatePatientDetails(@RequestBody Patient patient){

        int key = patient.getPatientId();

        if (hashMap.containsKey(key)){
            hashMap.put(key,patient);
            return "patient updated successfully";
        }
        else {
            return "data not existing";
        }
    }
    @PutMapping("/updatedisease")
    public String updatedisease(@RequestParam("patientId")Integer patientId,@RequestParam("disease")String disease)
    {
        if(hashMap.containsKey(patientId)){
            Patient patient  = hashMap.get(patientId);
            patient.setDisease(disease);

            hashMap.put(patientId,patient);
            return "updated succesfully";
        }
        return "patient doesnot exist";

    }
    @DeleteMapping("/deletePatient")

    public String deletePatient(@RequestParam("patientId")Integer patientId){

        hashMap.remove(patientId);
        return "patient deleted succcesfully";

    }


}
