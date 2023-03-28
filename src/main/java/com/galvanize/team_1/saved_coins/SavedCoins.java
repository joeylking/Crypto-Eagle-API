package com.galvanize.team_1.saved_coins;

import jdk.jfr.Enabled;

import javax.persistence.*;

@Entity
@Table(name = "WatchList")
public class SavedCoins {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String currencyName;
    private String userId;

    public SavedCoins(String id, String currencyName, String userId) {
        this.id = id;
        this.currencyName = currencyName;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
