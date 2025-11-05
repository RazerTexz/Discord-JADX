package com.discord.widgets.channels.permissions;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsOverview;
import d0.z.d.m;
import j0.k.b;
import j0.l.e.k;
import java.util.Map;
import rx.Observable;
import rx.functions.Func4;

/* compiled from: WidgetChannelSettingsPermissionsOverview.kt */
/* loaded from: classes2.dex */
public final class WidgetChannelSettingsPermissionsOverview$Model$Companion$get$1<T, R> implements b<Channel, Observable<? extends WidgetChannelSettingsPermissionsOverview.Model>> {
    public final /* synthetic */ long $channelId;

    /* compiled from: WidgetChannelSettingsPermissionsOverview.kt */
    /* renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsOverview$Model$Companion$get$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, T3, T4, R> implements Func4<Guild, MeUser, Long, Map<Long, ? extends GuildRole>, WidgetChannelSettingsPermissionsOverview.Model> {
        public final /* synthetic */ Channel $channel;

        public AnonymousClass1(Channel channel) {
            this.$channel = channel;
        }

        @Override // rx.functions.Func4
        public /* bridge */ /* synthetic */ WidgetChannelSettingsPermissionsOverview.Model call(Guild guild, MeUser meUser, Long l, Map<Long, ? extends GuildRole> map) {
            return call2(guild, meUser, l, (Map<Long, GuildRole>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetChannelSettingsPermissionsOverview.Model call2(Guild guild, MeUser meUser, Long l, Map<Long, GuildRole> map) {
            if (!WidgetChannelSettingsPermissionsOverview.Model.INSTANCE.isValid(meUser, guild, this.$channel, l)) {
                return null;
            }
            m.checkNotNullExpressionValue(meUser, "meUser");
            m.checkNotNull(guild);
            Channel channel = this.$channel;
            m.checkNotNull(l);
            long jLongValue = l.longValue();
            m.checkNotNullExpressionValue(map, "roles");
            return new WidgetChannelSettingsPermissionsOverview.Model(meUser, guild, channel, jLongValue, map);
        }
    }

    public WidgetChannelSettingsPermissionsOverview$Model$Companion$get$1(long j) {
        this.$channelId = j;
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChannelSettingsPermissionsOverview.Model> call2(Channel channel) {
        if (channel == null) {
            return new k(null);
        }
        StoreStream.Companion companion = StoreStream.INSTANCE;
        return Observable.h(companion.getGuilds().observeGuild(channel.getGuildId()), StoreUser.observeMe$default(companion.getUsers(), false, 1, null), companion.getPermissions().observePermissionsForChannel(this.$channelId), companion.getGuilds().observeRoles(channel.getGuildId()), new AnonymousClass1(channel));
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChannelSettingsPermissionsOverview.Model> call(Channel channel) {
        return call2(channel);
    }
}
