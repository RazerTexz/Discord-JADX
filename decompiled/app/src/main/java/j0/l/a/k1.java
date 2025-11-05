package j0.l.a;

import j0.l.a.j1;
import rx.functions.Func0;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: OperatorReplay.java */
/* loaded from: classes3.dex */
public final class k1<T> implements Func0<j1.e<T>> {
    public final /* synthetic */ int j;

    public k1(int i) {
        this.j = i;
    }

    @Override // rx.functions.Func0, java.util.concurrent.Callable
    public Object call() {
        return new j1.g(this.j);
    }
}
