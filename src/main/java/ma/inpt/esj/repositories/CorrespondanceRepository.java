package ma.inpt.esj.repositories;

import ma.inpt.esj.entities.Correspondance;
import ma.inpt.esj.entities.PriseEnCharge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorrespondanceRepository extends JpaRepository<Correspondance,Long> {
}
