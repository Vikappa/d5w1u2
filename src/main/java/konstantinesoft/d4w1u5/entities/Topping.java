package konstantinesoft.d4w1u5.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue("TOPPING")
@Getter
@Setter
@NoArgsConstructor
public class Topping extends Alimento {

    private String flavor;

    @ManyToMany(mappedBy = "toppings")
    private Set<Pizza> pizzas = new HashSet<>();

    public Topping(String name, String flavor) {
        super(name);
        this.flavor = flavor;
    }
}