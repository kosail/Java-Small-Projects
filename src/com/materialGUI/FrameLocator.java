package com.materialGUI;

import java.awt.Dimension;
import java.awt.Toolkit;

public class FrameLocator {
    private final Dimension screenResolution; // final because it will never change, and doesn't need to.
    private Dimension frameDimensions, centerLocation; // Declaring windowDimensions and centerLocation here as they are used across different methods, and not just one.

    public FrameLocator(Toolkit osToolkit) { // Constructor
        screenResolution = osToolkit.getScreenSize();
        frameDimensions = new Dimension(screenResolution.width/2,screenResolution.height/2); // Setting the frameDimensions to the half size of the screen, both in width and height.
        centerLocation = new Dimension((screenResolution.width-frameDimensions.width)/2, (screenResolution.height-frameDimensions.height)/2); // Setting the initial location of the Frame in the center.
    }

    void setWindowSize(int windowWidth, int windowHeight) { // This setter method is for changing the frame initial size to a custom one.
        frameDimensions = new Dimension(windowWidth, windowHeight); // Replacing windowDimension values with the ones handled by the user.
        centerLocation = new Dimension((screenResolution.width-windowWidth)/2, (screenResolution.height-windowHeight)/2);
    }

    // Getter methods to provide frame size and frame location.
    Dimension getFrameSize() {
        return frameDimensions;
    }

    Dimension getFrameLocation() {
        return centerLocation;
    }

}