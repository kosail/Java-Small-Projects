package com.materialGUI;

// Basic imports required to build the Window.
import javax.swing.JFrame;
import java.awt.Toolkit;
// For the frame styles, like icon, background image, etc...
import java.awt.Image;
import java.awt.Color;

public class FrameContainer extends JFrame {

    public FrameContainer (String windowName, FrameLocator frameLocation, PanelManager basePanel) { // First parameter is self-explanatory, while the second one is used for setting the frame location, plus creating a panel of the same size as the frame.
        this.setTitle(windowName);
        this.setBounds(
                frameLocation.getFrameLocation().width,
                frameLocation.getFrameLocation().height,
                frameLocation.getFrameSize().width,
                frameLocation.getFrameSize().height
        ); // Here we are calling frameLocator on its methods gerFrameLocation and getFrameSize. however, as the method JFrame.setBounds takes four arguments which all should be int type, we have to specifically call the method for each individual int return field. Remember: setBounds(posX, posY, sizeX, sizeY)
        this.getContentPane().add(basePanel); // Adding the created basePanel Object we just created (JPanel Object Type) to the Frame.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Simple method to set or change the Icon of the App. It's like the known "favicon", but in png, jpg or gif format.
    void setIcon(Toolkit osToolkit, String imagePath) {
        if (osToolkit != null && imagePath != null) {
            Image iconImage = osToolkit.getImage(imagePath); // Create an Image Object type with the path of the image.
            this.setIconImage(iconImage); // Set the icon using JFrame.setIconImage
        } else {
            System.out.println("Advertencia: El Toolkit o la Image son objetos null.");
        }
    }
}