package tn.esprit.devdream.service.classes;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.devdream.entities.Questionnaire;
import tn.esprit.devdream.repositories.IQuestionnaireRepository;
import tn.esprit.devdream.service.interfaces.IQuestionnaireService;

import java.util.List;


@Service
@AllArgsConstructor
public class QuestionnaireServiceImpl implements IQuestionnaireService {

    IQuestionnaireRepository iQuestionnaireRepository;
    @Override
    public Questionnaire addQuestionnaire (Questionnaire q) {
        return iQuestionnaireRepository.save(q);
    }

    @Override
    public Questionnaire modifyQuestionnaire(Questionnaire questionnaire) {
            return iQuestionnaireRepository.save(questionnaire);
    }
    @Override
    public List<Questionnaire> retrieveAllQuestionnaire() {

        return iQuestionnaireRepository.findAll();
    }
    @Override
    public Questionnaire retrieveQuestionnaire(Long idQuestionnaire) {
        return iQuestionnaireRepository.findById(idQuestionnaire).get();
    }
    @Override
    public void removeQuestionnaire(Long idQuestionnaire) {
        iQuestionnaireRepository.deleteById(idQuestionnaire);

    }


}
