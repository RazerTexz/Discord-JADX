package b.f.d.h;

import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.SharedReference;

/* compiled from: RefCountCloseableReference.java */
/* loaded from: classes.dex */
public class e<T> extends CloseableReference<T> {
    public e(SharedReference<T> sharedReference, CloseableReference.c cVar, Throwable th) {
        super(sharedReference, cVar, th);
    }

    @Override // com.facebook.common.references.CloseableReference
    public CloseableReference<T> b() {
        b.c.a.a0.d.B(x());
        return new e(this.o, this.p, this.q);
    }

    @Override // com.facebook.common.references.CloseableReference
    public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        return b();
    }

    public e(T t, f<T> fVar, CloseableReference.c cVar, Throwable th) {
        super(t, fVar, cVar, th);
    }
}
