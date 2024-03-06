package tn.esprit.devdream.service.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.devdream.entities.User;
import tn.esprit.devdream.repositories.UserRepository;
import tn.esprit.devdream.repositories.IUserRepository;
import tn.esprit.devdream.service.interfaces.IUserService;


import java.util.List;

@Service
public class UserServices implements IUserService {
    @Autowired
    UserRepository userrepo ;
    @Autowired
    IUserRepository iUserRepository;



    @Override
    public List<User> retrieveAllUsers() {
        return (List<User>) userrepo.findAll();
    }

    @Override
    public User retrieveUser(Long iduser) {
        return userrepo.findById(iduser.intValue()).get();
    }

    @Override
    public User addUser(User user) {
        return  userrepo.save(user);
    }

    @Override
    public void removeUser(Long iduser) {
   userrepo.deleteById(iduser.intValue());

    }

    @Override
    public User modifyUser(User user) {
        return  userrepo.save(user);
    }
    @Override
    public User findById(Long id) {
        return iUserRepository.findById(id).orElse(null);
    }
}

