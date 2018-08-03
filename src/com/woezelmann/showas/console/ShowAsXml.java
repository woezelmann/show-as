package com.woezelmann.showas.console;

import com.intellij.lang.xml.XMLLanguage;
import com.woezelmann.showas.ShowAsFromConsole;
import com.woezelmann.showas.ShowAsFromDebugger;

/**
 * @author wozniak
 * @since 14.05.12
 */
public class ShowAsXml extends ShowAsFromConsole {

    public ShowAsXml() {
        super(XMLLanguage.INSTANCE);
    }
}
