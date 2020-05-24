package com.rodrigo.poc.mvc.models;

import com.rodrigo.poc.mvc.annotations.CourseCode;

import javax.validation.constraints.*;

public class Customer {

    private String firstName;

    @NotNull(message = "Not null")
    @Size(min = 2, message = "is required")
    private String lastName;

    @NotNull(message = "Not null")
    @Min(value = 0, message = "The min value is 0")
    @Max(value = 8, message = "The max value is 8")
    private Integer freePasses;

    @NotNull(message = "Not null")
    @Size(min = 2, message = "is required")
    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 char/digits")
    private String postalCode;

    @CourseCode
    private String courseCode;

    public Customer() {

    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
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
}
