package com.woezelmann.showas.console;

import com.intellij.json.JsonLanguage;
import com.woezelmann.showas.ShowAsFromConsole;
import com.woezelmann.showas.ShowAsFromDebugger;

import java.util.Base64;

public class ShowAsDecodedBase64Json extends ShowAsFromConsole {
    public ShowAsDecodedBase64Json() {
        super(JsonLanguage.INSTANCE);
    }

    @Override
    public String preProcessValue(String value) {
        return new String(Base64.getDecoder().decode(value.getBytes()));
    }
}
