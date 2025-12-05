package p615g0;

import java.io.IOException;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: AsyncTimeout.kt */
/* renamed from: g0.d, reason: use source file name */
/* loaded from: classes3.dex */
public final class AsyncTimeout3 implements Source2 {

    /* renamed from: j */
    public final /* synthetic */ AsyncTimeout f26077j;

    /* renamed from: k */
    public final /* synthetic */ Source2 f26078k;

    public AsyncTimeout3(AsyncTimeout asyncTimeout, Source2 source2) {
        this.f26077j = asyncTimeout;
        this.f26078k = source2;
    }

    @Override // p615g0.Source2, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        AsyncTimeout asyncTimeout = this.f26077j;
        asyncTimeout.m10424i();
        try {
            this.f26078k.close();
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

    @Override // p615g0.Source2
    /* renamed from: i0 */
    public long mo10176i0(Buffer3 buffer3, long j) throws IOException {
        Intrinsics3.checkParameterIsNotNull(buffer3, "sink");
        AsyncTimeout asyncTimeout = this.f26077j;
        asyncTimeout.m10424i();
        try {
            long jMo10176i0 = this.f26078k.mo10176i0(buffer3, j);
            if (asyncTimeout.m10425j()) {
                throw asyncTimeout.mo10296k(null);
            }
            return jMo10176i0;
        } catch (IOException e) {
            if (asyncTimeout.m10425j()) {
                throw asyncTimeout.mo10296k(e);
            }
            throw e;
        } finally {
            asyncTimeout.m10425j();
        }
    }

    @Override // p615g0.Source2
    public Timeout2 timeout() {
        return this.f26077j;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("AsyncTimeout.source(");
        sbM833U.append(this.f26078k);
        sbM833U.append(')');
        return sbM833U.toString();
    }
}
