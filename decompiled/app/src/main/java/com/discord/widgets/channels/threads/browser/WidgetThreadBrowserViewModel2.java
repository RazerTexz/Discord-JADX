package com.discord.widgets.channels.threads.browser;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.widgets.channels.threads.browser.WidgetThreadBrowserViewModel;
import p658rx.functions.Func3;

/* compiled from: WidgetThreadBrowserViewModel.kt */
/* renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetThreadBrowserViewModel2<T1, T2, T3, R> implements Func3<Channel, Guild, Long, WidgetThreadBrowserViewModel.StoreState> {
    public static final WidgetThreadBrowserViewModel2 INSTANCE = new WidgetThreadBrowserViewModel2();

    @Override // p658rx.functions.Func3
    public /* bridge */ /* synthetic */ WidgetThreadBrowserViewModel.StoreState call(Channel channel, Guild guild, Long l) {
        return call2(channel, guild, l);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetThreadBrowserViewModel.StoreState call2(Channel channel, Guild guild, Long l) {
        return new WidgetThreadBrowserViewModel.StoreState(channel, guild, l);
    }
}
