package com.codegym.common.facility;

import com.codegym.dto.facility.FacilityDto;
import org.springframework.validation.Errors;

public class FacilityValidate {

    public static void checkName(FacilityDto facilityDto, Errors errors) {

        if (!facilityDto.getName().isEmpty()){
            if (!facilityDto.getName().matches("^([A-Z0-9])[a-z0-9]+((\\s[A-Z0-9])[a-z0-9]+)+$")){
                errors.rejectValue("name",
                        "create.name",
                        "Do not contain special characters, capitalize the first letter !");
            }
        }else {
            errors.rejectValue("name",
                    "create.name",
                    "Please enter !");
        }
    }

    public static void checkArea(FacilityDto facilityDto, Errors errors) {

        if (!facilityDto.getArea().isEmpty()){
            try {
                int area = Integer.parseInt(facilityDto.getArea());

                if (area <= 0){
                    errors.rejectValue("area",
                            "create.area",
                            "Please enter a positive number !");
                }
            }catch (Exception e){
                errors.rejectValue("area",
                        "create.area",
                        "Please enter a number !");
            }

        }else {
            errors.rejectValue("area",
                    "create.area",
                    "Please enter !");
        }
    }

    public static void checkCost(FacilityDto facilityDto, Errors errors) {

        if (!facilityDto.getCost().isEmpty()){
            try {
                double cost = Double.parseDouble(facilityDto.getCost());

                if (cost <= 0){
                    errors.rejectValue("cost",
                            "create.cost",
                            "Please enter a positive number !");
                }
            }catch (Exception e){
                errors.rejectValue("cost",
                        "create.cost",
                        "Please enter a number !");
            }

        }else {
            errors.rejectValue("cost",
                    "create.cost",
                    "Please enter !");
        }
    }

    public static void checkMaxPeople(FacilityDto facilityDto, Errors errors) {
        if (!facilityDto.getMaxPeople().isEmpty()){
            try {
                int maxPeople = Integer.parseInt(facilityDto.getMaxPeople());

                if (maxPeople <= 0){
                    errors.rejectValue("maxPeople",
                            "create.maxPeople",
                            "Please enter a positive number !");
                }
            }catch (Exception e){
                errors.rejectValue("maxPeople",
                        "create.maxPeople",
                        "Please enter a number !");
            }

        }else {
            errors.rejectValue("maxPeople",
                    "create.maxPeople",
                    "Please enter !");
        }
    }

    public static void checkPoolArea(FacilityDto facilityDto, Errors errors) {
        if (!facilityDto.getPoolArea().isEmpty()){
            try {
                double poolArea = Double.parseDouble(facilityDto.getPoolArea());

                if (poolArea <= 0){
                    errors.rejectValue("poolArea ",
                            "create.poolArea",
                            "Please enter a positive number !");
                }
            }catch (Exception e){
                errors.rejectValue("poolArea",
                        "create.poolArea",
                        "Please enter a positive number !");
            }
        }else {
            facilityDto.setPoolArea("0");
        }
    }

    public static void checkFloors(FacilityDto facilityDto, Errors errors) {
        if (!facilityDto.getFloors().isEmpty()){
            try {
                int floors = Integer.parseInt(facilityDto.getFloors());

                if (floors <= 0){
                    errors.rejectValue("floors ",
                            "create.floors",
                            "Please enter a positive number !");
                }
            }catch (Exception e){
                errors.rejectValue("floors",
                        "create.floors",
                        "Please enter a positive number !");
            }
        }else {
            facilityDto.setFloors("0");
        }
    }
}
