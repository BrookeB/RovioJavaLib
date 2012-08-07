package com.github.RovioJavaLib.Samples;

import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import com.github.RovioJavaLib.RJRobot;
import com.googlecode.javacv.CanvasFrame;
import com.googlecode.javacv.cpp.opencv_core.IplImage;

public class KeyEventDemo extends RJRobot implements KeyListener {
	public RJRobot robot = new RJRobot("192.168.1.231", "admin", "gtri2012");
	boolean isContinuous = false;

	/** Handle the key pressed event from the text field. */
	public KeyEventDemo(String IP, String username, String password) {
		super(IP, username, password);
		// TODO Auto-generated constructor stub
	}
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		//System.out.println(keyCode);

		if (keyCode == KeyEvent.VK_RIGHT) {
			robot.moveRight(isContinuous);
		}
		if (keyCode == KeyEvent.VK_LEFT) {
			robot.moveLeft(isContinuous);
		}
		if (keyCode == KeyEvent.VK_UP) {
			robot.moveForward(isContinuous);
		}
		if (keyCode == KeyEvent.VK_DOWN) {
			robot.moveBackwards(isContinuous);
		}
		if (keyCode == KeyEvent.VK_L) {
			robot.rotateLeft(isContinuous);
		}
		if (keyCode == KeyEvent.VK_R) {
			robot.rotateRight(isContinuous);
		}
		if (keyCode == KeyEvent.VK_D) {
			robot.diagnolLeft(isContinuous);
		}
		if (keyCode == KeyEvent.VK_S) {
			robot.diagnolRight(isContinuous);
		}
		if (keyCode == KeyEvent.VK_M) {
			robot.cameraBottom();
		}
		if (keyCode == KeyEvent.VK_N) {
			robot.cameraMiddle();
		}
		if (keyCode == KeyEvent.VK_T) {
			robot.cameraTop();
		}
		if (keyCode == KeyEvent.VK_H) {
			robot.goHome();
		}
		if(keyCode ==KeyEvent.VK_SPACE){
			robot.stopMovement();
		}
		 if (keyCode == KeyEvent.VK_1){
			 robot.diagnolForwardL(isContinuous);
		}
		 if (keyCode == KeyEvent.VK_2){
			 robot.diagnolForwardR(isContinuous); 
		 }
		 if(keyCode == KeyEvent.VK_3){
			 robot.rightRotate20(isContinuous);
		 }
		 if(keyCode == KeyEvent.VK_4){
			 robot.leftRotate20(isContinuous); 
		 }
		 if(keyCode == KeyEvent.VK_5){
			 System.out.println(robot.batteryPercentage() + "% battery remaining."); 
		 }
		 if(keyCode == KeyEvent.VK_6){
			 try {
				 robot.setBlueLights(true, false, false, true, false, false);
				 Thread.sleep(10);
				 robot.setBlueLights(false, true, false, false, true, false);
				 Thread.sleep(10);
				 robot.setBlueLights(false, false, true, false, false, true);
				 Thread.sleep(10);
				 robot.setBlueLights(true, false, false, true, false, false);
				 Thread.sleep(10);
				 robot.setBlueLights(false, true, false, false, true, false);
				 Thread.sleep(10);
				 robot.setBlueLights(false, false, true, false, false, true);
				 Thread.sleep(10);
				 robot.setBlueLights(true, true, true, true, true, true);
				 Thread.sleep(10);
			 
			 } catch (Exception err) {
				 
			 }
		 }
		if(keyCode == KeyEvent.VK_C) {
			isContinuous = !isContinuous;
			System.out.println( "Continuous motion is " + ((isContinuous)? "on." : "off."));
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		
		KeyEventDemo KED = new KeyEventDemo("192.168.1.230", "admin", "gtri2012");
		
		String WindowName = "Rovio Camera";
		CanvasFrame canvas = new CanvasFrame(WindowName, CanvasFrame.getDefaultGamma());
		
		Frame frame = new Frame();
		frame.addKeyListener(KED);
		frame.setVisible(true);
		while (frame.isVisible()) {

			java.awt.Image rovioImg = KED.robot.getImage();
			IplImage img = IplImage.createFrom((BufferedImage) rovioImg);
			canvas.showImage(img);
		}
	}
}