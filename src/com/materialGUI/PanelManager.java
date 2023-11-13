package com.materialGUI;

// For the frame styles, like icon, background image, etc...
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Dimension;

class PanelManager extends JPanel {
    private Image backgroundImage; // Instancing the backgroundImage Image Object here because we need to use it in two methods, which are the changeBackground one, and the paintComponent one. If we don't do this, the paintComponent one will not get any image to draw, as the backGroundImage object will be a local variable of changeBackgroundImage method.

    public PanelManager(Dimension frameSize) { // Constructor
        this.setBackground(SystemColor.window); // Starts the Panel using the SystemColor.window
        this.setPreferredSize(frameSize); // Sets the Panel size to the same as the Frame, and keep it as that big. Interestingly here, the method JPanel.setPreferredSize receives Dimension type Objects.
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
