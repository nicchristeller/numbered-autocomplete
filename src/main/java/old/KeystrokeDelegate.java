package old;

import com.intellij.codeInsight.editorActions.TypedHandlerDelegate;
import com.intellij.codeInsight.lookup.LookupManager;
import com.intellij.codeInsight.lookup.impl.LookupImpl;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;

public class KeystrokeDelegate extends TypedHandlerDelegate {
    @NotNull
    @Override
    public Result beforeCharTyped(char charTyped, @NotNull Project project, @NotNull Editor editor, @NotNull PsiFile file, @NotNull FileType fileType) {
        System.out.println("char typed (delegate):");
        System.out.println(charTyped);
//        boolean eventConsumed = false;
//        LookupImpl lookup = (LookupImpl) LookupManager.getActiveLookup(editor);
//        System.out.println(lookup);

        return Result.STOP;

//        if (lookup != null) {
//            if (Character.isDigit(charTyped)) {
//                eventConsumed = true;
//                int number = Character.getNumericValue(charTyped);
//                lookup.setCurrentItem(lookup.getItems().get(number - 1));
//            }
//        }
//
//        return eventConsumed
//                ? Result.STOP
//                : Result.CONTINUE;
//        return super.beforeCharTyped(c, project, editor, file, fileType);
    }
}

