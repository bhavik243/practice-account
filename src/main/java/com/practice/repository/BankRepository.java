package com.practice.repository;

import com.practice.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankRepository extends JpaRepository<Bank,Integer>{

	@Override
	List<Bank> findAllById(Iterable<Integer> iterable);

}
