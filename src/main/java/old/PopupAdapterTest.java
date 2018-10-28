package old;

import com.intellij.openapi.ui.popup.JBPopupAdapter;
import com.intellij.openapi.ui.popup.LightweightWindowEvent;

public class PopupAdapterTest extends JBPopupAdapter {
    @Override
    public void beforeShown(LightweightWindowEvent event) {
        System.out.println("In popup adapter");
        System.out.println(event.asPopup());
        super.beforeShown(event);
    }
}
