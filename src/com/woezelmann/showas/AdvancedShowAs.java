package com.woezelmann.showas;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Editor;

public class AdvancedShowAs extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent event) {

        Editor data = event.getData(PlatformDataKeys.EDITOR);
        if (data == null) {
            return;
        }

        String selectedText = data.getSelectionModel().getSelectedText();

        AdvancedEditorWrapper editorWrapper = new AdvancedEditorWrapper(event.getProject(), selectedText);
        editorWrapper.show();
    }
}
