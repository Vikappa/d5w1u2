package konstantinesoft.d4w1u5.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ALIMENTO_TYPE")
@Getter
@Setter
public abstract class Alimento {

    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ordine_id")
    protected Ordine ordine;

    protected String name;

    protected double calories;

    protected double price;
    protected Alimento() {
        this.calories = 0;
        this.price = 0;
    }

    protected Alimento(String name) {
        this.calories = 0;
        this.price = 0;
        this.name = name;
    }

    public Alimento(String name, double calories, double price) {
        this.name = name;
        this.calories = calories;
        this.price = price;
    }

    public Alimento(Ordine ordine, String name, double calories, double price) {
        this.ordine = ordine;
        this.name = name;
        this.calories = calories;
        this.price = price;
    }
}