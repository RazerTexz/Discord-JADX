package com.discord.api.voice.state;

import b.d.b.a.outline;
import com.discord.api.guildmember.GuildMember;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* compiled from: VoiceState.kt */
/* loaded from: classes.dex */
public final /* data */ class VoiceState {
    private final Long channelId;
    private final boolean deaf;
    private final long guildId;
    private final GuildMember member;
    private final boolean mute;
    private final UtcDateTime requestToSpeakTimestamp;
    private final boolean selfDeaf;
    private final boolean selfMute;
    private final boolean selfStream;
    private final boolean selfVideo;
    private final String sessionId;
    private final boolean suppress;
    private final long userId;

    /* renamed from: a, reason: from getter */
    public final Long getChannelId() {
        return this.channelId;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getDeaf() {
        return this.deaf;
    }

    /* renamed from: c, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* renamed from: d, reason: from getter */
    public final GuildMember getMember() {
        return this.member;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getMute() {
        return this.mute;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VoiceState)) {
            return false;
        }
        VoiceState voiceState = (VoiceState) other;
        return this.userId == voiceState.userId && this.suppress == voiceState.suppress && Intrinsics3.areEqual(this.sessionId, voiceState.sessionId) && this.selfMute == voiceState.selfMute && this.selfDeaf == voiceState.selfDeaf && this.selfVideo == voiceState.selfVideo && this.selfStream == voiceState.selfStream && this.mute == voiceState.mute && this.guildId == voiceState.guildId && this.deaf == voiceState.deaf && Intrinsics3.areEqual(this.member, voiceState.member) && Intrinsics3.areEqual(this.requestToSpeakTimestamp, voiceState.requestToSpeakTimestamp) && Intrinsics3.areEqual(this.channelId, voiceState.channelId);
    }

    /* renamed from: f, reason: from getter */
    public final UtcDateTime getRequestToSpeakTimestamp() {
        return this.requestToSpeakTimestamp;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getSelfDeaf() {
        return this.selfDeaf;
    }

    /* renamed from: h, reason: from getter */
    public final boolean getSelfMute() {
        return this.selfMute;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        long j = this.userId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        boolean z2 = this.suppress;
        int i2 = z2;
        if (z2 != 0) {
            i2 = 1;
        }
        int i3 = (i + i2) * 31;
        String str = this.sessionId;
        int iHashCode = (i3 + (str != null ? str.hashCode() : 0)) * 31;
        boolean z3 = this.selfMute;
        int i4 = z3;
        if (z3 != 0) {
            i4 = 1;
        }
        int i5 = (iHashCode + i4) * 31;
        boolean z4 = this.selfDeaf;
        int i6 = z4;
        if (z4 != 0) {
            i6 = 1;
        }
        int i7 = (i5 + i6) * 31;
        boolean z5 = this.selfVideo;
        int i8 = z5;
        if (z5 != 0) {
            i8 = 1;
        }
        int i9 = (i7 + i8) * 31;
        boolean z6 = this.selfStream;
        int i10 = z6;
        if (z6 != 0) {
            i10 = 1;
        }
        int i11 = (i9 + i10) * 31;
        boolean z7 = this.mute;
        int i12 = z7;
        if (z7 != 0) {
            i12 = 1;
        }
        long j2 = this.guildId;
        int i13 = (((i11 + i12) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        boolean z8 = this.deaf;
        int i14 = (i13 + (z8 ? 1 : z8 ? 1 : 0)) * 31;
        GuildMember guildMember = this.member;
        int iHashCode2 = (i14 + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
        UtcDateTime utcDateTime = this.requestToSpeakTimestamp;
        int iHashCode3 = (iHashCode2 + (utcDateTime != null ? utcDateTime.hashCode() : 0)) * 31;
        Long l = this.channelId;
        return iHashCode3 + (l != null ? l.hashCode() : 0);
    }

    /* renamed from: i, reason: from getter */
    public final boolean getSelfStream() {
        return this.selfStream;
    }

    /* renamed from: j, reason: from getter */
    public final boolean getSelfVideo() {
        return this.selfVideo;
    }

    /* renamed from: k, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: l, reason: from getter */
    public final boolean getSuppress() {
        return this.suppress;
    }

    /* renamed from: m, reason: from getter */
    public final long getUserId() {
        return this.userId;
    }

    public String toString() {
        StringBuilder sbU = outline.U("VoiceState(userId=");
        sbU.append(this.userId);
        sbU.append(", suppress=");
        sbU.append(this.suppress);
        sbU.append(", sessionId=");
        sbU.append(this.sessionId);
        sbU.append(", selfMute=");
        sbU.append(this.selfMute);
        sbU.append(", selfDeaf=");
        sbU.append(this.selfDeaf);
        sbU.append(", selfVideo=");
        sbU.append(this.selfVideo);
        sbU.append(", selfStream=");
        sbU.append(this.selfStream);
        sbU.append(", mute=");
        sbU.append(this.mute);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", deaf=");
        sbU.append(this.deaf);
        sbU.append(", member=");
        sbU.append(this.member);
        sbU.append(", requestToSpeakTimestamp=");
        sbU.append(this.requestToSpeakTimestamp);
        sbU.append(", channelId=");
        return outline.G(sbU, this.channelId, ")");
    }
}
