package p637j0.p642l.p643a;

import java.util.concurrent.atomic.AtomicLong;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p637j0.Observer2;
import p637j0.p641k.C12591d;
import p637j0.p642l.p647e.RxRingBuffer;
import p637j0.p642l.p647e.p649o.UnsafeAccess;
import p658rx.Observable;
import p658rx.Producer;
import p658rx.Subscriber;
import p658rx.exceptions.MissingBackpressureException;
import p658rx.functions.Func2;
import p658rx.functions.FuncN;
import p658rx.subscriptions.CompositeSubscription;

/* compiled from: OperatorZip.java */
/* renamed from: j0.l.a.q2, reason: use source file name */
/* loaded from: classes3.dex */
public final class OperatorZip<R> implements Observable.InterfaceC13006b<R, Observable<?>[]> {

    /* renamed from: j */
    public final FuncN<? extends R> f27005j;

    /* compiled from: OperatorZip.java */
    /* renamed from: j0.l.a.q2$a */
    public static final class a<R> extends AtomicLong {

        /* renamed from: j */
        public static final int f27006j = (int) (RxRingBuffer.f27283j * 0.7d);
        private static final long serialVersionUID = 5995274816189928317L;
        public final Observer2<? super R> child;
        private final CompositeSubscription childSubscription;
        public int emitted;
        private AtomicLong requested;
        private volatile Object[] subscribers;
        private final FuncN<? extends R> zipFunction;

        /* compiled from: OperatorZip.java */
        /* renamed from: j0.l.a.q2$a$a, reason: collision with other inner class name */
        public final class C13348a extends Subscriber {

            /* renamed from: j */
            public final RxRingBuffer f27007j;

            public C13348a() {
                int i = RxRingBuffer.f27283j;
                this.f27007j = UnsafeAccess.m10858b() ? new RxRingBuffer(true, RxRingBuffer.f27283j) : new RxRingBuffer();
            }

            @Override // p637j0.Observer2
            public void onCompleted() {
                RxRingBuffer rxRingBuffer = this.f27007j;
                if (rxRingBuffer.f27285l == null) {
                    rxRingBuffer.f27285l = NotificationLite.f26768a;
                }
                a.this.m10779b();
            }

            @Override // p637j0.Observer2
            public void onError(Throwable th) {
                a.this.child.onError(th);
            }

            @Override // p637j0.Observer2
            public void onNext(Object obj) {
                try {
                    this.f27007j.m10817a(obj);
                } catch (MissingBackpressureException e) {
                    a.this.child.onError(e);
                }
                a.this.m10779b();
            }

            @Override // p658rx.Subscriber
            public void onStart() {
                request(RxRingBuffer.f27283j);
            }
        }

        public a(Subscriber<? super R> subscriber, FuncN<? extends R> funcN) {
            CompositeSubscription compositeSubscription = new CompositeSubscription();
            this.childSubscription = compositeSubscription;
            this.child = subscriber;
            this.zipFunction = funcN;
            subscriber.add(compositeSubscription);
        }

        /* renamed from: a */
        public void m10778a(Observable[] observableArr, AtomicLong atomicLong) {
            Object[] objArr = new Object[observableArr.length];
            for (int i = 0; i < observableArr.length; i++) {
                C13348a c13348a = new C13348a();
                objArr[i] = c13348a;
                this.childSubscription.m11136a(c13348a);
            }
            this.requested = atomicLong;
            this.subscribers = objArr;
            for (int i2 = 0; i2 < observableArr.length; i2++) {
                observableArr[i2].m11107i0((C13348a) objArr[i2]);
            }
        }

        /* renamed from: b */
        public void m10779b() {
            Object[] objArr = this.subscribers;
            if (objArr == null || getAndIncrement() != 0) {
                return;
            }
            int length = objArr.length;
            Observer2<? super R> observer2 = this.child;
            AtomicLong atomicLong = this.requested;
            while (true) {
                Object[] objArr2 = new Object[length];
                boolean z2 = true;
                for (int i = 0; i < length; i++) {
                    Object objM10818b = ((C13348a) objArr[i]).f27007j.m10818b();
                    if (objM10818b == null) {
                        z2 = false;
                    } else {
                        if (NotificationLite.m10746c(objM10818b)) {
                            observer2.onCompleted();
                            this.childSubscription.unsubscribe();
                            return;
                        }
                        objArr2[i] = NotificationLite.m10745b(objM10818b);
                    }
                }
                if (z2 && atomicLong.get() > 0) {
                    try {
                        observer2.onNext(this.zipFunction.call(objArr2));
                        atomicLong.decrementAndGet();
                        this.emitted++;
                        for (Object obj : objArr) {
                            RxRingBuffer rxRingBuffer = ((C13348a) obj).f27007j;
                            rxRingBuffer.m10819c();
                            if (NotificationLite.m10746c(rxRingBuffer.m10818b())) {
                                observer2.onCompleted();
                                this.childSubscription.unsubscribe();
                                return;
                            }
                        }
                        if (this.emitted > f27006j) {
                            for (Object obj2 : objArr) {
                                ((C13348a) obj2).request(this.emitted);
                            }
                            this.emitted = 0;
                        }
                    } catch (Throwable th) {
                        C3404f.m4329p1(th, observer2, objArr2);
                        return;
                    }
                } else if (decrementAndGet() <= 0) {
                    return;
                }
            }
        }
    }

    /* compiled from: OperatorZip.java */
    /* renamed from: j0.l.a.q2$b */
    public static final class b<R> extends AtomicLong implements Producer {
        private static final long serialVersionUID = -1216676403723546796L;
        public final a<R> zipper;

        public b(a<R> aVar) {
            this.zipper = aVar;
        }

        @Override // p658rx.Producer
        /* renamed from: j */
        public void mo10704j(long j) {
            C3404f.m4276c0(this, j);
            this.zipper.m10779b();
        }
    }

    /* compiled from: OperatorZip.java */
    /* renamed from: j0.l.a.q2$c */
    public final class c extends Subscriber<Observable[]> {

        /* renamed from: j */
        public final Subscriber<? super R> f27009j;

        /* renamed from: k */
        public final a<R> f27010k;

        /* renamed from: l */
        public final b<R> f27011l;

        /* renamed from: m */
        public boolean f27012m;

        public c(OperatorZip operatorZip, Subscriber<? super R> subscriber, a<R> aVar, b<R> bVar) {
            this.f27009j = subscriber;
            this.f27010k = aVar;
            this.f27011l = bVar;
        }

        @Override // p637j0.Observer2
        public void onCompleted() {
            if (this.f27012m) {
                return;
            }
            this.f27009j.onCompleted();
        }

        @Override // p637j0.Observer2
        public void onError(Throwable th) {
            this.f27009j.onError(th);
        }

        @Override // p637j0.Observer2
        public void onNext(Object obj) {
            Observable[] observableArr = (Observable[]) obj;
            if (observableArr == null || observableArr.length == 0) {
                this.f27009j.onCompleted();
            } else {
                this.f27012m = true;
                this.f27010k.m10778a(observableArr, this.f27011l);
            }
        }
    }

    public OperatorZip(Func2 func2) {
        this.f27005j = new C12591d(func2);
    }

    @Override // p637j0.p641k.Func1
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        a aVar = new a(subscriber, this.f27005j);
        b bVar = new b(aVar);
        c cVar = new c(this, subscriber, aVar, bVar);
        subscriber.add(cVar);
        subscriber.setProducer(bVar);
        return cVar;
    }
}
