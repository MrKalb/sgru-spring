package br.com.ifrs.SGRU.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ifrs.SGRU.entities.CityEntity;

@Repository
public interface CityEntityRepository extends JpaRepository<CityEntity,Integer> {

}
