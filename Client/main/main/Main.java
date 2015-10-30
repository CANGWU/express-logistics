package main;

import javax.swing.*;

import presentation.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		JFrame mFrame = new JFrame();
		mFrame.setSize(800, 600);
		mFrame.setLocation(300, 300);
		
        JPanel panel=new OrderView(mFrame);
		mFrame.getContentPane().add(panel);
		mFrame.setVisible(true);
		mFrame.setResizable(false);
		mFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
