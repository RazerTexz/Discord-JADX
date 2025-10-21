package com.discord.utilities.search;

import d0.g0.Strings4;
import d0.t.Sets5;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.Set;
import kotlin.text.Regex;

/* compiled from: SearchUtils.kt */
/* loaded from: classes2.dex */
public final class SearchUtils {
    public static final SearchUtils INSTANCE = new SearchUtils();

    private SearchUtils() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x004b, code lost:
    
        r1 = r1 + 1;
        r3 = r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean fuzzyMatch(String query, String target) {
        Intrinsics3.checkNotNullParameter(query, "query");
        Intrinsics3.checkNotNullParameter(target, "target");
        if (query.length() > target.length()) {
            return false;
        }
        if (query.length() == target.length()) {
            return Intrinsics3.areEqual(query, target);
        }
        int length = query.length();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            char cCharAt = query.charAt(i);
            while (i2 < target.length()) {
                int i3 = i2 + 1;
                char cCharAt2 = target.charAt(i2);
                if (cCharAt2 == cCharAt || (cCharAt == ' ' && cCharAt2 == '-')) {
                    break;
                }
                i2 = i3;
            }
            return false;
        }
        return true;
    }

    public final Set<String> getQueriesFromSearchText(String searchText) {
        Intrinsics3.checkNotNullParameter(searchText, "searchText");
        return searchText.length() == 0 ? Sets5.emptySet() : _Collections.toSet(Strings4.split$default((CharSequence) new Regex("(\\n|\\t|\\s)").replace(new Regex("([!.;,\\-—–?\"'])").replace(Strings4.trim(searchText).toString(), ""), " "), new char[]{' '}, false, 0, 6, (Object) null));
    }
}
