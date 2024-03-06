package tn.esprit.devdream.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.devdream.entities.Etiquette;

@Repository
public interface IEtiquetteRepository extends JpaRepository<Etiquette, Long> {
}
