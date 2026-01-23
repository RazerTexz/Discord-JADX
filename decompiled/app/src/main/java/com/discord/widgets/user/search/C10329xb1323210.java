package com.discord.widgets.user.search;

import androidx.exifinterface.media.ExifInterface;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import java.util.Comparator;
import p507d0.p582u.C12169a;

/* JADX INFO: renamed from: com.discord.widgets.user.search.WidgetGlobalSearchModel$Companion$create$$inlined$sortedByDescending$1 */
/* JADX INFO: compiled from: Comparisons.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C10329xb1323210<T> implements Comparator {
    public final /* synthetic */ WidgetGlobalSearchModel.SearchContext $searchContext$inlined;

    public C10329xb1323210(WidgetGlobalSearchModel.SearchContext searchContext) {
        this.$searchContext$inlined = searchContext;
    }

    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        WidgetGlobalSearchScoreStrategy widgetGlobalSearchScoreStrategy = WidgetGlobalSearchScoreStrategy.INSTANCE;
        return C12169a.compareValues(Integer.valueOf(widgetGlobalSearchScoreStrategy.score((WidgetGlobalSearchModel.ItemDataPayload) t2, this.$searchContext$inlined.getSearchType(), this.$searchContext$inlined.getFrecencyChannels())), Integer.valueOf(widgetGlobalSearchScoreStrategy.score((WidgetGlobalSearchModel.ItemDataPayload) t, this.$searchContext$inlined.getSearchType(), this.$searchContext$inlined.getFrecencyChannels())));
    }
}
