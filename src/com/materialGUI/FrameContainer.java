package com.materialGUI;

// Basic imports required to build the Window.
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Toolkit;
import java.awt.Dimension;
// For the frame styles, like icon, background image, etc...
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.SystemColor;

class FrameContainer extends JFrame {
    private BasePanel basePanel; // Encapsulation of basePanel Object and also for being able to call the Object methods in the setBackground method.

    public FrameContainer (String windowName, FrameLocator frameLocation) { // First parameter is self-explanatory, while the second one is used for setting the frame location, plus creating a panel of the same size as the frame.
        this.setTitle(windowName);
        this.setBounds(frameLocation.getFrameLocation().width,frameLocation.getFrameLocation().height,frameLocation.getFrameSize().width,frameLocation.getFrameSize().height); // Here we are calling frameLocator on its methods gerFrameLocation and getFrameSize. however, as the method JFrame.setBounds takes four arguments which all should be int type, we have to specifically call the method for each individual int return field. Remember: setBounds(posX, posY, sizeX, sizeY)
        
        basePanel = new BasePanel(frameLocation.getFrameSize()); // Creating a new Panel and handling the Frame size to the BasePanel constructor, thus over there in the BasePanel Class we can use that data to set the Panel to the same size as the Frame.
        this.getContentPane().add(basePanel); // Adding the created basePanel Object we just created (JPanel Object Type) to the Frame.
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    // This method can be called from other places inside the package and is used for changing the background color of the basePanel.
    void setBackground(int red, int green, int blue) {
        basePanel.changeBackgroundColor(red, green, blue);
    }

    // This is the same as the above, but instead of a color, sets an image as the background.
    void setBackground(String imagePath) {
        basePanel.changeBackgroundImage(imagePath);
    }

    // Siple method to set or change the Icon of the App. It's like the known "favicon", but in png, jpg or gif format.
    void setIcon(Toolkit osToolkit, String imagePath) {
        Image iconImage = osToolkit.getImage(imagePath); // Create an Image Object type with the path of the image.
        this.setIconImage(iconImage); // Set the icon using JFrame.setIconImage
    }
}

class BasePanel extends JPanel {
    private Color backgroundColor = SystemColor.window; // If no color is handled, the Panel will start with the OS standard color.
    private Image backgroundImage; // Instancing the backgroundImage Image Object here because we need to use it in two methods, which are the changeBackground one, and the paintComponent one. If we don't do this, the paintComponent one will not get any image to draw, as the backGroundImage object will be a local variable of changeBackgroundImage method.

    public BasePanel(Dimension frameSize) { // Constructor
        setPanelBGColor(backgroundColor); // Starts the Panel using the SystemColor.window
        this.setPreferredSize(frameSize); // Sets the Panel size to the same as the Frame, and keep it as that big. Interestingly here, the method JPanel.setPreferredSize receives Dimension type Objects.
    }

    // Change the default color of the Panel (which is the SystemColor) to the one handled in RBG.
    void changeBackgroundColor(int red, int green, int blue) {
        // Using Math methods to avoid values under 0 or greater than 255, which can throw an Exception if not handled. No RGB color can be below 0 nor higher than 255.
        red = Math.max(0, Math.min(255, red));
        green = Math.max(0, Math.min(255, green));
        blue = Math.max(0, Math.min(255, blue));

        setPanelBGColor(new Color(red, green, blue));
    }

    // Simple use JPanel.setBackground to change the background color. This method is called by the constructor to paint the initial color, but also by changeBackgroundColor to make changes at any moment.
    private void setPanelBGColor(Color backgroundColor) {
        this.setBackground(backgroundColor);
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
       g.drawImage(backgroundImage,0,0, this.getWidth(), this.getHeight(), this);
    }
}