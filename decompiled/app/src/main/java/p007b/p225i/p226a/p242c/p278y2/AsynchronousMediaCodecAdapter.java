package p007b.p225i.p226a.p242c.p278y2;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p265v2.CryptoInfo;
import p007b.p225i.p226a.p242c.p278y2.AsynchronousMediaCodecBufferEnqueuer2;
import p007b.p225i.p226a.p242c.p278y2.MediaCodecAdapter;
import p007b.p225i.p355b.p356a.Supplier2;

/* compiled from: AsynchronousMediaCodecAdapter.java */
@RequiresApi(23)
/* renamed from: b.i.a.c.y2.l, reason: use source file name */
/* loaded from: classes3.dex */
public final class AsynchronousMediaCodecAdapter implements MediaCodecAdapter {

    /* renamed from: a */
    public final MediaCodec f9059a;

    /* renamed from: b */
    public final AsynchronousMediaCodecCallback f9060b;

    /* renamed from: c */
    public final AsynchronousMediaCodecBufferEnqueuer2 f9061c;

    /* renamed from: d */
    public final boolean f9062d;

    /* renamed from: e */
    public boolean f9063e;

    /* renamed from: f */
    public int f9064f = 0;

    /* renamed from: g */
    @Nullable
    public Surface f9065g;

    /* compiled from: AsynchronousMediaCodecAdapter.java */
    /* renamed from: b.i.a.c.y2.l$b */
    public static final class b implements MediaCodecAdapter.b {

        /* renamed from: a */
        public final Supplier2<HandlerThread> f9066a;

        /* renamed from: b */
        public final Supplier2<HandlerThread> f9067b;

        public b(int i, boolean z2) {
            C3129a c3129a = new C3129a(i);
            C3130b c3130b = new C3130b(i);
            this.f9066a = c3129a;
            this.f9067b = c3130b;
        }

        @Override // p007b.p225i.p226a.p242c.p278y2.MediaCodecAdapter.b
        /* renamed from: a */
        public /* bridge */ /* synthetic */ MediaCodecAdapter mo3845a(MediaCodecAdapter.a aVar) throws IOException {
            return m3846b(aVar);
        }

        /* renamed from: b */
        public AsynchronousMediaCodecAdapter m3846b(MediaCodecAdapter.a aVar) throws Exception {
            MediaCodec mediaCodecCreateByCodecName;
            String str = aVar.f9107a.f9112a;
            AsynchronousMediaCodecAdapter asynchronousMediaCodecAdapter = null;
            try {
                String strValueOf = String.valueOf(str);
                AnimatableValueParser.m515f(strValueOf.length() != 0 ? "createCodec:".concat(strValueOf) : new String("createCodec:"));
                mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str);
                try {
                    AsynchronousMediaCodecAdapter asynchronousMediaCodecAdapter2 = new AsynchronousMediaCodecAdapter(mediaCodecCreateByCodecName, this.f9066a.get(), this.f9067b.get(), false, null);
                    try {
                        AnimatableValueParser.m508d0();
                        AsynchronousMediaCodecAdapter.m3832k(asynchronousMediaCodecAdapter2, aVar.f9108b, aVar.f9110d, aVar.f9111e, 0, false);
                        return asynchronousMediaCodecAdapter2;
                    } catch (Exception e) {
                        e = e;
                        asynchronousMediaCodecAdapter = asynchronousMediaCodecAdapter2;
                        if (asynchronousMediaCodecAdapter != null) {
                            asynchronousMediaCodecAdapter.release();
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

    public AsynchronousMediaCodecAdapter(MediaCodec mediaCodec, HandlerThread handlerThread, HandlerThread handlerThread2, boolean z2, a aVar) {
        this.f9059a = mediaCodec;
        this.f9060b = new AsynchronousMediaCodecCallback(handlerThread);
        this.f9061c = new AsynchronousMediaCodecBufferEnqueuer2(mediaCodec, handlerThread2);
        this.f9062d = z2;
    }

    /* renamed from: k */
    public static void m3832k(AsynchronousMediaCodecAdapter asynchronousMediaCodecAdapter, MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i, boolean z2) {
        AsynchronousMediaCodecCallback asynchronousMediaCodecCallback = asynchronousMediaCodecAdapter.f9060b;
        MediaCodec mediaCodec = asynchronousMediaCodecAdapter.f9059a;
        AnimatableValueParser.m426D(asynchronousMediaCodecCallback.f9085c == null);
        asynchronousMediaCodecCallback.f9084b.start();
        Handler handler = new Handler(asynchronousMediaCodecCallback.f9084b.getLooper());
        mediaCodec.setCallback(asynchronousMediaCodecCallback, handler);
        asynchronousMediaCodecCallback.f9085c = handler;
        AnimatableValueParser.m515f("configureCodec");
        asynchronousMediaCodecAdapter.f9059a.configure(mediaFormat, surface, mediaCrypto, i);
        AnimatableValueParser.m508d0();
        if (z2) {
            asynchronousMediaCodecAdapter.f9065g = asynchronousMediaCodecAdapter.f9059a.createInputSurface();
        }
        AsynchronousMediaCodecBufferEnqueuer2 asynchronousMediaCodecBufferEnqueuer2 = asynchronousMediaCodecAdapter.f9061c;
        if (!asynchronousMediaCodecBufferEnqueuer2.f9076h) {
            asynchronousMediaCodecBufferEnqueuer2.f9072d.start();
            asynchronousMediaCodecBufferEnqueuer2.f9073e = new AsynchronousMediaCodecBufferEnqueuer(asynchronousMediaCodecBufferEnqueuer2, asynchronousMediaCodecBufferEnqueuer2.f9072d.getLooper());
            asynchronousMediaCodecBufferEnqueuer2.f9076h = true;
        }
        AnimatableValueParser.m515f("startCodec");
        asynchronousMediaCodecAdapter.f9059a.start();
        AnimatableValueParser.m508d0();
        asynchronousMediaCodecAdapter.f9064f = 1;
    }

    /* renamed from: l */
    public static String m3833l(int i, String str) {
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

    @Override // p007b.p225i.p226a.p242c.p278y2.MediaCodecAdapter
    /* renamed from: a */
    public boolean mo3834a() {
        return false;
    }

    @Override // p007b.p225i.p226a.p242c.p278y2.MediaCodecAdapter
    /* renamed from: b */
    public void mo3835b(int i, int i2, CryptoInfo cryptoInfo, long j, int i3) {
        AsynchronousMediaCodecBufferEnqueuer2 asynchronousMediaCodecBufferEnqueuer2 = this.f9061c;
        asynchronousMediaCodecBufferEnqueuer2.m3852f();
        AsynchronousMediaCodecBufferEnqueuer2.a aVarM3849e = AsynchronousMediaCodecBufferEnqueuer2.m3849e();
        aVarM3849e.f9077a = i;
        aVarM3849e.f9078b = i2;
        aVarM3849e.f9079c = 0;
        aVarM3849e.f9081e = j;
        aVarM3849e.f9082f = i3;
        MediaCodec.CryptoInfo cryptoInfo2 = aVarM3849e.f9080d;
        cryptoInfo2.numSubSamples = cryptoInfo.f7907f;
        cryptoInfo2.numBytesOfClearData = AsynchronousMediaCodecBufferEnqueuer2.m3848c(cryptoInfo.f7905d, cryptoInfo2.numBytesOfClearData);
        cryptoInfo2.numBytesOfEncryptedData = AsynchronousMediaCodecBufferEnqueuer2.m3848c(cryptoInfo.f7906e, cryptoInfo2.numBytesOfEncryptedData);
        byte[] bArrM3847b = AsynchronousMediaCodecBufferEnqueuer2.m3847b(cryptoInfo.f7903b, cryptoInfo2.key);
        Objects.requireNonNull(bArrM3847b);
        cryptoInfo2.key = bArrM3847b;
        byte[] bArrM3847b2 = AsynchronousMediaCodecBufferEnqueuer2.m3847b(cryptoInfo.f7902a, cryptoInfo2.iv);
        Objects.requireNonNull(bArrM3847b2);
        cryptoInfo2.iv = bArrM3847b2;
        cryptoInfo2.mode = cryptoInfo.f7904c;
        if (Util2.f6708a >= 24) {
            cryptoInfo2.setPattern(new MediaCodec.CryptoInfo.Pattern(cryptoInfo.f7908g, cryptoInfo.f7909h));
        }
        asynchronousMediaCodecBufferEnqueuer2.f9073e.obtainMessage(1, aVarM3849e).sendToTarget();
    }

    @Override // p007b.p225i.p226a.p242c.p278y2.MediaCodecAdapter
    /* renamed from: c */
    public void mo3836c(int i, long j) {
        this.f9059a.releaseOutputBuffer(i, j);
    }

    @Override // p007b.p225i.p226a.p242c.p278y2.MediaCodecAdapter
    /* renamed from: d */
    public int mo3837d() {
        int iM3861b;
        AsynchronousMediaCodecCallback asynchronousMediaCodecCallback = this.f9060b;
        synchronized (asynchronousMediaCodecCallback.f9083a) {
            iM3861b = -1;
            if (!asynchronousMediaCodecCallback.m3854b()) {
                IllegalStateException illegalStateException = asynchronousMediaCodecCallback.f9095m;
                if (illegalStateException != null) {
                    asynchronousMediaCodecCallback.f9095m = null;
                    throw illegalStateException;
                }
                MediaCodec.CodecException codecException = asynchronousMediaCodecCallback.f9092j;
                if (codecException != null) {
                    asynchronousMediaCodecCallback.f9092j = null;
                    throw codecException;
                }
                IntArrayQueue intArrayQueue = asynchronousMediaCodecCallback.f9086d;
                if (!(intArrayQueue.f9104c == 0)) {
                    iM3861b = intArrayQueue.m3861b();
                }
            }
        }
        return iM3861b;
    }

    @Override // p007b.p225i.p226a.p242c.p278y2.MediaCodecAdapter
    /* renamed from: e */
    public int mo3838e(MediaCodec.BufferInfo bufferInfo) {
        int iM3861b;
        AsynchronousMediaCodecCallback asynchronousMediaCodecCallback = this.f9060b;
        synchronized (asynchronousMediaCodecCallback.f9083a) {
            iM3861b = -1;
            if (!asynchronousMediaCodecCallback.m3854b()) {
                IllegalStateException illegalStateException = asynchronousMediaCodecCallback.f9095m;
                if (illegalStateException != null) {
                    asynchronousMediaCodecCallback.f9095m = null;
                    throw illegalStateException;
                }
                MediaCodec.CodecException codecException = asynchronousMediaCodecCallback.f9092j;
                if (codecException != null) {
                    asynchronousMediaCodecCallback.f9092j = null;
                    throw codecException;
                }
                IntArrayQueue intArrayQueue = asynchronousMediaCodecCallback.f9087e;
                if (!(intArrayQueue.f9104c == 0)) {
                    iM3861b = intArrayQueue.m3861b();
                    if (iM3861b >= 0) {
                        AnimatableValueParser.m438H(asynchronousMediaCodecCallback.f9090h);
                        MediaCodec.BufferInfo bufferInfoRemove = asynchronousMediaCodecCallback.f9088f.remove();
                        bufferInfo.set(bufferInfoRemove.offset, bufferInfoRemove.size, bufferInfoRemove.presentationTimeUs, bufferInfoRemove.flags);
                    } else if (iM3861b == -2) {
                        asynchronousMediaCodecCallback.f9090h = asynchronousMediaCodecCallback.f9089g.remove();
                    }
                }
            }
        }
        return iM3861b;
    }

    @Override // p007b.p225i.p226a.p242c.p278y2.MediaCodecAdapter
    /* renamed from: f */
    public void mo3839f(MediaCodecAdapter.c cVar, Handler handler) {
        m3844m();
        this.f9059a.setOnFrameRenderedListener(new C3131c(this, cVar), handler);
    }

    @Override // p007b.p225i.p226a.p242c.p278y2.MediaCodecAdapter
    public void flush() {
        this.f9061c.m3851d();
        this.f9059a.flush();
        AsynchronousMediaCodecCallback asynchronousMediaCodecCallback = this.f9060b;
        MediaCodec mediaCodec = this.f9059a;
        Objects.requireNonNull(mediaCodec);
        RunnableC3138j runnableC3138j = new RunnableC3138j(mediaCodec);
        synchronized (asynchronousMediaCodecCallback.f9083a) {
            asynchronousMediaCodecCallback.f9093k++;
            Handler handler = asynchronousMediaCodecCallback.f9085c;
            int i = Util2.f6708a;
            handler.post(new RunnableC3132d(asynchronousMediaCodecCallback, runnableC3138j));
        }
    }

    @Override // p007b.p225i.p226a.p242c.p278y2.MediaCodecAdapter
    /* renamed from: g */
    public void mo3840g(int i) {
        m3844m();
        this.f9059a.setVideoScalingMode(i);
    }

    @Override // p007b.p225i.p226a.p242c.p278y2.MediaCodecAdapter
    public MediaFormat getOutputFormat() {
        MediaFormat mediaFormat;
        AsynchronousMediaCodecCallback asynchronousMediaCodecCallback = this.f9060b;
        synchronized (asynchronousMediaCodecCallback.f9083a) {
            mediaFormat = asynchronousMediaCodecCallback.f9090h;
            if (mediaFormat == null) {
                throw new IllegalStateException();
            }
        }
        return mediaFormat;
    }

    @Override // p007b.p225i.p226a.p242c.p278y2.MediaCodecAdapter
    @Nullable
    /* renamed from: h */
    public ByteBuffer mo3841h(int i) {
        return this.f9059a.getInputBuffer(i);
    }

    @Override // p007b.p225i.p226a.p242c.p278y2.MediaCodecAdapter
    /* renamed from: i */
    public void mo3842i(Surface surface) {
        m3844m();
        this.f9059a.setOutputSurface(surface);
    }

    @Override // p007b.p225i.p226a.p242c.p278y2.MediaCodecAdapter
    @Nullable
    /* renamed from: j */
    public ByteBuffer mo3843j(int i) {
        return this.f9059a.getOutputBuffer(i);
    }

    /* renamed from: m */
    public final void m3844m() {
        if (this.f9062d) {
            try {
                this.f9061c.m3850a();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e);
            }
        }
    }

    @Override // p007b.p225i.p226a.p242c.p278y2.MediaCodecAdapter
    public void queueInputBuffer(int i, int i2, int i3, long j, int i4) {
        AsynchronousMediaCodecBufferEnqueuer2 asynchronousMediaCodecBufferEnqueuer2 = this.f9061c;
        asynchronousMediaCodecBufferEnqueuer2.m3852f();
        AsynchronousMediaCodecBufferEnqueuer2.a aVarM3849e = AsynchronousMediaCodecBufferEnqueuer2.m3849e();
        aVarM3849e.f9077a = i;
        aVarM3849e.f9078b = i2;
        aVarM3849e.f9079c = i3;
        aVarM3849e.f9081e = j;
        aVarM3849e.f9082f = i4;
        Handler handler = asynchronousMediaCodecBufferEnqueuer2.f9073e;
        int i5 = Util2.f6708a;
        handler.obtainMessage(0, aVarM3849e).sendToTarget();
    }

    @Override // p007b.p225i.p226a.p242c.p278y2.MediaCodecAdapter
    public void release() {
        try {
            if (this.f9064f == 1) {
                AsynchronousMediaCodecBufferEnqueuer2 asynchronousMediaCodecBufferEnqueuer2 = this.f9061c;
                if (asynchronousMediaCodecBufferEnqueuer2.f9076h) {
                    asynchronousMediaCodecBufferEnqueuer2.m3851d();
                    asynchronousMediaCodecBufferEnqueuer2.f9072d.quit();
                }
                asynchronousMediaCodecBufferEnqueuer2.f9076h = false;
                AsynchronousMediaCodecCallback asynchronousMediaCodecCallback = this.f9060b;
                synchronized (asynchronousMediaCodecCallback.f9083a) {
                    asynchronousMediaCodecCallback.f9094l = true;
                    asynchronousMediaCodecCallback.f9084b.quit();
                    asynchronousMediaCodecCallback.m3853a();
                }
            }
            this.f9064f = 2;
        } finally {
            Surface surface = this.f9065g;
            if (surface != null) {
                surface.release();
            }
            if (!this.f9063e) {
                this.f9059a.release();
                this.f9063e = true;
            }
        }
    }

    @Override // p007b.p225i.p226a.p242c.p278y2.MediaCodecAdapter
    public void releaseOutputBuffer(int i, boolean z2) {
        this.f9059a.releaseOutputBuffer(i, z2);
    }

    @Override // p007b.p225i.p226a.p242c.p278y2.MediaCodecAdapter
    public void setParameters(Bundle bundle) {
        m3844m();
        this.f9059a.setParameters(bundle);
    }
}
