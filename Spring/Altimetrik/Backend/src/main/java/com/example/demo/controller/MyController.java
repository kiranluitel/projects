package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Result;
import com.example.demo.exceptions.InvalidVinException;
import com.example.demo.service.WebService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Contact;

@RestController
@RequestMapping("/api")
//@CrossOrigin("*")
@CrossOrigin(origins="http://localhost:4200")
public class MyController {
	
	@Autowired
	private WebService webServiceImpl;
	
	@GetMapping("/{vin}")
	@ApiOperation(value="Decode VIN by vinId",
	notes="Give your VIN as input and get the info about your VIN",
	response=Contact.class)
	public ResponseEntity<List<Result>> getDecodedVin(
			@ApiParam(value="VIN must be of 17 characters",required=true)
			@PathVariable String vin) {
		if(vin.length() !=17) throw new InvalidVinException();
		List<Result> resultList = webServiceImpl.getResultList(vin);
		return new ResponseEntity<List<Result>>(resultList,HttpStatus.CREATED);

		
	
	}

}
