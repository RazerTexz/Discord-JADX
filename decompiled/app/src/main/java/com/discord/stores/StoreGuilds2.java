package com.discord.stores;

import androidx.core.app.NotificationCompat;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;

/* compiled from: StoreGuilds.kt */
/* renamed from: com.discord.stores.StoreGuilds$Actions$requestMembers$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreGuilds2<T, R> implements Func1<String, String> {
    public final /* synthetic */ boolean $autocomplete;

    public StoreGuilds2(boolean z2) {
        this.$autocomplete = z2;
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ String call(String str) {
        return call2(str);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final String call2(String str) {
        if (this.$autocomplete) {
            if (!(str == null || str.length() == 0) && str.charAt(0) == '@') {
                String strSubstring = str.substring(1);
                Intrinsics3.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
                return strSubstring;
            }
        }
        if (!this.$autocomplete) {
            if (!(str == null || str.length() == 0)) {
                return str;
            }
        }
        return null;
    }
}
