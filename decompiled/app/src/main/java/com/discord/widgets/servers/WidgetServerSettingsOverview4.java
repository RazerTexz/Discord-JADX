package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuildProfiles;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.widgets.servers.WidgetServerSettingsOverview;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;
import p658rx.functions.Func5;

/* compiled from: WidgetServerSettingsOverview.kt */
/* renamed from: com.discord.widgets.servers.WidgetServerSettingsOverview$Model$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsOverview4<T, R> implements Func1<Guild, Observable<? extends WidgetServerSettingsOverview.Model>> {
    public final /* synthetic */ long $guildId;

    /* compiled from: WidgetServerSettingsOverview.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsOverview$Model$Companion$get$1$1 */
    public static final class C92741<T1, T2, T3, T4, T5, R> implements Func5<MeUser, Channel, Channel, Long, StoreGuildProfiles.GuildProfileData, WidgetServerSettingsOverview.Model> {
        public final /* synthetic */ Guild $guild;

        public C92741(Guild guild) {
            this.$guild = guild;
        }

        @Override // p658rx.functions.Func5
        public /* bridge */ /* synthetic */ WidgetServerSettingsOverview.Model call(MeUser meUser, Channel channel, Channel channel2, Long l, StoreGuildProfiles.GuildProfileData guildProfileData) {
            return call2(meUser, channel, channel2, l, guildProfileData);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetServerSettingsOverview.Model call2(MeUser meUser, Channel channel, Channel channel2, Long l, StoreGuildProfiles.GuildProfileData guildProfileData) {
            Guild guild = this.$guild;
            Intrinsics3.checkNotNullExpressionValue(meUser, "me");
            return new WidgetServerSettingsOverview.Model(guild, meUser, channel, channel2, l, guildProfileData);
        }
    }

    public WidgetServerSettingsOverview4(long j) {
        this.$guildId = j;
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetServerSettingsOverview.Model> call2(Guild guild) {
        if (guild == null) {
            return new ScalarSynchronousObservable(null);
        }
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable observableObserveMe$default = StoreUser.observeMe$default(companion.getUsers(), false, 1, null);
        StoreChannels channels = companion.getChannels();
        Long afkChannelId = guild.getAfkChannelId();
        Observable<Channel> observableObserveChannel = channels.observeChannel(afkChannelId != null ? afkChannelId.longValue() : 0L);
        StoreChannels channels2 = companion.getChannels();
        Long systemChannelId = guild.getSystemChannelId();
        return Observable.m11072g(observableObserveMe$default, observableObserveChannel, channels2.observeChannel(systemChannelId != null ? systemChannelId.longValue() : 0L), companion.getPermissions().observePermissionsForGuild(this.$guildId), companion.getGuildProfiles().observeGuildProfile(this.$guildId), new C92741(guild));
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetServerSettingsOverview.Model> call(Guild guild) {
        return call2(guild);
    }
}
