package com.woezelmann.showas.button;

import com.intellij.ui.EditorTextField;

import javax.swing.*;
import java.awt.*;

public class NorthButton extends Button {
    private final JPanel panel;
    private final JPanel northButtons;
    private final EditorTextField textField;

    public NorthButton(String label, JPanel main, JPanel northButtons, EditorTextField textField) throws HeadlessException {
        super(label);
        this.panel = main;
        this.northButtons = northButtons;
        this.textField = textField;
    }

    public void init() {
        final int count = northButtons.getComponentCount();
        this.addActionListener(e -> {

            panel.remove(0);
            panel.add(textField, 0);
            panel.revalidate();
            panel.repaint();

            int currentCount = northButtons.getComponentCount();
            for (int i = count + 1; i < currentCount; i++) {
                northButtons.remove(count + 1);
            }
        });

        northButtons.add(this);
    }
}
