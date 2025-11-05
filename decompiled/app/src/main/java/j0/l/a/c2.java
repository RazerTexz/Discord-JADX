package j0.l.a;

import rx.Observable;
import rx.Subscriber;

/* compiled from: OperatorTake.java */
/* loaded from: classes3.dex */
public final class c2<T> implements Observable.b<T, T> {
    public final int j;

    public c2(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(b.d.b.a.a.q("limit >= 0 required but it was ", i));
        }
        this.j = i;
    }

    @Override // j0.k.b
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        b2 b2Var = new b2(this, subscriber);
        if (this.j == 0) {
            subscriber.onCompleted();
            b2Var.unsubscribe();
        }
        subscriber.add(b2Var);
        return b2Var;
    }
}
