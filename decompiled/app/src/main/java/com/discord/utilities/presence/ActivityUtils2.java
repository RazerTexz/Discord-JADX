package com.discord.utilities.presence;

import a0.a.a.b;
import b.d.b.a.outline;

/* compiled from: ActivityUtils.kt */
/* renamed from: com.discord.utilities.presence.StageCallRichPresencePartyData, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class ActivityUtils2 {
    private final long audienceSize;
    private final long channelId;
    private final long guildId;
    private final boolean guildIsPartnered;
    private final boolean guildIsVerified;
    private final long speakerCount;
    private final long stageInstanceId;
    private final boolean userIsSpeaker;

    public ActivityUtils2(long j, long j2, boolean z2, long j3, boolean z3, boolean z4, long j4, long j5) {
        this.stageInstanceId = j;
        this.channelId = j2;
        this.userIsSpeaker = z2;
        this.guildId = j3;
        this.guildIsPartnered = z3;
        this.guildIsVerified = z4;
        this.speakerCount = j4;
        this.audienceSize = j5;
    }

    public static /* synthetic */ ActivityUtils2 copy$default(ActivityUtils2 activityUtils2, long j, long j2, boolean z2, long j3, boolean z3, boolean z4, long j4, long j5, int i, Object obj) {
        return activityUtils2.copy((i & 1) != 0 ? activityUtils2.stageInstanceId : j, (i & 2) != 0 ? activityUtils2.channelId : j2, (i & 4) != 0 ? activityUtils2.userIsSpeaker : z2, (i & 8) != 0 ? activityUtils2.guildId : j3, (i & 16) != 0 ? activityUtils2.guildIsPartnered : z3, (i & 32) != 0 ? activityUtils2.guildIsVerified : z4, (i & 64) != 0 ? activityUtils2.speakerCount : j4, (i & 128) != 0 ? activityUtils2.audienceSize : j5);
    }

    /* renamed from: component1, reason: from getter */
    public final long getStageInstanceId() {
        return this.stageInstanceId;
    }

    /* renamed from: component2, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getUserIsSpeaker() {
        return this.userIsSpeaker;
    }

    /* renamed from: component4, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getGuildIsPartnered() {
        return this.guildIsPartnered;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getGuildIsVerified() {
        return this.guildIsVerified;
    }

    /* renamed from: component7, reason: from getter */
    public final long getSpeakerCount() {
        return this.speakerCount;
    }

    /* renamed from: component8, reason: from getter */
    public final long getAudienceSize() {
        return this.audienceSize;
    }

    public final ActivityUtils2 copy(long stageInstanceId, long channelId, boolean userIsSpeaker, long guildId, boolean guildIsPartnered, boolean guildIsVerified, long speakerCount, long audienceSize) {
        return new ActivityUtils2(stageInstanceId, channelId, userIsSpeaker, guildId, guildIsPartnered, guildIsVerified, speakerCount, audienceSize);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActivityUtils2)) {
            return false;
        }
        ActivityUtils2 activityUtils2 = (ActivityUtils2) other;
        return this.stageInstanceId == activityUtils2.stageInstanceId && this.channelId == activityUtils2.channelId && this.userIsSpeaker == activityUtils2.userIsSpeaker && this.guildId == activityUtils2.guildId && this.guildIsPartnered == activityUtils2.guildIsPartnered && this.guildIsVerified == activityUtils2.guildIsVerified && this.speakerCount == activityUtils2.speakerCount && this.audienceSize == activityUtils2.audienceSize;
    }

    public final long getAudienceSize() {
        return this.audienceSize;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final boolean getGuildIsPartnered() {
        return this.guildIsPartnered;
    }

    public final boolean getGuildIsVerified() {
        return this.guildIsVerified;
    }

    public final long getSpeakerCount() {
        return this.speakerCount;
    }

    public final long getStageInstanceId() {
        return this.stageInstanceId;
    }

    public final boolean getUserIsSpeaker() {
        return this.userIsSpeaker;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iA = (b.a(this.channelId) + (b.a(this.stageInstanceId) * 31)) * 31;
        boolean z2 = this.userIsSpeaker;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int iA2 = (b.a(this.guildId) + ((iA + i) * 31)) * 31;
        boolean z3 = this.guildIsPartnered;
        int i2 = z3;
        if (z3 != 0) {
            i2 = 1;
        }
        int i3 = (iA2 + i2) * 31;
        boolean z4 = this.guildIsVerified;
        return b.a(this.audienceSize) + ((b.a(this.speakerCount) + ((i3 + (z4 ? 1 : z4 ? 1 : 0)) * 31)) * 31);
    }

    public String toString() {
        StringBuilder sbU = outline.U("StageCallRichPresencePartyData(stageInstanceId=");
        sbU.append(this.stageInstanceId);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", userIsSpeaker=");
        sbU.append(this.userIsSpeaker);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", guildIsPartnered=");
        sbU.append(this.guildIsPartnered);
        sbU.append(", guildIsVerified=");
        sbU.append(this.guildIsVerified);
        sbU.append(", speakerCount=");
        sbU.append(this.speakerCount);
        sbU.append(", audienceSize=");
        return outline.C(sbU, this.audienceSize, ")");
    }
}
