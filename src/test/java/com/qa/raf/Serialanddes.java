package com.qa.raf;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Serialanddes  {
	
	
	@Test
	public void convertToPOJO() throws JsonProcessingException
	{
		Student stud=new Student();
		stud.setLoc("Coimbatore");
		stud.setName("Ram");
		
		
		ObjectMapper obj=new ObjectMapper();
		String jsondata=obj.writerWithDefaultPrettyPrinter().writeValueAsString(stud);
		System.out.println(jsondata);
	}

}
