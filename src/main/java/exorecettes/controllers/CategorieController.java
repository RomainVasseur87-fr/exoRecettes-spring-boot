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
import exorecettes.models.Categorie;
import exorecettes.services.CategorieService;

@RestController
@RequestMapping("categories") // localhost:8080/categories
public class CategorieController {

	@Autowired
	private CategorieService service;

	@GetMapping() // localhost:8080/categories---->get
	@ResponseStatus(code = HttpStatus.OK)
	public List<Categorie> findAll() {
		return this.service.getAll();
	}

	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Categorie findById(@PathVariable String id) {
		return this.service.findById(id);

	}

	@GetMapping("/{nom}") // localhost:8080/categories/un nom de categorie--->get
	@ResponseStatus(code = HttpStatus.OK)
	public Categorie findByNom(@PathVariable String nom) {
		return this.service.findByNom(nom);
	}

	@PostMapping() // localhost:8080/categories----> post
	@ResponseStatus(code = HttpStatus.CREATED)
	public Categorie create(@RequestBody Categorie categorie) {
		return this.service.create(categorie);

	}

	@PutMapping("/{nom}") // localhost:8080/recettes/un nom de categories---->put
	@ResponseStatus(code = HttpStatus.OK)
	public Categorie update(@PathVariable String nom, @RequestBody Categorie categorie) {
		Categorie oldcategorie = this.service.findByNom(nom);
		categorie.setNom(oldcategorie.getNom());
		return this.service.update(categorie);

	}

	@DeleteMapping("/{nom}") // localhost:8080/categories/un nom de categories---->delete
	@ResponseStatus(code = HttpStatus.OK)
	public void delete(@PathVariable String nom) {
		this.service.delete(nom);
	}

}
