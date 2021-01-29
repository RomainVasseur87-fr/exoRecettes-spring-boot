package exorecettes.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import exorecettes.models.Ingredient;

@Repository
public interface IngredientsRepository extends MongoRepository<Ingredient, String> {

	Ingredient findByNomAllIgnoreCase(String nom);

}
