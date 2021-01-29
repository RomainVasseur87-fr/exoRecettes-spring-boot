package exorecettes.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import org.springframework.web.server.ResponseStatusException;

import exorecettes.models.Categorie;
import exorecettes.models.Ingredient;
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

	public List<Recette> findByNom(String nom) {
		return this.repository.findByNomAllIgnoreCase(nom);
	}

	public List<Recette> findByCategorie(Categorie categorie) {
		return this.repository.findByCategories(categorie);
	}

	public Recette create(Recette recette) {
		return this.repository.insert(recette);
	}

	public Recette update(Recette recette) {
		return this.repository.save(recette);
	}

	public void delete(String id) {
		this.repository.deleteById(id);
	}

	public Recette ajouterIngredientsListe(Recette recette, List<Ingredient> ingredients) {
		// attention si il n'a pas de liste d'ingredient en creer une
		if (recette.getIngredients() == null) {
			List<Ingredient> listIngredients = new ArrayList<>();
			recette.setIngredients(listIngredients);
		}
		// ajout de la liste d'ingredient
		for (Ingredient ingredient : ingredients) {
			recette.getIngredients().add(ingredient);
		}
		// enregistrer la modification de la recette
		return this.repository.save(recette);
	}

	public Recette supprimerIngredientsListe(Recette recette, List<Ingredient> ingredients) {
		if (recette.getIngredients() == null) {
			List<Ingredient> listIngredients = new ArrayList<>();
			recette.setIngredients(listIngredients);
		}
		for (Ingredient ingredient : ingredients) {
			recette.getIngredients().remove(ingredient);
		}
		return this.repository.save(recette);
	}

	public Recette ajouterCategoriesListe(Recette recette, List<Categorie> categories) {
		// attention si il n'a pas de liste d'ingredient en creer une
		if (recette.getCategories() == null) {
			List<Categorie> listCategories = new ArrayList<>();
			recette.setCategories(listCategories);
		}
		// ajout de la liste d'ingredient
		recette.getCategories().addAll(categories);
		// enregistrer la modification de la recette
		return this.repository.save(recette);
	}

	public Recette supprimerCategoriesListe(Recette recette, List<Categorie> categories) {
		if (recette.getCategories() == null) {
			List<Categorie> listCategories = new ArrayList<>();
			recette.setCategories(listCategories);
		}
		for (Categorie categorie : categories) {
			recette.getCategories().remove(categorie);
		}
		return this.repository.save(recette);
	}

}
