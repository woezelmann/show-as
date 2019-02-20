package com.woezelmann.showas.button;

import com.intellij.ui.EditorTextField;
import com.woezelmann.showas.processor.TextProcessor;

import javax.swing.*;
import java.awt.*;

public class SouthButton extends Button{
    private final JPanel panel;
    private final JPanel southButtons;
    private final TextProcessor textProcessor;

    public SouthButton(String label, JPanel main, JPanel southButtons, TextProcessor textProcessor) throws HeadlessException {
        super(label);
        this.panel = main;
        this.southButtons = southButtons;
        this.textProcessor = textProcessor;
    }

    public void init() {
        this.addActionListener(e -> {
            EditorTextField textField = (EditorTextField) panel.getComponent(0);

            panel.remove(0);
            panel.add(textProcessor.process(textField), 0);
            panel.revalidate();
            panel.repaint();
        });

        southButtons.add(this);
    }
}
