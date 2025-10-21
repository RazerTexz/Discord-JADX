package co.discord.media_engine;

import com.hammerandchisel.libdiscord.Discord;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.Set;
import org.webrtc.VideoFrame;

/* compiled from: VideoStreamRenderer.kt */
/* renamed from: co.discord.media_engine.VideoStreamRenderer$Muxer$addSink$1$2, reason: use source file name */
/* loaded from: classes.dex */
public final class VideoStreamRenderer2 implements Discord.VideoFrameCallback {
    public final /* synthetic */ Set $sinks;

    public VideoStreamRenderer2(Set set) {
        this.$sinks = set;
    }

    @Override // com.hammerandchisel.libdiscord.Discord.VideoFrameCallback
    public final boolean onFrame(VideoFrame videoFrame) {
        Intrinsics3.checkNotNullParameter(videoFrame, "frame");
        synchronized (this.$sinks) {
            VideoStreamRenderer videoStreamRenderer = (VideoStreamRenderer) _Collections.firstOrNull(this.$sinks);
            if (videoStreamRenderer != null) {
                videoStreamRenderer.onFrame(videoFrame);
            }
            videoFrame.release();
        }
        return true;
    }
}
