package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.Result;
import com.example.demo.dto.Vin;

@Service
public class WebServiceImpl implements WebService {
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<Result> getResultList(String vin) {
		
		//gets the vin from given public api
		Vin myVin = getVinFromPublicApi(vin);
		
		//extract the valid field of vin
		List<Result> resultList = extractResultFromVin(myVin);
		
		//returns the valid results in list
		return resultList;
		
		
	}
	private List<Result> extractResultFromVin(Vin myVin) {
		
		List<Result> resultList = myVin.getResults()
				.stream()
				.filter(i->i.getValue() != null )
				.filter(j->j.getValue() !="")
				.collect(Collectors.toList());
		return resultList;
	}
	private Vin getVinFromPublicApi(String vin) {
		Map<String,String> map = new HashMap<>();
		map.put("vin",vin);
		Vin myVin = restTemplate.getForObject(
				"https://vpic.nhtsa.dot.gov/api/vehicles/decodevinextended/{vin}?format=json",
				Vin.class,map);
		return myVin;
	}
	


}
