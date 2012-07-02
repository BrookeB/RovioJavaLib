package com.github.RovioJavaLib.TEST;

// Import the basic graphics classes.
import java.awt.*;
import javax.swing.*;

public class ShowImage extends JPanel{
  Image image; // Declare a name for our Image object.

// Create a constructor method
  public ShowImage(Image img){
   super();
   // Load an image file into our Image object. 
   // This file has to be in the same
   // directory as ShowImage.class.
   image = img;
  }

// The following methods are instance methods.

/* Create a paintComponent() method to override the one in
JPanel.
This is where the drawing happens.
We don't have to call it in our program, it gets called
automatically whenever the panel needs to be redrawn,
like when it it made visible or moved or whatever.
*/
  public void paintComponent(Graphics g){

   // Draw our Image object.
   g.drawImage(image,50,10,200,200, this); // at location 50,10
     // 200 wide and high
  }
}