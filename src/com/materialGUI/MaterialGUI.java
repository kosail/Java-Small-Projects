package com.materialGUI;

import java.awt.Toolkit;

public class MaterialGUI {
    public static void main(String[] args) {
        Toolkit osToolkit = Toolkit.getDefaultToolkit(); // Creating a Toolkit Object containing the default Toolkit of the current OS
        FrameLocator frameLocator = new FrameLocator(osToolkit); // Instance new FrameLocator Object type to set the Frame's dimensions and initial Location. We can always change the Frame's size with the method frameLocator provides. However, as for now, I have not created any setter for new initial location. They will always start centered in the screen.
//        frameLocator.setWindowSize(200,200);
        
        FrameContainer mainFrame = new FrameContainer("Test", frameLocator); // New Frame and handling over the Frame name and the frameLocator Object, which will be helpful to get the screen size, Frame size and other stuff directly from the FrameContainer class.
        
        // mainFrame.setIcon(osToolkit, "0.jpg");
        // mainFrame.setBackground("0.png");
    }
}
