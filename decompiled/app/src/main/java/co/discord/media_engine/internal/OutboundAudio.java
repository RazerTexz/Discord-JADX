package co.discord.media_engine.internal;

import a0.a.a.a;
import a0.a.a.b;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* compiled from: NativeStatistics.kt */
/* loaded from: classes.dex */
public final /* data */ class OutboundAudio {
    private final int audioLevel;
    private final long bytesSent;
    private final String codecName;
    private final int codecPayloadType;
    private final int delayMedian;
    private final int delayStd;
    private final double echoReturnLoss;
    private final double echoReturnLossEnchancement;
    private final float fractionLost;
    private final long framesCaptured;
    private final long framesRendered;
    private final int jitter;
    private final Boolean noiseCancellerIsEnabled;
    private final Long noiseCancellerProcessTime;
    private final int packetsLost;
    private final long packetsSent;
    private final double residualEchoLikelihood;
    private final double residualEchoLikelihoodRecentMax;
    private final long rtt;
    private final long speaking;
    private final long ssrc;
    private final boolean typingNoiseDetected;
    private final Boolean voiceActivityDetectorIsEnabled;
    private final Long voiceActivityDetectorProcessTime;

    public OutboundAudio(int i, long j, String str, int i2, int i3, int i4, double d, double d2, float f, int i5, int i6, long j2, double d3, double d4, long j3, long j4, long j5, boolean z2, long j6, long j7, Boolean bool, Long l, Boolean bool2, Long l2) {
        Intrinsics3.checkNotNullParameter(str, "codecName");
        this.audioLevel = i;
        this.bytesSent = j;
        this.codecName = str;
        this.codecPayloadType = i2;
        this.delayMedian = i3;
        this.delayStd = i4;
        this.echoReturnLoss = d;
        this.echoReturnLossEnchancement = d2;
        this.fractionLost = f;
        this.jitter = i5;
        this.packetsLost = i6;
        this.packetsSent = j2;
        this.residualEchoLikelihood = d3;
        this.residualEchoLikelihoodRecentMax = d4;
        this.rtt = j3;
        this.speaking = j4;
        this.ssrc = j5;
        this.typingNoiseDetected = z2;
        this.framesCaptured = j6;
        this.framesRendered = j7;
        this.noiseCancellerIsEnabled = bool;
        this.noiseCancellerProcessTime = l;
        this.voiceActivityDetectorIsEnabled = bool2;
        this.voiceActivityDetectorProcessTime = l2;
    }

    public static /* synthetic */ OutboundAudio copy$default(OutboundAudio outboundAudio, int i, long j, String str, int i2, int i3, int i4, double d, double d2, float f, int i5, int i6, long j2, double d3, double d4, long j3, long j4, long j5, boolean z2, long j6, long j7, Boolean bool, Long l, Boolean bool2, Long l2, int i7, Object obj) {
        return outboundAudio.copy((i7 & 1) != 0 ? outboundAudio.audioLevel : i, (i7 & 2) != 0 ? outboundAudio.bytesSent : j, (i7 & 4) != 0 ? outboundAudio.codecName : str, (i7 & 8) != 0 ? outboundAudio.codecPayloadType : i2, (i7 & 16) != 0 ? outboundAudio.delayMedian : i3, (i7 & 32) != 0 ? outboundAudio.delayStd : i4, (i7 & 64) != 0 ? outboundAudio.echoReturnLoss : d, (i7 & 128) != 0 ? outboundAudio.echoReturnLossEnchancement : d2, (i7 & 256) != 0 ? outboundAudio.fractionLost : f, (i7 & 512) != 0 ? outboundAudio.jitter : i5, (i7 & 1024) != 0 ? outboundAudio.packetsLost : i6, (i7 & 2048) != 0 ? outboundAudio.packetsSent : j2, (i7 & 4096) != 0 ? outboundAudio.residualEchoLikelihood : d3, (i7 & 8192) != 0 ? outboundAudio.residualEchoLikelihoodRecentMax : d4, (i7 & 16384) != 0 ? outboundAudio.rtt : j3, (i7 & 32768) != 0 ? outboundAudio.speaking : j4, (i7 & 65536) != 0 ? outboundAudio.ssrc : j5, (i7 & 131072) != 0 ? outboundAudio.typingNoiseDetected : z2, (262144 & i7) != 0 ? outboundAudio.framesCaptured : j6, (i7 & 524288) != 0 ? outboundAudio.framesRendered : j7, (i7 & 1048576) != 0 ? outboundAudio.noiseCancellerIsEnabled : bool, (2097152 & i7) != 0 ? outboundAudio.noiseCancellerProcessTime : l, (i7 & 4194304) != 0 ? outboundAudio.voiceActivityDetectorIsEnabled : bool2, (i7 & 8388608) != 0 ? outboundAudio.voiceActivityDetectorProcessTime : l2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getAudioLevel() {
        return this.audioLevel;
    }

    /* renamed from: component10, reason: from getter */
    public final int getJitter() {
        return this.jitter;
    }

    /* renamed from: component11, reason: from getter */
    public final int getPacketsLost() {
        return this.packetsLost;
    }

    /* renamed from: component12, reason: from getter */
    public final long getPacketsSent() {
        return this.packetsSent;
    }

    /* renamed from: component13, reason: from getter */
    public final double getResidualEchoLikelihood() {
        return this.residualEchoLikelihood;
    }

    /* renamed from: component14, reason: from getter */
    public final double getResidualEchoLikelihoodRecentMax() {
        return this.residualEchoLikelihoodRecentMax;
    }

    /* renamed from: component15, reason: from getter */
    public final long getRtt() {
        return this.rtt;
    }

    /* renamed from: component16, reason: from getter */
    public final long getSpeaking() {
        return this.speaking;
    }

    /* renamed from: component17, reason: from getter */
    public final long getSsrc() {
        return this.ssrc;
    }

    /* renamed from: component18, reason: from getter */
    public final boolean getTypingNoiseDetected() {
        return this.typingNoiseDetected;
    }

    /* renamed from: component19, reason: from getter */
    public final long getFramesCaptured() {
        return this.framesCaptured;
    }

    /* renamed from: component2, reason: from getter */
    public final long getBytesSent() {
        return this.bytesSent;
    }

    /* renamed from: component20, reason: from getter */
    public final long getFramesRendered() {
        return this.framesRendered;
    }

    /* renamed from: component21, reason: from getter */
    public final Boolean getNoiseCancellerIsEnabled() {
        return this.noiseCancellerIsEnabled;
    }

    /* renamed from: component22, reason: from getter */
    public final Long getNoiseCancellerProcessTime() {
        return this.noiseCancellerProcessTime;
    }

    /* renamed from: component23, reason: from getter */
    public final Boolean getVoiceActivityDetectorIsEnabled() {
        return this.voiceActivityDetectorIsEnabled;
    }

    /* renamed from: component24, reason: from getter */
    public final Long getVoiceActivityDetectorProcessTime() {
        return this.voiceActivityDetectorProcessTime;
    }

    /* renamed from: component3, reason: from getter */
    public final String getCodecName() {
        return this.codecName;
    }

    /* renamed from: component4, reason: from getter */
    public final int getCodecPayloadType() {
        return this.codecPayloadType;
    }

    /* renamed from: component5, reason: from getter */
    public final int getDelayMedian() {
        return this.delayMedian;
    }

    /* renamed from: component6, reason: from getter */
    public final int getDelayStd() {
        return this.delayStd;
    }

    /* renamed from: component7, reason: from getter */
    public final double getEchoReturnLoss() {
        return this.echoReturnLoss;
    }

    /* renamed from: component8, reason: from getter */
    public final double getEchoReturnLossEnchancement() {
        return this.echoReturnLossEnchancement;
    }

    /* renamed from: component9, reason: from getter */
    public final float getFractionLost() {
        return this.fractionLost;
    }

    public final OutboundAudio copy(int audioLevel, long bytesSent, String codecName, int codecPayloadType, int delayMedian, int delayStd, double echoReturnLoss, double echoReturnLossEnchancement, float fractionLost, int jitter, int packetsLost, long packetsSent, double residualEchoLikelihood, double residualEchoLikelihoodRecentMax, long rtt, long speaking, long ssrc, boolean typingNoiseDetected, long framesCaptured, long framesRendered, Boolean noiseCancellerIsEnabled, Long noiseCancellerProcessTime, Boolean voiceActivityDetectorIsEnabled, Long voiceActivityDetectorProcessTime) {
        Intrinsics3.checkNotNullParameter(codecName, "codecName");
        return new OutboundAudio(audioLevel, bytesSent, codecName, codecPayloadType, delayMedian, delayStd, echoReturnLoss, echoReturnLossEnchancement, fractionLost, jitter, packetsLost, packetsSent, residualEchoLikelihood, residualEchoLikelihoodRecentMax, rtt, speaking, ssrc, typingNoiseDetected, framesCaptured, framesRendered, noiseCancellerIsEnabled, noiseCancellerProcessTime, voiceActivityDetectorIsEnabled, voiceActivityDetectorProcessTime);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OutboundAudio)) {
            return false;
        }
        OutboundAudio outboundAudio = (OutboundAudio) other;
        return this.audioLevel == outboundAudio.audioLevel && this.bytesSent == outboundAudio.bytesSent && Intrinsics3.areEqual(this.codecName, outboundAudio.codecName) && this.codecPayloadType == outboundAudio.codecPayloadType && this.delayMedian == outboundAudio.delayMedian && this.delayStd == outboundAudio.delayStd && Double.compare(this.echoReturnLoss, outboundAudio.echoReturnLoss) == 0 && Double.compare(this.echoReturnLossEnchancement, outboundAudio.echoReturnLossEnchancement) == 0 && Float.compare(this.fractionLost, outboundAudio.fractionLost) == 0 && this.jitter == outboundAudio.jitter && this.packetsLost == outboundAudio.packetsLost && this.packetsSent == outboundAudio.packetsSent && Double.compare(this.residualEchoLikelihood, outboundAudio.residualEchoLikelihood) == 0 && Double.compare(this.residualEchoLikelihoodRecentMax, outboundAudio.residualEchoLikelihoodRecentMax) == 0 && this.rtt == outboundAudio.rtt && this.speaking == outboundAudio.speaking && this.ssrc == outboundAudio.ssrc && this.typingNoiseDetected == outboundAudio.typingNoiseDetected && this.framesCaptured == outboundAudio.framesCaptured && this.framesRendered == outboundAudio.framesRendered && Intrinsics3.areEqual(this.noiseCancellerIsEnabled, outboundAudio.noiseCancellerIsEnabled) && Intrinsics3.areEqual(this.noiseCancellerProcessTime, outboundAudio.noiseCancellerProcessTime) && Intrinsics3.areEqual(this.voiceActivityDetectorIsEnabled, outboundAudio.voiceActivityDetectorIsEnabled) && Intrinsics3.areEqual(this.voiceActivityDetectorProcessTime, outboundAudio.voiceActivityDetectorProcessTime);
    }

    public final int getAudioLevel() {
        return this.audioLevel;
    }

    public final long getBytesSent() {
        return this.bytesSent;
    }

    public final String getCodecName() {
        return this.codecName;
    }

    public final int getCodecPayloadType() {
        return this.codecPayloadType;
    }

    public final int getDelayMedian() {
        return this.delayMedian;
    }

    public final int getDelayStd() {
        return this.delayStd;
    }

    public final double getEchoReturnLoss() {
        return this.echoReturnLoss;
    }

    public final double getEchoReturnLossEnchancement() {
        return this.echoReturnLossEnchancement;
    }

    public final float getFractionLost() {
        return this.fractionLost;
    }

    public final long getFramesCaptured() {
        return this.framesCaptured;
    }

    public final long getFramesRendered() {
        return this.framesRendered;
    }

    public final int getJitter() {
        return this.jitter;
    }

    public final Boolean getNoiseCancellerIsEnabled() {
        return this.noiseCancellerIsEnabled;
    }

    public final Long getNoiseCancellerProcessTime() {
        return this.noiseCancellerProcessTime;
    }

    public final int getPacketsLost() {
        return this.packetsLost;
    }

    public final long getPacketsSent() {
        return this.packetsSent;
    }

    public final double getResidualEchoLikelihood() {
        return this.residualEchoLikelihood;
    }

    public final double getResidualEchoLikelihoodRecentMax() {
        return this.residualEchoLikelihoodRecentMax;
    }

    public final long getRtt() {
        return this.rtt;
    }

    public final long getSpeaking() {
        return this.speaking;
    }

    public final long getSsrc() {
        return this.ssrc;
    }

    public final boolean getTypingNoiseDetected() {
        return this.typingNoiseDetected;
    }

    public final Boolean getVoiceActivityDetectorIsEnabled() {
        return this.voiceActivityDetectorIsEnabled;
    }

    public final Long getVoiceActivityDetectorProcessTime() {
        return this.voiceActivityDetectorProcessTime;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iA = (b.a(this.bytesSent) + (this.audioLevel * 31)) * 31;
        String str = this.codecName;
        int iA2 = (b.a(this.ssrc) + ((b.a(this.speaking) + ((b.a(this.rtt) + ((a.a(this.residualEchoLikelihoodRecentMax) + ((a.a(this.residualEchoLikelihood) + ((b.a(this.packetsSent) + ((((((Float.floatToIntBits(this.fractionLost) + ((a.a(this.echoReturnLossEnchancement) + ((a.a(this.echoReturnLoss) + ((((((((iA + (str != null ? str.hashCode() : 0)) * 31) + this.codecPayloadType) * 31) + this.delayMedian) * 31) + this.delayStd) * 31)) * 31)) * 31)) * 31) + this.jitter) * 31) + this.packetsLost) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        boolean z2 = this.typingNoiseDetected;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int iA3 = (b.a(this.framesRendered) + ((b.a(this.framesCaptured) + ((iA2 + i) * 31)) * 31)) * 31;
        Boolean bool = this.noiseCancellerIsEnabled;
        int iHashCode = (iA3 + (bool != null ? bool.hashCode() : 0)) * 31;
        Long l = this.noiseCancellerProcessTime;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Boolean bool2 = this.voiceActivityDetectorIsEnabled;
        int iHashCode3 = (iHashCode2 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Long l2 = this.voiceActivityDetectorProcessTime;
        return iHashCode3 + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("OutboundAudio(audioLevel=");
        sbU.append(this.audioLevel);
        sbU.append(", bytesSent=");
        sbU.append(this.bytesSent);
        sbU.append(", codecName=");
        sbU.append(this.codecName);
        sbU.append(", codecPayloadType=");
        sbU.append(this.codecPayloadType);
        sbU.append(", delayMedian=");
        sbU.append(this.delayMedian);
        sbU.append(", delayStd=");
        sbU.append(this.delayStd);
        sbU.append(", echoReturnLoss=");
        sbU.append(this.echoReturnLoss);
        sbU.append(", echoReturnLossEnchancement=");
        sbU.append(this.echoReturnLossEnchancement);
        sbU.append(", fractionLost=");
        sbU.append(this.fractionLost);
        sbU.append(", jitter=");
        sbU.append(this.jitter);
        sbU.append(", packetsLost=");
        sbU.append(this.packetsLost);
        sbU.append(", packetsSent=");
        sbU.append(this.packetsSent);
        sbU.append(", residualEchoLikelihood=");
        sbU.append(this.residualEchoLikelihood);
        sbU.append(", residualEchoLikelihoodRecentMax=");
        sbU.append(this.residualEchoLikelihoodRecentMax);
        sbU.append(", rtt=");
        sbU.append(this.rtt);
        sbU.append(", speaking=");
        sbU.append(this.speaking);
        sbU.append(", ssrc=");
        sbU.append(this.ssrc);
        sbU.append(", typingNoiseDetected=");
        sbU.append(this.typingNoiseDetected);
        sbU.append(", framesCaptured=");
        sbU.append(this.framesCaptured);
        sbU.append(", framesRendered=");
        sbU.append(this.framesRendered);
        sbU.append(", noiseCancellerIsEnabled=");
        sbU.append(this.noiseCancellerIsEnabled);
        sbU.append(", noiseCancellerProcessTime=");
        sbU.append(this.noiseCancellerProcessTime);
        sbU.append(", voiceActivityDetectorIsEnabled=");
        sbU.append(this.voiceActivityDetectorIsEnabled);
        sbU.append(", voiceActivityDetectorProcessTime=");
        return outline.G(sbU, this.voiceActivityDetectorProcessTime, ")");
    }
}
