package co.discord.media_engine.internal;

import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: NativeStatistics.kt */
/* loaded from: classes.dex */
public final /* data */ class Substream {
    private final int avgDelay;
    private final FrameCounts frameCounts;
    private final int height;
    private final boolean isFlexFEC;
    private final boolean isRTX;
    private final int maxDelay;
    private final int retransmitBitrate;
    private final RtcpStats rtcpStats;
    private final RtpStats rtpStats;
    private final long ssrc;
    private final int totalBitrate;
    private final int width;

    public Substream(int i, FrameCounts frameCounts, int i2, boolean z2, boolean z3, int i3, int i4, RtcpStats rtcpStats, RtpStats rtpStats, long j, int i5, int i6) {
        Intrinsics3.checkNotNullParameter(frameCounts, "frameCounts");
        Intrinsics3.checkNotNullParameter(rtcpStats, "rtcpStats");
        Intrinsics3.checkNotNullParameter(rtpStats, "rtpStats");
        this.avgDelay = i;
        this.frameCounts = frameCounts;
        this.height = i2;
        this.isFlexFEC = z2;
        this.isRTX = z3;
        this.maxDelay = i3;
        this.retransmitBitrate = i4;
        this.rtcpStats = rtcpStats;
        this.rtpStats = rtpStats;
        this.ssrc = j;
        this.totalBitrate = i5;
        this.width = i6;
    }

    public static /* synthetic */ Substream copy$default(Substream substream, int i, FrameCounts frameCounts, int i2, boolean z2, boolean z3, int i3, int i4, RtcpStats rtcpStats, RtpStats rtpStats, long j, int i5, int i6, int i7, Object obj) {
        return substream.copy((i7 & 1) != 0 ? substream.avgDelay : i, (i7 & 2) != 0 ? substream.frameCounts : frameCounts, (i7 & 4) != 0 ? substream.height : i2, (i7 & 8) != 0 ? substream.isFlexFEC : z2, (i7 & 16) != 0 ? substream.isRTX : z3, (i7 & 32) != 0 ? substream.maxDelay : i3, (i7 & 64) != 0 ? substream.retransmitBitrate : i4, (i7 & 128) != 0 ? substream.rtcpStats : rtcpStats, (i7 & 256) != 0 ? substream.rtpStats : rtpStats, (i7 & 512) != 0 ? substream.ssrc : j, (i7 & 1024) != 0 ? substream.totalBitrate : i5, (i7 & 2048) != 0 ? substream.width : i6);
    }

    /* renamed from: component1, reason: from getter */
    public final int getAvgDelay() {
        return this.avgDelay;
    }

    /* renamed from: component10, reason: from getter */
    public final long getSsrc() {
        return this.ssrc;
    }

    /* renamed from: component11, reason: from getter */
    public final int getTotalBitrate() {
        return this.totalBitrate;
    }

    /* renamed from: component12, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* renamed from: component2, reason: from getter */
    public final FrameCounts getFrameCounts() {
        return this.frameCounts;
    }

    /* renamed from: component3, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsFlexFEC() {
        return this.isFlexFEC;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getIsRTX() {
        return this.isRTX;
    }

    /* renamed from: component6, reason: from getter */
    public final int getMaxDelay() {
        return this.maxDelay;
    }

    /* renamed from: component7, reason: from getter */
    public final int getRetransmitBitrate() {
        return this.retransmitBitrate;
    }

    /* renamed from: component8, reason: from getter */
    public final RtcpStats getRtcpStats() {
        return this.rtcpStats;
    }

    /* renamed from: component9, reason: from getter */
    public final RtpStats getRtpStats() {
        return this.rtpStats;
    }

    public final Substream copy(int avgDelay, FrameCounts frameCounts, int height, boolean isFlexFEC, boolean isRTX, int maxDelay, int retransmitBitrate, RtcpStats rtcpStats, RtpStats rtpStats, long ssrc, int totalBitrate, int width) {
        Intrinsics3.checkNotNullParameter(frameCounts, "frameCounts");
        Intrinsics3.checkNotNullParameter(rtcpStats, "rtcpStats");
        Intrinsics3.checkNotNullParameter(rtpStats, "rtpStats");
        return new Substream(avgDelay, frameCounts, height, isFlexFEC, isRTX, maxDelay, retransmitBitrate, rtcpStats, rtpStats, ssrc, totalBitrate, width);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Substream)) {
            return false;
        }
        Substream substream = (Substream) other;
        return this.avgDelay == substream.avgDelay && Intrinsics3.areEqual(this.frameCounts, substream.frameCounts) && this.height == substream.height && this.isFlexFEC == substream.isFlexFEC && this.isRTX == substream.isRTX && this.maxDelay == substream.maxDelay && this.retransmitBitrate == substream.retransmitBitrate && Intrinsics3.areEqual(this.rtcpStats, substream.rtcpStats) && Intrinsics3.areEqual(this.rtpStats, substream.rtpStats) && this.ssrc == substream.ssrc && this.totalBitrate == substream.totalBitrate && this.width == substream.width;
    }

    public final int getAvgDelay() {
        return this.avgDelay;
    }

    public final FrameCounts getFrameCounts() {
        return this.frameCounts;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getMaxDelay() {
        return this.maxDelay;
    }

    public final int getRetransmitBitrate() {
        return this.retransmitBitrate;
    }

    public final RtcpStats getRtcpStats() {
        return this.rtcpStats;
    }

    public final RtpStats getRtpStats() {
        return this.rtpStats;
    }

    public final long getSsrc() {
        return this.ssrc;
    }

    public final int getTotalBitrate() {
        return this.totalBitrate;
    }

    public final int getWidth() {
        return this.width;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i = this.avgDelay * 31;
        FrameCounts frameCounts = this.frameCounts;
        int iHashCode = (((i + (frameCounts != null ? frameCounts.hashCode() : 0)) * 31) + this.height) * 31;
        boolean z2 = this.isFlexFEC;
        int i2 = z2;
        if (z2 != 0) {
            i2 = 1;
        }
        int i3 = (iHashCode + i2) * 31;
        boolean z3 = this.isRTX;
        int i4 = (((((i3 + (z3 ? 1 : z3 ? 1 : 0)) * 31) + this.maxDelay) * 31) + this.retransmitBitrate) * 31;
        RtcpStats rtcpStats = this.rtcpStats;
        int iHashCode2 = (i4 + (rtcpStats != null ? rtcpStats.hashCode() : 0)) * 31;
        RtpStats rtpStats = this.rtpStats;
        return ((((C0002b.m3a(this.ssrc) + ((iHashCode2 + (rtpStats != null ? rtpStats.hashCode() : 0)) * 31)) * 31) + this.totalBitrate) * 31) + this.width;
    }

    public final boolean isFlexFEC() {
        return this.isFlexFEC;
    }

    public final boolean isRTX() {
        return this.isRTX;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("Substream(avgDelay=");
        sbM833U.append(this.avgDelay);
        sbM833U.append(", frameCounts=");
        sbM833U.append(this.frameCounts);
        sbM833U.append(", height=");
        sbM833U.append(this.height);
        sbM833U.append(", isFlexFEC=");
        sbM833U.append(this.isFlexFEC);
        sbM833U.append(", isRTX=");
        sbM833U.append(this.isRTX);
        sbM833U.append(", maxDelay=");
        sbM833U.append(this.maxDelay);
        sbM833U.append(", retransmitBitrate=");
        sbM833U.append(this.retransmitBitrate);
        sbM833U.append(", rtcpStats=");
        sbM833U.append(this.rtcpStats);
        sbM833U.append(", rtpStats=");
        sbM833U.append(this.rtpStats);
        sbM833U.append(", ssrc=");
        sbM833U.append(this.ssrc);
        sbM833U.append(", totalBitrate=");
        sbM833U.append(this.totalBitrate);
        sbM833U.append(", width=");
        return outline.m814B(sbM833U, this.width, ")");
    }
}
