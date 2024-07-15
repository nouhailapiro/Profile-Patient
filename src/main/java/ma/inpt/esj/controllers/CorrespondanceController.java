package ma.inpt.esj.controllers;

import ma.inpt.esj.entities.Correspondance;
import ma.inpt.esj.services.CorrespondanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/correspondances")
public class CorrespondanceController {

    private final CorrespondanceService correspondanceService;

    @Autowired
    public CorrespondanceController(CorrespondanceService correspondanceService) {
        this.correspondanceService = correspondanceService;
    }

    @PostMapping
    public ResponseEntity<Correspondance> createCorrespondance(@RequestBody Correspondance correspondance) {
        Correspondance savedCorrespondance = correspondanceService.saveCorrespondance(correspondance);
        return new ResponseEntity<>(savedCorrespondance, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Correspondance> updateCorrespondance(
            @PathVariable Long id,
            @RequestBody Correspondance correspondance) {
        Correspondance updatedCorrespondance = correspondanceService.updateCorrespondance(id, correspondance);
        return new ResponseEntity<>(updatedCorrespondance, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCorrespondance(@PathVariable Long id) {
        correspondanceService.deleteCorrespondance(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Correspondance> getCorrespondanceById(@PathVariable Long id) {
        Correspondance correspondance = correspondanceService.getCorrespondanceById(id);
        return new ResponseEntity<>(correspondance, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Correspondance>> getAllCorrespondances() {
        List<Correspondance> correspondances = correspondanceService.getAllCorrespondances();
        return new ResponseEntity<>(correspondances, HttpStatus.OK);
    }
}

