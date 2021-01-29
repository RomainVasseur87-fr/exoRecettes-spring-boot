package exorecettes.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import exorecettes.models.Ingredient;
import exorecettes.models.Recette;
import exorecettes.services.RecetteService;


@RestController
@RequestMapping("recettes") // localhost:8080/recettes
public class RecetteController {

	@Autowired
	private RecetteService service;

	@GetMapping() // localhost:8080/recettes---->get
	@ResponseStatus(code = HttpStatus.OK)
	public List<Recette> findAll() {
		return this.service.getAll();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Recette findById(@PathVariable String id) {
		return this.service.findById(id);

	}
	
	@GetMapping("/nom/{nom}") // localhost:8080/recettes/nom/un nom de recette--->get
	@ResponseStatus(code = HttpStatus.OK)
	public List<Recette> findByNom(@PathVariable String nom) {
		return this.service.findByNom(nom);
	}
	
	@GetMapping("/categorie/{categorie}") // localhost:8080/recettes/categorie/une categorie--->get
	@ResponseStatus(code = HttpStatus.OK)
	public List<Recette> findByCategorie(@PathVariable String categorie) {
		List<Recette> recettes = this.service.getAll();
		// to do
		return this.service.findByCategorie(categorie);
	}

	@PostMapping() // localhost:8080/recettes----> post
	@ResponseStatus(code = HttpStatus.CREATED)
	public Recette create(@RequestBody Recette recette) {
		return this.service.create(recette);

	}

	@PutMapping("/{id}") // localhost:8080/recettes/id de recette---->put
	@ResponseStatus(code = HttpStatus.OK)
	public Recette update(@PathVariable String id, @RequestBody Recette recette) {
		Recette oldrecette = this.service.findById(id);
		recette.setId(oldrecette.getId());
		return this.service.update(recette);

	}

	@DeleteMapping("/{id}") // localhost:8080/recettes/id de recette---->delete
	@ResponseStatus(code = HttpStatus.OK)
	public void delete(@PathVariable String id) {
		this.service.delete(id);
	}
	
	//localhost:8080/recettes/un-id-recette/ajouteringredients----->put
	@PutMapping("/{id}/ajouteringredient")
	@ResponseStatus(code = HttpStatus.OK)
	public Recette ajoutVoitureListe(@PathVariable String id, @RequestBody List<Ingredient> ingredients) {
		Recette recette = this.service.findById(id);
		return this.service.ajouterIngredientsListe(recette, ingredients);
	}

}
