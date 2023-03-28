package com.galvanize.team_1.saved_coins;

import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class SavedCoinsService {

    SavedCoinsRepository savedCoinsRepository;

    public SavedCoinsList getAllSavedCoins(){

        return new SavedCoinsList(savedCoinsRepository.findAll());
    }

    public SavedCoins getSavedCoinsByID(String id) {
        return savedCoinsRepository.findById(id).orElse(null);
    }

    public SavedCoins addNewCoin(SavedCoins savedCoins){
        return savedCoinsRepository.save(savedCoins);
    }

    public void deleteCoin(String id) {
        Optional<SavedCoins> optionalSavedCoins = savedCoinsRepository.findById(id);
        if (optionalSavedCoins.isEmpty()) {
            throw new NoSuchElementException("Coin not found.");
        } else {
            savedCoinsRepository.delete(optionalSavedCoins.get());
        }
    }
}
