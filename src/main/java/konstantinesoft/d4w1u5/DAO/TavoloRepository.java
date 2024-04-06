package konstantinesoft.d4w1u5.DAO;
import konstantinesoft.d4w1u5.entities.Tavolo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TavoloRepository extends JpaRepository<Tavolo, Long> {
}
