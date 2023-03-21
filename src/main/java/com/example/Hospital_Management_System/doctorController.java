package com.example.Hospital_Management_System;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
@RestController
@RequestMapping("/doctor")
public class doctorController {

    HashMap<Integer,Doctor> doctorHashMap = new HashMap<>();
    @PostMapping("/addDoctor")

    public String addDoctor(@RequestBody Doctor doctor){

        int doctorId = doctor.getDoctorId();

        doctorHashMap.put(doctorId,doctor);

        return "doctor added succesfully";

    }
}
