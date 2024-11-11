package com.rancho_smart.ms_produccion_leche.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rancho_smart.ms_produccion_leche.entity.ProduccionLeche;
import com.rancho_smart.ms_produccion_leche.repository.ProduccionLecheRepository;

@Service
public class ProduccionLecheService {

    @Autowired
    private ProduccionLecheRepository produccionLecheRepository;

    public List<ProduccionLeche> getProduccionesLeche() {
        return this.produccionLecheRepository.findAll();
    }

    public List<ProduccionLeche> getProduccionLecheByIdAnimal(Long idAnimal){
        return this.produccionLecheRepository.findByIdAnimal(idAnimal);
    }

    public List<ProduccionLeche> getProduccionLecheByIdFinca(Long idFinca){
        return this.produccionLecheRepository.findByIdFinca(idFinca);
    }

    public List<ProduccionLeche> getProduccionLecheByIdLote(Long idLote){
        return this.produccionLecheRepository.findByIdLote(idLote);
    }
    
    public Optional<ProduccionLeche> getProduccionLecheById(Long id) {
        return this.produccionLecheRepository.findById(id);
    }

    public ProduccionLeche saveProduccionLeche(ProduccionLeche produccionLeche) {
        return this.produccionLecheRepository.save(produccionLeche);
    }

    public void deleteProduccionLeche(Long id) {
        this.produccionLecheRepository.deleteById(id);
    }
}
