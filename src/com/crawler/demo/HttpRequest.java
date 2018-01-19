package com.crawler.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class HttpRequest {
	
	public static void main(String[] args) throws DocumentException, UnsupportedEncodingException {
		//����Get����
//		String string = HttpRequest.sendGet(
//				"http://ws.webxml.com.cn/WebServices/WeatherWS.asmx", "getRegionDataset");
		String nameCode = URLEncoder.encode("�人","utf-8");
		String string = HttpRequest.sendGet(
				"http://ws.webxml.com.cn/WebServices/WeatherWS.asmx/getWeather", 
				"theCityCode="+nameCode+"&theUserID=");
//		HashMap<String, String> provinceId = new HashMap<String, String>();
//		HashMap<String, String> countryId = new HashMap<String, String>();
		Document document = DocumentHelper.parseText(string);
		Element root = document.getRootElement();
//		Element element = root.element("diffgram");
//		Element region = element.element("getRegion");
		Iterator<?> iter = root.elementIterator("string");
		StringBuffer sBuffer = new StringBuffer();
		while(iter.hasNext()){
			Element element = (Element) iter.next();
			if(element.getData().equals("��ѯ���Ϊ��")){
				sBuffer.append("��ѯ���Ϊ��");
			}else{
				sBuffer.append(element.getData());
				sBuffer.append("\n");
			}
//			String regionId = (String) province.element("RegionID").getData();
//			String regionName = (String) province.element("RegionName").getData();	
//			provinceId.put(regionId, regionName);
//			System.out.println("Name:"+regionName+" ID:"+regionId);
		}
//		Iterator iter2 = region.elementIterator("Country");
//		while(iter2.hasNext()){
//			Element province = (Element) iter2.next();
//			String regionId = (String) province.element("RegionID").getData();
//			String regionName = (String) province.element("RegionName").getData();	
//			countryId.put(regionId, regionName);
////			System.out.println("Name:"+regionName+" ID:"+regionId);
//		}
		System.out.println(sBuffer.toString());
		
		//����Post����
//		String string2 = HttpRequest.sendPost(
//				"http://www.webxml.com.cn/WebServices/WeatherWebService.asmx/getWeatherbyCityName", 
//				"�人");
//		String string2 = HttpRequest.sendPost(
//				"http://ws.webxml.com.cn", 
//				postMessage("�人", ""));
//		System.out.println(string2);
	}
	
	/**
	 * ��ָ����URL����GET��������
	 * �������name1=value&name2=value2����ʽ
	 * 
	 */
	
	public static String sendGet (String url,String param){
		String result = "";
		BufferedReader in = null;
		try{
			String urlNameString = url + "?" + param;
			URL realUrl = new URL(urlNameString);
			//�򿪺�URL֮�������
			URLConnection connection = realUrl.openConnection();
			//����ͨ�õ���������
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("Accept-Charset", "utf-8");
			connection.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1))");
			//����ʵ������
			connection.connect();
			//��ȡ������Ӧͷ�ֶ�
//			Map<String, List<String>> map = connection.getHeaderFields();
//			//����������Ӧͷ�ֶ�
//			for(String key:map.keySet()){
//				System.out.println(key+"--->"+map.get(key));
//			}
			//����bufferedReader���������ȡURL����Ӧ
			in = new BufferedReader(new InputStreamReader(
					connection.getInputStream(),"UTF-8"));
			String line;
			while ((line = in.readLine())!=null) {
				result += line;
			}
		}catch (Exception e) {
			System.out.println("����GET��������쳣��"+e);
			e.printStackTrace();
		}
		return result;
	}
	
	public static String sendPost(String url,String param){
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			URLConnection connection = realUrl.openConnection();
			
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			//����POST�������������������
			connection.setDoInput(true);
			connection.setDoOutput(true);
			
			out = new PrintWriter(connection.getOutputStream());
			out.print(param);
			out.flush();
			
			in = new BufferedReader(
					new InputStreamReader(
							connection.getInputStream(),"UTF-8"));
			String line;
			while((line = in.readLine())!= null){
				result += line;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try{
				if(out != null){
					out.close();
				}
				if(in != null){
					in.close();
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public static String postMessage(String theCityCode,String theUserID){
		StringBuilder sb = new StringBuilder();
		sb.append("POST /WebServices/WeatherWS.asmx/getWeather HTTP/1.1");
		sb.append("Host: ws.webxml.com.cn");
		sb.append("Content-Type: application/x-www-form-urlencoded");
		sb.append("Content-Length: length");
		sb.append("theCityCode="+theCityCode+"&theUserID="+theUserID);
		return sb.toString();
	}
}
