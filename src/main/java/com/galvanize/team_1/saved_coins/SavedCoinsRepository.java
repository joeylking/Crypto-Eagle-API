package com.galvanize.team_1.saved_coins;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavedCoinsRepository extends JpaRepository<SavedCoins, Integer> {
}
