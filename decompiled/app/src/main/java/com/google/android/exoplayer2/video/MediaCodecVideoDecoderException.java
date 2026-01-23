package com.google.android.exoplayer2.video;

import android.view.Surface;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.mediacodec.MediaCodecDecoderException;
import p007b.p225i.p226a.p242c.p278y2.MediaCodecInfo;

/* JADX INFO: loaded from: classes3.dex */
public class MediaCodecVideoDecoderException extends MediaCodecDecoderException {
    public final boolean isSurfaceValid;
    public final int surfaceIdentityHashCode;

    public MediaCodecVideoDecoderException(Throwable th, @Nullable MediaCodecInfo mediaCodecInfo, @Nullable Surface surface) {
        super(th, mediaCodecInfo);
        this.surfaceIdentityHashCode = System.identityHashCode(surface);
        this.isSurfaceValid = surface == null || surface.isValid();
    }
}
