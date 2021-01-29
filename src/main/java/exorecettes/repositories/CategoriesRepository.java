package exorecettes.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import exorecettes.models.Categorie;

@Repository
public interface CategoriesRepository extends MongoRepository<Categorie, String> {

	Categorie findByNomAllIgnoreCase(String nom);

}
