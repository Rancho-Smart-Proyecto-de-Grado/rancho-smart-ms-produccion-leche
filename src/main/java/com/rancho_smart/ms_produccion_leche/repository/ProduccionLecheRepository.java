package com.rancho_smart.ms_produccion_leche.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rancho_smart.ms_produccion_leche.entity.ProduccionLeche;
import java.util.List;


@Repository
public interface ProduccionLecheRepository extends JpaRepository<ProduccionLeche, Long>{
    public List<ProduccionLeche> findByIdAnimal(Long idAnimal);
    public List<ProduccionLeche> findByIdFinca(Long idFinca);
    public List<ProduccionLeche> findByIdLote(Long idLote);
}
