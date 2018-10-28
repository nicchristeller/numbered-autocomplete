import com.intellij.codeInsight.completion.PresentationInvariant;
import com.intellij.openapi.util.UserDataHolderBase;
import com.intellij.util.keyFMap.KeyFMap;

public class MyUserDataRetriever extends UserDataHolderBase {

    public MyUserDataRetriever(UserDataHolderBase target) {
        target.copyUserDataTo(this);
    }

    public KeyFMap getAllUserData() {
        return super.getUserMap();
    }

    @SuppressWarnings("KotlinInternalInJava")
    public PresentationInvariant getFirstUserDataItem() {
        KeyFMap userData = this.getAllUserData();
        Object firstDataElement = userData.get(userData.getKeys()[0]);

        return ((PresentationInvariant) firstDataElement);
    }
}
