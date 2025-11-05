package j0.l.a;

import java.util.Comparator;
import java.util.List;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func2;

/* compiled from: OperatorToObservableSortedList.java */
/* loaded from: classes3.dex */
public final class o2<T> implements Observable.b<List<T>, T> {
    public final Comparator<? super T> j;

    /* compiled from: OperatorToObservableSortedList.java */
    public class a implements Comparator<T> {
        public final /* synthetic */ Func2 j;

        public a(o2 o2Var, Func2 func2) {
            this.j = func2;
        }

        @Override // java.util.Comparator
        public int compare(T t, T t2) {
            return ((Integer) this.j.call(t, t2)).intValue();
        }
    }

    public o2(Func2<? super T, ? super T, Integer> func2, int i) {
        this.j = new a(this, func2);
    }

    @Override // j0.k.b
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        j0.l.b.b bVar = new j0.l.b.b(subscriber);
        p2 p2Var = new p2(this, bVar, subscriber);
        subscriber.add(p2Var);
        subscriber.setProducer(bVar);
        return p2Var;
    }
}
