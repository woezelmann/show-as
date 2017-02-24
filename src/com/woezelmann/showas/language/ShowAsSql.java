package com.woezelmann.showas.language;

import com.intellij.sql.dialects.SqlLanguageDialect;
import com.woezelmann.showas.ShowAs;

public class ShowAsSql extends ShowAs {


    public ShowAsSql() {
        super(SqlLanguageDialect.findLanguageByID("MySQL"));
    }
}
