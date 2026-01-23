package p615g0;

import java.io.IOException;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: g0.j, reason: use source file name */
/* JADX INFO: compiled from: ForwardingSource.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ForwardingSource implements Source2 {

    /* JADX INFO: renamed from: j */
    public final Source2 f26093j;

    public ForwardingSource(Source2 source2) {
        Intrinsics3.checkParameterIsNotNull(source2, "delegate");
        this.f26093j = source2;
    }

    @Override // p615g0.Source2, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f26093j.close();
    }

    @Override // p615g0.Source2
    public Timeout2 timeout() {
        return this.f26093j.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.f26093j + ')';
    }
}
