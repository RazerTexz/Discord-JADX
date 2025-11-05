package j0.l.a;

import androidx.recyclerview.widget.RecyclerView;
import j0.l.a.a;
import java.util.HashMap;
import java.util.Map;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func0;

/* compiled from: OnSubscribeToMap.java */
/* loaded from: classes3.dex */
public final class l0<T, K, V> implements Observable.a<Map<K, V>>, Func0<Map<K, V>> {
    public final Observable<T> j;
    public final j0.k.b<? super T, ? extends K> k;
    public final j0.k.b<? super T, ? extends V> l;
    public final Func0<? extends Map<K, V>> m = this;

    /* compiled from: OnSubscribeToMap.java */
    public static final class a<T, K, V> extends b<T, Map<K, V>> {
        public final j0.k.b<? super T, ? extends K> o;
        public final j0.k.b<? super T, ? extends V> p;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Subscriber<? super Map<K, V>> subscriber, Map<K, V> map, j0.k.b<? super T, ? extends K> bVar, j0.k.b<? super T, ? extends V> bVar2) {
            super(subscriber);
            this.l = map;
            this.k = true;
            this.o = bVar;
            this.p = bVar2;
        }

        @Override // j0.g
        public void onNext(T t) {
            if (this.n) {
                return;
            }
            try {
                ((Map) this.l).put(this.o.call(t), this.p.call(t));
            } catch (Throwable th) {
                b.i.a.f.e.o.f.o1(th);
                unsubscribe();
                onError(th);
            }
        }

        @Override // rx.Subscriber
        public void onStart() {
            request(RecyclerView.FOREVER_NS);
        }
    }

    public l0(Observable<T> observable, j0.k.b<? super T, ? extends K> bVar, j0.k.b<? super T, ? extends V> bVar2) {
        this.j = observable;
        this.k = bVar;
        this.l = bVar2;
    }

    @Override // rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        try {
            a aVar = new a(subscriber, this.m.call(), this.k, this.l);
            Observable<T> observable = this.j;
            Subscriber<? super R> subscriber2 = aVar.j;
            subscriber2.add(aVar);
            subscriber2.setProducer(new a.C0621a(aVar));
            observable.i0(aVar);
        } catch (Throwable th) {
            b.i.a.f.e.o.f.o1(th);
            subscriber.onError(th);
        }
    }

    @Override // rx.functions.Func0, java.util.concurrent.Callable
    public Object call() {
        return new HashMap();
    }
}
