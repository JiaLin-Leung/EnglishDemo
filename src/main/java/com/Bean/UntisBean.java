package com.Bean;

import java.io.Serializable;

public class UntisBean implements Serializable {

    private String city;
    private String name;
    private String class_id;
    private String unit_class_id;
    private String school_name;
    private String grade_id;
    private String county;
    private String id;
    private String type;
    private String school_id;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public String getUnit_class_id() {
        return unit_class_id;
    }

    public void setUnit_class_id(String unit_class_id) {
        this.unit_class_id = unit_class_id;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public String getGrade_id() {
        return grade_id;
    }

    public void setGrade_id(String grade_id) {
        this.grade_id = grade_id;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSchool_id() {
        return school_id;
    }

    public void setSchool_id(String school_id) {
        this.school_id = school_id;
    }

    @Override
    public String toString() {
        return "UntisBean{" +
                "city='" + city + '\'' +
                ", name='" + name + '\'' +
                ", class_id='" + class_id + '\'' +
                ", unit_class_id='" + unit_class_id + '\'' +
                ", school_name='" + school_name + '\'' +
                ", grade_id='" + grade_id + '\'' +
                ", county='" + county + '\'' +
                ", id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", school_id='" + school_id + '\'' +
                '}';
    }
}
