package ma.inpt.esj.services;

import ma.inpt.esj.entities.Consultation;
import ma.inpt.esj.repositories.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultationServiceImpl implements ConsultationService {

    private final ConsultationRepository consultationRepository;

    @Autowired
    public ConsultationServiceImpl(ConsultationRepository consultationRepository) {
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    @Override
    public Consultation updateConsultation(Long id, Consultation consultation) {
        Optional<Consultation> optionalConsultation = consultationRepository.findById(id);
        if (optionalConsultation.isPresent()) {
            Consultation existingConsultation = optionalConsultation.get();
            existingConsultation.setDate(consultation.getDate());
            existingConsultation.setDiagnostic(consultation.getDiagnostic());
            existingConsultation.setPrestation(consultation.getPrestation());
            existingConsultation.setReference(consultation.getReference());
            existingConsultation.setObservations(consultation.getObservations());
            existingConsultation.setJeune(consultation.getJeune());
            existingConsultation.setMedecin(consultation.getMedecin());
            existingConsultation.setCorrespondance(consultation.getCorrespondance());
            existingConsultation.setPrescriptions(consultation.getPrescriptions());
            return consultationRepository.save(existingConsultation);
        } else {
            throw new RuntimeException("Consultation not found with id " + id);
        }
    }

    @Override
    public void deleteConsultation(Long id) {
        consultationRepository.deleteById(id);
    }

    @Override
    public Consultation getConsultationById(Long id) {
        return consultationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consultation not found with id " + id));
    }

    @Override
    public List<Consultation> getAllConsultations() {
        return consultationRepository.findAll();
    }
}

