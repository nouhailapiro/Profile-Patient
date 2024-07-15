package ma.inpt.esj.services;

import ma.inpt.esj.entities.Correspondance;
import java.util.List;

public interface CorrespondanceService {
    Correspondance saveCorrespondance(Correspondance correspondance);
    Correspondance updateCorrespondance(Long id, Correspondance correspondance);
    void deleteCorrespondance(Long id);
    Correspondance getCorrespondanceById(Long id);
    List<Correspondance> getAllCorrespondances();
}


