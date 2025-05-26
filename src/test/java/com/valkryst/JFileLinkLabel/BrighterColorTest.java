package com.valkryst.JFileLinkLabel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.Color;
import java.lang.reflect.Method;
import java.io.File;

public class BrighterColorTest {
    @Test
    public void canGenerateBrighterColor() throws Exception {
        final Color[] testColors = {
            Color.BLACK,
            Color.RED,
            Color.GREEN,
            Color.BLUE,
            Color.CYAN,
            Color.MAGENTA,
            Color.YELLOW
        };

        final Method brighterColorMethod = JFileLinkLabel.class.getDeclaredMethod("brighterColor", Color.class);
        brighterColorMethod.setAccessible(true);

        final JFileLinkLabel label = new JFileLinkLabel("Test", new File("test.txt"));

        for (final Color originalColor : testColors) {
            final Color brightenedColor = (Color) brighterColorMethod.invoke(label, originalColor);
            Assertions.assertNotEquals(originalColor, brightenedColor);
            Assertions.assertEquals(originalColor.getAlpha(), brightenedColor.getAlpha());
        }
    }
}