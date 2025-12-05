package p007b.p109f.p115d.p123h;

import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.SharedReference;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p109f.p115d.p120e.FLog;

/* compiled from: DefaultCloseableReference.java */
/* renamed from: b.f.d.h.a, reason: use source file name */
/* loaded from: classes.dex */
public class DefaultCloseableReference<T> extends CloseableReference<T> {
    public DefaultCloseableReference(SharedReference<T> sharedReference, CloseableReference.InterfaceC10637c interfaceC10637c, Throwable th) {
        super(sharedReference, interfaceC10637c, th);
    }

    @Override // com.facebook.common.references.CloseableReference
    /* renamed from: b */
    public CloseableReference<T> mo999b() {
        AnimatableValueParser.m419B(m8643x());
        return new DefaultCloseableReference(this.f19443o, this.f19444p, this.f19445q != null ? new Throwable(this.f19445q) : null);
    }

    @Override // com.facebook.common.references.CloseableReference
    public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        return mo999b();
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
                FLog.m987o("DefaultCloseableReference", "Finalized without closing: %x %x (type = %s)", objArr);
                this.f19444p.mo1252a(this.f19443o, this.f19445q);
                close();
            }
        } finally {
            super.finalize();
        }
    }

    public DefaultCloseableReference(T t, ResourceReleaser<T> resourceReleaser, CloseableReference.InterfaceC10637c interfaceC10637c, Throwable th) {
        super(t, resourceReleaser, interfaceC10637c, th);
    }
}
