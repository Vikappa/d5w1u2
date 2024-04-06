package konstantinesoft.d4w1u5.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("DRINKS")
public class Drink extends Alimento {

    private String type;


    public Drink() {
    }

    public Drink(String name, String type) {
        super(name);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
