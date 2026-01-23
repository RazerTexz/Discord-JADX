package com.discord.widgets.channels.list;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreStream;
import com.discord.widgets.channels.list.WidgetChannelsListItemChannelActions;
import java.util.Map;
import p007b.p100d.p104b.p105a.outline;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;
import p658rx.functions.Func3;

/* JADX INFO: compiled from: WidgetChannelsListItemChannelActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListItemChannelActions$Model$Companion$get$1<T, R> implements Func1<Channel, Observable<? extends WidgetChannelsListItemChannelActions.Model>> {
    public final /* synthetic */ long $channelId;

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsListItemChannelActions$Model$Companion$get$1$1 */
    /* JADX INFO: compiled from: WidgetChannelsListItemChannelActions.kt */
    public static final class C74511<T1, T2, T3, R> implements Func3<Guild, Long, Map<Long, ? extends ModelNotificationSettings>, WidgetChannelsListItemChannelActions.Model> {
        public final /* synthetic */ Channel $channel;

        public C74511(Channel channel) {
            this.$channel = channel;
        }

        @Override // p658rx.functions.Func3
        public /* bridge */ /* synthetic */ WidgetChannelsListItemChannelActions.Model call(Guild guild, Long l, Map<Long, ? extends ModelNotificationSettings> map) {
            return call2(guild, l, map);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetChannelsListItemChannelActions.Model call2(Guild guild, Long l, Map<Long, ? extends ModelNotificationSettings> map) {
            ModelNotificationSettings.ChannelOverride channelOverride;
            ModelNotificationSettings modelNotificationSettings = (ModelNotificationSettings) outline.m843c(this.$channel, map);
            return new WidgetChannelsListItemChannelActions.Model(this.$channel, guild, l, (modelNotificationSettings == null || (channelOverride = modelNotificationSettings.getChannelOverride(this.$channel.getId())) == null || !channelOverride.isMuted()) ? false : true);
        }
    }

    public WidgetChannelsListItemChannelActions$Model$Companion$get$1(long j) {
        this.$channelId = j;
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChannelsListItemChannelActions.Model> call2(Channel channel) {
        if (channel == null) {
            return new ScalarSynchronousObservable(null);
        }
        StoreStream.Companion companion = StoreStream.INSTANCE;
        return Observable.m11075i(companion.getGuilds().observeFromChannelId(this.$channelId), companion.getPermissions().observePermissionsForChannel(this.$channelId), companion.getUserGuildSettings().observeGuildSettings(), new C74511(channel));
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChannelsListItemChannelActions.Model> call(Channel channel) {
        return call2(channel);
    }
}
