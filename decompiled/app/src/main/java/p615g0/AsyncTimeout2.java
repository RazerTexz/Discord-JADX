package p615g0;

import java.io.IOException;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: AsyncTimeout.kt */
/* renamed from: g0.c, reason: use source file name */
/* loaded from: classes3.dex */
public final class AsyncTimeout2 implements Sink {

    /* renamed from: j */
    public final /* synthetic */ AsyncTimeout f26075j;

    /* renamed from: k */
    public final /* synthetic */ Sink f26076k;

    public AsyncTimeout2(AsyncTimeout asyncTimeout, Sink sink) {
        this.f26075j = asyncTimeout;
        this.f26076k = sink;
    }

    @Override // p615g0.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        AsyncTimeout asyncTimeout = this.f26075j;
        asyncTimeout.m10424i();
        try {
            this.f26076k.close();
            if (asyncTimeout.m10425j()) {
                throw asyncTimeout.mo10296k(null);
            }
        } catch (IOException e) {
            if (!asyncTimeout.m10425j()) {
                throw e;
            }
            throw asyncTimeout.mo10296k(e);
        } finally {
            asyncTimeout.m10425j();
        }
    }

    @Override // p615g0.Sink, java.io.Flushable
    public void flush() throws IOException {
        AsyncTimeout asyncTimeout = this.f26075j;
        asyncTimeout.m10424i();
        try {
            this.f26076k.flush();
            if (asyncTimeout.m10425j()) {
                throw asyncTimeout.mo10296k(null);
            }
        } catch (IOException e) {
            if (!asyncTimeout.m10425j()) {
                throw e;
            }
            throw asyncTimeout.mo10296k(e);
        } finally {
            asyncTimeout.m10425j();
        }
    }

    @Override // p615g0.Sink
    public Timeout2 timeout() {
        return this.f26075j;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("AsyncTimeout.sink(");
        sbM833U.append(this.f26076k);
        sbM833U.append(')');
        return sbM833U.toString();
    }

    @Override // p615g0.Sink
    public void write(Buffer3 buffer3, long j) throws IOException {
        Intrinsics3.checkParameterIsNotNull(buffer3, "source");
        C3404f.m4192B(buffer3.f26080k, 0L, j);
        while (true) {
            long j2 = 0;
            if (j <= 0) {
                return;
            }
            Segment2 segment2 = buffer3.f26079j;
            if (segment2 == null) {
                Intrinsics3.throwNpe();
            }
            while (true) {
                if (j2 >= 65536) {
                    break;
                }
                j2 += segment2.f26120c - segment2.f26119b;
                if (j2 >= j) {
                    j2 = j;
                    break;
                } else {
                    segment2 = segment2.f26123f;
                    if (segment2 == null) {
                        Intrinsics3.throwNpe();
                    }
                }
            }
            AsyncTimeout asyncTimeout = this.f26075j;
            asyncTimeout.m10424i();
            try {
                this.f26076k.write(buffer3, j2);
                if (asyncTimeout.m10425j()) {
                    throw asyncTimeout.mo10296k(null);
                }
                j -= j2;
            } catch (IOException e) {
                if (!asyncTimeout.m10425j()) {
                    throw e;
                }
                throw asyncTimeout.mo10296k(e);
            } finally {
                asyncTimeout.m10425j();
            }
        }
    }
}
