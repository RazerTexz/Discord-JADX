package p007b.p109f.p115d.p123h;

import com.facebook.common.references.CloseableReference;

/* JADX INFO: renamed from: b.f.d.h.d, reason: use source file name */
/* JADX INFO: compiled from: NoOpCloseableReference.java */
/* JADX INFO: loaded from: classes.dex */
public class NoOpCloseableReference<T> extends CloseableReference<T> {
    public NoOpCloseableReference(T t, ResourceReleaser<T> resourceReleaser, CloseableReference.InterfaceC10637c interfaceC10637c, Throwable th) {
        super(t, resourceReleaser, interfaceC10637c, th);
    }

    @Override // com.facebook.common.references.CloseableReference
    /* JADX INFO: renamed from: b */
    public CloseableReference<T> mo999b() {
        return this;
    }

    @Override // com.facebook.common.references.CloseableReference
    public Object clone() throws CloneNotSupportedException {
        return this;
    }

    @Override // com.facebook.common.references.CloseableReference, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
