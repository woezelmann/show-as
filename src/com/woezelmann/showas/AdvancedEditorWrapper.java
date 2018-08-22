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

        panel.add(editorTextField);
        panel.add(northButtons, BorderLayout.NORTH);
        panel.add(southButtons, BorderLayout.SOUTH);

        new NorthButton("SOURCE", panel, northButtons, editorTextField).init();

        createSouthButton(JsonLanguage.INSTANCE, project, "JSON");
        createSouthButton(XMLLanguage.INSTANCE, project, "XML");
    }



    @NotNull
    private Button createSouthButton(Language language, Project project, String name) {
        Button comp = new Button(name);
        comp.addActionListener(e -> {
            EditorTextField textField = (EditorTextField) panel.getComponent(0);

            final PsiFile psiFile = PsiFileFactory.getInstance(project).createFileFromText(language, textField.getText());
            final PsiElement reformat = CodeStyleManager.getInstance(project).reformat(psiFile.copy());

            EditorTextField editorTextField = createEditorTextField(language, project, reformat.getText());
            panel.remove(0);
            panel.add(editorTextField, 0);
            panel.revalidate();
            panel.repaint();

            northButtons.add(new Label(">"));
            new NorthButton(name, panel, northButtons, textField).init();
        });

        southButtons.add(comp);
        return comp;
    }

    @NotNull
    private EditorTextField createEditorTextField(Language language, Project project, String text) {
        EditorTextField editorTextField = new ScrollableLanguageTextField(language, project, text);
        editorTextField.setOneLineMode(false);
        editorTextField.setPreferredSize(new Dimension(800, 600));
        return editorTextField;
    }

    @Override
    protected JComponent createCenterPanel() {
        return panel;
    }
}
