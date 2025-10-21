package com.discord.widgets.channels.threads.browser;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.stores.ArchivedThreadsStore;
import kotlin.Tuples2;
import rx.functions.Func2;

/* compiled from: WidgetThreadBrowserArchivedViewModel.kt */
/* renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserArchivedViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetThreadBrowserArchivedViewModel2<T1, T2, R> implements Func2<ArchivedThreadsStore.ThreadListingState, Channel, Tuples2<? extends ArchivedThreadsStore.ThreadListingState, ? extends Channel>> {
    public static final WidgetThreadBrowserArchivedViewModel2 INSTANCE = new WidgetThreadBrowserArchivedViewModel2();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Tuples2<? extends ArchivedThreadsStore.ThreadListingState, ? extends Channel> call(ArchivedThreadsStore.ThreadListingState threadListingState, Channel channel) {
        return call2(threadListingState, channel);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Tuples2<ArchivedThreadsStore.ThreadListingState, Channel> call2(ArchivedThreadsStore.ThreadListingState threadListingState, Channel channel) {
        return new Tuples2<>(threadListingState, channel);
    }
}
