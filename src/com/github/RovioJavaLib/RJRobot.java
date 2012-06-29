/**
 *This provides simple commands to control the Rovio Robot through Java
 * @author Brooke Bosley
 */
package com.github.RovioJavaLib;

import javax.swing.JOptionPane;

/**
 *
 */
public class RJRobot {

	/**
	 * 
	 */
	public RJRobot(String IP) {
		// TODO Auto-generated constructor stub
	}
	
	public void SendCommand(String cmd)
	{

        ///This code 1st prompts the user to enter his or her; Rovio Ip Address before beginning
        
         String ipStr = JOptionPane.showInputDialog("Please enter your Rovio's Ip Address?"); 
         int ip = Integer.parseInt(ipStr); 
         JOptionPane.showMessageDialog(null,"Is this your"+ ip +"hope this is correct"); 
         
           Object ip1Str;
	       Object ip1;
	       
		if(ip1Str != ip1)  //TODO How can I state "if you type yes  move on"; but "if you type in no retype." I am unclear if i am correct at this part of the program??
            {
              System.out.println("Please enter the correct value"); 
              String ipStr1 = JOptionPane.showInputDialog("Please enter your Rovio's Ip Address?"); 
              int ip1 = Integer.parseInt(ipStr1); 
              JOptionPane.showMessageDialog(null,"This is the Ip Address you reentered"+ip1+"hope this is correct"); 
             }
                
	}

}
