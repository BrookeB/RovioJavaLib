package com.github.RovioJavaLib.Samples;

import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import com.github.RovioJavaLib.RJRobot;
import com.googlecode.javacv.CanvasFrame;
import com.googlecode.javacv.cpp.opencv_core.IplImage;

public class KeyEventDemo extends RJRobot implements KeyListener {
	public static RJRobot robot = new RJRobot("192.168.1.231", "admin", "gtri2012");
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
		if (keyCode == KeyEvent.VK_1) {
			robot.rotateLeft(isContinuous);
		}
		if (keyCode == KeyEvent.VK_2) {
			robot.rotateRight(isContinuous);
		}
		if (keyCode == KeyEvent.VK_3) {
			robot.diagnolForwardL(isContinuous);
		}
		if (keyCode == KeyEvent.VK_4) {
			robot.diagnolForwardR(isContinuous);
		}
		if(keyCode == KeyEvent.VK_5){
			robot.diagnolBackwardR(isContinuous);
		}
		if(keyCode == KeyEvent.VK_6){
			robot.diagnolBackwardL(isContinuous);
		}
		if (keyCode == KeyEvent.VK_7) {
			robot.cameraLow();
		}
		if (keyCode == KeyEvent.VK_8) {
			robot.cameraMid();
	}
		if (keyCode == KeyEvent.VK_9) {
			robot.cameraHigh();
		}
		if (keyCode == KeyEvent.VK_H) {
			robot.goHome();
		}
    	if(keyCode ==KeyEvent.VK_SPACE){
			robot.stopMovement();
		}
	 if(keyCode == KeyEvent.VK_L){
	 robot.rotateLeft20(isContinuous);
	 }
	 if(keyCode == KeyEvent.VK_R){
		 robot.rotateRight20(isContinuous); 
	 }
		 if(keyCode == KeyEvent.VK_B){
			 System.out.println(robot.getBatteryPercent() + "% battery remaining."); 
		 }
//		 if(keyCode == KeyEvent.VK_6){
//			 try {
//				 robot.setBlueLights(true, false, false, true, false, false);
//				 Thread.sleep(10);
//				 robot.setBlueLights(false, true, false, false, true, false);
//				 Thread.sleep(10);
//				 robot.setBlueLights(false, false, true, false, false, true);
//				 Thread.sleep(10);
//				 robot.setBlueLights(true, false, false, true, false, false);
//				 Thread.sleep(10);
//				 robot.setBlueLights(false, true, false, false, true, false);
//				 Thread.sleep(10);
//				 robot.setBlueLights(false, false, true, false, false, true);
//				 Thread.sleep(10);
//				 robot.setBlueLights(true, true, true, true, true, true);
//				 Thread.sleep(10);
//			 
//			 } catch (Exception err) {
//				 
//			 }
//		 }
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
		
		KeyEventDemo KED = new KeyEventDemo("192.168.1.231", "admin", "gtri2012");
		
		String WindowName = "Rovio Camera";
		CanvasFrame canvas = new CanvasFrame(WindowName, CanvasFrame.getDefaultGamma());
		
		final Frame frame = new Frame();
		frame.addKeyListener(KED);
		frame.setVisible(true);
		frame.setBounds(0, 0, 100, 100);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e)
			{
				frame.dispose();
				robot.stopMovement();
				System.exit(0);
			}
		});
		while (frame.isVisible()) {

			java.awt.Image rovioImg = KED.robot.getImage();
			IplImage img = IplImage.createFrom((BufferedImage) rovioImg);
			canvas.showImage(img);
		}
	}
}