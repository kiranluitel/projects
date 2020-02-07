package com.example.demo.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown=true)
public class Result {
	
	private String Value;

	private String Variable;

	
	public Result() {
		
	}
	
	

	public Result(String value, String variable) {
		super();
		Value = value;
		Variable = variable;
	}



	public String getValue() {
		return Value;
	}
	
	@JsonProperty("Value")
	public void setValue(String value) {
		Value = value;
	}



	public String getVariable() {
		return Variable;
	}
	@JsonProperty("Variable")
	public void setVariable(String variable) {
		Variable = variable;
	}

	@Override
	public int hashCode() {
		
		return Objects.hash(Value,Variable);
		
	}
	
	@Override
	public boolean equals(Object o) {
		
		if(o==null) return false;
		if(!(o instanceof Result)) return false;
		Result r = (Result) o;
		return (Value.equals(r.Value) && Variable.equals(r.Variable));
	}



	@Override
	public String toString() {
		return "{Value:" + Value + ", Variable:" + Variable + "}";
	}
	
	
	

}
