package com.example.Hospital_Management_System;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service


public class nurseService {
    nurseRepository nurseRepository = new nurseRepository();

    public String addNurse(Nurse nurse){

        // validations

        if (nurse.getNurseId() < 0){
            return "enter a valid nurseId";
        }


        String ans = nurseRepository.addNurse(nurse);

        return ans;
    }

    public List<Nurse> getList(int age){

        List<Nurse> nurses = nurseRepository.getAllNurses();

        List<Nurse> finalList = new ArrayList<>();

        for (Nurse nurse : nurses){
            if (nurse.getAge()>age){
                finalList.add(nurse);
            }
        }
        return finalList;

    }

    public  List<Nurse> getBySpecialization(String specialization){

        List<Nurse> nurses = nurseRepository.getAllNurses();

        List<Nurse> finalList = new ArrayList<>();

        for (Nurse nurse : nurses){
            if (nurse.getSpecialization().equals(specialization)){
                finalList.add(nurse);
            }
        }
        return finalList;
    }
}
