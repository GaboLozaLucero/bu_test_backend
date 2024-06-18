package com.example.bu_test_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "branch")
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "branch_id")
    private Integer branchId;

    @Column(name = "branch_name", length = 15, nullable = false)
    private String branchName;

    public Branch() {}
    
    public Integer getBranchId() {
        return branchId;
    }
    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }
    public String getBranchName() {
        return branchName;
    }
    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }
    
    @Override
    public String toString() {
        return "Branch [branchId=" + branchId + ", branchName=" + branchName + "]";
    }

    
}
