package p007b.p008a.p018d;

import p637j0.p641k.Func1;
import p658rx.Observable;

/* compiled from: AppTransformers.kt */
/* renamed from: b.a.d.z */
/* loaded from: classes.dex */
public final class C0890z<T, R> implements Func1<T, Observable<? extends R>> {

    /* renamed from: j */
    public final /* synthetic */ C0853a0 f594j;

    public C0890z(C0853a0 c0853a0) {
        this.f594j = c0853a0;
    }

    @Override // p637j0.p641k.Func1
    public Object call(Object obj) {
        return ((Boolean) this.f594j.f499j.invoke(obj)).booleanValue() ? (Observable) this.f594j.f500k.invoke(obj) : (Observable) this.f594j.f501l.invoke(obj);
    }
}
