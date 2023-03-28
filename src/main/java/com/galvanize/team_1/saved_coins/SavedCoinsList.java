package com.galvanize.team_1.saved_coins;

import java.util.ArrayList;
import java.util.List;

public class SavedCoinsList {

    List<SavedCoins> savedCoinsList;

    public SavedCoinsList(){this.savedCoinsList = new ArrayList<>();}
    public SavedCoinsList(List<SavedCoins> list){
        this.savedCoinsList = list;
    }

    public List<SavedCoins> getSavedCoinsList() {
        return this.savedCoinsList;
    }

    public void setSavedCoinsList(List<SavedCoins> savedCoinsList) {
        this.savedCoinsList = savedCoinsList;
    }
}
