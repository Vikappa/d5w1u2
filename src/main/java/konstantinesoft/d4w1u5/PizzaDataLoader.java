package konstantinesoft.d4w1u5;

import konstantinesoft.d4w1u5.DAO.TavoloRepository;
import konstantinesoft.d4w1u5.entities.MenuConfig;
import konstantinesoft.d4w1u5.entities.Ordine;
import konstantinesoft.d4w1u5.entities.Tavolo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PizzaDataLoader {

    private static final Logger logger = LogManager.getLogger(PizzaDataLoader.class);

    @Autowired
    private MenuConfig menuConfig;

    @Bean
    CommandLineRunner initDatabase(TavoloRepository tavoloRepository) {
        return args -> {

            Ordine ordine1 = menuConfig.ordine1();
            Ordine ordine2 = menuConfig.ordine2();

            // Assegnazione degli ordini ai tavoli, se non hanno già ordini
            assignOrderToTableIfEmpty(tavoloRepository, 1L, ordine1);
            assignOrderToTableIfEmpty(tavoloRepository, 2L, ordine2);

            // Println delle pizze caricate
            logger.info("----------------------------------------------------------------------------------");
            logger.info("Loaded Orders:");
        };
    }

    private void assignOrderToTableIfEmpty(TavoloRepository tavoloRepository, Long tavoloId, Ordine ordine) {
        Tavolo tavolo = tavoloRepository.findById(tavoloId).orElseThrow(() -> new RuntimeException("Tavolo " + tavoloId + " non trovato"));
        if (tavolo.getOrdini().isEmpty()) {
            tavolo.addOrdine(ordine);
            tavoloRepository.save(tavolo);
            logger.info("Ordine assegnato al tavolo " + tavoloId);
        } else {
            logger.info("Il tavolo " + tavoloId + " ha già degli ordini. Nessun nuovo ordine aggiunto.");
        }
    }

    

}
