package konstantinesoft.d4w1u5.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor
public class Tavolo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numberOfSeats;

    @OneToMany(mappedBy = "tavolo", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Ordine> ordini = new ArrayList<>();

    public Tavolo(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public void addOrdine(Ordine ordine) {
        ordini.add(ordine);
        ordine.setTavolo(this);
    }

    public void removeOrdine(Ordine ordine) {
        ordini.remove(ordine);
        ordine.setTavolo(null);
    }
}

