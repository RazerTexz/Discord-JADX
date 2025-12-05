package com.discord.widgets.stage.model;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.role.GuildRole;
import com.discord.api.stageinstance.StageInstance;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.widgets.stage.model.StageCallModel;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;
import p658rx.functions.Func7;

/* compiled from: StageCallModel.kt */
/* renamed from: com.discord.widgets.stage.model.StageCallModel$Companion$observeStageCallModel$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StageCallModel4<T, R> implements Func1<Channel, Observable<? extends StageCallModel>> {
    public final /* synthetic */ long $channelId;

    /* compiled from: StageCallModel.kt */
    /* renamed from: com.discord.widgets.stage.model.StageCallModel$Companion$observeStageCallModel$1$1 */
    public static final class C100151<T1, T2, T3, T4, T5, T6, T7, R> implements Func7<Map<Long, ? extends StoreVoiceParticipants.VoiceUser>, Map<Long, ? extends GuildMember>, Map<Long, ? extends GuildRole>, Guild, Map<Long, ? extends Integer>, StageInstance, Boolean, StageCallModel> {
        public final /* synthetic */ Channel $channel;

        public C100151(Channel channel) {
            this.$channel = channel;
        }

        @Override // p658rx.functions.Func7
        public /* bridge */ /* synthetic */ StageCallModel call(Map<Long, ? extends StoreVoiceParticipants.VoiceUser> map, Map<Long, ? extends GuildMember> map2, Map<Long, ? extends GuildRole> map3, Guild guild, Map<Long, ? extends Integer> map4, StageInstance stageInstance, Boolean bool) {
            return call2((Map<Long, StoreVoiceParticipants.VoiceUser>) map, (Map<Long, GuildMember>) map2, (Map<Long, GuildRole>) map3, guild, (Map<Long, Integer>) map4, stageInstance, bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final StageCallModel call2(Map<Long, StoreVoiceParticipants.VoiceUser> map, Map<Long, GuildMember> map2, Map<Long, GuildRole> map3, Guild guild, Map<Long, Integer> map4, StageInstance stageInstance, Boolean bool) {
            StageCallModel.Companion companion = StageCallModel.INSTANCE;
            Channel channel = this.$channel;
            Intrinsics3.checkNotNullExpressionValue(map2, "guildMembers");
            Intrinsics3.checkNotNullExpressionValue(map3, "guildRoles");
            Intrinsics3.checkNotNullExpressionValue(map, "participants");
            Set<Long> setKeySet = map4.keySet();
            Intrinsics3.checkNotNullExpressionValue(bool, "isLurking");
            return StageCallModel.Companion.create$default(companion, channel, map2, map3, guild, map, setKeySet, stageInstance, bool.booleanValue(), null, 256, null);
        }
    }

    public StageCallModel4(long j) {
        this.$channelId = j;
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends StageCallModel> call(Channel channel) {
        return call2(channel);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends StageCallModel> call2(Channel channel) {
        if (channel == null) {
            return new ScalarSynchronousObservable(null);
        }
        if (!ChannelUtils.m7669D(channel)) {
            return new ScalarSynchronousObservable(null);
        }
        StoreStream.Companion companion = StoreStream.INSTANCE;
        return Observable.m11069e(ObservableExtensionsKt.leadingEdgeThrottle(companion.getVoiceParticipants().get(channel.getId()), 250L, TimeUnit.MILLISECONDS), companion.getGuilds().observeComputed(channel.getGuildId()), companion.getGuilds().observeRoles(channel.getGuildId()), companion.getGuilds().observeGuild(channel.getGuildId()), companion.getUserRelationships().observeForType(2), companion.getStageInstances().observeStageInstanceForChannel(this.$channelId), companion.getLurking().isLurkingObs(channel.getGuildId()), new C100151(channel));
    }
}
