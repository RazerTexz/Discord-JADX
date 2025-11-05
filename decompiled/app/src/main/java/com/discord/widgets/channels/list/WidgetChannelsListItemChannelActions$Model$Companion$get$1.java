package com.discord.widgets.channels.list;

import androidx.core.app.NotificationCompat;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreStream;
import com.discord.widgets.channels.list.WidgetChannelsListItemChannelActions;
import j0.k.b;
import j0.l.e.k;
import java.util.Map;
import rx.Observable;
import rx.functions.Func3;

/* compiled from: WidgetChannelsListItemChannelActions.kt */
/* loaded from: classes2.dex */
public final class WidgetChannelsListItemChannelActions$Model$Companion$get$1<T, R> implements b<Channel, Observable<? extends WidgetChannelsListItemChannelActions.Model>> {
    public final /* synthetic */ long $channelId;

    /* compiled from: WidgetChannelsListItemChannelActions.kt */
    /* renamed from: com.discord.widgets.channels.list.WidgetChannelsListItemChannelActions$Model$Companion$get$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, T3, R> implements Func3<Guild, Long, Map<Long, ? extends ModelNotificationSettings>, WidgetChannelsListItemChannelActions.Model> {
        public final /* synthetic */ Channel $channel;

        public AnonymousClass1(Channel channel) {
            this.$channel = channel;
        }

        @Override // rx.functions.Func3
        public /* bridge */ /* synthetic */ WidgetChannelsListItemChannelActions.Model call(Guild guild, Long l, Map<Long, ? extends ModelNotificationSettings> map) {
            return call2(guild, l, map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetChannelsListItemChannelActions.Model call2(Guild guild, Long l, Map<Long, ? extends ModelNotificationSettings> map) {
            ModelNotificationSettings.ChannelOverride channelOverride;
            ModelNotificationSettings modelNotificationSettings = (ModelNotificationSettings) a.c(this.$channel, map);
            return new WidgetChannelsListItemChannelActions.Model(this.$channel, guild, l, (modelNotificationSettings == null || (channelOverride = modelNotificationSettings.getChannelOverride(this.$channel.getId())) == null || !channelOverride.isMuted()) ? false : true);
        }
    }

    public WidgetChannelsListItemChannelActions$Model$Companion$get$1(long j) {
        this.$channelId = j;
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChannelsListItemChannelActions.Model> call2(Channel channel) {
        if (channel == null) {
            return new k(null);
        }
        StoreStream.Companion companion = StoreStream.INSTANCE;
        return Observable.i(companion.getGuilds().observeFromChannelId(this.$channelId), companion.getPermissions().observePermissionsForChannel(this.$channelId), companion.getUserGuildSettings().observeGuildSettings(), new AnonymousClass1(channel));
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChannelsListItemChannelActions.Model> call(Channel channel) {
        return call2(channel);
    }
}
