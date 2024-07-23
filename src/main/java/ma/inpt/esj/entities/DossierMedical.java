package ma.inpt.esj.entities;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.Builder;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DossierMedical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ElementCollection
    private List<AntecedentFamilial> antecedentsFamiliaux;
    @ElementCollection
    private List<AntecedentPersonnel> antecedentsPersonnels;

    @OneToMany(mappedBy = "dossierMedical", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Consultation> historiqueConsultations;
    @OneToMany(mappedBy = "dossierMedical", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PriseEnCharge> priseEnCharges;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "jeune_id")
    private Jeune jeune;
    // @OneToMany(cascade = CascadeType.ALL)
    // private List<Correspondance> correspondances;

}
