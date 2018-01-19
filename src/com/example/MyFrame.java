package com.example;

import javax.swing.*;

public class MyFrame{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("MyFrame");
		JButton jbtOK = new JButton("OK");
		frame.add(jbtOK);
		
		frame.setSize(400,300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
