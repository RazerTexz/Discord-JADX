package p637j0.p642l.p643a;

import java.util.Arrays;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p637j0.Observer2;
import p637j0.p652o.C12774l;
import p658rx.Observable;
import p658rx.Subscriber;
import p658rx.exceptions.CompositeException;

/* JADX INFO: renamed from: j0.l.a.k, reason: use source file name */
/* JADX INFO: compiled from: OnSubscribeDoOnEach.java */
/* JADX INFO: loaded from: classes3.dex */
public class OnSubscribeDoOnEach<T> implements Observable.InterfaceC13005a<T> {

    /* JADX INFO: renamed from: j */
    public final Observer2<? super T> f26881j;

    /* JADX INFO: renamed from: k */
    public final Observable<T> f26882k;

    /* JADX INFO: renamed from: j0.l.a.k$a */
    /* JADX INFO: compiled from: OnSubscribeDoOnEach.java */
    public static final class a<T> extends Subscriber<T> {

        /* JADX INFO: renamed from: j */
        public final Subscriber<? super T> f26883j;

        /* JADX INFO: renamed from: k */
        public final Observer2<? super T> f26884k;

        /* JADX INFO: renamed from: l */
        public boolean f26885l;

        public a(Subscriber<? super T> subscriber, Observer2<? super T> observer2) {
            super(subscriber);
            this.f26883j = subscriber;
            this.f26884k = observer2;
        }

        @Override // p637j0.Observer2
        public void onCompleted() {
            if (this.f26885l) {
                return;
            }
            try {
                this.f26884k.onCompleted();
                this.f26885l = true;
                this.f26883j.onCompleted();
            } catch (Throwable th) {
                C3404f.m4325o1(th);
                onError(th);
            }
        }

        @Override // p637j0.Observer2
        public void onError(Throwable th) {
            if (this.f26885l) {
                C12774l.m10863b(th);
                return;
            }
            this.f26885l = true;
            try {
                this.f26884k.onError(th);
                this.f26883j.onError(th);
            } catch (Throwable th2) {
                C3404f.m4325o1(th2);
                this.f26883j.onError(new CompositeException(Arrays.asList(th, th2)));
            }
        }

        @Override // p637j0.Observer2
        public void onNext(T t) {
            if (this.f26885l) {
                return;
            }
            try {
                this.f26884k.onNext(t);
                this.f26883j.onNext(t);
            } catch (Throwable th) {
                C3404f.m4329p1(th, this, t);
            }
        }
    }

    public OnSubscribeDoOnEach(Observable<T> observable, Observer2<? super T> observer2) {
        this.f26882k = observable;
        this.f26881j = observer2;
    }

    @Override // p658rx.functions.Action1
    public void call(Object obj) {
        this.f26882k.m11107i0(new a((Subscriber) obj, this.f26881j));
    }
}
