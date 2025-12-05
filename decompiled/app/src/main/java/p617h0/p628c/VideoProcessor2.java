package p617h0.p628c;

import androidx.annotation.Nullable;
import org.webrtc.VideoFrame;
import org.webrtc.VideoProcessor;

/* compiled from: VideoProcessor.java */
/* renamed from: h0.c.t0, reason: use source file name */
/* loaded from: classes3.dex */
public final /* synthetic */ class VideoProcessor2 {
    /* renamed from: a */
    public static void m10679a(VideoProcessor _this, VideoFrame videoFrame, VideoProcessor.FrameAdaptationParameters frameAdaptationParameters) {
        VideoFrame videoFrameM10680b = m10680b(videoFrame, frameAdaptationParameters);
        if (videoFrameM10680b != null) {
            _this.onFrameCaptured(videoFrameM10680b);
            videoFrameM10680b.release();
        }
    }

    @Nullable
    /* renamed from: b */
    public static VideoFrame m10680b(VideoFrame videoFrame, VideoProcessor.FrameAdaptationParameters frameAdaptationParameters) {
        if (frameAdaptationParameters.drop) {
            return null;
        }
        return new VideoFrame(videoFrame.getBuffer().cropAndScale(frameAdaptationParameters.cropX, frameAdaptationParameters.cropY, frameAdaptationParameters.cropWidth, frameAdaptationParameters.cropHeight, frameAdaptationParameters.scaleWidth, frameAdaptationParameters.scaleHeight), videoFrame.getRotation(), frameAdaptationParameters.timestampNs);
    }
}
