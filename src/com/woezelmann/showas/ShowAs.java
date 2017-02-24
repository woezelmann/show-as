package com.woezelmann.showas;

import com.intellij.debugger.actions.ViewAsGroup;
import com.intellij.debugger.engine.JavaValue;
import com.intellij.lang.Language;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiFileFactory;
import com.intellij.psi.codeStyle.CodeStyleManager;
import com.intellij.sql.dialects.SqlLanguageDialect;
import com.intellij.sql.psi.SqlLanguage;
import com.sun.jdi.Value;
import com.sun.tools.jdi.StringReferenceImpl;

import java.util.List;

public class ShowAs extends AnAction {

    private final Language language;

    public ShowAs(Language language) {
        this.language = language;
    }

    @Override
    public void actionPerformed(AnActionEvent event) {
        final List<JavaValue> selectedValues = ViewAsGroup.getSelectedValues(event);
        if (selectedValues.size() == 0) return;

        final Project project = event.getProject();
        final Value value = selectedValues.get(0).getDescriptor().getValue();

        if (value instanceof com.sun.tools.jdi.StringReferenceImpl) {

            final String text = ((StringReferenceImpl) value).value();
            final PsiFile psiFile = PsiFileFactory.getInstance(project).createFileFromText(language, preProcessValue(text));
            final PsiElement reformat = CodeStyleManager.getInstance(project).reformat(psiFile.copy());

            EditorWrapper editorWrapper = new EditorWrapper(language, project, reformat.getText());
            editorWrapper.show();
        }
    }

    public String preProcessValue(String value) {
        return value;
    }
}
