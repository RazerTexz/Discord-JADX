package j0.l.a;

import android.R;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.CompositeException;
import rx.subscriptions.SerialSubscription;

/* compiled from: OperatorSwitch.java */
/* loaded from: classes3.dex */
public final class y1<T> implements Observable.b<T, Observable<? extends T>> {
    public final boolean j;

    /* compiled from: OperatorSwitch.java */
    public static final class a {
        public static final y1<Object> a = new y1<>(false);
    }

    /* compiled from: OperatorSwitch.java */
    public static final class b<T> extends Subscriber<T> {
        public final long j;
        public final c<T> k;

        public b(long j, c<T> cVar) {
            this.j = j;
            this.k = cVar;
        }

        @Override // j0.g
        public void onCompleted() {
            c<T> cVar = this.k;
            long j = this.j;
            synchronized (cVar) {
                if (cVar.n.get() != j) {
                    return;
                }
                cVar.v = false;
                cVar.f3783s = null;
                cVar.b();
            }
        }

        @Override // j0.g
        public void onError(Throwable th) {
            boolean zC;
            c<T> cVar = this.k;
            long j = this.j;
            synchronized (cVar) {
                if (cVar.n.get() == j) {
                    zC = cVar.c(th);
                    cVar.v = false;
                    cVar.f3783s = null;
                } else {
                    zC = true;
                }
            }
            if (zC) {
                cVar.b();
            } else {
                j0.o.l.b(th);
            }
        }

        @Override // j0.g
        public void onNext(T t) {
            c<T> cVar = this.k;
            synchronized (cVar) {
                if (cVar.n.get() != this.j) {
                    return;
                }
                j0.l.e.n.e<Object> eVar = cVar.o;
                if (t == null) {
                    t = (T) e.f3771b;
                }
                eVar.e(this, t);
                cVar.b();
            }
        }

        @Override // rx.Subscriber
        public void setProducer(Producer producer) {
            c<T> cVar = this.k;
            long j = this.j;
            synchronized (cVar) {
                if (cVar.n.get() != j) {
                    return;
                }
                long j2 = cVar.r;
                cVar.f3783s = producer;
                producer.j(j2);
            }
        }
    }

    /* compiled from: OperatorSwitch.java */
    public static final class c<T> extends Subscriber<Observable<? extends T>> {
        public static final Throwable j = new Throwable("Terminal error");
        public final Subscriber<? super T> k;
        public final boolean m;
        public boolean p;
        public boolean q;
        public long r;

        /* renamed from: s, reason: collision with root package name */
        public Producer f3783s;
        public volatile boolean t;
        public Throwable u;
        public boolean v;
        public final SerialSubscription l = new SerialSubscription();
        public final AtomicLong n = new AtomicLong();
        public final j0.l.e.n.e<Object> o = new j0.l.e.n.e<>(j0.l.e.i.j);

        public c(Subscriber<? super T> subscriber, boolean z2) {
            this.k = subscriber;
            this.m = z2;
        }

        public boolean a(boolean z2, boolean z3, Throwable th, j0.l.e.n.e<Object> eVar, Subscriber<? super T> subscriber, boolean z4) {
            if (this.m) {
                if (!z2 || z3 || !z4) {
                    return false;
                }
                if (th != null) {
                    subscriber.onError(th);
                } else {
                    subscriber.onCompleted();
                }
                return true;
            }
            if (th != null) {
                eVar.clear();
                subscriber.onError(th);
                return true;
            }
            if (!z2 || z3 || !z4) {
                return false;
            }
            subscriber.onCompleted();
            return true;
        }

        public void b() {
            Throwable th;
            Throwable th2;
            synchronized (this) {
                if (this.p) {
                    this.q = true;
                    return;
                }
                this.p = true;
                boolean z2 = this.v;
                long j2 = this.r;
                Throwable th3 = this.u;
                if (th3 != null && th3 != (th2 = j) && !this.m) {
                    this.u = th2;
                }
                j0.l.e.n.e<Object> eVar = this.o;
                AtomicLong atomicLong = this.n;
                Subscriber<? super T> subscriber = this.k;
                long j3 = j2;
                Throwable th4 = th3;
                boolean z3 = this.t;
                while (true) {
                    long j4 = 0;
                    while (j4 != j3) {
                        if (subscriber.isUnsubscribed()) {
                            return;
                        }
                        boolean zIsEmpty = eVar.isEmpty();
                        if (a(z3, z2, th4, eVar, subscriber, zIsEmpty)) {
                            return;
                        }
                        if (zIsEmpty) {
                            break;
                        }
                        b bVar = (b) eVar.poll();
                        R.anim animVar = (Object) e.b(eVar.poll());
                        if (atomicLong.get() == bVar.j) {
                            subscriber.onNext(animVar);
                            j4++;
                        }
                    }
                    if (j4 == j3) {
                        if (subscriber.isUnsubscribed()) {
                            return;
                        }
                        if (a(this.t, z2, th4, eVar, subscriber, eVar.isEmpty())) {
                            return;
                        }
                    }
                    synchronized (this) {
                        long j5 = this.r;
                        if (j5 != RecyclerView.FOREVER_NS) {
                            j5 -= j4;
                            this.r = j5;
                        }
                        j3 = j5;
                        if (!this.q) {
                            this.p = false;
                            return;
                        }
                        this.q = false;
                        z3 = this.t;
                        z2 = this.v;
                        th4 = this.u;
                        if (th4 != null && th4 != (th = j) && !this.m) {
                            this.u = th;
                        }
                    }
                }
            }
        }

        public boolean c(Throwable th) {
            Throwable th2 = this.u;
            if (th2 == j) {
                return false;
            }
            if (th2 == null) {
                this.u = th;
            } else if (th2 instanceof CompositeException) {
                ArrayList arrayList = new ArrayList(((CompositeException) th2).b());
                arrayList.add(th);
                this.u = new CompositeException(arrayList);
            } else {
                this.u = new CompositeException(th2, th);
            }
            return true;
        }

        @Override // j0.g
        public void onCompleted() {
            this.t = true;
            b();
        }

        @Override // j0.g
        public void onError(Throwable th) {
            boolean zC;
            synchronized (this) {
                zC = c(th);
            }
            if (!zC) {
                j0.o.l.b(th);
            } else {
                this.t = true;
                b();
            }
        }

        @Override // j0.g
        public void onNext(Object obj) {
            b bVar;
            Observable observable = (Observable) obj;
            long jIncrementAndGet = this.n.incrementAndGet();
            Subscription subscription = this.l.j.get();
            if (subscription == j0.l.d.b.INSTANCE) {
                subscription = j0.r.c.a;
            }
            if (subscription != null) {
                subscription.unsubscribe();
            }
            synchronized (this) {
                bVar = new b(jIncrementAndGet, this);
                this.v = true;
                this.f3783s = null;
            }
            this.l.a(bVar);
            observable.i0(bVar);
        }
    }

    public y1(boolean z2) {
        this.j = z2;
    }

    @Override // j0.k.b
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        c cVar = new c(subscriber, this.j);
        subscriber.add(cVar);
        cVar.k.add(cVar.l);
        cVar.k.add(new j0.r.a(new z1(cVar)));
        cVar.k.setProducer(new a2(cVar));
        return cVar;
    }
}
