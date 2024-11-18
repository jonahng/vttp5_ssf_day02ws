package com.jonah.vttp5_ssf_day02ws.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.lang.*;

import org.springframework.stereotype.Service;

@Service
public class NumberService {


    public List<Integer> generateRandomNumbers(String countOfNumbers){
        List<Integer> listOfRandomNumbers = new ArrayList<>();
        Random random = new Random();
        for(int i=0; i<Integer.parseInt(countOfNumbers); i++){
            listOfRandomNumbers.add(random.nextInt(10));
        }
        return listOfRandomNumbers;


    }
    
}
