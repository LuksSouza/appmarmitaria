package com.marmitaria.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marmitaria.app.domain.Prato;

@Repository
public interface PratoRepository extends JpaRepository<Prato, Long> {

}
