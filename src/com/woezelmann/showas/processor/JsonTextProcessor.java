package com.woezelmann.showas.processor;

import com.intellij.json.JsonLanguage;
import com.intellij.lang.Language;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiFileFactory;
import com.intellij.psi.codeStyle.CodeStyleManager;
import com.intellij.ui.EditorTextField;
import com.woezelmann.showas.ScrollableLanguageTextField;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class JsonTextProcessor extends BufferedTextProcessor {

    public JsonTextProcessor(Project project) {
        super(project, JsonLanguage.INSTANCE);
    }

    @Override
    protected EditorTextField format(EditorTextField source) {
        final PsiFile psiFile = PsiFileFactory.getInstance(project).createFileFromText(language, source.getText());
        final PsiElement reformat = CodeStyleManager.getInstance(project).reformat(psiFile.copy());

        EditorTextField editorTextField = createEditorTextField(language, project, reformat.getText());
        return editorTextField;
    }

    @NotNull
    private EditorTextField createEditorTextField(Language language, Project project, String text) {
        EditorTextField editorTextField = new ScrollableLanguageTextField(language, project, text);
        editorTextField.setOneLineMode(false);
        editorTextField.setPreferredSize(new Dimension(800, 600));
        return editorTextField;
    }
}
