package ma.inpt.esj.services;

import ma.inpt.esj.entities.PriseEnCharge;

import java.util.List;

public interface PriseEnChargeService {

    PriseEnCharge getPriseEnChargeById(Long id);

    PriseEnCharge createPriseEnCharge(PriseEnCharge priseEnCharge);

    PriseEnCharge updatePriseEnCharge(Long id, PriseEnCharge priseEnCharge);

    void deletePriseEnCharge(Long id);

    List<PriseEnCharge> getPriseEnChargesByDossierMedical(Long dossierMedicalId);
}

