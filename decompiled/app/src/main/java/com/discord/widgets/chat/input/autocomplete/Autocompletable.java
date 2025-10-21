package com.discord.widgets.chat.input.autocomplete;

import androidx.core.app.NotificationCompat;
import com.discord.utilities.collections.MultiListIterator;
import d0.z.d.Intrinsics3;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Autocompletable.kt */
/* loaded from: classes2.dex */
public abstract class Autocompletable {
    private Autocompletable() {
    }

    public List<String> getAutocompleteTextMatchers() {
        return null;
    }

    public List<String> getHiddenInputTextMatchers() {
        return null;
    }

    public abstract String getInputReplacement();

    public abstract List<String> getInputTextMatchers();

    public final Iterator<String> iterateAutocompleteMatchers() {
        List<String> autocompleteTextMatchers = getAutocompleteTextMatchers();
        if (autocompleteTextMatchers == null || autocompleteTextMatchers.isEmpty()) {
            return getInputTextMatchers().iterator();
        }
        List<String> autocompleteTextMatchers2 = getAutocompleteTextMatchers();
        Intrinsics3.checkNotNull(autocompleteTextMatchers2);
        return new MultiListIterator(getInputTextMatchers(), autocompleteTextMatchers2);
    }

    public final Iterator<String> iterateTextMatchers() {
        List<String> hiddenInputTextMatchers = getHiddenInputTextMatchers();
        if (hiddenInputTextMatchers == null || hiddenInputTextMatchers.isEmpty()) {
            return getInputTextMatchers().iterator();
        }
        List<String> hiddenInputTextMatchers2 = getHiddenInputTextMatchers();
        Intrinsics3.checkNotNull(hiddenInputTextMatchers2);
        return new MultiListIterator(getInputTextMatchers(), hiddenInputTextMatchers2);
    }

    public LeadingIdentifier leadingIdentifier() {
        return LeadingIdentifier.NONE;
    }

    public final boolean matchesText(String text) {
        Intrinsics3.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        if (getInputTextMatchers().contains(text)) {
            return true;
        }
        List<String> hiddenInputTextMatchers = getHiddenInputTextMatchers();
        return hiddenInputTextMatchers != null && hiddenInputTextMatchers.contains(text);
    }

    public /* synthetic */ Autocompletable(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
