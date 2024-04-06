package konstantinesoft.d4w1u5;
import konstantinesoft.d4w1u5.entities.Alimento;
import konstantinesoft.d4w1u5.entities.Pizza;
import konstantinesoft.d4w1u5.entities.Topping;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    private static final Logger logger = LogManager.getLogger(PizzaDataLoader.class);

    private List<Alimento> items;

    public Menu() {
        this.items = new ArrayList<>();
    }

    public void addAlimento(Alimento alimento) {
        items.add(alimento);
    }

    public void printMenu() {
        System.out.println("Menu:");
        for (int i = 0; i < this.items.size(); i++) {
            logger.info(i+this.items.get(i).toString());
        }
    }

    public List<Alimento> getItems() {
        return items;
    }

    public void setItems(List<Alimento> items) {
        this.items = items;
    }

    public static Pizza creaPizzaMargheritaPiccola(){
        Topping pomodoro = new Topping("Pomodoro", 10, 1.2);
        Topping mozzarella = new Topping("Mozzarella", 10, 1.2);
        Pizza pizzaMargheritaPiccola = new Pizza();
        pizzaMargheritaPiccola.setName("Margherita piccola");
        pizzaMargheritaPiccola.setPizzaSize(Pizza.PIZZASIZE.PICCOLA);
        pizzaMargheritaPiccola.setCalories(200);
        pizzaMargheritaPiccola.setPrice(2.5);
        pizzaMargheritaPiccola.addTopping(pomodoro);
        pizzaMargheritaPiccola.addTopping(mozzarella);
        return pizzaMargheritaPiccola;
    }
    public static Pizza creaPizzaMargheritaMedia(){
        Topping pomodoro = new Topping("Pomodoro", 10, 1.2);
        Topping mozzarella = new Topping("Mozzarella", 10, 1.2);
        Pizza pizzaMargheritaPiccola = new Pizza();
        pizzaMargheritaPiccola.setName("Margherita media");
        pizzaMargheritaPiccola.setPizzaSize(Pizza.PIZZASIZE.MEDIO);
        pizzaMargheritaPiccola.setCalories(500);
        pizzaMargheritaPiccola.setPrice(5.0);
        pizzaMargheritaPiccola.addTopping(pomodoro);
        pizzaMargheritaPiccola.addTopping(mozzarella);
        return pizzaMargheritaPiccola;
    }
    public static Pizza creaPizzaMargheritaGrande(){
        Topping pomodoro = new Topping("Pomodoro", 10, 1.2);
        Topping mozzarella = new Topping("Mozzarella", 10, 1.2);
        Pizza pizzaMargheritaPiccola = new Pizza();
        pizzaMargheritaPiccola.setName("Margherita Grande");
        pizzaMargheritaPiccola.setPizzaSize(Pizza.PIZZASIZE.GRANDE);
        pizzaMargheritaPiccola.setCalories(700);
        pizzaMargheritaPiccola.setPrice(7.5);
        pizzaMargheritaPiccola.addTopping(pomodoro);
        pizzaMargheritaPiccola.addTopping(mozzarella);
        return pizzaMargheritaPiccola;
    }
}
