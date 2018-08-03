package com.woezelmann.showas.console;

import com.intellij.openapi.fileTypes.PlainTextLanguage;
import com.woezelmann.showas.ShowAsFromConsole;
import com.woezelmann.showas.ShowAsFromDebugger;

import java.util.Base64;

public class ShowAsDecodedBase64 extends ShowAsFromConsole {
    public ShowAsDecodedBase64() {
        super(PlainTextLanguage.INSTANCE);
    }

    @Override
    public String preProcessValue(String value) {
        return new String(Base64.getDecoder().decode(value.getBytes()));
    }
}
