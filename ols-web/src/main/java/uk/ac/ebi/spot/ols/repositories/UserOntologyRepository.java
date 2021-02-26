package uk.ac.ebi.spot.ols.repositories;

import uk.ac.ebi.spot.ols.entities.UserOntology;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserOntologyRepository extends CrudRepository<UserOntology, Long> {
    
    List<UserOntology> findByName(String name);
    
}