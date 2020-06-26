package com.woezelmann.showas.console;

import com.intellij.json.JsonLanguage;
import com.woezelmann.showas.ShowAsFromConsole;

public class ShowAsJson extends ShowAsFromConsole {
    public ShowAsJson() {
        super(JsonLanguage.INSTANCE);
    }
}
