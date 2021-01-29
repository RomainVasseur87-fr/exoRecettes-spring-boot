package exorecettes.models;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document("categorie")
public class Categorie {
	
	@Id
	private String ID;
	private String nom;

	public Categorie() {
	}
	
	@Autowired
	public Categorie(String nom) {
		this.nom = nom;
	}
	
	

}
