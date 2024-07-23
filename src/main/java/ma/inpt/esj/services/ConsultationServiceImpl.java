package ma.inpt.esj.services;

import ma.inpt.esj.entities.Consultation;
import ma.inpt.esj.entities.DossierMedical;
import ma.inpt.esj.entities.Jeune;
import ma.inpt.esj.entities.Medecin;
import ma.inpt.esj.repositories.ConsultationRepository;
import ma.inpt.esj.repositories.JeuneRepository;
import ma.inpt.esj.repositories.MedecinRepository;
import ma.inpt.esj.repositories.DossierMedicalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultationServiceImpl implements ConsultationService {

    private final ConsultationRepository consultationRepository;
    private final JeuneRepository jeuneRepository;
    private final MedecinRepository medecinRepository;
    private final DossierMedicalRepository dossierMedicalRepository;

    @Autowired
    public ConsultationServiceImpl(ConsultationRepository consultationRepository, JeuneRepository jeuneRepository,
            MedecinRepository medecinRepository, DossierMedicalRepository dossierMedicalRepository) {
        this.consultationRepository = consultationRepository;
        this.jeuneRepository = jeuneRepository;
        this.medecinRepository = medecinRepository;
        this.dossierMedicalRepository = dossierMedicalRepository;
    }

    @Override
    public Consultation saveConsultation(Consultation consultation, Long idMedecin) {

        Medecin medecin = medecinRepository.findById(idMedecin).orElse(null);
        consultation.setMedecin(medecin);

        return consultationRepository.save(consultation);
    }

    @Override
    public Consultation updateConsultation(Long id, Consultation consultation) {
        Optional<Consultation> optionalConsultation = consultationRepository.findById(id);
        if (optionalConsultation.isPresent()) {
            Consultation existingConsultation = optionalConsultation.get();
            existingConsultation.setDate(consultation.getDate());
            existingConsultation.setMotif(consultation.getMotif());
            existingConsultation.setAntecedentPersonnel(consultation.getAntecedentPersonnel());
            existingConsultation.setAntecedentFamilial(consultation.getAntecedentFamilial());
            existingConsultation.setHistoriqueClinique(consultation.getHistoriqueClinique());
            existingConsultation.setExamenClinique(consultation.getExamenClinique());
            existingConsultation.setExamenMedical(consultation.getExamenMedical());
            existingConsultation.setDiagnostic(consultation.getDiagnostic());

            Jeune jeune = jeuneRepository.findById(consultation.getJeune().getId()).orElse(null);
            Medecin medecin = medecinRepository.findById(consultation.getMedecin().getId()).orElse(null);
            DossierMedical dossierMedical = dossierMedicalRepository.findById(consultation.getDossierMedical().getId())
                    .orElse(null);

            existingConsultation.setJeune(jeune);
            existingConsultation.setMedecin(medecin);
            existingConsultation.setDossierMedical(dossierMedical);

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
