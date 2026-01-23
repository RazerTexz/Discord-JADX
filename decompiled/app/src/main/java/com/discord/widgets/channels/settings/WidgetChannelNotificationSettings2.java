package com.discord.widgets.channels.settings;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreStream;
import com.discord.widgets.channels.settings.WidgetChannelNotificationSettings;
import com.discord.widgets.forums.ForumUtils;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;

/* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetChannelNotificationSettings$Model$Companion$get$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetChannelNotificationSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelNotificationSettings2<T, R> implements Func1<Channel, Observable<? extends WidgetChannelNotificationSettings.Model>> {
    public static final WidgetChannelNotificationSettings2 INSTANCE = new WidgetChannelNotificationSettings2();

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChannelNotificationSettings.Model> call(Channel channel) {
        return call2(channel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChannelNotificationSettings.Model> call2(Channel channel) {
        if (channel == null) {
            return new ScalarSynchronousObservable(null);
        }
        StoreStream.Companion companion = StoreStream.INSTANCE;
        return Observable.m11071f(companion.getThreadsJoined().observeJoinedThread(channel.getId()), companion.getChannels().observeChannel(channel.getParentId()), companion.getGuilds().observeGuild(channel.getGuildId()), companion.getUserGuildSettings().observeGuildSettings(channel.getGuildId()), companion.getGuildProfiles().observeGuildProfile(channel.getGuildId()), ForumUtils.observeCanAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, channel.getGuildId(), null, null, 6, null), new WidgetChannelNotificationSettings3(channel));
    }
}
