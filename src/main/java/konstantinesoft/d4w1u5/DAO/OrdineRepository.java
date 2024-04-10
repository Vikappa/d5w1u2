package konstantinesoft.d4w1u5.DAO;
import konstantinesoft.d4w1u5.entities.Ordine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdineRepository extends JpaRepository<Ordine, Long> {

    @Query("SELECT o FROM Ordine o JOIN FETCH o.alimenti JOIN FETCH o.tavolo")
    List<Ordine> findAllWithAlimentiAndTavolo();
}

