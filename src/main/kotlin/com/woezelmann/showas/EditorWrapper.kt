package com.woezelmann.showas

import com.intellij.ui.EditorTextField
import java.awt.BorderLayout
import java.awt.Dimension
import javax.swing.JComponent
import javax.swing.JPanel

import com.intellij.lang.Language;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;


class EditorWrapper : DialogWrapper {
    private val panel = JPanel(BorderLayout())

    constructor(language: Language, project: Project, text: String) : super(project){
        super.setOKActionEnabled(false)
        init()
        val editorTextField: EditorTextField = ScrollableLanguageTextField(language, project, text)
        editorTextField.setOneLineMode(false)
        editorTextField.preferredSize = Dimension(800, 600)
        editorTextField.isVisible = true
        panel.add(editorTextField)
    }

    override fun createCenterPanel(): JComponent {
        return panel
    }
}