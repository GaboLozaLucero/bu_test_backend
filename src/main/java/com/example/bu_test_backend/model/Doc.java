package com.example.bu_test_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "doc")
public class Doc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doc_id")
    private Integer docId;  //show the id of the document in this table, not user's

    @Column(name = "doc_name", nullable = false, length = 40)
    private String doc_name;

    public Doc() {}

    public Integer getDocId() {
        return docId;
    }

    public void setDocId(Integer docId) {
        this.docId = docId;
    }

    public String getDoc_name() {
        return doc_name;
    }

    public void setDoc_name(String doc_name) {
        this.doc_name = doc_name;
    }

    @Override
    public String toString() {
        return "Doc [docId=" + docId + ", doc_name=" + doc_name + "]";
    }
    
}
