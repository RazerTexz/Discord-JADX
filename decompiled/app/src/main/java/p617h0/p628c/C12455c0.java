package p617h0.p628c;

import org.webrtc.EncodedImage;
import org.webrtc.VideoEncoder;
import org.webrtc.VideoEncoderWrapper;

/* compiled from: lambda */
/* renamed from: h0.c.c0 */
/* loaded from: classes3.dex */
public final /* synthetic */ class C12455c0 implements VideoEncoder.Callback {

    /* renamed from: a */
    public final /* synthetic */ long f26413a;

    public /* synthetic */ C12455c0(long j) {
        this.f26413a = j;
    }

    @Override // org.webrtc.VideoEncoder.Callback
    public final void onEncodedFrame(EncodedImage encodedImage, VideoEncoder.CodecSpecificInfo codecSpecificInfo) {
        VideoEncoderWrapper.lambda$createEncoderCallback$0(this.f26413a, encodedImage, codecSpecificInfo);
    }
}
