package com.galvanize.team_1.coin;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class CoinController {

    @GetMapping("/get-coins")
    public CoinList getAllCoins(){
        String url = "https://api.coincap.io/v2/assets";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, CoinList.class);
    }

    @GetMapping("/coin/{id}")
    public CoinWrapper getCoin(@PathVariable String id){
        String url = "https://api.coincap.io/v2/assets/" + id;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, CoinWrapper.class);
    }



}
