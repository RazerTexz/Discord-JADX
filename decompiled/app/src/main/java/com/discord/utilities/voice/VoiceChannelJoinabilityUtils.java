package com.discord.utilities.voice;

import androidx.core.app.NotificationCompat;
import b.c.a.a0.d;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.GuildMaxVideoChannelUsers;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.api.permission.Permission;
import com.discord.api.stageinstance.StageInstance;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStageInstances;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.stores.StoreVoiceStates;
import com.discord.utilities.guilds.GuildVerificationLevelUtils;
import com.discord.utilities.permissions.PermissionUtils;
import d0.t.h0;
import d0.z.d.m;
import j0.k.b;
import j0.l.e.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import rx.Observable;
import rx.functions.Func6;

/* compiled from: VoiceChannelJoinabilityUtils.kt */
/* loaded from: classes2.dex */
public final class VoiceChannelJoinabilityUtils {
    public static final VoiceChannelJoinabilityUtils INSTANCE = new VoiceChannelJoinabilityUtils();

    /* compiled from: VoiceChannelJoinabilityUtils.kt */
    /* renamed from: com.discord.utilities.voice.VoiceChannelJoinabilityUtils$observeJoinability$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<Channel, Observable<? extends VoiceChannelJoinability>> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ StoreGuilds $guildsStore;
        public final /* synthetic */ StorePermissions $permissionsStore;
        public final /* synthetic */ StoreStageInstances $stageInstancesStore;
        public final /* synthetic */ StoreVoiceChannelSelected $voiceChannelSelectedStore;
        public final /* synthetic */ StoreVoiceStates $voiceStatesStore;

        /* compiled from: VoiceChannelJoinabilityUtils.kt */
        /* renamed from: com.discord.utilities.voice.VoiceChannelJoinabilityUtils$observeJoinability$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C03471<T1, T2, T3, T4, T5, T6, R> implements Func6<Map<Long, ? extends VoiceState>, Long, Guild, GuildVerificationLevel, Long, StageInstance, VoiceChannelJoinability> {
            public final /* synthetic */ Channel $channel;

            public C03471(Channel channel) {
                this.$channel = channel;
            }

            @Override // rx.functions.Func6
            public /* bridge */ /* synthetic */ VoiceChannelJoinability call(Map<Long, ? extends VoiceState> map, Long l, Guild guild, GuildVerificationLevel guildVerificationLevel, Long l2, StageInstance stageInstance) {
                return call2((Map<Long, VoiceState>) map, l, guild, guildVerificationLevel, l2, stageInstance);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final VoiceChannelJoinability call2(Map<Long, VoiceState> map, Long l, Guild guild, GuildVerificationLevel guildVerificationLevel, Long l2, StageInstance stageInstance) {
                GuildMaxVideoChannelUsers maxVideoChannelUsers;
                VoiceChannelJoinabilityUtils voiceChannelJoinabilityUtils = VoiceChannelJoinabilityUtils.INSTANCE;
                Channel channel = this.$channel;
                Collection<VoiceState> collectionValues = map.values();
                if (guild == null || (maxVideoChannelUsers = guild.getMaxVideoChannelUsers()) == null) {
                    maxVideoChannelUsers = GuildMaxVideoChannelUsers.Unlimited.INSTANCE;
                }
                m.checkNotNullExpressionValue(guildVerificationLevel, "verificationLevelTriggered");
                return voiceChannelJoinabilityUtils.computeJoinability(channel, collectionValues, l, maxVideoChannelUsers, guildVerificationLevel, l2, stageInstance);
            }
        }

        public AnonymousClass1(StoreVoiceStates storeVoiceStates, long j, StorePermissions storePermissions, StoreGuilds storeGuilds, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreStageInstances storeStageInstances) {
            this.$voiceStatesStore = storeVoiceStates;
            this.$channelId = j;
            this.$permissionsStore = storePermissions;
            this.$guildsStore = storeGuilds;
            this.$voiceChannelSelectedStore = storeVoiceChannelSelected;
            this.$stageInstancesStore = storeStageInstances;
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Observable<? extends VoiceChannelJoinability> call(Channel channel) {
            return call2(channel);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends VoiceChannelJoinability> call2(Channel channel) {
            return channel == null ? new k(VoiceChannelJoinability.CHANNEL_DOES_NOT_EXIST) : Observable.f(this.$voiceStatesStore.observe(channel.getGuildId(), this.$channelId), this.$permissionsStore.observePermissionsForChannel(this.$channelId), this.$guildsStore.observeGuild(channel.getGuildId()), GuildVerificationLevelUtils.observeVerificationLevelTriggered$default(GuildVerificationLevelUtils.INSTANCE, channel.getGuildId(), null, null, null, 14, null), this.$voiceChannelSelectedStore.observeSelectedVoiceChannelId(), this.$stageInstancesStore.observeStageInstanceForChannel(this.$channelId), new C03471(channel));
        }
    }

    private VoiceChannelJoinabilityUtils() {
    }

    public static /* synthetic */ Observable observeJoinability$default(VoiceChannelJoinabilityUtils voiceChannelJoinabilityUtils, long j, StoreChannels storeChannels, StoreGuilds storeGuilds, StorePermissions storePermissions, StoreVoiceStates storeVoiceStates, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreStageInstances storeStageInstances, int i, Object obj) {
        return voiceChannelJoinabilityUtils.observeJoinability(j, (i & 2) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels, (i & 4) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 8) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions, (i & 16) != 0 ? StoreStream.INSTANCE.getVoiceStates() : storeVoiceStates, (i & 32) != 0 ? StoreStream.INSTANCE.getVoiceChannelSelected() : storeVoiceChannelSelected, (i & 64) != 0 ? StoreStream.INSTANCE.getStageInstances() : storeStageInstances);
    }

    public final VoiceChannelJoinability computeJoinability(Channel channel, Collection<VoiceState> channelVoiceStates, Long channelPermissions, GuildMaxVideoChannelUsers guildMaxVideoChannelUsers, GuildVerificationLevel verificationLevelTriggered, Long selectedVoiceChannelId, StageInstance stageInstance) {
        boolean z2;
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(channelVoiceStates, "channelVoiceStates");
        m.checkNotNullParameter(guildMaxVideoChannelUsers, "guildMaxVideoChannelUsers");
        m.checkNotNullParameter(verificationLevelTriggered, "verificationLevelTriggered");
        if (ChannelUtils.B(channel)) {
            return VoiceChannelJoinability.CAN_JOIN;
        }
        long id2 = channel.getId();
        if (selectedVoiceChannelId != null && id2 == selectedVoiceChannelId.longValue()) {
            return VoiceChannelJoinability.CAN_JOIN;
        }
        if (!PermissionUtils.can(Permission.CONNECT, channelPermissions)) {
            return VoiceChannelJoinability.PERMISSIONS_MISSING;
        }
        if ((verificationLevelTriggered != GuildVerificationLevel.NONE) && (stageInstance == null || !d.W0(stageInstance))) {
            return VoiceChannelJoinability.PERMISSIONS_MISSING;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : channelVoiceStates) {
            Long channelId = ((VoiceState) obj).getChannelId();
            if (channelId != null && channelId.longValue() == channel.getId()) {
                arrayList.add(obj);
            }
        }
        int size = arrayList.size();
        if (arrayList.isEmpty()) {
            z2 = false;
        } else {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (((VoiceState) it.next()).getSelfVideo()) {
                    z2 = true;
                    break;
                }
            }
            z2 = false;
        }
        boolean zCan = PermissionUtils.can(Permission.MOVE_MEMBERS, channelPermissions);
        if (size < (channel.getUserLimit() != 0 ? channel.getUserLimit() : Integer.MAX_VALUE) || zCan) {
            return (!(z2 && (guildMaxVideoChannelUsers instanceof GuildMaxVideoChannelUsers.Limited) && size >= ((GuildMaxVideoChannelUsers.Limited) guildMaxVideoChannelUsers).getLimit()) || PermissionUtils.can(8L, channelPermissions)) ? VoiceChannelJoinability.CAN_JOIN : (((GuildMaxVideoChannelUsers.Limited) guildMaxVideoChannelUsers).getLimit() == size && zCan) ? VoiceChannelJoinability.CAN_JOIN : VoiceChannelJoinability.GUILD_VIDEO_AT_CAPACITY;
        }
        return VoiceChannelJoinability.CHANNEL_FULL;
    }

    public final VoiceChannelJoinability getJoinability(long channelId) {
        GuildMaxVideoChannelUsers maxVideoChannelUsers;
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Channel channel = companion.getChannels().getChannel(channelId);
        if (channel == null) {
            return VoiceChannelJoinability.CHANNEL_DOES_NOT_EXIST;
        }
        Map mapEmptyMap = (Map) a.c(channel, companion.getVoiceStates().get());
        if (mapEmptyMap == null) {
            mapEmptyMap = h0.emptyMap();
        }
        Collection collectionValues = mapEmptyMap.values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            Long channelId2 = ((VoiceState) obj).getChannelId();
            if (channelId2 != null && channelId2.longValue() == channelId) {
                arrayList.add(obj);
            }
        }
        StoreStream.Companion companion2 = StoreStream.INSTANCE;
        Long l = companion2.getPermissions().getPermissionsByChannel().get(Long.valueOf(channelId));
        Guild guild = companion2.getGuilds().getGuild(channel.getGuildId());
        GuildVerificationLevel verificationLevelTriggered$default = GuildVerificationLevelUtils.getVerificationLevelTriggered$default(GuildVerificationLevelUtils.INSTANCE, channel.getGuildId(), null, null, null, 14, null);
        long selectedVoiceChannelId = companion2.getVoiceChannelSelected().getSelectedVoiceChannelId();
        StageInstance stageInstanceForChannel = companion2.getStageInstances().getStageInstanceForChannel(channelId);
        if (guild == null || (maxVideoChannelUsers = guild.getMaxVideoChannelUsers()) == null) {
            maxVideoChannelUsers = GuildMaxVideoChannelUsers.Unlimited.INSTANCE;
        }
        return computeJoinability(channel, arrayList, l, maxVideoChannelUsers, verificationLevelTriggered$default, Long.valueOf(selectedVoiceChannelId), stageInstanceForChannel);
    }

    public final Observable<VoiceChannelJoinability> observeJoinability(long channelId, StoreChannels channelsStore, StoreGuilds guildsStore, StorePermissions permissionsStore, StoreVoiceStates voiceStatesStore, StoreVoiceChannelSelected voiceChannelSelectedStore, StoreStageInstances stageInstancesStore) {
        m.checkNotNullParameter(channelsStore, "channelsStore");
        m.checkNotNullParameter(guildsStore, "guildsStore");
        m.checkNotNullParameter(permissionsStore, "permissionsStore");
        m.checkNotNullParameter(voiceStatesStore, "voiceStatesStore");
        m.checkNotNullParameter(voiceChannelSelectedStore, "voiceChannelSelectedStore");
        m.checkNotNullParameter(stageInstancesStore, "stageInstancesStore");
        Observable observableY = channelsStore.observeChannel(channelId).Y(new AnonymousClass1(voiceStatesStore, channelId, permissionsStore, guildsStore, voiceChannelSelectedStore, stageInstancesStore));
        m.checkNotNullExpressionValue(observableY, "channelsStore\n        .o…  }\n          }\n        }");
        return observableY;
    }
}
