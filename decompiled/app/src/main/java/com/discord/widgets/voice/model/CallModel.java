package com.discord.widgets.voice.model;

import co.discord.media_engine.DeviceDescription4;
import com.discord.api.application.Application;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.GuildMaxVideoChannelUsers;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.permission.Permission;
import com.discord.api.stageinstance.StageInstance;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.embeddedactivities.EmbeddedActivity;
import com.discord.models.guild.Guild;
import com.discord.rtcconnection.RtcConnection;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.stores.StoreApplicationStreaming;
import com.discord.stores.StoreAudioManagerV2;
import com.discord.stores.StoreMediaSettings;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.time.Clock;
import com.discord.utilities.voice.VoiceChannelJoinabilityUtils2;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0002b;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.Observable;

/* compiled from: CallModel.kt */
/* loaded from: classes.dex */
public final /* data */ class CallModel {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final StoreApplicationStreaming.ActiveApplicationStream activeStream;
    private final Map<Long, Application> applications;
    private final StoreAudioManagerV2.State audioManagerState;
    private final int callFeedbackTriggerRateDenominator;
    private final CameraState cameraState;
    private final Channel channel;
    private final Long channelPermissions;
    private final Map<Long, EmbeddedActivity> embeddedActivitiesForChannel;
    private final Guild guild;
    private final GuildMaxVideoChannelUsers guildMaxVideoChannelMembers;
    private final List<GuildScheduledEvent> guildScheduledEvents;
    private final boolean isChannelSelected;
    private final boolean isMyHandRaised;
    private final boolean isVideoCall;
    private final long myId;
    private final int numUsersConnected;
    private final Map<Long, StoreVoiceParticipants.VoiceUser> participants;
    private final RtcConnection.Metadata rtcConnectionMetadata;
    private final DeviceDescription4 selectedVideoDevice;
    private final int streamFeedbackTriggerRateDenominator;
    private final long timeConnectedMs;
    private final List<DeviceDescription4> videoDevices;
    private final VoiceChannelJoinabilityUtils2 voiceChannelJoinability;
    private final StoreMediaSettings.VoiceConfiguration voiceSettings;

    /* compiled from: CallModel.kt */
    public static final class Companion {

        /* compiled from: CallModel.kt */
        public static final /* data */ class Chunk {
            private final StoreAudioManagerV2.State audioManagerState;
            private final Channel channel;
            private final Long channelPermissions;
            private final long myUserId;
            private final DeviceDescription4 selectedVideoDevice;
            private final long timeConnectedMs;
            private final List<DeviceDescription4> videoDevices;
            private final StoreMediaSettings.VoiceConfiguration voiceConfig;
            private final Map<Long, StoreVoiceParticipants.VoiceUser> voiceParticipants;

            public Chunk(Channel channel, long j, long j2, StoreMediaSettings.VoiceConfiguration voiceConfiguration, Map<Long, StoreVoiceParticipants.VoiceUser> map, Long l, List<DeviceDescription4> list, DeviceDescription4 deviceDescription4, StoreAudioManagerV2.State state) {
                Intrinsics3.checkNotNullParameter(channel, "channel");
                Intrinsics3.checkNotNullParameter(voiceConfiguration, "voiceConfig");
                Intrinsics3.checkNotNullParameter(map, "voiceParticipants");
                Intrinsics3.checkNotNullParameter(list, "videoDevices");
                Intrinsics3.checkNotNullParameter(state, "audioManagerState");
                this.channel = channel;
                this.myUserId = j;
                this.timeConnectedMs = j2;
                this.voiceConfig = voiceConfiguration;
                this.voiceParticipants = map;
                this.channelPermissions = l;
                this.videoDevices = list;
                this.selectedVideoDevice = deviceDescription4;
                this.audioManagerState = state;
            }

            public static /* synthetic */ Chunk copy$default(Chunk chunk, Channel channel, long j, long j2, StoreMediaSettings.VoiceConfiguration voiceConfiguration, Map map, Long l, List list, DeviceDescription4 deviceDescription4, StoreAudioManagerV2.State state, int i, Object obj) {
                return chunk.copy((i & 1) != 0 ? chunk.channel : channel, (i & 2) != 0 ? chunk.myUserId : j, (i & 4) != 0 ? chunk.timeConnectedMs : j2, (i & 8) != 0 ? chunk.voiceConfig : voiceConfiguration, (i & 16) != 0 ? chunk.voiceParticipants : map, (i & 32) != 0 ? chunk.channelPermissions : l, (i & 64) != 0 ? chunk.videoDevices : list, (i & 128) != 0 ? chunk.selectedVideoDevice : deviceDescription4, (i & 256) != 0 ? chunk.audioManagerState : state);
            }

            /* renamed from: component1, reason: from getter */
            public final Channel getChannel() {
                return this.channel;
            }

            /* renamed from: component2, reason: from getter */
            public final long getMyUserId() {
                return this.myUserId;
            }

            /* renamed from: component3, reason: from getter */
            public final long getTimeConnectedMs() {
                return this.timeConnectedMs;
            }

            /* renamed from: component4, reason: from getter */
            public final StoreMediaSettings.VoiceConfiguration getVoiceConfig() {
                return this.voiceConfig;
            }

            public final Map<Long, StoreVoiceParticipants.VoiceUser> component5() {
                return this.voiceParticipants;
            }

            /* renamed from: component6, reason: from getter */
            public final Long getChannelPermissions() {
                return this.channelPermissions;
            }

            public final List<DeviceDescription4> component7() {
                return this.videoDevices;
            }

            /* renamed from: component8, reason: from getter */
            public final DeviceDescription4 getSelectedVideoDevice() {
                return this.selectedVideoDevice;
            }

            /* renamed from: component9, reason: from getter */
            public final StoreAudioManagerV2.State getAudioManagerState() {
                return this.audioManagerState;
            }

            public final Chunk copy(Channel channel, long myUserId, long timeConnectedMs, StoreMediaSettings.VoiceConfiguration voiceConfig, Map<Long, StoreVoiceParticipants.VoiceUser> voiceParticipants, Long channelPermissions, List<DeviceDescription4> videoDevices, DeviceDescription4 selectedVideoDevice, StoreAudioManagerV2.State audioManagerState) {
                Intrinsics3.checkNotNullParameter(channel, "channel");
                Intrinsics3.checkNotNullParameter(voiceConfig, "voiceConfig");
                Intrinsics3.checkNotNullParameter(voiceParticipants, "voiceParticipants");
                Intrinsics3.checkNotNullParameter(videoDevices, "videoDevices");
                Intrinsics3.checkNotNullParameter(audioManagerState, "audioManagerState");
                return new Chunk(channel, myUserId, timeConnectedMs, voiceConfig, voiceParticipants, channelPermissions, videoDevices, selectedVideoDevice, audioManagerState);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Chunk)) {
                    return false;
                }
                Chunk chunk = (Chunk) other;
                return Intrinsics3.areEqual(this.channel, chunk.channel) && this.myUserId == chunk.myUserId && this.timeConnectedMs == chunk.timeConnectedMs && Intrinsics3.areEqual(this.voiceConfig, chunk.voiceConfig) && Intrinsics3.areEqual(this.voiceParticipants, chunk.voiceParticipants) && Intrinsics3.areEqual(this.channelPermissions, chunk.channelPermissions) && Intrinsics3.areEqual(this.videoDevices, chunk.videoDevices) && Intrinsics3.areEqual(this.selectedVideoDevice, chunk.selectedVideoDevice) && Intrinsics3.areEqual(this.audioManagerState, chunk.audioManagerState);
            }

            public final StoreAudioManagerV2.State getAudioManagerState() {
                return this.audioManagerState;
            }

            public final Channel getChannel() {
                return this.channel;
            }

            public final Long getChannelPermissions() {
                return this.channelPermissions;
            }

            public final long getMyUserId() {
                return this.myUserId;
            }

            public final DeviceDescription4 getSelectedVideoDevice() {
                return this.selectedVideoDevice;
            }

            public final long getTimeConnectedMs() {
                return this.timeConnectedMs;
            }

            public final List<DeviceDescription4> getVideoDevices() {
                return this.videoDevices;
            }

            public final StoreMediaSettings.VoiceConfiguration getVoiceConfig() {
                return this.voiceConfig;
            }

            public final Map<Long, StoreVoiceParticipants.VoiceUser> getVoiceParticipants() {
                return this.voiceParticipants;
            }

            public int hashCode() {
                Channel channel = this.channel;
                int iM3a = (C0002b.m3a(this.timeConnectedMs) + ((C0002b.m3a(this.myUserId) + ((channel != null ? channel.hashCode() : 0) * 31)) * 31)) * 31;
                StoreMediaSettings.VoiceConfiguration voiceConfiguration = this.voiceConfig;
                int iHashCode = (iM3a + (voiceConfiguration != null ? voiceConfiguration.hashCode() : 0)) * 31;
                Map<Long, StoreVoiceParticipants.VoiceUser> map = this.voiceParticipants;
                int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
                Long l = this.channelPermissions;
                int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
                List<DeviceDescription4> list = this.videoDevices;
                int iHashCode4 = (iHashCode3 + (list != null ? list.hashCode() : 0)) * 31;
                DeviceDescription4 deviceDescription4 = this.selectedVideoDevice;
                int iHashCode5 = (iHashCode4 + (deviceDescription4 != null ? deviceDescription4.hashCode() : 0)) * 31;
                StoreAudioManagerV2.State state = this.audioManagerState;
                return iHashCode5 + (state != null ? state.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("Chunk(channel=");
                sbM833U.append(this.channel);
                sbM833U.append(", myUserId=");
                sbM833U.append(this.myUserId);
                sbM833U.append(", timeConnectedMs=");
                sbM833U.append(this.timeConnectedMs);
                sbM833U.append(", voiceConfig=");
                sbM833U.append(this.voiceConfig);
                sbM833U.append(", voiceParticipants=");
                sbM833U.append(this.voiceParticipants);
                sbM833U.append(", channelPermissions=");
                sbM833U.append(this.channelPermissions);
                sbM833U.append(", videoDevices=");
                sbM833U.append(this.videoDevices);
                sbM833U.append(", selectedVideoDevice=");
                sbM833U.append(this.selectedVideoDevice);
                sbM833U.append(", audioManagerState=");
                sbM833U.append(this.audioManagerState);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        private Companion() {
        }

        public static final /* synthetic */ CallModel access$create(Companion companion, Channel channel, Guild guild, long j, long j2, StoreMediaSettings.VoiceConfiguration voiceConfiguration, Map map, Long l, List list, boolean z2, DeviceDescription4 deviceDescription4, StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream, RtcConnection.Metadata metadata, int i, int i2, StoreAudioManagerV2.State state, VoiceChannelJoinabilityUtils2 voiceChannelJoinabilityUtils2, List list2, Map map2, Map map3) {
            return companion.create(channel, guild, j, j2, voiceConfiguration, map, l, list, z2, deviceDescription4, activeApplicationStream, metadata, i, i2, state, voiceChannelJoinabilityUtils2, list2, map2, map3);
        }

        public static final /* synthetic */ Observable access$observeChunk(Companion companion, Channel channel) {
            return companion.observeChunk(channel);
        }

        private final CallModel create(Channel channel, Guild guild, long myUserId, long timeConnectedMs, StoreMediaSettings.VoiceConfiguration voiceConfig, Map<Long, StoreVoiceParticipants.VoiceUser> voiceParticipants, Long channelPermissions, List<DeviceDescription4> videoDevices, boolean isChannelSelected, DeviceDescription4 selectedVideoDevice, StoreApplicationStreaming.ActiveApplicationStream activeStream, RtcConnection.Metadata rtcConnectionMetadata, int callFeedbackTriggerRateDenominator, int streamFeedbackTriggerRateDenominator, StoreAudioManagerV2.State audioManagerState, VoiceChannelJoinabilityUtils2 voiceChannelJoinability, List<GuildScheduledEvent> guildScheduledEvents, Map<Long, EmbeddedActivity> embeddedActivitiesForChannel, Map<Long, Application> applications) {
            int i;
            GuildMaxVideoChannelUsers maxVideoChannelUsers;
            if (voiceParticipants.isEmpty()) {
                i = 0;
            } else {
                Iterator<Map.Entry<Long, StoreVoiceParticipants.VoiceUser>> it = voiceParticipants.entrySet().iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    if (it.next().getValue().isConnected()) {
                        i2++;
                    }
                }
                i = i2;
            }
            StoreVoiceParticipants.VoiceUser voiceUser = voiceParticipants.get(Long.valueOf(myUserId));
            boolean z2 = voiceUser != null && voiceUser.getIsRequestingToSpeak();
            if (guild == null || (maxVideoChannelUsers = guild.getMaxVideoChannelUsers()) == null) {
                maxVideoChannelUsers = GuildMaxVideoChannelUsers.Unlimited.INSTANCE;
            }
            return new CallModel(voiceParticipants, myUserId, timeConnectedMs, videoDevices, selectedVideoDevice, voiceConfig, rtcConnectionMetadata, callFeedbackTriggerRateDenominator, streamFeedbackTriggerRateDenominator, activeStream, voiceChannelJoinability, maxVideoChannelUsers, guild, isChannelSelected, z2, guildScheduledEvents, embeddedActivitiesForChannel, applications, channel, i, channelPermissions, audioManagerState);
        }

        private final Observable<Chunk> observeChunk(Channel channel) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<Chunk> observableM11067d = Observable.m11067d(companion.getUsers().observeMeId(), companion.getVoiceChannelSelected().observeTimeSelectedMs(), companion.getMediaSettings().getVoiceConfiguration(), ObservableExtensionsKt.leadingEdgeThrottle(companion.getVoiceParticipants().get(channel.getId()), 250L, TimeUnit.MILLISECONDS), companion.getPermissions().observePermissionsForChannel(channel.getId()), companion.getMediaEngine().getVideoInputDevices(), companion.getMediaEngine().getSelectedVideoInputDevice(), companion.getAudioManagerV2().observeAudioManagerState(), new CallModel3(channel));
            Intrinsics3.checkNotNullExpressionValue(observableM11067d, "Observable\n          .co…            )\n          }");
            return observableM11067d;
        }

        public final Observable<CallModel> get(long channelId) {
            Observable observableM11099Y = StoreStream.INSTANCE.getChannels().observeChannel(channelId).m11099Y(new CallModel2(channelId));
            Intrinsics3.checkNotNullExpressionValue(observableM11099Y, "StoreStream\n          .g…            }\n          }");
            return observableM11099Y;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00d6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CallModel(Map<Long, StoreVoiceParticipants.VoiceUser> map, long j, long j2, List<DeviceDescription4> list, DeviceDescription4 deviceDescription4, StoreMediaSettings.VoiceConfiguration voiceConfiguration, RtcConnection.Metadata metadata, int i, int i2, StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream, VoiceChannelJoinabilityUtils2 voiceChannelJoinabilityUtils2, GuildMaxVideoChannelUsers guildMaxVideoChannelUsers, Guild guild, boolean z2, boolean z3, List<GuildScheduledEvent> list2, Map<Long, EmbeddedActivity> map2, Map<Long, Application> map3, Channel channel, int i3, Long l, StoreAudioManagerV2.State state) {
        boolean z4;
        Intrinsics3.checkNotNullParameter(map, "participants");
        Intrinsics3.checkNotNullParameter(list, "videoDevices");
        Intrinsics3.checkNotNullParameter(voiceConfiguration, "voiceSettings");
        Intrinsics3.checkNotNullParameter(voiceChannelJoinabilityUtils2, "voiceChannelJoinability");
        Intrinsics3.checkNotNullParameter(guildMaxVideoChannelUsers, "guildMaxVideoChannelMembers");
        Intrinsics3.checkNotNullParameter(list2, "guildScheduledEvents");
        Intrinsics3.checkNotNullParameter(map2, "embeddedActivitiesForChannel");
        Intrinsics3.checkNotNullParameter(map3, "applications");
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Intrinsics3.checkNotNullParameter(state, "audioManagerState");
        this.participants = map;
        this.myId = j;
        this.timeConnectedMs = j2;
        this.videoDevices = list;
        this.selectedVideoDevice = deviceDescription4;
        this.voiceSettings = voiceConfiguration;
        this.rtcConnectionMetadata = metadata;
        this.callFeedbackTriggerRateDenominator = i;
        this.streamFeedbackTriggerRateDenominator = i2;
        this.activeStream = activeApplicationStream;
        this.voiceChannelJoinability = voiceChannelJoinabilityUtils2;
        this.guildMaxVideoChannelMembers = guildMaxVideoChannelUsers;
        this.guild = guild;
        this.isChannelSelected = z2;
        this.isMyHandRaised = z3;
        this.guildScheduledEvents = list2;
        this.embeddedActivitiesForChannel = map2;
        this.applications = map3;
        this.channel = channel;
        this.numUsersConnected = i3;
        this.channelPermissions = l;
        this.audioManagerState = state;
        this.cameraState = deviceDescription4 != null ? CameraState.CAMERA_ON : CameraState.CAMERA_OFF;
        boolean z5 = true;
        if (!isStreaming()) {
            if (map.isEmpty()) {
                z4 = false;
                if (!z4) {
                    z5 = false;
                }
            } else {
                Iterator<Map.Entry<Long, StoreVoiceParticipants.VoiceUser>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    VoiceState voiceState = it.next().getValue().getVoiceState();
                    if (voiceState != null ? voiceState.getSelfVideo() : false) {
                        z4 = true;
                        break;
                    }
                }
                z4 = false;
                if (!z4) {
                }
            }
        }
        this.isVideoCall = z5;
    }

    /* renamed from: component19, reason: from getter */
    private final Channel getChannel() {
        return this.channel;
    }

    /* renamed from: component20, reason: from getter */
    private final int getNumUsersConnected() {
        return this.numUsersConnected;
    }

    /* renamed from: component21, reason: from getter */
    private final Long getChannelPermissions() {
        return this.channelPermissions;
    }

    /* renamed from: component22, reason: from getter */
    private final StoreAudioManagerV2.State getAudioManagerState() {
        return this.audioManagerState;
    }

    public static /* synthetic */ CallModel copy$default(CallModel callModel, Map map, long j, long j2, List list, DeviceDescription4 deviceDescription4, StoreMediaSettings.VoiceConfiguration voiceConfiguration, RtcConnection.Metadata metadata, int i, int i2, StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream, VoiceChannelJoinabilityUtils2 voiceChannelJoinabilityUtils2, GuildMaxVideoChannelUsers guildMaxVideoChannelUsers, Guild guild, boolean z2, boolean z3, List list2, Map map2, Map map3, Channel channel, int i3, Long l, StoreAudioManagerV2.State state, int i4, Object obj) {
        return callModel.copy((i4 & 1) != 0 ? callModel.participants : map, (i4 & 2) != 0 ? callModel.myId : j, (i4 & 4) != 0 ? callModel.timeConnectedMs : j2, (i4 & 8) != 0 ? callModel.videoDevices : list, (i4 & 16) != 0 ? callModel.selectedVideoDevice : deviceDescription4, (i4 & 32) != 0 ? callModel.voiceSettings : voiceConfiguration, (i4 & 64) != 0 ? callModel.rtcConnectionMetadata : metadata, (i4 & 128) != 0 ? callModel.callFeedbackTriggerRateDenominator : i, (i4 & 256) != 0 ? callModel.streamFeedbackTriggerRateDenominator : i2, (i4 & 512) != 0 ? callModel.activeStream : activeApplicationStream, (i4 & 1024) != 0 ? callModel.voiceChannelJoinability : voiceChannelJoinabilityUtils2, (i4 & 2048) != 0 ? callModel.guildMaxVideoChannelMembers : guildMaxVideoChannelUsers, (i4 & 4096) != 0 ? callModel.guild : guild, (i4 & 8192) != 0 ? callModel.isChannelSelected : z2, (i4 & 16384) != 0 ? callModel.isMyHandRaised : z3, (i4 & 32768) != 0 ? callModel.guildScheduledEvents : list2, (i4 & 65536) != 0 ? callModel.embeddedActivitiesForChannel : map2, (i4 & 131072) != 0 ? callModel.applications : map3, (i4 & 262144) != 0 ? callModel.channel : channel, (i4 & 524288) != 0 ? callModel.numUsersConnected : i3, (i4 & 1048576) != 0 ? callModel.channelPermissions : l, (i4 & 2097152) != 0 ? callModel.audioManagerState : state);
    }

    public final boolean canInvite() {
        boolean zM7667B = ChannelUtils.m7667B(this.channel);
        boolean z2 = ChannelUtils.m7699w(this.channel) && PermissionUtils.can(1L, this.channelPermissions);
        StageInstance stageInstanceForChannel = StoreStream.INSTANCE.getStageInstances().getStageInstanceForChannel(this.channel.getId());
        return zM7667B || z2 || ((stageInstanceForChannel != null ? stageInstanceForChannel.getInviteCode() : null) != null);
    }

    public final boolean canManageEvent() {
        return GuildScheduledEventUtilities.INSTANCE.canStartEventInChannel(this.channel, this.channelPermissions);
    }

    public final boolean canRequestToSpeak() {
        return ChannelUtils.m7669D(this.channel) && PermissionUtils.can(Permission.REQUEST_TO_SPEAK, this.channelPermissions);
    }

    public final Map<Long, StoreVoiceParticipants.VoiceUser> component1() {
        return this.participants;
    }

    /* renamed from: component10, reason: from getter */
    public final StoreApplicationStreaming.ActiveApplicationStream getActiveStream() {
        return this.activeStream;
    }

    /* renamed from: component11, reason: from getter */
    public final VoiceChannelJoinabilityUtils2 getVoiceChannelJoinability() {
        return this.voiceChannelJoinability;
    }

    /* renamed from: component12, reason: from getter */
    public final GuildMaxVideoChannelUsers getGuildMaxVideoChannelMembers() {
        return this.guildMaxVideoChannelMembers;
    }

    /* renamed from: component13, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* renamed from: component14, reason: from getter */
    public final boolean getIsChannelSelected() {
        return this.isChannelSelected;
    }

    /* renamed from: component15, reason: from getter */
    public final boolean getIsMyHandRaised() {
        return this.isMyHandRaised;
    }

    public final List<GuildScheduledEvent> component16() {
        return this.guildScheduledEvents;
    }

    public final Map<Long, EmbeddedActivity> component17() {
        return this.embeddedActivitiesForChannel;
    }

    public final Map<Long, Application> component18() {
        return this.applications;
    }

    /* renamed from: component2, reason: from getter */
    public final long getMyId() {
        return this.myId;
    }

    /* renamed from: component3, reason: from getter */
    public final long getTimeConnectedMs() {
        return this.timeConnectedMs;
    }

    public final List<DeviceDescription4> component4() {
        return this.videoDevices;
    }

    /* renamed from: component5, reason: from getter */
    public final DeviceDescription4 getSelectedVideoDevice() {
        return this.selectedVideoDevice;
    }

    /* renamed from: component6, reason: from getter */
    public final StoreMediaSettings.VoiceConfiguration getVoiceSettings() {
        return this.voiceSettings;
    }

    /* renamed from: component7, reason: from getter */
    public final RtcConnection.Metadata getRtcConnectionMetadata() {
        return this.rtcConnectionMetadata;
    }

    /* renamed from: component8, reason: from getter */
    public final int getCallFeedbackTriggerRateDenominator() {
        return this.callFeedbackTriggerRateDenominator;
    }

    /* renamed from: component9, reason: from getter */
    public final int getStreamFeedbackTriggerRateDenominator() {
        return this.streamFeedbackTriggerRateDenominator;
    }

    public final CallModel copy(Map<Long, StoreVoiceParticipants.VoiceUser> participants, long myId, long timeConnectedMs, List<DeviceDescription4> videoDevices, DeviceDescription4 selectedVideoDevice, StoreMediaSettings.VoiceConfiguration voiceSettings, RtcConnection.Metadata rtcConnectionMetadata, int callFeedbackTriggerRateDenominator, int streamFeedbackTriggerRateDenominator, StoreApplicationStreaming.ActiveApplicationStream activeStream, VoiceChannelJoinabilityUtils2 voiceChannelJoinability, GuildMaxVideoChannelUsers guildMaxVideoChannelMembers, Guild guild, boolean isChannelSelected, boolean isMyHandRaised, List<GuildScheduledEvent> guildScheduledEvents, Map<Long, EmbeddedActivity> embeddedActivitiesForChannel, Map<Long, Application> applications, Channel channel, int numUsersConnected, Long channelPermissions, StoreAudioManagerV2.State audioManagerState) {
        Intrinsics3.checkNotNullParameter(participants, "participants");
        Intrinsics3.checkNotNullParameter(videoDevices, "videoDevices");
        Intrinsics3.checkNotNullParameter(voiceSettings, "voiceSettings");
        Intrinsics3.checkNotNullParameter(voiceChannelJoinability, "voiceChannelJoinability");
        Intrinsics3.checkNotNullParameter(guildMaxVideoChannelMembers, "guildMaxVideoChannelMembers");
        Intrinsics3.checkNotNullParameter(guildScheduledEvents, "guildScheduledEvents");
        Intrinsics3.checkNotNullParameter(embeddedActivitiesForChannel, "embeddedActivitiesForChannel");
        Intrinsics3.checkNotNullParameter(applications, "applications");
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Intrinsics3.checkNotNullParameter(audioManagerState, "audioManagerState");
        return new CallModel(participants, myId, timeConnectedMs, videoDevices, selectedVideoDevice, voiceSettings, rtcConnectionMetadata, callFeedbackTriggerRateDenominator, streamFeedbackTriggerRateDenominator, activeStream, voiceChannelJoinability, guildMaxVideoChannelMembers, guild, isChannelSelected, isMyHandRaised, guildScheduledEvents, embeddedActivitiesForChannel, applications, channel, numUsersConnected, channelPermissions, audioManagerState);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CallModel)) {
            return false;
        }
        CallModel callModel = (CallModel) other;
        return Intrinsics3.areEqual(this.participants, callModel.participants) && this.myId == callModel.myId && this.timeConnectedMs == callModel.timeConnectedMs && Intrinsics3.areEqual(this.videoDevices, callModel.videoDevices) && Intrinsics3.areEqual(this.selectedVideoDevice, callModel.selectedVideoDevice) && Intrinsics3.areEqual(this.voiceSettings, callModel.voiceSettings) && Intrinsics3.areEqual(this.rtcConnectionMetadata, callModel.rtcConnectionMetadata) && this.callFeedbackTriggerRateDenominator == callModel.callFeedbackTriggerRateDenominator && this.streamFeedbackTriggerRateDenominator == callModel.streamFeedbackTriggerRateDenominator && Intrinsics3.areEqual(this.activeStream, callModel.activeStream) && Intrinsics3.areEqual(this.voiceChannelJoinability, callModel.voiceChannelJoinability) && Intrinsics3.areEqual(this.guildMaxVideoChannelMembers, callModel.guildMaxVideoChannelMembers) && Intrinsics3.areEqual(this.guild, callModel.guild) && this.isChannelSelected == callModel.isChannelSelected && this.isMyHandRaised == callModel.isMyHandRaised && Intrinsics3.areEqual(this.guildScheduledEvents, callModel.guildScheduledEvents) && Intrinsics3.areEqual(this.embeddedActivitiesForChannel, callModel.embeddedActivitiesForChannel) && Intrinsics3.areEqual(this.applications, callModel.applications) && Intrinsics3.areEqual(this.channel, callModel.channel) && this.numUsersConnected == callModel.numUsersConnected && Intrinsics3.areEqual(this.channelPermissions, callModel.channelPermissions) && Intrinsics3.areEqual(this.audioManagerState, callModel.audioManagerState);
    }

    public final StoreApplicationStreaming.ActiveApplicationStream getActiveStream() {
        return this.activeStream;
    }

    public final Map<Long, Application> getApplications() {
        return this.applications;
    }

    public final StoreAudioManagerV2.State getAudioManagerState() {
        return this.audioManagerState;
    }

    public final long getCallDurationMs(Clock clock) {
        Intrinsics3.checkNotNullParameter(clock, "clock");
        return clock.currentTimeMillis() - this.timeConnectedMs;
    }

    public final int getCallFeedbackTriggerRateDenominator() {
        return this.callFeedbackTriggerRateDenominator;
    }

    public final CameraState getCameraState() {
        return this.cameraState;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final Long getChannelPermissions() {
        return this.channelPermissions;
    }

    public final StoreVoiceParticipants.VoiceUser getDmRecipient() {
        Object obj = null;
        if (this.channel.getType() != 1) {
            return null;
        }
        Iterator<T> it = this.participants.values().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((StoreVoiceParticipants.VoiceUser) next).getUser().getId() != this.myId) {
                obj = next;
                break;
            }
        }
        return (StoreVoiceParticipants.VoiceUser) obj;
    }

    public final Map<Long, EmbeddedActivity> getEmbeddedActivitiesForChannel() {
        return this.embeddedActivitiesForChannel;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final GuildMaxVideoChannelUsers getGuildMaxVideoChannelMembers() {
        return this.guildMaxVideoChannelMembers;
    }

    public final List<GuildScheduledEvent> getGuildScheduledEvents() {
        return this.guildScheduledEvents;
    }

    public final MediaEngineConnection.InputMode getInputMode() {
        return this.voiceSettings.getInputMode();
    }

    public final long getMyId() {
        return this.myId;
    }

    public final int getNumUsersConnected() {
        return this.numUsersConnected;
    }

    public final Map<Long, StoreVoiceParticipants.VoiceUser> getParticipants() {
        return this.participants;
    }

    public final RtcConnection.Metadata getRtcConnectionMetadata() {
        return this.rtcConnectionMetadata;
    }

    public final DeviceDescription4 getSelectedVideoDevice() {
        return this.selectedVideoDevice;
    }

    public final int getStreamFeedbackTriggerRateDenominator() {
        return this.streamFeedbackTriggerRateDenominator;
    }

    public final long getTimeConnectedMs() {
        return this.timeConnectedMs;
    }

    public final List<DeviceDescription4> getVideoDevices() {
        return this.videoDevices;
    }

    public final VoiceChannelJoinabilityUtils2 getVoiceChannelJoinability() {
        return this.voiceChannelJoinability;
    }

    public final StoreMediaSettings.VoiceConfiguration getVoiceSettings() {
        return this.voiceSettings;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Map<Long, StoreVoiceParticipants.VoiceUser> map = this.participants;
        int iM3a = (C0002b.m3a(this.timeConnectedMs) + ((C0002b.m3a(this.myId) + ((map != null ? map.hashCode() : 0) * 31)) * 31)) * 31;
        List<DeviceDescription4> list = this.videoDevices;
        int iHashCode = (iM3a + (list != null ? list.hashCode() : 0)) * 31;
        DeviceDescription4 deviceDescription4 = this.selectedVideoDevice;
        int iHashCode2 = (iHashCode + (deviceDescription4 != null ? deviceDescription4.hashCode() : 0)) * 31;
        StoreMediaSettings.VoiceConfiguration voiceConfiguration = this.voiceSettings;
        int iHashCode3 = (iHashCode2 + (voiceConfiguration != null ? voiceConfiguration.hashCode() : 0)) * 31;
        RtcConnection.Metadata metadata = this.rtcConnectionMetadata;
        int iHashCode4 = (((((iHashCode3 + (metadata != null ? metadata.hashCode() : 0)) * 31) + this.callFeedbackTriggerRateDenominator) * 31) + this.streamFeedbackTriggerRateDenominator) * 31;
        StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream = this.activeStream;
        int iHashCode5 = (iHashCode4 + (activeApplicationStream != null ? activeApplicationStream.hashCode() : 0)) * 31;
        VoiceChannelJoinabilityUtils2 voiceChannelJoinabilityUtils2 = this.voiceChannelJoinability;
        int iHashCode6 = (iHashCode5 + (voiceChannelJoinabilityUtils2 != null ? voiceChannelJoinabilityUtils2.hashCode() : 0)) * 31;
        GuildMaxVideoChannelUsers guildMaxVideoChannelUsers = this.guildMaxVideoChannelMembers;
        int iHashCode7 = (iHashCode6 + (guildMaxVideoChannelUsers != null ? guildMaxVideoChannelUsers.hashCode() : 0)) * 31;
        Guild guild = this.guild;
        int iHashCode8 = (iHashCode7 + (guild != null ? guild.hashCode() : 0)) * 31;
        boolean z2 = this.isChannelSelected;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode8 + i) * 31;
        boolean z3 = this.isMyHandRaised;
        int i3 = (i2 + (z3 ? 1 : z3 ? 1 : 0)) * 31;
        List<GuildScheduledEvent> list2 = this.guildScheduledEvents;
        int iHashCode9 = (i3 + (list2 != null ? list2.hashCode() : 0)) * 31;
        Map<Long, EmbeddedActivity> map2 = this.embeddedActivitiesForChannel;
        int iHashCode10 = (iHashCode9 + (map2 != null ? map2.hashCode() : 0)) * 31;
        Map<Long, Application> map3 = this.applications;
        int iHashCode11 = (iHashCode10 + (map3 != null ? map3.hashCode() : 0)) * 31;
        Channel channel = this.channel;
        int iHashCode12 = (((iHashCode11 + (channel != null ? channel.hashCode() : 0)) * 31) + this.numUsersConnected) * 31;
        Long l = this.channelPermissions;
        int iHashCode13 = (iHashCode12 + (l != null ? l.hashCode() : 0)) * 31;
        StoreAudioManagerV2.State state = this.audioManagerState;
        return iHashCode13 + (state != null ? state.hashCode() : 0);
    }

    public final boolean isChannelSelected() {
        return this.isChannelSelected;
    }

    public final boolean isConnected() {
        StoreVoiceParticipants.VoiceUser voiceUser = this.participants.get(Long.valueOf(this.myId));
        if (voiceUser != null) {
            return voiceUser.isConnected();
        }
        return false;
    }

    public final boolean isDeafenedByAnySource() {
        return isSelfDeafened() || isServerDeafened();
    }

    public final boolean isMeMutedByAnySource() {
        VoiceState voiceState;
        StoreVoiceParticipants.VoiceUser voiceUser = this.participants.get(Long.valueOf(this.myId));
        if (voiceUser == null || (voiceState = voiceUser.getVoiceState()) == null) {
            return false;
        }
        return AnimatableValueParser.m481V0(voiceState);
    }

    public final boolean isMuted() {
        VoiceState voiceState;
        StoreVoiceParticipants.VoiceUser voiceUser = this.participants.get(Long.valueOf(this.myId));
        if (voiceUser == null || (voiceState = voiceUser.getVoiceState()) == null) {
            return false;
        }
        return voiceState.getMute();
    }

    public final boolean isMyHandRaised() {
        return this.isMyHandRaised;
    }

    public final boolean isSelfDeafened() {
        return this.voiceSettings.isSelfDeafened();
    }

    public final boolean isServerDeafened() {
        VoiceState voiceState;
        StoreVoiceParticipants.VoiceUser voiceUser = this.participants.get(Long.valueOf(this.myId));
        if (voiceUser == null || (voiceState = voiceUser.getVoiceState()) == null) {
            return false;
        }
        return voiceState.getDeaf();
    }

    public final boolean isStreaming() {
        ModelApplicationStream stream;
        long j = this.myId;
        StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream = this.activeStream;
        return (activeApplicationStream == null || (stream = activeApplicationStream.getStream()) == null || j != stream.getOwnerId()) ? false : true;
    }

    public final boolean isSuppressed() {
        VoiceState voiceState;
        StoreVoiceParticipants.VoiceUser voiceUser = this.participants.get(Long.valueOf(this.myId));
        if (voiceUser == null || (voiceState = voiceUser.getVoiceState()) == null) {
            return false;
        }
        return voiceState.getSuppress();
    }

    /* renamed from: isVideoCall, reason: from getter */
    public final boolean getIsVideoCall() {
        return this.isVideoCall;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("CallModel(participants=");
        sbM833U.append(this.participants);
        sbM833U.append(", myId=");
        sbM833U.append(this.myId);
        sbM833U.append(", timeConnectedMs=");
        sbM833U.append(this.timeConnectedMs);
        sbM833U.append(", videoDevices=");
        sbM833U.append(this.videoDevices);
        sbM833U.append(", selectedVideoDevice=");
        sbM833U.append(this.selectedVideoDevice);
        sbM833U.append(", voiceSettings=");
        sbM833U.append(this.voiceSettings);
        sbM833U.append(", rtcConnectionMetadata=");
        sbM833U.append(this.rtcConnectionMetadata);
        sbM833U.append(", callFeedbackTriggerRateDenominator=");
        sbM833U.append(this.callFeedbackTriggerRateDenominator);
        sbM833U.append(", streamFeedbackTriggerRateDenominator=");
        sbM833U.append(this.streamFeedbackTriggerRateDenominator);
        sbM833U.append(", activeStream=");
        sbM833U.append(this.activeStream);
        sbM833U.append(", voiceChannelJoinability=");
        sbM833U.append(this.voiceChannelJoinability);
        sbM833U.append(", guildMaxVideoChannelMembers=");
        sbM833U.append(this.guildMaxVideoChannelMembers);
        sbM833U.append(", guild=");
        sbM833U.append(this.guild);
        sbM833U.append(", isChannelSelected=");
        sbM833U.append(this.isChannelSelected);
        sbM833U.append(", isMyHandRaised=");
        sbM833U.append(this.isMyHandRaised);
        sbM833U.append(", guildScheduledEvents=");
        sbM833U.append(this.guildScheduledEvents);
        sbM833U.append(", embeddedActivitiesForChannel=");
        sbM833U.append(this.embeddedActivitiesForChannel);
        sbM833U.append(", applications=");
        sbM833U.append(this.applications);
        sbM833U.append(", channel=");
        sbM833U.append(this.channel);
        sbM833U.append(", numUsersConnected=");
        sbM833U.append(this.numUsersConnected);
        sbM833U.append(", channelPermissions=");
        sbM833U.append(this.channelPermissions);
        sbM833U.append(", audioManagerState=");
        sbM833U.append(this.audioManagerState);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
