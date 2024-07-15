package ma.inpt.esj.services;

import ma.inpt.esj.entities.DossierMedical;
import java.util.List;

public interface DossierMedicalService {
    DossierMedical saveDossierMedical(DossierMedical consultation);
    DossierMedical updateDossierMedical(Long id, DossierMedical consultation);
    void deleteDossierMedical(Long id);
    DossierMedical getDossierMedicalById(Long id);
    List<DossierMedical> getAllDossierMedicals();
}
