package com.valkryst.JFileLinkLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.net.URI;
import java.nio.file.Path;
import java.util.Objects;
import java.util.logging.Logger;

public class JFileLinkLabel extends JLabel implements MouseListener {
    /** {@link Logger} for this class. */
    private final Logger logger = Logger.getLogger(JFileLinkLabel.class.getName());

    /** The {@link URI} to link to. */
    private final URI uri;

    /**
     * <p>The color of the text when the mouse is not hovering over it.</p>
     *
     * <p>This defaults to the <i>textHighlight</i> color from the current {@link UIManager} theme.</p>
     */
    private Color foregroundColor = UIManager.getColor("textHighlight");

    /** The brightness multiplier used to calculate the color of the text when the mouse is hovering over it. */
    private float brightnessMultiplier = 0.4f;

    /**
     * Constructs a new {@link JFileLinkLabel}.
     *
     * @param text Text to display on the label.
     * @param file {@link File} to link to.
     */
    public JFileLinkLabel(final String text, final File file) {
        this(text, file.toURI());
    }

    /**
     * Constructs a new {@link JFileLinkLabel}.
     *
     * @param text Text to display on the label.
     * @param path {@link Path} to link to.
     */
    public JFileLinkLabel(final String text, final Path path) {
        this(text, path.toUri());
    }

    /**
     * Constructs a new {@link JFileLinkLabel}.
     *
     * @param text Text to display on the label.
     * @param uri  {@link URI} to link to.
     */
    public JFileLinkLabel(final String text, final URI uri) {
        Objects.requireNonNull(text);
        Objects.requireNonNull(uri);

        this.uri = uri.normalize();

        this.setForeground(UIManager.getColor("textHighlight"));
        this.setText(text);
    }

    /**
     * Constructs a new {@link JFileLinkLabel}.
     *
     * @param file {@link File} to link to.
     */
    public JFileLinkLabel(final File file) {
        this(file.toURI());
    }

    /**
     * Constructs a new {@link JFileLinkLabel}.
     *
     * @param path {@link Path} to link to.
     */
    public JFileLinkLabel(final Path path) {
        this(path.toUri());
    }

    /**
     * Constructs a new {@link JFileLinkLabel}.
     *
     * @param uri {@link URI} to link to.
     */
    public JFileLinkLabel(final URI uri) {
        this(uri.toString(), uri);
    }

    @Override
    public void mouseClicked(final MouseEvent e) {
        if (!Desktop.isDesktopSupported()) {
            logger.warning("The Desktop class is not supported on this platform.");
            return;
        }

        try {
            final Desktop desktop = Desktop.getDesktop();

            if (uri.getScheme().equalsIgnoreCase("file")) {
                if (desktop.isSupported(Desktop.Action.OPEN)) {
                    desktop.open(new File(uri));
                } else {
                    logger.warning("Desktop.Action.OPEN is not supported on this platform.");
                }
            } else {
                if (desktop.isSupported(Desktop.Action.BROWSE)) {
                    desktop.browse(uri);
                } else {
                    logger.warning("Desktop.Action.BROWSE is not supported on this platform.");
                }
            }
        } catch (final Exception ex) {
            logger.warning("Failed to check whether URI is a valid filesystem path: " + ex.getMessage());
        }
    }

    @Override
    public void mousePressed(final MouseEvent e) {}

    @Override
    public void mouseReleased(final MouseEvent e) {}

    @Override
    public void mouseEntered(final MouseEvent e) {
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        super.setForeground(brighterColor(foregroundColor));
    }

    @Override
    public void mouseExited(final MouseEvent e) {
        this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        super.setForeground(foregroundColor);
    }

    @Override
    public void setForeground(final Color foregroundColor) {
        this.foregroundColor = foregroundColor;
        super.setForeground(foregroundColor);
    }

    @Override
    public void setText(final String text) {
        super.setText("<html><u>" + text + "</u></html>");
    }

    /**
     * <p>Calculates a brighter color based on the given color and the brightness multiplier.</p>
     *
     * <p>
     *     We cannot use {@link Color#brighter()} as it does not work well with colours that are already as bright
     *     as they can be. See <a href="https://stackoverflow.com/a/18648235/13279616">here</a> for more information.
     * </p>
     *
     * @param color {@link Color} to brighten.
     * @return Brightened {@link Color}.
     */
    private Color brighterColor(final Color color) {
        Objects.requireNonNull(color);

        return new Color(
            Math.round(Math.min(255, color.getRed() + 255 * brightnessMultiplier)),
            Math.round(Math.min(255, color.getGreen() + 255 * brightnessMultiplier)),
            Math.round(Math.min(255, color.getBlue() + 255 * brightnessMultiplier)),
            color.getAlpha()
        );
    }

    /**
     * Sets a new value for {@link #brightnessMultiplier}.
     *
     * @param brightnessMultiplier The new value.
     */
    public void setBrightnessMultiplier(final float brightnessMultiplier) {
        if (brightnessMultiplier < 0) {
            throw new IllegalArgumentException("Brightness multiplier must be greater than or equal to 0.");
        }

        if (brightnessMultiplier > 1) {
            throw new IllegalArgumentException("Brightness multiplier must be less than or equal to 1.");
        }

        this.brightnessMultiplier = brightnessMultiplier;
    }
}
