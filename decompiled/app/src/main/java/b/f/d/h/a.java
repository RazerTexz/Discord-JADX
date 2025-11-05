package b.f.d.h;

import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.SharedReference;

/* compiled from: DefaultCloseableReference.java */
/* loaded from: classes.dex */
public class a<T> extends CloseableReference<T> {
    public a(SharedReference<T> sharedReference, CloseableReference.c cVar, Throwable th) {
        super(sharedReference, cVar, th);
    }

    @Override // com.facebook.common.references.CloseableReference
    public CloseableReference<T> b() {
        b.c.a.a0.d.B(x());
        return new a(this.o, this.p, this.q != null ? new Throwable(this.q) : null);
    }

    @Override // com.facebook.common.references.CloseableReference
    public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        return b();
    }

    public void finalize() throws Throwable {
        try {
            synchronized (this) {
                if (this.n) {
                    return;
                }
                T tC = this.o.c();
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(System.identityHashCode(this));
                objArr[1] = Integer.valueOf(System.identityHashCode(this.o));
                objArr[2] = tC == null ? null : tC.getClass().getName();
                b.f.d.e.a.o("DefaultCloseableReference", "Finalized without closing: %x %x (type = %s)", objArr);
                this.p.a(this.o, this.q);
                close();
            }
        } finally {
            super.finalize();
        }
    }

    public a(T t, f<T> fVar, CloseableReference.c cVar, Throwable th) {
        super(t, fVar, cVar, th);
    }
}
