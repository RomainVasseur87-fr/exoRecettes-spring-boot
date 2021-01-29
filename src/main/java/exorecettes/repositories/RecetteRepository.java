package exorecettes.repositories;



import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import exorecettes.models.Recette;

@Repository
public interface RecetteRepository extends MongoRepository<Recette, String>{

	public Recette findByNomAllIgnoreCase(String nom);

	public List<Recette> findByCategorieAllIgnoreCase(String categorie);

}
