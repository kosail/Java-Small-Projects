package com.materialGUI;

import java.awt.Toolkit;

public class MaterialGUI {
    public static void main(String[] args) {
        Toolkit osToolkit = Toolkit.getDefaultToolkit();
        FrameLocator frameLocator = new FrameLocator(osToolkit);
        
        FrameContainer mainFrame = new FrameContainer("Test", frameLocator);
        // mainFrame.setIcon(osToolkit, "0.jpg");
        // mainFrame.setBackground("0.png");
    }
}
