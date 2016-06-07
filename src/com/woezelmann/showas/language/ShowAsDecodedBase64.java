package com.woezelmann.showas.language;

import com.intellij.openapi.fileTypes.PlainTextLanguage;
import com.woezelmann.showas.ShowAs;

import java.util.Base64;

public class ShowAsDecodedBase64 extends ShowAs {
    public ShowAsDecodedBase64() {
        super(PlainTextLanguage.INSTANCE);
    }

    @Override
    public String preProcessValue(String value) {
        return new String(Base64.getDecoder().decode(value.getBytes()));
    }
}
