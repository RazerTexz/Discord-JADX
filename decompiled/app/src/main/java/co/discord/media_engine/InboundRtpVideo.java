package co.discord.media_engine;

import com.discord.models.domain.ModelAuditLogEntry;
import p001a0.p002a.p003a.C0001a;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: Statistics.kt */
/* loaded from: classes.dex */
public final /* data */ class InboundRtpVideo {
    private final int averageDecodeTime;
    private final int bitrate;
    private final long bytesReceived;
    private final StatsCodec codec;
    private final String decoderImplementationName;
    private final long firCount;
    private final int frameRateDecode;
    private final int frameRateNetwork;
    private final int frameRateRender;
    private final int framesDecoded;
    private final int framesDropped;
    private final int framesReceived;
    private final long freezeCount;
    private final long nackCount;
    private final int packetsLost;
    private final int packetsReceived;
    private final long pauseCount;
    private final long pliCount;
    private final long qpSum;
    private final Resolution resolution;
    private final long ssrc;
    private final double sumOfSquaredFramesDurations;
    private final long totalFramesDuration;
    private final long totalFreezesDuration;
    private final long totalPausesDuration;
    private final String type;

    public InboundRtpVideo(String str, long j, StatsCodec statsCodec, long j2, int i, int i2, int i3, int i4, Resolution resolution, String str2, int i5, int i6, int i7, int i8, int i9, int i10, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, double d) {
        Intrinsics3.checkNotNullParameter(str, "type");
        Intrinsics3.checkNotNullParameter(resolution, "resolution");
        Intrinsics3.checkNotNullParameter(str2, "decoderImplementationName");
        this.type = str;
        this.ssrc = j;
        this.codec = statsCodec;
        this.bytesReceived = j2;
        this.packetsReceived = i;
        this.packetsLost = i2;
        this.bitrate = i3;
        this.averageDecodeTime = i4;
        this.resolution = resolution;
        this.decoderImplementationName = str2;
        this.framesDecoded = i5;
        this.framesDropped = i6;
        this.framesReceived = i7;
        this.frameRateDecode = i8;
        this.frameRateNetwork = i9;
        this.frameRateRender = i10;
        this.firCount = j3;
        this.nackCount = j4;
        this.pliCount = j5;
        this.qpSum = j6;
        this.freezeCount = j7;
        this.pauseCount = j8;
        this.totalFreezesDuration = j9;
        this.totalPausesDuration = j10;
        this.totalFramesDuration = j11;
        this.sumOfSquaredFramesDurations = d;
    }

    public static /* synthetic */ InboundRtpVideo copy$default(InboundRtpVideo inboundRtpVideo, String str, long j, StatsCodec statsCodec, long j2, int i, int i2, int i3, int i4, Resolution resolution, String str2, int i5, int i6, int i7, int i8, int i9, int i10, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, double d, int i11, Object obj) {
        return inboundRtpVideo.copy((i11 & 1) != 0 ? inboundRtpVideo.type : str, (i11 & 2) != 0 ? inboundRtpVideo.ssrc : j, (i11 & 4) != 0 ? inboundRtpVideo.codec : statsCodec, (i11 & 8) != 0 ? inboundRtpVideo.bytesReceived : j2, (i11 & 16) != 0 ? inboundRtpVideo.packetsReceived : i, (i11 & 32) != 0 ? inboundRtpVideo.packetsLost : i2, (i11 & 64) != 0 ? inboundRtpVideo.bitrate : i3, (i11 & 128) != 0 ? inboundRtpVideo.averageDecodeTime : i4, (i11 & 256) != 0 ? inboundRtpVideo.resolution : resolution, (i11 & 512) != 0 ? inboundRtpVideo.decoderImplementationName : str2, (i11 & 1024) != 0 ? inboundRtpVideo.framesDecoded : i5, (i11 & 2048) != 0 ? inboundRtpVideo.framesDropped : i6, (i11 & 4096) != 0 ? inboundRtpVideo.framesReceived : i7, (i11 & 8192) != 0 ? inboundRtpVideo.frameRateDecode : i8, (i11 & 16384) != 0 ? inboundRtpVideo.frameRateNetwork : i9, (i11 & 32768) != 0 ? inboundRtpVideo.frameRateRender : i10, (i11 & 65536) != 0 ? inboundRtpVideo.firCount : j3, (i11 & 131072) != 0 ? inboundRtpVideo.nackCount : j4, (i11 & 262144) != 0 ? inboundRtpVideo.pliCount : j5, (i11 & 524288) != 0 ? inboundRtpVideo.qpSum : j6, (i11 & 1048576) != 0 ? inboundRtpVideo.freezeCount : j7, (i11 & 2097152) != 0 ? inboundRtpVideo.pauseCount : j8, (i11 & 4194304) != 0 ? inboundRtpVideo.totalFreezesDuration : j9, (i11 & 8388608) != 0 ? inboundRtpVideo.totalPausesDuration : j10, (i11 & 16777216) != 0 ? inboundRtpVideo.totalFramesDuration : j11, (i11 & 33554432) != 0 ? inboundRtpVideo.sumOfSquaredFramesDurations : d);
    }

    /* renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component10, reason: from getter */
    public final String getDecoderImplementationName() {
        return this.decoderImplementationName;
    }

    /* renamed from: component11, reason: from getter */
    public final int getFramesDecoded() {
        return this.framesDecoded;
    }

    /* renamed from: component12, reason: from getter */
    public final int getFramesDropped() {
        return this.framesDropped;
    }

    /* renamed from: component13, reason: from getter */
    public final int getFramesReceived() {
        return this.framesReceived;
    }

    /* renamed from: component14, reason: from getter */
    public final int getFrameRateDecode() {
        return this.frameRateDecode;
    }

    /* renamed from: component15, reason: from getter */
    public final int getFrameRateNetwork() {
        return this.frameRateNetwork;
    }

    /* renamed from: component16, reason: from getter */
    public final int getFrameRateRender() {
        return this.frameRateRender;
    }

    /* renamed from: component17, reason: from getter */
    public final long getFirCount() {
        return this.firCount;
    }

    /* renamed from: component18, reason: from getter */
    public final long getNackCount() {
        return this.nackCount;
    }

    /* renamed from: component19, reason: from getter */
    public final long getPliCount() {
        return this.pliCount;
    }

    /* renamed from: component2, reason: from getter */
    public final long getSsrc() {
        return this.ssrc;
    }

    /* renamed from: component20, reason: from getter */
    public final long getQpSum() {
        return this.qpSum;
    }

    /* renamed from: component21, reason: from getter */
    public final long getFreezeCount() {
        return this.freezeCount;
    }

    /* renamed from: component22, reason: from getter */
    public final long getPauseCount() {
        return this.pauseCount;
    }

    /* renamed from: component23, reason: from getter */
    public final long getTotalFreezesDuration() {
        return this.totalFreezesDuration;
    }

    /* renamed from: component24, reason: from getter */
    public final long getTotalPausesDuration() {
        return this.totalPausesDuration;
    }

    /* renamed from: component25, reason: from getter */
    public final long getTotalFramesDuration() {
        return this.totalFramesDuration;
    }

    /* renamed from: component26, reason: from getter */
    public final double getSumOfSquaredFramesDurations() {
        return this.sumOfSquaredFramesDurations;
    }

    /* renamed from: component3, reason: from getter */
    public final StatsCodec getCodec() {
        return this.codec;
    }

    /* renamed from: component4, reason: from getter */
    public final long getBytesReceived() {
        return this.bytesReceived;
    }

    /* renamed from: component5, reason: from getter */
    public final int getPacketsReceived() {
        return this.packetsReceived;
    }

    /* renamed from: component6, reason: from getter */
    public final int getPacketsLost() {
        return this.packetsLost;
    }

    /* renamed from: component7, reason: from getter */
    public final int getBitrate() {
        return this.bitrate;
    }

    /* renamed from: component8, reason: from getter */
    public final int getAverageDecodeTime() {
        return this.averageDecodeTime;
    }

    /* renamed from: component9, reason: from getter */
    public final Resolution getResolution() {
        return this.resolution;
    }

    public final InboundRtpVideo copy(String type, long ssrc, StatsCodec codec, long bytesReceived, int packetsReceived, int packetsLost, int bitrate, int averageDecodeTime, Resolution resolution, String decoderImplementationName, int framesDecoded, int framesDropped, int framesReceived, int frameRateDecode, int frameRateNetwork, int frameRateRender, long firCount, long nackCount, long pliCount, long qpSum, long freezeCount, long pauseCount, long totalFreezesDuration, long totalPausesDuration, long totalFramesDuration, double sumOfSquaredFramesDurations) {
        Intrinsics3.checkNotNullParameter(type, "type");
        Intrinsics3.checkNotNullParameter(resolution, "resolution");
        Intrinsics3.checkNotNullParameter(decoderImplementationName, "decoderImplementationName");
        return new InboundRtpVideo(type, ssrc, codec, bytesReceived, packetsReceived, packetsLost, bitrate, averageDecodeTime, resolution, decoderImplementationName, framesDecoded, framesDropped, framesReceived, frameRateDecode, frameRateNetwork, frameRateRender, firCount, nackCount, pliCount, qpSum, freezeCount, pauseCount, totalFreezesDuration, totalPausesDuration, totalFramesDuration, sumOfSquaredFramesDurations);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InboundRtpVideo)) {
            return false;
        }
        InboundRtpVideo inboundRtpVideo = (InboundRtpVideo) other;
        return Intrinsics3.areEqual(this.type, inboundRtpVideo.type) && this.ssrc == inboundRtpVideo.ssrc && Intrinsics3.areEqual(this.codec, inboundRtpVideo.codec) && this.bytesReceived == inboundRtpVideo.bytesReceived && this.packetsReceived == inboundRtpVideo.packetsReceived && this.packetsLost == inboundRtpVideo.packetsLost && this.bitrate == inboundRtpVideo.bitrate && this.averageDecodeTime == inboundRtpVideo.averageDecodeTime && Intrinsics3.areEqual(this.resolution, inboundRtpVideo.resolution) && Intrinsics3.areEqual(this.decoderImplementationName, inboundRtpVideo.decoderImplementationName) && this.framesDecoded == inboundRtpVideo.framesDecoded && this.framesDropped == inboundRtpVideo.framesDropped && this.framesReceived == inboundRtpVideo.framesReceived && this.frameRateDecode == inboundRtpVideo.frameRateDecode && this.frameRateNetwork == inboundRtpVideo.frameRateNetwork && this.frameRateRender == inboundRtpVideo.frameRateRender && this.firCount == inboundRtpVideo.firCount && this.nackCount == inboundRtpVideo.nackCount && this.pliCount == inboundRtpVideo.pliCount && this.qpSum == inboundRtpVideo.qpSum && this.freezeCount == inboundRtpVideo.freezeCount && this.pauseCount == inboundRtpVideo.pauseCount && this.totalFreezesDuration == inboundRtpVideo.totalFreezesDuration && this.totalPausesDuration == inboundRtpVideo.totalPausesDuration && this.totalFramesDuration == inboundRtpVideo.totalFramesDuration && Double.compare(this.sumOfSquaredFramesDurations, inboundRtpVideo.sumOfSquaredFramesDurations) == 0;
    }

    public final int getAverageDecodeTime() {
        return this.averageDecodeTime;
    }

    public final int getBitrate() {
        return this.bitrate;
    }

    public final long getBytesReceived() {
        return this.bytesReceived;
    }

    public final StatsCodec getCodec() {
        return this.codec;
    }

    public final String getDecoderImplementationName() {
        return this.decoderImplementationName;
    }

    public final long getFirCount() {
        return this.firCount;
    }

    public final int getFrameRateDecode() {
        return this.frameRateDecode;
    }

    public final int getFrameRateNetwork() {
        return this.frameRateNetwork;
    }

    public final int getFrameRateRender() {
        return this.frameRateRender;
    }

    public final int getFramesDecoded() {
        return this.framesDecoded;
    }

    public final int getFramesDropped() {
        return this.framesDropped;
    }

    public final int getFramesReceived() {
        return this.framesReceived;
    }

    public final long getFreezeCount() {
        return this.freezeCount;
    }

    public final long getNackCount() {
        return this.nackCount;
    }

    public final int getPacketsLost() {
        return this.packetsLost;
    }

    public final int getPacketsReceived() {
        return this.packetsReceived;
    }

    public final long getPauseCount() {
        return this.pauseCount;
    }

    public final long getPliCount() {
        return this.pliCount;
    }

    public final long getQpSum() {
        return this.qpSum;
    }

    public final Resolution getResolution() {
        return this.resolution;
    }

    public final long getSsrc() {
        return this.ssrc;
    }

    public final double getSumOfSquaredFramesDurations() {
        return this.sumOfSquaredFramesDurations;
    }

    public final long getTotalFramesDuration() {
        return this.totalFramesDuration;
    }

    public final long getTotalFreezesDuration() {
        return this.totalFreezesDuration;
    }

    public final long getTotalPausesDuration() {
        return this.totalPausesDuration;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.type;
        int iM3a = (C0002b.m3a(this.ssrc) + ((str != null ? str.hashCode() : 0) * 31)) * 31;
        StatsCodec statsCodec = this.codec;
        int iM3a2 = (((((((((C0002b.m3a(this.bytesReceived) + ((iM3a + (statsCodec != null ? statsCodec.hashCode() : 0)) * 31)) * 31) + this.packetsReceived) * 31) + this.packetsLost) * 31) + this.bitrate) * 31) + this.averageDecodeTime) * 31;
        Resolution resolution = this.resolution;
        int iHashCode = (iM3a2 + (resolution != null ? resolution.hashCode() : 0)) * 31;
        String str2 = this.decoderImplementationName;
        return C0001a.m2a(this.sumOfSquaredFramesDurations) + ((C0002b.m3a(this.totalFramesDuration) + ((C0002b.m3a(this.totalPausesDuration) + ((C0002b.m3a(this.totalFreezesDuration) + ((C0002b.m3a(this.pauseCount) + ((C0002b.m3a(this.freezeCount) + ((C0002b.m3a(this.qpSum) + ((C0002b.m3a(this.pliCount) + ((C0002b.m3a(this.nackCount) + ((C0002b.m3a(this.firCount) + ((((((((((((((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.framesDecoded) * 31) + this.framesDropped) * 31) + this.framesReceived) * 31) + this.frameRateDecode) * 31) + this.frameRateNetwork) * 31) + this.frameRateRender) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("InboundRtpVideo(type=");
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
        sbM833U.append(", bitrate=");
        sbM833U.append(this.bitrate);
        sbM833U.append(", averageDecodeTime=");
        sbM833U.append(this.averageDecodeTime);
        sbM833U.append(", resolution=");
        sbM833U.append(this.resolution);
        sbM833U.append(", decoderImplementationName=");
        sbM833U.append(this.decoderImplementationName);
        sbM833U.append(", framesDecoded=");
        sbM833U.append(this.framesDecoded);
        sbM833U.append(", framesDropped=");
        sbM833U.append(this.framesDropped);
        sbM833U.append(", framesReceived=");
        sbM833U.append(this.framesReceived);
        sbM833U.append(", frameRateDecode=");
        sbM833U.append(this.frameRateDecode);
        sbM833U.append(", frameRateNetwork=");
        sbM833U.append(this.frameRateNetwork);
        sbM833U.append(", frameRateRender=");
        sbM833U.append(this.frameRateRender);
        sbM833U.append(", firCount=");
        sbM833U.append(this.firCount);
        sbM833U.append(", nackCount=");
        sbM833U.append(this.nackCount);
        sbM833U.append(", pliCount=");
        sbM833U.append(this.pliCount);
        sbM833U.append(", qpSum=");
        sbM833U.append(this.qpSum);
        sbM833U.append(", freezeCount=");
        sbM833U.append(this.freezeCount);
        sbM833U.append(", pauseCount=");
        sbM833U.append(this.pauseCount);
        sbM833U.append(", totalFreezesDuration=");
        sbM833U.append(this.totalFreezesDuration);
        sbM833U.append(", totalPausesDuration=");
        sbM833U.append(this.totalPausesDuration);
        sbM833U.append(", totalFramesDuration=");
        sbM833U.append(this.totalFramesDuration);
        sbM833U.append(", sumOfSquaredFramesDurations=");
        sbM833U.append(this.sumOfSquaredFramesDurations);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
