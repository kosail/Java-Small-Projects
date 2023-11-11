package com.materialGUI;

import java.awt.Dimension;
import java.awt.Toolkit;

public class FrameLocator {
    private Dimension screenResolution;
    private Dimension windowDimensions;
    private Dimension centerLocation;

    public FrameLocator(Toolkit osToolkit) {
        screenResolution = osToolkit.getScreenSize();
        windowDimensions = new Dimension(screenResolution.width/2,screenResolution.height/2);
        centerLocation = new Dimension((screenResolution.width-windowDimensions.width)/2, (screenResolution.height-windowDimensions.height)/2);
    }

    void setWindowSize(int windowWidth, int windowHeight) {
        windowDimensions = new Dimension(windowWidth, windowHeight);
        centerLocation = new Dimension((screenResolution.width-windowWidth)/2, (screenResolution.height-windowHeight)/2);
    }

    Dimension getWindowSize() {
        return windowDimensions;
    }

    Dimension getFrameLocation() {
        return centerLocation;
    }

}