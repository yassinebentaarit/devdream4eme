package tn.esprit.devdream.service.interfaces;

import tn.esprit.devdream.entities.Logistiques;
import tn.esprit.devdream.entities.OCTeam;

import java.util.List;
import java.util.Set;

public interface IOCTeamService {
    public OCTeam addOCTeam(OCTeam e,Long eventId);
    public OCTeam showOCTeam(int e) ;
    public OCTeam updateOCTeam(OCTeam e);
    public OCTeam deleteOCTeam(int e);
    public Set<OCTeam> findAllOCTeamsByEventId(int e);

}
