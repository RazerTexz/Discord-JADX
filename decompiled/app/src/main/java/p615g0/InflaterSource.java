package p615g0;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: g0.m, reason: use source file name */
/* JADX INFO: compiled from: InflaterSource.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class InflaterSource implements Source2 {

    /* JADX INFO: renamed from: j */
    public int f26100j;

    /* JADX INFO: renamed from: k */
    public boolean f26101k;

    /* JADX INFO: renamed from: l */
    public final BufferedSource f26102l;

    /* JADX INFO: renamed from: m */
    public final Inflater f26103m;

    public InflaterSource(Source2 source2, Inflater inflater) {
        Intrinsics3.checkParameterIsNotNull(source2, "source");
        Intrinsics3.checkParameterIsNotNull(inflater, "inflater");
        Intrinsics3.checkParameterIsNotNull(source2, "$this$buffer");
        RealBufferedSource realBufferedSource = new RealBufferedSource(source2);
        Intrinsics3.checkParameterIsNotNull(realBufferedSource, "source");
        Intrinsics3.checkParameterIsNotNull(inflater, "inflater");
        this.f26102l = realBufferedSource;
        this.f26103m = inflater;
    }

    /* JADX INFO: renamed from: a */
    public final long m10488a(Buffer3 buffer3, long j) throws IOException {
        Intrinsics3.checkParameterIsNotNull(buffer3, "sink");
        if (!(j >= 0)) {
            throw new IllegalArgumentException(outline.m877t("byteCount < 0: ", j).toString());
        }
        if (!(!this.f26101k)) {
            throw new IllegalStateException("closed".toString());
        }
        if (j == 0) {
            return 0L;
        }
        try {
            Segment2 segment2M10438N = buffer3.m10438N(1);
            int iMin = (int) Math.min(j, 8192 - segment2M10438N.f26120c);
            if (this.f26103m.needsInput() && !this.f26102l.mo10472w()) {
                Segment2 segment2 = this.f26102l.mo10457g().f26079j;
                if (segment2 == null) {
                    Intrinsics3.throwNpe();
                }
                int i = segment2.f26120c;
                int i2 = segment2.f26119b;
                int i3 = i - i2;
                this.f26100j = i3;
                this.f26103m.setInput(segment2.f26118a, i2, i3);
            }
            int iInflate = this.f26103m.inflate(segment2M10438N.f26118a, segment2M10438N.f26120c, iMin);
            int i4 = this.f26100j;
            if (i4 != 0) {
                int remaining = i4 - this.f26103m.getRemaining();
                this.f26100j -= remaining;
                this.f26102l.skip(remaining);
            }
            if (iInflate > 0) {
                segment2M10438N.f26120c += iInflate;
                long j2 = iInflate;
                buffer3.f26080k += j2;
                return j2;
            }
            if (segment2M10438N.f26119b == segment2M10438N.f26120c) {
                buffer3.f26079j = segment2M10438N.m10494a();
                SegmentPool.m10498a(segment2M10438N);
            }
            return 0L;
        } catch (DataFormatException e) {
            throw new IOException(e);
        }
    }

    @Override // p615g0.Source2, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f26101k) {
            return;
        }
        this.f26103m.end();
        this.f26101k = true;
        this.f26102l.close();
    }

    @Override // p615g0.Source2
    /* JADX INFO: renamed from: i0 */
    public long mo10176i0(Buffer3 buffer3, long j) throws IOException {
        Intrinsics3.checkParameterIsNotNull(buffer3, "sink");
        do {
            long jM10488a = m10488a(buffer3, j);
            if (jM10488a > 0) {
                return jM10488a;
            }
            if (this.f26103m.finished() || this.f26103m.needsDictionary()) {
                return -1L;
            }
        } while (!this.f26102l.mo10472w());
        throw new EOFException("source exhausted prematurely");
    }

    @Override // p615g0.Source2
    public Timeout2 timeout() {
        return this.f26102l.timeout();
    }

    public InflaterSource(BufferedSource bufferedSource, Inflater inflater) {
        Intrinsics3.checkParameterIsNotNull(bufferedSource, "source");
        Intrinsics3.checkParameterIsNotNull(inflater, "inflater");
        this.f26102l = bufferedSource;
        this.f26103m = inflater;
    }
}
