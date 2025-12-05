package com.discord.widgets.channels.permissions;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsOverview;
import java.util.Map;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;
import p658rx.functions.Func4;

/* compiled from: WidgetChannelSettingsPermissionsOverview.kt */
/* renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsOverview$Model$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChannelSettingsPermissionsOverview2<T, R> implements Func1<Channel, Observable<? extends WidgetChannelSettingsPermissionsOverview.Model>> {
    public final /* synthetic */ long $channelId;

    /* compiled from: WidgetChannelSettingsPermissionsOverview.kt */
    /* renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsOverview$Model$Companion$get$1$1 */
    public static final class C75521<T1, T2, T3, T4, R> implements Func4<Guild, MeUser, Long, Map<Long, ? extends GuildRole>, WidgetChannelSettingsPermissionsOverview.Model> {
        public final /* synthetic */ Channel $channel;

        public C75521(Channel channel) {
            this.$channel = channel;
        }

        @Override // p658rx.functions.Func4
        public /* bridge */ /* synthetic */ WidgetChannelSettingsPermissionsOverview.Model call(Guild guild, MeUser meUser, Long l, Map<Long, ? extends GuildRole> map) {
            return call2(guild, meUser, l, (Map<Long, GuildRole>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetChannelSettingsPermissionsOverview.Model call2(Guild guild, MeUser meUser, Long l, Map<Long, GuildRole> map) {
            if (!WidgetChannelSettingsPermissionsOverview.Model.INSTANCE.isValid(meUser, guild, this.$channel, l)) {
                return null;
            }
            Intrinsics3.checkNotNullExpressionValue(meUser, "meUser");
            Intrinsics3.checkNotNull(guild);
            Channel channel = this.$channel;
            Intrinsics3.checkNotNull(l);
            long jLongValue = l.longValue();
            Intrinsics3.checkNotNullExpressionValue(map, "roles");
            return new WidgetChannelSettingsPermissionsOverview.Model(meUser, guild, channel, jLongValue, map);
        }
    }

    public WidgetChannelSettingsPermissionsOverview2(long j) {
        this.$channelId = j;
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChannelSettingsPermissionsOverview.Model> call2(Channel channel) {
        if (channel == null) {
            return new ScalarSynchronousObservable(null);
        }
        StoreStream.Companion companion = StoreStream.INSTANCE;
        return Observable.m11073h(companion.getGuilds().observeGuild(channel.getGuildId()), StoreUser.observeMe$default(companion.getUsers(), false, 1, null), companion.getPermissions().observePermissionsForChannel(this.$channelId), companion.getGuilds().observeRoles(channel.getGuildId()), new C75521(channel));
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChannelSettingsPermissionsOverview.Model> call(Channel channel) {
        return call2(channel);
    }
}
