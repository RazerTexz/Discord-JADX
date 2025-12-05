package p007b.p225i.p226a.p242c.p265v2;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.util.ArrayDeque;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.p245b3.SimpleSubtitleDecoder;
import p007b.p225i.p226a.p242c.p245b3.SimpleSubtitleDecoder2;
import p007b.p225i.p226a.p242c.p245b3.SubtitleInputBuffer;
import p007b.p225i.p226a.p242c.p265v2.DecoderOutputBuffer;

/* compiled from: SimpleDecoder.java */
/* renamed from: b.i.a.c.v2.h, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class SimpleDecoder<I extends DecoderInputBuffer, O extends DecoderOutputBuffer, E extends DecoderException> implements Decoder<I, O, E> {

    /* renamed from: a */
    public final Thread f7931a;

    /* renamed from: b */
    public final Object f7932b = new Object();

    /* renamed from: c */
    public final ArrayDeque<I> f7933c = new ArrayDeque<>();

    /* renamed from: d */
    public final ArrayDeque<O> f7934d = new ArrayDeque<>();

    /* renamed from: e */
    public final I[] f7935e;

    /* renamed from: f */
    public final O[] f7936f;

    /* renamed from: g */
    public int f7937g;

    /* renamed from: h */
    public int f7938h;

    /* renamed from: i */
    @Nullable
    public I f7939i;

    /* renamed from: j */
    @Nullable
    public E f7940j;

    /* renamed from: k */
    public boolean f7941k;

    /* renamed from: l */
    public boolean f7942l;

    /* renamed from: m */
    public int f7943m;

    /* compiled from: SimpleDecoder.java */
    /* renamed from: b.i.a.c.v2.h$a */
    public class a extends Thread {
        public a(String str) {
            super(str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            SimpleDecoder simpleDecoder = SimpleDecoder.this;
            Objects.requireNonNull(simpleDecoder);
            do {
                try {
                } catch (InterruptedException e) {
                    throw new IllegalStateException(e);
                }
            } while (simpleDecoder.m3557f());
        }
    }

    public SimpleDecoder(I[] iArr, O[] oArr) {
        this.f7935e = iArr;
        this.f7937g = iArr.length;
        for (int i = 0; i < this.f7937g; i++) {
            this.f7935e[i] = new SubtitleInputBuffer();
        }
        this.f7936f = oArr;
        this.f7938h = oArr.length;
        for (int i2 = 0; i2 < this.f7938h; i2++) {
            this.f7936f[i2] = new SimpleSubtitleDecoder((SimpleSubtitleDecoder2) this);
        }
        a aVar = new a("ExoPlayer:SimpleDecoder");
        this.f7931a = aVar;
        aVar.start();
    }

    @Override // p007b.p225i.p226a.p242c.p265v2.Decoder
    @Nullable
    /* renamed from: b */
    public Object mo2608b() throws DecoderException {
        O oRemoveFirst;
        synchronized (this.f7932b) {
            m3559h();
            oRemoveFirst = this.f7934d.isEmpty() ? null : this.f7934d.removeFirst();
        }
        return oRemoveFirst;
    }

    @Override // p007b.p225i.p226a.p242c.p265v2.Decoder
    @Nullable
    /* renamed from: c */
    public Object mo2609c() throws DecoderException {
        I i;
        synchronized (this.f7932b) {
            m3559h();
            AnimatableValueParser.m426D(this.f7939i == null);
            int i2 = this.f7937g;
            if (i2 == 0) {
                i = null;
            } else {
                I[] iArr = this.f7935e;
                int i3 = i2 - 1;
                this.f7937g = i3;
                i = iArr[i3];
            }
            this.f7939i = i;
        }
        return i;
    }

    @Override // p007b.p225i.p226a.p242c.p265v2.Decoder
    /* renamed from: d */
    public void mo2610d(Object obj) throws DecoderException {
        DecoderInputBuffer decoderInputBuffer = (DecoderInputBuffer) obj;
        synchronized (this.f7932b) {
            m3559h();
            AnimatableValueParser.m531j(decoderInputBuffer == this.f7939i);
            this.f7933c.addLast(decoderInputBuffer);
            m3558g();
            this.f7939i = null;
        }
    }

    @Nullable
    /* renamed from: e */
    public abstract E mo2616e(I i, O o, boolean z2);

    /* JADX WARN: Removed duplicated region for block: B:34:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0078 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean m3557f() throws InterruptedException {
        SubtitleDecoderException subtitleDecoderException;
        SubtitleDecoderException subtitleDecoderException2;
        synchronized (this.f7932b) {
            while (!this.f7942l) {
                if (!this.f7933c.isEmpty() && this.f7938h > 0) {
                    break;
                }
                this.f7932b.wait();
            }
            if (this.f7942l) {
                return false;
            }
            I iRemoveFirst = this.f7933c.removeFirst();
            O[] oArr = this.f7936f;
            int i = this.f7938h - 1;
            this.f7938h = i;
            O o = oArr[i];
            boolean z2 = this.f7941k;
            this.f7941k = false;
            if (iRemoveFirst.m3555n()) {
                o.m3551j(4);
            } else {
                if (iRemoveFirst.m3554m()) {
                    o.m3551j(Integer.MIN_VALUE);
                }
                try {
                    subtitleDecoderException2 = (E) mo2616e(iRemoveFirst, o, z2);
                } catch (OutOfMemoryError e) {
                    subtitleDecoderException = new SubtitleDecoderException("Unexpected decode error", e);
                    subtitleDecoderException2 = subtitleDecoderException;
                    if (subtitleDecoderException2 != null) {
                    }
                    synchronized (this.f7932b) {
                    }
                } catch (RuntimeException e2) {
                    subtitleDecoderException = new SubtitleDecoderException("Unexpected decode error", e2);
                    subtitleDecoderException2 = subtitleDecoderException;
                    if (subtitleDecoderException2 != null) {
                    }
                    synchronized (this.f7932b) {
                    }
                }
                if (subtitleDecoderException2 != null) {
                    synchronized (this.f7932b) {
                        this.f7940j = subtitleDecoderException2;
                    }
                    return false;
                }
            }
            synchronized (this.f7932b) {
                if (this.f7941k) {
                    o.mo2611p();
                } else if (o.m3554m()) {
                    this.f7943m++;
                    o.mo2611p();
                } else {
                    this.f7943m = 0;
                    this.f7934d.addLast(o);
                }
                m3560i(iRemoveFirst);
            }
            return true;
        }
    }

    @Override // p007b.p225i.p226a.p242c.p265v2.Decoder
    public final void flush() {
        synchronized (this.f7932b) {
            this.f7941k = true;
            this.f7943m = 0;
            I i = this.f7939i;
            if (i != null) {
                m3560i(i);
                this.f7939i = null;
            }
            while (!this.f7933c.isEmpty()) {
                m3560i(this.f7933c.removeFirst());
            }
            while (!this.f7934d.isEmpty()) {
                this.f7934d.removeFirst().mo2611p();
            }
        }
    }

    /* renamed from: g */
    public final void m3558g() {
        if (!this.f7933c.isEmpty() && this.f7938h > 0) {
            this.f7932b.notify();
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: E extends com.google.android.exoplayer2.decoder.DecoderException */
    /* renamed from: h */
    public final void m3559h() throws E, DecoderException {
        E e = this.f7940j;
        if (e != null) {
            throw e;
        }
    }

    /* renamed from: i */
    public final void m3560i(I i) {
        i.mo3856p();
        I[] iArr = this.f7935e;
        int i2 = this.f7937g;
        this.f7937g = i2 + 1;
        iArr[i2] = i;
    }

    @Override // p007b.p225i.p226a.p242c.p265v2.Decoder
    @CallSuper
    public void release() {
        synchronized (this.f7932b) {
            this.f7942l = true;
            this.f7932b.notify();
        }
        try {
            this.f7931a.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }
}
