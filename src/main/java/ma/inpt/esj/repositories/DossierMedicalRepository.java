package ma.inpt.esj.repositories;

import ma.inpt.esj.entities.DossierMedical;
import ma.inpt.esj.entities.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DossierMedicalRepository extends JpaRepository<DossierMedical,Long> {
}
