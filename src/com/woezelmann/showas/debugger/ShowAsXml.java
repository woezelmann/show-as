package com.woezelmann.showas.debugger;

import com.intellij.lang.xml.XMLLanguage;
import com.woezelmann.showas.ShowAsFromDebugger;

/**
 * @author wozniak
 * @since 14.05.12
 */
public class ShowAsXml extends ShowAsFromDebugger {

    public ShowAsXml() {
        super(XMLLanguage.INSTANCE);
    }
}
