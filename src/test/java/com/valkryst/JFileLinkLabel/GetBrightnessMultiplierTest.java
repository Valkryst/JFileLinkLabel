package com.valkryst.JFileLinkLabel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

public class GetBrightnessMultiplierTest {
    @Test
    public void canGetBrightnessMultiplier() {
        final JFileLinkLabel label = new JFileLinkLabel("Test", new File("test.txt"));
        Assertions.assertEquals(0.4f, label.getBrightnessMultiplier());
    }
}
