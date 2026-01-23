package p615g0;

import java.io.IOException;
import java.io.OutputStream;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: g0.p, reason: use source file name */
/* JADX INFO: compiled from: JvmOkio.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class JvmOkio2 implements Sink {

    /* JADX INFO: renamed from: j */
    public final OutputStream f26109j;

    /* JADX INFO: renamed from: k */
    public final Timeout2 f26110k;

    public JvmOkio2(OutputStream outputStream, Timeout2 timeout2) {
        Intrinsics3.checkParameterIsNotNull(outputStream, "out");
        Intrinsics3.checkParameterIsNotNull(timeout2, "timeout");
        this.f26109j = outputStream;
        this.f26110k = timeout2;
    }

    @Override // p615g0.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f26109j.close();
    }

    @Override // p615g0.Sink, java.io.Flushable
    public void flush() throws IOException {
        this.f26109j.flush();
    }

    @Override // p615g0.Sink
    public Timeout2 timeout() {
        return this.f26110k;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("sink(");
        sbM833U.append(this.f26109j);
        sbM833U.append(')');
        return sbM833U.toString();
    }

    @Override // p615g0.Sink
    public void write(Buffer3 buffer3, long j) throws IOException {
        Intrinsics3.checkParameterIsNotNull(buffer3, "source");
        C3404f.m4192B(buffer3.f26080k, 0L, j);
        while (j > 0) {
            this.f26110k.mo10483f();
            Segment2 segment2 = buffer3.f26079j;
            if (segment2 == null) {
                Intrinsics3.throwNpe();
            }
            int iMin = (int) Math.min(j, segment2.f26120c - segment2.f26119b);
            this.f26109j.write(segment2.f26118a, segment2.f26119b, iMin);
            int i = segment2.f26119b + iMin;
            segment2.f26119b = i;
            long j2 = iMin;
            j -= j2;
            buffer3.f26080k -= j2;
            if (i == segment2.f26120c) {
                buffer3.f26079j = segment2.m10494a();
                SegmentPool.m10498a(segment2);
            }
        }
    }
}
