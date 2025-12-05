package com.discord.widgets.chat.input.autocomplete;

import com.discord.app.AppLog;
import com.discord.utilities.logging.Logger;
import java.util.Map;
import kotlin.ranges.Ranges2;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p579g0.Strings4;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: AutocompleteExtensions.kt */
/* renamed from: com.discord.widgets.chat.input.autocomplete.AutocompleteExtensionsKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class AutocompleteExtensions {
    public static final String replaceAutocompleteDataWithServerValues(String str, Map<Ranges2, ? extends Autocompletable> map) {
        Intrinsics3.checkNotNullParameter(str, "$this$replaceAutocompleteDataWithServerValues");
        Intrinsics3.checkNotNullParameter(map, "inputMentionsMap");
        String string = str;
        for (Ranges2 ranges2 : _Collections.sortedWith(map.keySet(), new C7762xcb37dea4())) {
            Autocompletable autocompletable = map.get(ranges2);
            if (autocompletable != null) {
                if (ranges2.getFirst() > string.length() || ranges2.getLast() > string.length()) {
                    AppLog appLog = AppLog.f14950g;
                    StringBuilder sbM833U = outline.m833U("Invalid mention position to insert ");
                    sbM833U.append(autocompletable.getInputReplacement());
                    sbM833U.append(' ');
                    sbM833U.append("into ");
                    sbM833U.append(string);
                    sbM833U.append(" at [");
                    sbM833U.append(ranges2.getFirst());
                    sbM833U.append(" - ");
                    sbM833U.append(ranges2.getLast());
                    sbM833U.append("]. Original input: ");
                    sbM833U.append(str);
                    String string2 = sbM833U.toString();
                    StringBuilder sbM833U2 = outline.m833U("first ");
                    sbM833U2.append(ranges2.getFirst());
                    sbM833U2.append(", last ");
                    sbM833U2.append(ranges2.getLast());
                    sbM833U2.append(", s.length() ");
                    sbM833U2.append(string.length());
                    Logger.e$default(appLog, string2, new IndexOutOfBoundsException(sbM833U2.toString()), null, 4, null);
                } else {
                    string = Strings4.replaceRange(string, ranges2.getFirst(), ranges2.getLast(), autocompletable.getInputReplacement()).toString();
                }
            }
        }
        return string;
    }
}
