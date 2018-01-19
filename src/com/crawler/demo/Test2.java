package com.crawler.demo;

import java.io.InputStream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Test2 {
	
	public static void getUrl(String url){
		try{
			Document doc = (Document)Jsoup.connect(url).get();
			Elements jpgs = doc.select("img[src$=.jpg]");
//			InputStream is = jpgs.
		}catch(Exception e){
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
