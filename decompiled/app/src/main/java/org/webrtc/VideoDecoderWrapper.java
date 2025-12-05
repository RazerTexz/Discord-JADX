package org.webrtc;

import org.webrtc.VideoDecoder;
import p617h0.p628c.C12453b0;

/* loaded from: classes3.dex */
public class VideoDecoderWrapper {
    @CalledByNative
    public static VideoDecoder.Callback createDecoderCallback(long j) {
        return new C12453b0(j);
    }

    public static /* synthetic */ void lambda$createDecoderCallback$0(long j, VideoFrame videoFrame, Integer num, Integer num2) {
        nativeOnDecodedFrame(j, videoFrame, num, num2);
    }

    private static native void nativeOnDecodedFrame(long j, VideoFrame videoFrame, Integer num, Integer num2);
}
