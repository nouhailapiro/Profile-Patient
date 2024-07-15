package ma.inpt.esj.services;

import ma.inpt.esj.entities.PriseEnCharge;
import ma.inpt.esj.repositories.PriseEnChargeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PriseEnChargeServiceImpl implements PriseEnChargeService {

    private final PriseEnChargeRepository priseEnChargeRepository;

    @Autowired
    public PriseEnChargeServiceImpl(PriseEnChargeRepository priseEnChargeRepository) {
        this.priseEnChargeRepository = priseEnChargeRepository;
    }

    @Override
    public PriseEnCharge getPriseEnChargeById(Long id) {
        Optional<PriseEnCharge> priseEnCharge = priseEnChargeRepository.findById(id);
        return priseEnCharge.orElse(null);
    }

    @Override
    public PriseEnCharge createPriseEnCharge(PriseEnCharge priseEnCharge) {
        return priseEnChargeRepository.save(priseEnCharge);
    }

    @Override
    public PriseEnCharge updatePriseEnCharge(Long id, PriseEnCharge updatedPriseEnCharge) {
        Optional<PriseEnCharge> existingPriseEnCharge = priseEnChargeRepository.findById(id);
        if (existingPriseEnCharge.isPresent()) {
            updatedPriseEnCharge.setId(id);
            return priseEnChargeRepository.save(updatedPriseEnCharge);
        } else {
            return null;
        }
    }

    @Override
    public void deletePriseEnCharge(Long id) {
        priseEnChargeRepository.deleteById(id);
    }

    @Override
    public List<PriseEnCharge> getPriseEnChargesByDossierMedical(Long dossierMedicalId) {
        return priseEnChargeRepository.findByDossierMedicalId(dossierMedicalId);
    }
}

