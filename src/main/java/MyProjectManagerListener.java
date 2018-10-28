import com.intellij.codeInsight.lookup.*;
import com.intellij.codeInsight.lookup.impl.LookupImpl;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManagerListener;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MyProjectManagerListener implements ProjectManagerListener {

    private Map<Project, PropertyChangeListener> listeners = new HashMap<>();
    private static LookupEx lookupEx = null;
    private static int count = 0;

    private void onProjectManagerPropertyChange(Project project, PropertyChangeEvent evt) {
        //java.beans.PropertyChangeEvent[propertyName=activeLookup; oldValue=null; newValue=javax.swing.JPanel[,0,0,0x0,invalid,layout=java.awt.BorderLayout,alignmentX=0.0,alignmentY=0.0,border=,flags=9,maximumSize=,minimumSize=,preferredSize=]; propagationId=null; source=com.intellij.codeInsight.lookup.impl.LookupManagerImpl@6ac6507a]
        System.out.println(evt);

        if (evt.getPropertyName().equals("activeLookup")) {
            onActiveLookupChange(project, evt);
        }
    }

    private void onActiveLookupChange(Project project, PropertyChangeEvent evt) {
        boolean isShowingLookup = evt.getNewValue() != null;

        if (isShowingLookup) {

            LookupManager lookupManager = LookupManager.getInstance(project);
            LookupImpl lookup = (LookupImpl) Objects.requireNonNull(lookupManager.getActiveLookup());


            lookup.addLookupListener(new LookupListener() {
                @Override
                public void itemSelected(LookupEvent event) {
                }

                @Override
                public void lookupCanceled(LookupEvent event) {
                }

                @Override
                public void currentItemChanged(LookupEvent event) {
                    System.out.println("current item changed in lookup");

                    if (lookup.getItems().get(0) instanceof MyLookupElement) {
                        // lookup has already been replaced
                        return;
                    }

                    LookupElement[] numberedLookupElements = CustomLookupBuilder.addNumberedIconsToLookupElements(lookup);

                    System.out.println("showing custom lookup with elements length: " + numberedLookupElements.length);
                    new java.util.Timer().schedule(
                            new java.util.TimerTask() {
                                @Override
                                public void run() {
                                    lookupEx = lookupManager.showLookup(lookup.getEditor(), numberedLookupElements);
                                }
                            },
                            3000
                    );

                    lookup.removeLookupListener(this);
                }
            });
        }
        System.out.println("");
    }

    @Override
    public void projectOpened(Project project) {
        System.out.println("project opened");
        PropertyChangeListener changeListener = evt -> onProjectManagerPropertyChange(project, evt);
        listeners.put(project, changeListener);
        LookupManager.getInstance(project).addPropertyChangeListener(changeListener);
    }

    @Override
    public void projectClosed(Project project) {
        System.out.println("project closed");
        LookupManager.getInstance(project).removePropertyChangeListener(listeners.get(project));
        listeners.remove(project);
    }
}
