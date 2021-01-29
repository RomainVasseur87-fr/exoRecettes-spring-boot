package exorecettes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import exorecettes.services.IngredientService;


@RestController
@RequestMapping("ingredients") // localhost:8080/ingredients
public class IngredientController {
	
	@Autowired
	private IngredientService service;

}
