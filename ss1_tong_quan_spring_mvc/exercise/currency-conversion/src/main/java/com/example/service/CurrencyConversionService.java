package com.example.service;

import java.util.HashMap;
import java.util.Map;

public class CurrencyConversionService {

    public Map<String, String> validate(String usd){
        Map<String, String> errorMap = new HashMap<>();

        if (!usd.isEmpty()){
            try {
                if (Double.parseDouble(usd) < 0){
                    errorMap.put("errUSD", "please input usd");
                }
            }catch (NumberFormatException e){
                errorMap.put("errUSD","please input right format");
            }
        }else {
            errorMap.put("errUSD","please input usd");
        }
        return errorMap;
    }

}
