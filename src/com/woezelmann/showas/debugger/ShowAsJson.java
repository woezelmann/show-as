package com.woezelmann.showas.debugger;

import com.intellij.json.JsonLanguage;
import com.woezelmann.showas.ShowAsFromDebugger;

public class ShowAsJson extends ShowAsFromDebugger {
    public ShowAsJson() {
        super(JsonLanguage.INSTANCE);
    }
}
