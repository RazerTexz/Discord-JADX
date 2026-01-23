package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderException;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p278y2.MediaCodecInfo;

/* JADX INFO: loaded from: classes3.dex */
public class MediaCodecDecoderException extends DecoderException {

    @Nullable
    public final MediaCodecInfo codecInfo;

    @Nullable
    public final String diagnosticInfo;

    /* JADX WARN: Illegal instructions before constructor call */
    public MediaCodecDecoderException(Throwable th, @Nullable MediaCodecInfo mediaCodecInfo) {
        String diagnosticInfo = null;
        String strValueOf = String.valueOf(mediaCodecInfo == null ? null : mediaCodecInfo.f9112a);
        super(strValueOf.length() != 0 ? "Decoder failed: ".concat(strValueOf) : new String("Decoder failed: "), th);
        this.codecInfo = mediaCodecInfo;
        if (Util2.f6708a >= 21 && (th instanceof MediaCodec.CodecException)) {
            diagnosticInfo = ((MediaCodec.CodecException) th).getDiagnosticInfo();
        }
        this.diagnosticInfo = diagnosticInfo;
    }
}
