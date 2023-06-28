package com.woezelmann.showas.debugger

import com.intellij.lang.Language
import com.intellij.openapi.actionSystem.AnActionEvent

import com.intellij.xdebugger.impl.ui.tree.XDebuggerTree
import com.intellij.xdebugger.impl.ui.tree.nodes.XValueNodeImpl
import com.woezelmann.showas.ShowAs


open class ShowAsFromDebugger(language: Language) : ShowAs(language) {
    override fun fetchValue(event: AnActionEvent?): String? {

        val tree = XDebuggerTree.getTree(event);
        val lastPathComponent: XValueNodeImpl = tree?.leadSelectionPath?.lastPathComponent as XValueNodeImpl;
        return lastPathComponent.rawValue;

    }
}