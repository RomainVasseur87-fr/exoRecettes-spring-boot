package exorecettes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import exorecettes.models.Categorie;
import exorecettes.repositories.CategoriesRepository;

@Service
public class CategorieService {

	@Autowired
	private CategoriesRepository repository;

	public List<Categorie> getAll() {
		return this.repository.findAll();
	}

	public Categorie findById(String id) {
		// return un optional (on est pas sure de trouver un User)
		return this.repository.findById(id)
				// sinon on demande de lancer
				.orElseThrow(
						// une fonction lambda
						// qui retourn une execption HTTP
						() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	public Categorie findByNom(@PathVariable String nom) {
		return this.repository.findByNomAllIgnoreCase(nom);
	}

	public Categorie create(Categorie categorie) {
		return this.repository.insert(categorie);
	}

	public Categorie update(Categorie categorie) {
		return this.repository.save(categorie);
	}

	public void delete(String nom) {
		this.repository.delete(this.repository.findByNomAllIgnoreCase(nom));
	}

}
