package com.valkryst.JFileLinkLabel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

public class SetTextTest {
    @Test
    public void canSetText() {
        final JFileLinkLabel label = new JFileLinkLabel("", new File("test.txt"));
        Assertions.assertEquals("", label.getText());

        label.setText("Test Text");
        Assertions.assertEquals("<html><u>Test Text</u></html>", label.getText());
    }

    @Test
    public void canSetTextToNull() {
        final JFileLinkLabel label = new JFileLinkLabel("", new File("test.txt"));
        Assertions.assertEquals("", label.getText());

        label.setText(null);
        Assertions.assertNull(label.getText());
    }

    @Test
    public void canSetTextToEmptyString() {
        final JFileLinkLabel label = new JFileLinkLabel("", new File("test.txt"));
        Assertions.assertEquals("", label.getText());

        label.setText("");
        Assertions.assertEquals("", label.getText());
    }
}
