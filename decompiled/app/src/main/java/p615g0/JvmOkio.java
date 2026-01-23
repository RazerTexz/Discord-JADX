package p615g0;

import java.io.IOException;
import java.io.InputStream;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: g0.n, reason: use source file name */
/* JADX INFO: compiled from: JvmOkio.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class JvmOkio implements Source2 {

    /* JADX INFO: renamed from: j */
    public final InputStream f26104j;

    /* JADX INFO: renamed from: k */
    public final Timeout2 f26105k;

    public JvmOkio(InputStream inputStream, Timeout2 timeout2) {
        Intrinsics3.checkParameterIsNotNull(inputStream, "input");
        Intrinsics3.checkParameterIsNotNull(timeout2, "timeout");
        this.f26104j = inputStream;
        this.f26105k = timeout2;
    }

    @Override // p615g0.Source2, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f26104j.close();
    }

    @Override // p615g0.Source2
    /* JADX INFO: renamed from: i0 */
    public long mo10176i0(Buffer3 buffer3, long j) {
        Intrinsics3.checkParameterIsNotNull(buffer3, "sink");
        if (j == 0) {
            return 0L;
        }
        if (!(j >= 0)) {
            throw new IllegalArgumentException(outline.m877t("byteCount < 0: ", j).toString());
        }
        try {
            this.f26105k.mo10483f();
            Segment2 segment2M10438N = buffer3.m10438N(1);
            int i = this.f26104j.read(segment2M10438N.f26118a, segment2M10438N.f26120c, (int) Math.min(j, 8192 - segment2M10438N.f26120c));
            if (i != -1) {
                segment2M10438N.f26120c += i;
                long j2 = i;
                buffer3.f26080k += j2;
                return j2;
            }
            if (segment2M10438N.f26119b != segment2M10438N.f26120c) {
                return -1L;
            }
            buffer3.f26079j = segment2M10438N.m10494a();
            SegmentPool.m10498a(segment2M10438N);
            return -1L;
        } catch (AssertionError e) {
            if (C3404f.m4367z0(e)) {
                throw new IOException(e);
            }
            throw e;
        }
    }

    @Override // p615g0.Source2
    public Timeout2 timeout() {
        return this.f26105k;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("source(");
        sbM833U.append(this.f26104j);
        sbM833U.append(')');
        return sbM833U.toString();
    }
}
