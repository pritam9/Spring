package com.mad.json;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MyProductJson {
	public static String jsonString;
	public void getJson(){
		byte[] encoded;
		try {
			File f = new File(getClass().getResource("ProductJson.txt").getFile());
			encoded = Files.readAllBytes(Paths.get(f.getAbsolutePath()));
			jsonString = new String(encoded, StandardCharsets.UTF_8);
			return;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		jsonString =  "\"Error\" : \"Error getting Data. Please try again!\"";
	}
	
}
