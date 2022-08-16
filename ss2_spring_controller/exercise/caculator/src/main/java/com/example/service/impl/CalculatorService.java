package com.example.service.impl;

import com.example.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {

    @Override
    public double calculator(Double num1, Double num2, String operator) {

        switch (operator) {
            case "Addition(+)":
                return num1 + num2;
            case "Subtraction(-)":
                return num1 - num2;
            case "Multiplication(X)":
                return num1 * num2;
            case "Division(/)":
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    throw new ArithmeticException();
                }
            default:
                return 0;
        }
    }
}
