package com.discord.utilities.guildscheduledevent;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.permission.Permission;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventUrlUtils;
import com.discord.widgets.voice.model.CallModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AppToast;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.Maps6;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.Observable;

/* JADX INFO: compiled from: GuildScheduledEventUtilities.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventUtilities {
    public static final String ANALYTICS_SOURCE = "Guild Events";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String QUERY_PARAM_NAME = "event";

    /* JADX INFO: compiled from: GuildScheduledEventUtilities.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ boolean canCreateAnyEvent$default(Companion companion, long j, StoreChannels storeChannels, StorePermissions storePermissions, int i, Object obj) {
            if ((i & 2) != 0) {
                storeChannels = StoreStream.INSTANCE.getChannels();
            }
            if ((i & 4) != 0) {
                storePermissions = StoreStream.INSTANCE.getPermissions();
            }
            return companion.canCreateAnyEvent(j, storeChannels, storePermissions);
        }

        public static /* synthetic */ boolean canShareEvent$default(Companion companion, Long l, long j, StoreChannels storeChannels, StoreGuilds storeGuilds, StoreUser storeUser, StorePermissions storePermissions, int i, Object obj) {
            return companion.canShareEvent(l, j, (i & 4) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels, (i & 8) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 16) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser, (i & 32) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions);
        }

        public static /* synthetic */ boolean canStartEvent$default(Companion companion, long j, Long l, StoreChannels storeChannels, StorePermissions storePermissions, int i, Object obj) {
            if ((i & 4) != 0) {
                storeChannels = StoreStream.INSTANCE.getChannels();
            }
            StoreChannels storeChannels2 = storeChannels;
            if ((i & 8) != 0) {
                storePermissions = StoreStream.INSTANCE.getPermissions();
            }
            return companion.canStartEvent(j, l, storeChannels2, storePermissions);
        }

        private final List<Channel> getGuildScheduledEventCreatableChannelsForGuild(long guildId, StoreChannels channelsStore, StorePermissions permissionsStore) {
            Map<Long, Channel> channelsForGuild = channelsStore.getChannelsForGuild(guildId);
            Map<Long, Long> permissionsByChannel = permissionsStore.getPermissionsByChannel();
            Collection<Channel> collectionValues = channelsForGuild.values();
            ArrayList arrayList = new ArrayList();
            for (Object obj : collectionValues) {
                Channel channel = (Channel) obj;
                if (GuildScheduledEventUtilities.INSTANCE.canStartEventInChannel(channel, (Long) outline.m845d(channel, permissionsByChannel))) {
                    arrayList.add(obj);
                }
            }
            return arrayList;
        }

        public static /* synthetic */ List getGuildScheduledEventCreatableChannelsForGuild$default(Companion companion, long j, StoreChannels storeChannels, StorePermissions storePermissions, int i, Object obj) {
            if ((i & 2) != 0) {
                storeChannels = StoreStream.INSTANCE.getChannels();
            }
            if ((i & 4) != 0) {
                storePermissions = StoreStream.INSTANCE.getPermissions();
            }
            return companion.getGuildScheduledEventCreatableChannelsForGuild(j, storeChannels, storePermissions);
        }

        public static /* synthetic */ GuildScheduledEvent getGuildScheduledEventToEndForCall$default(Companion companion, CallModel callModel, Long l, StoreGuilds storeGuilds, int i, Object obj) {
            if ((i & 4) != 0) {
                storeGuilds = StoreStream.INSTANCE.getGuilds();
            }
            return companion.getGuildScheduledEventToEndForCall(callModel, l, storeGuilds);
        }

        public static /* synthetic */ Observable observeCanCreateAnyEvent$default(Companion companion, long j, ObservationDeck observationDeck, StoreChannels storeChannels, StorePermissions storePermissions, int i, Object obj) {
            if ((i & 2) != 0) {
                observationDeck = ObservationDeck4.get();
            }
            ObservationDeck observationDeck2 = observationDeck;
            if ((i & 4) != 0) {
                storeChannels = StoreStream.INSTANCE.getChannels();
            }
            StoreChannels storeChannels2 = storeChannels;
            if ((i & 8) != 0) {
                storePermissions = StoreStream.INSTANCE.getPermissions();
            }
            return companion.observeCanCreateAnyEvent(j, observationDeck2, storeChannels2, storePermissions);
        }

        public final boolean canCreateAnyEvent(long guildId, StoreChannels channelsStore, StorePermissions permissionsStore) {
            Intrinsics3.checkNotNullParameter(channelsStore, "channelsStore");
            Intrinsics3.checkNotNullParameter(permissionsStore, "permissionsStore");
            Long l = permissionsStore.getGuildPermissions().get(Long.valueOf(guildId));
            if (l == null) {
                return false;
            }
            if (PermissionUtils.can(Permission.MANAGE_EVENTS, Long.valueOf(l.longValue()))) {
                return true;
            }
            return !getGuildScheduledEventCreatableChannelsForGuild(guildId, channelsStore, permissionsStore).isEmpty();
        }

        public final boolean canCreateExternalEvent(Long guildPermissions) {
            return PermissionUtils.can(Permission.MANAGE_EVENTS, guildPermissions);
        }

        public final boolean canShareEvent(Long channelId, long guildId, StoreChannels channelsStore, StoreGuilds guildsStore, StoreUser usersStore, StorePermissions permissionsStore) {
            GuildMember member;
            Intrinsics3.checkNotNullParameter(channelsStore, "channelsStore");
            Intrinsics3.checkNotNullParameter(guildsStore, "guildsStore");
            Intrinsics3.checkNotNullParameter(usersStore, "usersStore");
            Intrinsics3.checkNotNullParameter(permissionsStore, "permissionsStore");
            if (channelId == null) {
                return PermissionUtils.can(1L, permissionsStore.getGuildPermissions().get(Long.valueOf(guildId)));
            }
            Channel channel = channelsStore.getChannel(channelId.longValue());
            if (channel == null || !PermissionUtils.can(1L, permissionsStore.getPermissionsByChannel().get(channelId))) {
                return false;
            }
            PermissionUtils permissionUtils = PermissionUtils.INSTANCE;
            Map<Long, GuildRole> mapEmptyMap = (Map) outline.m843c(channel, guildsStore.getRoles());
            if (mapEmptyMap == null) {
                mapEmptyMap = Maps6.emptyMap();
            }
            return (!permissionUtils.canEveryoneRole(Permission.VIEW_CHANNEL, channel, mapEmptyMap) || (member = guildsStore.getMember(channel.getGuildId(), usersStore.getMeSnapshot().getId())) == null || member.getPending()) ? false : true;
        }

        public final boolean canStartEvent(long guildId, Long channelId, StoreChannels channelsStore, StorePermissions permissionsStore) {
            Intrinsics3.checkNotNullParameter(channelsStore, "channelsStore");
            Intrinsics3.checkNotNullParameter(permissionsStore, "permissionsStore");
            if (channelId == null) {
                Long l = permissionsStore.getGuildPermissions().get(Long.valueOf(guildId));
                if (l != null) {
                    return PermissionUtils.can(Permission.MANAGE_EVENTS, Long.valueOf(l.longValue()));
                }
                return false;
            }
            Channel channel = channelsStore.getChannel(channelId.longValue());
            Long l2 = permissionsStore.getPermissionsByChannel().get(channelId);
            if (channel == null) {
                return false;
            }
            return canStartEventInChannel(channel, l2);
        }

        public final boolean canStartEventInChannel(Channel channel, Long channelPermissions) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            if (!PermissionUtils.can(8589935616L, channelPermissions)) {
                return false;
            }
            if (ChannelUtils.m7669D(channel)) {
                return PermissionUtils.can(Permission.START_STAGE_EVENT, channelPermissions);
            }
            if (ChannelUtils.m7675J(channel)) {
                return PermissionUtils.can(Permission.START_VOICE_EVENT, channelPermissions);
            }
            return false;
        }

        public final GuildScheduledEvent getGuildScheduledEventToEndForCall(CallModel callModel, Long myPermissions, StoreGuilds guildsStore) {
            GuildScheduledEvent liveEvent;
            Intrinsics3.checkNotNullParameter(callModel, "callModel");
            Intrinsics3.checkNotNullParameter(guildsStore, "guildsStore");
            Channel channel = callModel.getChannel();
            Guild guild = guildsStore.getGuild(channel.getGuildId());
            if (guild == null || (liveEvent = GuildScheduledEventUtilities5.getLiveEvent(callModel.getGuildScheduledEvents())) == null || !canStartEventInChannel(channel, myPermissions)) {
                return null;
            }
            Map map = (Map) outline.m847e(guild, guildsStore.getRoles());
            for (Map.Entry<Long, StoreVoiceParticipants.VoiceUser> entry : callModel.getParticipants().entrySet()) {
                long jLongValue = entry.getKey().longValue();
                if (!entry.getValue().isMe() && !canStartEventInChannel(channel, Long.valueOf(PermissionUtils.computeNonThreadPermissions(jLongValue, guild.getId(), guild.getOwnerId(), entry.getValue().getGuildMember(), map, channel.m7655v())))) {
                    return null;
                }
            }
            return liveEvent;
        }

        public final boolean isEventViewableByEveryone(Long channelId) {
            if (channelId == null) {
                return true;
            }
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Channel channel = companion.getChannels().getChannel(channelId.longValue());
            if (channel != null) {
                PermissionUtils permissionUtils = PermissionUtils.INSTANCE;
                Map<Long, GuildRole> mapEmptyMap = (Map) outline.m843c(channel, companion.getGuilds().getRoles());
                if (mapEmptyMap == null) {
                    mapEmptyMap = Maps6.emptyMap();
                }
                if (permissionUtils.canEveryoneRole(Permission.VIEW_CHANNEL, channel, mapEmptyMap)) {
                    return true;
                }
            }
            return false;
        }

        public final void launchInvite(boolean canShare, Fragment fragment, long guildId, Channel channel, long guildEventId) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            if (canShare) {
                Observable<Channel> observableM11119z = StoreStream.INSTANCE.getChannels().observeDefaultChannel(guildId).m11119z();
                Intrinsics3.checkNotNullExpressionValue(observableM11119z, "StoreStream.getChannels(…dId)\n            .first()");
                ObservableExtensionsKt.appSubscribe$default(observableM11119z, fragment.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new GuildScheduledEventUtilities3(fragment, channel, guildEventId), 62, (Object) null);
            } else {
                Context context = fragment.getContext();
                if (context != null) {
                    CharSequence eventDetailsUrl = GuildScheduledEventUrlUtils.INSTANCE.getEventDetailsUrl(guildId, guildEventId);
                    Intrinsics3.checkNotNullExpressionValue(context, "context");
                    AppToast.m165c(context, eventDetailsUrl, 0, 4);
                }
            }
        }

        public final Observable<Boolean> observeCanCreateAnyEvent(long guildId, ObservationDeck observationDeck, StoreChannels channelsStore, StorePermissions permissionsStore) {
            Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
            Intrinsics3.checkNotNullParameter(channelsStore, "channelsStore");
            Intrinsics3.checkNotNullParameter(permissionsStore, "permissionsStore");
            return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{channelsStore, permissionsStore}, false, null, null, new GuildScheduledEventUtilities4(guildId, channelsStore, permissionsStore), 14, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
