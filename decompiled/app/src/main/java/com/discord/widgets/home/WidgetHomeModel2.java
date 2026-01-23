package com.discord.widgets.home;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreChannelsSelected;
import kotlin.Tuples2;
import p507d0.Tuples;
import p658rx.functions.Func2;

/* JADX INFO: renamed from: com.discord.widgets.home.WidgetHomeModel$Companion$get$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetHomeModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHomeModel2<T1, T2, R> implements Func2<Long, StoreChannelsSelected.ResolvedSelectedChannel, Tuples2<? extends Long, ? extends StoreChannelsSelected.ResolvedSelectedChannel>> {
    public static final WidgetHomeModel2 INSTANCE = new WidgetHomeModel2();

    @Override // p658rx.functions.Func2
    public /* bridge */ /* synthetic */ Tuples2<? extends Long, ? extends StoreChannelsSelected.ResolvedSelectedChannel> call(Long l, StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
        return call2(l, resolvedSelectedChannel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Tuples2<Long, StoreChannelsSelected.ResolvedSelectedChannel> call2(Long l, StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
        return Tuples.m10073to(l, resolvedSelectedChannel);
    }
}
