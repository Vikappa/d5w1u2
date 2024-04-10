package konstantinesoft.d4w1u5;

import konstantinesoft.d4w1u5.DAO.OrdineRepository;
import konstantinesoft.d4w1u5.DAO.TavoloRepository;
import konstantinesoft.d4w1u5.entities.MenuConfig;
import konstantinesoft.d4w1u5.entities.Ordine;
import konstantinesoft.d4w1u5.entities.Tavolo;
import org.antlr.v4.runtime.tree.pattern.ParseTreePattern;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Scanner;

@Configuration
public class PizzaDataLoader {

    private static final Logger logger = LogManager.getLogger(PizzaDataLoader.class);

    @Autowired
    private MenuConfig menuConfig;


    @Value("${costo.coperto}")
    private double costoCoperto;
    @Bean
    CommandLineRunner initDatabase(TavoloRepository tavoloRepository, OrdineRepository ordineRepository) {
        return args -> {

            Ordine ordine1 = menuConfig.ordine1();
            Ordine ordine2 = menuConfig.ordine2();

            if (tavoloRepository.count() == 0) {
                // Se non esistono tavoli, crea e salva 5 nuovi tavoli
                    Tavolo tavolo1 = new Tavolo();
                    tavolo1.setNumberOfSeats(4);
                    Tavolo tavolo2 = new Tavolo();
                    tavolo2.setNumberOfSeats(5);
                    Tavolo tavolo3 = new Tavolo();
                    tavolo3.setNumberOfSeats(2);
                    Tavolo tavolo4 = new Tavolo();
                    tavolo4.setNumberOfSeats(6);
                    Tavolo tavolo5 = new Tavolo();
                    tavolo5.setNumberOfSeats(2);
                    tavoloRepository.save(tavolo1);
                    tavoloRepository.save(tavolo2);
                    tavoloRepository.save(tavolo3);
                    tavoloRepository.save(tavolo4);
                    tavoloRepository.save(tavolo5);

                logger.info("5 nuovi tavoli sono stati creati e salvati nel database.");
            }

            // Assegnazione degli ordini ai tavoli, se non hanno già ordini
            assignOrderToTableIfEmpty(tavoloRepository, 1L, ordine1);
            assignOrderToTableIfEmpty(tavoloRepository, 2L, ordine2);

            String green = "\033[32m";
            String reset = "\033[0m";

            logger.info("");
            logger.info("");

            String asciiArt =
                    "__________.__                           _____                       \n" +
                            "\\______   \\__|____________________     /     \\   ____   ____  __ __ \n" +
                            " |     ___/  \\___   /\\___   /\\__  \\   /  \\ /  \\_/ __ \\ /    \\|  |  \\\n" +
                            " |    |   |  |/    /  /    /  / __ \\_/    Y    \\  ___/|   |  \\  |  /\n" +
                            " |____|   |__/_____ \\/_____ \\(____  /\\____|__  /\\___  >___|  /____/ \n" +
                            "                   \\/      \\/     \\/         \\/     \\/     \\/       ";
            logger.info(green + asciiArt + reset);
            logger.info("");
            startRouting(tavoloRepository, ordineRepository);


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

    private void startRouting(TavoloRepository tavoloRepository, OrdineRepository ordiniRepository) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Seleziona un'opzione:");
                System.out.println("1: Visualizza tavoli");
                System.out.println("2: Visualizza ordini");
                System.out.println("3: Aggiungi un nuovo ordine");
                System.out.println("0: Esci");
                System.out.print("Inserisci la tua scelta: ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        visualizzaTavoli(tavoloRepository);
                        break;
                    case 2:
                        visualizzaOrdini(ordiniRepository);
                    break;
                    case 3:
                        System.out.println("Aggiunta di un nuovo ordine...");
                        break;
                    case 0:
                        System.out.println("Uscita...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Scelta non valida. Riprova.");
                }
            }
        }
    }

    private void visualizzaTavoli(TavoloRepository tavoloRepository) {
        List<Tavolo> tavoli = tavoloRepository.findAll();
        if (tavoli.isEmpty()) {
            System.out.println("Non ci sono tavoli disponibili.");
            return;
        }
        tavoli.forEach(tavolo -> {
            System.out.println("Tavolo ID: " + tavolo.getId() + ", Posti: " + tavolo.getNumberOfSeats());
            if (tavolo.getOrdini() != null && !tavolo.getOrdini().isEmpty()) {
                System.out.println("\tOrdini per questo tavolo:");
                tavolo.getOrdini().forEach(ordine -> System.out.println("\t\tOrdine ID: " + ordine.getId() + ", Stato: " + ordine.getStatoOrdine()));
            } else {
                System.out.println("\tNessun ordine per questo tavolo.");
            }
        });
    }
    private void visualizzaOrdini(OrdineRepository ordineRepository) {
        List<Ordine> ordini = ordineRepository.findAllWithAlimentiAndTavolo();
        if (ordini.isEmpty()) {
            System.out.println("Non ci sono ordini disponibili.");
        } else {
            ordini.forEach(ordine -> {
                System.out.println("Ordine ID: " + ordine.getId() + ", Stato: " + ordine.getStatoOrdine());
                System.out.println("\tTavolo ID: " + (ordine.getTavolo() != null ? ordine.getTavolo().getId() : "Non assegnato"));
                System.out.println("\tData e ora: " + ordine.getOrario_ricezione());
                System.out.println("\tAlimenti ordinati:");
                ordine.getAlimenti().forEach(alimento -> {
                    System.out.println("\t\t" + alimento.getName() + " - Prezzo: " + alimento.getPrice() + "€");
                });
                System.out.println("\tTotale ordine: " + ordine.getTavolo().calcolaConto(costoCoperto) + "€");
                System.out.println();
            });
        }
    }
}
