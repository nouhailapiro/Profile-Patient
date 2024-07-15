package ma.inpt.esj.entities;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.Builder;

@Entity
@Getter @Setter @Builder @AllArgsConstructor @NoArgsConstructor @ToString
public class Consultation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private String diagnostic;
    private String prestation;
    private String reference;
    private String observations;
    @OneToOne(cascade = CascadeType.ALL)
    private Jeune jeune;
    @OneToOne(cascade = CascadeType.ALL)
    private Medecin medecin;
    @OneToOne(cascade = CascadeType.ALL)
    private Correspondance correspondance;
    @OneToMany(mappedBy = "consultation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Prescription> prescriptions;
    @ManyToOne
    @JoinColumn(name = "dossier_medical_id")
    private DossierMedical dossierMedical;
}
