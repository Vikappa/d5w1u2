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

            Pizza pizza1 = Menu.creaPizzaMargheritaPiccola();
            Pizza pizza2 = Menu.creaPizzaMargheritaMedia();
            Pizza pizza3 = Menu.creaPizzaMargheritaGrande();


            repository.save(pizza1);
            repository.save(pizza2);
            repository.save(pizza3);

            logger.info("Loaded Pizzas:");
            repository.findAll().forEach(pizza -> logger.info(pizza.getName() + ", " + pizza.getSize()));
        };
    }
}
