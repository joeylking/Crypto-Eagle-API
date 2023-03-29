package com.galvanize.team_1.saved_coins;

import javax.persistence.*;

@Entity
@Table(name = "saved_coins")
public class SavedCoins {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String currencyName;
    private int userId;

    public SavedCoins(){}

    public SavedCoins( String currencyName, int userId) {
        this.currencyName = currencyName;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
