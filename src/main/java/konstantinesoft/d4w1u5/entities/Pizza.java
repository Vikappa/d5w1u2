package konstantinesoft.d4w1u5.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue("PIZZA")
@Getter
@Setter
@NoArgsConstructor
public class Pizza extends Alimento {

    private String size;

    @ManyToMany
    @JoinTable(
            name = "pizza_topping",
            joinColumns = @JoinColumn(name = "pizza_id"),
            inverseJoinColumns = @JoinColumn(name = "topping_id")
    )
    private Set<Topping> toppings = new HashSet<>();

    public Pizza(String name, String size) {
        super(name);
        this.size = size;
    }

    public void addTopping(Topping topping) {
        this.toppings.add(topping);
        topping.getPizzas().add(this);
    }

    public void removeTopping(Topping topping) {
        this.toppings.remove(topping);
        topping.getPizzas().remove(this);
    }
}
