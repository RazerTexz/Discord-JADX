package com.discord.gateway.io;

import b.d.b.a.a;
import com.discord.api.activity.Activity;
import com.discord.utilities.time.ClockFactory;
import d0.t.n;
import d0.z.d.m;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Outgoing.kt */
/* loaded from: classes.dex */
public abstract class OutgoingPayload {

    /* compiled from: Outgoing.kt */
    public static final class ApplicationCommandRequest extends OutgoingPayload {
        private final boolean applications;
        private final List<String> commandIds;
        private final long guildId;
        private final Integer limit;
        private final String nonce;
        private final Integer offset;
        private final String query;

        public /* synthetic */ ApplicationCommandRequest(long j, String str, Integer num, Integer num2, boolean z2, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : num2, (i & 16) != 0 ? false : z2, str2, (i & 64) != 0 ? null : list);
        }

        public final boolean getApplications() {
            return this.applications;
        }

        public final List<String> getCommandIds() {
            return this.commandIds;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        public final Integer getLimit() {
            return this.limit;
        }

        public final String getNonce() {
            return this.nonce;
        }

        public final Integer getOffset() {
            return this.offset;
        }

        public final String getQuery() {
            return this.query;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ApplicationCommandRequest(long j, String str, Integer num, Integer num2, boolean z2, String str2, List<String> list) {
            super(null);
            m.checkNotNullParameter(str2, "nonce");
            this.guildId = j;
            this.query = str;
            this.offset = num;
            this.limit = num2;
            this.applications = z2;
            this.nonce = str2;
            this.commandIds = list;
        }
    }

    /* compiled from: Outgoing.kt */
    public static final class CallConnect extends OutgoingPayload {
        private final long channelId;

        public CallConnect(long j) {
            super(null);
            this.channelId = j;
        }
    }

    /* compiled from: Outgoing.kt */
    public static final class CreateStream {
        private final long channelId;
        private final Long guildId;
        private final String preferredRegion;
        private final String type;

        public CreateStream(String str, long j, Long l, String str2) {
            m.checkNotNullParameter(str, "type");
            this.type = str;
            this.channelId = j;
            this.guildId = l;
            this.preferredRegion = str2;
        }

        public final long getChannelId() {
            return this.channelId;
        }

        public final Long getGuildId() {
            return this.guildId;
        }

        public final String getPreferredRegion() {
            return this.preferredRegion;
        }

        public final String getType() {
            return this.type;
        }
    }

    /* compiled from: Outgoing.kt */
    public static final class DeleteStream extends OutgoingPayload {
        private final String streamKey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DeleteStream(String str) {
            super(null);
            m.checkNotNullParameter(str, "streamKey");
            this.streamKey = str;
        }

        public final String getStreamKey() {
            return this.streamKey;
        }
    }

    /* compiled from: Outgoing.kt */
    public static final class ForumUnreadsRequest extends OutgoingPayload {
        private final long channelId;
        private final long guildId;
        private final List<ForumUnreadsRequestThread> threads;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ForumUnreadsRequest(long j, long j2, List<ForumUnreadsRequestThread> list) {
            super(null);
            m.checkNotNullParameter(list, "threads");
            this.guildId = j;
            this.channelId = j2;
            this.threads = list;
        }

        public final long getChannelId() {
            return this.channelId;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        public final List<ForumUnreadsRequestThread> getThreads() {
            return this.threads;
        }
    }

    /* compiled from: Outgoing.kt */
    public static final class ForumUnreadsRequestThread {
        private final long ackMessageId;
        private final long threadId;

        public ForumUnreadsRequestThread(long j, long j2) {
            this.threadId = j;
            this.ackMessageId = j2;
        }

        public final long getAckMessageId() {
            return this.ackMessageId;
        }

        public final long getThreadId() {
            return this.threadId;
        }
    }

    /* compiled from: Outgoing.kt */
    public static final /* data */ class GuildMembersRequest extends OutgoingPayload {
        private final List<Long> guildId;
        private final Integer limit;
        private final boolean presences;
        private final String query;
        private final List<Long> userIds;

        public /* synthetic */ GuildMembersRequest(List list, String str, List list2, Integer num, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : list2, (i & 8) != 0 ? null : num, (i & 16) != 0 ? true : z2);
        }

        private final List<Long> component1() {
            return this.guildId;
        }

        /* renamed from: component2, reason: from getter */
        private final String getQuery() {
            return this.query;
        }

        private final List<Long> component3() {
            return this.userIds;
        }

        /* renamed from: component4, reason: from getter */
        private final Integer getLimit() {
            return this.limit;
        }

        public static /* synthetic */ GuildMembersRequest copy$default(GuildMembersRequest guildMembersRequest, List list, String str, List list2, Integer num, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = guildMembersRequest.guildId;
            }
            if ((i & 2) != 0) {
                str = guildMembersRequest.query;
            }
            String str2 = str;
            if ((i & 4) != 0) {
                list2 = guildMembersRequest.userIds;
            }
            List list3 = list2;
            if ((i & 8) != 0) {
                num = guildMembersRequest.limit;
            }
            Integer num2 = num;
            if ((i & 16) != 0) {
                z2 = guildMembersRequest.presences;
            }
            return guildMembersRequest.copy(list, str2, list3, num2, z2);
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getPresences() {
            return this.presences;
        }

        public final GuildMembersRequest copy(List<Long> guildId, String query, List<Long> userIds, Integer limit, boolean presences) {
            m.checkNotNullParameter(guildId, "guildId");
            return new GuildMembersRequest(guildId, query, userIds, limit, presences);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GuildMembersRequest)) {
                return false;
            }
            GuildMembersRequest guildMembersRequest = (GuildMembersRequest) other;
            return m.areEqual(this.guildId, guildMembersRequest.guildId) && m.areEqual(this.query, guildMembersRequest.query) && m.areEqual(this.userIds, guildMembersRequest.userIds) && m.areEqual(this.limit, guildMembersRequest.limit) && this.presences == guildMembersRequest.presences;
        }

        public final boolean getPresences() {
            return this.presences;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            List<Long> list = this.guildId;
            int iHashCode = (list != null ? list.hashCode() : 0) * 31;
            String str = this.query;
            int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
            List<Long> list2 = this.userIds;
            int iHashCode3 = (iHashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31;
            Integer num = this.limit;
            int iHashCode4 = (iHashCode3 + (num != null ? num.hashCode() : 0)) * 31;
            boolean z2 = this.presences;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode4 + i;
        }

        public String toString() {
            StringBuilder sbU = a.U("GuildMembersRequest(guildId=");
            sbU.append(this.guildId);
            sbU.append(", query=");
            sbU.append(this.query);
            sbU.append(", userIds=");
            sbU.append(this.userIds);
            sbU.append(", limit=");
            sbU.append(this.limit);
            sbU.append(", presences=");
            return a.O(sbU, this.presences, ")");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GuildMembersRequest(List<Long> list, String str, List<Long> list2, Integer num, boolean z2) {
            super(null);
            m.checkNotNullParameter(list, "guildId");
            this.guildId = list;
            this.query = str;
            this.userIds = list2;
            this.limit = num;
            this.presences = z2;
        }
    }

    /* compiled from: Outgoing.kt */
    public static final class GuildSubscriptions extends OutgoingPayload {
        private final Boolean activities;
        private final Map<Long, List<List<Integer>>> channels;
        private final List<Long> members;
        private final List<Long> threadMemberLists;
        private final Boolean threads;
        private final Boolean typing;

        public /* synthetic */ GuildSubscriptions(Map map, Boolean bool, Boolean bool2, List list, Boolean bool3, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : map, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : bool2, (i & 8) != 0 ? null : list, (i & 16) != 0 ? null : bool3, list2);
        }

        public final Boolean getActivities() {
            return this.activities;
        }

        public final Map<Long, List<List<Integer>>> getChannels() {
            return this.channels;
        }

        public final List<Long> getMembers() {
            return this.members;
        }

        public final List<Long> getThreadMemberLists() {
            return this.threadMemberLists;
        }

        public final Boolean getThreads() {
            return this.threads;
        }

        public final Boolean getTyping() {
            return this.typing;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public GuildSubscriptions(Map<Long, ? extends List<? extends List<Integer>>> map, Boolean bool, Boolean bool2, List<Long> list, Boolean bool3, List<Long> list2) {
            super(null);
            this.channels = map;
            this.typing = bool;
            this.activities = bool2;
            this.members = list;
            this.threads = bool3;
            this.threadMemberLists = list2;
        }
    }

    /* compiled from: Outgoing.kt */
    public static final class GuildSubscriptionsUpdate extends OutgoingPayload {
        private final Boolean activities;
        private final Map<Long, List<List<Integer>>> channels;
        private final long guildId;
        private final List<Long> members;
        private final List<Long> threadMemberLists;
        private final Boolean threads;
        private final Boolean typing;

        /* JADX WARN: Multi-variable type inference failed */
        public GuildSubscriptionsUpdate(long j, Boolean bool, Boolean bool2, List<Long> list, Map<Long, ? extends List<? extends List<Integer>>> map, Boolean bool3, List<Long> list2) {
            super(null);
            this.guildId = j;
            this.typing = bool;
            this.activities = bool2;
            this.members = list;
            this.channels = map;
            this.threads = bool3;
            this.threadMemberLists = list2;
        }

        public final Boolean getActivities() {
            return this.activities;
        }

        public final Map<Long, List<List<Integer>>> getChannels() {
            return this.channels;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        public final List<Long> getMembers() {
            return this.members;
        }

        public final List<Long> getThreadMemberLists() {
            return this.threadMemberLists;
        }

        public final Boolean getThreads() {
            return this.threads;
        }

        public final Boolean getTyping() {
            return this.typing;
        }
    }

    /* compiled from: Outgoing.kt */
    public static final class Identify extends OutgoingPayload {
        private final long capabilities;
        private final IdentifyClientState clientState;
        private final boolean compress;
        private final int largeThreshold;
        private final Map<String, Object> properties;
        private final String token;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Identify(String str, int i, boolean z2, long j, Map<String, ? extends Object> map, IdentifyClientState identifyClientState) {
            super(null);
            m.checkNotNullParameter(str, "token");
            m.checkNotNullParameter(map, "properties");
            this.token = str;
            this.largeThreshold = i;
            this.compress = z2;
            this.capabilities = j;
            this.properties = map;
            this.clientState = identifyClientState;
        }
    }

    /* compiled from: Outgoing.kt */
    public static final class IdentifyClientState {
        private final Map<Long, String[]> guildHashes;
        private final long highestLastMessageId;
        private final int readStateVersion;
        private final int useruserGuildSettingsVersion;

        public IdentifyClientState(Map<Long, String[]> map, long j, int i, int i2) {
            m.checkNotNullParameter(map, "guildHashes");
            this.guildHashes = map;
            this.highestLastMessageId = j;
            this.readStateVersion = i;
            this.useruserGuildSettingsVersion = i2;
        }

        public final Map<Long, String[]> getGuildHashes() {
            return this.guildHashes;
        }

        public final long getHighestLastMessageId() {
            return this.highestLastMessageId;
        }

        public final int getReadStateVersion() {
            return this.readStateVersion;
        }

        public final int getUseruserGuildSettingsVersion() {
            return this.useruserGuildSettingsVersion;
        }
    }

    /* compiled from: Outgoing.kt */
    public static final class Resume extends OutgoingPayload {
        private final int seq;
        private final String sessionId;
        private final String token;

        public Resume(String str, String str2, int i) {
            super(null);
            this.token = str;
            this.sessionId = str2;
            this.seq = i;
        }
    }

    /* compiled from: Outgoing.kt */
    public static final class StreamPing extends OutgoingPayload {
        private final String streamKey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StreamPing(String str) {
            super(null);
            m.checkNotNullParameter(str, "streamKey");
            this.streamKey = str;
        }

        public final String getStreamKey() {
            return this.streamKey;
        }
    }

    /* compiled from: Outgoing.kt */
    public static final /* data */ class VoiceStateUpdate extends OutgoingPayload {
        private final Long channelId;
        private final Long guildId;
        private final String preferredRegion;
        private final boolean selfDeaf;
        private final boolean selfMute;
        private final boolean selfVideo;

        public /* synthetic */ VoiceStateUpdate(Long l, Long l2, boolean z2, boolean z3, boolean z4, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(l, l2, z2, z3, z4, (i & 32) != 0 ? null : str);
        }

        public static /* synthetic */ VoiceStateUpdate copy$default(VoiceStateUpdate voiceStateUpdate, Long l, Long l2, boolean z2, boolean z3, boolean z4, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                l = voiceStateUpdate.guildId;
            }
            if ((i & 2) != 0) {
                l2 = voiceStateUpdate.channelId;
            }
            Long l3 = l2;
            if ((i & 4) != 0) {
                z2 = voiceStateUpdate.selfMute;
            }
            boolean z5 = z2;
            if ((i & 8) != 0) {
                z3 = voiceStateUpdate.selfDeaf;
            }
            boolean z6 = z3;
            if ((i & 16) != 0) {
                z4 = voiceStateUpdate.selfVideo;
            }
            boolean z7 = z4;
            if ((i & 32) != 0) {
                str = voiceStateUpdate.preferredRegion;
            }
            return voiceStateUpdate.copy(l, l3, z5, z6, z7, str);
        }

        /* renamed from: component1, reason: from getter */
        public final Long getGuildId() {
            return this.guildId;
        }

        /* renamed from: component2, reason: from getter */
        public final Long getChannelId() {
            return this.channelId;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getSelfMute() {
            return this.selfMute;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getSelfDeaf() {
            return this.selfDeaf;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getSelfVideo() {
            return this.selfVideo;
        }

        /* renamed from: component6, reason: from getter */
        public final String getPreferredRegion() {
            return this.preferredRegion;
        }

        public final VoiceStateUpdate copy(Long guildId, Long channelId, boolean selfMute, boolean selfDeaf, boolean selfVideo, String preferredRegion) {
            return new VoiceStateUpdate(guildId, channelId, selfMute, selfDeaf, selfVideo, preferredRegion);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VoiceStateUpdate)) {
                return false;
            }
            VoiceStateUpdate voiceStateUpdate = (VoiceStateUpdate) other;
            return m.areEqual(this.guildId, voiceStateUpdate.guildId) && m.areEqual(this.channelId, voiceStateUpdate.channelId) && this.selfMute == voiceStateUpdate.selfMute && this.selfDeaf == voiceStateUpdate.selfDeaf && this.selfVideo == voiceStateUpdate.selfVideo && m.areEqual(this.preferredRegion, voiceStateUpdate.preferredRegion);
        }

        public final Long getChannelId() {
            return this.channelId;
        }

        public final Long getGuildId() {
            return this.guildId;
        }

        public final String getPreferredRegion() {
            return this.preferredRegion;
        }

        public final boolean getSelfDeaf() {
            return this.selfDeaf;
        }

        public final boolean getSelfMute() {
            return this.selfMute;
        }

        public final boolean getSelfVideo() {
            return this.selfVideo;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            Long l = this.guildId;
            int iHashCode = (l != null ? l.hashCode() : 0) * 31;
            Long l2 = this.channelId;
            int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
            boolean z2 = this.selfMute;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode2 + i) * 31;
            boolean z3 = this.selfDeaf;
            int i3 = z3;
            if (z3 != 0) {
                i3 = 1;
            }
            int i4 = (i2 + i3) * 31;
            boolean z4 = this.selfVideo;
            int i5 = (i4 + (z4 ? 1 : z4 ? 1 : 0)) * 31;
            String str = this.preferredRegion;
            return i5 + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = a.U("VoiceStateUpdate(guildId=");
            sbU.append(this.guildId);
            sbU.append(", channelId=");
            sbU.append(this.channelId);
            sbU.append(", selfMute=");
            sbU.append(this.selfMute);
            sbU.append(", selfDeaf=");
            sbU.append(this.selfDeaf);
            sbU.append(", selfVideo=");
            sbU.append(this.selfVideo);
            sbU.append(", preferredRegion=");
            return a.J(sbU, this.preferredRegion, ")");
        }

        public VoiceStateUpdate(Long l, Long l2, boolean z2, boolean z3, boolean z4, String str) {
            super(null);
            this.guildId = l;
            this.channelId = l2;
            this.selfMute = z2;
            this.selfDeaf = z3;
            this.selfVideo = z4;
            this.preferredRegion = str;
        }
    }

    /* compiled from: Outgoing.kt */
    public static final /* data */ class VoiceStateUpdateNoPreferredRegion extends OutgoingPayload {
        private final Long channelId;
        private final Long guildId;
        private final boolean selfDeaf;
        private final boolean selfMute;
        private final boolean selfVideo;

        public VoiceStateUpdateNoPreferredRegion(Long l, Long l2, boolean z2, boolean z3, boolean z4) {
            super(null);
            this.guildId = l;
            this.channelId = l2;
            this.selfMute = z2;
            this.selfDeaf = z3;
            this.selfVideo = z4;
        }

        public static /* synthetic */ VoiceStateUpdateNoPreferredRegion copy$default(VoiceStateUpdateNoPreferredRegion voiceStateUpdateNoPreferredRegion, Long l, Long l2, boolean z2, boolean z3, boolean z4, int i, Object obj) {
            if ((i & 1) != 0) {
                l = voiceStateUpdateNoPreferredRegion.guildId;
            }
            if ((i & 2) != 0) {
                l2 = voiceStateUpdateNoPreferredRegion.channelId;
            }
            Long l3 = l2;
            if ((i & 4) != 0) {
                z2 = voiceStateUpdateNoPreferredRegion.selfMute;
            }
            boolean z5 = z2;
            if ((i & 8) != 0) {
                z3 = voiceStateUpdateNoPreferredRegion.selfDeaf;
            }
            boolean z6 = z3;
            if ((i & 16) != 0) {
                z4 = voiceStateUpdateNoPreferredRegion.selfVideo;
            }
            return voiceStateUpdateNoPreferredRegion.copy(l, l3, z5, z6, z4);
        }

        /* renamed from: component1, reason: from getter */
        public final Long getGuildId() {
            return this.guildId;
        }

        /* renamed from: component2, reason: from getter */
        public final Long getChannelId() {
            return this.channelId;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getSelfMute() {
            return this.selfMute;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getSelfDeaf() {
            return this.selfDeaf;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getSelfVideo() {
            return this.selfVideo;
        }

        public final VoiceStateUpdateNoPreferredRegion copy(Long guildId, Long channelId, boolean selfMute, boolean selfDeaf, boolean selfVideo) {
            return new VoiceStateUpdateNoPreferredRegion(guildId, channelId, selfMute, selfDeaf, selfVideo);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VoiceStateUpdateNoPreferredRegion)) {
                return false;
            }
            VoiceStateUpdateNoPreferredRegion voiceStateUpdateNoPreferredRegion = (VoiceStateUpdateNoPreferredRegion) other;
            return m.areEqual(this.guildId, voiceStateUpdateNoPreferredRegion.guildId) && m.areEqual(this.channelId, voiceStateUpdateNoPreferredRegion.channelId) && this.selfMute == voiceStateUpdateNoPreferredRegion.selfMute && this.selfDeaf == voiceStateUpdateNoPreferredRegion.selfDeaf && this.selfVideo == voiceStateUpdateNoPreferredRegion.selfVideo;
        }

        public final Long getChannelId() {
            return this.channelId;
        }

        public final Long getGuildId() {
            return this.guildId;
        }

        public final boolean getSelfDeaf() {
            return this.selfDeaf;
        }

        public final boolean getSelfMute() {
            return this.selfMute;
        }

        public final boolean getSelfVideo() {
            return this.selfVideo;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            Long l = this.guildId;
            int iHashCode = (l != null ? l.hashCode() : 0) * 31;
            Long l2 = this.channelId;
            int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
            boolean z2 = this.selfMute;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode2 + i) * 31;
            boolean z3 = this.selfDeaf;
            int i3 = z3;
            if (z3 != 0) {
                i3 = 1;
            }
            int i4 = (i2 + i3) * 31;
            boolean z4 = this.selfVideo;
            return i4 + (z4 ? 1 : z4 ? 1 : 0);
        }

        public String toString() {
            StringBuilder sbU = a.U("VoiceStateUpdateNoPreferredRegion(guildId=");
            sbU.append(this.guildId);
            sbU.append(", channelId=");
            sbU.append(this.channelId);
            sbU.append(", selfMute=");
            sbU.append(this.selfMute);
            sbU.append(", selfDeaf=");
            sbU.append(this.selfDeaf);
            sbU.append(", selfVideo=");
            return a.O(sbU, this.selfVideo, ")");
        }
    }

    /* compiled from: Outgoing.kt */
    public static final class WatchStream extends OutgoingPayload {
        private final String streamKey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WatchStream(String str) {
            super(null);
            m.checkNotNullParameter(str, "streamKey");
            this.streamKey = str;
        }

        public final String getStreamKey() {
            return this.streamKey;
        }
    }

    private OutgoingPayload() {
    }

    public /* synthetic */ OutgoingPayload(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: Outgoing.kt */
    public static final /* data */ class PresenceUpdate extends OutgoingPayload {
        private final List<Activity> activities;
        private final Boolean afk;
        private final Long since;
        private final String status;

        public /* synthetic */ PresenceUpdate(String str, Long l, List list, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? Long.valueOf(ClockFactory.get().currentTimeMillis()) : l, (i & 4) != 0 ? n.emptyList() : list, (i & 8) != 0 ? Boolean.FALSE : bool);
        }

        /* renamed from: component1, reason: from getter */
        private final String getStatus() {
            return this.status;
        }

        /* renamed from: component2, reason: from getter */
        private final Long getSince() {
            return this.since;
        }

        private final List<Activity> component3() {
            return this.activities;
        }

        /* renamed from: component4, reason: from getter */
        private final Boolean getAfk() {
            return this.afk;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PresenceUpdate copy$default(PresenceUpdate presenceUpdate, String str, Long l, List list, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                str = presenceUpdate.status;
            }
            if ((i & 2) != 0) {
                l = presenceUpdate.since;
            }
            if ((i & 4) != 0) {
                list = presenceUpdate.activities;
            }
            if ((i & 8) != 0) {
                bool = presenceUpdate.afk;
            }
            return presenceUpdate.copy(str, l, list, bool);
        }

        public final PresenceUpdate copy(String status, Long since, List<Activity> activities, Boolean afk) {
            m.checkNotNullParameter(activities, "activities");
            return new PresenceUpdate(status, since, activities, afk);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PresenceUpdate)) {
                return false;
            }
            PresenceUpdate presenceUpdate = (PresenceUpdate) other;
            return m.areEqual(this.status, presenceUpdate.status) && m.areEqual(this.since, presenceUpdate.since) && m.areEqual(this.activities, presenceUpdate.activities) && m.areEqual(this.afk, presenceUpdate.afk);
        }

        public int hashCode() {
            String str = this.status;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            Long l = this.since;
            int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
            List<Activity> list = this.activities;
            int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
            Boolean bool = this.afk;
            return iHashCode3 + (bool != null ? bool.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = a.U("PresenceUpdate(status=");
            sbU.append(this.status);
            sbU.append(", since=");
            sbU.append(this.since);
            sbU.append(", activities=");
            sbU.append(this.activities);
            sbU.append(", afk=");
            return a.D(sbU, this.afk, ")");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PresenceUpdate(String str, Long l, List<Activity> list, Boolean bool) {
            super(null);
            m.checkNotNullParameter(list, "activities");
            this.status = str;
            this.since = l;
            this.activities = list;
            this.afk = bool;
        }
    }
}
