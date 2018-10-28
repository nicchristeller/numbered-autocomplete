import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.editor.actionSystem.EditorActionManager;
import com.intellij.openapi.editor.actionSystem.TypedAction;
import com.intellij.openapi.editor.actionSystem.TypedActionHandler;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.util.messages.MessageBus;
import com.intellij.util.messages.MessageBusConnection;

public class EditorIllustration extends AnAction {

    static {
        MessageBus messageBus = ApplicationManager.getApplication().getMessageBus();
        MessageBusConnection connection = messageBus.connect();
        connection.subscribe(ProjectManager.TOPIC, new MyProjectManagerListener());

        final EditorActionManager actionManager = EditorActionManager.getInstance();

        // register KeystrokeHandler
        final TypedAction typedActionService = actionManager.getTypedAction();
        TypedActionHandler originalHandler = typedActionService.getHandler();
        typedActionService.setupHandler(new KeystrokeHandler(originalHandler));


    }

    @Override
    public void actionPerformed(AnActionEvent e) {

    }
}
