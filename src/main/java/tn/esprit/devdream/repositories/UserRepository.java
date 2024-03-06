package tn.esprit.devdream.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.devdream.entities.User;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository <User, Integer>{
    Optional<User> findByEmail(String email);
    User findUserByIdentifiant(String Identifiant);

}
