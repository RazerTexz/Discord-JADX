package com.discord.widgets.user.search;

import androidx.exifinterface.media.ExifInterface;
import java.util.Comparator;
import java.util.Map;
import p507d0.p582u.C12169a;

/* compiled from: Comparisons.kt */
/* renamed from: com.discord.widgets.user.search.WidgetGlobalSearchModel$Companion$getRecentChannelIds$$inlined$sortedBy$1 */
/* loaded from: classes.dex */
public final class C10338xcfd7ee1e<T> implements Comparator {
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return C12169a.compareValues((Long) ((Map.Entry) t).getValue(), (Long) ((Map.Entry) t2).getValue());
    }
}
