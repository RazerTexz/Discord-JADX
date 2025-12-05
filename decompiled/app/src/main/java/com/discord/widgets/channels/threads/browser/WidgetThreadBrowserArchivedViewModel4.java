package com.discord.widgets.channels.threads.browser;

import androidx.core.app.NotificationCompat;
import com.discord.widgets.channels.threads.browser.WidgetThreadBrowserArchivedViewModel;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;
import p658rx.Observable;

/* compiled from: WidgetThreadBrowserArchivedViewModel.kt */
/* renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserArchivedViewModel$storeStateObservable$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetThreadBrowserArchivedViewModel4<T, R> implements Func1<WidgetThreadBrowserArchivedViewModel.ViewMode, Observable<? extends WidgetThreadBrowserArchivedViewModel.StoreState>> {
    public final /* synthetic */ WidgetThreadBrowserArchivedViewModel this$0;

    public WidgetThreadBrowserArchivedViewModel4(WidgetThreadBrowserArchivedViewModel widgetThreadBrowserArchivedViewModel) {
        this.this$0 = widgetThreadBrowserArchivedViewModel;
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetThreadBrowserArchivedViewModel.StoreState> call(WidgetThreadBrowserArchivedViewModel.ViewMode viewMode) {
        return call2(viewMode);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetThreadBrowserArchivedViewModel.StoreState> call2(WidgetThreadBrowserArchivedViewModel.ViewMode viewMode) {
        WidgetThreadBrowserArchivedViewModel.Companion companion = WidgetThreadBrowserArchivedViewModel.INSTANCE;
        Intrinsics3.checkNotNullExpressionValue(viewMode, "viewMode");
        return WidgetThreadBrowserArchivedViewModel.Companion.access$observeStoreState(companion, viewMode, WidgetThreadBrowserArchivedViewModel.access$getGuildId$p(this.this$0), WidgetThreadBrowserArchivedViewModel.access$getChannelId$p(this.this$0), WidgetThreadBrowserArchivedViewModel.access$getStoreGuilds$p(this.this$0), WidgetThreadBrowserArchivedViewModel.access$getStoreChannels$p(this.this$0), WidgetThreadBrowserArchivedViewModel.access$getStoreUser$p(this.this$0), WidgetThreadBrowserArchivedViewModel.access$getStoreArchivedThreads$p(this.this$0), WidgetThreadBrowserArchivedViewModel.access$getStorePermissions$p(this.this$0));
    }
}
