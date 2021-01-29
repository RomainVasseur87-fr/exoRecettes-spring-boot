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
import exorecettes.services.IngredientService;

@RestController
@RequestMapping("ingredients") // localhost:8080/ingredients
public class IngredientController {

	@Autowired
	private IngredientService service;

	@GetMapping() // localhost:8080/ingredients---->get
	@ResponseStatus(code = HttpStatus.OK)
	public List<Ingredient> findAll() {
		return this.service.getAll();
	}

	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Ingredient findById(@PathVariable String id) {
		return this.service.findById(id);

	}

	@GetMapping("/{nom}") // localhost:8080/ingredients/un nom d'ingredient--->get
	@ResponseStatus(code = HttpStatus.OK)
	public Ingredient findByNom(@PathVariable String nom) {
		return this.service.findByNom(nom);
	}

	@PostMapping() // localhost:8080/ingredients----> post
	@ResponseStatus(code = HttpStatus.CREATED)
	public Ingredient create(@RequestBody Ingredient ingredient) {
		return this.service.create(ingredient);

	}

	@PutMapping("/{id}") // localhost:8080/ingredients/un nom d'ingredient---->put
	@ResponseStatus(code = HttpStatus.OK)
	public Ingredient update(@PathVariable String id, @RequestBody Ingredient ingredient) {
		Ingredient oldIngredient = this.service.findById(id);
		ingredient.setNom(oldIngredient.getId());
		return this.service.update(ingredient);

	}

	@DeleteMapping("/{id}") // localhost:8080/ingredients/id de categories---->delete
	@ResponseStatus(code = HttpStatus.OK)
	public void delete(@PathVariable String id) {
		this.service.deleteById(id);
	}

}
