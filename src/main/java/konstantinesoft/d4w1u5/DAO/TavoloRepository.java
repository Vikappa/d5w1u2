package konstantinesoft.d4w1u5.DAO;
import konstantinesoft.d4w1u5.entities.Tavolo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TavoloRepository extends JpaRepository<Tavolo, Long> {
    // Trova tutti i tavoli con un certo numero di posti a sedere
    List<Tavolo> findByNumberOfSeats(int numberOfSeats);

    // Trova tutti i tavoli che hanno almeno un ordine associato
    @Query("SELECT t FROM Tavolo t JOIN t.ordini o")
    List<Tavolo> findTavoliWithOrders();

    // Trova tutti i tavoli con ordini che contengono un certo alimento
    @Query("SELECT DISTINCT t FROM Tavolo t JOIN t.ordini o JOIN o.alimenti a WHERE a.name = :alimentoName")
    List<Tavolo> findByOrdineContainingAlimento(@Param("alimentoName") String alimentoName);

    // Conta quanti ordini ci sono per un certo tavolo
    @Query("SELECT COUNT(o) FROM Tavolo t JOIN t.ordini o WHERE t.id = :tavoloId")
    Long countOrdiniByTavoloId(@Param("tavoloId") Long tavoloId);

    // Trova tutti i tavoli che non hanno ordini
    @Query("SELECT t FROM Tavolo t WHERE t.ordini IS EMPTY")
    List<Tavolo> findTavoliWithoutOrders();
}
