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
	
	//��Դ������ҳ��ַ
	private static String resourceURL = "http://www.csdn.net/";
	private static String resURL = "https://tieba.baidu.com/p/3927954592";
	private static String baeuty = "http://image.so.com/z?ch=beauty";
	//��Դ����·��
//	private static String downloadFilePath = "D:\\downloadImage\\";
//	private static String downloadFilePath = "D:\\downloadImage2\\";
	private static String downloadFilePath = "D:\\downloadImage3\\";
	private static int num = 0;
	
	public static void downloadImages(String filePath,String imgUrl) throws UnsupportedEncodingException{
		//ͼƬurl�е�ǰ�沿�֣�����http://image.csdn.net/
		String beforeUrl = imgUrl.substring(0,imgUrl.lastIndexOf("/")+1);
		//ͼƬ��url�ĺ��沿�֣�����*.jpg
		String fileName = imgUrl.substring(imgUrl.lastIndexOf("/")+1);
		//����֮��fileName�ո����ַ�"+"
		String newFileName = URLEncoder.encode(fileName,"UTF-8");
		//�ѱ���֮���fileName�е��ַ�"+"�滻��UTF-8�еĿո��ʾ"%20"
		newFileName = newFileName.replaceAll("\\+", "\\%20");
		//����֮���url
		imgUrl = beforeUrl+newFileName;
		
		try {
			//����Ŀ¼
			File file = new File(filePath);
			if(!file.exists()){
				file.mkdirs();
			}
			//��ȡ���ص�ַ
			URL url = new URL(imgUrl);
			//���������ַ
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			//��ȡ���ӵ������
			InputStream is = connection.getInputStream();
			//����������д���ļ�
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
		// ��һ����վ��ȡ�ͽ���һ��HTML�ĵ�
//		Document document = Jsoup.connect(resourceURL).get();
		Document document = Jsoup.connect(baeuty).get();
//		System.out.println(document);
		//��ȡ���е�img��ǩ
		Elements elements = document.getElementsByTag("img");
		for(Element element:elements){
			//��ȡÿ��img��ǩ��src���ԣ���ͼƬ��ַ����abs����ʾ����·��
			String imgsrc = element.attr("abs:src");
			
			System.out.println("��������ͼƬ��------------------"+imgsrc);
			downloadImages(downloadFilePath, imgsrc);
			System.out.println("ͼƬ������ϣ�-------------------"+imgsrc);
			System.out.println("------------------------------------------"
					+ "---------------------------------------------------");
			if(num > 500)
				break;
			
		}
		System.out.println("�������� "+num+" ���ļ�����ȥ�أ�");
	}

}
