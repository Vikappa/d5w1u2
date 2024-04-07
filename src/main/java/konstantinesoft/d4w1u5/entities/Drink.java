package konstantinesoft.d4w1u5.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("DRINKS")
public class Drink extends Alimento {

    private double drink_size;

    public Drink() {
    }

    public Drink(String name) {
        super(name);
    }

    public double getSize() {
        return drink_size;
    }

    public void setSize(double size) {
        this.drink_size = size;
    }
}
