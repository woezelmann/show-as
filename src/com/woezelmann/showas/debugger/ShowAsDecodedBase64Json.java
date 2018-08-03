package com.woezelmann.showas.debugger;

import com.intellij.json.JsonLanguage;
import com.woezelmann.showas.ShowAsFromDebugger;

import java.util.Base64;

public class ShowAsDecodedBase64Json extends ShowAsFromDebugger {
    public ShowAsDecodedBase64Json() {
        super(JsonLanguage.INSTANCE);
    }

    @Override
    public String preProcessValue(String value) {
        return new String(Base64.getDecoder().decode(value.getBytes()));
    }
}
