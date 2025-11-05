package j0.l.a;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.MissingBackpressureException;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.SerialSubscription;

/* compiled from: OnSubscribeConcatMap.java */
/* loaded from: classes3.dex */
public final class h<T, R> implements Observable.a<R> {
    public final Observable<? extends T> j;
    public final j0.k.b<? super T, ? extends Observable<? extends R>> k;

    /* compiled from: OnSubscribeConcatMap.java */
    public static final class a<T, R> implements Producer {
        public final R j;
        public final c<T, R> k;
        public boolean l;

        public a(R r, c<T, R> cVar) {
            this.j = r;
            this.k = cVar;
        }

        @Override // rx.Producer
        public void j(long j) {
            if (this.l || j <= 0) {
                return;
            }
            this.l = true;
            c<T, R> cVar = this.k;
            cVar.j.onNext(this.j);
            cVar.m.b(1L);
            cVar.f3773s = false;
            cVar.a();
        }
    }

    /* compiled from: OnSubscribeConcatMap.java */
    public static final class b<T, R> extends Subscriber<R> {
        public final c<T, R> j;
        public long k;

        public b(c<T, R> cVar) {
            this.j = cVar;
        }

        @Override // j0.g
        public void onCompleted() {
            c<T, R> cVar = this.j;
            long j = this.k;
            if (j != 0) {
                cVar.m.b(j);
            }
            cVar.f3773s = false;
            cVar.a();
        }

        @Override // j0.g
        public void onError(Throwable th) {
            c<T, R> cVar = this.j;
            long j = this.k;
            if (!j0.l.e.d.f(cVar.p, th)) {
                j0.o.l.b(th);
                return;
            }
            if (cVar.l == 0) {
                Throwable thH = j0.l.e.d.h(cVar.p);
                if (!j0.l.e.d.g(thH)) {
                    cVar.j.onError(thH);
                }
                cVar.unsubscribe();
                return;
            }
            if (j != 0) {
                cVar.m.b(j);
            }
            cVar.f3773s = false;
            cVar.a();
        }

        @Override // j0.g
        public void onNext(R r) {
            this.k++;
            this.j.j.onNext(r);
        }

        @Override // rx.Subscriber
        public void setProducer(Producer producer) {
            this.j.m.c(producer);
        }
    }

    /* compiled from: OnSubscribeConcatMap.java */
    public static final class c<T, R> extends Subscriber<T> {
        public final Subscriber<? super R> j;
        public final j0.k.b<? super T, ? extends Observable<? extends R>> k;
        public final int l;
        public final Queue<Object> n;
        public final SerialSubscription q;
        public volatile boolean r;

        /* renamed from: s, reason: collision with root package name */
        public volatile boolean f3773s;
        public final j0.l.b.a m = new j0.l.b.a();
        public final AtomicInteger o = new AtomicInteger();
        public final AtomicReference<Throwable> p = new AtomicReference<>();

        public c(Subscriber<? super R> subscriber, j0.k.b<? super T, ? extends Observable<? extends R>> bVar, int i, int i2) {
            this.j = subscriber;
            this.k = bVar;
            this.l = i2;
            this.n = j0.l.e.o.y.b() ? new j0.l.e.o.n<>(i) : new j0.l.e.n.c<>(i);
            this.q = new SerialSubscription();
            request(i);
        }

        public void a() {
            if (this.o.getAndIncrement() != 0) {
                return;
            }
            int i = this.l;
            while (!this.j.isUnsubscribed()) {
                if (!this.f3773s) {
                    if (i == 1 && this.p.get() != null) {
                        Throwable thH = j0.l.e.d.h(this.p);
                        if (j0.l.e.d.g(thH)) {
                            return;
                        }
                        this.j.onError(thH);
                        return;
                    }
                    boolean z2 = this.r;
                    Object objPoll = this.n.poll();
                    boolean z3 = objPoll == null;
                    if (z2 && z3) {
                        Throwable thH2 = j0.l.e.d.h(this.p);
                        if (thH2 == null) {
                            this.j.onCompleted();
                            return;
                        } else {
                            if (j0.l.e.d.g(thH2)) {
                                return;
                            }
                            this.j.onError(thH2);
                            return;
                        }
                    }
                    if (!z3) {
                        try {
                            Observable<? extends R> observableCall = this.k.call((Object) e.b(objPoll));
                            if (observableCall == null) {
                                b(new NullPointerException("The source returned by the mapper was null"));
                                return;
                            }
                            if (observableCall != j0.l.a.c.k) {
                                if (observableCall instanceof j0.l.e.k) {
                                    this.f3773s = true;
                                    this.m.c(new a(((j0.l.e.k) observableCall).l, this));
                                } else {
                                    b bVar = new b(this);
                                    this.q.a(bVar);
                                    if (bVar.isUnsubscribed()) {
                                        return;
                                    }
                                    this.f3773s = true;
                                    observableCall.i0(bVar);
                                }
                                request(1L);
                            } else {
                                request(1L);
                            }
                        } catch (Throwable th) {
                            b.i.a.f.e.o.f.o1(th);
                            b(th);
                            return;
                        }
                    }
                }
                if (this.o.decrementAndGet() == 0) {
                    return;
                }
            }
        }

        public void b(Throwable th) {
            unsubscribe();
            if (!j0.l.e.d.f(this.p, th)) {
                j0.o.l.b(th);
                return;
            }
            Throwable thH = j0.l.e.d.h(this.p);
            if (j0.l.e.d.g(thH)) {
                return;
            }
            this.j.onError(thH);
        }

        @Override // j0.g
        public void onCompleted() {
            this.r = true;
            a();
        }

        @Override // j0.g
        public void onError(Throwable th) {
            if (!j0.l.e.d.f(this.p, th)) {
                j0.o.l.b(th);
                return;
            }
            this.r = true;
            if (this.l != 0) {
                a();
                return;
            }
            Throwable thH = j0.l.e.d.h(this.p);
            if (!j0.l.e.d.g(thH)) {
                this.j.onError(thH);
            }
            this.q.j.unsubscribe();
        }

        @Override // j0.g
        public void onNext(T t) {
            Queue<Object> queue = this.n;
            if (t == null) {
                t = (T) e.f3771b;
            }
            if (queue.offer(t)) {
                a();
            } else {
                unsubscribe();
                onError(new MissingBackpressureException());
            }
        }
    }

    public h(Observable<? extends T> observable, j0.k.b<? super T, ? extends Observable<? extends R>> bVar, int i, int i2) {
        this.j = observable;
        this.k = bVar;
    }

    @Override // rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        c cVar = new c(new SerializedSubscriber(subscriber), this.k, 2, 0);
        subscriber.add(cVar);
        subscriber.add(cVar.q);
        subscriber.setProducer(new g(this, cVar));
        if (subscriber.isUnsubscribed()) {
            return;
        }
        this.j.i0(cVar);
    }
}
