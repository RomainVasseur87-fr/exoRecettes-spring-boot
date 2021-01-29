package exorecettes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import exorecettes.models.Ingredient;
import exorecettes.repositories.IngredientsRepository;

@Service
public class IngredientService {

	@Autowired
	private IngredientsRepository repository;

	public List<Ingredient> getAll() {
		return this.repository.findAll();
	}

	public Ingredient findById(String id) {
		// return un optional (on est pas sure de trouver un User)
		return this.repository.findById(id)
				// sinon on demande de lancer
				.orElseThrow(
						// une fonction lambda
						// qui retourn une execption HTTP
						() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	public Ingredient findByNom(@PathVariable String nom) {
		return this.repository.findByNomAllIgnoreCase(nom);
	}

	public Ingredient create(Ingredient ingredient) {
		return this.repository.insert(ingredient);
	}

	public Ingredient update(Ingredient ingredient) {
		return this.repository.save(ingredient);
	}

	public void delete(String nom) {
		this.repository.delete(this.repository.findByNomAllIgnoreCase(nom));
	}

}
