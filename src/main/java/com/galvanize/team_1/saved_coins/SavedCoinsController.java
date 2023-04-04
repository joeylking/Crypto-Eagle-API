package com.galvanize.team_1.saved_coins;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/saved-coins")
@CrossOrigin(origins = "http://localhost:3000")
public class SavedCoinsController {

    SavedCoinsService savedCoinsService;

    public SavedCoinsController(SavedCoinsService savedCoinsService) {
        this.savedCoinsService = savedCoinsService;
    }

    @GetMapping(value = {"", "/"})
    public ResponseEntity<SavedCoinsList> getAllSavedCoins(){
        SavedCoinsList savedCoinsList = savedCoinsService.getAllSavedCoins();

        HttpStatus status = savedCoinsList.getSavedCoinsList().isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK;

        return new ResponseEntity<>(savedCoinsList, status);
    }

    @GetMapping(value = {"/{id}"})
    public ResponseEntity<SavedCoins> getSavedCoinsByID (@PathVariable String id){
        SavedCoins savedCoins = savedCoinsService.getSavedCoinsByID(id);

        HttpStatus status = savedCoins == null ? HttpStatus.NO_CONTENT : HttpStatus.OK;

        return new ResponseEntity<>(savedCoins, status);
    }

    @GetMapping("/user/{userid}")
    public ResponseEntity<SavedCoinsList> getAllSavedCoinsByUser(@PathVariable int userid){
        SavedCoinsList savedCoinsList = savedCoinsService.getAllSavedCoinsByUser(userid);

        HttpStatus status =  savedCoinsList.getSavedCoinsList().isEmpty() ?  HttpStatus.NO_CONTENT : HttpStatus.OK;

        return new ResponseEntity<>(savedCoinsList, status);
    }

    @PostMapping("/add")
    public ResponseEntity<SavedCoins> addNewCoin(@RequestBody SavedCoins savedCoins){
        return new ResponseEntity<>(savedCoinsService.addNewCoin(savedCoins), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCoin(@PathVariable String id){
        try {
            savedCoinsService.deleteCoin(id);
        } catch (Exception e) {
            return new ResponseEntity<>("Delete unsuccessful.", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Delete successful.", HttpStatus.ACCEPTED);
    }
}
