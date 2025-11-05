package j0.l.a;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func2;

/* compiled from: OperatorTakeWhile.java */
/* loaded from: classes3.dex */
public final class i2<T> implements Observable.b<T, T> {
    public final Func2<? super T, ? super Integer, Boolean> j;

    /* compiled from: OperatorTakeWhile.java */
    public class a implements Func2<T, Integer, Boolean> {
        public final /* synthetic */ j0.k.b j;

        public a(j0.k.b bVar) {
            this.j = bVar;
        }

        @Override // rx.functions.Func2
        public Boolean call(Object obj, Integer num) {
            return (Boolean) this.j.call(obj);
        }
    }

    public i2(j0.k.b<? super T, Boolean> bVar) {
        this.j = new a(bVar);
    }

    @Override // j0.k.b
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        j2 j2Var = new j2(this, subscriber, false, subscriber);
        subscriber.add(j2Var);
        return j2Var;
    }
}
