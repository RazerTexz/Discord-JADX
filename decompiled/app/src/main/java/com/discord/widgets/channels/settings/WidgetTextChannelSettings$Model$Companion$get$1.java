package com.discord.widgets.channels.settings;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.GuildFeature;
import com.discord.api.permission.Permission;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.channels.settings.WidgetTextChannelSettings;
import j0.k.b;
import j0.l.e.k;
import rx.Observable;
import rx.functions.Func3;

/* compiled from: WidgetTextChannelSettings.kt */
/* loaded from: classes2.dex */
public final class WidgetTextChannelSettings$Model$Companion$get$1<T, R> implements b<Channel, Observable<? extends WidgetTextChannelSettings.Model>> {
    public final /* synthetic */ long $channelId;

    /* compiled from: WidgetTextChannelSettings.kt */
    /* renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$Model$Companion$get$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, T3, R> implements Func3<Guild, MeUser, Long, WidgetTextChannelSettings.Model> {
        public final /* synthetic */ Channel $channel;

        public AnonymousClass1(Channel channel) {
            this.$channel = channel;
        }

        @Override // rx.functions.Func3
        public /* bridge */ /* synthetic */ WidgetTextChannelSettings.Model call(Guild guild, MeUser meUser, Long l) {
            return call2(guild, meUser, l);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetTextChannelSettings.Model call2(Guild guild, MeUser meUser, Long l) {
            Long publicUpdatesChannelId;
            Long rulesChannelId;
            if (guild == null) {
                return null;
            }
            boolean zCanAndIsElevated = PermissionUtils.canAndIsElevated(16L, l, meUser.getMfaEnabled(), guild.getMfaLevel());
            boolean zCanAndIsElevated2 = PermissionUtils.canAndIsElevated(Permission.MANAGE_ROLES, l, meUser.getMfaEnabled(), guild.getMfaLevel());
            boolean z2 = !this.$channel.getNsfw() || StoreStream.INSTANCE.getGuildsNsfw().isGuildNsfwGateAgreed(this.$channel.getGuildId());
            boolean zContains = guild.getFeatures().contains(GuildFeature.COMMUNITY);
            return new WidgetTextChannelSettings.Model(guild, this.$channel, zCanAndIsElevated, zCanAndIsElevated2, z2, zContains && (rulesChannelId = guild.getRulesChannelId()) != null && rulesChannelId.longValue() == WidgetTextChannelSettings$Model$Companion$get$1.this.$channelId, zContains && (publicUpdatesChannelId = guild.getPublicUpdatesChannelId()) != null && publicUpdatesChannelId.longValue() == WidgetTextChannelSettings$Model$Companion$get$1.this.$channelId, zContains);
        }
    }

    public WidgetTextChannelSettings$Model$Companion$get$1(long j) {
        this.$channelId = j;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetTextChannelSettings.Model> call(Channel channel) {
        return call2(channel);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetTextChannelSettings.Model> call2(Channel channel) {
        if (channel == null || ChannelUtils.H(channel)) {
            return new k(null);
        }
        StoreStream.Companion companion = StoreStream.INSTANCE;
        return Observable.i(companion.getGuilds().observeGuild(channel.getGuildId()), StoreUser.observeMe$default(companion.getUsers(), false, 1, null), companion.getPermissions().observePermissionsForChannel(this.$channelId), new AnonymousClass1(channel));
    }
}
