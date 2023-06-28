package com.woezelmann.showas.console

import com.intellij.lang.Language
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.PlatformDataKeys
import com.intellij.openapi.editor.Editor
import com.woezelmann.showas.ShowAs


open class ShowAsFromConsole(language: Language) : ShowAs(language) {
    override fun fetchValue(event: AnActionEvent?): String? {
        val data: Editor? = event!!.getData(PlatformDataKeys.EDITOR)
        return data?.getSelectionModel()?.getSelectedText()
    }
}