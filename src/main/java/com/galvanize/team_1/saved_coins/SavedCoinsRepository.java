package com.galvanize.team_1.saved_coins;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SavedCoinsRepository extends JpaRepository<SavedCoins, String> {
}
