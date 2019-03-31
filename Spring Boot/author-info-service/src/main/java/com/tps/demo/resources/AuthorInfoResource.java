package com.tps.demo.resources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tps.demo.models.AuthorItem;

@RestController
@RequestMapping("/author")
public class AuthorInfoResource {

	@RequestMapping("/{authorId}")
	public AuthorItem getAuthor(@PathVariable("authorId") String authorId ) {
		return new AuthorItem(authorId, "Stephen King");
	}
	
	@RequestMapping("/hola")
	public static void AuthorInfoGetRequest() throws IOException {
		String readLine= null;
		URL url = new URL("https://www.goodreads.com/author/list/3389?format=xml&key=");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK) {
	        BufferedReader in = new BufferedReader(
	                new InputStreamReader(con.getInputStream()));
	        StringBuffer response = new StringBuffer();
	        while ((readLine = in .readLine()) != null) {
	            response.append(readLine);
	        } in .close();
	        // print result
	        System.out.println("JSON String Result " + response.toString());
	    } else {
	        System.out.println("GET NOT WORKED");
	    }
	}
}
