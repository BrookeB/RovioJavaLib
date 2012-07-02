package com.github.RovioJavaLib.TEST;

import com.github.RovioJavaLib.RJRobot;

import java.awt.Image;
import javax.swing.*;

public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			RJRobot robot = new RJRobot("192.168.1.233","admin","Cfire19");
			
			System.out.println(robot.moveForward());
				Thread.sleep(1000);
			System.out.println(robot.rotateLeft());
				Thread.sleep(1000);
			System.out.println(robot.rotateRight());
			
			Image img = robot.getImage();
			
			JFrame frame = new JFrame("ShowImage");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(600,400);
			
			ShowImage shwimg = new ShowImage(img);
			frame.setContentPane(shwimg);
			frame.setVisible(true);
		
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
