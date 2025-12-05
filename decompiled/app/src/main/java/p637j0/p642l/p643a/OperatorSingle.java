package p637j0.p642l.p643a;

import java.util.NoSuchElementException;
import p637j0.p642l.p644b.SingleProducer;
import p637j0.p652o.C12774l;
import p658rx.Observable;
import p658rx.Subscriber;

/* compiled from: OperatorSingle.java */
/* renamed from: j0.l.a.r1, reason: use source file name */
/* loaded from: classes3.dex */
public final class OperatorSingle<T> implements Observable.InterfaceC13006b<T, T> {

    /* compiled from: OperatorSingle.java */
    /* renamed from: j0.l.a.r1$a */
    public static final class a {

        /* renamed from: a */
        public static final OperatorSingle<?> f27024a = new OperatorSingle<>();
    }

    /* compiled from: OperatorSingle.java */
    /* renamed from: j0.l.a.r1$b */
    public static final class b<T> extends Subscriber<T> {

        /* renamed from: j */
        public final Subscriber<? super T> f27025j;

        /* renamed from: k */
        public final boolean f27026k;

        /* renamed from: l */
        public final T f27027l;

        /* renamed from: m */
        public T f27028m;

        /* renamed from: n */
        public boolean f27029n;

        /* renamed from: o */
        public boolean f27030o;

        public b(Subscriber<? super T> subscriber, boolean z2, T t) {
            this.f27025j = subscriber;
            this.f27026k = z2;
            this.f27027l = t;
            request(2L);
        }

        @Override // p637j0.Observer2
        public void onCompleted() {
            if (this.f27030o) {
                return;
            }
            if (this.f27029n) {
                this.f27025j.setProducer(new SingleProducer(this.f27025j, this.f27028m));
            } else if (this.f27026k) {
                this.f27025j.setProducer(new SingleProducer(this.f27025j, this.f27027l));
            } else {
                this.f27025j.onError(new NoSuchElementException("Sequence contains no elements"));
            }
        }

        @Override // p637j0.Observer2
        public void onError(Throwable th) {
            if (this.f27030o) {
                C12774l.m10863b(th);
            } else {
                this.f27025j.onError(th);
            }
        }

        @Override // p637j0.Observer2
        public void onNext(T t) {
            if (this.f27030o) {
                return;
            }
            if (!this.f27029n) {
                this.f27028m = t;
                this.f27029n = true;
            } else {
                this.f27030o = true;
                this.f27025j.onError(new IllegalArgumentException("Sequence contains too many elements"));
                unsubscribe();
            }
        }
    }

    @Override // p637j0.p641k.Func1
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        b bVar = new b(subscriber, false, null);
        subscriber.add(bVar);
        return bVar;
    }
}
