package com.example.bu_test_backend.dto;

import java.time.LocalDate;

public class ClientDto {
    // private Integer clientId;
    // private String clientName;
    // private String clientFirstLastname;
    // private String clientSecondLastname;
    // private Integer docId;
    // private String doc;
    // private LocalDate birthDate;
    // private Integer genderId;

    private String clientId;
    private String clientName;
    private String clientFirstLastname;
    private String clientSecondLastname;
    private Integer docId;
    private String docName;
    private LocalDate birthDate;
    private Integer genderId;
    private String genderName;

    // Default constructor
    public ClientDto() {
    }

    // Parameterized constructor
    public ClientDto(String clientId, String clientName, String clientFirstLastname, String clientSecondLastname,
            Integer docId, String docName, LocalDate birthDate, Integer genderId, String genderName) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.clientFirstLastname = clientFirstLastname;
        this.clientSecondLastname = clientSecondLastname;
        this.docId = docId;
        this.docName = docName;
        this.birthDate = birthDate;
        this.genderId=genderId;
        this.genderName = genderName;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientFirstLastname() {
        return clientFirstLastname;
    }

    public void setClientFirstLastname(String clientFirstLastname) {
        this.clientFirstLastname = clientFirstLastname;
    }

    public String getClientSecondLastname() {
        return clientSecondLastname;
    }

    public void setClientSecondLastname(String clientSecondLastname) {
        this.clientSecondLastname = clientSecondLastname;
    }

    public Integer getDocId() {
        return docId;
    }

    public void setDocId(Integer docId) {
        this.docId = docId;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

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
        return "ClientDto [clientId=" + clientId + ", clientName=" + clientName + ", clientFirstLastname="
                + clientFirstLastname + ", clientSecondLastname=" + clientSecondLastname + ", docId=" + docId
                + ", docName=" + docName + ", birthDate=" + birthDate + ", genderId=" + genderId + ", genderName="
                + genderName + "]";
    }

    

    
    
}