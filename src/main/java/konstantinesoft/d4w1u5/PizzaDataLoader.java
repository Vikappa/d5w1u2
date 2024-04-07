package konstantinesoft.d4w1u5;
import konstantinesoft.d4w1u5.DAO.AlimentoRepository;
import konstantinesoft.d4w1u5.entities.Drink;
import konstantinesoft.d4w1u5.entities.Pizza;
import konstantinesoft.d4w1u5.entities.Topping;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class PizzaDataLoader {

    private static final Logger logger = LogManager.getLogger(PizzaDataLoader.class);

    @Bean
    CommandLineRunner initDatabase(AlimentoRepository foodRepository) {
        return args -> {

            Pizza pizza1 = Menu.creaPizzaMargheritaPiccola();
            Pizza pizza2 = Menu.creaPizzaDiavolaGrande();
            Pizza pizza3 = Menu.creaPizzaHawaiiMedia();
            Topping topping1 = Menu.creaMozzarella();
            Topping topping2 = Menu.creaCipolla();
            Drink drink = Menu.creaVino();


            foodRepository.save(pizza1);
            foodRepository.save(pizza2);
            foodRepository.save(pizza3);
            foodRepository.save(topping1);
            foodRepository.save(topping2);
            foodRepository.save(drink);




            logger.info("------------------------------------------------------------------------");
            logger.info("Loaded Pizzas:");
            foodRepository.findAll().forEach(pizza -> logger.info(pizza.toString()));
        };
    }
}
