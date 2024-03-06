package tn.esprit.devdream.service.classes;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.devdream.entities.Application;
import tn.esprit.devdream.entities.Depot;
import tn.esprit.devdream.entities.Etat;
import tn.esprit.devdream.entities.Stage;
import tn.esprit.devdream.repositories.ApplicationRepository;
import tn.esprit.devdream.repositories.DepotRepository;
import tn.esprit.devdream.repositories.StageRepository;
import tn.esprit.devdream.service.interfaces.IApplicationService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ApplicationServiceImpl  implements IApplicationService {
    @Autowired
    ApplicationRepository applicationRepository;
    @Autowired
    StageRepository stageRepository;
    @Autowired
    DepotRepository depotRepository;

    @Override
    public List<Application> retrieveAllApplications() {

        return applicationRepository.findAll();
    }

    @Override
    public Application retrieveApplication(Long id) {
        return applicationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Application not found with id: " + id));
    }

    @Override
    public Application addApplication(Application c) {







        c.setEtat(Etat.Encours);

        return applicationRepository.save(c);
    }

    @Override
    public void removeApplication(Long id) {
        applicationRepository.deleteById(id);
    }

    @Override
    public Application modifyApplication(Application application) {
        Optional<Application> existingApplication = applicationRepository.findById(application.getId_application());
        if (existingApplication.isPresent()) {
            return applicationRepository.save(application);
        } else {
            throw new EntityNotFoundException("Application not found with id: " + application.getId_application());
        }
    }

    @Override
    public Depot applicationaccept(Application c) {
        c.setEtat(Etat.Accepte);
        Depot depot = new Depot();
        Stage stage = new Stage();

        stage.setOffre(c.getOffre());
        stage.setStagiere(c.getEtudiant());
        //stage.setMaitrestage(c.getOffre().getCreator());
        stage.setStagiere(c.getEtudiant());

        // Set the stage before saving the depot
        depot.setStage(stage);
        depot.setEtudiant(c.getEtudiant());

        // Save the stage first
        stage = stageRepository.save(stage);

        // Then save the depot
        depot = depotRepository.save(depot);

        // Save the application
        c = applicationRepository.save(c);

        return depot;
    }

    @Override
    public void applicationrefuser(Application c) {
        c.setEtat(Etat.Refuse);
        c = applicationRepository.save(c);

    }


}