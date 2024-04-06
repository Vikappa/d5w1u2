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

    @OneToMany(mappedBy = "tavolo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ordine> ordini = new ArrayList<>();

    // Constructor excluding id and ordini list
    public Tavolo(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    // Convenience method to add an Ordine to the Tavolo
    public void addOrdine(Ordine ordine) {
        ordini.add(ordine);
        ordine.setTavolo(this);
    }

    // Convenience method to remove an Ordine from the Tavolo
    public void removeOrdine(Ordine ordine) {
        ordini.remove(ordine);
        ordine.setTavolo(null);
    }
}

