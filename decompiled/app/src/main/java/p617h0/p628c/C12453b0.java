package p617h0.p628c;

import org.webrtc.VideoDecoder;
import org.webrtc.VideoDecoderWrapper;
import org.webrtc.VideoFrame;

/* JADX INFO: renamed from: h0.c.b0 */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C12453b0 implements VideoDecoder.Callback {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ long f26411a;

    public /* synthetic */ C12453b0(long j) {
        this.f26411a = j;
    }

    @Override // org.webrtc.VideoDecoder.Callback
    public final void onDecodedFrame(VideoFrame videoFrame, Integer num, Integer num2) {
        VideoDecoderWrapper.lambda$createDecoderCallback$0(this.f26411a, videoFrame, num, null);
    }
}
