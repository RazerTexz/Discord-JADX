package j0.l.a;

import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.MissingBackpressureException;
import rx.functions.Func2;
import rx.functions.FuncN;
import rx.subscriptions.CompositeSubscription;

/* compiled from: OperatorZip.java */
/* loaded from: classes3.dex */
public final class q2<R> implements Observable.b<R, Observable<?>[]> {
    public final FuncN<? extends R> j;

    /* compiled from: OperatorZip.java */
    public static final class a<R> extends AtomicLong {
        public static final int j = (int) (j0.l.e.i.j * 0.7d);
        private static final long serialVersionUID = 5995274816189928317L;
        public final j0.g<? super R> child;
        private final CompositeSubscription childSubscription;
        public int emitted;
        private AtomicLong requested;
        private volatile Object[] subscribers;
        private final FuncN<? extends R> zipFunction;

        /* compiled from: OperatorZip.java */
        /* renamed from: j0.l.a.q2$a$a, reason: collision with other inner class name */
        public final class C0622a extends Subscriber {
            public final j0.l.e.i j;

            public C0622a() {
                int i = j0.l.e.i.j;
                this.j = j0.l.e.o.y.b() ? new j0.l.e.i(true, j0.l.e.i.j) : new j0.l.e.i();
            }

            @Override // j0.g
            public void onCompleted() {
                j0.l.e.i iVar = this.j;
                if (iVar.l == null) {
                    iVar.l = e.a;
                }
                a.this.b();
            }

            @Override // j0.g
            public void onError(Throwable th) {
                a.this.child.onError(th);
            }

            @Override // j0.g
            public void onNext(Object obj) {
                try {
                    this.j.a(obj);
                } catch (MissingBackpressureException e) {
                    a.this.child.onError(e);
                }
                a.this.b();
            }

            @Override // rx.Subscriber
            public void onStart() {
                request(j0.l.e.i.j);
            }
        }

        public a(Subscriber<? super R> subscriber, FuncN<? extends R> funcN) {
            CompositeSubscription compositeSubscription = new CompositeSubscription();
            this.childSubscription = compositeSubscription;
            this.child = subscriber;
            this.zipFunction = funcN;
            subscriber.add(compositeSubscription);
        }

        public void a(Observable[] observableArr, AtomicLong atomicLong) {
            Object[] objArr = new Object[observableArr.length];
            for (int i = 0; i < observableArr.length; i++) {
                C0622a c0622a = new C0622a();
                objArr[i] = c0622a;
                this.childSubscription.a(c0622a);
            }
            this.requested = atomicLong;
            this.subscribers = objArr;
            for (int i2 = 0; i2 < observableArr.length; i2++) {
                observableArr[i2].i0((C0622a) objArr[i2]);
            }
        }

        public void b() {
            Object[] objArr = this.subscribers;
            if (objArr == null || getAndIncrement() != 0) {
                return;
            }
            int length = objArr.length;
            j0.g<? super R> gVar = this.child;
            AtomicLong atomicLong = this.requested;
            while (true) {
                Object[] objArr2 = new Object[length];
                boolean z2 = true;
                for (int i = 0; i < length; i++) {
                    Object objB = ((C0622a) objArr[i]).j.b();
                    if (objB == null) {
                        z2 = false;
                    } else {
                        if (e.c(objB)) {
                            gVar.onCompleted();
                            this.childSubscription.unsubscribe();
                            return;
                        }
                        objArr2[i] = e.b(objB);
                    }
                }
                if (z2 && atomicLong.get() > 0) {
                    try {
                        gVar.onNext(this.zipFunction.call(objArr2));
                        atomicLong.decrementAndGet();
                        this.emitted++;
                        for (Object obj : objArr) {
                            j0.l.e.i iVar = ((C0622a) obj).j;
                            iVar.c();
                            if (e.c(iVar.b())) {
                                gVar.onCompleted();
                                this.childSubscription.unsubscribe();
                                return;
                            }
                        }
                        if (this.emitted > j) {
                            for (Object obj2 : objArr) {
                                ((C0622a) obj2).request(this.emitted);
                            }
                            this.emitted = 0;
                        }
                    } catch (Throwable th) {
                        b.i.a.f.e.o.f.p1(th, gVar, objArr2);
                        return;
                    }
                } else if (decrementAndGet() <= 0) {
                    return;
                }
            }
        }
    }

    /* compiled from: OperatorZip.java */
    public static final class b<R> extends AtomicLong implements Producer {
        private static final long serialVersionUID = -1216676403723546796L;
        public final a<R> zipper;

        public b(a<R> aVar) {
            this.zipper = aVar;
        }

        @Override // rx.Producer
        public void j(long j) {
            b.i.a.f.e.o.f.c0(this, j);
            this.zipper.b();
        }
    }

    /* compiled from: OperatorZip.java */
    public final class c extends Subscriber<Observable[]> {
        public final Subscriber<? super R> j;
        public final a<R> k;
        public final b<R> l;
        public boolean m;

        public c(q2 q2Var, Subscriber<? super R> subscriber, a<R> aVar, b<R> bVar) {
            this.j = subscriber;
            this.k = aVar;
            this.l = bVar;
        }

        @Override // j0.g
        public void onCompleted() {
            if (this.m) {
                return;
            }
            this.j.onCompleted();
        }

        @Override // j0.g
        public void onError(Throwable th) {
            this.j.onError(th);
        }

        @Override // j0.g
        public void onNext(Object obj) {
            Observable[] observableArr = (Observable[]) obj;
            if (observableArr == null || observableArr.length == 0) {
                this.j.onCompleted();
            } else {
                this.m = true;
                this.k.a(observableArr, this.l);
            }
        }
    }

    public q2(Func2 func2) {
        this.j = new j0.k.d(func2);
    }

    @Override // j0.k.b
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        a aVar = new a(subscriber, this.j);
        b bVar = new b(aVar);
        c cVar = new c(this, subscriber, aVar, bVar);
        subscriber.add(cVar);
        subscriber.setProducer(bVar);
        return cVar;
    }
}
