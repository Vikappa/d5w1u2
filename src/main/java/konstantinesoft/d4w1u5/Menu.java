package konstantinesoft.d4w1u5;
import konstantinesoft.d4w1u5.entities.Alimento;
import konstantinesoft.d4w1u5.entities.Drink;
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
        Topping pomodoro = new Topping("Pomodoro", 56, 1.2);
        Topping mozzarella = new Topping("Mozzarella", 92, 0.69);
        Pizza pizzaMargheritaPiccola = new Pizza();
        pizzaMargheritaPiccola.setName("Margherita piccola");
        pizzaMargheritaPiccola.setPizzaSize(Pizza.PIZZASIZE.PICCOLA);
        pizzaMargheritaPiccola.setBasePriceAndCalories();
        pizzaMargheritaPiccola.setCalories(200.0);
        pizzaMargheritaPiccola.setPrice(2.5);
        pizzaMargheritaPiccola.addTopping(pomodoro);
        pizzaMargheritaPiccola.addTopping(mozzarella);
        return pizzaMargheritaPiccola;
    }
    public static Pizza creaPizzaMargheritaMedia(){
        Topping pomodoro = new Topping("Pomodoro", 56, 1.2);
        Topping mozzarella = new Topping("Mozzarella", 92, 0.69);
        Pizza pizzaMargheritaMedia = new Pizza();
        pizzaMargheritaMedia.setName("Margherita media");
        pizzaMargheritaMedia.setPizzaSize(Pizza.PIZZASIZE.MEDIO);
        pizzaMargheritaMedia.setCalories(500.0);
        pizzaMargheritaMedia.setPrice(5.0);
        pizzaMargheritaMedia.addTopping(pomodoro);
        pizzaMargheritaMedia.addTopping(mozzarella);
        return pizzaMargheritaMedia;
    }
    public static Pizza creaPizzaMargheritaGrande(){
        Topping pomodoro = new Topping("Pomodoro", 56, 1.2);
        Topping mozzarella = new Topping("Mozzarella", 92, 0.69);
        Pizza pizzaMargheritaGrande = new Pizza();
        pizzaMargheritaGrande.setName("Margherita Grande");
        pizzaMargheritaGrande.setPizzaSize(Pizza.PIZZASIZE.GRANDE);
        pizzaMargheritaGrande.setCalories(700.0);
        pizzaMargheritaGrande.setPrice(7.5);
        pizzaMargheritaGrande.addTopping(pomodoro);
        pizzaMargheritaGrande.addTopping(mozzarella);
        return pizzaMargheritaGrande;
    }

    public static Pizza creaPizzaHawaiiPiccola() {
        Topping pomodoro = new Topping("Pomodoro", 56, 1.2);
        Topping mozzarella = new Topping("Mozzarella", 92, 0.69);
        Topping prosciutto = new Topping("Prosciutto", 56, 1.2);
        Topping ananas = new Topping("ananas", 110, 1.2);
        Pizza pizzaHawaiiPiccola = new Pizza();
        pizzaHawaiiPiccola.setName("Hawaii piccola");
        pizzaHawaiiPiccola.setPizzaSize(Pizza.PIZZASIZE.PICCOLA);
        pizzaHawaiiPiccola.setCalories(200.0);
        pizzaHawaiiPiccola.setPrice(2.5);
        pizzaHawaiiPiccola.addTopping(pomodoro);
        pizzaHawaiiPiccola.addTopping(mozzarella);
        pizzaHawaiiPiccola.addTopping(prosciutto);
        pizzaHawaiiPiccola.addTopping(ananas);
        return pizzaHawaiiPiccola;
    }


    public static Pizza creaPizzaHawaiiMedia() {
        Topping pomodoro = new Topping("Pomodoro", 56, 1.2);
        Topping mozzarella = new Topping("Mozzarella", 92, 0.69);
        Topping prosciutto = new Topping("Prosciutto", 56, 1.2);
        Topping ananas = new Topping("ananas", 110, 1.2);
        Pizza pizzaHawaiiPiccola = new Pizza();
        pizzaHawaiiPiccola.setName("Hawaii piccola");
        pizzaHawaiiPiccola.setPizzaSize(Pizza.PIZZASIZE.MEDIO);
        pizzaHawaiiPiccola.setCalories(500.0);
        pizzaHawaiiPiccola.setPrice(5);
        pizzaHawaiiPiccola.addTopping(pomodoro);
        pizzaHawaiiPiccola.addTopping(mozzarella);
        pizzaHawaiiPiccola.addTopping(prosciutto);
        pizzaHawaiiPiccola.addTopping(ananas);
        return pizzaHawaiiPiccola;
    }

    public static Pizza creaPizzaHawaiiGrande() {
        Topping pomodoro = new Topping("Pomodoro", 56, 1.2);
        Topping mozzarella = new Topping("Mozzarella", 92, 0.69);
        Topping prosciutto = new Topping("Prosciutto", 56, 1.2);
        Topping ananas = new Topping("ananas", 110, 1.2);
        Pizza pizzaHawaiiPiccola = new Pizza();
        pizzaHawaiiPiccola.setName("Hawaii piccola");
        pizzaHawaiiPiccola.setPizzaSize(Pizza.PIZZASIZE.GRANDE);
        pizzaHawaiiPiccola.setCalories(700);
        pizzaHawaiiPiccola.setPrice(7);
        pizzaHawaiiPiccola.addTopping(pomodoro);
        pizzaHawaiiPiccola.addTopping(mozzarella);
        pizzaHawaiiPiccola.addTopping(prosciutto);
        pizzaHawaiiPiccola.addTopping(ananas);
        return pizzaHawaiiPiccola;
    }

    public static Pizza creaPizzaSalamePiccola(){
        Topping pomodoro = new Topping("Pomodoro", 56, 1.2);
        Topping mozzarella = new Topping("Mozzarella", 92, 0.69);
        Topping Salame = new Topping("Salame", 86, 0.99);
        Pizza pizzaSalamePiccola = new Pizza();
        pizzaSalamePiccola.setName("Salame piccola");
        pizzaSalamePiccola.setPizzaSize(Pizza.PIZZASIZE.PICCOLA);
        pizzaSalamePiccola.setCalories(200.0);
        pizzaSalamePiccola.setPrice(2.5);
        pizzaSalamePiccola.addTopping(pomodoro);
        pizzaSalamePiccola.addTopping(mozzarella);
        pizzaSalamePiccola.addTopping(Salame);
        return pizzaSalamePiccola;
    }

    public static Pizza creaPizzaSalameMedia(){
        Topping pomodoro = new Topping("Pomodoro", 56, 1.2);
        Topping mozzarella = new Topping("Mozzarella", 92, 0.69);
        Topping Salame = new Topping("Salame", 86, 0.99);
        Pizza pizzaSalamePiccola = new Pizza();
        pizzaSalamePiccola.setName("Salame media");
        pizzaSalamePiccola.setPizzaSize(Pizza.PIZZASIZE.MEDIO);
        pizzaSalamePiccola.setCalories(500);
        pizzaSalamePiccola.setPrice(5);
        pizzaSalamePiccola.addTopping(pomodoro);
        pizzaSalamePiccola.addTopping(mozzarella);
        pizzaSalamePiccola.addTopping(Salame);
        return pizzaSalamePiccola;
    }
    public static Pizza creaPizzaSalameGrande(){
        Topping pomodoro = new Topping("Pomodoro", 56, 1.2);
        Topping mozzarella = new Topping("Mozzarella", 92, 0.69);
        Topping Salame = new Topping("Salame", 86, 0.99);
        Pizza pizzaSalamePiccola = new Pizza();
        pizzaSalamePiccola.setName("Salame grande");
        pizzaSalamePiccola.setPizzaSize(Pizza.PIZZASIZE.GRANDE);
        pizzaSalamePiccola.setCalories(700);
        pizzaSalamePiccola.setPrice(7.5);
        pizzaSalamePiccola.addTopping(pomodoro);
        pizzaSalamePiccola.addTopping(mozzarella);
        pizzaSalamePiccola.addTopping(Salame);
        return pizzaSalamePiccola;
    }

    public static Pizza creaPizzaDiavolaPiccola(){
        Topping pomodoro = new Topping("Pomodoro", 56, 1.2);
        Topping mozzarella = new Topping("Mozzarella", 92, 0.69);
        Topping Salame = new Topping("Ventricina", 86, 0.99);
        Pizza diavolaPiccola = new Pizza();
        diavolaPiccola.setName("Diavola piccola");
        diavolaPiccola.setPizzaSize(Pizza.PIZZASIZE.PICCOLA);
        diavolaPiccola.setCalories(200.0);
        diavolaPiccola.setPrice(2.5);
        diavolaPiccola.addTopping(pomodoro);
        diavolaPiccola.addTopping(mozzarella);
        diavolaPiccola.addTopping(Salame);
        return diavolaPiccola;
    }
    public static Pizza creaPizzaDiavolaMedia(){
        Topping pomodoro = new Topping("Pomodoro", 56, 1.2);
        Topping mozzarella = new Topping("Mozzarella", 92, 0.69);
        Topping Salame = new Topping("Ventricina", 86, 0.99);
        Pizza diavolaPiccola = new Pizza();
        diavolaPiccola.setName("Diavola media");
        diavolaPiccola.setPizzaSize(Pizza.PIZZASIZE.MEDIO);
        diavolaPiccola.setCalories(500);
        diavolaPiccola.setPrice(5);
        diavolaPiccola.addTopping(pomodoro);
        diavolaPiccola.addTopping(mozzarella);
        diavolaPiccola.addTopping(Salame);
        return diavolaPiccola;
    }

    public static Pizza creaPizzaDiavolaGrande(){
        Topping pomodoro = new Topping("Pomodoro", 56, 1.2);
        Topping mozzarella = new Topping("Mozzarella", 92, 0.69);
        Topping Salame = new Topping("Ventricina", 86, 0.99);
        Pizza diavolaPiccola = new Pizza();
        diavolaPiccola.setName("Diavola grande");
        diavolaPiccola.setPizzaSize(Pizza.PIZZASIZE.GRANDE);
        diavolaPiccola.setCalories(700);
        diavolaPiccola.setPrice(7.5);
        diavolaPiccola.addTopping(pomodoro);
        diavolaPiccola.addTopping(mozzarella);
        diavolaPiccola.addTopping(Salame);
        return diavolaPiccola;
    }

    public static Topping creaMozzarella(){
        return new Topping("Mozzarella", 92, 0.69);
    }


    public static Topping creaSalame() {
        return new Topping("Salame", 86, 0.99);
    }

    public static Topping creaProsciutto() {
        return new Topping("Prosciutto", 86, 0.99);
    }


    public static Topping creaAnanas() {
        return new Topping("Ananas", 110, 1.2);
    }

    public static Topping creaPomodoro() {
        return new Topping("Pomodoro", 56, 1.2);
    }

    public static Topping creaCipolla() {
        return new Topping("Cipolla", 22, 0.69);
    }

    public static Drink creaLimonata03(){
        Drink limonata = new Drink();
        limonata.setName("Limonata");
        limonata.setPrice(1.29);
        limonata.setCalories(100);
        limonata.setSize(0.3);
        return limonata;
    }

    public static Drink creaLimonata05() {
        Drink limonata = new Drink();
        limonata.setName("Limonata");
        limonata.setPrice(2.5);
        limonata.setCalories(100);
        limonata.setSize(0.5);
        return limonata;
    }

    public static Drink creaAcqua05(){
        Drink acqua = new Drink();
        acqua.setName("Acqua");
        acqua.setPrice(1);
        acqua.setCalories(0);
        acqua.setSize(0.5);
        return acqua;
    }

    public static Drink creaAcqua07(){
        Drink acqua = new Drink();
        acqua.setName("Acqua");
        acqua.setPrice(1.29);
        acqua.setCalories(0);
        acqua.setSize(0.7);
        return acqua;
    }

    public static Drink creaVino(){
        Drink vino = new Drink();
        vino.setName("Vino");
        vino.setPrice(7.49);
        vino.setCalories(607);
        vino.setSize(0.75);
        return vino;
    }
}
