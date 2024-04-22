package com.materialGUI;

import java.io.File;
import java.io.IOException;
import java.awt.Font;
import java.awt.FontFormatException;

public class CustomFont {
    public static Font loadFont(String fontPath) {
        try {
			return Font.createFont(Font.TRUETYPE_FONT, new File(fontPath));
		} catch (IOException | FontFormatException e) {
			return new Font("Arial", Font.PLAIN, 12);
		}
    }
}
