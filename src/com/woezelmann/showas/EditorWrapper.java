package com.woezelmann.showas;

import com.intellij.lang.Language;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.ui.EditorTextField;

import javax.swing.*;
import java.awt.*;

/**
 * @author wozniak
 * @since 16.05.12
 */
public class EditorWrapper extends DialogWrapper {

    private JPanel panel = new JPanel(new BorderLayout());

    protected EditorWrapper(Language language, Project project, String text) {
        super(project);
        super.setOKActionEnabled(false);

        init();

        EditorTextField editorTextField = new ScrollableLanguageTextField(language, project, text);
        editorTextField.setOneLineMode(false);
        editorTextField.setPreferredSize(new Dimension(800, 600));

        editorTextField.setVisible(true);

        panel.add(editorTextField);
    }

    @Override
    protected JComponent createCenterPanel() {
        return panel;
    }
}
