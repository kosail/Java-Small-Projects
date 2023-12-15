package com.materialGUI;

// For the frame styles, like icon, background image, etc...
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Dimension;
//import com.materialGUI.design.*;

public class PanelManager extends JPanel {
    private Image backgroundImage; // Instancing the backgroundImage Image Object here because we need to use it in two methods, which are the changeBackground one, and the paintComponent one. If we don't do this, the paintComponent one will not get any image to draw, as the backGroundImage object will be a local variable of changeBackgroundImage method.

    public PanelManager(Dimension frameSize) { // Constructor
        this.setBackground(SystemColor.window); // Starts the Panel using the SystemColor.window
        this.setPreferredSize(frameSize); // Sets the Panel size to the same as the Frame, and keep it as that big. Interestingly here, the method JPanel.setPreferredSize receives Dimension type Objects.
    }

    // This method is used for changing the background color of the basePanel.
    void setBackgroundColor(int red, int green, int blue) {
        // Using Math methods to avoid values under 0 or greater than 255, which can throw an Exception if not handled. No RGB color can be below 0 nor higher than 255.
        red = Math.max(0, Math.min(255, red));
        green = Math.max(0, Math.min(255, green));
        blue = Math.max(0, Math.min(255, blue));

        this.changeBackgroundColor(new Color(red, green, blue)); // Calls changeBackgroundColor method and handles a new Color Object type using the three RBG values.
    }

    public void setBackgroundColor(String hexColor) {
        try {
            if (hexColor.startsWith("#")) { // If there is a # at the beginning, then remove it using substring and continue to parse the hex number to an int one.
                hexColor = hexColor.substring(1); //Replace the string by the same content but beginning in the position 1.
            }
            this.changeBackgroundColor(new Color(Integer.parseInt(hexColor, 16))); // Parses to int base 10 the hexColor String using base 16 or radix 16. Then, gives that int to Color, which creates a new Color Object type, and then it is handled to the method changeBackgroundColor.
        } catch (NumberFormatException e) {
            e.getCause();
        }
    }

    // This is the same as the above, but instead of a color, sets an image as the background.
    void setBackgroundImage(String imagePath) {
        this.changeBackgroundImage(imagePath);
    }

    // Change the default color of the Panel (which is the SystemColor) to the one handled in a Color Object.
    void changeBackgroundColor(Color newBGColor) {
        this.setBackground(newBGColor);
    }

    void changeBackgroundImage(String imagePath) {
        ImageIcon bgImage = new ImageIcon(imagePath); // Instances an ImageIcon Object type called bgImage, which contains the image at the handled Path.
        backgroundImage = bgImage.getImage(); // Updating the value of Object backgroundImage from null to the actual image.
        repaint(); // This tells the Swing hypervisor to constantly repaint the Panel as soon as there are any changes on the state of the Frame (like changing the Frame size). Without this method here, the Frame starts without painting the background image because that event gets stuck by the Swing Hypervisor until there are new Frame updates, or until the hypervisor determines that there must be an update.
    }

    @Override
    protected void paintComponent(Graphics g) { // Overriding the paintComponent method from JFrame. This is necessary because we need to tell JFrame to make his usual behaviour, but also adding the actions that we indicate in this override method.
        super.paintComponent(g);

        // drawImage method is for render or paint the image handled.
        // g.drawImage(Image img, posX, posY, int imgWidth, int imgHeight, ImageObserver this)
        g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}
