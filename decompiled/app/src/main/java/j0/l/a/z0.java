package j0.l.a;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.exceptions.MissingBackpressureException;
import rx.functions.Action0;

/* compiled from: OperatorObserveOn.java */
/* loaded from: classes3.dex */
public final class z0<T> implements Observable.b<T, T> {
    public final Scheduler j;
    public final boolean k;
    public final int l;

    /* compiled from: OperatorObserveOn.java */
    public static final class a<T> extends Subscriber<T> implements Action0 {
        public final Subscriber<? super T> j;
        public final Scheduler.Worker k;
        public final boolean l;
        public final Queue<Object> m;
        public final int n;
        public volatile boolean o;
        public final AtomicLong p = new AtomicLong();
        public final AtomicLong q = new AtomicLong();
        public Throwable r;

        /* renamed from: s, reason: collision with root package name */
        public long f3784s;

        public a(Scheduler scheduler, Subscriber<? super T> subscriber, boolean z2, int i) {
            this.j = subscriber;
            this.k = scheduler.a();
            this.l = z2;
            i = i <= 0 ? j0.l.e.i.j : i;
            this.n = i - (i >> 2);
            if (j0.l.e.o.y.b()) {
                this.m = new j0.l.e.o.n(i);
            } else {
                this.m = new j0.l.e.n.c(i);
            }
            request(i);
        }

        public boolean a(boolean z2, boolean z3, Subscriber<? super T> subscriber, Queue<Object> queue) {
            if (subscriber.isUnsubscribed()) {
                queue.clear();
                return true;
            }
            if (!z2) {
                return false;
            }
            if (this.l) {
                if (!z3) {
                    return false;
                }
                Throwable th = this.r;
                try {
                    if (th != null) {
                        subscriber.onError(th);
                    } else {
                        subscriber.onCompleted();
                    }
                    return false;
                } finally {
                }
            }
            Throwable th2 = this.r;
            if (th2 != null) {
                queue.clear();
                try {
                    subscriber.onError(th2);
                    return true;
                } finally {
                }
            }
            if (!z3) {
                return false;
            }
            try {
                subscriber.onCompleted();
                return true;
            } finally {
            }
        }

        public void b() {
            if (this.q.getAndIncrement() == 0) {
                this.k.a(this);
            }
        }

        @Override // rx.functions.Action0
        public void call() {
            long j = this.f3784s;
            Queue<Object> queue = this.m;
            Subscriber<? super T> subscriber = this.j;
            long jAddAndGet = 1;
            do {
                long jU0 = this.p.get();
                while (jU0 != j) {
                    boolean z2 = this.o;
                    Object objPoll = queue.poll();
                    boolean z3 = objPoll == null;
                    if (a(z2, z3, subscriber, queue)) {
                        return;
                    }
                    if (z3) {
                        break;
                    }
                    subscriber.onNext((Object) e.b(objPoll));
                    j++;
                    if (j == this.n) {
                        jU0 = b.i.a.f.e.o.f.U0(this.p, j);
                        request(j);
                        j = 0;
                    }
                }
                if (jU0 == j && a(this.o, queue.isEmpty(), subscriber, queue)) {
                    return;
                }
                this.f3784s = j;
                jAddAndGet = this.q.addAndGet(-jAddAndGet);
            } while (jAddAndGet != 0);
        }

        @Override // j0.g
        public void onCompleted() {
            if (isUnsubscribed() || this.o) {
                return;
            }
            this.o = true;
            b();
        }

        @Override // j0.g
        public void onError(Throwable th) {
            if (isUnsubscribed() || this.o) {
                j0.o.l.b(th);
                return;
            }
            this.r = th;
            this.o = true;
            b();
        }

        @Override // j0.g
        public void onNext(T t) {
            if (isUnsubscribed() || this.o) {
                return;
            }
            Queue<Object> queue = this.m;
            if (t == null) {
                t = (T) e.f3771b;
            }
            if (queue.offer(t)) {
                b();
            } else {
                onError(new MissingBackpressureException());
            }
        }
    }

    public z0(Scheduler scheduler, boolean z2, int i) {
        this.j = scheduler;
        this.k = z2;
        this.l = i <= 0 ? j0.l.e.i.j : i;
    }

    @Override // j0.k.b
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        Scheduler scheduler = this.j;
        if (scheduler instanceof j0.l.c.m) {
            return subscriber;
        }
        a aVar = new a(scheduler, subscriber, this.k, this.l);
        Subscriber<? super T> subscriber2 = aVar.j;
        subscriber2.setProducer(new y0(aVar));
        subscriber2.add(aVar.k);
        subscriber2.add(aVar);
        return aVar;
    }
}
