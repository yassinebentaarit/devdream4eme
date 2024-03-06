package tn.esprit.devdream.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.devdream.entities.OCTeam;
import tn.esprit.devdream.entities.SessionEvent;
import tn.esprit.devdream.entities.Event;
import org.springframework.data.repository.query.Param;

import java.util.Set;

@Repository
public interface SessionEventRepository extends CrudRepository <SessionEvent, Integer>{
    @Query("SELECT se FROM SessionEvent se JOIN se.event e WHERE e = :event")
    Set<SessionEvent> findSessionEventByEvent(@Param("event") Event event);
}
