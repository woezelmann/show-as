package com.woezelmann.showas.console;

import com.intellij.json.JsonLanguage;
import com.woezelmann.showas.ShowAsFromConsole;
import com.woezelmann.showas.ShowAsFromDebugger;

public class ShowAsJson extends ShowAsFromConsole {
    public ShowAsJson() {
        super(JsonLanguage.INSTANCE);
    }
}
