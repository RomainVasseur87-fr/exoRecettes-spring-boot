package exorecettes.repositories;



import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import exorecettes.models.Categorie;
import exorecettes.models.Recette;

@Repository
public interface RecetteRepository extends MongoRepository<Recette, String>{

	public List<Recette> findByNomAllIgnoreCase(String nom);

	//public List<Recette> findByCategoriesAllIgnoreCase(String categorie);
	
	public List<Recette> findByCategories(Categorie categorie);

}
