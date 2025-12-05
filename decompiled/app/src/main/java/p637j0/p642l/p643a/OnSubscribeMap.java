package p637j0.p642l.p643a;

import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p637j0.p641k.Func1;
import p637j0.p652o.C12774l;
import p658rx.Observable;
import p658rx.Producer;
import p658rx.Subscriber;
import p658rx.exceptions.OnErrorThrowable;

/* compiled from: OnSubscribeMap.java */
/* renamed from: j0.l.a.s, reason: use source file name */
/* loaded from: classes3.dex */
public final class OnSubscribeMap<T, R> implements Observable.InterfaceC13005a<R> {

    /* renamed from: j */
    public final Observable<T> f27031j;

    /* renamed from: k */
    public final Func1<? super T, ? extends R> f27032k;

    /* compiled from: OnSubscribeMap.java */
    /* renamed from: j0.l.a.s$a */
    public static final class a<T, R> extends Subscriber<T> {

        /* renamed from: j */
        public final Subscriber<? super R> f27033j;

        /* renamed from: k */
        public final Func1<? super T, ? extends R> f27034k;

        /* renamed from: l */
        public boolean f27035l;

        public a(Subscriber<? super R> subscriber, Func1<? super T, ? extends R> func1) {
            this.f27033j = subscriber;
            this.f27034k = func1;
        }

        @Override // p637j0.Observer2
        public void onCompleted() {
            if (this.f27035l) {
                return;
            }
            this.f27033j.onCompleted();
        }

        @Override // p637j0.Observer2
        public void onError(Throwable th) {
            if (this.f27035l) {
                C12774l.m10863b(th);
            } else {
                this.f27035l = true;
                this.f27033j.onError(th);
            }
        }

        @Override // p637j0.Observer2
        public void onNext(T t) {
            try {
                this.f27033j.onNext(this.f27034k.call(t));
            } catch (Throwable th) {
                C3404f.m4325o1(th);
                unsubscribe();
                onError(OnErrorThrowable.m11126a(th, t));
            }
        }

        @Override // p658rx.Subscriber
        public void setProducer(Producer producer) {
            this.f27033j.setProducer(producer);
        }
    }

    public OnSubscribeMap(Observable<T> observable, Func1<? super T, ? extends R> func1) {
        this.f27031j = observable;
        this.f27032k = func1;
    }

    @Override // p658rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        a aVar = new a(subscriber, this.f27032k);
        subscriber.add(aVar);
        this.f27031j.m11107i0(aVar);
    }
}
