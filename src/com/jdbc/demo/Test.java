package com.jdbc.demo;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
	public static void main(String[] args) {
		
		//声明Connection对象
		Connection con;
		//驱动程序名
		String drive= "com.mysql.jdbc.Driver";
		//URL指向要访问的数据库名
		String url = "jdbc:mysql://localhost:3306/test?characterEncoding=utf-8&&useSSL=false";
		//用户名和密码
		String user = "root";
		String password = "xx921226";
		
		//遍历查询结果集
		try {
			//加载驱动程序
			Class.forName(drive);
			//1，getConnection()方法，连接数据库
			con = DriverManager.getConnection(url,user,password);
			if (!con.isClosed()) {
				System.out.println("Succeeded connecting to the Database!");
			}
			//2，创建statement类对象，用来执行SQL语句
			Statement statement = con.createStatement();
			
			//要执行的SQL语句
			PreparedStatement psql;
			//预处理添加数据
			psql = con.prepareStatement("insert into employment(employId,name,"
					+ "job,hireDate,salary) values(?,?,?,?,?)");
			psql.setString(1, "3212");
			psql.setString(2, "王刚");
			psql.setString(3, "总裁");
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date myDate2 = dateFormat.parse("2010-09-13");
			psql.setDate(4, new java.sql.Date(myDate2.getTime()));
			psql.setFloat(5, (float)2000.3);
			psql.execute();
			
			//预处理更新数据
//			psql = con.prepareStatement("update employment set salary = ? where name = ?");
//			psql.setFloat(1, (float)5000.0);
//			psql.setString(2, "王刚");
//			psql.execute();
			
			//预处理删除数据
//			psql = con.prepareStatement("delete from employment where salary > ?");
//			psql.setFloat(1, 4500);
//			psql.executeUpdate();
//			psql.close();
			
			String sql = "select * from employment";
			
			//3,ResultSet类，用来存放获取的结果集
			ResultSet rs = statement.executeQuery(sql);
			System.out.println("-----------");
			System.out.println("执行结果如下所示：");
			System.out.println("------------------------------------------------");
			System.out.println("id\tname\tjob\thireDate\tsalary");
			System.out.println("------------------------------------------------");
			
			String id = null;
			String name = null;
			String job = null;
			Date hireDate;
			float salary;
			while (rs.next()) {
				//获取数据
				id  =rs.getString("employId");
				name = rs.getString("name");
				job = rs.getString("job");
				hireDate = rs.getDate("hireDate");
				salary = rs.getFloat("salary");
				
				System.out.println(id+"\t"+name+"\t"+job+"\t"+
						new SimpleDateFormat("yyyy-MM-dd").format(hireDate)
						+ "\t"+salary);
			}
			rs.close();
			con.close();
		} catch (ClassNotFoundException e) {
			//数据库驱动类异常处理
			System.out.println("Sorry,Can't find the Drive");
			e.printStackTrace();
		}catch (SQLException e) {
			// 数据库连接失败异常
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("数据库成功获取");
		}
	}
}
