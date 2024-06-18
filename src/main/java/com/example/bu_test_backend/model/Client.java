package com.example.bu_test_backend.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @Column(name = "client_id", length = 12, nullable = false)
    private String clientId;

    @Column(name = "client_name", length = 20, nullable = false)
    private String clientName;

    @Column(name = "client_first_lastname", length = 20, nullable = false)
    private String clientFirstLastname;

    @Column(name = "client_second_lastname", length = 20, nullable = false)
    private String clientSecondLastname;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doc_id", nullable = false)
    private Doc doc;    //type of document

    @Column(name = "birth_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate birthDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "gender_id", nullable = false)
    private Gender gender;

    public Client(){}

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

    public Doc getDoc() {
        return doc;
    }

    public void setDoc(Doc doc) {
        this.doc = doc;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Client [clientId=" + clientId + ", clientName=" + clientName + ", clientFirstLastname="
                + clientFirstLastname + ", clientSecondLastname=" + clientSecondLastname + ", doc=" + doc
                + ", birthDate=" + birthDate + ", gender=" + gender + "]";
    }

    

    
}
