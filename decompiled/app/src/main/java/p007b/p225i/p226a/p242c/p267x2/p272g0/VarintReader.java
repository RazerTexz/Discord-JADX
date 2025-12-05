package p007b.p225i.p226a.p242c.p267x2.p272g0;

import java.io.IOException;
import p007b.p225i.p226a.p242c.p267x2.ExtractorInput;

/* compiled from: VarintReader.java */
/* renamed from: b.i.a.c.x2.g0.g, reason: use source file name */
/* loaded from: classes3.dex */
public final class VarintReader {

    /* renamed from: a */
    public static final long[] f8302a = {128, 64, 32, 16, 8, 4, 2, 1};

    /* renamed from: b */
    public final byte[] f8303b = new byte[8];

    /* renamed from: c */
    public int f8304c;

    /* renamed from: d */
    public int f8305d;

    /* renamed from: a */
    public static long m3685a(byte[] bArr, int i, boolean z2) {
        long j = bArr[0] & 255;
        if (z2) {
            j &= ~f8302a[i - 1];
        }
        for (int i2 = 1; i2 < i; i2++) {
            j = (j << 8) | (bArr[i2] & 255);
        }
        return j;
    }

    /* renamed from: b */
    public static int m3686b(int i) {
        int i2 = 0;
        while (true) {
            long[] jArr = f8302a;
            if (i2 >= jArr.length) {
                return -1;
            }
            if ((jArr[i2] & i) != 0) {
                return i2 + 1;
            }
            i2++;
        }
    }

    /* renamed from: c */
    public long m3687c(ExtractorInput extractorInput, boolean z2, boolean z3, int i) throws IOException {
        if (this.f8304c == 0) {
            if (!extractorInput.mo3643c(this.f8303b, 0, 1, z2)) {
                return -1L;
            }
            int iM3686b = m3686b(this.f8303b[0] & 255);
            this.f8305d = iM3686b;
            if (iM3686b == -1) {
                throw new IllegalStateException("No valid varint length mask found");
            }
            this.f8304c = 1;
        }
        int i2 = this.f8305d;
        if (i2 > i) {
            this.f8304c = 0;
            return -2L;
        }
        if (i2 != 1) {
            extractorInput.readFully(this.f8303b, 1, i2 - 1);
        }
        this.f8304c = 0;
        return m3685a(this.f8303b, this.f8305d, z3);
    }
}
