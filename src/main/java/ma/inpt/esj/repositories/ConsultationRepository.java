package ma.inpt.esj.repositories;

import ma.inpt.esj.entities.Consultation;
import ma.inpt.esj.entities.PriseEnCharge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}
