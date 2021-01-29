package exorecettes.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document("ingredient")
public class Ingredient {
	
	private String nom;
	private List<Ingredient> ingredients;
	private List<Categorie> categorie;
	private String description;
	
	public Ingredient() {
	}
	
	@Autowired
	public Ingredient(String nom, List<Ingredient> ingredients, List<Categorie> categorie, String description) {
		this.nom = nom;
		this.ingredients = ingredients;
		this.categorie = categorie;
		this.description = description;
	}
	
	

}
