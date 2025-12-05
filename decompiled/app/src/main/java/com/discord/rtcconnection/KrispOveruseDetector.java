package com.discord.rtcconnection;

import co.discord.media_engine.OutboundRtpAudio;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import kotlin.Tuples2;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: KrispOveruseDetector.kt */
/* loaded from: classes.dex */
public final class KrispOveruseDetector {

    /* renamed from: a */
    public OutboundRtpAudio f18736a;

    /* renamed from: b */
    public OutboundRtpAudio f18737b;

    /* renamed from: c */
    public int f18738c;

    /* renamed from: d */
    public final MediaEngineConnection f18739d;

    /* compiled from: KrispOveruseDetector.kt */
    public enum Status {
        CPU_OVERUSE,
        FAILED,
        VAD_CPU_OVERUSE
    }

    public KrispOveruseDetector(MediaEngineConnection mediaEngineConnection) {
        Intrinsics3.checkNotNullParameter(mediaEngineConnection, "connection");
        this.f18739d = mediaEngineConnection;
    }

    /* renamed from: a */
    public final Tuples2<Boolean, Long> m8451a(OutboundRtpAudio outboundRtpAudio, OutboundRtpAudio outboundRtpAudio2, double d) {
        if (outboundRtpAudio == null || outboundRtpAudio2 == null) {
            return new Tuples2<>(Boolean.FALSE, 0L);
        }
        long noiseCancellerProcessTime = outboundRtpAudio2.getNoiseCancellerProcessTime() - outboundRtpAudio.getNoiseCancellerProcessTime();
        long framesCaptured = outboundRtpAudio2.getFramesCaptured() - outboundRtpAudio.getFramesCaptured();
        if (framesCaptured == 0) {
            return new Tuples2<>(Boolean.FALSE, Long.valueOf(noiseCancellerProcessTime));
        }
        return new Tuples2<>(Boolean.valueOf(((double) noiseCancellerProcessTime) / ((double) framesCaptured) > d), Long.valueOf(noiseCancellerProcessTime));
    }
}
