package com.fracong.test;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class TestSwingFrame {

	public static void main(String[] args) {
//		viewFrame1();
//		viewFrame2();
//		viewFrame3();
		viewFrame4();
	}
	
	public static void viewFrame1(){
		JFrame jFrame = new JFrame("SWING TEST");
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		jFrame.setBounds(((int)dimension.getWidth() - 200) / 2, ((int)dimension.getHeight() - 300) / 2, (int)dimension.getWidth() / 2, (int)dimension.getHeight() / 2);
		jFrame.setResizable(false);
		jFrame.setLayout(null);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setVisible(true);
	}
	
	public static void viewFrame2(){
		JFrame jFrame = new JFrame("SWING TEST");
		jFrame.setResizable(false);
		jFrame.setLayout(null);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setSize(Toolkit.getDefaultToolkit().getScreenSize());    
		jFrame.setLocation(0,0);
		jFrame.setVisible(true);
	}
	
	public static void viewFrame3(){
		JFrame jFrame = new JFrame("SWING TEST");
		jFrame.setResizable(false);
		jFrame.setLayout(null);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(jFrame); 
		jFrame.setVisible(true);
	}
	
	public static void viewFrame4(){
		JFrame jFrame = new JFrame("SWING TEST");
		jFrame.setResizable(true);
		jFrame.setLayout(null);
		jFrame.setAlwaysOnTop(true);
		jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setVisible(true);
	}
}
