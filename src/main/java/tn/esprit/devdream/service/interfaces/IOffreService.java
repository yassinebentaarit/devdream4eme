package tn.esprit.devdream.service.interfaces;

import tn.esprit.devdream.entities.Application;
import tn.esprit.devdream.entities.Offre;
import tn.esprit.devdream.entities.User;

import java.util.List;

public interface IOffreService {
    public List<Offre> retrieveAllOffres();
    public Offre retrieveOffre(Long id);
    public Offre addOffre(Offre c);
    public void removeOffre(Long id);
    public Offre modifyOffre(Offre Offre);

    public Application applytooffer(Offre offre);
//
//    List<Offre> searchOffers(String keywords);

    List<User> getEtudiantsparoffre(Long  id_offre);

    void accepterEtudiant(Long  id_offre, Long id);
}