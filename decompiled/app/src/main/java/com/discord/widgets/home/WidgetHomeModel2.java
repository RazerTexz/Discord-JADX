package com.discord.widgets.home;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreChannelsSelected;
import d0.Tuples;
import kotlin.Tuples2;
import rx.functions.Func2;

/* compiled from: WidgetHomeModel.kt */
/* renamed from: com.discord.widgets.home.WidgetHomeModel$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetHomeModel2<T1, T2, R> implements Func2<Long, StoreChannelsSelected.ResolvedSelectedChannel, Tuples2<? extends Long, ? extends StoreChannelsSelected.ResolvedSelectedChannel>> {
    public static final WidgetHomeModel2 INSTANCE = new WidgetHomeModel2();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Tuples2<? extends Long, ? extends StoreChannelsSelected.ResolvedSelectedChannel> call(Long l, StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
        return call2(l, resolvedSelectedChannel);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Tuples2<Long, StoreChannelsSelected.ResolvedSelectedChannel> call2(Long l, StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
        return Tuples.to(l, resolvedSelectedChannel);
    }
}
