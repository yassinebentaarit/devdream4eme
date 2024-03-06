package tn.esprit.devdream.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.devdream.entities.Event;
import tn.esprit.devdream.entities.OCTeam;

import java.util.List;
import java.util.Set;

@Repository
public interface OCTeamRepository extends CrudRepository <OCTeam, Integer>{
    @Query("SELECT oct FROM OCTeam oct JOIN oct.event e WHERE e = :event")
    Set<OCTeam> findOCTeamsByEvent(@Param("event") Event event);
}
