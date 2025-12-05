package p617h0.p628c;

import androidx.annotation.Nullable;
import org.webrtc.CalledByNative;
import org.webrtc.VideoCodecInfo;
import org.webrtc.VideoDecoder;
import org.webrtc.VideoDecoderFactory;

/* compiled from: VideoDecoderFactory.java */
/* renamed from: h0.c.q0, reason: use source file name */
/* loaded from: classes3.dex */
public final /* synthetic */ class VideoDecoderFactory2 {
    @Nullable
    @Deprecated
    /* renamed from: a */
    public static VideoDecoder m10671a(VideoDecoderFactory _this, String str) {
        throw new UnsupportedOperationException("Deprecated and not implemented.");
    }

    @Nullable
    @CalledByNative
    /* renamed from: b */
    public static VideoDecoder m10672b(VideoDecoderFactory _this, VideoCodecInfo videoCodecInfo) {
        return _this.createDecoder(videoCodecInfo.getName());
    }

    @CalledByNative
    /* renamed from: c */
    public static VideoCodecInfo[] m10673c(VideoDecoderFactory videoDecoderFactory) {
        return new VideoCodecInfo[0];
    }
}
