package g0;

import java.io.IOException;

/* compiled from: ForwardingSink.kt */
/* loaded from: classes3.dex */
public abstract class i implements v {
    private final v delegate;

    public i(v vVar) {
        d0.z.d.m.checkParameterIsNotNull(vVar, "delegate");
        this.delegate = vVar;
    }

    /* renamed from: -deprecated_delegate, reason: not valid java name */
    public final v m114deprecated_delegate() {
        return this.delegate;
    }

    @Override // g0.v, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    public final v delegate() {
        return this.delegate;
    }

    @Override // g0.v, java.io.Flushable
    public void flush() throws IOException {
        this.delegate.flush();
    }

    @Override // g0.v
    public y timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }

    @Override // g0.v
    public void write(e eVar, long j) throws IOException {
        d0.z.d.m.checkParameterIsNotNull(eVar, "source");
        this.delegate.write(eVar, j);
    }
}
