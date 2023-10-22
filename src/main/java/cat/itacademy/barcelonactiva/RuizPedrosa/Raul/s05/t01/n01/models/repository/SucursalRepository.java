package cat.itacademy.barcelonactiva.RuizPedrosa.Raul.s05.t01.n01.models.repository;

import cat.itacademy.barcelonactiva.RuizPedrosa.Raul.s05.t01.n01.models.domain.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Integer> {
}
