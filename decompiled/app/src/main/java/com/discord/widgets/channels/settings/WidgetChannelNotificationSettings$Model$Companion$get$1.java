package com.discord.widgets.channels.settings;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreStream;
import com.discord.widgets.channels.settings.WidgetChannelNotificationSettings;
import com.discord.widgets.forums.ForumUtils;
import j0.k.b;
import j0.l.e.k;
import rx.Observable;

/* compiled from: WidgetChannelNotificationSettings.kt */
/* loaded from: classes2.dex */
public final class WidgetChannelNotificationSettings$Model$Companion$get$1<T, R> implements b<Channel, Observable<? extends WidgetChannelNotificationSettings.Model>> {
    public static final WidgetChannelNotificationSettings$Model$Companion$get$1 INSTANCE = new WidgetChannelNotificationSettings$Model$Companion$get$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChannelNotificationSettings.Model> call(Channel channel) {
        return call2(channel);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChannelNotificationSettings.Model> call2(Channel channel) {
        if (channel == null) {
            return new k(null);
        }
        StoreStream.Companion companion = StoreStream.INSTANCE;
        return Observable.f(companion.getThreadsJoined().observeJoinedThread(channel.getId()), companion.getChannels().observeChannel(channel.getParentId()), companion.getGuilds().observeGuild(channel.getGuildId()), companion.getUserGuildSettings().observeGuildSettings(channel.getGuildId()), companion.getGuildProfiles().observeGuildProfile(channel.getGuildId()), ForumUtils.observeCanAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, channel.getGuildId(), null, null, 6, null), new WidgetChannelNotificationSettings$Model$Companion$get$1$$special$$inlined$let$lambda$1(channel));
    }
}
