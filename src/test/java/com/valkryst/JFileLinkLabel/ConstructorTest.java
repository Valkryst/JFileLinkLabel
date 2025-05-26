package com.valkryst.JFileLinkLabel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConstructorTest {
    @Test
    public void canConstructWithStringAndFile() {
        new JFileLinkLabel("Test", new File("test.txt"));
    }

    @Test
    public void cannotConstructWithNullStringAndFile() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            new JFileLinkLabel(null, new File("test.txt"));
        });
    }

    @Test
    public void cannotConstructWithStringAndNullFile() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            new JFileLinkLabel("Test", (File) null);
        });
    }

    @Test
    public void canConstructWithStringAndPath() {
        new JFileLinkLabel("Test", Paths.get("test.txt"));
    }

    @Test
    public void cannotConstructWithNullStringAndPath() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            new JFileLinkLabel(null, Paths.get("test.txt"));
        });
    }

    @Test
    public void cannotConstructWithStringAndNullPath() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            new JFileLinkLabel("Test", (Path) null);
        });
    }

    @Test
    public void canConstructWithStringAndURI() {
        new JFileLinkLabel("Test", Paths.get("test.txt").toUri());
    }

    @Test
    public void cannotConstructWithNullStringAndURI() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            new JFileLinkLabel(null, Paths.get("test.txt").toUri());
        });
    }

    @Test
    public void cannotConstructWithStringAndNullURI() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            new JFileLinkLabel("Test", (java.net.URI) null);
        });
    }

    @Test
    public void canConstructWithFile() {
        new JFileLinkLabel(new File("test.txt"));
    }

    @Test
    public void cannotConstructWithNullFile() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            new JFileLinkLabel((File) null);
        });
    }

    @Test
    public void canConstructWithPath() {
        new JFileLinkLabel(Paths.get("test.txt"));
    }

    @Test
    public void cannotConstructWithNullPath() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            new JFileLinkLabel((Path) null);
        });
    }

    @Test
    public void canConstructWithURI() {
        new JFileLinkLabel(Paths.get("test.txt").toUri());
    }

    @Test
    public void cannotConstructWithNullURI() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            new JFileLinkLabel((java.net.URI) null);
        });
    }
}
