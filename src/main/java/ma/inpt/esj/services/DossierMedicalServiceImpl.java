package ma.inpt.esj.services;

import ma.inpt.esj.entities.DossierMedical;
import ma.inpt.esj.repositories.DossierMedicalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DossierMedicalServiceImpl implements DossierMedicalService {

    private final DossierMedicalRepository dossierMedicalRepository;

    @Autowired
    public DossierMedicalServiceImpl(DossierMedicalRepository dossierMedicalRepository) {
        this.dossierMedicalRepository = dossierMedicalRepository;
    }

    @Override
    public DossierMedical saveDossierMedical(DossierMedical dossierMedical) {
        return dossierMedicalRepository.save(dossierMedical);
    }

    @Override
    public DossierMedical updateDossierMedical(Long id, DossierMedical dossierMedical) {
        Optional<DossierMedical> optionalDossierMedical = dossierMedicalRepository.findById(id);
        if (optionalDossierMedical.isPresent()) {
            DossierMedical existingDossierMedical = optionalDossierMedical.get();
            existingDossierMedical.setAntecedentsFamiliaux(dossierMedical.getAntecedentsFamiliaux());
            existingDossierMedical.setAntecedentsPersonnels(dossierMedical.getAntecedentsPersonnels());
            existingDossierMedical.setHistoriqueConsultations(dossierMedical.getHistoriqueConsultations());
            return dossierMedicalRepository.save(existingDossierMedical);
        } else {
            throw new RuntimeException("DossierMedical not found with id " + id);
        }
    }

    @Override
    public void deleteDossierMedical(Long id) {
        dossierMedicalRepository.deleteById(id);
    }

    @Override
    public DossierMedical getDossierMedicalById(Long id) {
        return dossierMedicalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("DossierMedical not found with id " + id));
    }

    @Override
    public List<DossierMedical> getAllDossierMedicals() {
        return dossierMedicalRepository.findAll();
    }
}