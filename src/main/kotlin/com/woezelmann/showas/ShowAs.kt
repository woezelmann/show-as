package com.woezelmann.showas

import com.intellij.json.JsonLanguage
import com.intellij.lang.Language
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiFileFactory
import com.intellij.psi.codeStyle.CodeStyleManager


abstract class ShowAs(val language: Language) : AnAction() {

    override fun actionPerformed(event: AnActionEvent) {

        val text: String? = fetchValue(event)

        if (text == null) {
            return
        }

        val project: Project? = event.getProject()
        val psiFile: PsiFile = PsiFileFactory.getInstance(project).createFileFromText(language, text)

        val reformat = CodeStyleManager.getInstance(project!!).reformat(psiFile.copy())

        val editorWrapper = EditorWrapper(JsonLanguage.INSTANCE, project, reformat.text)
        editorWrapper.show()

    }

    abstract fun fetchValue(event: AnActionEvent?): String?

}