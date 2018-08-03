package com.woezelmann.showas;

import com.intellij.debugger.actions.ViewAsGroup;
import com.intellij.debugger.engine.JavaValue;
import com.intellij.lang.Language;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.sun.jdi.Value;
import com.sun.tools.jdi.StringReferenceImpl;

import java.util.List;

public class ShowAsFromDebugger extends ShowAs {

    public ShowAsFromDebugger(Language language) {
        super(language);
    }

    @Override
    public String fetchValue(AnActionEvent event) {
        final List<JavaValue> selectedValues = ViewAsGroup.getSelectedValues(event);
        if (selectedValues.size() == 0) return null;
        final Value value = selectedValues.get(0).getDescriptor().getValue();

        if (value instanceof com.sun.tools.jdi.StringReferenceImpl) {
            return ((StringReferenceImpl) value).value();
        }

        return null;
    }


}
