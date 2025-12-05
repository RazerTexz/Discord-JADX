package p007b.p225i.p226a.p242c.p243a3;

import android.media.MediaCodec;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Objects;
import p007b.p225i.p226a.p242c.p243a3.SampleQueue;
import p007b.p225i.p226a.p242c.p257e3.Allocation;
import p007b.p225i.p226a.p242c.p257e3.DefaultAllocator;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p265v2.CryptoInfo;
import p007b.p225i.p226a.p242c.p267x2.TrackOutput2;

/* compiled from: SampleDataQueue.java */
/* renamed from: b.i.a.c.a3.g0, reason: use source file name */
/* loaded from: classes3.dex */
public class SampleDataQueue {

    /* renamed from: a */
    public final DefaultAllocator f5578a;

    /* renamed from: b */
    public final int f5579b;

    /* renamed from: c */
    public final ParsableByteArray f5580c;

    /* renamed from: d */
    public a f5581d;

    /* renamed from: e */
    public a f5582e;

    /* renamed from: f */
    public a f5583f;

    /* renamed from: g */
    public long f5584g;

    /* compiled from: SampleDataQueue.java */
    /* renamed from: b.i.a.c.a3.g0$a */
    public static final class a {

        /* renamed from: a */
        public final long f5585a;

        /* renamed from: b */
        public final long f5586b;

        /* renamed from: c */
        public boolean f5587c;

        /* renamed from: d */
        @Nullable
        public Allocation f5588d;

        /* renamed from: e */
        @Nullable
        public a f5589e;

        public a(long j, int i) {
            this.f5585a = j;
            this.f5586b = j + i;
        }

        /* renamed from: a */
        public int m2521a(long j) {
            return ((int) (j - this.f5585a)) + this.f5588d.f6523b;
        }
    }

    public SampleDataQueue(DefaultAllocator defaultAllocator) {
        this.f5578a = defaultAllocator;
        int i = defaultAllocator.f6563b;
        this.f5579b = i;
        this.f5580c = new ParsableByteArray(32);
        a aVar = new a(0L, i);
        this.f5581d = aVar;
        this.f5582e = aVar;
        this.f5583f = aVar;
    }

    /* renamed from: d */
    public static a m2515d(a aVar, long j, ByteBuffer byteBuffer, int i) {
        while (j >= aVar.f5586b) {
            aVar = aVar.f5589e;
        }
        while (i > 0) {
            int iMin = Math.min(i, (int) (aVar.f5586b - j));
            byteBuffer.put(aVar.f5588d.f6522a, aVar.m2521a(j), iMin);
            i -= iMin;
            j += iMin;
            if (j == aVar.f5586b) {
                aVar = aVar.f5589e;
            }
        }
        return aVar;
    }

    /* renamed from: e */
    public static a m2516e(a aVar, long j, byte[] bArr, int i) {
        while (j >= aVar.f5586b) {
            aVar = aVar.f5589e;
        }
        int i2 = i;
        while (i2 > 0) {
            int iMin = Math.min(i2, (int) (aVar.f5586b - j));
            System.arraycopy(aVar.f5588d.f6522a, aVar.m2521a(j), bArr, i - i2, iMin);
            i2 -= iMin;
            j += iMin;
            if (j == aVar.f5586b) {
                aVar = aVar.f5589e;
            }
        }
        return aVar;
    }

    /* renamed from: f */
    public static a m2517f(a aVar, DecoderInputBuffer decoderInputBuffer, SampleQueue.b bVar, ParsableByteArray parsableByteArray) {
        if (decoderInputBuffer.m8814t()) {
            long j = bVar.f5623b;
            int iM3105y = 1;
            parsableByteArray.m3075A(1);
            a aVarM2516e = m2516e(aVar, j, parsableByteArray.f6793a, 1);
            long j2 = j + 1;
            byte b2 = parsableByteArray.f6793a[0];
            boolean z2 = (b2 & 128) != 0;
            int i = b2 & 127;
            CryptoInfo cryptoInfo = decoderInputBuffer.f19777k;
            byte[] bArr = cryptoInfo.f7902a;
            if (bArr == null) {
                cryptoInfo.f7902a = new byte[16];
            } else {
                Arrays.fill(bArr, (byte) 0);
            }
            aVar = m2516e(aVarM2516e, j2, cryptoInfo.f7902a, i);
            long j3 = j2 + i;
            if (z2) {
                parsableByteArray.m3075A(2);
                aVar = m2516e(aVar, j3, parsableByteArray.f6793a, 2);
                j3 += 2;
                iM3105y = parsableByteArray.m3105y();
            }
            int[] iArr = cryptoInfo.f7905d;
            if (iArr == null || iArr.length < iM3105y) {
                iArr = new int[iM3105y];
            }
            int[] iArr2 = cryptoInfo.f7906e;
            if (iArr2 == null || iArr2.length < iM3105y) {
                iArr2 = new int[iM3105y];
            }
            if (z2) {
                int i2 = iM3105y * 6;
                parsableByteArray.m3075A(i2);
                aVar = m2516e(aVar, j3, parsableByteArray.f6793a, i2);
                j3 += i2;
                parsableByteArray.m3079E(0);
                for (int i3 = 0; i3 < iM3105y; i3++) {
                    iArr[i3] = parsableByteArray.m3105y();
                    iArr2[i3] = parsableByteArray.m3103w();
                }
            } else {
                iArr[0] = 0;
                iArr2[0] = bVar.f5622a - ((int) (j3 - bVar.f5623b));
            }
            TrackOutput2.a aVar2 = bVar.f5624c;
            int i4 = Util2.f6708a;
            byte[] bArr2 = aVar2.f9001b;
            byte[] bArr3 = cryptoInfo.f7902a;
            int i5 = aVar2.f9000a;
            int i6 = aVar2.f9002c;
            int i7 = aVar2.f9003d;
            cryptoInfo.f7907f = iM3105y;
            cryptoInfo.f7905d = iArr;
            cryptoInfo.f7906e = iArr2;
            cryptoInfo.f7903b = bArr2;
            cryptoInfo.f7902a = bArr3;
            cryptoInfo.f7904c = i5;
            cryptoInfo.f7908g = i6;
            cryptoInfo.f7909h = i7;
            MediaCodec.CryptoInfo cryptoInfo2 = cryptoInfo.f7910i;
            cryptoInfo2.numSubSamples = iM3105y;
            cryptoInfo2.numBytesOfClearData = iArr;
            cryptoInfo2.numBytesOfEncryptedData = iArr2;
            cryptoInfo2.key = bArr2;
            cryptoInfo2.iv = bArr3;
            cryptoInfo2.mode = i5;
            if (Util2.f6708a >= 24) {
                CryptoInfo.b bVar2 = cryptoInfo.f7911j;
                Objects.requireNonNull(bVar2);
                bVar2.f7913b.set(i6, i7);
                bVar2.f7912a.setPattern(bVar2.f7913b);
            }
            long j4 = bVar.f5623b;
            int i8 = (int) (j3 - j4);
            bVar.f5623b = j4 + i8;
            bVar.f5622a -= i8;
        }
        if (!decoderInputBuffer.m3553l()) {
            decoderInputBuffer.m8812r(bVar.f5622a);
            return m2515d(aVar, bVar.f5623b, decoderInputBuffer.f19778l, bVar.f5622a);
        }
        parsableByteArray.m3075A(4);
        a aVarM2516e2 = m2516e(aVar, bVar.f5623b, parsableByteArray.f6793a, 4);
        int iM3103w = parsableByteArray.m3103w();
        bVar.f5623b += 4;
        bVar.f5622a -= 4;
        decoderInputBuffer.m8812r(iM3103w);
        a aVarM2515d = m2515d(aVarM2516e2, bVar.f5623b, decoderInputBuffer.f19778l, iM3103w);
        bVar.f5623b += iM3103w;
        int i9 = bVar.f5622a - iM3103w;
        bVar.f5622a = i9;
        ByteBuffer byteBuffer = decoderInputBuffer.f19781o;
        if (byteBuffer == null || byteBuffer.capacity() < i9) {
            decoderInputBuffer.f19781o = ByteBuffer.allocate(i9);
        } else {
            decoderInputBuffer.f19781o.clear();
        }
        return m2515d(aVarM2515d, bVar.f5623b, decoderInputBuffer.f19781o, bVar.f5622a);
    }

    /* renamed from: a */
    public void m2518a(long j) {
        a aVar;
        if (j == -1) {
            return;
        }
        while (true) {
            aVar = this.f5581d;
            if (j < aVar.f5586b) {
                break;
            }
            DefaultAllocator defaultAllocator = this.f5578a;
            Allocation allocation = aVar.f5588d;
            synchronized (defaultAllocator) {
                Allocation[] allocationArr = defaultAllocator.f6564c;
                allocationArr[0] = allocation;
                defaultAllocator.m2858a(allocationArr);
            }
            a aVar2 = this.f5581d;
            aVar2.f5588d = null;
            a aVar3 = aVar2.f5589e;
            aVar2.f5589e = null;
            this.f5581d = aVar3;
        }
        if (this.f5582e.f5585a < aVar.f5585a) {
            this.f5582e = aVar;
        }
    }

    /* renamed from: b */
    public final void m2519b(int i) {
        long j = this.f5584g + i;
        this.f5584g = j;
        a aVar = this.f5583f;
        if (j == aVar.f5586b) {
            this.f5583f = aVar.f5589e;
        }
    }

    /* renamed from: c */
    public final int m2520c(int i) {
        Allocation allocation;
        a aVar = this.f5583f;
        if (!aVar.f5587c) {
            DefaultAllocator defaultAllocator = this.f5578a;
            synchronized (defaultAllocator) {
                defaultAllocator.f6566e++;
                int i2 = defaultAllocator.f6567f;
                if (i2 > 0) {
                    Allocation[] allocationArr = defaultAllocator.f6568g;
                    int i3 = i2 - 1;
                    defaultAllocator.f6567f = i3;
                    allocation = allocationArr[i3];
                    Objects.requireNonNull(allocation);
                    defaultAllocator.f6568g[defaultAllocator.f6567f] = null;
                } else {
                    allocation = new Allocation(new byte[defaultAllocator.f6563b], 0);
                }
            }
            a aVar2 = new a(this.f5583f.f5586b, this.f5579b);
            aVar.f5588d = allocation;
            aVar.f5589e = aVar2;
            aVar.f5587c = true;
        }
        return Math.min(i, (int) (this.f5583f.f5586b - this.f5584g));
    }
}
