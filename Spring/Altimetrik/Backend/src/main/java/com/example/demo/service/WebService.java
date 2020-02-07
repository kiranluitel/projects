package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;


import com.example.demo.dto.Result;

public interface WebService {

//	DecodedVin getDecodedVin(String vin);

	List<Result> getResultList(String vin);
	

}
