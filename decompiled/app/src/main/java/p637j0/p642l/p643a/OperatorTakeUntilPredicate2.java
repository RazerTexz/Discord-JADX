package p637j0.p642l.p643a;

import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p637j0.p641k.Func1;
import p658rx.Observable;
import p658rx.Subscriber;

/* JADX INFO: renamed from: j0.l.a.h2, reason: use source file name */
/* JADX INFO: compiled from: OperatorTakeUntilPredicate.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OperatorTakeUntilPredicate2<T> implements Observable.InterfaceC13006b<T, T> {

    /* JADX INFO: renamed from: j */
    public final Func1<? super T, Boolean> f26841j;

    /* JADX INFO: renamed from: j0.l.a.h2$a */
    /* JADX INFO: compiled from: OperatorTakeUntilPredicate.java */
    public final class a extends Subscriber<T> {

        /* JADX INFO: renamed from: j */
        public final Subscriber<? super T> f26842j;

        /* JADX INFO: renamed from: k */
        public boolean f26843k;

        public a(Subscriber<? super T> subscriber) {
            this.f26842j = subscriber;
        }

        @Override // p637j0.Observer2
        public void onCompleted() {
            if (this.f26843k) {
                return;
            }
            this.f26842j.onCompleted();
        }

        @Override // p637j0.Observer2
        public void onError(Throwable th) {
            if (this.f26843k) {
                return;
            }
            this.f26842j.onError(th);
        }

        @Override // p637j0.Observer2
        public void onNext(T t) {
            this.f26842j.onNext(t);
            try {
                if (OperatorTakeUntilPredicate2.this.f26841j.call(t).booleanValue()) {
                    this.f26843k = true;
                    this.f26842j.onCompleted();
                    unsubscribe();
                }
            } catch (Throwable th) {
                this.f26843k = true;
                C3404f.m4329p1(th, this.f26842j, t);
                unsubscribe();
            }
        }
    }

    public OperatorTakeUntilPredicate2(Func1<? super T, Boolean> func1) {
        this.f26841j = func1;
    }

    @Override // p637j0.p641k.Func1
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        a aVar = new a(subscriber);
        subscriber.add(aVar);
        subscriber.setProducer(new OperatorTakeUntilPredicate(this, aVar));
        return aVar;
    }
}
