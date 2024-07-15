package ma.inpt.esj.controllers;

import ma.inpt.esj.entities.PriseEnCharge;
import ma.inpt.esj.services.PriseEnChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prise-en-charge")
public class PriseEnChargeController {

    private final PriseEnChargeService priseEnChargeService;

    @Autowired
    public PriseEnChargeController(PriseEnChargeService priseEnChargeService) {
        this.priseEnChargeService = priseEnChargeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PriseEnCharge> getPriseEnChargeById(@PathVariable("id") Long id) {
        PriseEnCharge priseEnCharge = priseEnChargeService.getPriseEnChargeById(id);
        if (priseEnCharge != null) {
            return ResponseEntity.ok(priseEnCharge);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<PriseEnCharge> createPriseEnCharge(@RequestBody PriseEnCharge priseEnCharge) {
        PriseEnCharge createdPriseEnCharge = priseEnChargeService.createPriseEnCharge(priseEnCharge);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPriseEnCharge);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PriseEnCharge> updatePriseEnCharge(
            @PathVariable("id") Long id,
            @RequestBody PriseEnCharge priseEnCharge) {
        PriseEnCharge updatedPriseEnCharge = priseEnChargeService.updatePriseEnCharge(id, priseEnCharge);
        if (updatedPriseEnCharge != null) {
            return ResponseEntity.ok(updatedPriseEnCharge);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePriseEnCharge(@PathVariable("id") Long id) {
        priseEnChargeService.deletePriseEnCharge(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/dossier-medical/{dossierMedicalId}")
    public ResponseEntity<List<PriseEnCharge>> getPriseEnChargesByDossierMedical(
            @PathVariable("dossierMedicalId") Long dossierMedicalId) {
        List<PriseEnCharge> priseEnCharges = priseEnChargeService.getPriseEnChargesByDossierMedical(dossierMedicalId);
        if (!priseEnCharges.isEmpty()) {
            return ResponseEntity.ok(priseEnCharges);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

