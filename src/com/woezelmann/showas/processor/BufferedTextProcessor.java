package com.woezelmann.showas.processor;

import com.intellij.lang.Language;
import com.intellij.openapi.project.Project;
import com.intellij.ui.EditorTextField;

public abstract class BufferedTextProcessor implements TextProcessor {

    protected final Project project;
    protected final Language language;

    private EditorTextField textField;

    protected BufferedTextProcessor(Project project, Language language) {
        this.project = project;
        this.language = language;
    }

    @Override
    public final EditorTextField process(EditorTextField editorTextField) {

        if (textField == null) {
            textField = format(editorTextField);
        }

        return textField;
    }

    protected abstract EditorTextField format(EditorTextField editorTextField);
}
