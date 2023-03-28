package com.galvanize.team_1.coin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
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
