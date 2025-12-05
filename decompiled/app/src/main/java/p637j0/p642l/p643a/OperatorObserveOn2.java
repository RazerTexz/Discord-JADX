package p637j0.p642l.p643a;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p637j0.p642l.p645c.TrampolineScheduler;
import p637j0.p642l.p647e.RxRingBuffer;
import p637j0.p642l.p647e.p648n.SpscAtomicArrayQueue;
import p637j0.p642l.p647e.p649o.SpscArrayQueue;
import p637j0.p642l.p647e.p649o.UnsafeAccess;
import p637j0.p652o.C12774l;
import p658rx.Observable;
import p658rx.Scheduler;
import p658rx.Subscriber;
import p658rx.exceptions.MissingBackpressureException;
import p658rx.functions.Action0;

/* compiled from: OperatorObserveOn.java */
/* renamed from: j0.l.a.z0, reason: use source file name */
/* loaded from: classes3.dex */
public final class OperatorObserveOn2<T> implements Observable.InterfaceC13006b<T, T> {

    /* renamed from: j */
    public final Scheduler f27145j;

    /* renamed from: k */
    public final boolean f27146k;

    /* renamed from: l */
    public final int f27147l;

    /* compiled from: OperatorObserveOn.java */
    /* renamed from: j0.l.a.z0$a */
    public static final class a<T> extends Subscriber<T> implements Action0 {

        /* renamed from: j */
        public final Subscriber<? super T> f27148j;

        /* renamed from: k */
        public final Scheduler.Worker f27149k;

        /* renamed from: l */
        public final boolean f27150l;

        /* renamed from: m */
        public final Queue<Object> f27151m;

        /* renamed from: n */
        public final int f27152n;

        /* renamed from: o */
        public volatile boolean f27153o;

        /* renamed from: p */
        public final AtomicLong f27154p = new AtomicLong();

        /* renamed from: q */
        public final AtomicLong f27155q = new AtomicLong();

        /* renamed from: r */
        public Throwable f27156r;

        /* renamed from: s */
        public long f27157s;

        public a(Scheduler scheduler, Subscriber<? super T> subscriber, boolean z2, int i) {
            this.f27148j = subscriber;
            this.f27149k = scheduler.mo10739a();
            this.f27150l = z2;
            i = i <= 0 ? RxRingBuffer.f27283j : i;
            this.f27152n = i - (i >> 2);
            if (UnsafeAccess.m10858b()) {
                this.f27151m = new SpscArrayQueue(i);
            } else {
                this.f27151m = new SpscAtomicArrayQueue(i);
            }
            request(i);
        }

        /* renamed from: a */
        public boolean m10793a(boolean z2, boolean z3, Subscriber<? super T> subscriber, Queue<Object> queue) {
            if (subscriber.isUnsubscribed()) {
                queue.clear();
                return true;
            }
            if (!z2) {
                return false;
            }
            if (this.f27150l) {
                if (!z3) {
                    return false;
                }
                Throwable th = this.f27156r;
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
            Throwable th2 = this.f27156r;
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

        /* renamed from: b */
        public void m10794b() {
            if (this.f27155q.getAndIncrement() == 0) {
                this.f27149k.mo10740a(this);
            }
        }

        @Override // p658rx.functions.Action0
        public void call() {
            long j = this.f27157s;
            Queue<Object> queue = this.f27151m;
            Subscriber<? super T> subscriber = this.f27148j;
            long jAddAndGet = 1;
            do {
                long jM4250U0 = this.f27154p.get();
                while (jM4250U0 != j) {
                    boolean z2 = this.f27153o;
                    Object objPoll = queue.poll();
                    boolean z3 = objPoll == null;
                    if (m10793a(z2, z3, subscriber, queue)) {
                        return;
                    }
                    if (z3) {
                        break;
                    }
                    subscriber.onNext((Object) NotificationLite.m10745b(objPoll));
                    j++;
                    if (j == this.f27152n) {
                        jM4250U0 = C3404f.m4250U0(this.f27154p, j);
                        request(j);
                        j = 0;
                    }
                }
                if (jM4250U0 == j && m10793a(this.f27153o, queue.isEmpty(), subscriber, queue)) {
                    return;
                }
                this.f27157s = j;
                jAddAndGet = this.f27155q.addAndGet(-jAddAndGet);
            } while (jAddAndGet != 0);
        }

        @Override // p637j0.Observer2
        public void onCompleted() {
            if (isUnsubscribed() || this.f27153o) {
                return;
            }
            this.f27153o = true;
            m10794b();
        }

        @Override // p637j0.Observer2
        public void onError(Throwable th) {
            if (isUnsubscribed() || this.f27153o) {
                C12774l.m10863b(th);
                return;
            }
            this.f27156r = th;
            this.f27153o = true;
            m10794b();
        }

        @Override // p637j0.Observer2
        public void onNext(T t) {
            if (isUnsubscribed() || this.f27153o) {
                return;
            }
            Queue<Object> queue = this.f27151m;
            if (t == null) {
                t = (T) NotificationLite.f26769b;
            }
            if (queue.offer(t)) {
                m10794b();
            } else {
                onError(new MissingBackpressureException());
            }
        }
    }

    public OperatorObserveOn2(Scheduler scheduler, boolean z2, int i) {
        this.f27145j = scheduler;
        this.f27146k = z2;
        this.f27147l = i <= 0 ? RxRingBuffer.f27283j : i;
    }

    @Override // p637j0.p641k.Func1
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        Scheduler scheduler = this.f27145j;
        if (scheduler instanceof TrampolineScheduler) {
            return subscriber;
        }
        a aVar = new a(scheduler, subscriber, this.f27146k, this.f27147l);
        Subscriber<? super T> subscriber2 = aVar.f27148j;
        subscriber2.setProducer(new OperatorObserveOn(aVar));
        subscriber2.add(aVar.f27149k);
        subscriber2.add(aVar);
        return aVar;
    }
}
