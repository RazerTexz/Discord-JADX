package org.webrtc;

import android.media.MediaCodecInfo;
import androidx.annotation.Nullable;
import org.webrtc.EglBase;
import org.webrtc.Predicate;

/* JADX INFO: loaded from: classes3.dex */
public class PlatformSoftwareVideoDecoderFactory extends MediaCodecVideoDecoderFactory {
    private static final Predicate<MediaCodecInfo> defaultAllowedPredicate = new C129791();

    /* JADX INFO: renamed from: org.webrtc.PlatformSoftwareVideoDecoderFactory$1 */
    public class C129791 implements Predicate<MediaCodecInfo> {
        @Override // org.webrtc.Predicate
        public /* synthetic */ Predicate<MediaCodecInfo> and(Predicate<? super MediaCodecInfo> predicate) {
            return Predicate.CC.m11035a(this, predicate);
        }

        @Override // org.webrtc.Predicate
        public /* synthetic */ Predicate<MediaCodecInfo> negate() {
            return Predicate.CC.m11036b(this);
        }

        @Override // org.webrtc.Predicate
        /* JADX INFO: renamed from: or */
        public /* synthetic */ Predicate<MediaCodecInfo> mo11025or(Predicate<? super MediaCodecInfo> predicate) {
            return Predicate.CC.m11037c(this, predicate);
        }

        @Override // org.webrtc.Predicate
        public /* bridge */ /* synthetic */ boolean test(MediaCodecInfo mediaCodecInfo) {
            return test2(mediaCodecInfo);
        }

        /* JADX INFO: renamed from: test, reason: avoid collision after fix types in other method */
        public boolean test2(MediaCodecInfo mediaCodecInfo) {
            return MediaCodecUtils.isSoftwareOnly(mediaCodecInfo);
        }
    }

    public PlatformSoftwareVideoDecoderFactory(@Nullable EglBase.Context context) {
        super(context, defaultAllowedPredicate);
    }

    @Override // org.webrtc.MediaCodecVideoDecoderFactory, org.webrtc.VideoDecoderFactory
    @Nullable
    public /* bridge */ /* synthetic */ VideoDecoder createDecoder(VideoCodecInfo videoCodecInfo) {
        return super.createDecoder(videoCodecInfo);
    }

    @Override // org.webrtc.MediaCodecVideoDecoderFactory, org.webrtc.VideoDecoderFactory
    public /* bridge */ /* synthetic */ VideoCodecInfo[] getSupportedCodecs() {
        return super.getSupportedCodecs();
    }
}
