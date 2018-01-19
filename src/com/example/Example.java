package com.example;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.function.IntPredicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sun.javafx.geom.AreaOp.AddOp;

abstract class  A{
	private void doSomething(){
		System.out.println("do something in A");
	}
	public void repeat(){
		doSomething();
	}
	
	abstract void fun();
}
abstract class B extends A{
	private void doSomething(){
		System.out.println("do something in B");
	}
}

class InvalidException extends Exception{
	public InvalidException(){
		super("InvalidException");
	}
}

public class Example {
	private int a;
	private int b;
	String s;
	Date d;
	
//	abstract void fun();
	
	public static void change(String s,StringBuilder builder)
	throws InvalidException{
		s = s+" and HTML";
		builder.append(" and HTML");
	}
	public static void nullPointerFun() {
		System.out.println("nullPointerFun");
	}
	
	public <E extends Object> void printArray(E[] list){
		for(E o:list)
			System.out.print(o+" ");
		System.out.println();
	}
	
	public static void makeException(int value) throws Exception{
		if(value < 40)
			throw new Exception(("Exception"));
	}
	
	public static void method1() throws Exception{
		throw new Exception("Exception");
	}
	
	public static void method() throws Exception{
		try{
			method1();
		}
		catch(RuntimeException ex){
			System.out.println("RuntimeException");
		}catch (Exception ex) {
			System.out.println("Exception Method");
			throw ex;
		}
	}
	
	public static <T> void add(GenericStack<T> stack1,
			GenericStack<? super T> stack2){
		while (!stack1.isEmpty())
			stack2.push(stack1.pop());
//		T t1 = (T)new Object();
;	}
	
	public static String transferString(StringBuilder s){
		while(true){
			boolean adjust = true;
			for(int i = 0;i < s.length()-1;i++){
				if(Character.isUpperCase(s.charAt(i)) && 
						Character.isLowerCase(s.charAt(i+1))){
					char tmp = s.charAt(i);
					s.setCharAt(i, s.charAt(i+1));
					s.setCharAt(i+1, tmp);
					if(adjust){
						adjust = false;
					}
				}
			}
			if(adjust)
				break;
		}
		return s.toString();
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<StringBuilder> list = new ArrayList<StringBuilder>();
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			StringBuilder s = new StringBuilder(scanner.next());
			list.add(s);
		}
		scanner.close();
		for(StringBuilder s:list){
			System.out.println(transferString(s));
		}
		
		Set<String> hashSet = new HashSet<String>();
		hashSet.add("杭州");
		hashSet.add("武汉");
		hashSet.add("北京");
		hashSet.add("上海");
		hashSet.add("武汉");
		System.out.println(hashSet);
		Map<String,Integer> hashMap = new HashMap<String, Integer>();
		hashMap.put("Smith", 30);
		hashMap.put("Anderson", 31);
		hashMap.put("Lewis", 29);
		hashMap.put("Cook", 29);
		
		System.out.println("Display entries in hashMap");
		System.out.println(hashMap);
//		Set<Map.Entry<String, Integer>> set = hashMap.entrySet();
//		System.out.println(set);
		Map<String, Integer> treeMap = new TreeMap<String, Integer>(hashMap);
		System.out.println("Display entries in ascending order of key");
		System.out.println(treeMap);
		
		Map<String, Integer> linkedHashMap = new LinkedHashMap<String, Integer>(16,0.75f,true);
		linkedHashMap.put("Smith", 30);
		linkedHashMap.put("Anderson", 31);
		linkedHashMap.put("Lewis", 29);
		linkedHashMap.put("Cook", 29);
		
		System.out.println("Display entries in LinkedHashMap");
		System.out.println(linkedHashMap);
		
		
//		ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("D://test.dat"));
//		LinkedHashSet<String>set1 = new LinkedHashSet<String>();
//		set1.add("New York");
//		LinkedHashSet<String> set2 = (LinkedHashSet<String>)set1.clone();
//		set1.add("Atlanta");
//		output.writeObject(set1);
//		output.writeObject(set2);
//		output.close();
//		
//		ObjectInputStream input = new ObjectInputStream(new FileInputStream("d:\\test.dat"));
//		try {
//			set1 = (LinkedHashSet<String>)input.readObject();
//			set2 = (LinkedHashSet<String>)input.readObject();
//		} catch (ClassNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		System.out.println(set1);
//		System.out.println(set2);
//		input.close();
		
//		LinkedHashSet<String> set1 = new LinkedHashSet<String>();
//		set1.add("New York");
//		LinkedHashSet<String> set2 = set1;
//		LinkedHashSet<String> set3 = (LinkedHashSet<String>)(set1.clone());
//		set1.add("Atlanta");
//		System.out.println("set1 is "+ set1);
//		System.out.println("set2 is "+ set2);
//		System.out.println("set3 is "+ set3);
		
//		StringBuilder sBuilder = new StringBuilder(15);
//		sBuilder.append("example double is ");
//		sBuilder.append(20.5);
//		System.out.println(sBuilder);
//		System.out.println(""+sBuilder.capacity()+" "+sBuilder.length());
//		sBuilder.trimToSize();
//		System.out.println(""+sBuilder.capacity()+" "+sBuilder.length());
		
//		String string = "java";
//		StringBuilder builder = new StringBuilder(string);
//		change(string, builder);
//		System.out.println(string);
//		System.out.println(builder);
//		Date date = new Date();
//		System.out.println(date);
		
//		(new B()).repeat();
//		Integer[] list1 = {12,23,55,1};
//		Double[] list2 = {12.4,24.0,55.2,1.0};
//		int[] list3 = {1,2,3};
//		printArray(list1);
//		printArray(list2);
//		printArray(list3);
//		System.out.println(1/0);
//		long value = Long.MAX_VALUE+1;
//		System.out.println(value);
//		try {
//			method();
//		} catch (RuntimeException ex) {
//			// TODO: handle exception
//			System.out.println("Runtime Exception main");
//		}catch(Exception ex){
//			System.out.println("Exception in main");
//		}
		
//		File file = new File("D:/url.txt");
//		if(file.exists()){
//			System.out.println("File already exists");
//			System.exit(1);
//		}
//		try(PrintWriter output = new PrintWriter(file);){
//		output.printf("amount is %f %e\r\n",32.32,32.32);
//		output.printf("amount is %5.4f %5.4e\r\n",32.32,32.32);
//		output.printf("%6b\r\n",(1>2));
//		output.printf("%6s\r\n","Java");
////		output.close();
//		}
		
//		try(Scanner input = new Scanner(System.in);){
//			int  iValue = input.nextInt();
//			String line1 = input.nextLine();
//			String line2 = input.nextLine();
//			System.out.println(iValue+"\n"+ line1+"\n"+line2);
//		}
		
//		Number numberRef = new Integer(0);
//		Double doubleRefDouble = (Double)numberRef;
//		Number[] numberArray = new Integer[2];
//		numberArray[0] = new Double(1.5);
		Number x = 3;
		System.out.println(x.intValue());
		System.out.println(x.doubleValue());
		
//		Comparable<Date> d1 = new Date();
//		System.out.println(d1.compareTo());
		GenericStack<String> stack1 = new GenericStack<>();
		GenericStack<Object> stack2 = new GenericStack<>();
		stack2.push("Java");
		stack2.push(2);
		stack1.push("Sun");
		add(stack1,stack2);
		
//		Comparable x1 = new Date();
//		System.out.println(x1.compareTo("red"));
		Integer[] integer = {1,2,3,4,5};
		Example e0 = new Example();
		e0.printArray(integer);
		
//		try{
//			URL url = new URL("http://www.baidu.com");
//			Scanner input1 = new Scanner(url.openStream());
//			PrintWriter input2 = new PrintWriter(file);
//			while(input1.hasNext()){
//				String line = input1.nextLine();
////				System.out.println(line);			
//				input2.println(line);
//			}
//			input1.close();
//			input2.close();
//		}
//		catch(MalformedURLException ex){
//			System.out.println("Invalid URL");
//		}
//		catch(IOException ex){
//			System.out.println("IO ERROR");
//		}
		
//		Example e = new Example();
//		Object obj = new Object();
//		System.out.println(e instanceof Object);
////		e = (Example)obj;
//		ArrayList<Integer> list = new ArrayList<>();
//		list.add(5);
//		System.out.println(list.remove(0));
//		Integer[] a = {1,2,3,4,5};
//		System.out.println(Arrays.asList(a).toString());
//		ArrayList<Integer> list4 = new ArrayList<Integer>(Arrays.asList(a));
		
//		Example x = null;
//		x.nullPointerFun();
//		Example example = new Example();
//		System.out.println(example.a+" "+example.b+" "+example.s+" "+
//				example.d);
//		((Example)null).nullPointerFun();
//		System.out.println(new Integer(10));
		
		
//		String[] tokens = "Java#HTML#Perl".split("#");
//		for(int i = 0;i < tokens.length;i++)
//			System.out.println(tokens[i]);
//		System.out.println("Welcome".replace("e", "AB"));
//		System.out.println(String.valueOf(new BigInteger("12345678909876543212345")));
//		System.out.println("There are".matches("^The"));
	}

}
