package com.discord.widgets.channels.threads.browser;

import androidx.core.app.NotificationCompat;
import com.discord.widgets.channels.threads.browser.WidgetThreadBrowserArchivedViewModel;
import d0.z.d.m;
import j0.k.b;
import rx.Observable;

/* compiled from: WidgetThreadBrowserArchivedViewModel.kt */
/* loaded from: classes2.dex */
public final class WidgetThreadBrowserArchivedViewModel$storeStateObservable$1<T, R> implements b<WidgetThreadBrowserArchivedViewModel.ViewMode, Observable<? extends WidgetThreadBrowserArchivedViewModel.StoreState>> {
    public final /* synthetic */ WidgetThreadBrowserArchivedViewModel this$0;

    public WidgetThreadBrowserArchivedViewModel$storeStateObservable$1(WidgetThreadBrowserArchivedViewModel widgetThreadBrowserArchivedViewModel) {
        this.this$0 = widgetThreadBrowserArchivedViewModel;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetThreadBrowserArchivedViewModel.StoreState> call(WidgetThreadBrowserArchivedViewModel.ViewMode viewMode) {
        return call2(viewMode);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetThreadBrowserArchivedViewModel.StoreState> call2(WidgetThreadBrowserArchivedViewModel.ViewMode viewMode) {
        WidgetThreadBrowserArchivedViewModel.Companion companion = WidgetThreadBrowserArchivedViewModel.INSTANCE;
        m.checkNotNullExpressionValue(viewMode, "viewMode");
        return WidgetThreadBrowserArchivedViewModel.Companion.access$observeStoreState(companion, viewMode, WidgetThreadBrowserArchivedViewModel.access$getGuildId$p(this.this$0), WidgetThreadBrowserArchivedViewModel.access$getChannelId$p(this.this$0), WidgetThreadBrowserArchivedViewModel.access$getStoreGuilds$p(this.this$0), WidgetThreadBrowserArchivedViewModel.access$getStoreChannels$p(this.this$0), WidgetThreadBrowserArchivedViewModel.access$getStoreUser$p(this.this$0), WidgetThreadBrowserArchivedViewModel.access$getStoreArchivedThreads$p(this.this$0), WidgetThreadBrowserArchivedViewModel.access$getStorePermissions$p(this.this$0));
    }
}
