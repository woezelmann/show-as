package com.woezelmann.showas.console;

import com.intellij.sql.dialects.SqlLanguageDialect;
import com.woezelmann.showas.ShowAsFromConsole;
import com.woezelmann.showas.ShowAsFromDebugger;

public class ShowAsSql extends ShowAsFromConsole {


    public ShowAsSql() {
        super(SqlLanguageDialect.findLanguageByID("MySQL"));
    }
}
