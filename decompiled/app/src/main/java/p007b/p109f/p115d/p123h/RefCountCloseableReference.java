package p007b.p109f.p115d.p123h;

import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.SharedReference;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;

/* JADX INFO: renamed from: b.f.d.h.e, reason: use source file name */
/* JADX INFO: compiled from: RefCountCloseableReference.java */
/* JADX INFO: loaded from: classes.dex */
public class RefCountCloseableReference<T> extends CloseableReference<T> {
    public RefCountCloseableReference(SharedReference<T> sharedReference, CloseableReference.InterfaceC10637c interfaceC10637c, Throwable th) {
        super(sharedReference, interfaceC10637c, th);
    }

    @Override // com.facebook.common.references.CloseableReference
    /* JADX INFO: renamed from: b */
    public CloseableReference<T> mo999b() {
        AnimatableValueParser.m419B(m8643x());
        return new RefCountCloseableReference(this.f19443o, this.f19444p, this.f19445q);
    }

    @Override // com.facebook.common.references.CloseableReference
    public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        return mo999b();
    }

    public RefCountCloseableReference(T t, ResourceReleaser<T> resourceReleaser, CloseableReference.InterfaceC10637c interfaceC10637c, Throwable th) {
        super(t, resourceReleaser, interfaceC10637c, th);
    }
}
