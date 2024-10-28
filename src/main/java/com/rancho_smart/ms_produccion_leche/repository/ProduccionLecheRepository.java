package com.rancho_smart.ms_produccion_leche.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rancho_smart.ms_produccion_leche.entity.ProduccionLeche;

@Repository
public interface ProduccionLecheRepository extends JpaRepository<ProduccionLeche, Long>{
    
}
