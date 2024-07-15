package ma.inpt.esj.repositories;

import ma.inpt.esj.entities.PriseEnCharge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PriseEnChargeRepository extends JpaRepository<PriseEnCharge,Long> {
    List<PriseEnCharge> findByDossierMedicalId(Long dossierMedicalId);
}
