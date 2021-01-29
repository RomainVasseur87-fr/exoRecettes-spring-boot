package exorecettes.models;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document("recette")
public class Recette {
	
	@Id
	private String id;
	private String nom;
	private List<Ingredient> ingredients;
	@DBRef
	private List<Categorie> categorie;
	
	private String description;
	
	public Recette() {
	}
	
	@Autowired
	public Recette(String nom, List<Ingredient> ingredients, List<Categorie> categorie, String description) {
		this.nom = nom;
		this.ingredients = ingredients;
		this.categorie = categorie;
		this.description = description;
	}


	
	

}
