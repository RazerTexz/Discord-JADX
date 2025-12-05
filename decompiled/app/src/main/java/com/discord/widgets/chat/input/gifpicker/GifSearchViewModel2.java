package com.discord.widgets.chat.input.gifpicker;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreAnalytics;
import com.discord.utilities.analytics.SearchType;
import p658rx.functions.Action1;

/* compiled from: GifSearchViewModel.kt */
/* renamed from: com.discord.widgets.chat.input.gifpicker.GifSearchViewModel$Companion$observeQueryState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class GifSearchViewModel2<T> implements Action1<String> {
    public final /* synthetic */ StoreAnalytics $storeAnalytics;

    public GifSearchViewModel2(StoreAnalytics storeAnalytics) {
        this.$storeAnalytics = storeAnalytics;
    }

    @Override // p658rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(String str) {
        call2(str);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(String str) {
        StoreAnalytics.trackSearchStarted$default(this.$storeAnalytics, SearchType.GIF, null, false, 6, null);
    }
}
