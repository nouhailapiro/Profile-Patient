package ma.inpt.esj.controllers;

import ma.inpt.esj.entities.DossierMedical;
import ma.inpt.esj.services.DossierMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dossiersMedicaux")
public class DossierMedicalController {

    private final DossierMedicalService dossierMedicalService;

    @Autowired
    public DossierMedicalController(DossierMedicalService dossierMedicalService) {
        this.dossierMedicalService = dossierMedicalService;
    }

    @PostMapping
    public ResponseEntity<DossierMedical> createDossierMedical(@RequestBody DossierMedical dossierMedical) {
        DossierMedical savedDossierMedical = dossierMedicalService.saveDossierMedical(dossierMedical);
        return new ResponseEntity<>(savedDossierMedical, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DossierMedical> updateDossierMedical(
            @PathVariable Long id,
            @RequestBody DossierMedical dossierMedical) {
        DossierMedical updatedDossierMedical = dossierMedicalService.updateDossierMedical(id, dossierMedical);
        return new ResponseEntity<>(updatedDossierMedical, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDossierMedical(@PathVariable Long id) {
        dossierMedicalService.deleteDossierMedical(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DossierMedical> getDossierMedicalById(@PathVariable Long id) {
        DossierMedical dossierMedical = dossierMedicalService.getDossierMedicalById(id);
        return new ResponseEntity<>(dossierMedical, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<DossierMedical>> getAllDossierMedicals() {
        List<DossierMedical> dossierMedicals = dossierMedicalService.getAllDossierMedicals();
        return new ResponseEntity<>(dossierMedicals, HttpStatus.OK);
    }
}



