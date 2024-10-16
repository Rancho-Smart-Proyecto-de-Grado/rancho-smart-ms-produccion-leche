package  com.rancho_smart.ms_produccion_leche.Controller;

import java.util.List;

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

import com.rancho_smart.ms_produccion_leche.Entity.Leche;
import com.rancho_smart.ms_produccion_leche.Service.LecheService;



@RestController
@RequestMapping("/leche")
public class LecheRestController {
 @Autowired
    private LecheService lecheService;

    @PostMapping
    public ResponseEntity<Leche> registrarProduccion(@RequestBody Leche leche) {
        Leche nuevaLeche = lecheService.createProduccionLeche(leche);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaLeche);
    }

  @GetMapping("/{id}")
    public ResponseEntity<Leche> getLecheById(@PathVariable Long id) {
        return ResponseEntity.ok(lecheService.getProduccionLecheById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Leche>> getAllLeches() {
        return ResponseEntity.ok(lecheService.getAllProduccionLeche());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLecheById(@PathVariable Long id) {
        lecheService.deleteProduccionLecheById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Leche> updateLeche(@PathVariable Long id, @RequestBody Leche leche) {
        return ResponseEntity.ok(lecheService.updateProduccionLeche(id, leche));
    }

    @GetMapping("/lote/{idLote}/{meses}")
public List<Leche> getProduccionByLote(@PathVariable Long idLote, @PathVariable int meses) {
    return lecheService.getProduccionByLoteAndFecha(idLote, meses);
}

@GetMapping("/animal/{idAnimal}/{meses}")
public List<Leche> getProduccionByAnimal(@PathVariable Long idAnimal, @PathVariable int meses) {
    return lecheService.getProduccionByAnimalAndFecha(idAnimal, meses);
}

  @GetMapping("/lote/{idLote}")
    public List<Leche> getProduccionByLote(@PathVariable Long idLote) {
        return lecheService.getProduccionByLote(idLote);
    }

    @GetMapping("/animal/{idAnimal}")
    public List<Leche> getProduccionByAnimal(@PathVariable Long idAnimal) {
        return lecheService.getProduccionByAnimal(idAnimal);
    }
}
