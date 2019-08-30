package br.com.ifrs.SGRU.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifrs.SGRU.entities.PersonEntity;
import br.com.ifrs.SGRU.entities.WalletEntity;

public interface WalletRepository extends JpaRepository<WalletEntity, Integer> {
	
}
