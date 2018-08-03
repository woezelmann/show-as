package com.woezelmann.showas.debugger;

import com.intellij.sql.dialects.SqlLanguageDialect;
import com.woezelmann.showas.ShowAsFromDebugger;

public class ShowAsSql extends ShowAsFromDebugger {


    public ShowAsSql() {
        super(SqlLanguageDialect.findLanguageByID("MySQL"));
    }
}
