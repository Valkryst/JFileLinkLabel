package com.valkryst.JFileLinkLabel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

public class SetBrightnessMultiplierTest {
    @Test
    public void canSetBrightnessMultiplier() {
        final JFileLinkLabel label = new JFileLinkLabel("Test", new File("test.txt"));

        final float randomVal = (float) Math.random();
        label.setBrightnessMultiplier(randomVal);
        Assertions.assertEquals(label.getBrightnessMultiplier(), randomVal);
    }

    @Test
    public void cannotSetBrightnessMultiplierOutsideOfAllowedBounds() {
        final JFileLinkLabel label = new JFileLinkLabel("Test", new File("test.txt"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            label.setBrightnessMultiplier(-0.1f);
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            label.setBrightnessMultiplier(1.1f);
        });
    }
}
