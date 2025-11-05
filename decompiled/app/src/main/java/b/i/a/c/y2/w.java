package b.i.a.c.y2;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import b.i.a.c.f3.e0;
import b.i.a.c.y2.t;
import java.nio.ByteBuffer;

/* compiled from: SynchronousMediaCodecAdapter.java */
/* loaded from: classes3.dex */
public class w implements t {
    public final MediaCodec a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public ByteBuffer[] f1316b;

    @Nullable
    public ByteBuffer[] c;

    public w(MediaCodec mediaCodec, Surface surface, a aVar) {
        this.a = mediaCodec;
        if (e0.a < 21) {
            this.f1316b = mediaCodec.getInputBuffers();
            this.c = mediaCodec.getOutputBuffers();
        }
    }

    @Override // b.i.a.c.y2.t
    public boolean a() {
        return false;
    }

    @Override // b.i.a.c.y2.t
    public void b(int i, int i2, b.i.a.c.v2.c cVar, long j, int i3) throws MediaCodec.CryptoException {
        this.a.queueSecureInputBuffer(i, i2, cVar.i, j, i3);
    }

    @Override // b.i.a.c.y2.t
    @RequiresApi(21)
    public void c(int i, long j) {
        this.a.releaseOutputBuffer(i, j);
    }

    @Override // b.i.a.c.y2.t
    public int d() {
        return this.a.dequeueInputBuffer(0L);
    }

    @Override // b.i.a.c.y2.t
    public int e(MediaCodec.BufferInfo bufferInfo) {
        int iDequeueOutputBuffer;
        do {
            iDequeueOutputBuffer = this.a.dequeueOutputBuffer(bufferInfo, 0L);
            if (iDequeueOutputBuffer == -3 && e0.a < 21) {
                this.c = this.a.getOutputBuffers();
            }
        } while (iDequeueOutputBuffer == -3);
        return iDequeueOutputBuffer;
    }

    @Override // b.i.a.c.y2.t
    @RequiresApi(23)
    public void f(t.c cVar, Handler handler) {
        this.a.setOnFrameRenderedListener(new i(this, cVar), handler);
    }

    @Override // b.i.a.c.y2.t
    public void flush() {
        this.a.flush();
    }

    @Override // b.i.a.c.y2.t
    public void g(int i) {
        this.a.setVideoScalingMode(i);
    }

    @Override // b.i.a.c.y2.t
    public MediaFormat getOutputFormat() {
        return this.a.getOutputFormat();
    }

    @Override // b.i.a.c.y2.t
    @Nullable
    public ByteBuffer h(int i) {
        return e0.a >= 21 ? this.a.getInputBuffer(i) : this.f1316b[i];
    }

    @Override // b.i.a.c.y2.t
    @RequiresApi(23)
    public void i(Surface surface) {
        this.a.setOutputSurface(surface);
    }

    @Override // b.i.a.c.y2.t
    @Nullable
    public ByteBuffer j(int i) {
        return e0.a >= 21 ? this.a.getOutputBuffer(i) : this.c[i];
    }

    @Override // b.i.a.c.y2.t
    public void queueInputBuffer(int i, int i2, int i3, long j, int i4) throws MediaCodec.CryptoException {
        this.a.queueInputBuffer(i, i2, i3, j, i4);
    }

    @Override // b.i.a.c.y2.t
    public void release() {
        this.f1316b = null;
        this.c = null;
        this.a.release();
    }

    @Override // b.i.a.c.y2.t
    public void releaseOutputBuffer(int i, boolean z2) {
        this.a.releaseOutputBuffer(i, z2);
    }

    @Override // b.i.a.c.y2.t
    @RequiresApi(19)
    public void setParameters(Bundle bundle) {
        this.a.setParameters(bundle);
    }
}
