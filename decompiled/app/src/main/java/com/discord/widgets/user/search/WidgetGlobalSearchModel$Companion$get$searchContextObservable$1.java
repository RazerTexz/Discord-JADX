package com.discord.widgets.user.search;

import androidx.core.app.NotificationCompat;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.functions.Func2;

/* compiled from: WidgetGlobalSearchModel.kt */
/* loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$get$searchContextObservable$1<T1, T2, R> implements Func2<String, WidgetGlobalSearchModel.SearchContext, WidgetGlobalSearchModel.SearchContext> {
    public static final WidgetGlobalSearchModel$Companion$get$searchContextObservable$1 INSTANCE = new WidgetGlobalSearchModel$Companion$get$searchContextObservable$1();

    @Override // p658rx.functions.Func2
    public /* bridge */ /* synthetic */ WidgetGlobalSearchModel.SearchContext call(String str, WidgetGlobalSearchModel.SearchContext searchContext) {
        return call2(str, searchContext);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetGlobalSearchModel.SearchContext call2(String str, WidgetGlobalSearchModel.SearchContext searchContext) {
        Intrinsics3.checkNotNullExpressionValue(str, "filterStr");
        return WidgetGlobalSearchModel.SearchContext.copy$default(searchContext, str, null, 0L, 0L, 0L, null, null, 126, null);
    }
}
