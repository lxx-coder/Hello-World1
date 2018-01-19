package com.example;

import javax.swing.*;
import java.awt.GridLayout;

public class ShowGridLayout extends JFrame{
	public ShowGridLayout() {
		// TODO Auto-generated constructor stub
		setLayout(new GridLayout(3,2,5,5));
		
		add(new JLabel("First Name"));
		add(new JTextField(8));
		add(new JLabel("MI"));
		add(new JTextField(1));
		add(new JLabel("Last Name"));
		add(new JTextField(8));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShowGridLayout frame = new ShowGridLayout();
		frame.setTitle("ShowGridLayout");
		frame.setSize(200,200);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
