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
	 * ���ݱ�ǩ��ȡ��ҳ����
	 * @param url
	 */
	public static void GetUrl(String url){
		try {
			Document doc = (Document) Jsoup.connect(url)
			//.data("query","Java")
			//.userAgent("ͷ��")
			//.cookie("auth","token")
			//.timeout(3000)
			//.post()
			.get();
			//�õ�html�����ж���
			Element content = doc.getElementById("content");
			//�����html��<a>...<a/>֮������ж���
			Elements links = content.getElementsByTag("a");
			//Element links = doc.select("a[href]");
			//��չ��Ϊ.png��ͼƬ
			Elements pngs = doc.select("img[src$=.png]");
			//class����masthead��div��ǩ
			Element masthead = doc.select("div.masthead").first();
			
			for(Element link:links){
				//�õ�<a>...</a>�������ַ
				String linkHref = link.attr("href");
				//�õ�<a>...<a/>����ĺ���
				String linkText = link.text();
				System.out.println(linkText+": "+linkHref);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//��ץȡ����ҳ���HTML�ļ��������ڱ���
	public static void saveHtml(String url){
		try {
			String path = "D:\\dest\\dest.html";
			File dest = new File(path);
			//�����ֽ�������
			InputStream is;
			//�ֽ������
			FileOutputStream fos = new FileOutputStream(dest);
			URL temp = new URL(url);
			is = temp.openStream();
			//Ϊ�ֽ��������ӻ���
			BufferedInputStream bis = new BufferedInputStream(is);
			//Ϊ�ֽ�������ӻ���
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
	
	//�������ص�html
	public static void getLocalHtml(String path){
		//��ȡ����·��
		File file = new File(path);
		//���ļ��б���Ϊ����
		File[] array = file.listFiles();
		
		for(int i = 0;i < array.length;i++){
			try {
				if(array[i].isFile()){
					System.out.println("���ڽ�����ַ��"+array[i].getName());
					
					Document doc = Jsoup.parse(array[i],"UTF-8");
					//�õ�HTML�����ж���
					Element content = doc.getElementById("content");
					//�����html��<a>...</a>֮������ж���
					Elements links = content.getElementsByTag("a");
					
					Elements pngs = doc.select("img[src$=.png]");
					//class����masthead��div��ǩ
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
