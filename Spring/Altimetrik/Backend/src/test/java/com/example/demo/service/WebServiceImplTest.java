package com.example.demo.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;


import com.example.demo.dto.Result;
import com.example.demo.dto.Vin;

@RunWith(MockitoJUnitRunner.class)
public class WebServiceImplTest {
	
	@Mock
	private RestTemplate restTemplateMock;
	
	@InjectMocks
	private WebServiceImpl webServiceImpl;
	
	
	@Test 
	public void decodedVinMethodTest() {
		
		String vin = "vin";
		
		Map<String,String> map = new HashMap<>();
		map.put("vin",vin);
		
			
		
		when(restTemplateMock.getForObject("https://vpic.nhtsa.dot.gov/api/vehicles/decodevinextended/{vin}?format=json", Vin.class
				,map))
		.thenReturn(getVin());
		
		List<Result> result = webServiceImpl.getResultList("vin");
		
		List<Result> expected = Arrays.asList(
				
				new Result("A3W","Model"),
				
				new Result("USA","Plant Country"),
				new Result("IL","Plant State"),
				
				new Result("Chicago","Plant City")
				);
		
		
		
		
		
		assertEquals(expected,result);
	}

	private Vin getVin() {
		List<Result> resultList = Arrays.asList(
		new Result(null,"Make"),
		new Result("A3W","Model"),
		new Result(null,"Model Year"),
		new Result("USA","Plant Country"),
		new Result("IL","Plant State"),
		
		new Result("Chicago","Plant City")
		);

		return new Vin(resultList);
	}
	

}
