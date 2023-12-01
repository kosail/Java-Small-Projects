package com.materialGUI;

// Basic imports required to build the Window.
import javax.swing.JFrame;
import java.awt.Toolkit;
// For the frame styles, like icon, background image, etc...
import java.awt.Image;
import java.awt.Color;

public class FrameContainer extends JFrame {
    private final PanelManager basePanel; // Encapsulation of basePanel Object and also for being able to call the Object methods in the setBackground method.

    public FrameContainer (String windowName, FrameLocator frameLocation) { // First parameter is self-explanatory, while the second one is used for setting the frame location, plus creating a panel of the same size as the frame.
        this.setTitle(windowName);
        this.setBounds(frameLocation.getFrameLocation().width,frameLocation.getFrameLocation().height,frameLocation.getFrameSize().width,frameLocation.getFrameSize().height); // Here we are calling frameLocator on its methods gerFrameLocation and getFrameSize. however, as the method JFrame.setBounds takes four arguments which all should be int type, we have to specifically call the method for each individual int return field. Remember: setBounds(posX, posY, sizeX, sizeY)
        
        basePanel = new PanelManager(frameLocation.getFrameSize()); // Creating a new Panel and handling the Frame size to the BasePanel constructor, thus over there in the BasePanel Class we can use that data to set the Panel to the same size as the Frame.
        this.getContentPane().add(basePanel); // Adding the created basePanel Object we just created (JPanel Object Type) to the Frame.
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // This method is used for changing the background color of the basePanel.
    void setBackgroundColor(int red, int green, int blue) {
        // Using Math methods to avoid values under 0 or greater than 255, which can throw an Exception if not handled. No RGB color can be below 0 nor higher than 255.
        red = Math.max(0, Math.min(255, red));
        green = Math.max(0, Math.min(255, green));
        blue = Math.max(0, Math.min(255, blue));

        basePanel.changeBackgroundColor(new Color(red, green, blue)); // Calls changeBackgroundColor method and handles a new Color Object type using the three RBG values.
    }

    void setBackgroundColor(String hexColor) {
        if (hexColor.startsWith("#")) { // If there is a # at the beginning, then remove it using substring and continue to parse the hex number to an int one.
            hexColor = hexColor.substring(1); //Replace the string by the same content but beginning in the position 1.
        }
        basePanel.changeBackgroundColor(new Color(Integer.parseInt(hexColor, 16))); // Parses to int base 10 the hexColor String using base 16 or radix 16. Then, gives that int to Color, which creates a new Color Object type, and then it is handled to the method changeBackgroundColor.
    }

    // This is the same as the above, but instead of a color, sets an image as the background.
    void setBackgroundImage(String imagePath) {
            basePanel.changeBackgroundImage(imagePath);
    }

    // Simple method to set or change the Icon of the App. It's like the known "favicon", but in png, jpg or gif format.
    void setIcon(Toolkit osToolkit, String imagePath) {
        Image iconImage = osToolkit.getImage(imagePath); // Create an Image Object type with the path of the image.
        this.setIconImage(iconImage); // Set the icon using JFrame.setIconImage
    }
}