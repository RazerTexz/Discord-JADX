package p007b.p225i.p226a.p242c.p278y2;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.IOException;
import java.nio.ByteBuffer;
import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.p265v2.CryptoInfo;

/* compiled from: MediaCodecAdapter.java */
/* renamed from: b.i.a.c.y2.t, reason: use source file name */
/* loaded from: classes3.dex */
public interface MediaCodecAdapter {

    /* compiled from: MediaCodecAdapter.java */
    /* renamed from: b.i.a.c.y2.t$a */
    public static final class a {

        /* renamed from: a */
        public final MediaCodecInfo f9107a;

        /* renamed from: b */
        public final MediaFormat f9108b;

        /* renamed from: c */
        public final Format2 f9109c;

        /* renamed from: d */
        @Nullable
        public final Surface f9110d;

        /* renamed from: e */
        @Nullable
        public final MediaCrypto f9111e;

        public a(MediaCodecInfo mediaCodecInfo, MediaFormat mediaFormat, Format2 format2, @Nullable Surface surface, @Nullable MediaCrypto mediaCrypto, int i, boolean z2) {
            this.f9107a = mediaCodecInfo;
            this.f9108b = mediaFormat;
            this.f9109c = format2;
            this.f9110d = surface;
            this.f9111e = mediaCrypto;
        }
    }

    /* compiled from: MediaCodecAdapter.java */
    /* renamed from: b.i.a.c.y2.t$b */
    public interface b {
        /* renamed from: a */
        MediaCodecAdapter mo3845a(a aVar) throws IOException;
    }

    /* compiled from: MediaCodecAdapter.java */
    /* renamed from: b.i.a.c.y2.t$c */
    public interface c {
    }

    /* renamed from: a */
    boolean mo3834a();

    /* renamed from: b */
    void mo3835b(int i, int i2, CryptoInfo cryptoInfo, long j, int i3);

    @RequiresApi(21)
    /* renamed from: c */
    void mo3836c(int i, long j);

    /* renamed from: d */
    int mo3837d();

    /* renamed from: e */
    int mo3838e(MediaCodec.BufferInfo bufferInfo);

    @RequiresApi(23)
    /* renamed from: f */
    void mo3839f(c cVar, Handler handler);

    void flush();

    /* renamed from: g */
    void mo3840g(int i);

    MediaFormat getOutputFormat();

    @Nullable
    /* renamed from: h */
    ByteBuffer mo3841h(int i);

    @RequiresApi(23)
    /* renamed from: i */
    void mo3842i(Surface surface);

    @Nullable
    /* renamed from: j */
    ByteBuffer mo3843j(int i);

    void queueInputBuffer(int i, int i2, int i3, long j, int i4);

    void release();

    void releaseOutputBuffer(int i, boolean z2);

    @RequiresApi(19)
    void setParameters(Bundle bundle);
}
