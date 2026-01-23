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
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;
import p658rx.functions.Func3;

/* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$Model$Companion$get$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetTextChannelSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetTextChannelSettings2<T, R> implements Func1<Channel, Observable<? extends WidgetTextChannelSettings.Model>> {
    public final /* synthetic */ long $channelId;

    /* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$Model$Companion$get$1$1 */
    /* JADX INFO: compiled from: WidgetTextChannelSettings.kt */
    public static final class C75901<T1, T2, T3, R> implements Func3<Guild, MeUser, Long, WidgetTextChannelSettings.Model> {
        public final /* synthetic */ Channel $channel;

        public C75901(Channel channel) {
            this.$channel = channel;
        }

        @Override // p658rx.functions.Func3
        public /* bridge */ /* synthetic */ WidgetTextChannelSettings.Model call(Guild guild, MeUser meUser, Long l) {
            return call2(guild, meUser, l);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
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
            return new WidgetTextChannelSettings.Model(guild, this.$channel, zCanAndIsElevated, zCanAndIsElevated2, z2, zContains && (rulesChannelId = guild.getRulesChannelId()) != null && rulesChannelId.longValue() == WidgetTextChannelSettings2.this.$channelId, zContains && (publicUpdatesChannelId = guild.getPublicUpdatesChannelId()) != null && publicUpdatesChannelId.longValue() == WidgetTextChannelSettings2.this.$channelId, zContains);
        }
    }

    public WidgetTextChannelSettings2(long j) {
        this.$channelId = j;
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetTextChannelSettings.Model> call(Channel channel) {
        return call2(channel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetTextChannelSettings.Model> call2(Channel channel) {
        if (channel == null || ChannelUtils.m7673H(channel)) {
            return new ScalarSynchronousObservable(null);
        }
        StoreStream.Companion companion = StoreStream.INSTANCE;
        return Observable.m11075i(companion.getGuilds().observeGuild(channel.getGuildId()), StoreUser.observeMe$default(companion.getUsers(), false, 1, null), companion.getPermissions().observePermissionsForChannel(this.$channelId), new C75901(channel));
    }
}
