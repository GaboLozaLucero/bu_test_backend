package com.example.bu_test_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "coin")
public class Coin {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coin_id")
    private Integer coinId;

    @Column(name = "coin_name", length = 5, nullable = false)
    private String coinName;

    public Coin() {}

    public Integer getCoinId() {
        return coinId;
    }
    public void setCoinId(Integer coinId) {
        this.coinId = coinId;
    }
    public String getCoinName() {
        return coinName;
    }
    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }
    
    @Override
    public String toString() {
        return "Coin [coinId=" + coinId + ", coinName=" + coinName + "]";
    }

    
}
