package konstantinesoft.d4w1u5.entities;

import konstantinesoft.d4w1u5.Menu;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;

@Configuration
@PropertySource("application.properties")
public class MenuConfig {

    @Bean
    public Topping pomodoro() {
        return new Menu().creaPomodoro();
    }

    @Bean
    public Topping mozzarella() {
        return Menu.creaMozzarella();
    }

    @Bean
    public Topping cipolla() {
        return Menu.creaCipolla();
    }


    @Bean
    public Topping ananas() {
        return Menu.creaAnanas();
    }

    @Bean
    public Topping prosciutto() {
        return Menu.creaProsciutto();
    }

    @Bean
    public Topping salame() {
        return Menu.creaSalame();
    }


    @Bean
    public Topping ventricinaPiccante() {
        return new Topping("Ventricina", 86, 0.99);
    }


    @Bean
    public Topping extraMozzarella() {
        return new Topping("Extra Mozzarella", 0.92, 0.69);
    }

    @Bean
    public Pizza pizzaMargheritaPiccola() {
        return Menu.creaPizzaMargheritaPiccola();
    }

    @Bean
    public Pizza pizzaMargheritaGrande() {
        return Menu.creaPizzaMargheritaGrande();
    }

    @Bean
    public Pizza pizzaHawaii() {
        return Menu.creaPizzaHawaiiMedia();
    }

    @Bean
    public Pizza pizzaSalame() {
        return Menu.creaPizzaSalameMedia();
    }

    @Bean
    public Pizza pizzaDiavola() { //VINCENZO'S FAVOURITE
        return Menu.creaPizzaDiavolaMedia();
    }

    @Bean
    public Drink limonata03() {
        return Menu.creaLimonata03();
    }

    @Bean
    public Drink acqua() {
        return Menu.creaAcqua05();
    }

    @Bean
    public Drink vino() {
        return Menu.creaVino();
    }

    @Bean
    public Ordine ordine1(){
        Ordine ordine = new Ordine();
        ordine.addAlimento(pizzaMargheritaPiccola());
        ordine.addAlimento(pizzaSalame());
        ordine.addAlimento(limonata03());
        ordine.addAlimento(acqua());
        return ordine;
    }
    @Bean
    public Ordine ordine2(){
        Ordine ordine = new Ordine();
        ordine.addAlimento(pizzaDiavola());
        ordine.addAlimento(pizzaHawaii());
        ordine.addAlimento(pizzaMargheritaGrande());
        ordine.addAlimento(pizzaMargheritaGrande());
        ordine.addAlimento(vino());
        return ordine;
    }


}
