package ma.inpt.esj.repositories;

import ma.inpt.esj.entities.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrescriptionRepository extends JpaRepository<Prescription,Long> {
    List<Prescription> findByConsultationId(Long consultationId);
}
