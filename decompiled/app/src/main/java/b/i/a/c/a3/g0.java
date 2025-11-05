package b.i.a.c.a3;

import android.media.MediaCodec;
import androidx.annotation.Nullable;
import b.i.a.c.a3.h0;
import b.i.a.c.v2.c;
import b.i.a.c.x2.w;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Objects;

/* compiled from: SampleDataQueue.java */
/* loaded from: classes3.dex */
public class g0 {
    public final b.i.a.c.e3.o a;

    /* renamed from: b, reason: collision with root package name */
    public final int f817b;
    public final b.i.a.c.f3.x c;
    public a d;
    public a e;
    public a f;
    public long g;

    /* compiled from: SampleDataQueue.java */
    public static final class a {
        public final long a;

        /* renamed from: b, reason: collision with root package name */
        public final long f818b;
        public boolean c;

        @Nullable
        public b.i.a.c.e3.e d;

        @Nullable
        public a e;

        public a(long j, int i) {
            this.a = j;
            this.f818b = j + i;
        }

        public int a(long j) {
            return ((int) (j - this.a)) + this.d.f939b;
        }
    }

    public g0(b.i.a.c.e3.o oVar) {
        this.a = oVar;
        int i = oVar.f944b;
        this.f817b = i;
        this.c = new b.i.a.c.f3.x(32);
        a aVar = new a(0L, i);
        this.d = aVar;
        this.e = aVar;
        this.f = aVar;
    }

    public static a d(a aVar, long j, ByteBuffer byteBuffer, int i) {
        while (j >= aVar.f818b) {
            aVar = aVar.e;
        }
        while (i > 0) {
            int iMin = Math.min(i, (int) (aVar.f818b - j));
            byteBuffer.put(aVar.d.a, aVar.a(j), iMin);
            i -= iMin;
            j += iMin;
            if (j == aVar.f818b) {
                aVar = aVar.e;
            }
        }
        return aVar;
    }

    public static a e(a aVar, long j, byte[] bArr, int i) {
        while (j >= aVar.f818b) {
            aVar = aVar.e;
        }
        int i2 = i;
        while (i2 > 0) {
            int iMin = Math.min(i2, (int) (aVar.f818b - j));
            System.arraycopy(aVar.d.a, aVar.a(j), bArr, i - i2, iMin);
            i2 -= iMin;
            j += iMin;
            if (j == aVar.f818b) {
                aVar = aVar.e;
            }
        }
        return aVar;
    }

    public static a f(a aVar, DecoderInputBuffer decoderInputBuffer, h0.b bVar, b.i.a.c.f3.x xVar) {
        if (decoderInputBuffer.t()) {
            long j = bVar.f824b;
            int iY = 1;
            xVar.A(1);
            a aVarE = e(aVar, j, xVar.a, 1);
            long j2 = j + 1;
            byte b2 = xVar.a[0];
            boolean z2 = (b2 & 128) != 0;
            int i = b2 & 127;
            b.i.a.c.v2.c cVar = decoderInputBuffer.k;
            byte[] bArr = cVar.a;
            if (bArr == null) {
                cVar.a = new byte[16];
            } else {
                Arrays.fill(bArr, (byte) 0);
            }
            aVar = e(aVarE, j2, cVar.a, i);
            long j3 = j2 + i;
            if (z2) {
                xVar.A(2);
                aVar = e(aVar, j3, xVar.a, 2);
                j3 += 2;
                iY = xVar.y();
            }
            int[] iArr = cVar.d;
            if (iArr == null || iArr.length < iY) {
                iArr = new int[iY];
            }
            int[] iArr2 = cVar.e;
            if (iArr2 == null || iArr2.length < iY) {
                iArr2 = new int[iY];
            }
            if (z2) {
                int i2 = iY * 6;
                xVar.A(i2);
                aVar = e(aVar, j3, xVar.a, i2);
                j3 += i2;
                xVar.E(0);
                for (int i3 = 0; i3 < iY; i3++) {
                    iArr[i3] = xVar.y();
                    iArr2[i3] = xVar.w();
                }
            } else {
                iArr[0] = 0;
                iArr2[0] = bVar.a - ((int) (j3 - bVar.f824b));
            }
            w.a aVar2 = bVar.c;
            int i4 = b.i.a.c.f3.e0.a;
            byte[] bArr2 = aVar2.f1299b;
            byte[] bArr3 = cVar.a;
            int i5 = aVar2.a;
            int i6 = aVar2.c;
            int i7 = aVar2.d;
            cVar.f = iY;
            cVar.d = iArr;
            cVar.e = iArr2;
            cVar.f1141b = bArr2;
            cVar.a = bArr3;
            cVar.c = i5;
            cVar.g = i6;
            cVar.h = i7;
            MediaCodec.CryptoInfo cryptoInfo = cVar.i;
            cryptoInfo.numSubSamples = iY;
            cryptoInfo.numBytesOfClearData = iArr;
            cryptoInfo.numBytesOfEncryptedData = iArr2;
            cryptoInfo.key = bArr2;
            cryptoInfo.iv = bArr3;
            cryptoInfo.mode = i5;
            if (b.i.a.c.f3.e0.a >= 24) {
                c.b bVar2 = cVar.j;
                Objects.requireNonNull(bVar2);
                bVar2.f1142b.set(i6, i7);
                bVar2.a.setPattern(bVar2.f1142b);
            }
            long j4 = bVar.f824b;
            int i8 = (int) (j3 - j4);
            bVar.f824b = j4 + i8;
            bVar.a -= i8;
        }
        if (!decoderInputBuffer.l()) {
            decoderInputBuffer.r(bVar.a);
            return d(aVar, bVar.f824b, decoderInputBuffer.l, bVar.a);
        }
        xVar.A(4);
        a aVarE2 = e(aVar, bVar.f824b, xVar.a, 4);
        int iW = xVar.w();
        bVar.f824b += 4;
        bVar.a -= 4;
        decoderInputBuffer.r(iW);
        a aVarD = d(aVarE2, bVar.f824b, decoderInputBuffer.l, iW);
        bVar.f824b += iW;
        int i9 = bVar.a - iW;
        bVar.a = i9;
        ByteBuffer byteBuffer = decoderInputBuffer.o;
        if (byteBuffer == null || byteBuffer.capacity() < i9) {
            decoderInputBuffer.o = ByteBuffer.allocate(i9);
        } else {
            decoderInputBuffer.o.clear();
        }
        return d(aVarD, bVar.f824b, decoderInputBuffer.o, bVar.a);
    }

    public void a(long j) {
        a aVar;
        if (j == -1) {
            return;
        }
        while (true) {
            aVar = this.d;
            if (j < aVar.f818b) {
                break;
            }
            b.i.a.c.e3.o oVar = this.a;
            b.i.a.c.e3.e eVar = aVar.d;
            synchronized (oVar) {
                b.i.a.c.e3.e[] eVarArr = oVar.c;
                eVarArr[0] = eVar;
                oVar.a(eVarArr);
            }
            a aVar2 = this.d;
            aVar2.d = null;
            a aVar3 = aVar2.e;
            aVar2.e = null;
            this.d = aVar3;
        }
        if (this.e.a < aVar.a) {
            this.e = aVar;
        }
    }

    public final void b(int i) {
        long j = this.g + i;
        this.g = j;
        a aVar = this.f;
        if (j == aVar.f818b) {
            this.f = aVar.e;
        }
    }

    public final int c(int i) {
        b.i.a.c.e3.e eVar;
        a aVar = this.f;
        if (!aVar.c) {
            b.i.a.c.e3.o oVar = this.a;
            synchronized (oVar) {
                oVar.e++;
                int i2 = oVar.f;
                if (i2 > 0) {
                    b.i.a.c.e3.e[] eVarArr = oVar.g;
                    int i3 = i2 - 1;
                    oVar.f = i3;
                    eVar = eVarArr[i3];
                    Objects.requireNonNull(eVar);
                    oVar.g[oVar.f] = null;
                } else {
                    eVar = new b.i.a.c.e3.e(new byte[oVar.f944b], 0);
                }
            }
            a aVar2 = new a(this.f.f818b, this.f817b);
            aVar.d = eVar;
            aVar.e = aVar2;
            aVar.c = true;
        }
        return Math.min(i, (int) (this.f.f818b - this.g));
    }
}
