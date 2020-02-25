package com.recipe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RecipeApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(RecipeApplication.class, args);
//		// Host url
//		String host = "https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/";
//		String charset = "UTF-8";
//		// Headers for a request
//		String x_rapidapi_host = "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com";
//		String x_rapidapi_key = "3a01be6e25msh75a6c8a146c41d5p18acf7jsn5846c5ec8a46";// Type here your key
//		// Params
//		String s = "Pulp";
//		// Format query for preventing encoding problems
//		String query = String.format("s=%s", URLEncoder.encode(s, charset));
//
//		HttpResponse<JsonNode> response = Unirest.get(host + "?" + query).header("x-rapidapi-host", x_rapidapi_host)
//				.header("x-rapidapi-key", x_rapidapi_key).asJson();
//		System.out.println(response.getStatus());
//		System.out.println(response.getHeaders().get("Content-Type"));
//
//		@SuppressWarnings("unused")
//		HttpResponse<String> responseRandom = Unirest.get(
//				"https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/random?number=1&tags=vegetarian%252Cdessert")
//				.header("x-rapidapi-host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
//				.header("x-rapidapi-key", "3a01be6e25msh75a6c8a146c41d5p18acf7jsn5846c5ec8a46").asString();
//		
//		
	}

}
