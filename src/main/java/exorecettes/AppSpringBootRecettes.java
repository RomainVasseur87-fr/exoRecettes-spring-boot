package exorecettes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class AppSpringBootRecettes {
	public static void main(String[] args) {
		//remplace contexte car le creer tout seule.
		SpringApplication.run(AppSpringBootRecettes.class, args);
	}

}
