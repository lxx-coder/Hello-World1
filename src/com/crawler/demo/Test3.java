package com.crawler.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test3 {
	
	//资源所在网页地址
	private static String resourceURL = "http://www.csdn.net/";
	private static String resURL = "https://tieba.baidu.com/p/3927954592";
	private static String baeuty = "http://image.so.com/z?ch=beauty";
	//资源保存路径
//	private static String downloadFilePath = "D:\\downloadImage\\";
//	private static String downloadFilePath = "D:\\downloadImage2\\";
	private static String downloadFilePath = "D:\\downloadImage3\\";
	private static int num = 0;
	
	public static void downloadImages(String filePath,String imgUrl) throws UnsupportedEncodingException{
		//图片url中的前面部分，例如http://image.csdn.net/
		String beforeUrl = imgUrl.substring(0,imgUrl.lastIndexOf("/")+1);
		//图片的url的后面部分，例如*.jpg
		String fileName = imgUrl.substring(imgUrl.lastIndexOf("/")+1);
		//编码之后fileName空格变成字符"+"
		String newFileName = URLEncoder.encode(fileName,"UTF-8");
		//把编码之后的fileName中的字符"+"替换成UTF-8中的空格表示"%20"
		newFileName = newFileName.replaceAll("\\+", "\\%20");
		//编码之后的url
		imgUrl = beforeUrl+newFileName;
		
		try {
			//创建目录
			File file = new File(filePath);
			if(!file.exists()){
				file.mkdirs();
			}
			//获取下载地址
			URL url = new URL(imgUrl);
			//连接网络地址
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			//获取链接的输出流
			InputStream is = connection.getInputStream();
			//根据输入流写入文件
			FileOutputStream out = new FileOutputStream(new File(filePath + fileName));
			int i = 0;
			while((i = is.read()) != -1){
				out.write(i);
			}
			out.close();
			is.close();
			num++;
 		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		// 从一个网站获取和解析一个HTML文档
//		Document document = Jsoup.connect(resourceURL).get();
		Document document = Jsoup.connect(baeuty).get();
//		System.out.println(document);
		//获取所有的img标签
		Elements elements = document.getElementsByTag("img");
		for(Element element:elements){
			//获取每个img标签的src属性，即图片地址，加abs：表示绝对路径
			String imgsrc = element.attr("abs:src");
			
			System.out.println("正在下载图片：------------------"+imgsrc);
			downloadImages(downloadFilePath, imgsrc);
			System.out.println("图片下载完毕：-------------------"+imgsrc);
			System.out.println("------------------------------------------"
					+ "---------------------------------------------------");
			if(num > 500)
				break;
			
		}
		System.out.println("共下载了 "+num+" 个文件（不去重）");
	}

}
