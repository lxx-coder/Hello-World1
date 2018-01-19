package com.jdbc.demo;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
	public static void main(String[] args) {
		
		//����Connection����
		Connection con;
		//����������
		String drive= "com.mysql.jdbc.Driver";
		//URLָ��Ҫ���ʵ����ݿ���
		String url = "jdbc:mysql://localhost:3306/test?characterEncoding=utf-8&&useSSL=false";
		//�û���������
		String user = "root";
		String password = "xx921226";
		
		//������ѯ�����
		try {
			//������������
			Class.forName(drive);
			//1��getConnection()�������������ݿ�
			con = DriverManager.getConnection(url,user,password);
			if (!con.isClosed()) {
				System.out.println("Succeeded connecting to the Database!");
			}
			//2������statement���������ִ��SQL���
			Statement statement = con.createStatement();
			
			//Ҫִ�е�SQL���
			PreparedStatement psql;
			//Ԥ�����������
			psql = con.prepareStatement("insert into employment(employId,name,"
					+ "job,hireDate,salary) values(?,?,?,?,?)");
			psql.setString(1, "3212");
			psql.setString(2, "����");
			psql.setString(3, "�ܲ�");
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date myDate2 = dateFormat.parse("2010-09-13");
			psql.setDate(4, new java.sql.Date(myDate2.getTime()));
			psql.setFloat(5, (float)2000.3);
			psql.execute();
			
			//Ԥ�����������
//			psql = con.prepareStatement("update employment set salary = ? where name = ?");
//			psql.setFloat(1, (float)5000.0);
//			psql.setString(2, "����");
//			psql.execute();
			
			//Ԥ����ɾ������
//			psql = con.prepareStatement("delete from employment where salary > ?");
//			psql.setFloat(1, 4500);
//			psql.executeUpdate();
//			psql.close();
			
			String sql = "select * from employment";
			
			//3,ResultSet�࣬������Ż�ȡ�Ľ����
			ResultSet rs = statement.executeQuery(sql);
			System.out.println("-----------");
			System.out.println("ִ�н��������ʾ��");
			System.out.println("------------------------------------------------");
			System.out.println("id\tname\tjob\thireDate\tsalary");
			System.out.println("------------------------------------------------");
			
			String id = null;
			String name = null;
			String job = null;
			Date hireDate;
			float salary;
			while (rs.next()) {
				//��ȡ����
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
			//���ݿ��������쳣����
			System.out.println("Sorry,Can't find the Drive");
			e.printStackTrace();
		}catch (SQLException e) {
			// ���ݿ�����ʧ���쳣
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("���ݿ�ɹ���ȡ");
		}
	}
}
