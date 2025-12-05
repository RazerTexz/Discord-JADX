package p637j0.p642l.p643a;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p637j0.p641k.Func1;
import p637j0.p642l.p644b.ProducerArbiter;
import p637j0.p642l.p647e.ExceptionsUtils;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p637j0.p642l.p647e.p648n.SpscAtomicArrayQueue;
import p637j0.p642l.p647e.p649o.SpscArrayQueue;
import p637j0.p642l.p647e.p649o.UnsafeAccess;
import p637j0.p652o.C12774l;
import p658rx.Observable;
import p658rx.Producer;
import p658rx.Subscriber;
import p658rx.exceptions.MissingBackpressureException;
import p658rx.observers.SerializedSubscriber;
import p658rx.subscriptions.SerialSubscription;

/* compiled from: OnSubscribeConcatMap.java */
/* renamed from: j0.l.a.h, reason: use source file name */
/* loaded from: classes3.dex */
public final class OnSubscribeConcatMap2<T, R> implements Observable.InterfaceC13005a<R> {

    /* renamed from: j */
    public final Observable<? extends T> f26812j;

    /* renamed from: k */
    public final Func1<? super T, ? extends Observable<? extends R>> f26813k;

    /* compiled from: OnSubscribeConcatMap.java */
    /* renamed from: j0.l.a.h$a */
    public static final class a<T, R> implements Producer {

        /* renamed from: j */
        public final R f26814j;

        /* renamed from: k */
        public final c<T, R> f26815k;

        /* renamed from: l */
        public boolean f26816l;

        public a(R r, c<T, R> cVar) {
            this.f26814j = r;
            this.f26815k = cVar;
        }

        @Override // p658rx.Producer
        /* renamed from: j */
        public void mo10704j(long j) {
            if (this.f26816l || j <= 0) {
                return;
            }
            this.f26816l = true;
            c<T, R> cVar = this.f26815k;
            cVar.f26819j.onNext(this.f26814j);
            cVar.f26822m.m10796b(1L);
            cVar.f26828s = false;
            cVar.m10751a();
        }
    }

    /* compiled from: OnSubscribeConcatMap.java */
    /* renamed from: j0.l.a.h$b */
    public static final class b<T, R> extends Subscriber<R> {

        /* renamed from: j */
        public final c<T, R> f26817j;

        /* renamed from: k */
        public long f26818k;

        public b(c<T, R> cVar) {
            this.f26817j = cVar;
        }

        @Override // p637j0.Observer2
        public void onCompleted() {
            c<T, R> cVar = this.f26817j;
            long j = this.f26818k;
            if (j != 0) {
                cVar.f26822m.m10796b(j);
            }
            cVar.f26828s = false;
            cVar.m10751a();
        }

        @Override // p637j0.Observer2
        public void onError(Throwable th) {
            c<T, R> cVar = this.f26817j;
            long j = this.f26818k;
            if (!ExceptionsUtils.m10811f(cVar.f26825p, th)) {
                C12774l.m10863b(th);
                return;
            }
            if (cVar.f26821l == 0) {
                Throwable thM10813h = ExceptionsUtils.m10813h(cVar.f26825p);
                if (!ExceptionsUtils.m10812g(thM10813h)) {
                    cVar.f26819j.onError(thM10813h);
                }
                cVar.unsubscribe();
                return;
            }
            if (j != 0) {
                cVar.f26822m.m10796b(j);
            }
            cVar.f26828s = false;
            cVar.m10751a();
        }

        @Override // p637j0.Observer2
        public void onNext(R r) {
            this.f26818k++;
            this.f26817j.f26819j.onNext(r);
        }

        @Override // p658rx.Subscriber
        public void setProducer(Producer producer) {
            this.f26817j.f26822m.m10797c(producer);
        }
    }

    /* compiled from: OnSubscribeConcatMap.java */
    /* renamed from: j0.l.a.h$c */
    public static final class c<T, R> extends Subscriber<T> {

        /* renamed from: j */
        public final Subscriber<? super R> f26819j;

        /* renamed from: k */
        public final Func1<? super T, ? extends Observable<? extends R>> f26820k;

        /* renamed from: l */
        public final int f26821l;

        /* renamed from: n */
        public final Queue<Object> f26823n;

        /* renamed from: q */
        public final SerialSubscription f26826q;

        /* renamed from: r */
        public volatile boolean f26827r;

        /* renamed from: s */
        public volatile boolean f26828s;

        /* renamed from: m */
        public final ProducerArbiter f26822m = new ProducerArbiter();

        /* renamed from: o */
        public final AtomicInteger f26824o = new AtomicInteger();

        /* renamed from: p */
        public final AtomicReference<Throwable> f26825p = new AtomicReference<>();

        public c(Subscriber<? super R> subscriber, Func1<? super T, ? extends Observable<? extends R>> func1, int i, int i2) {
            this.f26819j = subscriber;
            this.f26820k = func1;
            this.f26821l = i2;
            this.f26823n = UnsafeAccess.m10858b() ? new SpscArrayQueue<>(i) : new SpscAtomicArrayQueue<>(i);
            this.f26826q = new SerialSubscription();
            request(i);
        }

        /* renamed from: a */
        public void m10751a() {
            if (this.f26824o.getAndIncrement() != 0) {
                return;
            }
            int i = this.f26821l;
            while (!this.f26819j.isUnsubscribed()) {
                if (!this.f26828s) {
                    if (i == 1 && this.f26825p.get() != null) {
                        Throwable thM10813h = ExceptionsUtils.m10813h(this.f26825p);
                        if (ExceptionsUtils.m10812g(thM10813h)) {
                            return;
                        }
                        this.f26819j.onError(thM10813h);
                        return;
                    }
                    boolean z2 = this.f26827r;
                    Object objPoll = this.f26823n.poll();
                    boolean z3 = objPoll == null;
                    if (z2 && z3) {
                        Throwable thM10813h2 = ExceptionsUtils.m10813h(this.f26825p);
                        if (thM10813h2 == null) {
                            this.f26819j.onCompleted();
                            return;
                        } else {
                            if (ExceptionsUtils.m10812g(thM10813h2)) {
                                return;
                            }
                            this.f26819j.onError(thM10813h2);
                            return;
                        }
                    }
                    if (!z3) {
                        try {
                            Observable<? extends R> observableCall = this.f26820k.call((Object) NotificationLite.m10745b(objPoll));
                            if (observableCall == null) {
                                m10752b(new NullPointerException("The source returned by the mapper was null"));
                                return;
                            }
                            if (observableCall != EmptyObservableHolder.f26751k) {
                                if (observableCall instanceof ScalarSynchronousObservable) {
                                    this.f26828s = true;
                                    this.f26822m.m10797c(new a(((ScalarSynchronousObservable) observableCall).f27288l, this));
                                } else {
                                    b bVar = new b(this);
                                    this.f26826q.m11139a(bVar);
                                    if (bVar.isUnsubscribed()) {
                                        return;
                                    }
                                    this.f26828s = true;
                                    observableCall.m11107i0(bVar);
                                }
                                request(1L);
                            } else {
                                request(1L);
                            }
                        } catch (Throwable th) {
                            C3404f.m4325o1(th);
                            m10752b(th);
                            return;
                        }
                    }
                }
                if (this.f26824o.decrementAndGet() == 0) {
                    return;
                }
            }
        }

        /* renamed from: b */
        public void m10752b(Throwable th) {
            unsubscribe();
            if (!ExceptionsUtils.m10811f(this.f26825p, th)) {
                C12774l.m10863b(th);
                return;
            }
            Throwable thM10813h = ExceptionsUtils.m10813h(this.f26825p);
            if (ExceptionsUtils.m10812g(thM10813h)) {
                return;
            }
            this.f26819j.onError(thM10813h);
        }

        @Override // p637j0.Observer2
        public void onCompleted() {
            this.f26827r = true;
            m10751a();
        }

        @Override // p637j0.Observer2
        public void onError(Throwable th) {
            if (!ExceptionsUtils.m10811f(this.f26825p, th)) {
                C12774l.m10863b(th);
                return;
            }
            this.f26827r = true;
            if (this.f26821l != 0) {
                m10751a();
                return;
            }
            Throwable thM10813h = ExceptionsUtils.m10813h(this.f26825p);
            if (!ExceptionsUtils.m10812g(thM10813h)) {
                this.f26819j.onError(thM10813h);
            }
            this.f26826q.f27657j.unsubscribe();
        }

        @Override // p637j0.Observer2
        public void onNext(T t) {
            Queue<Object> queue = this.f26823n;
            if (t == null) {
                t = (T) NotificationLite.f26769b;
            }
            if (queue.offer(t)) {
                m10751a();
            } else {
                unsubscribe();
                onError(new MissingBackpressureException());
            }
        }
    }

    public OnSubscribeConcatMap2(Observable<? extends T> observable, Func1<? super T, ? extends Observable<? extends R>> func1, int i, int i2) {
        this.f26812j = observable;
        this.f26813k = func1;
    }

    @Override // p658rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        c cVar = new c(new SerializedSubscriber(subscriber), this.f26813k, 2, 0);
        subscriber.add(cVar);
        subscriber.add(cVar.f26826q);
        subscriber.setProducer(new OnSubscribeConcatMap(this, cVar));
        if (subscriber.isUnsubscribed()) {
            return;
        }
        this.f26812j.m11107i0(cVar);
    }
}
