package com.codegym.common.employee;

import com.codegym.dto.employee.EmployeeDto;
import org.springframework.validation.Errors;

public class EmployeeValidate {

    public static void checkName(EmployeeDto employeeDto, Errors errors) {
        if (!employeeDto.getName().isEmpty()){
            if (!employeeDto.getName().matches("^([A-VXYỲỌÁẦẢẤỜỄÀẠẰỆẾÝỘẬỐŨỨĨÕÚỮỊỖÌỀỂẨỚẶÒÙỒỢÃỤỦÍỸẮẪỰỈỎỪỶỞÓÉỬỴẲẸÈẼỔẴẺỠƠÔƯĂÊÂĐ]{1})([a-vxyỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâđ]+)((\\s{1}([A-VXYỲỌÁẦẢẤỜỄÀẠẰỆẾÝỘẬỐŨỨĨÕÚỮỊỖÌỀỂẨỚẶÒÙỒỢÃỤỦÍỸẮẪỰỈỎỪỶỞÓÉỬỴẲẸÈẼỔẴẺỠƠÔƯĂÊÂĐ]{1})[a-vxyỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâđ]+))+$")){
                errors.rejectValue("name",
                        "create.name",
                        "Do not contain special characters and numbers, capitalize the first letter !");
            }
        }else {
            errors.rejectValue("name",
                    "create.name",
                    "Please enter !");
        }
    }
}
