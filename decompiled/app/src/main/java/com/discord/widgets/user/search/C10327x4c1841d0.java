package com.discord.widgets.user.search;

import androidx.exifinterface.media.ExifInterface;
import com.discord.widgets.user.search.WidgetGlobalSearchGuildsModel;
import java.util.Comparator;
import p507d0.p582u.C12169a;

/* compiled from: Comparisons.kt */
/* renamed from: com.discord.widgets.user.search.WidgetGlobalSearchGuildsModel$Companion$create$$inlined$sortedByDescending$1 */
/* loaded from: classes.dex */
public final class C10327x4c1841d0<T> implements Comparator {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return C12169a.compareValues(Integer.valueOf(((WidgetGlobalSearchGuildsModel.Item) t2).getMentionCount()), Integer.valueOf(((WidgetGlobalSearchGuildsModel.Item) t).getMentionCount()));
    }
}
