package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

//@Component
//@JsonIgnoreProperties(ignoreUnknown=true)
public class Vin {
	

	
	List<Result> Results;
	
	public Vin() {
		
	}
	
	


	public Vin(List<Result> results) {
		
		Results = results;
	}




	public List<Result> getResults() {
		return Results;
	}
	@JsonProperty("Results")
	public void setResults(List<Result> results) {
		Results = results;
	}



	
	
	
}
