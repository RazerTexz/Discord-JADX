package p007b.p109f.p115d.p123h;

import com.facebook.common.references.CloseableReference;
import p007b.p109f.p115d.p120e.FLog;

/* compiled from: FinalizerCloseableReference.java */
/* renamed from: b.f.d.h.b, reason: use source file name */
/* loaded from: classes.dex */
public class FinalizerCloseableReference<T> extends CloseableReference<T> {
    public FinalizerCloseableReference(T t, ResourceReleaser<T> resourceReleaser, CloseableReference.InterfaceC10637c interfaceC10637c, Throwable th) {
        super(t, resourceReleaser, interfaceC10637c, th);
    }

    @Override // com.facebook.common.references.CloseableReference
    /* renamed from: b */
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

    public void finalize() throws Throwable {
        try {
            synchronized (this) {
                if (this.f19442n) {
                    return;
                }
                T tM8646c = this.f19443o.m8646c();
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(System.identityHashCode(this));
                objArr[1] = Integer.valueOf(System.identityHashCode(this.f19443o));
                objArr[2] = tM8646c == null ? null : tM8646c.getClass().getName();
                FLog.m987o("FinalizerCloseableReference", "Finalized without closing: %x %x (type = %s)", objArr);
                this.f19443o.m8644a();
            }
        } finally {
            super.finalize();
        }
    }
}
