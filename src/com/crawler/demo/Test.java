package com.crawler.demo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.exercise.demo.test22_3;

public class Test {
	
	/**
	 * 根据标签获取网页内容
	 * @param url
	 */
	public static void GetUrl(String url){
		try {
			Document doc = (Document) Jsoup.connect(url)
			//.data("query","Java")
			//.userAgent("头部")
			//.cookie("auth","token")
			//.timeout(3000)
			//.post()
			.get();
			//得到html的所有东西
			Element content = doc.getElementById("content");
			//分离出html下<a>...<a/>之间的所有东西
			Elements links = content.getElementsByTag("a");
			//Element links = doc.select("a[href]");
			//扩展名为.png的图片
			Elements pngs = doc.select("img[src$=.png]");
			//class等于masthead的div标签
			Element masthead = doc.select("div.masthead").first();
			
			for(Element link:links){
				//得到<a>...</a>里面的网址
				String linkHref = link.attr("href");
				//得到<a>...<a/>里面的汉字
				String linkText = link.text();
				System.out.println(linkText+": "+linkHref);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//将抓取的网页变成HTML文件，保存在本地
	public static void saveHtml(String url){
		try {
			String path = "D:\\dest\\dest.html";
			File dest = new File(path);
			//接收字节输入流
			InputStream is;
			//字节输出流
			FileOutputStream fos = new FileOutputStream(dest);
			URL temp = new URL(url);
			is = temp.openStream();
			//为字节输入流加缓冲
			BufferedInputStream bis = new BufferedInputStream(is);
			//为字节输出流加缓冲
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			int length;
			byte[] bytes = new byte[1024*1024];
			while ((length = bis.read(bytes,0,bytes.length)) != -1) {
				fos.write(bytes,0,length);
			}
			bos.close();
			fos.close();
			bis.close();
			is.close();
			
			getLocalHtml(path.substring(0, path.lastIndexOf("\\")));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//解析本地的html
	public static void getLocalHtml(String path){
		//读取本地路径
		File file = new File(path);
		//将文件列表保存为数组
		File[] array = file.listFiles();
		
		for(int i = 0;i < array.length;i++){
			try {
				if(array[i].isFile()){
					System.out.println("正在解析网址："+array[i].getName());
					
					Document doc = Jsoup.parse(array[i],"UTF-8");
					//得到HTML的所有东西
					Element content = doc.getElementById("content");
					//分离出html下<a>...</a>之间的所有东西
					Elements links = content.getElementsByTag("a");
					
					Elements pngs = doc.select("img[src$=.png]");
					//class等于masthead的div标签
					Element masthead = doc.select("div.masthead").first();
					for(Element link:links){
						String linkHref = link.attr("href");
						String linkText = link.text();
						System.out.println(linkText);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		String url = "http://www.cnblogs.com/TTyb/";
		GetUrl(url);
		//saveHtml(url);
	}

}
