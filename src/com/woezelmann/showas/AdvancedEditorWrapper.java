package com.woezelmann.showas;

import com.intellij.json.JsonLanguage;
import com.intellij.lang.Language;
import com.intellij.lang.xml.XMLLanguage;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiFileFactory;
import com.intellij.psi.codeStyle.CodeStyleManager;
import com.intellij.ui.EditorTextField;
import com.woezelmann.showas.button.NorthButton;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;


public class AdvancedEditorWrapper extends DialogWrapper {

    private JPanel panel = new JPanel(new BorderLayout());
    private JPanel northButtons = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel southButtons = new JPanel(new FlowLayout(FlowLayout.LEFT));

    protected AdvancedEditorWrapper(Project project, String text) {
        super(project);
        super.setOKActionEnabled(false);

        init();

        EditorTextField editorTextField = createEditorTextField(JsonLanguage.INSTANCE, project, text);
        editorTextField.setVisible(true);

        panel.add(northButtons, BorderLayout.NORTH);
        panel.add(editorTextField);
        panel.add(southButtons, BorderLayout.SOUTH);

        new NorthButton("SOURCE", panel, northButtons, editorTextField).init();

        createSouthButton(JsonLanguage.INSTANCE, project, "JSON");

    }

    @Override
    protected JComponent createCenterPanel() {
        return panel;
    }
}
