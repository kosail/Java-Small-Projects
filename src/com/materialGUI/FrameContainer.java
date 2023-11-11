package com.materialGUI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Color;

class FrameContainer extends JFrame {
    private BaseLabel baseLabel;

    public FrameContainer (String windowName, FrameLocator windowPosition) {
        this.setTitle(windowName);
        this.setBounds(windowPosition.getFrameLocation().width,windowPosition.getFrameLocation().height,windowPosition.getWindowSize().width,windowPosition.getWindowSize().height);
        
        baseLabel = new BaseLabel();
        this.getContentPane().add(baseLabel);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    void setBackground(int red, int green, int blue) {
        baseLabel.changeBackgroundColor(red, green, blue);
    }

    void setBackground(String imagePath) {
        baseLabel.changeBackgroundImage(imagePath);
    }

    void setIcon(Toolkit osToolkit, String imagePath) {
        Image iconImage = osToolkit.getImage(imagePath);
        this.setIconImage(iconImage);
    }
}

class BaseLabel extends JLabel {
    private Color backgroundColor = Color.WHITE;
    private Image backgroundImage;

    public BaseLabel() {
        this.setOpaque(true);
        setLabelBGColor(backgroundColor);
    }

    void changeBackgroundColor(int red, int green, int blue) {
        red = Math.max(0, Math.min(255, red));
        green = Math.max(0, Math.min(255, green));
        blue = Math.max(0, Math.min(255, blue));
        
        backgroundColor = new Color(red, green, blue);
        setLabelBGColor(backgroundColor);
    }
    
    private void setLabelBGColor(Color backgroundColor) {
        this.setBackground(backgroundColor); 
    }

    void changeBackgroundImage(String imagePath) {
        ImageIcon bgImage = new ImageIcon(imagePath);
        backgroundImage = bgImage.getImage();
        repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
       super.paintComponent(g);

       // Obtener las dimensiones del JLabel
       g.drawImage(backgroundImage,0,0, this.getWidth(), this.getHeight(), this);
    }
    
}
