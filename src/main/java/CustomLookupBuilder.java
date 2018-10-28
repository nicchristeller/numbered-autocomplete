import com.intellij.codeInsight.completion.PresentationInvariant;
import com.intellij.codeInsight.lookup.AutoCompletionPolicy;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.codeInsight.lookup.impl.LookupImpl;
import com.intellij.openapi.util.IconLoader;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("KotlinInternalInJava")
public class CustomLookupBuilder {

    public static LookupElement[] addNumberedIconsToLookupElements(@NotNull LookupImpl lookup) {
        List<LookupElement> items = new ArrayList<>();

        List<LookupElement> existingElements = lookup.getItems();
        for (int i = 0; i < existingElements.size(); i++) {
            LookupElement existingElement = existingElements.get(i);
            MyUserDataRetriever dataRetriever = new MyUserDataRetriever(existingElement);
            PresentationInvariant presentationInfo = dataRetriever.getFirstUserDataItem();

            LookupElementBuilder builder = LookupElementBuilder
                    .create("my" + presentationInfo.getItemText())
                    .withTypeText(presentationInfo.getType())
                    .withTailText(presentationInfo.getTail());

            if ((i + 1) < 10) {
                builder = builder.withIcon(IconLoader.getIcon("icons/" + (i + 1) + ".png"));
            }

            items.add(builder.withAutoCompletionPolicy(AutoCompletionPolicy.SETTINGS_DEPENDENT));
        }

        LookupElement[] itemsArray = new LookupElement[items.size()];
        for (int i = 0; i < items.size(); i++) {
            itemsArray[i] = new MyLookupElement<>(items.get(i));
        }

        return itemsArray;

    }
}
