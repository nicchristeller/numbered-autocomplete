import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementDecorator;
import org.jetbrains.annotations.NotNull;

public class MyLookupElement<T extends LookupElement> extends LookupElementDecorator {

    public MyLookupElement(LookupElement delegate) {
        super(delegate);
    }
}
