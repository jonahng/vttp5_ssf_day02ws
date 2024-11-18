package com.jonah.vttp5_ssf_day02ws.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/numbers")
public class NumberController {

    @GetMapping("")
    public String numberForm(){
        return "numberForm";
    }

    @PostMapping("")
    public String handleNumberForm(@RequestBody MultiValueMap<String, String> form){
        Map<String, String> numberFormData = new HashMap<>();
        for(String str: form.keySet()){
            numberFormData.put(str, form.getFirst(str));
            System.out.println("Form input:" + str + ":" + form.getFirst(str));
        }
        return "numberForm";
    }

    
}
