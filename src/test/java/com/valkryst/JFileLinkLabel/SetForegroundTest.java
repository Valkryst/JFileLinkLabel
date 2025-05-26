package com.valkryst.JFileLinkLabel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.File;

public class SetForegroundTest {
    @Test
    public void canSetForeground() {
        final JFileLinkLabel label = new JFileLinkLabel("Test", new File("test.txt"));
        Assertions.assertNotEquals(Color.RED, label.getForeground());

        label.setForeground(Color.RED);
        Assertions.assertEquals(Color.RED, label.getForeground());
    }

    @Test
    public void canSetForegroundToNull() {
        final JFileLinkLabel label = new JFileLinkLabel("Test", new File("test.txt"));
        Assertions.assertNotNull(label.getForeground());

        label.setForeground(null);
        Assertions.assertNull(label.getForeground());
    }
}
