package p637j0.p642l.p643a;

import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p637j0.p641k.Func1;
import p637j0.p652o.C12774l;
import p658rx.Observable;
import p658rx.Producer;
import p658rx.Subscriber;
import p658rx.exceptions.OnErrorThrowable;

/* compiled from: OnSubscribeFilter.java */
/* renamed from: j0.l.a.l, reason: use source file name */
/* loaded from: classes3.dex */
public final class OnSubscribeFilter<T> implements Observable.InterfaceC13005a<T> {

    /* renamed from: j */
    public final Observable<T> f26894j;

    /* renamed from: k */
    public final Func1<? super T, Boolean> f26895k;

    /* compiled from: OnSubscribeFilter.java */
    /* renamed from: j0.l.a.l$a */
    public static final class a<T> extends Subscriber<T> {

        /* renamed from: j */
        public final Subscriber<? super T> f26896j;

        /* renamed from: k */
        public final Func1<? super T, Boolean> f26897k;

        /* renamed from: l */
        public boolean f26898l;

        public a(Subscriber<? super T> subscriber, Func1<? super T, Boolean> func1) {
            this.f26896j = subscriber;
            this.f26897k = func1;
            request(0L);
        }

        @Override // p637j0.Observer2
        public void onCompleted() {
            if (this.f26898l) {
                return;
            }
            this.f26896j.onCompleted();
        }

        @Override // p637j0.Observer2
        public void onError(Throwable th) {
            if (this.f26898l) {
                C12774l.m10863b(th);
            } else {
                this.f26898l = true;
                this.f26896j.onError(th);
            }
        }

        @Override // p637j0.Observer2
        public void onNext(T t) {
            try {
                if (this.f26897k.call(t).booleanValue()) {
                    this.f26896j.onNext(t);
                } else {
                    request(1L);
                }
            } catch (Throwable th) {
                C3404f.m4325o1(th);
                unsubscribe();
                onError(OnErrorThrowable.m11126a(th, t));
            }
        }

        @Override // p658rx.Subscriber
        public void setProducer(Producer producer) {
            super.setProducer(producer);
            this.f26896j.setProducer(producer);
        }
    }

    public OnSubscribeFilter(Observable<T> observable, Func1<? super T, Boolean> func1) {
        this.f26894j = observable;
        this.f26895k = func1;
    }

    @Override // p658rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        a aVar = new a(subscriber, this.f26895k);
        subscriber.add(aVar);
        this.f26894j.m11107i0(aVar);
    }
}
