package ma.inpt.esj.services;

import ma.inpt.esj.entities.Correspondance;
import ma.inpt.esj.repositories.CorrespondanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CorrespondanceServiceImpl implements CorrespondanceService {

    private final CorrespondanceRepository correspondanceRepository;

    @Autowired
    public CorrespondanceServiceImpl(CorrespondanceRepository correspondanceRepository) {
        this.correspondanceRepository = correspondanceRepository;
    }

    @Override
    public Correspondance saveCorrespondance(Correspondance correspondance) {
        return correspondanceRepository.save(correspondance);
    }

    @Override
    public Correspondance updateCorrespondance(Long id, Correspondance correspondance) {
        Optional<Correspondance> optionalCorrespondance = correspondanceRepository.findById(id);
        if (optionalCorrespondance.isPresent()) {
            Correspondance existingCorrespondance = optionalCorrespondance.get();
            existingCorrespondance.setType(correspondance.getType());
            existingCorrespondance.setDetails(correspondance.getDetails());
            existingCorrespondance.setDate(correspondance.getDate());
            existingCorrespondance.setConsultation(correspondance.getConsultation());
            return correspondanceRepository.save(existingCorrespondance);
        } else {
            throw new RuntimeException("Correspondance not found with id " + id);
        }
    }

    @Override
    public void deleteCorrespondance(Long id) {
        correspondanceRepository.deleteById(id);
    }

    @Override
    public Correspondance getCorrespondanceById(Long id) {
        return correspondanceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Correspondance not found with id " + id));
    }

    @Override
    public List<Correspondance> getAllCorrespondances() {
        return correspondanceRepository.findAll();
    }
}

