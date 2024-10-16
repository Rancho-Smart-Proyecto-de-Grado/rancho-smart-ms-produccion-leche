package  com.rancho_smart.ms_produccion_leche.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rancho_smart.ms_produccion_leche.Entity.Leche;



public interface LecheRepository extends JpaRepository<Leche, Long> {

    List<Leche> findByIdLoteOrderByFechaExtraccionDesc(Long idLote);

    List<Leche> findByIdAnimalOrderByFechaExtraccionDesc(Long idAnimal);

    List<Leche> findAllByOrderByFechaExtraccionDesc();

    List<Leche> findByIdLoteAndFechaExtraccionBetweenOrderByFechaExtraccionDesc(Long idLote, LocalDate startDate, LocalDate endDate);

    List<Leche> findByIdAnimalAndFechaExtraccionBetweenOrderByFechaExtraccionDesc(Long idAnimal, LocalDate startDate, LocalDate endDate);
}
