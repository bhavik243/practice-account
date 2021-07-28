package com.practice.repository;

import java.util.Optional;

import com.practice.entity.FavouriteAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<FavouriteAccount,Integer>{

	Optional<FavouriteAccount> findByIbanNumber(int ibanNumber);

	ResponseEntity<Object> getById(FavouriteAccount favouriteAccount);
}
