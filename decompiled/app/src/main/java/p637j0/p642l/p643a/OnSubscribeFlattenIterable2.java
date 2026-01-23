package p637j0.p642l.p643a;

import androidx.recyclerview.widget.RecyclerView;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p637j0.p641k.Func1;
import p637j0.p642l.p643a.OnSubscribeFromIterable;
import p637j0.p642l.p647e.ExceptionsUtils;
import p637j0.p642l.p647e.RxRingBuffer;
import p637j0.p642l.p647e.p648n.SpscAtomicArrayQueue;
import p637j0.p642l.p647e.p648n.SpscLinkedArrayQueue;
import p637j0.p642l.p647e.p649o.SpscArrayQueue;
import p637j0.p642l.p647e.p649o.UnsafeAccess;
import p637j0.p652o.C12774l;
import p658rx.Observable;
import p658rx.Subscriber;
import p658rx.exceptions.MissingBackpressureException;

/* JADX INFO: renamed from: j0.l.a.n, reason: use source file name */
/* JADX INFO: compiled from: OnSubscribeFlattenIterable.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OnSubscribeFlattenIterable2<T, R> implements Observable.InterfaceC13005a<R> {

    /* JADX INFO: renamed from: j */
    public final Observable<? extends T> f26916j;

    /* JADX INFO: renamed from: k */
    public final Func1<? super T, ? extends Iterable<? extends R>> f26917k;

    /* JADX INFO: renamed from: l */
    public final int f26918l;

    /* JADX INFO: renamed from: j0.l.a.n$a */
    /* JADX INFO: compiled from: OnSubscribeFlattenIterable.java */
    public static final class a<T, R> extends Subscriber<T> {

        /* JADX INFO: renamed from: j */
        public final Subscriber<? super R> f26919j;

        /* JADX INFO: renamed from: k */
        public final Func1<? super T, ? extends Iterable<? extends R>> f26920k;

        /* JADX INFO: renamed from: l */
        public final long f26921l;

        /* JADX INFO: renamed from: m */
        public final Queue<Object> f26922m;

        /* JADX INFO: renamed from: q */
        public volatile boolean f26926q;

        /* JADX INFO: renamed from: r */
        public long f26927r;

        /* JADX INFO: renamed from: s */
        public Iterator<? extends R> f26928s;

        /* JADX INFO: renamed from: n */
        public final AtomicReference<Throwable> f26923n = new AtomicReference<>();

        /* JADX INFO: renamed from: p */
        public final AtomicInteger f26925p = new AtomicInteger();

        /* JADX INFO: renamed from: o */
        public final AtomicLong f26924o = new AtomicLong();

        public a(Subscriber<? super R> subscriber, Func1<? super T, ? extends Iterable<? extends R>> func1, int i) {
            this.f26919j = subscriber;
            this.f26920k = func1;
            if (i == Integer.MAX_VALUE) {
                this.f26921l = RecyclerView.FOREVER_NS;
                this.f26922m = new SpscLinkedArrayQueue(RxRingBuffer.f27283j);
            } else {
                this.f26921l = i - (i >> 2);
                if (UnsafeAccess.m10858b()) {
                    this.f26922m = new SpscArrayQueue(i);
                } else {
                    this.f26922m = new SpscAtomicArrayQueue(i);
                }
            }
            request(i);
        }

        /* JADX INFO: renamed from: a */
        public boolean m10772a(boolean z2, boolean z3, Subscriber<?> subscriber, Queue<?> queue) {
            if (subscriber.isUnsubscribed()) {
                queue.clear();
                this.f26928s = null;
                return true;
            }
            if (!z2) {
                return false;
            }
            if (this.f26923n.get() == null) {
                if (!z3) {
                    return false;
                }
                subscriber.onCompleted();
                return true;
            }
            Throwable thM10813h = ExceptionsUtils.m10813h(this.f26923n);
            unsubscribe();
            queue.clear();
            this.f26928s = null;
            subscriber.onError(thM10813h);
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x0063  */
        /* JADX INFO: renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void m10773b() {
            int i;
            if (this.f26925p.getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super R> subscriber = this.f26919j;
            Queue<?> queue = this.f26922m;
            int iAddAndGet = 1;
            while (true) {
                Iterator<? extends R> it = this.f26928s;
                boolean z2 = false;
                if (it == null) {
                    boolean z3 = this.f26926q;
                    Object objPoll = queue.poll();
                    boolean z4 = objPoll == null;
                    if (m10772a(z3, z4, subscriber, queue)) {
                        return;
                    }
                    if (z4) {
                        i = iAddAndGet;
                    } else {
                        long j = this.f26927r + 1;
                        i = iAddAndGet;
                        if (j == this.f26921l) {
                            this.f26927r = 0L;
                            request(j);
                        } else {
                            this.f26927r = j;
                        }
                        try {
                            it = this.f26920k.call((Object) NotificationLite.m10745b(objPoll)).iterator();
                        } catch (Throwable th) {
                            C3404f.m4325o1(th);
                            onError(th);
                        }
                        if (it.hasNext()) {
                            this.f26928s = it;
                        } else {
                            iAddAndGet = i;
                        }
                    }
                    if (it != null) {
                        long j2 = this.f26924o.get();
                        long j3 = 0;
                        while (j3 != j2) {
                            if (m10772a(this.f26926q, false, subscriber, queue)) {
                                return;
                            }
                            try {
                                subscriber.onNext(it.next());
                            } catch (Throwable th2) {
                                C3404f.m4325o1(th2);
                                this.f26928s = null;
                                onError(th2);
                            }
                            if (m10772a(this.f26926q, false, subscriber, queue)) {
                                return;
                            }
                            j3++;
                            try {
                            } catch (Throwable th3) {
                                C3404f.m4325o1(th3);
                                this.f26928s = null;
                                onError(th3);
                            }
                            if (!it.hasNext()) {
                                this.f26928s = null;
                                it = null;
                                break;
                            }
                        }
                        if (j3 == j2) {
                            boolean z5 = this.f26926q;
                            if (queue.isEmpty() && it == null) {
                                z2 = true;
                            }
                            if (m10772a(z5, z2, subscriber, queue)) {
                                return;
                            }
                        }
                        if (j3 != 0) {
                            C3404f.m4250U0(this.f26924o, j3);
                        }
                        if (it == null) {
                            iAddAndGet = i;
                        }
                    }
                    iAddAndGet = this.f26925p.addAndGet(-i);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
        }

        @Override // p637j0.Observer2
        public void onCompleted() {
            this.f26926q = true;
            m10773b();
        }

        @Override // p637j0.Observer2
        public void onError(Throwable th) {
            if (!ExceptionsUtils.m10811f(this.f26923n, th)) {
                C12774l.m10863b(th);
            } else {
                this.f26926q = true;
                m10773b();
            }
        }

        @Override // p637j0.Observer2
        public void onNext(T t) {
            Queue<Object> queue = this.f26922m;
            if (t == null) {
                t = (T) NotificationLite.f26769b;
            }
            if (queue.offer(t)) {
                m10773b();
            } else {
                unsubscribe();
                onError(new MissingBackpressureException());
            }
        }
    }

    /* JADX INFO: renamed from: j0.l.a.n$b */
    /* JADX INFO: compiled from: OnSubscribeFlattenIterable.java */
    public static final class b<T, R> implements Observable.InterfaceC13005a<R> {

        /* JADX INFO: renamed from: j */
        public final T f26929j;

        /* JADX INFO: renamed from: k */
        public final Func1<? super T, ? extends Iterable<? extends R>> f26930k;

        public b(T t, Func1<? super T, ? extends Iterable<? extends R>> func1) {
            this.f26929j = t;
            this.f26930k = func1;
        }

        @Override // p658rx.functions.Action1
        public void call(Object obj) {
            Subscriber subscriber = (Subscriber) obj;
            try {
                Iterator<? extends R> it = this.f26930k.call(this.f26929j).iterator();
                if (it.hasNext()) {
                    subscriber.setProducer(new OnSubscribeFromIterable.a(subscriber, it));
                } else {
                    subscriber.onCompleted();
                }
            } catch (Throwable th) {
                C3404f.m4329p1(th, subscriber, this.f26929j);
            }
        }
    }

    public OnSubscribeFlattenIterable2(Observable<? extends T> observable, Func1<? super T, ? extends Iterable<? extends R>> func1, int i) {
        this.f26916j = observable;
        this.f26917k = func1;
        this.f26918l = i;
    }

    @Override // p658rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        a aVar = new a(subscriber, this.f26917k, this.f26918l);
        subscriber.add(aVar);
        subscriber.setProducer(new OnSubscribeFlattenIterable(this, aVar));
        this.f26916j.m11107i0(aVar);
    }
}
