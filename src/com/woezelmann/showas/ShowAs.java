package com.woezelmann.showas;

import com.intellij.lang.Language;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiFileFactory;
import com.intellij.psi.codeStyle.CodeStyleManager;

public abstract class ShowAs extends AnAction {

    private final Language language;

    public ShowAs(Language language) {
        this.language = language;
    }

    @Override
    public void actionPerformed(AnActionEvent event) {

        String text = fetchValue(event);

        if (text == null) {
            return;
        }

        final Project project = event.getProject();
        final PsiFile psiFile = PsiFileFactory.getInstance(project).createFileFromText(language, preProcessValue(text));
        final PsiElement reformat = CodeStyleManager.getInstance(project).reformat(psiFile.copy());

        EditorWrapper editorWrapper = new EditorWrapper(language, project, reformat.getText());
        editorWrapper.show();
    }

    public abstract String fetchValue(AnActionEvent event);

    public String preProcessValue(String value) {
        return value;
    }
}
