package p615g0;

import java.io.IOException;
import java.util.zip.Deflater;
import okio.BufferedSink;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: g0.h, reason: use source file name */
/* JADX INFO: compiled from: DeflaterSink.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DeflaterSink implements Sink {

    /* JADX INFO: renamed from: j */
    public boolean f26090j;

    /* JADX INFO: renamed from: k */
    public final BufferedSink f26091k;

    /* JADX INFO: renamed from: l */
    public final Deflater f26092l;

    public DeflaterSink(Sink sink, Deflater deflater) {
        Intrinsics3.checkParameterIsNotNull(sink, "sink");
        Intrinsics3.checkParameterIsNotNull(deflater, "deflater");
        Intrinsics3.checkParameterIsNotNull(sink, "$this$buffer");
        RealBufferedSink realBufferedSink = new RealBufferedSink(sink);
        Intrinsics3.checkParameterIsNotNull(realBufferedSink, "sink");
        Intrinsics3.checkParameterIsNotNull(deflater, "deflater");
        this.f26091k = realBufferedSink;
        this.f26092l = deflater;
    }

    @IgnoreJRERequirement
    /* JADX INFO: renamed from: a */
    public final void m10477a(boolean z2) throws IOException {
        Segment2 segment2M10438N;
        int iDeflate;
        Buffer3 buffer3Mo10457g = this.f26091k.mo10457g();
        while (true) {
            segment2M10438N = buffer3Mo10457g.m10438N(1);
            if (z2) {
                Deflater deflater = this.f26092l;
                byte[] bArr = segment2M10438N.f26118a;
                int i = segment2M10438N.f26120c;
                iDeflate = deflater.deflate(bArr, i, 8192 - i, 2);
            } else {
                Deflater deflater2 = this.f26092l;
                byte[] bArr2 = segment2M10438N.f26118a;
                int i2 = segment2M10438N.f26120c;
                iDeflate = deflater2.deflate(bArr2, i2, 8192 - i2);
            }
            if (iDeflate > 0) {
                segment2M10438N.f26120c += iDeflate;
                buffer3Mo10457g.f26080k += (long) iDeflate;
                this.f26091k.mo10431F();
            } else if (this.f26092l.needsInput()) {
                break;
            }
        }
        if (segment2M10438N.f26119b == segment2M10438N.f26120c) {
            buffer3Mo10457g.f26079j = segment2M10438N.m10494a();
            SegmentPool.m10498a(segment2M10438N);
        }
    }

    @Override // p615g0.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.f26090j) {
            return;
        }
        Throwable th = null;
        try {
            this.f26092l.finish();
            m10477a(false);
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.f26092l.end();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        try {
            this.f26091k.close();
        } catch (Throwable th4) {
            if (th == null) {
                th = th4;
            }
        }
        this.f26090j = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // p615g0.Sink, java.io.Flushable
    public void flush() throws IOException {
        m10477a(true);
        this.f26091k.flush();
    }

    @Override // p615g0.Sink
    public Timeout2 timeout() {
        return this.f26091k.timeout();
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("DeflaterSink(");
        sbM833U.append(this.f26091k);
        sbM833U.append(')');
        return sbM833U.toString();
    }

    @Override // p615g0.Sink
    public void write(Buffer3 buffer3, long j) throws IOException {
        Intrinsics3.checkParameterIsNotNull(buffer3, "source");
        C3404f.m4192B(buffer3.f26080k, 0L, j);
        while (j > 0) {
            Segment2 segment2 = buffer3.f26079j;
            if (segment2 == null) {
                Intrinsics3.throwNpe();
            }
            int iMin = (int) Math.min(j, segment2.f26120c - segment2.f26119b);
            this.f26092l.setInput(segment2.f26118a, segment2.f26119b, iMin);
            m10477a(false);
            long j2 = iMin;
            buffer3.f26080k -= j2;
            int i = segment2.f26119b + iMin;
            segment2.f26119b = i;
            if (i == segment2.f26120c) {
                buffer3.f26079j = segment2.m10494a();
                SegmentPool.m10498a(segment2);
            }
            j -= j2;
        }
    }
}
