package com.woezelmann.showas

import com.intellij.lang.Language
import com.intellij.openapi.editor.ex.EditorEx
import com.intellij.openapi.project.Project
import com.intellij.ui.LanguageTextField

class ScrollableLanguageTextField(language: Language, project: Project, s: String) :
    LanguageTextField(language, project, s) {

    override fun createEditor(): EditorEx {
        val editor = super.createEditor()
        editor.setVerticalScrollbarVisible(true);
        editor.setHorizontalScrollbarVisible(true);
        return editor
    }
}