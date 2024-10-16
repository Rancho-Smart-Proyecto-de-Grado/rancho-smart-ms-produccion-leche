package com.rancho_smart.ms_produccion_leche.Service;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rancho_smart.ms_produccion_leche.Entity.Leche;
import com.rancho_smart.ms_produccion_leche.Repository.LecheRepository;


@Service
public class LecheService {

    @Autowired
    private LecheRepository lecheRepository;

    public Leche createProduccionLeche(Leche leche) {
        return lecheRepository.save(leche);
    }

    public Leche getProduccionLecheById(Long id) {
        return lecheRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Leche no encontrada"));
    }

    public List<Leche> getAllProduccionLeche() {
        return lecheRepository.findAllByOrderByFechaExtraccionDesc();
    }

    public void deleteProduccionLecheById(Long id) {
        lecheRepository.deleteById(id);
    }

    public Leche updateProduccionLeche(Long id, Leche updatedLeche) {
        return lecheRepository.findById(id)
                .map(leche -> {
                    leche.setIdLote(updatedLeche.getIdLote());
                    leche.setIdAnimal(updatedLeche.getIdAnimal());
                    leche.setFechaExtraccion(updatedLeche.getFechaExtraccion());
                    leche.setCantidad(updatedLeche.getCantidad());
                    return lecheRepository.save(leche);
                })
                .orElseThrow(() -> new RuntimeException("Leche no encontrada"));
    }


    public List<Leche> getProduccionByLoteAndFecha(Long idLote, int meses) {
        LocalDate fechaFin = LocalDate.now();
        LocalDate fechaInicio = fechaFin.minusMonths(meses);
    
        return lecheRepository.findByIdLoteAndFechaExtraccionBetweenOrderByFechaExtraccionDesc(idLote, fechaInicio, fechaFin);
    }
    
    public List<Leche> getProduccionByAnimalAndFecha(Long idAnimal, int meses) {
        LocalDate fechaFin = LocalDate.now();
        LocalDate fechaInicio = fechaFin.minusMonths(meses);

        return lecheRepository.findByIdAnimalAndFechaExtraccionBetweenOrderByFechaExtraccionDesc(idAnimal, fechaInicio, fechaFin);
    }

    public List<Leche> getProduccionByLote(Long idLote) {
        return lecheRepository.findByIdLoteOrderByFechaExtraccionDesc(idLote);
    }

    public List<Leche> getProduccionByAnimal(Long idAnimal) {
        return lecheRepository.findByIdAnimalOrderByFechaExtraccionDesc(idAnimal);
    }
}
