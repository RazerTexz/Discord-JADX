package p637j0.p642l.p643a;

import p637j0.p642l.p643a.OperatorReplay;
import p658rx.functions.Func0;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: j0.l.a.k1, reason: use source file name */
/* JADX INFO: compiled from: OperatorReplay.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OperatorReplay2<T> implements Func0<OperatorReplay.e<T>> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ int f26890j;

    public OperatorReplay2(int i) {
        this.f26890j = i;
    }

    @Override // p658rx.functions.Func0, java.util.concurrent.Callable
    public Object call() {
        return new OperatorReplay.g(this.f26890j);
    }
}
