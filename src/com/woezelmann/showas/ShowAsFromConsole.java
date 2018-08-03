package com.woezelmann.showas;

import com.intellij.lang.Language;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Editor;

public class ShowAsFromConsole extends ShowAs {

    public ShowAsFromConsole(Language language) {
        super(language);
    }

    @Override
    public String fetchValue(AnActionEvent event) {
        Editor data = event.getData(PlatformDataKeys.EDITOR);
        if (data != null) {
            return data.getSelectionModel().getSelectedText();
        }

        return null;
    }
}
