package p637j0.p642l.p643a;

import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;
import java.util.Map;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p637j0.p641k.Func1;
import p637j0.p642l.p643a.DeferredScalarSubscriber;
import p658rx.Observable;
import p658rx.Subscriber;
import p658rx.functions.Func0;

/* JADX INFO: renamed from: j0.l.a.l0, reason: use source file name */
/* JADX INFO: compiled from: OnSubscribeToMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OnSubscribeToMap<T, K, V> implements Observable.InterfaceC13005a<Map<K, V>>, Func0<Map<K, V>> {

    /* JADX INFO: renamed from: j */
    public final Observable<T> f26899j;

    /* JADX INFO: renamed from: k */
    public final Func1<? super T, ? extends K> f26900k;

    /* JADX INFO: renamed from: l */
    public final Func1<? super T, ? extends V> f26901l;

    /* JADX INFO: renamed from: m */
    public final Func0<? extends Map<K, V>> f26902m = this;

    /* JADX INFO: renamed from: j0.l.a.l0$a */
    /* JADX INFO: compiled from: OnSubscribeToMap.java */
    public static final class a<T, K, V> extends DeferredScalarSubscriberSafe<T, Map<K, V>> {

        /* JADX INFO: renamed from: o */
        public final Func1<? super T, ? extends K> f26903o;

        /* JADX INFO: renamed from: p */
        public final Func1<? super T, ? extends V> f26904p;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Subscriber<? super Map<K, V>> subscriber, Map<K, V> map, Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func12) {
            super(subscriber);
            this.f26721l = map;
            this.f26720k = true;
            this.f26903o = func1;
            this.f26904p = func12;
        }

        @Override // p637j0.Observer2
        public void onNext(T t) {
            if (this.f26737n) {
                return;
            }
            try {
                ((Map) this.f26721l).put(this.f26903o.call(t), this.f26904p.call(t));
            } catch (Throwable th) {
                C3404f.m4325o1(th);
                unsubscribe();
                onError(th);
            }
        }

        @Override // p658rx.Subscriber
        public void onStart() {
            request(RecyclerView.FOREVER_NS);
        }
    }

    public OnSubscribeToMap(Observable<T> observable, Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func12) {
        this.f26899j = observable;
        this.f26900k = func1;
        this.f26901l = func12;
    }

    @Override // p658rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        try {
            a aVar = new a(subscriber, this.f26902m.call(), this.f26900k, this.f26901l);
            Observable<T> observable = this.f26899j;
            Subscriber<? super R> subscriber2 = aVar.f26719j;
            subscriber2.add(aVar);
            subscriber2.setProducer(new DeferredScalarSubscriber.a(aVar));
            observable.m11107i0(aVar);
        } catch (Throwable th) {
            C3404f.m4325o1(th);
            subscriber.onError(th);
        }
    }

    @Override // p658rx.functions.Func0, java.util.concurrent.Callable
    public Object call() {
        return new HashMap();
    }
}
