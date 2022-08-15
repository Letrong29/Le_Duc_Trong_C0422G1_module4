package com.example.service;

import java.util.Map;

public interface ICurrencyService {

    double convert(String usd);

    Map<String, String> validate(String usd);

}
