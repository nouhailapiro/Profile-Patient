package ma.inpt.esj.services;

import ma.inpt.esj.entities.Prescription;
import ma.inpt.esj.repositories.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;

    @Autowired
    public PrescriptionServiceImpl(PrescriptionRepository prescriptionRepository) {
        this.prescriptionRepository = prescriptionRepository;
    }

    @Override
    public Prescription getPrescriptionById(Long id) {
        Optional<Prescription> prescription = prescriptionRepository.findById(id);
        return prescription.orElse(null);
    }

    @Override
    public Prescription createPrescription(Prescription prescription) {
        return prescriptionRepository.save(prescription);
    }

    @Override
    public Prescription updatePrescription(Long id, Prescription prescription) {
        Optional<Prescription> existingPrescription = prescriptionRepository.findById(id);
        if (existingPrescription.isPresent()) {
            prescription.setId(id);
            return prescriptionRepository.save(prescription);
        } else {
            return null;
        }
    }

    @Override
    public void deletePrescription(Long id) {
        prescriptionRepository.deleteById(id);
    }

    @Override
    public List<Prescription> getPrescriptionsByConsultation(Long consultationId) {
        return prescriptionRepository.findByConsultationId(consultationId);
    }
}
