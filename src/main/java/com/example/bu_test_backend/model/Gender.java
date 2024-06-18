package com.example.bu_test_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "gender")
public class Gender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gender_id")
    private Integer genderId;

    @Column(name = "gender_name", length = 12, nullable = false)
    private String genderName;

    public Gender() {}

    public Integer getGenderId() {
        return genderId;
    }
    public void setGenderId(Integer genderId) {
        this.genderId = genderId;
    }
    public String getGenderName() {
        return genderName;
    }
    public void setGenderName(String genderName) {
        this.genderName = genderName;
    }
    
    @Override
    public String toString() {
        return "Gender [genderId=" + genderId + ", genderName=" + genderName + "]";
    }

    
}
