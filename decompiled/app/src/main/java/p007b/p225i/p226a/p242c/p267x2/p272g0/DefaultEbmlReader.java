package p007b.p225i.p226a.p242c.p267x2.p272g0;

import java.io.IOException;
import java.util.ArrayDeque;
import p007b.p225i.p226a.p242c.p267x2.ExtractorInput;

/* compiled from: DefaultEbmlReader.java */
/* renamed from: b.i.a.c.x2.g0.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class DefaultEbmlReader implements EbmlReader {

    /* renamed from: a */
    public final byte[] f8181a = new byte[8];

    /* renamed from: b */
    public final ArrayDeque<b> f8182b = new ArrayDeque<>();

    /* renamed from: c */
    public final VarintReader f8183c = new VarintReader();

    /* renamed from: d */
    public EbmlProcessor f8184d;

    /* renamed from: e */
    public int f8185e;

    /* renamed from: f */
    public int f8186f;

    /* renamed from: g */
    public long f8187g;

    /* compiled from: DefaultEbmlReader.java */
    /* renamed from: b.i.a.c.x2.g0.b$b */
    public static final class b {

        /* renamed from: a */
        public final int f8188a;

        /* renamed from: b */
        public final long f8189b;

        public b(int i, long j, a aVar) {
            this.f8188a = i;
            this.f8189b = j;
        }
    }

    /* renamed from: a */
    public final long m3670a(ExtractorInput extractorInput, int i) throws IOException {
        extractorInput.readFully(this.f8181a, 0, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 8) | (this.f8181a[i2] & 255);
        }
        return j;
    }
}
