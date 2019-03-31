package com.tps.demo.resources;

import java.io.IOException;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tps.demo.models.BookItem;

@RestController
@RequestMapping("/book")
public class BookInfoResource {
	
	@SuppressWarnings("unused")
	private static String apikey = "0PfbxFwn7QpsYFKx7KfnjQ";
	//private static String secret = "Zb3U8do43KYumXMUpJbKXOo9wcfQsdgzEguWUnqA5g";
	
	@RequestMapping("/{bookId}")
	public BookItem getBook(@PathVariable("bookId") int bookId){
		
		return new BookItem(bookId,"Stephen King", "Test", "2");
	}
	@RequestMapping("/{authorName}/{bookName}")
	public static void bookInfoGetRequest(@PathVariable("authorName") String authorName,
			@PathVariable("bookName") String bookName) throws IOException {
		System.out.println(bookName + " " + authorName);
	} 
		
	}

