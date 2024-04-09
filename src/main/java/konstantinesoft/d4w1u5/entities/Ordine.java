package konstantinesoft.d4w1u5.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Ordine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime orario_ricezione;

    @OneToMany(mappedBy = "ordine", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Alimento> alimenti = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tavolo_id")
    private Tavolo tavolo;


    public void addAlimento(Alimento alimento) {
        alimenti.add(alimento);
        alimento.setOrdine(this);
    }

    public void removeAlimento(Alimento alimento) {
        alimenti.remove(alimento);
        alimento.setOrdine(null);
    }

    public Ordine() {
        this.orario_ricezione = LocalDateTime.now();
    }
}