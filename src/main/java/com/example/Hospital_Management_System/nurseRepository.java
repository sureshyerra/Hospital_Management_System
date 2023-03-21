package com.example.Hospital_Management_System;


import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class nurseRepository {

    HashMap<Integer,Nurse> nurseHashMap = new HashMap<>();

    public String addNurse(Nurse nurse){

        int key = nurse.getNurseId();

        nurseHashMap.put(key,nurse);

        return "nurse added successfully";

    }
    public List<Nurse> getAllNurses(){

        return nurseHashMap.values().stream().toList();
    }
}
