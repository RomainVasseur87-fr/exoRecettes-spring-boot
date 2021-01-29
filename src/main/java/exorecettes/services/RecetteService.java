package exorecettes.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import exorecettes.models.Recette;
import exorecettes.repositories.RecetteRepository;

@Service
public class RecetteService {

	@Autowired
	private RecetteRepository repository;

	public List<Recette> getAll() {
		return this.repository.findAll();
	}

	public Recette findById(String id) {
		// return un optional (on est pas sure de trouver un User)
		return this.repository.findById(id)
				// sinon on demande de lancer
				.orElseThrow(
						// une fonction lambda
						// qui retourn une execption HTTP
						() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	public Recette findByNom(@PathVariable String nom) {
		return this.repository.findByNomAllIgnoreCase(nom);
	}
	public List<Recette> findByCategorie(@PathVariable String categorie) {
		// to do
		return this.repository.findByCategorieAllIgnoreCase(categorie);
	}

	public Recette create(Recette recette) {
		return this.repository.insert(recette);
	}

	public Recette update(Recette recette) {
		return this.repository.save(recette);
	}

	public void delete(String nom) {
		this.repository.delete(this.repository.findByNomAllIgnoreCase(nom));
	}

}
