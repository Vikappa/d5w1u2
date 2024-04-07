package konstantinesoft.d4w1u5.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import konstantinesoft.d4w1u5.entities.Alimento;

@Repository
public interface AlimentoRepository extends JpaRepository<Alimento, Long> {
}

