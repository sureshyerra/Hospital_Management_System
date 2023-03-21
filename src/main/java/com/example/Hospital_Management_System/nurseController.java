package com.example.Hospital_Management_System;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nurse")
public class nurseController {
    nurseService nurseService = new nurseService();

    @PostMapping("/add")



    public String addNurse(@RequestBody Nurse nurse){

        String ans = nurseService.addNurse(nurse);
        return ans;

    }
    @GetMapping("/getByAge")
    public List<Nurse> getNursesGreaterthanAge(@RequestParam("age")Integer age){

        List<Nurse>nurseList = nurseService.getList(age);

        return nurseList;
    }
    @GetMapping("/getByQualification")

    public List<Nurse> getNursesByQualification(@RequestParam("specialization") String specialization){


        List<Nurse> nurses = nurseService.getBySpecialization(specialization);
        return nurses;
    }
}
