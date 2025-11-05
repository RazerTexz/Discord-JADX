package b.i.a.c.y2;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import b.i.a.c.f3.e0;
import b.i.a.c.y2.n;
import b.i.a.c.y2.t;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Objects;

/* compiled from: AsynchronousMediaCodecAdapter.java */
@RequiresApi(23)
/* loaded from: classes3.dex */
public final class l implements t {
    public final MediaCodec a;

    /* renamed from: b, reason: collision with root package name */
    public final o f1306b;
    public final n c;
    public final boolean d;
    public boolean e;
    public int f = 0;

    @Nullable
    public Surface g;

    /* compiled from: AsynchronousMediaCodecAdapter.java */
    public static final class b implements t.b {
        public final b.i.b.a.l<HandlerThread> a;

        /* renamed from: b, reason: collision with root package name */
        public final b.i.b.a.l<HandlerThread> f1307b;

        public b(int i, boolean z2) {
            b.i.a.c.y2.a aVar = new b.i.a.c.y2.a(i);
            b.i.a.c.y2.b bVar = new b.i.a.c.y2.b(i);
            this.a = aVar;
            this.f1307b = bVar;
        }

        @Override // b.i.a.c.y2.t.b
        public /* bridge */ /* synthetic */ t a(t.a aVar) throws IOException {
            return b(aVar);
        }

        public l b(t.a aVar) throws Exception {
            MediaCodec mediaCodecCreateByCodecName;
            String str = aVar.a.a;
            l lVar = null;
            try {
                String strValueOf = String.valueOf(str);
                b.c.a.a0.d.f(strValueOf.length() != 0 ? "createCodec:".concat(strValueOf) : new String("createCodec:"));
                mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str);
                try {
                    l lVar2 = new l(mediaCodecCreateByCodecName, this.a.get(), this.f1307b.get(), false, null);
                    try {
                        b.c.a.a0.d.d0();
                        l.k(lVar2, aVar.f1314b, aVar.d, aVar.e, 0, false);
                        return lVar2;
                    } catch (Exception e) {
                        e = e;
                        lVar = lVar2;
                        if (lVar != null) {
                            lVar.release();
                        } else if (mediaCodecCreateByCodecName != null) {
                            mediaCodecCreateByCodecName.release();
                        }
                        throw e;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Exception e3) {
                e = e3;
                mediaCodecCreateByCodecName = null;
            }
        }
    }

    public l(MediaCodec mediaCodec, HandlerThread handlerThread, HandlerThread handlerThread2, boolean z2, a aVar) {
        this.a = mediaCodec;
        this.f1306b = new o(handlerThread);
        this.c = new n(mediaCodec, handlerThread2);
        this.d = z2;
    }

    public static void k(l lVar, MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i, boolean z2) {
        o oVar = lVar.f1306b;
        MediaCodec mediaCodec = lVar.a;
        b.c.a.a0.d.D(oVar.c == null);
        oVar.f1310b.start();
        Handler handler = new Handler(oVar.f1310b.getLooper());
        mediaCodec.setCallback(oVar, handler);
        oVar.c = handler;
        b.c.a.a0.d.f("configureCodec");
        lVar.a.configure(mediaFormat, surface, mediaCrypto, i);
        b.c.a.a0.d.d0();
        if (z2) {
            lVar.g = lVar.a.createInputSurface();
        }
        n nVar = lVar.c;
        if (!nVar.h) {
            nVar.d.start();
            nVar.e = new m(nVar, nVar.d.getLooper());
            nVar.h = true;
        }
        b.c.a.a0.d.f("startCodec");
        lVar.a.start();
        b.c.a.a0.d.d0();
        lVar.f = 1;
    }

    public static String l(int i, String str) {
        StringBuilder sb = new StringBuilder(str);
        if (i == 1) {
            sb.append("Audio");
        } else if (i == 2) {
            sb.append("Video");
        } else {
            sb.append("Unknown(");
            sb.append(i);
            sb.append(")");
        }
        return sb.toString();
    }

    @Override // b.i.a.c.y2.t
    public boolean a() {
        return false;
    }

    @Override // b.i.a.c.y2.t
    public void b(int i, int i2, b.i.a.c.v2.c cVar, long j, int i3) {
        n nVar = this.c;
        nVar.f();
        n.a aVarE = n.e();
        aVarE.a = i;
        aVarE.f1309b = i2;
        aVarE.c = 0;
        aVarE.e = j;
        aVarE.f = i3;
        MediaCodec.CryptoInfo cryptoInfo = aVarE.d;
        cryptoInfo.numSubSamples = cVar.f;
        cryptoInfo.numBytesOfClearData = n.c(cVar.d, cryptoInfo.numBytesOfClearData);
        cryptoInfo.numBytesOfEncryptedData = n.c(cVar.e, cryptoInfo.numBytesOfEncryptedData);
        byte[] bArrB = n.b(cVar.f1141b, cryptoInfo.key);
        Objects.requireNonNull(bArrB);
        cryptoInfo.key = bArrB;
        byte[] bArrB2 = n.b(cVar.a, cryptoInfo.iv);
        Objects.requireNonNull(bArrB2);
        cryptoInfo.iv = bArrB2;
        cryptoInfo.mode = cVar.c;
        if (e0.a >= 24) {
            cryptoInfo.setPattern(new MediaCodec.CryptoInfo.Pattern(cVar.g, cVar.h));
        }
        nVar.e.obtainMessage(1, aVarE).sendToTarget();
    }

    @Override // b.i.a.c.y2.t
    public void c(int i, long j) {
        this.a.releaseOutputBuffer(i, j);
    }

    @Override // b.i.a.c.y2.t
    public int d() {
        int iB;
        o oVar = this.f1306b;
        synchronized (oVar.a) {
            iB = -1;
            if (!oVar.b()) {
                IllegalStateException illegalStateException = oVar.m;
                if (illegalStateException != null) {
                    oVar.m = null;
                    throw illegalStateException;
                }
                MediaCodec.CodecException codecException = oVar.j;
                if (codecException != null) {
                    oVar.j = null;
                    throw codecException;
                }
                s sVar = oVar.d;
                if (!(sVar.c == 0)) {
                    iB = sVar.b();
                }
            }
        }
        return iB;
    }

    @Override // b.i.a.c.y2.t
    public int e(MediaCodec.BufferInfo bufferInfo) {
        int iB;
        o oVar = this.f1306b;
        synchronized (oVar.a) {
            iB = -1;
            if (!oVar.b()) {
                IllegalStateException illegalStateException = oVar.m;
                if (illegalStateException != null) {
                    oVar.m = null;
                    throw illegalStateException;
                }
                MediaCodec.CodecException codecException = oVar.j;
                if (codecException != null) {
                    oVar.j = null;
                    throw codecException;
                }
                s sVar = oVar.e;
                if (!(sVar.c == 0)) {
                    iB = sVar.b();
                    if (iB >= 0) {
                        b.c.a.a0.d.H(oVar.h);
                        MediaCodec.BufferInfo bufferInfoRemove = oVar.f.remove();
                        bufferInfo.set(bufferInfoRemove.offset, bufferInfoRemove.size, bufferInfoRemove.presentationTimeUs, bufferInfoRemove.flags);
                    } else if (iB == -2) {
                        oVar.h = oVar.g.remove();
                    }
                }
            }
        }
        return iB;
    }

    @Override // b.i.a.c.y2.t
    public void f(t.c cVar, Handler handler) {
        m();
        this.a.setOnFrameRenderedListener(new c(this, cVar), handler);
    }

    @Override // b.i.a.c.y2.t
    public void flush() {
        this.c.d();
        this.a.flush();
        o oVar = this.f1306b;
        MediaCodec mediaCodec = this.a;
        Objects.requireNonNull(mediaCodec);
        j jVar = new j(mediaCodec);
        synchronized (oVar.a) {
            oVar.k++;
            Handler handler = oVar.c;
            int i = e0.a;
            handler.post(new d(oVar, jVar));
        }
    }

    @Override // b.i.a.c.y2.t
    public void g(int i) {
        m();
        this.a.setVideoScalingMode(i);
    }

    @Override // b.i.a.c.y2.t
    public MediaFormat getOutputFormat() {
        MediaFormat mediaFormat;
        o oVar = this.f1306b;
        synchronized (oVar.a) {
            mediaFormat = oVar.h;
            if (mediaFormat == null) {
                throw new IllegalStateException();
            }
        }
        return mediaFormat;
    }

    @Override // b.i.a.c.y2.t
    @Nullable
    public ByteBuffer h(int i) {
        return this.a.getInputBuffer(i);
    }

    @Override // b.i.a.c.y2.t
    public void i(Surface surface) {
        m();
        this.a.setOutputSurface(surface);
    }

    @Override // b.i.a.c.y2.t
    @Nullable
    public ByteBuffer j(int i) {
        return this.a.getOutputBuffer(i);
    }

    public final void m() {
        if (this.d) {
            try {
                this.c.a();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e);
            }
        }
    }

    @Override // b.i.a.c.y2.t
    public void queueInputBuffer(int i, int i2, int i3, long j, int i4) {
        n nVar = this.c;
        nVar.f();
        n.a aVarE = n.e();
        aVarE.a = i;
        aVarE.f1309b = i2;
        aVarE.c = i3;
        aVarE.e = j;
        aVarE.f = i4;
        Handler handler = nVar.e;
        int i5 = e0.a;
        handler.obtainMessage(0, aVarE).sendToTarget();
    }

    @Override // b.i.a.c.y2.t
    public void release() {
        try {
            if (this.f == 1) {
                n nVar = this.c;
                if (nVar.h) {
                    nVar.d();
                    nVar.d.quit();
                }
                nVar.h = false;
                o oVar = this.f1306b;
                synchronized (oVar.a) {
                    oVar.l = true;
                    oVar.f1310b.quit();
                    oVar.a();
                }
            }
            this.f = 2;
        } finally {
            Surface surface = this.g;
            if (surface != null) {
                surface.release();
            }
            if (!this.e) {
                this.a.release();
                this.e = true;
            }
        }
    }

    @Override // b.i.a.c.y2.t
    public void releaseOutputBuffer(int i, boolean z2) {
        this.a.releaseOutputBuffer(i, z2);
    }

    @Override // b.i.a.c.y2.t
    public void setParameters(Bundle bundle) {
        m();
        this.a.setParameters(bundle);
    }
}
