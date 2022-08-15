package com.example.service.impl;

import com.example.service.ICurrencyService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CurrencyService implements ICurrencyService {

    @Override
    public double convert(String usd) {
        double result = Double.parseDouble(usd) * 23000;
        return result;
    }

    public Map<String, String> validate(String usd) {
        Map<String, String> errorMap = new HashMap<>();

        if (!usd.isEmpty()) {
            try {
                if (Double.parseDouble(usd) < 0) {
                    errorMap.put("errUSD", "please input usd");
                }
            } catch (NumberFormatException e) {
                errorMap.put("errUSD", "please input right format");
            }
        } else {
            errorMap.put("errUSD", "please input usd");
        }
        return errorMap;
    }

}
