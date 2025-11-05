package j0.l.e;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.Observable;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;

/* compiled from: ScalarSynchronousObservable.java */
/* loaded from: classes3.dex */
public final class k<T> extends Observable<T> {
    public static final boolean k = Boolean.valueOf(System.getProperty("rx.just.strong-mode", "false")).booleanValue();
    public final T l;

    /* compiled from: ScalarSynchronousObservable.java */
    public class a implements j0.k.b<Action0, Subscription> {
        public final /* synthetic */ j0.l.c.b j;

        public a(k kVar, j0.l.c.b bVar) {
            this.j = bVar;
        }

        @Override // j0.k.b
        public Subscription call(Action0 action0) {
            return this.j.e.get().a().f(action0, -1L, TimeUnit.NANOSECONDS);
        }
    }

    /* compiled from: ScalarSynchronousObservable.java */
    public class b implements j0.k.b<Action0, Subscription> {
        public final /* synthetic */ Scheduler j;

        public b(k kVar, Scheduler scheduler) {
            this.j = scheduler;
        }

        @Override // j0.k.b
        public Subscription call(Action0 action0) {
            Scheduler.Worker workerA = this.j.a();
            workerA.a(new l(this, action0, workerA));
            return workerA;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: ScalarSynchronousObservable.java */
    public class c<R> implements Observable.a<R> {
        public final /* synthetic */ j0.k.b j;

        public c(j0.k.b bVar) {
            this.j = bVar;
        }

        @Override // rx.functions.Action1
        public void call(Object obj) {
            Subscriber subscriber = (Subscriber) obj;
            Observable observable = (Observable) this.j.call(k.this.l);
            if (!(observable instanceof k)) {
                observable.i0(new j0.n.e(subscriber, subscriber));
            } else {
                T t = ((k) observable).l;
                subscriber.setProducer(k.k ? new j0.l.b.c(subscriber, t) : new g(subscriber, t));
            }
        }
    }

    /* compiled from: ScalarSynchronousObservable.java */
    public static final class d<T> implements Observable.a<T> {
        public final T j;

        public d(T t) {
            this.j = t;
        }

        @Override // rx.functions.Action1
        public void call(Object obj) {
            Subscriber subscriber = (Subscriber) obj;
            T t = this.j;
            subscriber.setProducer(k.k ? new j0.l.b.c(subscriber, t) : new g(subscriber, t));
        }
    }

    /* compiled from: ScalarSynchronousObservable.java */
    public static final class e<T> implements Observable.a<T> {
        public final T j;
        public final j0.k.b<Action0, Subscription> k;

        public e(T t, j0.k.b<Action0, Subscription> bVar) {
            this.j = t;
            this.k = bVar;
        }

        @Override // rx.functions.Action1
        public void call(Object obj) {
            Subscriber subscriber = (Subscriber) obj;
            subscriber.setProducer(new f(subscriber, this.j, this.k));
        }
    }

    /* compiled from: ScalarSynchronousObservable.java */
    public static final class f<T> extends AtomicBoolean implements Producer, Action0 {
        private static final long serialVersionUID = -2466317989629281651L;
        public final Subscriber<? super T> actual;
        public final j0.k.b<Action0, Subscription> onSchedule;
        public final T value;

        public f(Subscriber<? super T> subscriber, T t, j0.k.b<Action0, Subscription> bVar) {
            this.actual = subscriber;
            this.value = t;
            this.onSchedule = bVar;
        }

        @Override // rx.functions.Action0
        public void call() {
            Subscriber<? super T> subscriber = this.actual;
            if (subscriber.isUnsubscribed()) {
                return;
            }
            T t = this.value;
            try {
                subscriber.onNext(t);
                if (subscriber.isUnsubscribed()) {
                    return;
                }
                subscriber.onCompleted();
            } catch (Throwable th) {
                b.i.a.f.e.o.f.p1(th, subscriber, t);
            }
        }

        @Override // rx.Producer
        public void j(long j) {
            if (j < 0) {
                throw new IllegalArgumentException(b.d.b.a.a.t("n >= 0 required but it was ", j));
            }
            if (j == 0 || !compareAndSet(false, true)) {
                return;
            }
            this.actual.add(this.onSchedule.call(this));
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public String toString() {
            StringBuilder sbU = b.d.b.a.a.U("ScalarAsyncProducer[");
            sbU.append(this.value);
            sbU.append(", ");
            sbU.append(get());
            sbU.append("]");
            return sbU.toString();
        }
    }

    /* compiled from: ScalarSynchronousObservable.java */
    public static final class g<T> implements Producer {
        public final Subscriber<? super T> j;
        public final T k;
        public boolean l;

        public g(Subscriber<? super T> subscriber, T t) {
            this.j = subscriber;
            this.k = t;
        }

        @Override // rx.Producer
        public void j(long j) {
            if (this.l) {
                return;
            }
            if (j < 0) {
                throw new IllegalStateException(b.d.b.a.a.t("n >= required but it was ", j));
            }
            if (j == 0) {
                return;
            }
            this.l = true;
            Subscriber<? super T> subscriber = this.j;
            if (subscriber.isUnsubscribed()) {
                return;
            }
            T t = this.k;
            try {
                subscriber.onNext(t);
                if (subscriber.isUnsubscribed()) {
                    return;
                }
                subscriber.onCompleted();
            } catch (Throwable th) {
                b.i.a.f.e.o.f.p1(th, subscriber, t);
            }
        }
    }

    public k(T t) {
        super(j0.o.l.a(new d(t)));
        this.l = t;
    }

    public <R> Observable<R> k0(j0.k.b<? super T, ? extends Observable<? extends R>> bVar) {
        return Observable.h0(new c(bVar));
    }

    public Observable<T> l0(Scheduler scheduler) {
        return Observable.h0(new e(this.l, scheduler instanceof j0.l.c.b ? new a(this, (j0.l.c.b) scheduler) : new b(this, scheduler)));
    }
}
