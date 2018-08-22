package com.woezelmann.showas.button;

import com.intellij.ui.EditorTextField;

import javax.swing.*;
import java.awt.*;

public class SouthButton extends Button{
    private final JPanel panel;
    private final JPanel southButtons;
    private final EditorTextField textField;

    public SouthButton(String label, JPanel main, JPanel southButtons, EditorTextField textField) throws HeadlessException {
        super(label);
        this.panel = main;
        this.southButtons = southButtons;
        this.textField = textField;
    }

    public void init() {
        this.addActionListener(e -> {
            panel.remove(0);
            panel.add(textField, 0);
            panel.revalidate();
            panel.repaint();
        });

        southButtons.add(this);
    }
}
