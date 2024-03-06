package tn.esprit.devdream.service.interfaces;

import tn.esprit.devdream.entities.OCTeam;
import tn.esprit.devdream.entities.SessionEvent;

import java.util.Set;

public interface ISessionEventService {
    public SessionEvent addSessionEvent(SessionEvent s,Long eventId);
    public SessionEvent showSessionEvent(int e) ;
    public SessionEvent updateSessionEvent(SessionEvent e);
    public SessionEvent deleteSessionEvent(int e);
    public Set<SessionEvent> findAllSessionEventByEventId(int e);

}
