import com.intellij.codeInsight.completion.PresentationInvariant;
import com.intellij.codeInsight.editorActions.TypedHandler;
import com.intellij.codeInsight.lookup.AutoCompletionPolicy;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.codeInsight.lookup.LookupManager;
import com.intellij.codeInsight.lookup.impl.LookupImpl;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.actionSystem.TypedActionHandler;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.IconLoader;
import org.jetbrains.annotations.NotNull;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class KeystrokeHandler extends TypedHandler {
    public KeystrokeHandler(TypedActionHandler originalHandler) {
        super(originalHandler);
    }

    @Override
    public void execute(@NotNull Editor editor, char charTyped, @NotNull DataContext dataContext) {
        Project project = editor.getProject();

        Runnable runnable = () -> {
            LookupImpl lookup = (LookupImpl) LookupManager.getActiveLookup(editor);


            // build lookup
//            LookupManager lookupManager = LookupManager.getInstance(project);
//
//            LookupImpl defaultLookup = (LookupImpl) Objects.requireNonNull(lookupManager.getActiveLookup());
//            LookupElement[] numberedLookupElements = CustomLookupBuilder.addNumberedIconsToLookupElements(defaultLookup);
//
//            System.out.println("(keystroke) showing custom lookup with elements length: " + numberedLookupElements.length);
//            lookupManager.showLookup(defaultLookup.getEditor(), numberedLookupElements);
            // build lookup


            boolean lookupExistsAndNumberTyped = lookup != null && Character.isDigit(charTyped);
            if (lookupExistsAndNumberTyped) {

                int numberTyped = Character.getNumericValue(charTyped);
                List<LookupElement> lookupItems = lookup.getItems();

                if (numberTyped <= lookupItems.size() && numberTyped != 0) {
                    lookup.setCurrentItem(lookupItems.get(numberTyped - 1));
                }

            } else {
                if (myOriginalHandler != null) {
                    myOriginalHandler.execute(editor, charTyped, dataContext);
                }
            }
        };

        WriteCommandAction.runWriteCommandAction(project, runnable);
    }
}
