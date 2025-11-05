package b.i.a.c.t2;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.audio.AudioProcessor;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import java.util.Objects;

/* compiled from: SonicAudioProcessor.java */
/* loaded from: classes3.dex */
public final class e0 implements AudioProcessor {

    /* renamed from: b, reason: collision with root package name */
    public int f1120b;
    public float c = 1.0f;
    public float d = 1.0f;
    public AudioProcessor.a e;
    public AudioProcessor.a f;
    public AudioProcessor.a g;
    public AudioProcessor.a h;
    public boolean i;

    @Nullable
    public d0 j;
    public ByteBuffer k;
    public ShortBuffer l;
    public ByteBuffer m;
    public long n;
    public long o;
    public boolean p;

    public e0() {
        AudioProcessor.a aVar = AudioProcessor.a.a;
        this.e = aVar;
        this.f = aVar;
        this.g = aVar;
        this.h = aVar;
        ByteBuffer byteBuffer = AudioProcessor.a;
        this.k = byteBuffer;
        this.l = byteBuffer.asShortBuffer();
        this.m = byteBuffer;
        this.f1120b = -1;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean a() {
        return this.f.f2914b != -1 && (Math.abs(this.c - 1.0f) >= 1.0E-4f || Math.abs(this.d - 1.0f) >= 1.0E-4f || this.f.f2914b != this.e.f2914b);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean b() {
        d0 d0Var;
        return this.p && ((d0Var = this.j) == null || (d0Var.m * d0Var.f1118b) * 2 == 0);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void c(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            d0 d0Var = this.j;
            Objects.requireNonNull(d0Var);
            ShortBuffer shortBufferAsShortBuffer = byteBuffer.asShortBuffer();
            int iRemaining = byteBuffer.remaining();
            this.n += iRemaining;
            int iRemaining2 = shortBufferAsShortBuffer.remaining();
            int i = d0Var.f1118b;
            int i2 = iRemaining2 / i;
            short[] sArrC = d0Var.c(d0Var.j, d0Var.k, i2);
            d0Var.j = sArrC;
            shortBufferAsShortBuffer.get(sArrC, d0Var.k * d0Var.f1118b, ((i * i2) * 2) / 2);
            d0Var.k += i2;
            d0Var.f();
            byteBuffer.position(byteBuffer.position() + iRemaining);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public AudioProcessor.a d(AudioProcessor.a aVar) throws AudioProcessor.UnhandledAudioFormatException {
        if (aVar.d != 2) {
            throw new AudioProcessor.UnhandledAudioFormatException(aVar);
        }
        int i = this.f1120b;
        if (i == -1) {
            i = aVar.f2914b;
        }
        this.e = aVar;
        AudioProcessor.a aVar2 = new AudioProcessor.a(i, aVar.c, 2);
        this.f = aVar2;
        this.i = true;
        return aVar2;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void e() {
        int i;
        d0 d0Var = this.j;
        if (d0Var != null) {
            int i2 = d0Var.k;
            float f = d0Var.c;
            float f2 = d0Var.d;
            int i3 = d0Var.m + ((int) ((((i2 / (f / f2)) + d0Var.o) / (d0Var.e * f2)) + 0.5f));
            d0Var.j = d0Var.c(d0Var.j, i2, (d0Var.h * 2) + i2);
            int i4 = 0;
            while (true) {
                i = d0Var.h * 2;
                int i5 = d0Var.f1118b;
                if (i4 >= i * i5) {
                    break;
                }
                d0Var.j[(i5 * i2) + i4] = 0;
                i4++;
            }
            d0Var.k = i + d0Var.k;
            d0Var.f();
            if (d0Var.m > i3) {
                d0Var.m = i3;
            }
            d0Var.k = 0;
            d0Var.r = 0;
            d0Var.o = 0;
        }
        this.p = true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void flush() {
        if (a()) {
            AudioProcessor.a aVar = this.e;
            this.g = aVar;
            AudioProcessor.a aVar2 = this.f;
            this.h = aVar2;
            if (this.i) {
                this.j = new d0(aVar.f2914b, aVar.c, this.c, this.d, aVar2.f2914b);
            } else {
                d0 d0Var = this.j;
                if (d0Var != null) {
                    d0Var.k = 0;
                    d0Var.m = 0;
                    d0Var.o = 0;
                    d0Var.p = 0;
                    d0Var.q = 0;
                    d0Var.r = 0;
                    d0Var.f1119s = 0;
                    d0Var.t = 0;
                    d0Var.u = 0;
                    d0Var.v = 0;
                }
            }
        }
        this.m = AudioProcessor.a;
        this.n = 0L;
        this.o = 0L;
        this.p = false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public ByteBuffer getOutput() {
        int i;
        d0 d0Var = this.j;
        if (d0Var != null && (i = d0Var.m * d0Var.f1118b * 2) > 0) {
            if (this.k.capacity() < i) {
                ByteBuffer byteBufferOrder = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
                this.k = byteBufferOrder;
                this.l = byteBufferOrder.asShortBuffer();
            } else {
                this.k.clear();
                this.l.clear();
            }
            ShortBuffer shortBuffer = this.l;
            int iMin = Math.min(shortBuffer.remaining() / d0Var.f1118b, d0Var.m);
            shortBuffer.put(d0Var.l, 0, d0Var.f1118b * iMin);
            int i2 = d0Var.m - iMin;
            d0Var.m = i2;
            short[] sArr = d0Var.l;
            int i3 = d0Var.f1118b;
            System.arraycopy(sArr, iMin * i3, sArr, 0, i2 * i3);
            this.o += i;
            this.k.limit(i);
            this.m = this.k;
        }
        ByteBuffer byteBuffer = this.m;
        this.m = AudioProcessor.a;
        return byteBuffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        this.c = 1.0f;
        this.d = 1.0f;
        AudioProcessor.a aVar = AudioProcessor.a.a;
        this.e = aVar;
        this.f = aVar;
        this.g = aVar;
        this.h = aVar;
        ByteBuffer byteBuffer = AudioProcessor.a;
        this.k = byteBuffer;
        this.l = byteBuffer.asShortBuffer();
        this.m = byteBuffer;
        this.f1120b = -1;
        this.i = false;
        this.j = null;
        this.n = 0L;
        this.o = 0L;
        this.p = false;
    }
}
