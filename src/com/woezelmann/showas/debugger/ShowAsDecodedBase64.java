package com.woezelmann.showas.debugger;

import com.intellij.openapi.fileTypes.PlainTextLanguage;
import com.woezelmann.showas.ShowAsFromDebugger;

import java.util.Base64;

public class ShowAsDecodedBase64 extends ShowAsFromDebugger {
    public ShowAsDecodedBase64() {
        super(PlainTextLanguage.INSTANCE);
    }

    @Override
    public String preProcessValue(String value) {
        return new String(Base64.getDecoder().decode(value.getBytes()));
    }
}
