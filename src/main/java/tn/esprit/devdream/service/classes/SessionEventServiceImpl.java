package tn.esprit.devdream.service.classes;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.devdream.entities.Event;
import tn.esprit.devdream.entities.OCTeam;
import tn.esprit.devdream.entities.SessionEvent;
import tn.esprit.devdream.repositories.EventRepository;
import tn.esprit.devdream.repositories.SessionEventRepository;
import tn.esprit.devdream.service.interfaces.ISessionEventService;

import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
public class SessionEventServiceImpl implements ISessionEventService
{
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    SessionEventRepository sessionEventRep;
    @Override
    public SessionEvent addSessionEvent(SessionEvent e,Long eventId) {
        Optional<Event> optionalEvent = eventRepository.findById(eventId.intValue());

        if (optionalEvent.isPresent()) {
            Event event = optionalEvent.get();
            // Set the Event for the Logistiques entity
            e.setEvent(event);
            // Save the Logistiques entity
            sessionEventRep.save(e);
            return e;
        } else {
            throw new EntityNotFoundException("Event not found with id: " + eventId);
        }

    }
    @Override
public SessionEvent showSessionEvent(int e) {
    return sessionEventRep.findById(e).orElse(null);
}

    @Override
    public SessionEvent updateSessionEvent(SessionEvent se) {
        // Validate that eventEnd is after eventStart
            // Retrieve the existing event from the database
            SessionEvent existingSessionEvent = sessionEventRep.findById(Math.toIntExact(se.getIdSessionEvent())).orElse(null);
            if (existingSessionEvent != null) {

                // Update the fields of the existing event
                existingSessionEvent.setSessionStarting(se.getSessionStarting());
                existingSessionEvent.setSessionEnd(se.getSessionEnd());
                existingSessionEvent.setSessionName(se.getSessionName());
                // Save the updated event to the database
                return sessionEventRep.save(existingSessionEvent);
            } else {
                // If the event does not exist, you can throw an exception or handle it in any other appropriate way
                throw new IllegalArgumentException("Event not found");
            }
    }
//    @Override
//    public OCTeam updateOCTeam(OCTeam e) {
//        // Validate that eventEnd is after eventStart
//        // Retrieve the existing event from the database
//        OCTeam existingOCTeam = oCTeamRep.findById(Math.toIntExact(e.getId_OC())).orElse(null);
//        if (existingOCTeam != null) {
//            // Update the fields of the existing OCTeam
//            existingOCTeam.setOCnames(e.getOCnames());
//            existingOCTeam.setOCRole(e.getOCRole());
//            // Save the updated OCTeam to the database
//            return oCTeamRep.save(existingOCTeam);
//        } else {
//            // If the event does not exist, you can throw an exception or handle it in any other appropriate way
//            throw new IllegalArgumentException("OCTeam not found");
//        }
//    }

    @Override
    public SessionEvent deleteSessionEvent(int SessionEventId) {
        // Check if the event exists
        try{
            Optional<SessionEvent> optionalEvent = sessionEventRep.findById(SessionEventId);
            // If the event exists, retrieve it
            SessionEvent oCTeamToDelete = optionalEvent.get();
            // Delete the event by its ID
            sessionEventRep.deleteById(SessionEventId);
            // Return the deleted event
            return oCTeamToDelete;
        } catch(Exception e) {
            // If the event does not exist, throw an exception or handle it in any other appropriate way
            throw new IllegalArgumentException("OCTeam not found");
        }
    }

    @Override
    public Set<SessionEvent> findAllSessionEventByEventId(int eventId){// Fetch the Event object based on the eventId
        Event event = eventRepository.findById(eventId).orElseThrow();
        return sessionEventRep.findSessionEventByEvent(event);
    }
}
