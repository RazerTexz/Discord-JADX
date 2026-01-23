package p637j0.p642l.p643a;

import p637j0.p641k.Func1;
import p658rx.Observable;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: j0.l.a.d1, reason: use source file name */
/* JADX INFO: compiled from: OperatorOnErrorResumeNextViaFunction.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OperatorOnErrorResumeNextViaFunction2<T> implements Func1<Throwable, Observable<? extends T>> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ Observable f26766j;

    public OperatorOnErrorResumeNextViaFunction2(Observable observable) {
        this.f26766j = observable;
    }

    @Override // p637j0.p641k.Func1
    public Object call(Throwable th) {
        return this.f26766j;
    }
}
