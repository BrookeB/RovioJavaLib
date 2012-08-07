/**
 *This provides simple commands to control the Rovio Robot through Java
 * @author Brooke Bosley
 */
package com.github.RovioJavaLib;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.*;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Vector;

/**
 *
 */
public class RJRobot {

	private String _IP, _username, _password, _baseURL;
	private Thread _continuousThread;
	
	/**
	 * @author Matthew Barulic
	 * @param IP
	 *            - The IP address for Rovio.
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
	public boolean SendCommand(String cmd) {
		try {
			
			URL url = new URL(_baseURL + cmd);

			URLConnection uc = url.openConnection();
			uc.setDoOutput(true);

			BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
			// Read anything returned by Rovio and print it
			String line;
			while ((line = in.readLine()) != null) {
				// System.out.println (line);
			}
			// Close connection
			in.close();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @author Matthew Barulic
	 * @return Returns a frame from Rovio's camera.
	 */
	public Image getImage() {
		InputStream inStream = null;
		Image result = null;
		try {
			URL url = new URL(_baseURL + "Jpeg/CamImg0000.jpg");
			url.openConnection();
			inStream = url.openStream();
			/*
			 * ByteArrayOutputStream bais = new ByteArrayOutputStream(); byte[]
			 * buffer = new byte[512]; int len; while ( (len =
			 * inStream.read(buffer)) > 0 ) { bais.write(buffer, 0, len); }
			 */

			result = ImageIO.read(inStream);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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

	public boolean moveForward(boolean continuous) {
		if(_continuousThread.isAlive())
			_continuousThread.interrupt();
		if(continuous) {
			_continuousThread = new Thread(new RJContinuousRunnable(100, this, "rev.cgi?Cmd=nav&action=18&drive=1&speed=5"));
			_continuousThread.start();
			return true;
		} else {
			try {
	
				URL url = new URL(_baseURL + "rev.cgi?Cmd=nav&action=18&drive=1&speed=5");
	
				URLConnection uc = url.openConnection();
				uc.setDoOutput(true);
	
				BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
				// Read anything returned by Rovio and print it
				String line;
				while ((line = in.readLine()) != null) {
					// System.out.println (line);
				}
				// Close connection
				in.close();
	
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
	}

	public boolean rotateRight(boolean continuous) {
		if(_continuousThread.isAlive())
			_continuousThread.interrupt();
		if(continuous) {
			_continuousThread = new Thread(new RJContinuousRunnable(100, this, "rev.cgi?Cmd=nav&action=18&drive=6&speed=5"));
			_continuousThread.start();
			return true;
		} else {
			try {
	
				URL url = new URL(_baseURL + "rev.cgi?Cmd=nav&action=18&drive=6&speed=5");
	
				URLConnection uc = url.openConnection();
				uc.setDoOutput(true);
	
				BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
				// Read anything returned by Rovio and print it
				String line;
				while ((line = in.readLine()) != null) {
					// System.out.println (line);
				}
				// Close connection
				in.close();
	
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
	}
	public boolean rotateRight20(boolean continuous) {
		if(_continuousThread.isAlive())
			_continuousThread.interrupt();
		if(continuous) {
			_continuousThread = new Thread(new RJContinuousRunnable(100, this, "rev.cgi?Cmd=nav&action=18&drive=18&speed=5"));
			_continuousThread.start();
			return true;
		} else {
			try {
	
				URL url = new URL(_baseURL + "rev.cgi?Cmd=nav&action=18&drive=18&speed=5");
	
				URLConnection uc = url.openConnection();
				uc.setDoOutput(true);
	
				BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
				// Read anything returned by Rovio and print it
				String line;
				while ((line = in.readLine()) != null) {
					// System.out.println (line);
				}
				// Close connection
				in.close();
	
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
	}

	public boolean rotateLeft(boolean continuous) {
		if(_continuousThread.isAlive())
			_continuousThread.interrupt();
		if(continuous) {
			_continuousThread = new Thread(new RJContinuousRunnable(100, this, "rev.cgi?Cmd=nav&action=18&drive=5&speed=5"));
			_continuousThread.start();
			return true;
		} else {
			try {
	
				URL url = new URL(_baseURL + "rev.cgi?Cmd=nav&action=18&drive=5&speed=5");
	
				URLConnection uc = url.openConnection();
				uc.setDoOutput(true);
	
				BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
				// Read anything returned by Rovio and print it
				String line;
				while ((line = in.readLine()) != null) {
					// System.out.println (line);
				}
				// Close connection
				in.close();
	
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
	}
	public boolean rotateLeft20(boolean continuous) {
		if(_continuousThread.isAlive())
			_continuousThread.interrupt();
		if(continuous) {
			_continuousThread = new Thread(new RJContinuousRunnable(100, this, "rev.cgi?Cmd=nav&action=18&drive=17&speed=5"));
			_continuousThread.start();
			return true;
		} else {
			try {
	
				URL url = new URL(_baseURL + "rev.cgi?Cmd=nav&action=17&drive=5&speed=5");
	
				URLConnection uc = url.openConnection();
				uc.setDoOutput(true);
	
				BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
				// Read anything returned by Rovio and print it
				String line;
				while ((line = in.readLine()) != null) {
					// System.out.println (line);
				}
				// Close connection
				in.close();
	
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
	}

	public boolean moveRight(boolean continuous) {
		if(_continuousThread.isAlive())
			_continuousThread.interrupt();
		if(continuous) {
			_continuousThread = new Thread(new RJContinuousRunnable(100, this, "rev.cgi?Cmd=nav&action=18&drive=4&speed=5"));
			_continuousThread.start();
			return true;
		} else {
			try {
	
				URL url = new URL(_baseURL + "rev.cgi?Cmd=nav&action=18&drive=4&speed=5");
	
				URLConnection uc = url.openConnection();
				uc.setDoOutput(true);
	
				BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
				// Read anything returned by Rovio and print it
				String line;
				while ((line = in.readLine()) != null) {
					// System.out.println (line);
				}
				// Close connection
				in.close();
	
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
	}

	public boolean moveLeft(boolean continuous) {
		if(_continuousThread.isAlive())
			_continuousThread.interrupt();
		if(continuous) {
			_continuousThread = new Thread(new RJContinuousRunnable(100, this, "rev.cgi?Cmd=nav&action=18&drive=3&speed=5"));
			_continuousThread.start();
			return true;
		} else {
			try {
	
				URL url = new URL(_baseURL + "rev.cgi?Cmd=nav&action=18&drive=3&speed=5");
	
				URLConnection uc = url.openConnection();
				uc.setDoOutput(true);
	
				BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
				// Read anything returned by Rovio and print it
				String line;
				while ((line = in.readLine()) != null) {
					// System.out.println (line);
				}
				// Close connection
				in.close();
	
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
	}

	public boolean moveBackwards(boolean continuous) {
		if(_continuousThread.isAlive())
			_continuousThread.interrupt();
		if(continuous) {
			_continuousThread = new Thread(new RJContinuousRunnable(100, this, "rev.cgi?Cmd=nav&action=18&drive=2&speed=5"));
			_continuousThread.start();
			return true;
		} else {
			try {
	
				URL url = new URL(_baseURL + "rev.cgi?Cmd=nav&action=18&drive=2&speed=5");
	
				URLConnection uc = url.openConnection();
				uc.setDoOutput(true);
	
				BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
				// Read anything returned by Rovio and print it
				String line;
				while ((line = in.readLine()) != null) {
					// System.out.println (line);
				}
				// Close connection
				in.close();
	
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
	}
	public boolean diagnolForwardL(boolean continuous) {
		if(_continuousThread.isAlive())
			_continuousThread.interrupt();
		if(continuous) {
			_continuousThread = new Thread(new RJContinuousRunnable(100, this, "rev.cgi?Cmd=nav&action=18&drive=7&speed=5"));
			_continuousThread.start();
			return true;
		} else {
			try {
	
				URL url = new URL(_baseURL + "rev.cgi?Cmd=nav&action=18&drive=2&speed=5");
	
				URLConnection uc = url.openConnection();
				uc.setDoOutput(true);
	
				BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
				// Read anything returned by Rovio and print it
				String line;
				while ((line = in.readLine()) != null) {
					// System.out.println (line);
				}
				// Close connection
				in.close();
	
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
	}
	public boolean diagnolForwardR(boolean continuous) {
		if(_continuousThread.isAlive())
			_continuousThread.interrupt();
		if(continuous) {
			_continuousThread = new Thread(new RJContinuousRunnable(100, this, "rev.cgi?Cmd=nav&action=18&drive=8&speed=5"));
			_continuousThread.start();
			return true;
		} else {
			try {
	
				URL url = new URL(_baseURL + "rev.cgi?Cmd=nav&action=18&drive=2&speed=5");
	
				URLConnection uc = url.openConnection();
				uc.setDoOutput(true);
	
				BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
				// Read anything returned by Rovio and print it
				String line;
				while ((line = in.readLine()) != null) {
					// System.out.println (line);
				}
				// Close connection
				in.close();
	
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
	}
	public boolean diagnolBackwardsR(boolean continuous) {
		if(_continuousThread.isAlive())
			_continuousThread.interrupt();
		if(continuous) {
			_continuousThread = new Thread(new RJContinuousRunnable(100, this, "rev.cgi?Cmd=nav&action=18&drive=10&speed=5"));
			_continuousThread.start();
			return true;
		} else {
			try {
	
				URL url = new URL(_baseURL + "rev.cgi?Cmd=nav&action=18&drive=2&speed=5");
	
				URLConnection uc = url.openConnection();
				uc.setDoOutput(true);
	
				BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
				// Read anything returned by Rovio and print it
				String line;
				while ((line = in.readLine()) != null) {
					// System.out.println (line);
				}
				// Close connection
				in.close();
	
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
	}
	public boolean diagnolBackwardsL(boolean continuous) {
		if(_continuousThread.isAlive())
			_continuousThread.interrupt();
		if(continuous) {
			_continuousThread = new Thread(new RJContinuousRunnable(100, this, "rev.cgi?Cmd=nav&action=18&drive=9&speed=5"));
			_continuousThread.start();
			return true;
		} else {
			try {
	
				URL url = new URL(_baseURL + "rev.cgi?Cmd=nav&action=18&drive=2&speed=5");
	
				URLConnection uc = url.openConnection();
				uc.setDoOutput(true);
	
				BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
				// Read anything returned by Rovio and print it
				String line;
				while ((line = in.readLine()) != null) {
					// System.out.println (line);
				}
				// Close connection
				in.close();
	
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
	}

	public boolean cameraLow() {
		try {

			URL url = new URL(_baseURL + "rev.cgi?Cmd=nav&action=18&drive=12");

			URLConnection uc = url.openConnection();
			uc.setDoOutput(true);

			BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
			// Read anything returned by Rovio and print it
			String line;
			while ((line = in.readLine()) != null) {
				// System.out.println (line);
			}
			// Close connection
			in.close();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean cameraMid() {
		try {

			URL url = new URL(_baseURL + "rev.cgi?Cmd=nav&action=18&drive=13");

			URLConnection uc = url.openConnection();
			uc.setDoOutput(true);

			BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
			// Read anything returned by Rovio and print it
			String line;
			while ((line = in.readLine()) != null) {
				// System.out.println (line);
			}
			// Close connection
			in.close();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean setPath(){
	try {

		URL url = new URL(_baseURL + "rev.cgi?Cmd=nav&action=2");

		URLConnection uc = url.openConnection();
		uc.setDoOutput(true);

		BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
		// Read anything returned by Rovio and print it
		String line;
		while ((line = in.readLine()) != null) {
		System.out.println ("Recording on....");
		}
		// Close connection
		in.close();

		return true;
	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}
}
	public boolean stopPath(){
		try {

			URL url = new URL(_baseURL + "rev.cgi?Cmd=nav&action=value&name=n_value");

			URLConnection uc = url.openConnection();
			uc.setDoOutput(true);

			BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
			// Read anything returned by Rovio and print it
			String line;
			while ((line = in.readLine()) != null) {
			System.out.println ("Recording on....");
			}
			// Close connection
			in.close();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}	
	public boolean playPath(){
		try {

			URL url = new URL(_baseURL + "rev.cgi?Cmd=nav&action=6");

			URLConnection uc = url.openConnection();
			uc.setDoOutput(true);

			BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
			// Read anything returned by Rovio and print it
			String line;
			while ((line = in.readLine()) != null) {
			System.out.println ("Recording on....");
			}
			// Close connection
			in.close();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}	
	
	public boolean cameraHigh() {
		try {

			URL url = new URL(_baseURL + "rev.cgi?Cmd=nav&action=18&drive=11");

			URLConnection uc = url.openConnection();
			uc.setDoOutput(true);

			BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
			// Read anything returned by Rovio and print it
			String line;
			while ((line = in.readLine()) != null) {
				// System.out.println (line);
			}
			// Close connection
			in.close();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public int getBatteryPercent() {
		try {

			URL url = new URL(_baseURL + "rev.cgi?Cmd=nav&action=1");

			URLConnection uc = url.openConnection();
			uc.setDoOutput(true);

			BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
			// Read anything returned by Rovio and print it
			Vector<String> lines = new Vector<String>();
			String line;
			do {
				line = in.readLine();
				if(line != null)lines.add(line);
			} while(line != null);
			// Close connection
			in.close();

			String batLevelAsText = lines.lastElement().substring(9,12);
			
			return (int)( ((Integer.parseInt(batLevelAsText) - 100.0) / 27.0) * 100.0 );
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	public boolean setBlueLights(boolean fL, boolean mL, boolean bL, boolean fR, boolean mR, boolean bR) {
		int val = 0; 
		if(fL) val +=1; 
		if(mL)val += 2; 
		if(bL) val += 4; 
		if(fR) val += 8; 
		if(mR) val += 16;
		if(bR) val += 32; 		
		try {

			URL url = new URL(_baseURL + "debug.cgi?action=write_mem&address= 0xC57E4&size=0x1&value=0x1A");

			URLConnection uc = url.openConnection();
			uc.setDoOutput(true);

			BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
			// Read anything returned by Rovio and print it
			String line;
			while ((line = in.readLine()) != null) {
				// System.out.println (line);
			}
			// Close connection
			in.close();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	try {

		URL url = new URL(_baseURL + "rev.cgi?Cmd=nav&action=19&LIGHT=0"+ LIGHT = val);

		URLConnection uc = url.openConnection();
		uc.setDoOutput(true);

		BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
		// Read anything returned by Rovio and print it
		String line;
		while ((line = in.readLine()) != null) {
			// System.out.println (line);
		}
		// Close connection
		in.close();

	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}
try {

	URL url = new URL(_baseURL + "debug.cgi?action=write_mem&address=0xC57E4&size=0x1&value=0x18");

	URLConnection uc = url.openConnection();
	uc.setDoOutput(true);

	BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
	// Read anything returned by Rovio and print it
	String line;
	while ((line = in.readLine()) != null) {
		// System.out.println (line);
	}
	// Close connection
	in.close();
   return true;
} catch (Exception e) {
	e.printStackTrace();
	return false;
}
}
	
	
	
	private class RJContinuousRunnable implements Runnable
	{
		String _command;
		RJRobot _robot;
		int _delay;
		
		public RJContinuousRunnable (int milliseconds, RJRobot robot, String command) {
			_command = command;
			_robot = robot;
			_delay = milliseconds;
		}

		@Override
		public void run() {
			while(true) {
				_robot.SendCommand(_command);
				try {
					Thread.sleep(_delay);
				} catch (InterruptedException e) {
					break;
				}
			}
		}
		
	}
}
