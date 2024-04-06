package konstantinesoft.d4w1u5;
import konstantinesoft.d4w1u5.DAO.PizzaRepository;
import konstantinesoft.d4w1u5.entities.Pizza;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class PizzaDataLoader {

    private static final Logger logger = LogManager.getLogger(PizzaDataLoader.class);

    @Bean
    CommandLineRunner initDatabase(PizzaRepository repository) {
        return args -> {
            logger.info("Preloading " + repository.save(new Pizza("Margherita", "Medium")));
            logger.info("Preloading " + repository.save(new Pizza("Pepperoni", "Large")));

            logger.info("Loaded Pizzas:");
            repository.findAll().forEach(pizza -> logger.info(pizza.getName() + ", " + pizza.getSize()));
        };
    }
}
