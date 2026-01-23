package p637j0.p642l.p643a;

import android.R;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import p637j0.p642l.p646d.Unsubscribed;
import p637j0.p642l.p647e.RxRingBuffer;
import p637j0.p642l.p647e.p648n.SpscLinkedArrayQueue;
import p637j0.p652o.C12774l;
import p637j0.p655r.BooleanSubscription;
import p637j0.p655r.Subscriptions;
import p658rx.Observable;
import p658rx.Producer;
import p658rx.Subscriber;
import p658rx.Subscription;
import p658rx.exceptions.CompositeException;
import p658rx.subscriptions.SerialSubscription;

/* JADX INFO: renamed from: j0.l.a.y1, reason: use source file name */
/* JADX INFO: compiled from: OperatorSwitch.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OperatorSwitch2<T> implements Observable.InterfaceC13006b<T, Observable<? extends T>> {

    /* JADX INFO: renamed from: j */
    public final boolean f27125j;

    /* JADX INFO: renamed from: j0.l.a.y1$a */
    /* JADX INFO: compiled from: OperatorSwitch.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public static final OperatorSwitch2<Object> f27126a = new OperatorSwitch2<>(false);
    }

    /* JADX INFO: renamed from: j0.l.a.y1$b */
    /* JADX INFO: compiled from: OperatorSwitch.java */
    public static final class b<T> extends Subscriber<T> {

        /* JADX INFO: renamed from: j */
        public final long f27127j;

        /* JADX INFO: renamed from: k */
        public final c<T> f27128k;

        public b(long j, c<T> cVar) {
            this.f27127j = j;
            this.f27128k = cVar;
        }

        @Override // p637j0.Observer2
        public void onCompleted() {
            c<T> cVar = this.f27128k;
            long j = this.f27127j;
            synchronized (cVar) {
                if (cVar.f27133n.get() != j) {
                    return;
                }
                cVar.f27141v = false;
                cVar.f27138s = null;
                cVar.m10791b();
            }
        }

        @Override // p637j0.Observer2
        public void onError(Throwable th) {
            boolean zM10792c;
            c<T> cVar = this.f27128k;
            long j = this.f27127j;
            synchronized (cVar) {
                if (cVar.f27133n.get() == j) {
                    zM10792c = cVar.m10792c(th);
                    cVar.f27141v = false;
                    cVar.f27138s = null;
                } else {
                    zM10792c = true;
                }
            }
            if (zM10792c) {
                cVar.m10791b();
            } else {
                C12774l.m10863b(th);
            }
        }

        @Override // p637j0.Observer2
        public void onNext(T t) {
            c<T> cVar = this.f27128k;
            synchronized (cVar) {
                if (cVar.f27133n.get() != this.f27127j) {
                    return;
                }
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = cVar.f27134o;
                if (t == null) {
                    t = (T) NotificationLite.f26769b;
                }
                spscLinkedArrayQueue.m10830e(this, t);
                cVar.m10791b();
            }
        }

        @Override // p658rx.Subscriber
        public void setProducer(Producer producer) {
            c<T> cVar = this.f27128k;
            long j = this.f27127j;
            synchronized (cVar) {
                if (cVar.f27133n.get() != j) {
                    return;
                }
                long j2 = cVar.f27137r;
                cVar.f27138s = producer;
                producer.mo10704j(j2);
            }
        }
    }

    /* JADX INFO: renamed from: j0.l.a.y1$c */
    /* JADX INFO: compiled from: OperatorSwitch.java */
    public static final class c<T> extends Subscriber<Observable<? extends T>> {

        /* JADX INFO: renamed from: j */
        public static final Throwable f27129j = new Throwable("Terminal error");

        /* JADX INFO: renamed from: k */
        public final Subscriber<? super T> f27130k;

        /* JADX INFO: renamed from: m */
        public final boolean f27132m;

        /* JADX INFO: renamed from: p */
        public boolean f27135p;

        /* JADX INFO: renamed from: q */
        public boolean f27136q;

        /* JADX INFO: renamed from: r */
        public long f27137r;

        /* JADX INFO: renamed from: s */
        public Producer f27138s;

        /* JADX INFO: renamed from: t */
        public volatile boolean f27139t;

        /* JADX INFO: renamed from: u */
        public Throwable f27140u;

        /* JADX INFO: renamed from: v */
        public boolean f27141v;

        /* JADX INFO: renamed from: l */
        public final SerialSubscription f27131l = new SerialSubscription();

        /* JADX INFO: renamed from: n */
        public final AtomicLong f27133n = new AtomicLong();

        /* JADX INFO: renamed from: o */
        public final SpscLinkedArrayQueue<Object> f27134o = new SpscLinkedArrayQueue<>(RxRingBuffer.f27283j);

        public c(Subscriber<? super T> subscriber, boolean z2) {
            this.f27130k = subscriber;
            this.f27132m = z2;
        }

        /* JADX INFO: renamed from: a */
        public boolean m10790a(boolean z2, boolean z3, Throwable th, SpscLinkedArrayQueue<Object> spscLinkedArrayQueue, Subscriber<? super T> subscriber, boolean z4) {
            if (this.f27132m) {
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
                spscLinkedArrayQueue.clear();
                subscriber.onError(th);
                return true;
            }
            if (!z2 || z3 || !z4) {
                return false;
            }
            subscriber.onCompleted();
            return true;
        }

        /* JADX INFO: renamed from: b */
        public void m10791b() {
            Throwable th;
            Throwable th2;
            synchronized (this) {
                if (this.f27135p) {
                    this.f27136q = true;
                    return;
                }
                this.f27135p = true;
                boolean z2 = this.f27141v;
                long j = this.f27137r;
                Throwable th3 = this.f27140u;
                if (th3 != null && th3 != (th2 = f27129j) && !this.f27132m) {
                    this.f27140u = th2;
                }
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f27134o;
                AtomicLong atomicLong = this.f27133n;
                Subscriber<? super T> subscriber = this.f27130k;
                long j2 = j;
                Throwable th4 = th3;
                boolean z3 = this.f27139t;
                while (true) {
                    long j3 = 0;
                    while (j3 != j2) {
                        if (subscriber.isUnsubscribed()) {
                            return;
                        }
                        boolean zIsEmpty = spscLinkedArrayQueue.isEmpty();
                        if (m10790a(z3, z2, th4, spscLinkedArrayQueue, subscriber, zIsEmpty)) {
                            return;
                        }
                        if (zIsEmpty) {
                            break;
                        }
                        b bVar = (b) spscLinkedArrayQueue.poll();
                        R.anim animVar = (Object) NotificationLite.m10745b(spscLinkedArrayQueue.poll());
                        if (atomicLong.get() == bVar.f27127j) {
                            subscriber.onNext(animVar);
                            j3++;
                        }
                    }
                    if (j3 == j2) {
                        if (subscriber.isUnsubscribed()) {
                            return;
                        }
                        if (m10790a(this.f27139t, z2, th4, spscLinkedArrayQueue, subscriber, spscLinkedArrayQueue.isEmpty())) {
                            return;
                        }
                    }
                    synchronized (this) {
                        long j4 = this.f27137r;
                        if (j4 != RecyclerView.FOREVER_NS) {
                            j4 -= j3;
                            this.f27137r = j4;
                        }
                        j2 = j4;
                        if (!this.f27136q) {
                            this.f27135p = false;
                            return;
                        }
                        this.f27136q = false;
                        z3 = this.f27139t;
                        z2 = this.f27141v;
                        th4 = this.f27140u;
                        if (th4 != null && th4 != (th = f27129j) && !this.f27132m) {
                            this.f27140u = th;
                        }
                    }
                }
            }
        }

        /* JADX INFO: renamed from: c */
        public boolean m10792c(Throwable th) {
            Throwable th2 = this.f27140u;
            if (th2 == f27129j) {
                return false;
            }
            if (th2 == null) {
                this.f27140u = th;
            } else if (th2 instanceof CompositeException) {
                ArrayList arrayList = new ArrayList(((CompositeException) th2).m11122b());
                arrayList.add(th);
                this.f27140u = new CompositeException(arrayList);
            } else {
                this.f27140u = new CompositeException(th2, th);
            }
            return true;
        }

        @Override // p637j0.Observer2
        public void onCompleted() {
            this.f27139t = true;
            m10791b();
        }

        @Override // p637j0.Observer2
        public void onError(Throwable th) {
            boolean zM10792c;
            synchronized (this) {
                zM10792c = m10792c(th);
            }
            if (!zM10792c) {
                C12774l.m10863b(th);
            } else {
                this.f27139t = true;
                m10791b();
            }
        }

        @Override // p637j0.Observer2
        public void onNext(Object obj) {
            b bVar;
            Observable observable = (Observable) obj;
            long jIncrementAndGet = this.f27133n.incrementAndGet();
            Subscription subscription = this.f27131l.f27657j.get();
            if (subscription == Unsubscribed.INSTANCE) {
                subscription = Subscriptions.f27422a;
            }
            if (subscription != null) {
                subscription.unsubscribe();
            }
            synchronized (this) {
                bVar = new b(jIncrementAndGet, this);
                this.f27141v = true;
                this.f27138s = null;
            }
            this.f27131l.m11139a(bVar);
            observable.m11107i0(bVar);
        }
    }

    public OperatorSwitch2(boolean z2) {
        this.f27125j = z2;
    }

    @Override // p637j0.p641k.Func1
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        c cVar = new c(subscriber, this.f27125j);
        subscriber.add(cVar);
        cVar.f27130k.add(cVar.f27131l);
        cVar.f27130k.add(new BooleanSubscription(new OperatorSwitch3(cVar)));
        cVar.f27130k.setProducer(new OperatorSwitch(cVar));
        return cVar;
    }
}
