package old;

import com.intellij.codeInsight.lookup.LookupManager;
import com.intellij.codeInsight.lookup.impl.LookupImpl;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.IdeActions;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.actionSystem.EditorActionHandler;
import com.intellij.openapi.editor.actionSystem.EditorActionManager;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

public class AddCaretBelowAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent anActionEvent) {
//        System.out.println("HEREHEREHERE2");
//
//        final Editor editor = anActionEvent.getRequiredData(CommonDataKeys.EDITOR);
//        EditorActionManager actionManager = EditorActionManager.getInstance();
//
////        EditorActionHandler addCaretActionHandler = actionManager.getActionHandler(IdeActions.ACTION_EDITOR_CLONE_CARET_BELOW);
////        addCaretActionHandler.execute(editor, editor.getCaretModel().getCurrentCaret(), anActionEvent.getDataContext());
//
//        EditorActionHandler addCaretActionHandler = actionManager.getActionHandler(IdeActions.ACTION_EDITOR_MOVE_CARET_UP);
////        addCaretActionHandler.
//        addCaretActionHandler.execute(editor, editor.getCaretModel().getCurrentCaret(), anActionEvent.getDataContext());

//        LookupImpl lookup = (LookupImpl) LookupManager.getActiveLookup(anActionEvent.);

    }

    @Override
    public void update(@NotNull final AnActionEvent anActionEvent) {
        System.out.println("HEREHEREHERE3");

        final Project project = anActionEvent.getData(CommonDataKeys.PROJECT);
        final Editor editor = anActionEvent.getData(CommonDataKeys.EDITOR);

        anActionEvent.getPresentation().setVisible(true);

//        anActionEvent.getPresentation().setVisible(
//            project != null
//            && editor != null
//            && editor.getCaretModel().getCaretCount() > 0
//        );
    }
}

