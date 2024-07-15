package ma.inpt.esj.services;

import ma.inpt.esj.entities.Prescription;

import java.util.List;

public interface PrescriptionService {

    Prescription getPrescriptionById(Long id);

    Prescription createPrescription(Prescription prescription);

    Prescription updatePrescription(Long id, Prescription prescription);

    void deletePrescription(Long id);

    List<Prescription> getPrescriptionsByConsultation(Long consultationId);
}

