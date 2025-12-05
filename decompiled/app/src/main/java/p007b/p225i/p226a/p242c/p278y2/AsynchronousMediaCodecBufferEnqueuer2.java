package p007b.p225i.p226a.p242c.p278y2;

import android.media.MediaCodec;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import p007b.p225i.p226a.p242c.p259f3.ConditionVariable;
import p007b.p225i.p226a.p242c.p259f3.Util2;

/* compiled from: AsynchronousMediaCodecBufferEnqueuer.java */
@RequiresApi(23)
/* renamed from: b.i.a.c.y2.n, reason: use source file name */
/* loaded from: classes3.dex */
public class AsynchronousMediaCodecBufferEnqueuer2 {

    /* renamed from: a */
    @GuardedBy("MESSAGE_PARAMS_INSTANCE_POOL")
    public static final ArrayDeque<a> f9069a = new ArrayDeque<>();

    /* renamed from: b */
    public static final Object f9070b = new Object();

    /* renamed from: c */
    public final MediaCodec f9071c;

    /* renamed from: d */
    public final HandlerThread f9072d;

    /* renamed from: e */
    public Handler f9073e;

    /* renamed from: f */
    public final AtomicReference<RuntimeException> f9074f;

    /* renamed from: g */
    public final ConditionVariable f9075g;

    /* renamed from: h */
    public boolean f9076h;

    /* compiled from: AsynchronousMediaCodecBufferEnqueuer.java */
    /* renamed from: b.i.a.c.y2.n$a */
    public static class a {

        /* renamed from: a */
        public int f9077a;

        /* renamed from: b */
        public int f9078b;

        /* renamed from: c */
        public int f9079c;

        /* renamed from: d */
        public final MediaCodec.CryptoInfo f9080d = new MediaCodec.CryptoInfo();

        /* renamed from: e */
        public long f9081e;

        /* renamed from: f */
        public int f9082f;
    }

    public AsynchronousMediaCodecBufferEnqueuer2(MediaCodec mediaCodec, HandlerThread handlerThread) {
        ConditionVariable conditionVariable = new ConditionVariable();
        this.f9071c = mediaCodec;
        this.f9072d = handlerThread;
        this.f9075g = conditionVariable;
        this.f9074f = new AtomicReference<>();
    }

    @Nullable
    /* renamed from: b */
    public static byte[] m3847b(@Nullable byte[] bArr, @Nullable byte[] bArr2) {
        if (bArr == null) {
            return bArr2;
        }
        if (bArr2 == null || bArr2.length < bArr.length) {
            return Arrays.copyOf(bArr, bArr.length);
        }
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    @Nullable
    /* renamed from: c */
    public static int[] m3848c(@Nullable int[] iArr, @Nullable int[] iArr2) {
        if (iArr == null) {
            return iArr2;
        }
        if (iArr2 == null || iArr2.length < iArr.length) {
            return Arrays.copyOf(iArr, iArr.length);
        }
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        return iArr2;
    }

    /* renamed from: e */
    public static a m3849e() {
        ArrayDeque<a> arrayDeque = f9069a;
        synchronized (arrayDeque) {
            if (arrayDeque.isEmpty()) {
                return new a();
            }
            return arrayDeque.removeFirst();
        }
    }

    /* renamed from: a */
    public final void m3850a() throws InterruptedException {
        this.f9075g.m3025a();
        Handler handler = this.f9073e;
        int i = Util2.f6708a;
        handler.obtainMessage(2).sendToTarget();
        ConditionVariable conditionVariable = this.f9075g;
        synchronized (conditionVariable) {
            while (!conditionVariable.f6728b) {
                conditionVariable.wait();
            }
        }
    }

    /* renamed from: d */
    public void m3851d() {
        if (this.f9076h) {
            try {
                Handler handler = this.f9073e;
                int i = Util2.f6708a;
                handler.removeCallbacksAndMessages(null);
                m3850a();
                m3852f();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e);
            }
        }
    }

    /* renamed from: f */
    public final void m3852f() {
        RuntimeException andSet = this.f9074f.getAndSet(null);
        if (andSet != null) {
            throw andSet;
        }
    }
}
