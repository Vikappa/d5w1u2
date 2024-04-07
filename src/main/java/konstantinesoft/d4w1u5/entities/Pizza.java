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


    public String getSize() {
        return this.pizzaSize.toString();
    }

    public enum PIZZASIZE {
        GRANDE, MEDIO, PICCOLA
    }

    @Enumerated(EnumType.STRING)
    private PIZZASIZE pizzaSize;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "pizza_topping",
            joinColumns = @JoinColumn(name = "pizza_id"),
            inverseJoinColumns = @JoinColumn(name = "topping_id")
    )
    private Set<Topping> toppings = new HashSet<>();

    public void addTopping(Topping topping) {
        this.toppings.add(topping);
        topping.getPizzas().add(this);
        this.price += topping.getPrice();
        this.calories += topping.getCalories();
    }

    public void removeTopping(Topping topping) {
        this.toppings.remove(topping);
        topping.getPizzas().remove(this);
        this.price -= topping.getPrice();
        this.calories -= topping.getCalories();
    }

    public void setBasePriceAndCalories() {
        if (this.pizzaSize == PIZZASIZE.PICCOLA) {
            this.price = 2.5;
            this.calories = 200;
        } else if (this.pizzaSize == PIZZASIZE.MEDIO) {
            this.price = 5.0;
            this.calories = 500;
        } else if (this.pizzaSize == PIZZASIZE.GRANDE) {
            this.price = 7.5;
            this.calories = 700;
        }
    }
    @Override
    public String toString() {
        return "Pizza {"+ name + '\'' +
                ", Grandezza=" + pizzaSize +
                ", toppings=" + toppings +
                ", calorie=" + calories +
                ", prezzo=" + price + "€" +
                '}';
    }
}
