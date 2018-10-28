package old;

import com.intellij.codeInsight.lookup.impl.LookupActionHandler;
import com.intellij.codeInsight.lookup.impl.LookupImpl;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.editor.Caret;
import com.intellij.openapi.editor.actionSystem.EditorActionHandler;
import org.jetbrains.annotations.Nullable;

public class NumberedAutocompleteLookupHandler extends LookupActionHandler {

    public NumberedAutocompleteLookupHandler(EditorActionHandler originalHandler) {
        super(originalHandler);
    }

    @Override
    protected void executeInLookup(LookupImpl lookup, DataContext context, @Nullable Caret caret) {
        System.out.println("In lookup handler");
    }
}
