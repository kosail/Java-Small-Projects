package com.materialGUI;

public class MaterialGUI {
    public static void main(String[] args) {
        FrameLocator frameLocator = new FrameLocator(); // Instance new FrameLocator Object type to set the Frame's dimensions and initial Location. We can always change the Frame's size with the method frameLocator provides. However, as for now, I have not created any setter for new initial location. They will always start centered in the screen.
//        frameLocator.setWindowSize(200,200);
        PanelManager mainPanel = new PanelManager(frameLocator.getFrameSize());
        
        FrameContainer mainFrame = new FrameContainer("Test", frameLocator, mainPanel); // New Frame and handling over the Frame name and the frameLocator Object, which will be helpful to get the screen size, Frame size and other stuff directly from the FrameContainer class.

        mainPanel.setBackgroundColor("04ded0");
        // mainFrame.setIcon(osToolkit, "0.jpg");
        // mainFrame.setBackground("0.png");
//        mainFrame.setUndecorated(true);
        mainFrame.setVisible(true);
    }
}
