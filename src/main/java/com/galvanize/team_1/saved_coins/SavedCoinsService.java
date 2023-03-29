package com.galvanize.team_1.saved_coins;

import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class SavedCoinsService {

    SavedCoinsRepository savedCoinsRepository;

    public SavedCoinsService(SavedCoinsRepository savedCoinsRepository) {
        this.savedCoinsRepository = savedCoinsRepository;
    }

    public SavedCoinsList getAllSavedCoins() {
        return new SavedCoinsList(savedCoinsRepository.findAll());
    }

    public SavedCoins getSavedCoinsByID(String id) {
        return savedCoinsRepository.findById(Integer.parseInt(id)).orElse(null);
    }

    public SavedCoins addNewCoin(SavedCoins savedCoins) {
        return savedCoinsRepository.save(savedCoins);
    }

    public void deleteCoin(String id) {
        Optional<SavedCoins> optionalSavedCoins = savedCoinsRepository.findById(Integer.parseInt(id));
        if (optionalSavedCoins.isEmpty()) {
            throw new NoSuchElementException("Coin not found.");
        } else {
            savedCoinsRepository.delete(optionalSavedCoins.get());
        }
    }

    public SavedCoinsList getAllSavedCoinsByUser(String userid) {
        return new SavedCoinsList(savedCoinsRepository.findAllByUserId(Integer.parseInt(userid)));
    }
}
