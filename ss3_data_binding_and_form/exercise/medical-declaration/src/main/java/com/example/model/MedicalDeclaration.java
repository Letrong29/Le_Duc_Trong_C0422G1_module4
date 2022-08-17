package com.example.model;

public class MedicalDeclaration {

    private int id;

    private String name;

    private int yearOfBirth;

    private String gender;

    private String nationality;

    private String idCard;

    private String vehicles;

    private String licensePlates;

    private String seats;

    private int startYears;

    private int startMonths;

    private int startDays;

    private int endYears;

    private int endMonths;

    private int endDays;

    private String thePastFourteenDays;

    public MedicalDeclaration() {
    }

    public MedicalDeclaration(int id, String name, int yearOfBirth, String gender, String nationality, String idCard, String vehicles, String licensePlates, String seats, int startYears, int startMonths, int startDays, int endYears, int endMonths, int endDays, String thePastFourteenDays) {
        this.id = id;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
        this.nationality = nationality;
        this.idCard = idCard;
        this.vehicles = vehicles;
        this.licensePlates = licensePlates;
        this.seats = seats;
        this.startYears = startYears;
        this.startMonths = startMonths;
        this.startDays = startDays;
        this.endYears = endYears;
        this.endMonths = endMonths;
        this.endDays = endDays;
        this.thePastFourteenDays = thePastFourteenDays;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getVehicles() {
        return vehicles;
    }

    public void setVehicles(String vehicles) {
        this.vehicles = vehicles;
    }

    public String getLicensePlates() {
        return licensePlates;
    }

    public void setLicensePlates(String licensePlates) {
        this.licensePlates = licensePlates;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public int getStartYears() {
        return startYears;
    }

    public void setStartYears(int startYears) {
        this.startYears = startYears;
    }

    public int getStartMonths() {
        return startMonths;
    }

    public void setStartMonths(int startMonths) {
        this.startMonths = startMonths;
    }

    public int getStartDays() {
        return startDays;
    }

    public void setStartDays(int startDays) {
        this.startDays = startDays;
    }

    public int getEndYears() {
        return endYears;
    }

    public void setEndYears(int endYears) {
        this.endYears = endYears;
    }

    public int getEndMonths() {
        return endMonths;
    }

    public void setEndMonths(int endMonths) {
        this.endMonths = endMonths;
    }

    public int getEndDays() {
        return endDays;
    }

    public void setEndDays(int endDays) {
        this.endDays = endDays;
    }

    public String getThePastFourteenDays() {
        return thePastFourteenDays;
    }

    public void setThePastFourteenDays(String thePastFourteenDays) {
        this.thePastFourteenDays = thePastFourteenDays;
    }
}
