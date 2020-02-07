package com.example.demo.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.dto.Result;
import com.example.demo.service.WebService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

@RunWith(SpringRunner.class)
@WebMvcTest(value=MyController.class)
public class MyControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private WebService webServiceImpl;
	
	@Test
	public void getDecodedVinTest() throws Exception {
		
		List<Result> resultList = new ArrayList<>();
		
		Mockito.when(webServiceImpl.getResultList(Mockito.anyString())).thenReturn(resultList);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/JH4TB2H26CC000")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder)
				.andExpect(status().is(400))
				.andReturn();
		

		String errorExpected = ""
				+ "{status:400,message:\"Invalid Vehicle Identification Number\"}";
//		System.out.println("expected: "+errorExpected);
		
		JSONAssert.assertEquals(errorExpected,result.getResponse().getContentAsString(),false);
				
	}
	
//	@Test 
//	public void getDecodedVinTest2() throws Exception {
//		
//		RequestBuilder requestBuilder1 = MockMvcRequestBuilders.get("/api/1FAHP3EN6CW000000")
//				.accept(MediaType.APPLICATION_JSON);
//		
//		List<Result> resultList = Arrays.asList(
//				new Result("Hello","Error"),
//				new Result("chicago","city"),
//				new Result("Il","state"),
//				new Result("hello","hello")
//				);
//		
//		Mockito.when(webServiceImpl.getResultList(Mockito.anyString())).thenReturn(resultList);
//		
//		MvcResult result1 = mockMvc.perform(requestBuilder1)
//				.andExpect(status().is(201))
//				.andReturn();
//		
//
//		
//		JSONAssert.assertEquals(returnExpected,result,false);
//		
//
//	}
	

	
	

}
