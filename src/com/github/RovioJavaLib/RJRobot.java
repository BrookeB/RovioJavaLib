/**
 *This provides simple commands to control the Rovio Robot through Java
 * @author Brooke Bosley
 */
package com.github.RovioJavaLib;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import java.awt.Image;
import java.awt.image.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;

/**
 *
 */
public class RJRobot {
	
	private String _IP, _username, _password;
	
	private String _baseURL;

	/**
	 * @author Matthew Barulic
	 * @param IP - The IP address for Rovio.
	 */
	public RJRobot(String IP, String username, String password) {
		_IP = IP;
		_username = username;
		_password = password;
		
		Authenticator.setDefault(new Authenticator() {                                        
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(_username, _password.toCharArray());
                }
            });
		
		_baseURL = "http://" + _IP + "/";
	}
	
	/**
	 * 
	 * @param cmd
	 */
	public void SendCommand(String cmd)
	{

		// TODO As this is part of a library, to be accessed from code, wouldn't it make more sense to just use the _IP member the class was initialized with?
		
        ///This code 1st prompts the user to enter his or her; Rovio Ip Address before beginning
        /*
         String ipStr = JOptionPane.showInputDialog("Please enter your Rovio's Ip Address?"); 
         int ip = Integer.parseInt(ipStr); 
         JOptionPane.showMessageDialog(null,"Is this your"+ ip +"hope this is correct"); 
         
           Object ip1Str;
	       Object ip1;
	       
		if(ip1Str != ip1)  //TODO How can I state "if you type yes  move on"; but "if you type in no retype." I am unclear if i am correct at this part of the program??
            {
              System.out.println("Please enter the correct value"); 
              String ipStr1 = JOptionPane.showInputDialog("Please enter your Rovio's Ip Address?"); 
              int int1 = Integer.parseInt(ipStr1); 
              JOptionPane.showMessageDialog(null,"This is the Ip Address you reentered"+ip1+"hope this is correct"); 
             }
                */
	}

	/**
	 * @author Matthew Barulic
	 * @return Returns a frame from Rovio's camera.
	 */
	public Image getImage()
	{
		InputStream inStream = null;
		Image result = null;
		try {
			URL url = new URL(_baseURL + "Jpeg/CamImg0000.jpg");
			url.openConnection();
			inStream = url.openStream();
			/*ByteArrayOutputStream bais = new ByteArrayOutputStream();
			byte[] buffer = new byte[512];
			int len;
			while ( (len = inStream.read(buffer)) > 0 ) {
				bais.write(buffer, 0, len);
			}*/
			
			result = ImageIO.read(inStream);
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (inStream != null) {
				try {
					inStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
}
