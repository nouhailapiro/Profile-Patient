package ma.inpt.esj.entities;

import java.util.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.Builder;

@Entity
@Getter @Setter @Builder @AllArgsConstructor @NoArgsConstructor @ToString
public class PriseEnCharge {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String details;
    private Date dateDebut;
    private Date dateFin;
    @ManyToOne
    @JoinColumn(name = "dossier_medical_id")
    private DossierMedical dossierMedical;
}
