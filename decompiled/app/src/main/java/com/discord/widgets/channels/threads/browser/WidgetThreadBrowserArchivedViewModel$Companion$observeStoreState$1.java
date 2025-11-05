package com.discord.widgets.channels.threads.browser;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.stores.ArchivedThreadsStore;
import kotlin.Pair;
import rx.functions.Func2;

/* compiled from: WidgetThreadBrowserArchivedViewModel.kt */
/* loaded from: classes2.dex */
public final class WidgetThreadBrowserArchivedViewModel$Companion$observeStoreState$1<T1, T2, R> implements Func2<ArchivedThreadsStore.ThreadListingState, Channel, Pair<? extends ArchivedThreadsStore.ThreadListingState, ? extends Channel>> {
    public static final WidgetThreadBrowserArchivedViewModel$Companion$observeStoreState$1 INSTANCE = new WidgetThreadBrowserArchivedViewModel$Companion$observeStoreState$1();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Pair<? extends ArchivedThreadsStore.ThreadListingState, ? extends Channel> call(ArchivedThreadsStore.ThreadListingState threadListingState, Channel channel) {
        return call2(threadListingState, channel);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Pair<ArchivedThreadsStore.ThreadListingState, Channel> call2(ArchivedThreadsStore.ThreadListingState threadListingState, Channel channel) {
        return new Pair<>(threadListingState, channel);
    }
}
