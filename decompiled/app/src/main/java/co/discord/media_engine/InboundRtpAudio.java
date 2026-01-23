package co.discord.media_engine;

import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: Statistics.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class InboundRtpAudio {
    private final boolean audioDetected;
    private final PlayoutMetric audioJitterBuffer;
    private final PlayoutMetric audioJitterDelay;
    private final PlayoutMetric audioJitterTarget;
    private final float audioLevel;
    private final PlayoutMetric audioPlayoutUnderruns;
    private final long bytesReceived;
    private final StatsCodec codec;
    private final int decodingCNG;
    private final int decodingMutedOutput;
    private final int decodingNormal;
    private final int decodingPLC;
    private final int decodingPLCCNG;
    private final long delayEstimate;
    private final long jitter;
    private final long jitterBuffer;
    private final long jitterBufferPreferred;
    private final Long opAccelerate;
    private final Long opCNG;
    private final Long opExpand;
    private final Long opMerge;
    private final Long opNormal;
    private final Long opPreemptiveExpand;
    private final Long opSilence;
    private final long packetsLost;
    private final long packetsReceived;
    private final PlayoutMetric relativePlayoutDelay;
    private final PlayoutMetric relativeReceptionDelay;
    private final long ssrc;
    private final String type;

    public InboundRtpAudio(String str, long j, StatsCodec statsCodec, long j2, long j3, long j4, float f, boolean z2, long j5, long j6, long j7, long j8, int i, int i2, int i3, int i4, int i5, Long l, Long l2, Long l3, Long l4, Long l5, Long l6, Long l7, PlayoutMetric playoutMetric, PlayoutMetric playoutMetric2, PlayoutMetric playoutMetric3, PlayoutMetric playoutMetric4, PlayoutMetric playoutMetric5, PlayoutMetric playoutMetric6) {
        Intrinsics3.checkNotNullParameter(str, "type");
        Intrinsics3.checkNotNullParameter(statsCodec, "codec");
        this.type = str;
        this.ssrc = j;
        this.codec = statsCodec;
        this.bytesReceived = j2;
        this.packetsReceived = j3;
        this.packetsLost = j4;
        this.audioLevel = f;
        this.audioDetected = z2;
        this.jitter = j5;
        this.jitterBuffer = j6;
        this.jitterBufferPreferred = j7;
        this.delayEstimate = j8;
        this.decodingCNG = i;
        this.decodingMutedOutput = i2;
        this.decodingNormal = i3;
        this.decodingPLC = i4;
        this.decodingPLCCNG = i5;
        this.opSilence = l;
        this.opNormal = l2;
        this.opMerge = l3;
        this.opExpand = l4;
        this.opAccelerate = l5;
        this.opPreemptiveExpand = l6;
        this.opCNG = l7;
        this.audioJitterBuffer = playoutMetric;
        this.audioJitterDelay = playoutMetric2;
        this.audioJitterTarget = playoutMetric3;
        this.audioPlayoutUnderruns = playoutMetric4;
        this.relativeReceptionDelay = playoutMetric5;
        this.relativePlayoutDelay = playoutMetric6;
    }

    public static /* synthetic */ InboundRtpAudio copy$default(InboundRtpAudio inboundRtpAudio, String str, long j, StatsCodec statsCodec, long j2, long j3, long j4, float f, boolean z2, long j5, long j6, long j7, long j8, int i, int i2, int i3, int i4, int i5, Long l, Long l2, Long l3, Long l4, Long l5, Long l6, Long l7, PlayoutMetric playoutMetric, PlayoutMetric playoutMetric2, PlayoutMetric playoutMetric3, PlayoutMetric playoutMetric4, PlayoutMetric playoutMetric5, PlayoutMetric playoutMetric6, int i6, Object obj) {
        return inboundRtpAudio.copy((i6 & 1) != 0 ? inboundRtpAudio.type : str, (i6 & 2) != 0 ? inboundRtpAudio.ssrc : j, (i6 & 4) != 0 ? inboundRtpAudio.codec : statsCodec, (i6 & 8) != 0 ? inboundRtpAudio.bytesReceived : j2, (i6 & 16) != 0 ? inboundRtpAudio.packetsReceived : j3, (i6 & 32) != 0 ? inboundRtpAudio.packetsLost : j4, (i6 & 64) != 0 ? inboundRtpAudio.audioLevel : f, (i6 & 128) != 0 ? inboundRtpAudio.audioDetected : z2, (i6 & 256) != 0 ? inboundRtpAudio.jitter : j5, (i6 & 512) != 0 ? inboundRtpAudio.jitterBuffer : j6, (i6 & 1024) != 0 ? inboundRtpAudio.jitterBufferPreferred : j7, (i6 & 2048) != 0 ? inboundRtpAudio.delayEstimate : j8, (i6 & 4096) != 0 ? inboundRtpAudio.decodingCNG : i, (i6 & 8192) != 0 ? inboundRtpAudio.decodingMutedOutput : i2, (i6 & 16384) != 0 ? inboundRtpAudio.decodingNormal : i3, (i6 & 32768) != 0 ? inboundRtpAudio.decodingPLC : i4, (i6 & 65536) != 0 ? inboundRtpAudio.decodingPLCCNG : i5, (i6 & 131072) != 0 ? inboundRtpAudio.opSilence : l, (i6 & 262144) != 0 ? inboundRtpAudio.opNormal : l2, (i6 & 524288) != 0 ? inboundRtpAudio.opMerge : l3, (i6 & 1048576) != 0 ? inboundRtpAudio.opExpand : l4, (i6 & 2097152) != 0 ? inboundRtpAudio.opAccelerate : l5, (i6 & 4194304) != 0 ? inboundRtpAudio.opPreemptiveExpand : l6, (i6 & 8388608) != 0 ? inboundRtpAudio.opCNG : l7, (i6 & 16777216) != 0 ? inboundRtpAudio.audioJitterBuffer : playoutMetric, (i6 & 33554432) != 0 ? inboundRtpAudio.audioJitterDelay : playoutMetric2, (i6 & 67108864) != 0 ? inboundRtpAudio.audioJitterTarget : playoutMetric3, (i6 & 134217728) != 0 ? inboundRtpAudio.audioPlayoutUnderruns : playoutMetric4, (i6 & 268435456) != 0 ? inboundRtpAudio.relativeReceptionDelay : playoutMetric5, (i6 & 536870912) != 0 ? inboundRtpAudio.relativePlayoutDelay : playoutMetric6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final long getJitterBuffer() {
        return this.jitterBuffer;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final long getJitterBufferPreferred() {
        return this.jitterBufferPreferred;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final long getDelayEstimate() {
        return this.delayEstimate;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final int getDecodingCNG() {
        return this.decodingCNG;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final int getDecodingMutedOutput() {
        return this.decodingMutedOutput;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final int getDecodingNormal() {
        return this.decodingNormal;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final int getDecodingPLC() {
        return this.decodingPLC;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final int getDecodingPLCCNG() {
        return this.decodingPLCCNG;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final Long getOpSilence() {
        return this.opSilence;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final Long getOpNormal() {
        return this.opNormal;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getSsrc() {
        return this.ssrc;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final Long getOpMerge() {
        return this.opMerge;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final Long getOpExpand() {
        return this.opExpand;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final Long getOpAccelerate() {
        return this.opAccelerate;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final Long getOpPreemptiveExpand() {
        return this.opPreemptiveExpand;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final Long getOpCNG() {
        return this.opCNG;
    }

    /* JADX INFO: renamed from: component25, reason: from getter */
    public final PlayoutMetric getAudioJitterBuffer() {
        return this.audioJitterBuffer;
    }

    /* JADX INFO: renamed from: component26, reason: from getter */
    public final PlayoutMetric getAudioJitterDelay() {
        return this.audioJitterDelay;
    }

    /* JADX INFO: renamed from: component27, reason: from getter */
    public final PlayoutMetric getAudioJitterTarget() {
        return this.audioJitterTarget;
    }

    /* JADX INFO: renamed from: component28, reason: from getter */
    public final PlayoutMetric getAudioPlayoutUnderruns() {
        return this.audioPlayoutUnderruns;
    }

    /* JADX INFO: renamed from: component29, reason: from getter */
    public final PlayoutMetric getRelativeReceptionDelay() {
        return this.relativeReceptionDelay;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final StatsCodec getCodec() {
        return this.codec;
    }

    /* JADX INFO: renamed from: component30, reason: from getter */
    public final PlayoutMetric getRelativePlayoutDelay() {
        return this.relativePlayoutDelay;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getBytesReceived() {
        return this.bytesReceived;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getPacketsReceived() {
        return this.packetsReceived;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final long getPacketsLost() {
        return this.packetsLost;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final float getAudioLevel() {
        return this.audioLevel;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getAudioDetected() {
        return this.audioDetected;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final long getJitter() {
        return this.jitter;
    }

    public final InboundRtpAudio copy(String type, long ssrc, StatsCodec codec, long bytesReceived, long packetsReceived, long packetsLost, float audioLevel, boolean audioDetected, long jitter, long jitterBuffer, long jitterBufferPreferred, long delayEstimate, int decodingCNG, int decodingMutedOutput, int decodingNormal, int decodingPLC, int decodingPLCCNG, Long opSilence, Long opNormal, Long opMerge, Long opExpand, Long opAccelerate, Long opPreemptiveExpand, Long opCNG, PlayoutMetric audioJitterBuffer, PlayoutMetric audioJitterDelay, PlayoutMetric audioJitterTarget, PlayoutMetric audioPlayoutUnderruns, PlayoutMetric relativeReceptionDelay, PlayoutMetric relativePlayoutDelay) {
        Intrinsics3.checkNotNullParameter(type, "type");
        Intrinsics3.checkNotNullParameter(codec, "codec");
        return new InboundRtpAudio(type, ssrc, codec, bytesReceived, packetsReceived, packetsLost, audioLevel, audioDetected, jitter, jitterBuffer, jitterBufferPreferred, delayEstimate, decodingCNG, decodingMutedOutput, decodingNormal, decodingPLC, decodingPLCCNG, opSilence, opNormal, opMerge, opExpand, opAccelerate, opPreemptiveExpand, opCNG, audioJitterBuffer, audioJitterDelay, audioJitterTarget, audioPlayoutUnderruns, relativeReceptionDelay, relativePlayoutDelay);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InboundRtpAudio)) {
            return false;
        }
        InboundRtpAudio inboundRtpAudio = (InboundRtpAudio) other;
        return Intrinsics3.areEqual(this.type, inboundRtpAudio.type) && this.ssrc == inboundRtpAudio.ssrc && Intrinsics3.areEqual(this.codec, inboundRtpAudio.codec) && this.bytesReceived == inboundRtpAudio.bytesReceived && this.packetsReceived == inboundRtpAudio.packetsReceived && this.packetsLost == inboundRtpAudio.packetsLost && Float.compare(this.audioLevel, inboundRtpAudio.audioLevel) == 0 && this.audioDetected == inboundRtpAudio.audioDetected && this.jitter == inboundRtpAudio.jitter && this.jitterBuffer == inboundRtpAudio.jitterBuffer && this.jitterBufferPreferred == inboundRtpAudio.jitterBufferPreferred && this.delayEstimate == inboundRtpAudio.delayEstimate && this.decodingCNG == inboundRtpAudio.decodingCNG && this.decodingMutedOutput == inboundRtpAudio.decodingMutedOutput && this.decodingNormal == inboundRtpAudio.decodingNormal && this.decodingPLC == inboundRtpAudio.decodingPLC && this.decodingPLCCNG == inboundRtpAudio.decodingPLCCNG && Intrinsics3.areEqual(this.opSilence, inboundRtpAudio.opSilence) && Intrinsics3.areEqual(this.opNormal, inboundRtpAudio.opNormal) && Intrinsics3.areEqual(this.opMerge, inboundRtpAudio.opMerge) && Intrinsics3.areEqual(this.opExpand, inboundRtpAudio.opExpand) && Intrinsics3.areEqual(this.opAccelerate, inboundRtpAudio.opAccelerate) && Intrinsics3.areEqual(this.opPreemptiveExpand, inboundRtpAudio.opPreemptiveExpand) && Intrinsics3.areEqual(this.opCNG, inboundRtpAudio.opCNG) && Intrinsics3.areEqual(this.audioJitterBuffer, inboundRtpAudio.audioJitterBuffer) && Intrinsics3.areEqual(this.audioJitterDelay, inboundRtpAudio.audioJitterDelay) && Intrinsics3.areEqual(this.audioJitterTarget, inboundRtpAudio.audioJitterTarget) && Intrinsics3.areEqual(this.audioPlayoutUnderruns, inboundRtpAudio.audioPlayoutUnderruns) && Intrinsics3.areEqual(this.relativeReceptionDelay, inboundRtpAudio.relativeReceptionDelay) && Intrinsics3.areEqual(this.relativePlayoutDelay, inboundRtpAudio.relativePlayoutDelay);
    }

    public final boolean getAudioDetected() {
        return this.audioDetected;
    }

    public final PlayoutMetric getAudioJitterBuffer() {
        return this.audioJitterBuffer;
    }

    public final PlayoutMetric getAudioJitterDelay() {
        return this.audioJitterDelay;
    }

    public final PlayoutMetric getAudioJitterTarget() {
        return this.audioJitterTarget;
    }

    public final float getAudioLevel() {
        return this.audioLevel;
    }

    public final PlayoutMetric getAudioPlayoutUnderruns() {
        return this.audioPlayoutUnderruns;
    }

    public final long getBytesReceived() {
        return this.bytesReceived;
    }

    public final StatsCodec getCodec() {
        return this.codec;
    }

    public final int getDecodingCNG() {
        return this.decodingCNG;
    }

    public final int getDecodingMutedOutput() {
        return this.decodingMutedOutput;
    }

    public final int getDecodingNormal() {
        return this.decodingNormal;
    }

    public final int getDecodingPLC() {
        return this.decodingPLC;
    }

    public final int getDecodingPLCCNG() {
        return this.decodingPLCCNG;
    }

    public final long getDelayEstimate() {
        return this.delayEstimate;
    }

    public final long getJitter() {
        return this.jitter;
    }

    public final long getJitterBuffer() {
        return this.jitterBuffer;
    }

    public final long getJitterBufferPreferred() {
        return this.jitterBufferPreferred;
    }

    public final Long getOpAccelerate() {
        return this.opAccelerate;
    }

    public final Long getOpCNG() {
        return this.opCNG;
    }

    public final Long getOpExpand() {
        return this.opExpand;
    }

    public final Long getOpMerge() {
        return this.opMerge;
    }

    public final Long getOpNormal() {
        return this.opNormal;
    }

    public final Long getOpPreemptiveExpand() {
        return this.opPreemptiveExpand;
    }

    public final Long getOpSilence() {
        return this.opSilence;
    }

    public final long getPacketsLost() {
        return this.packetsLost;
    }

    public final long getPacketsReceived() {
        return this.packetsReceived;
    }

    public final PlayoutMetric getRelativePlayoutDelay() {
        return this.relativePlayoutDelay;
    }

    public final PlayoutMetric getRelativeReceptionDelay() {
        return this.relativeReceptionDelay;
    }

    public final long getSsrc() {
        return this.ssrc;
    }

    public final String getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r0v75 */
    /* JADX WARN: Type inference failed for: r0v78 */
    public int hashCode() {
        String str = this.type;
        int iM3a = (C0002b.m3a(this.ssrc) + ((str != null ? str.hashCode() : 0) * 31)) * 31;
        StatsCodec statsCodec = this.codec;
        int iFloatToIntBits = (Float.floatToIntBits(this.audioLevel) + ((C0002b.m3a(this.packetsLost) + ((C0002b.m3a(this.packetsReceived) + ((C0002b.m3a(this.bytesReceived) + ((iM3a + (statsCodec != null ? statsCodec.hashCode() : 0)) * 31)) * 31)) * 31)) * 31)) * 31;
        boolean z2 = this.audioDetected;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int iM3a2 = (((((((((((C0002b.m3a(this.delayEstimate) + ((C0002b.m3a(this.jitterBufferPreferred) + ((C0002b.m3a(this.jitterBuffer) + ((C0002b.m3a(this.jitter) + ((iFloatToIntBits + r0) * 31)) * 31)) * 31)) * 31)) * 31) + this.decodingCNG) * 31) + this.decodingMutedOutput) * 31) + this.decodingNormal) * 31) + this.decodingPLC) * 31) + this.decodingPLCCNG) * 31;
        Long l = this.opSilence;
        int iHashCode = (iM3a2 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.opNormal;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.opMerge;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.opExpand;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.opAccelerate;
        int iHashCode5 = (iHashCode4 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.opPreemptiveExpand;
        int iHashCode6 = (iHashCode5 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.opCNG;
        int iHashCode7 = (iHashCode6 + (l7 != null ? l7.hashCode() : 0)) * 31;
        PlayoutMetric playoutMetric = this.audioJitterBuffer;
        int iHashCode8 = (iHashCode7 + (playoutMetric != null ? playoutMetric.hashCode() : 0)) * 31;
        PlayoutMetric playoutMetric2 = this.audioJitterDelay;
        int iHashCode9 = (iHashCode8 + (playoutMetric2 != null ? playoutMetric2.hashCode() : 0)) * 31;
        PlayoutMetric playoutMetric3 = this.audioJitterTarget;
        int iHashCode10 = (iHashCode9 + (playoutMetric3 != null ? playoutMetric3.hashCode() : 0)) * 31;
        PlayoutMetric playoutMetric4 = this.audioPlayoutUnderruns;
        int iHashCode11 = (iHashCode10 + (playoutMetric4 != null ? playoutMetric4.hashCode() : 0)) * 31;
        PlayoutMetric playoutMetric5 = this.relativeReceptionDelay;
        int iHashCode12 = (iHashCode11 + (playoutMetric5 != null ? playoutMetric5.hashCode() : 0)) * 31;
        PlayoutMetric playoutMetric6 = this.relativePlayoutDelay;
        return iHashCode12 + (playoutMetric6 != null ? playoutMetric6.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("InboundRtpAudio(type=");
        sbM833U.append(this.type);
        sbM833U.append(", ssrc=");
        sbM833U.append(this.ssrc);
        sbM833U.append(", codec=");
        sbM833U.append(this.codec);
        sbM833U.append(", bytesReceived=");
        sbM833U.append(this.bytesReceived);
        sbM833U.append(", packetsReceived=");
        sbM833U.append(this.packetsReceived);
        sbM833U.append(", packetsLost=");
        sbM833U.append(this.packetsLost);
        sbM833U.append(", audioLevel=");
        sbM833U.append(this.audioLevel);
        sbM833U.append(", audioDetected=");
        sbM833U.append(this.audioDetected);
        sbM833U.append(", jitter=");
        sbM833U.append(this.jitter);
        sbM833U.append(", jitterBuffer=");
        sbM833U.append(this.jitterBuffer);
        sbM833U.append(", jitterBufferPreferred=");
        sbM833U.append(this.jitterBufferPreferred);
        sbM833U.append(", delayEstimate=");
        sbM833U.append(this.delayEstimate);
        sbM833U.append(", decodingCNG=");
        sbM833U.append(this.decodingCNG);
        sbM833U.append(", decodingMutedOutput=");
        sbM833U.append(this.decodingMutedOutput);
        sbM833U.append(", decodingNormal=");
        sbM833U.append(this.decodingNormal);
        sbM833U.append(", decodingPLC=");
        sbM833U.append(this.decodingPLC);
        sbM833U.append(", decodingPLCCNG=");
        sbM833U.append(this.decodingPLCCNG);
        sbM833U.append(", opSilence=");
        sbM833U.append(this.opSilence);
        sbM833U.append(", opNormal=");
        sbM833U.append(this.opNormal);
        sbM833U.append(", opMerge=");
        sbM833U.append(this.opMerge);
        sbM833U.append(", opExpand=");
        sbM833U.append(this.opExpand);
        sbM833U.append(", opAccelerate=");
        sbM833U.append(this.opAccelerate);
        sbM833U.append(", opPreemptiveExpand=");
        sbM833U.append(this.opPreemptiveExpand);
        sbM833U.append(", opCNG=");
        sbM833U.append(this.opCNG);
        sbM833U.append(", audioJitterBuffer=");
        sbM833U.append(this.audioJitterBuffer);
        sbM833U.append(", audioJitterDelay=");
        sbM833U.append(this.audioJitterDelay);
        sbM833U.append(", audioJitterTarget=");
        sbM833U.append(this.audioJitterTarget);
        sbM833U.append(", audioPlayoutUnderruns=");
        sbM833U.append(this.audioPlayoutUnderruns);
        sbM833U.append(", relativeReceptionDelay=");
        sbM833U.append(this.relativeReceptionDelay);
        sbM833U.append(", relativePlayoutDelay=");
        sbM833U.append(this.relativePlayoutDelay);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
