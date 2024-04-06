package konstantinesoft.d4w1u5.DAO;

import konstantinesoft.d4w1u5.entities.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkRepository extends JpaRepository<Drink, Long> {
}