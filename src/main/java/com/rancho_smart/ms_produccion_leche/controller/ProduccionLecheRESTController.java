package com.rancho_smart.ms_produccion_leche.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rancho_smart.ms_produccion_leche.entity.ProduccionLeche;
import com.rancho_smart.ms_produccion_leche.service.ProduccionLecheService;

@RestController
@RequestMapping(path = "/producciones-leche")
public class ProduccionLecheRESTController {

    @Autowired
    private ProduccionLecheService produccionLecheService;

    @GetMapping
    public ResponseEntity<List<ProduccionLeche>> getAllProduccionesLeche() {
        List<ProduccionLeche> listado = this.produccionLecheService.getProduccionesLeche();
        return new ResponseEntity<>(listado, HttpStatus.OK);
    }

    @GetMapping("/animal/{idAnimal}")
    public ResponseEntity<List<ProduccionLeche>> getProduccionLecheByIdAnimal(@PathVariable Long idAnimal){
        List<ProduccionLeche> produccionesAnimal = this.produccionLecheService.getProduccionLecheByIdAnimal(idAnimal);
        if(produccionesAnimal.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(produccionesAnimal, HttpStatus.OK);
        }
    }

    @GetMapping("/finca/{idFinca}")
    public ResponseEntity<List<ProduccionLeche>> getProduccionLecheByIdFinca(@PathVariable Long idFinca){
        List<ProduccionLeche> produccionesFinca = this.produccionLecheService.getProduccionLecheByIdFinca(idFinca);
        if(produccionesFinca.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(produccionesFinca, HttpStatus.OK);
        }
    }

    @GetMapping("/lote/{idLote}")
    public ResponseEntity<List<ProduccionLeche>> getProduccionLecheByIdLote(@PathVariable Long idLote){
        List<ProduccionLeche> produccionesLote = this.produccionLecheService.getProduccionLecheByIdLote(idLote);
        if(produccionesLote.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(produccionesLote, HttpStatus.OK);
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ProduccionLeche> getProduccionLecheById(@PathVariable Long id) {
        Optional<ProduccionLeche> produccionLeche = this.produccionLecheService.getProduccionLecheById(id);
        return produccionLeche.map(ResponseEntity::ok)
                              .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<ProduccionLeche> saveProduccionLeche(@RequestBody ProduccionLeche produccionLeche) {
        ProduccionLeche produccionLecheCreada = this.produccionLecheService.saveProduccionLeche(produccionLeche);
        return new ResponseEntity<>(produccionLecheCreada, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProduccionLeche> updateProduccionLeche(@PathVariable Long id, @RequestBody ProduccionLeche produccionLeche) {
        if (!this.produccionLecheService.getProduccionLecheById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            produccionLeche.setIdProduccionLeche(id);
            ProduccionLeche produccionLecheActualizada = this.produccionLecheService.saveProduccionLeche(produccionLeche);
            return new ResponseEntity<>(produccionLecheActualizada, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduccionLeche(@PathVariable Long id) {
        if (!this.produccionLecheService.getProduccionLecheById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            this.produccionLecheService.deleteProduccionLeche(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
