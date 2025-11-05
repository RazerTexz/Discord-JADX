package b.a.d;

import b.a.d.o;
import rx.Observable;

/* compiled from: AppTransformers.kt */
/* loaded from: classes.dex */
public final class t<T, R> implements j0.k.b<T, Observable<? extends T>> {
    public final /* synthetic */ o.d j;

    public t(o.d dVar) {
        this.j = dVar;
    }

    @Override // j0.k.b
    public Object call(Object obj) {
        if (((Boolean) this.j.j.invoke(obj)).booleanValue()) {
            return new j0.l.e.k(obj);
        }
        j0.l.e.k kVar = new j0.l.e.k(this.j.k);
        o.d dVar = this.j;
        return kVar.q(dVar.l, dVar.m);
    }
}
