package com.woezelmann.showas;

import com.intellij.lang.Language;
import com.intellij.openapi.editor.ex.EditorEx;
import com.intellij.openapi.project.Project;
import com.intellij.ui.LanguageTextField;

import java.awt.*;

public class ScrollableLanguageTextField extends LanguageTextField {
    public ScrollableLanguageTextField(Language language, Project project, String s) {
        super(language, project, s);
    }

    @Override
    protected EditorEx createEditor() {
        final EditorEx editor = super.createEditor();
        editor.setVerticalScrollbarVisible(true);
        editor.setHorizontalScrollbarVisible(true);
        return editor;

    }
}
