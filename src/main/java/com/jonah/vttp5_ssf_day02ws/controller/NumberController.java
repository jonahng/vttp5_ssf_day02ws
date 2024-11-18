package com.jonah.vttp5_ssf_day02ws.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jonah.vttp5_ssf_day02ws.service.NumberService;

@Controller
@RequestMapping("/numbers")
public class NumberController {

    @Autowired
    NumberService numberService;

    @GetMapping("")
    public String numberForm(){
        return "numberForm";
    }

    @PostMapping("")
    public String handleNumberForm(@RequestBody MultiValueMap<String, String> form, Model model){
        Map<String, String> numberFormData = new HashMap<>();
        for(String str: form.keySet()){
            numberFormData.put(str, form.getFirst(str));
            System.out.println("Form input:" + str + ":" + form.getFirst(str));
        }
        List<Integer> listOfGeneratedNumbers = numberService.generateRandomNumbers(numberFormData.get("inputNumber"));
        System.out.println("The number of random numbers generated is: " + numberFormData.get("inputNumber"));
        System.out.println("The list of random numbers generated is: " + listOfGeneratedNumbers);
        model.addAttribute("randomNumbers",listOfGeneratedNumbers);
        return "generatedNumbers";
    }

    
}
