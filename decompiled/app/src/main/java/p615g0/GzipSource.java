package p615g0;

import androidx.recyclerview.widget.RecyclerView;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: GzipSource.kt */
/* renamed from: g0.l, reason: use source file name */
/* loaded from: classes3.dex */
public final class GzipSource implements Source2 {

    /* renamed from: j */
    public byte f26095j;

    /* renamed from: k */
    public final RealBufferedSource f26096k;

    /* renamed from: l */
    public final Inflater f26097l;

    /* renamed from: m */
    public final InflaterSource f26098m;

    /* renamed from: n */
    public final CRC32 f26099n;

    public GzipSource(Source2 source2) {
        Intrinsics3.checkParameterIsNotNull(source2, "source");
        RealBufferedSource realBufferedSource = new RealBufferedSource(source2);
        this.f26096k = realBufferedSource;
        Inflater inflater = new Inflater(true);
        this.f26097l = inflater;
        this.f26098m = new InflaterSource((BufferedSource) realBufferedSource, inflater);
        this.f26099n = new CRC32();
    }

    /* renamed from: a */
    public final void m10486a(String str, int i, int i2) throws IOException {
        if (i2 == i) {
            return;
        }
        String str2 = String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i)}, 3));
        Intrinsics3.checkExpressionValueIsNotNull(str2, "java.lang.String.format(this, *args)");
        throw new IOException(str2);
    }

    /* renamed from: b */
    public final void m10487b(Buffer3 buffer3, long j, long j2) {
        Segment2 segment2 = buffer3.f26079j;
        if (segment2 == null) {
            Intrinsics3.throwNpe();
        }
        while (true) {
            int i = segment2.f26120c;
            int i2 = segment2.f26119b;
            if (j < i - i2) {
                break;
            }
            j -= i - i2;
            segment2 = segment2.f26123f;
            if (segment2 == null) {
                Intrinsics3.throwNpe();
            }
        }
        while (j2 > 0) {
            int iMin = (int) Math.min(segment2.f26120c - r7, j2);
            this.f26099n.update(segment2.f26118a, (int) (segment2.f26119b + j), iMin);
            j2 -= iMin;
            segment2 = segment2.f26123f;
            if (segment2 == null) {
                Intrinsics3.throwNpe();
            }
            j = 0;
        }
    }

    @Override // p615g0.Source2, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f26098m.close();
    }

    @Override // p615g0.Source2
    /* renamed from: i0 */
    public long mo10176i0(Buffer3 buffer3, long j) throws IOException {
        long j2;
        Intrinsics3.checkParameterIsNotNull(buffer3, "sink");
        if (!(j >= 0)) {
            throw new IllegalArgumentException(outline.m877t("byteCount < 0: ", j).toString());
        }
        if (j == 0) {
            return 0L;
        }
        if (this.f26095j == 0) {
            this.f26096k.mo10463p0(10L);
            byte bM10464q = this.f26096k.f26114j.m10464q(3L);
            boolean z2 = ((bM10464q >> 1) & 1) == 1;
            if (z2) {
                m10487b(this.f26096k.f26114j, 0L, 10L);
            }
            m10486a("ID1ID2", 8075, this.f26096k.readShort());
            this.f26096k.skip(8L);
            if (((bM10464q >> 2) & 1) == 1) {
                this.f26096k.mo10463p0(2L);
                if (z2) {
                    m10487b(this.f26096k.f26114j, 0L, 2L);
                }
                long jM10474y = this.f26096k.f26114j.m10474y();
                this.f26096k.mo10463p0(jM10474y);
                if (z2) {
                    j2 = jM10474y;
                    m10487b(this.f26096k.f26114j, 0L, jM10474y);
                } else {
                    j2 = jM10474y;
                }
                this.f26096k.skip(j2);
            }
            if (((bM10464q >> 3) & 1) == 1) {
                long jM10492a = this.f26096k.m10492a((byte) 0, 0L, RecyclerView.FOREVER_NS);
                if (jM10492a == -1) {
                    throw new EOFException();
                }
                if (z2) {
                    m10487b(this.f26096k.f26114j, 0L, jM10492a + 1);
                }
                this.f26096k.skip(jM10492a + 1);
            }
            if (((bM10464q >> 4) & 1) == 1) {
                long jM10492a2 = this.f26096k.m10492a((byte) 0, 0L, RecyclerView.FOREVER_NS);
                if (jM10492a2 == -1) {
                    throw new EOFException();
                }
                if (z2) {
                    m10487b(this.f26096k.f26114j, 0L, jM10492a2 + 1);
                }
                this.f26096k.skip(jM10492a2 + 1);
            }
            if (z2) {
                RealBufferedSource realBufferedSource = this.f26096k;
                realBufferedSource.mo10463p0(2L);
                m10486a("FHCRC", realBufferedSource.f26114j.m10474y(), (short) this.f26099n.getValue());
                this.f26099n.reset();
            }
            this.f26095j = (byte) 1;
        }
        if (this.f26095j == 1) {
            long j3 = buffer3.f26080k;
            long jMo10176i0 = this.f26098m.mo10176i0(buffer3, j);
            if (jMo10176i0 != -1) {
                m10487b(buffer3, j3, jMo10176i0);
                return jMo10176i0;
            }
            this.f26095j = (byte) 2;
        }
        if (this.f26095j == 2) {
            m10486a("CRC", this.f26096k.m10493b(), (int) this.f26099n.getValue());
            m10486a("ISIZE", this.f26096k.m10493b(), (int) this.f26097l.getBytesWritten());
            this.f26095j = (byte) 3;
            if (!this.f26096k.mo10472w()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    @Override // p615g0.Source2
    public Timeout2 timeout() {
        return this.f26096k.timeout();
    }
}
