package p007b.p008a.p018d;

import p007b.p008a.p018d.C0879o;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;

/* JADX INFO: renamed from: b.a.d.t */
/* JADX INFO: compiled from: AppTransformers.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0884t<T, R> implements Func1<T, Observable<? extends T>> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C0879o.d f580j;

    public C0884t(C0879o.d dVar) {
        this.f580j = dVar;
    }

    @Override // p637j0.p641k.Func1
    public Object call(Object obj) {
        if (((Boolean) this.f580j.f571j.invoke(obj)).booleanValue()) {
            return new ScalarSynchronousObservable(obj);
        }
        ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(this.f580j.f572k);
        C0879o.d dVar = this.f580j;
        return scalarSynchronousObservable.m11111q(dVar.f573l, dVar.f574m);
    }
}
