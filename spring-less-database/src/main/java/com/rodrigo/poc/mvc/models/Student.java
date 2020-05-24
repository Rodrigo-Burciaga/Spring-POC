package com.rodrigo.poc.mvc.models;

import java.util.LinkedHashMap;

public class Student {

    private String firstName;
    private String lastName;
    private String country;
    private LinkedHashMap<String, String> countries;
    private LinkedHashMap<String, String> languages;
    private String[] operatingSystemsSelected;
    private LinkedHashMap<String, String> operatingSystems;
    private String language;

    public Student() {
        countries = new LinkedHashMap<>();
        countries.put("MEX", "México");
        countries.put("BRA", "Brasil");
        countries.put("FRA", "Francia");
        languages = new LinkedHashMap<>();
        languages.put("C#", "C#");
        languages.put("JAVA", "Java");
        languages.put("PYTHON", "Python");
        operatingSystems = new LinkedHashMap<>();
        operatingSystems.put("LINUX", "Linux");
        operatingSystems.put("WINDOWS", "Windows");
        operatingSystems.put("MAC", "MAC OS");
    }

    public LinkedHashMap<String, String> getOperatingSystems() {
        return operatingSystems;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LinkedHashMap<String, String> getCountries() {
        return countries;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public LinkedHashMap<String, String> getLanguages() {
        return languages;
    }

    public String[] getOperatingSystemsSelected() {
        return operatingSystemsSelected;
    }

    public void setOperatingSystemsSelected(String[] operatingSystemsSelected) {
        this.operatingSystemsSelected = operatingSystemsSelected;
    }
}
