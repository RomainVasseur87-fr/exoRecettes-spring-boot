package exorecettes.models;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document("ingredient")
public class Ingredient {
	
	@Id
	private String id;
	private String nom;
	private double quantité;
	private String unité;
	
	public Ingredient() {
	}

	@Autowired
	public Ingredient(String nom, double quantité, String unité) {
		this.nom = nom;
		this.quantité = quantité;
		this.unité = unité;
	}
	
	
	
	

}
