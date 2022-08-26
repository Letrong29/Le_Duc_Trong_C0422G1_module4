package com.codegym.common;

import com.codegym.dto.UserDto;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;

public class DateTimeUtils {

    public static void checkAge(String age, Errors errors) {

        if (!age.isEmpty()){
            try {
                LocalDate dateOfBirth = LocalDate.parse(age);

                int checkAge = Period.between(dateOfBirth, LocalDate.now()).getYears();

                if (checkAge < 18){
                    errors.rejectValue("age",
                            "create.age",
                            "under 18 years old !");
                }
            }catch (DateTimeParseException e){
                errors.rejectValue("age",
                        "create.age",
                        "Wrong format !");
            }
        }else {
            errors.rejectValue("age",
                    "create.age",
                    "please enter !");
        }
    }
}
