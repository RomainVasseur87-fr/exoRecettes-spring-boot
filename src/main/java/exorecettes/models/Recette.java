package exorecettes.models;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document("recette")
public class Recette {
	
	private String nom;
	private double quantité;
	private String unité;
	
	public Recette() {
	}
	@Autowired
	public Recette(String nom, double quantité, String unité) {
		this.nom = nom;
		this.quantité = quantité;
		this.unité = unité;
	}
	
	

}
